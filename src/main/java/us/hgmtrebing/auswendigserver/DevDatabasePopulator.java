package us.hgmtrebing.auswendigserver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DevDatabasePopulator implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private DeckSideRepository deckSideRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Populating Dev Database with dummy data.");

        addUser("Harry", "Trebing", "hgmtrebing");
        addUser("Anjanette", "Trebing", "aktrebing");
        addUser("Georgiana", "Trebing", "gmtrebing");
        addUser("Evangeline", "Trebing", "eltrebing");
        addUser("James", "Crawford", "jgcrawford");

        List<UserEntity> harry = userRepository.findByUsername("hgmtrebing");
        List<UserEntity> anjanette = userRepository.findByUsername("aktrebing");

        addDeck("German Example Sentences", harry.get(0), List.of("German", "English"));
        addDeck("Spanish Example Sentences", harry.get(0), List.of("Spanish", "English", "Notes"));
        addDeck("Japanese Cooking Vocabulary", anjanette.get(0), List.of("Japanese", "English", "Photo", "Audio", "Notes"));
    }

    private void addUser(String firstName, String lastName, String userName) {
        userRepository.saveAndFlush(UserEntity.builder()
                .firstName(firstName)
                .lastName(lastName)
                .username(userName)
                .build()
        );
    }

    private void addDeck(String deckName, UserEntity owner, List<String> sides) {
        DeckEntity deck = deckRepository.saveAndFlush(DeckEntity.builder()
                .deckName(deckName)
                .owner(owner)
                .build()
        );

        for (String side : sides) {
            deckSideRepository.saveAndFlush(DeckSideEntity.builder()
                    .name(side)
                    .deck(deck)
                    .build()
            );
        }
    }
}
