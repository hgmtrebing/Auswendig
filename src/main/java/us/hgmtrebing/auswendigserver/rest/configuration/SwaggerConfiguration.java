package us.hgmtrebing.auswendigserver.rest.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI auswendigSwaggerApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Auswendig API")
                        .version("1.0")
                        .description("RESTful API for Auswendig Flash Card Application.")
                        .contact(new Contact()
                                .email("hgmtrebing@outlook.com")
                                .name("Harry Trebing")
                        )
                )
                ;
    }
}
