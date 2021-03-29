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

CREATE SEQUENCE IF NOT EXISTS user_account_id_seq;

insert into user_account(
    id_user_account,
    user_account_last_name,
    user_account_email,
    user_account_mot_de_passe
)
values
(nextval('user_account_id_seq'), 'Jobs', 'eric.aubrun@gmail.com','$2a$10$fcEe3X.fC7QxmSj7hRZJdujuZ8UavlkhewM37rcjJWdRtQt.ROJPK'),
(nextval('user_account_id_seq'), 'Musk', 'aubrun.eric@free.fr', '$2a$10$PBcySTS3eGN69mRzF6BWx.hs7aayN0FIJqLY16ZsKen4S0ikAyL9G'),
(nextval('user_account_id_seq'), 'Ma', 'aubrun.sylvie@free.fr', '$2a$10$c/Iju8gfO4wokM2nY8B6V.aJP9plWIgSJ.4xzrj27UZQ5TP9cxeeq'),
(nextval('user_account_id_seq'), 'Bezos', 'eric.aubrun@gmail.com','$2a$10$oRStZm22E3KTYZop3vBB9.sKDnzv13YYgAwHJrQ1J8/x8T.k7tQAK'),
(nextval('user_account_id_seq'), 'Knight', 'aubrun.eric@free.fr', '$2a$10$P0.aPdbYOpdtquVx6JQ01Otl43eA.uy9gmgxgOvHq193Zy3LF0VkG'),
(nextval('user_account_id_seq'), 'Zuckerberg', 'aubrun.sylvie@free.fr', '$2a$10$d65Cvz.Uf3MYTy2tu5W4Eun3Tzckcgm23yEfcZD/xPH7oTPjNy2ma'),
(nextval('user_account_id_seq'), 'William Foster', 'eric.aubrun@gmail.com','$2a$10$dG0tU0KM0GTUm4xs56UnDeKuxwkRA6DSzpI5WYoNk/.l294zERTNe'),
(nextval('user_account_id_seq'), 'Gramsci', 'aubrun.eric@free.fr', '$2a$10$vhMKl55c6q/78r3s5w9OI.fgVh366UaUPRb13LqdTr4jPzA2d7NfS'),
(nextval('user_account_id_seq'), 'Heidegger', 'aubrun.sylvie@free.fr', '$2a$10$Mm/u35cmpZzyR.Fg6ntmq.YlIFs5WPv.cEghq30FmtYwrwvPjp3ze'),
(nextval('user_account_id_seq'), 'Cohen', 'eric.aubrun@gmail.com','$2a$10$CZBukW/NfpkF/mON0f7dc.MtE95U72zWgjjyupFgDAo8d8mRN3QHi');

/*
 sJ53
 eM86
 jM68
 sB64
 pK38
 mZ84
 jWF35
 aG1891
 mH1889
 aC55
 */

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
(nextval('book_id_seq'), 4, 'La source vive', '2018-03-01', 1, 1, 1),
(nextval('book_id_seq'), 10, 'La Vertu d’Égoïsme', '2008-01-09', 1, 1, 1),
(nextval('book_id_seq'), 7, 'We the Living', '2011-06-07', 1, 1, 1),
(nextval('book_id_seq'), 8, 'Capitalism', '1986-07-15', 1, 1, 1),
(nextval('book_id_seq'), 1, 'Le but', '2013-04-19', 2, 2, 2),
(nextval('book_id_seq'), 2, 'Critical chain', '2019-08-15', 2, 2, 2),
(nextval('book_id_seq'), 5, 'Evident, non ?', '2010-11-09', 2, 2, 2),
(nextval('book_id_seq'), 9, 'Réussir n''est pas une question de chance' , '2017-05-11', 2, 2, 2),
(nextval('book_id_seq'), 3, 'Un an pour sauver l''entreprise', '2003-02-04', 2, 2, 2),
(nextval('book_id_seq'), 2, 'Carnets', '2010-10-01', 3, 3, 3),
(nextval('book_id_seq'), 6, 'La première et dernière liberté', '1995-01-01', 3, 3, 3),
(nextval('book_id_seq'), 11, 'De la nature et de l''environnement', '1994-02-03', 3, 3, 3),
(nextval('book_id_seq'), 4, 'De la vie et de la mort', '1994-11-15', 3, 3, 3),
(nextval('book_id_seq'), 7, 'Dernier journal', '1997-06-17', 3, 3, 3),
(nextval('book_id_seq'), 1, 'La Flamme de l''attention', '2016-02-04', 3, 3, 3),
(nextval('book_id_seq'), 3, 'Plénitude de la vie', '1989-10-01', 3, 3, 3),
(nextval('book_id_seq'), 5, 'La Relation de l''homme au monde', '1995-02-23', 3, 3, 3),
(nextval('book_id_seq'), 19, 'La Vérité et l''évènement', '1990-01-01', 3, 3, 3),
(nextval('book_id_seq'), 13, 'Le temps aboli', '2019-09-18', 3, 3, 3);

