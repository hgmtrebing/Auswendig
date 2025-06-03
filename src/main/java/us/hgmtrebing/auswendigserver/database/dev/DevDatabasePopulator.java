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
import us.hgmtrebing.auswendigserver.rest.mapping.UserMapper;
import us.hgmtrebing.auswendigserver.rest.schemas.UserRequestSchema;

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

    @Autowired
    private UserMapper userMapper;

    @Override
    public void run(String... args) throws Exception {
        log.info("Populating Dev Database with dummy data.");

        addUser("Harry", "Trebing", "hgmtrebing", "test", "test@test.com");
        addUser("Anjanette", "Trebing", "aktrebing", "test", "test@test.com");
        addUser("Georgiana", "Trebing", "gmtrebing", "test", "test@test.com");
        addUser("Evangeline", "Trebing", "eltrebing", "test", "test@test.com");
        addUser("James", "Crawford", "jgcrawford", "test", "test@test.com");

        UserEntity harry = userRepository.findByUsername("hgmtrebing");
        UserEntity anjanette = userRepository.findByUsername("aktrebing");

        addDeck("German->English Sentences", "German to English Example Sentences", harry, "English", "German", "Note", "Hint" );
        addDeck("English->Spanish Sentences", "Spanish to English Example Sentences", harry, "English", "Spanish", "Note", "Hint" );
        addDeck("English->Mandarin Sentences", "Mandarin to English Example Sentences", harry, "English", "Mandarin", "Note", "Hint" );
        addDeck("Japanese Cooking Vocabulary", "Cooking Vocabulary for Japanese", harry, "German", "Japanese", "Note", "Hint" );

    }

    private void addUser(String firstName, String lastName, String userName, String password, String email) {
        UserRequestSchema schema = UserRequestSchema.builder()
                .firstName(firstName)
                .lastName(lastName)
                .username(userName)
                .password(password)
                .email(email)
                .build();

        userRepository.saveAndFlush(userMapper.convert(schema));
    }

    private void addDeck(String deckName, String description, UserEntity owner, String questionSideName, String answerSideName, String globalNote, String globalHint) {
        CardlessDeckEntity deck = cardlessDeckRepository.saveAndFlush(CardlessDeckEntity.builder()
                .name(deckName)
                .description(description)
                .owner(owner)
                .questionSideName(questionSideName)
                .answerSideName(answerSideName)
                .globalNote(globalNote)
                .globalHint(globalHint)
                .build()
        );
    }
}
