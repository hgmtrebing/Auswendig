# Planning

## 2024-09-05 : 12:48:22

Additional Card Refactor:
    - Question
    - Answer
    - Hint
    - Note
    - Last Success
    - Last Failure
    - Success Count
    - Failure Count
    - Tags

- I don't think I even need dual-sided cards. Single cards are sufficient.
- This does mean that I need very powerful importing ability, and maybe a configurable datasource ability.



## 2024-09-01 : 11:35:01

Major refactor:

I think my app can really support two-sided decks as the base case and add:
    - Support for complex imports
    - Later, add support for storing tabular data and cutting questions from it

For decks, this means removing the Card Template list, and adding:
    - side01Name
    - side01Description
    - side01Type
    - side02Name
    - side02Description
    - side02Type
    - side01GlobalHint
    - side01GlobalNote
    - side02GlobalHint
    - side02GlobalNote

For cards, this means:
    - side01Value
    - side01Hint
    - side01Note
    - side02Value
    - side02Hint
    - side02Note
    - side01LastSuccessDate
    - side01LastFailureDate
    - side01SuccessCount
    - side01FailureCount

## 2024-09-01 : 10:53:53

The major advantage of Multisided Cards is:
    - Ease of import
    - Ease of export
    - Custom base to create many cards from
    - Easy to customize notes and hints
    - Data could actually live in the Flashcard app

However, mulitsided cards come with a number of disadvantages:
    - Large Many-To-Many Table to retrieve data
    - What happens when the Deck Template is changed - a side gets added or removed? Large database operation to update all cards.
    - Questions now live in a separate table from Cards

The advantage of dual-sided cards is:
    - Performance - the size of everything can be easily known in advance. Querying is much easier.
    - Covers a majority of use cases

The disadvantages of dual-sided cards is:
    - User has to perform work in advance to chop up data for importing
    - Complex, multi-columned data can no longer live in the app

## 2024-08-31 : 22:46:48

Well, I have reached a point where I need to decide how to manage multi-sided cards.

I should consider a couple of things:
    - No matter what, every Card must have at least two sides.
    - Multisided cards almost certainly will lead to large many-to-many table(s) with an accompanying performance hit.
        - It's better to have sides statically allocated, if possible
    - During quizzes, it may be useful to have multisided questions, multisided answers, hints, and notes.
        - However, the simple base case is just to have a question side, answer side, and hints side.
    - With multisided cards, it's complicated to determine how to manage when:
        - A new side is added to the Deck Template
        - An existing side is removed from the Template
    - I also need to think about whether to limit the number of sides a Deck has

I like how Anki does sides - It allows the user to embed card data in a document.
But, doing so starts to obscure what sides are being tested.

Each side should have a name, a description, and a type.

Do I really need multisided Cards though? Every question is fundamentally two-sided.
If I support multideck quizzes, it negates much of the need for multisided cards.

English
Pinyin
Simplified Chinese
Audio

English <-> Pinyin
    English


## 2024-08-25 : 19:31:00

I think I've gone as far as I can without really planning everything out.

First, I envision supporting several question types:
    - Guess and Check
    - Multiple Choice
    - Text Input

I want questions to be selected on:
    - Cumulative Success Ratio
    - Time Since Last Failure
    - Time Since Last Question
    - Total Questions
    - Round Robin
    - Completely Random

I also want each question to have optional hints, which consist of any other sides.

I want Quizzes to support multiple decks, multiple question types, and multiple selection criteria

This raises some questions:
    - At what level should I track pass/fail?
        - At Question,Answer,Type pairing 
        - At Question<->Answer pairing
    - How should I treat mispellings in Text Input?
    - How should I handle adding or removing Sides to a Deck Card Template?
    - How 

Question Table
    question_id
    fk_question_template_id
    fk_card_id
    total_success
    total_failure
    last_success
    last_failure

Question Template Table (tbl_question_template)
    question_template_id
    question_template_question_side
    question_template_answer_side
    fk_question_type
    fk_deck_id

Quiz Table (tbl_quiz)
    pk_quiz_id
    fk_owner_user_id
    name
    description
    last_quiz_date
    create_date
    last_modified_date

Quiz Question Template Table (tbl_quiz_question_template)
    fk_quiz_id
    fk_question_template_id

Deck Table (tbl_deck)
    pk_deck_id
    name
    description
    fk_owner_user_id

Deck Card Template Table (tbl_deck_card_template)
    fk_deck_id
    pk_template_side_id
    name
    type

User Table (tbl_user)
    pk_user_id
    first_name
    last_name
    username

Card Table (tbl_card)
    pk_card_id
    fk_deck_id

Card Side Table (tbl_card_side)
    pk_card_side_id
    fk_card_id
    fk_template_side_id
    value

Question Picking Algorithm
    
    Question Picking Algorithm should be customizeable, based on the following:
        - Minimum Success Count
            - Prioritizes cards that are below a minimum success threshold
        - Last Success Date
            - Prioritizes cards with a more distant last success date
        - Failed Recently
            - Prioritizes cards with a more recent fail date
        - Minimum Success Ratio
            - Prioritizes cards that have a Success / Failure Ratio below a certain level
        - Maximum Success Ratio
            - Deprioritizes cards that are over a Success / Failure Ratio
            - This may not be necessary