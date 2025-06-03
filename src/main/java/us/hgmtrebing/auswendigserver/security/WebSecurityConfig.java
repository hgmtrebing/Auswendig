package us.hgmtrebing.auswendigserver.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import us.hgmtrebing.auswendigserver.database.entity.UserEntity;
import us.hgmtrebing.auswendigserver.database.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .authorizeHttpRequests(auths -> {

                    // Per documentation, matches are considered in order, so more specific matches should be first
                    auths.requestMatchers("/api/v1/user/add-new-user").permitAll();
                    auths.anyRequest().authenticated();

                })
                .formLogin(formLogin -> {
                    formLogin.permitAll();
                })
                .logout(logout -> logout.permitAll())
                .build();
    }

    /**
     * This is used to provide the `UserDetailsService` bean that is used by Spring Session to validate
     * username/password combinations.
     * @param userRepository
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new UserDetailsService() {

            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                UserEntity user = userRepository.findByUsername(username);
                if (user == null) {
                    throw new UsernameNotFoundException("Could not find user: " + username);
                }

                return user;
            }
        };
    }
}
