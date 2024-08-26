# Planning

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