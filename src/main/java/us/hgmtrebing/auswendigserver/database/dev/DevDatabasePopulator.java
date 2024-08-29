package us.hgmtrebing.auswendigserver.database.dev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import us.hgmtrebing.auswendigserver.database.entity.deck.DeckEntity;
import us.hgmtrebing.auswendigserver.database.entity.deck.CardSideTemplateEntity;
import us.hgmtrebing.auswendigserver.database.entity.UserEntity;
import us.hgmtrebing.auswendigserver.database.repository.DeckRepository;
import us.hgmtrebing.auswendigserver.database.repository.DeckSideRepository;
import us.hgmtrebing.auswendigserver.database.repository.UserRepository;

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

        UserEntity harry = userRepository.findByUsername("hgmtrebing");
        UserEntity anjanette = userRepository.findByUsername("aktrebing");

        addDeck("German Example Sentences", harry, List.of("German", "English"));
        addDeck("Spanish Example Sentences", harry, List.of("Spanish", "English", "Notes"));
        addDeck("Japanese Cooking Vocabulary", anjanette, List.of("Japanese", "English", "Photo", "Audio", "Notes"));
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
                .name(deckName)
                .owner(owner)
                .build()
        );

        for (String side : sides) {
            deckSideRepository.saveAndFlush(CardSideTemplateEntity.builder()
                    .name(side)
                    .deck(deck)
                    .build()
            );
        }
    }
}