CREATE SEQUENCE IF NOT EXISTS borrowing_id_seq;

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
(nextval('borrowing_id_seq'), 1, 1, '2021-01-10', '2021-02-10' , false, 1),
(nextval('borrowing_id_seq'), 8, 1, '2021-01-10', '2021-02-10' , false, 1),
(nextval('borrowing_id_seq'), 2, 1, '2021-02-10', '2021-03-10' , false, 1),
(nextval('borrowing_id_seq'), 3, 2, '2021-03-10', '2021-04-10' , false, 2),
(nextval('borrowing_id_seq'), 4, 2, '2021-01-11', '2021-02-11' , false, 2),
(nextval('borrowing_id_seq'), 5, 2, '2021-02-11', '2021-03-11' , false, 2),
(nextval('borrowing_id_seq'), 6, 3, '2021-03-11', '2021-04-11' , false, 3),
(nextval('borrowing_id_seq'), 7, 3, '2021-01-12', '2021-02-12' , false, 3),
(nextval('borrowing_id_seq'), 8, 3, '2021-02-12', '2021-03-12' , false, 3),
(nextval('borrowing_id_seq'), 9, 4, '2021-03-12', '2021-04-12' , false, 4),
(nextval('borrowing_id_seq'), 1, 4, '2021-01-10', '2021-02-10' , false, 4),
(nextval('borrowing_id_seq'), 8, 4, '2021-01-10', '2021-02-10' , false, 4),
(nextval('borrowing_id_seq'), 2, 5, '2021-02-10', '2021-03-10' , false, 5),
(nextval('borrowing_id_seq'), 3, 5, '2021-03-10', '2021-04-10' , false, 5),
(nextval('borrowing_id_seq'), 4, 5, '2021-01-11', '2021-02-11' , false, 5),
(nextval('borrowing_id_seq'), 5, 6, '2021-02-11', '2021-03-11' , false, 6),
(nextval('borrowing_id_seq'), 6, 6, '2021-03-11', '2021-04-11' , false, 6),
(nextval('borrowing_id_seq'), 7, 6, '2021-01-12', '2021-02-12' , false, 6),
(nextval('borrowing_id_seq'), 8, 7, '2021-02-12', '2021-03-12' , false, 7),
(nextval('borrowing_id_seq'), 9, 7, '2021-03-12', '2021-04-12' , false, 7),
(nextval('borrowing_id_seq'), 1, 7, '2021-01-10', '2021-02-10' , false, 7),
(nextval('borrowing_id_seq'), 8, 8, '2021-01-10', '2021-02-10' , false, 8),
(nextval('borrowing_id_seq'), 2, 8, '2021-02-10', '2021-03-10' , false, 8),
(nextval('borrowing_id_seq'), 3, 8, '2021-03-10', '2021-04-10' , false, 8),
(nextval('borrowing_id_seq'), 4, 9, '2021-01-11', '2021-02-11' , false, 9),
(nextval('borrowing_id_seq'), 5, 9, '2021-02-11', '2021-03-11' , false, 9),
(nextval('borrowing_id_seq'), 6, 9, '2021-03-11', '2021-04-11' , false, 9),
(nextval('borrowing_id_seq'), 7, 10, '2021-01-12', '2021-02-12' , false, 10),
(nextval('borrowing_id_seq'), 8, 10, '2021-02-12', '2021-03-12' , false, 10),
(nextval('borrowing_id_seq'), 9, 10, '2021-03-12', '2021-04-12' , false, 10);

CREATE SEQUENCE IF NOT EXISTS user_role_id_seq;

insert into user_role(
    id_role,
    user_role_name
)
values
(nextval('user_role_id_seq'), 'ROLE_USER'),
(nextval('user_role_id_seq'), 'ROLE_MODERATOR'),
(nextval('user_role_id_seq'), 'ROLE_ADMIN');

CREATE SEQUENCE IF NOT EXISTS user_roles_id_seq;

insert into user_roles(
    user_id,
    role_id
)
values
(1, 3),
(2, 2),
(3, 1),
(4, 3),
(5, 2),
(6, 1),
(7, 3),
(8, 2),
(9, 1),
(10, 3);