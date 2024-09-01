package us.hgmtrebing.auswendigserver.database.dev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import us.hgmtrebing.auswendigserver.database.entity.SideTypeEntity;
import us.hgmtrebing.auswendigserver.database.entity.deck.CardlessDeckEntity;
import us.hgmtrebing.auswendigserver.database.entity.UserEntity;
import us.hgmtrebing.auswendigserver.database.repository.CardlessDeckRepository;
import us.hgmtrebing.auswendigserver.database.repository.DeckSideRepository;
import us.hgmtrebing.auswendigserver.database.repository.UserRepository;

@Component
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DevDatabasePopulator implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CardlessDeckRepository cardlessDeckRepository;

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

        addDeck("German Example Sentences", harry, "German", SideTypeEntity.TEXT, "English", SideTypeEntity.TEXT);
        addDeck("Spanish Example Sentences", harry, "Spanish", SideTypeEntity.TEXT, "English", SideTypeEntity.TEXT);
        addDeck("Japanese Cooking Vocabulary", anjanette, "Japanese", SideTypeEntity.TEXT, "English", SideTypeEntity.TEXT);
    }

    private void addUser(String firstName, String lastName, String userName) {
        userRepository.saveAndFlush(UserEntity.builder()
                .firstName(firstName)
                .lastName(lastName)
                .username(userName)
                .build()
        );
    }

    private void addDeck(String deckName, UserEntity owner, String side01Name, SideTypeEntity side01Type, String side02Name, SideTypeEntity side02Type) {
        CardlessDeckEntity deck = cardlessDeckRepository.saveAndFlush(CardlessDeckEntity.builder()
                .name(deckName)
                .owner(owner)
                        .side01Name(side01Name)
                        .side01Type(side01Type)
                        .side02Name(side02Name)
                        .side02Type(side02Type)
                .build()
        );

    }
}
