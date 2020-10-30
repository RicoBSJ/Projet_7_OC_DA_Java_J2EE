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
    user_account_first_name,
    user_account_last_name,
    user_account_email,
    user_account_mot_de_passe
)
values
(nextval('user_account_id_seq'), 'Elon', 'Musk', 'e.musk@gmail.com', 'eM86'),
(nextval('user_account_id_seq'), 'Steve', 'Jobs', 's_jobs@gmail.com','sJ53'),
(nextval('user_account_id_seq'), 'Jack', 'Ma', 'j-ma@gmail.com', 'jM68');

CREATE SEQUENCE IF NOT EXISTS book_id_seq;

insert into book(
    id_book,
    book_quantity,
    book_quantity_loan,
    book_renewal_loan,
    book_title,
    book_year,
    id_author,
    id_category,
    id_edition
)
values
(nextval('book_id_seq'), 3, 1, false, 'La grève', '2017-03-09', 1, 1, 1),
(nextval('book_id_seq'), 3, 1, false, 'La source vive', '2018-03-01', 1, 1, 1),
(nextval('book_id_seq'), 3, 1, false, 'La Vertu d’Égoïsme', '2008-01-09', 1, 1, 1),
(nextval('book_id_seq'), 3, 1, false, 'We the Living', '2011-06-07', 1, 1, 1),
(nextval('book_id_seq'), 3, 1, false, 'Capitalism', '1986-07-15', 1, 1, 1),
(nextval('book_id_seq'), 3, 1, false, 'Le but', '2013-04-19', 2, 2, 2),
(nextval('book_id_seq'), 3, 1, false, 'Critical chain', '2019-08-15', 2, 2, 2),
(nextval('book_id_seq'), 3, 1, false, 'Evident, non ?', '2010-11-09', 2, 2, 2),
(nextval('book_id_seq'), 3, 1, false, 'Réussir n''est pas une question de chance' , '2017-05-11', 2, 2, 2),
(nextval('book_id_seq'), 3, 1, false, 'Un an pour sauver l''entreprise', '2003-02-04', 2, 2, 2),
(nextval('book_id_seq'), 3, 1, false, 'Carnets', '2010-10-01', 3, 3, 3),
(nextval('book_id_seq'), 3, 1, false, 'La première et dernière liberté', '1995-01-01', 3, 3, 3),
(nextval('book_id_seq'), 3, 1, false, 'De la nature et de l''environnement', '1994-02-03', 3, 3, 3),
(nextval('book_id_seq'), 3, 1, false, 'De la vie et de la mort', '1994-11-15', 3, 3, 3),
(nextval('book_id_seq'), 3, 1, false, 'Dernier journal', '1997-06-17', 3, 3, 3),
(nextval('book_id_seq'), 3, 1, false, 'La Flamme de l''attention', '2016-02-04', 3, 3, 3),
(nextval('book_id_seq'), 3, 1, false, 'Plénitude de la vie', '1989-10-01', 3, 3, 3),
(nextval('book_id_seq'), 3, 1, false, 'La Relation de l''homme au monde', '1995-02-23', 3, 3, 3),
(nextval('book_id_seq'), 3, 1, false, 'La Vérité et l''évènement', '1990-01-01', 3, 3, 3),
(nextval('book_id_seq'), 3, 1, false, 'Le temps aboli', '2019-09-18', 3, 3, 3);

SELECT author_first_name, author_last_name, edition_name, book_title
  FROM book
    INNER JOIN author
      ON author.id_author = book.id_author
    INNER JOIN edition
      ON edition.id_edition = book.id_edition;

INSERT INTO author (author_first_name, author_last_name) SELECT NEW.author_first_name, author_last_name FROM author WHERE NOT EXISTS (SELECT * FROM author WHERE author.author_name = NEW.author_name);
INSERT INTO edition (edition_name) SELECT NEW.edition_name FROM edition WHERE NOT EXISTS (SELECT * FROM edition WHERE edition.edition_name = SELECT NEW.edition_name);
INSERT INTO book (id_author, id_edition, book_title) SELECT author.id, edition.id, NEW.book_title FROM author, edition WHERE author_first_name = NEW.author_first_name AND edition_name = NEW edition_name);

CREATE SEQUENCE IF NOT EXISTS loan_id_seq;

insert into loan(
    id_loan,
    id_user_account
)
values
(nextval('loan_id_seq'), 1),
(nextval('loan_id_seq'), 2),
(nextval('loan_id_seq'), 3);