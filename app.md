```mermaid
classDiagram
    direction BT
    class acess {
        date data_acesso
        bigint(20) user_id
        bigint(20) id
    }
    class bible_books {
        varchar(10) abbreviation
        varchar(255) author
        varchar(255) genre
        varchar(1000) historical_context
        varchar(2000) key_verses
        varchar(255) name
        int(11) number_of_chapters
        int(11) order_in_testament
        varchar(255) original_language
        varchar(255) testament
        varchar(500) theme
        bigint(20) id_book
    }
    class bible_chapters {
        int(11) chapter_number
        varchar(500) summary
        bigint(20) book_id
        bigint(20) id_chapter
    }
    class profile_book_read_progress {
        bit(1) completed
        int(11) current_chapter
        int(11) current_verse
        date end_date
        varchar(2000) notes
        double read_percentage
        date start_date
        bigint(20) book_id
        bigint(20) profile_id
        bigint(20) id
    }
    class profiles {
        longblob image_profile
        longblob imagesection
        varchar(45) nickname
        longtext summary
        bigint(20) user_id
        varchar(255) verse
        bigint(20) id_profile
    }
    class users {
        varchar(70) email
        varchar(45) fullname
        varchar(255) password
        bigint(20) id_user
    }
    class verse {
        text text
        int(11) verse_number
        bigint(20) id_chapter
        bigint(20) id_verse
    }
    acess --> users : user_id:id_user
    bible_chapters --> bible_books : book_id:id_book
    profile_book_read_progress --> bible_books : book_id:id_book
    profile_book_read_progress --> profiles : profile_id:id_profile
    profiles --> users : user_id:id_user
    verse --> bible_chapters : id_chapter
    
