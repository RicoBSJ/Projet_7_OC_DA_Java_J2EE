CREATE SEQUENCE IF NOT EXISTS author_id_seq;

insert into author(
    id_author,
    author_first_name,
    author_last_name
)
values
(nextval('author_id_seq'),'Ayn', 'Rand'),
(nextval('author_id_seq'),'Eliyahu M.', 'Goldratt'),
(nextval('author_id_seq'),'Jiddu', 'Krishnamurti');

CREATE SEQUENCE IF NOT EXISTS category_id_seq;

insert into category (
    id_category,
    category_name
)
values
(nextval('category_id_seq'),'roman'),
(nextval('category_id_seq'),'management'),
(nextval('category_id_seq'),'spiritualité');

CREATE SEQUENCE IF NOT EXISTS edition_id_seq;

insert into edition(
    id_edition,
    edition_name
)
values
(nextval('edition_id_seq'), 'Les Belles Lettres'),
(nextval('edition_id_seq'), 'Plon'),
(nextval('edition_id_seq'), 'Signet'),
(nextval('edition_id_seq'), 'Afnor'),
(nextval('edition_id_seq'), 'Editions du Rocher'),
(nextval('edition_id_seq'), 'Signet');

/*CREATE SEQUENCE IF NOT EXISTS user_account_id_seq;

insert into user_account(
    id_user_account,
    user_account_last_name,
    user_account_email,
    user_account_mot_de_passe
)
values
(nextval('user_account_id_seq'), 'admin', 'admin@gmail.com', 'admin'),
(nextval('user_account_id_seq'), 'Musk', 'e.musk@gmail.com', 'eM86'),
(nextval('user_account_id_seq'), 'Jobs', 's_jobs@gmail.com','sJ53'),
(nextval('user_account_id_seq'), 'Ma', 'j-ma@gmail.com', 'jM68');*/

CREATE SEQUENCE IF NOT EXISTS book_id_seq;

insert into book(
    id_book,
    book_quantity,
    book_title,
    book_year,
    id_author,
    id_category,
    id_edition
)
values
(nextval('book_id_seq'), 3, 'La grève', '2017-03-09', 1, 1, 1),
(nextval('book_id_seq'), 3, 'La source vive', '2018-03-01', 1, 1, 1),
(nextval('book_id_seq'), 3, 'La Vertu d’Égoïsme', '2008-01-09', 1, 1, 1),
(nextval('book_id_seq'), 3, 'We the Living', '2011-06-07', 1, 1, 1),
(nextval('book_id_seq'), 3, 'Capitalism', '1986-07-15', 1, 1, 1),
(nextval('book_id_seq'), 3, 'Le but', '2013-04-19', 2, 2, 2),
(nextval('book_id_seq'), 3, 'Critical chain', '2019-08-15', 2, 2, 2),
(nextval('book_id_seq'), 3, 'Evident, non ?', '2010-11-09', 2, 2, 2),
(nextval('book_id_seq'), 3, 'Réussir n''est pas une question de chance' , '2017-05-11', 2, 2, 2),
(nextval('book_id_seq'), 3, 'Un an pour sauver l''entreprise', '2003-02-04', 2, 2, 2),
(nextval('book_id_seq'), 3, 'Carnets', '2010-10-01', 3, 3, 3),
(nextval('book_id_seq'), 3, 'La première et dernière liberté', '1995-01-01', 3, 3, 3),
(nextval('book_id_seq'), 3, 'De la nature et de l''environnement', '1994-02-03', 3, 3, 3),
(nextval('book_id_seq'), 3, 'De la vie et de la mort', '1994-11-15', 3, 3, 3),
(nextval('book_id_seq'), 3, 'Dernier journal', '1997-06-17', 3, 3, 3),
(nextval('book_id_seq'), 3, 'La Flamme de l''attention', '2016-02-04', 3, 3, 3),
(nextval('book_id_seq'), 3, 'Plénitude de la vie', '1989-10-01', 3, 3, 3),
(nextval('book_id_seq'), 3, 'La Relation de l''homme au monde', '1995-02-23', 3, 3, 3),
(nextval('book_id_seq'), 3, 'La Vérité et l''évènement', '1990-01-01', 3, 3, 3),
(nextval('book_id_seq'), 3, 'Le temps aboli', '2019-09-18', 3, 3, 3);

/*CREATE SEQUENCE IF NOT EXISTS borrowing_id_seq;

insert into borrowing(
    id_borrowing,
    id_book,
    id_user_account,
    borrowing_begin_date,
    borrowing_end_date,
    book_renewal,
    user_account_borrowings
)
values
(nextval('borrowing_id_seq'), 1, 1, '2020-11-10', '2020-12-10' , false, 1 );*/

CREATE SEQUENCE IF NOT EXISTS user_role_id_seq;

insert into user_role(
    id_role,
    user_role_name
)
values
(nextval('user_role_id_seq'), 'ROLE_USER'),
(nextval('user_role_id_seq'), 'ROLE_MODERATOR'),
(nextval('user_role_id_seq'), 'ROLE_ADMIN');

/*CREATE SEQUENCE IF NOT EXISTS user_account_user_role_list_id_seq;

insert into user_account_user_role_list(
    user_account_id_user_account,
    user_role_list_id_user_role
)
values
( 1, 2),
( 2, 2),
( 3, 2);*/