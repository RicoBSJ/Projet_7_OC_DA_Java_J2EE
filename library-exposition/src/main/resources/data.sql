CREATE SEQUENCE IF NOT EXISTS author_id_seq;

insert into author(
    author_id,
    first_name,
    name_author
)
values
(setval('author_id_seq', 1),'Ayn', 'Rand'),
(nextval('author_id_seq'),'Eliyahu M.', 'Goldratt'),
(nextval('author_id_seq'),'Jiddu', 'Krishnamurti');

CREATE SEQUENCE IF NOT EXISTS category_id_seq;

insert into category (
    category_id,
    name_category
)
values
(setval('category_id_seq', 1),'roman'),
(nextval('category_id_seq'),'management'),
(nextval('category_id_seq'),'spiritualité');

CREATE SEQUENCE IF NOT EXISTS user_account_id_seq;

insert into user_account(
    user_id,
    first_name,
    name_user,
    email,
    mot_de_passe
)
values
(setval('user_account_id_seq', 1), 'Elon', 'Musk', 'e.musk@gmail.com', 'eM86'),
(nextval('user_account_id_seq'), 'Steve', 'Jobs', 's_jobs@gmail.com','sJ53'),
(nextval('user_account_id_seq'), 'Jack', 'Ma', 'j-ma@gmail.com', 'jM68');

CREATE SEQUENCE IF NOT EXISTS book_id_seq;

insert into book(
    book_id,
    quantity,
    quantity_loan,
    renewal_loan,
    title,
    year_book,
    book_author,
    book_category
)
values
(setval('book_id_seq', 1), 3, 1, false, 'La grève', '2017-03-09', 1, 1),
(nextval('book_id_seq'), 3, 1, false, 'La source vive', '2018-03-01', 1, 1),
(nextval('book_id_seq'), 3, 1, false, 'La Vertu d’Égoïsme', '2008-01-09', 1, 1),
(nextval('book_id_seq'), 3, 1, false, 'We the Living', '2011-06-07', 1, 1),
(nextval('book_id_seq'), 3, 1, false, 'Capitalism', '1986-07-15', 1, 1),
(nextval('book_id_seq'), 3, 1, false, 'Le but', '2013-04-19', 2, 2),
(nextval('book_id_seq'), 3, 1, false, 'Critical chain', '2019-08-15', 2, 2),
(nextval('book_id_seq'), 3, 1, false, 'Evident, non ?', '2010-11-09', 2, 2),
(nextval('book_id_seq'), 3, 1, false, 'Réussir n''est pas une question de chance' , '2017-05-11', 2, 2),
(nextval('book_id_seq'), 3, 1, false, 'Un an pour sauver l''entreprise', '2003-02-04', 2, 2),
(nextval('book_id_seq'), 3, 1, false, 'Carnets', '2010-10-01', 3, 3),
(nextval('book_id_seq'), 3, 1, false, 'De la liberté', '1996-03-22', 3, 3),
(nextval('book_id_seq'), 3, 1, false, 'De la nature et de l''environnement', '1994-02-03', 3, 3),
(nextval('book_id_seq'), 3, 1, false, 'De la vie et de la mort', '1994-11-15', 3, 3),
(nextval('book_id_seq'), 3, 1, false, 'Dernier journal', '1997-06-17', 3, 3),
(nextval('book_id_seq'), 3, 1, false, 'La Flamme de l''attention', '2016-02-04', 3, 3),
(nextval('book_id_seq'), 3, 1, false, 'Plénitude de la vie', '2003-09-08', 3, 3),
(nextval('book_id_seq'), 3, 1, false, 'La Relation de l''homme au monde', '1995-02-23', 3, 3),
(nextval('book_id_seq'), 3, 1, false, 'La Vérité et l''évènement', '2010-10-01', 3, 3),
(nextval('book_id_seq'), 3, 1, false, 'Le temps aboli', '2019-09-18', 3, 3);

CREATE SEQUENCE IF NOT EXISTS loan_id_seq;

insert into loan(
    loan_id,
    loan_book,
    loan_list
)
values
(setval('loan_id_seq', 1), 1, 1),
(nextval('loan_id_seq'), 2, 2),
(nextval('loan_id_seq'), 3, 3);