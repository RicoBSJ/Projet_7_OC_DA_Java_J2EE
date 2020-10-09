insert into category (
    category_id,
    name_category
)
values
(nextval('hibernate_sequence'),'roman'),
(nextval('hibernate_sequence'),'management'),
(nextval('hibernate_sequence'),'spiritualité');

insert into author(
    author_id,
    first_name,
    name_author
)
values
(1,'Ayn', 'Rand'),
(2,'Eliyahu M.', 'Goldratt'),
(3,'Jiddu', 'Krishnamurti');

insert into book(
    book_id,
    title,
    quantity,
    quantity_loan,
    renewal_loan,
    year_book,
    book_author,
    book_category
)
values
(1, 'La grève', 3, 1, false, '2017-03-09', 1, 1),
(2, 'La source vive', 3, 1, false, '2018-03-01', 1, 1),
(3, 'La Vertu d’Égoïsme', 3, 1, false, '2008-01-09', 1, 1),
(4, 'We the Living', 3, 1, false, '2011-06-07', 1, 1),
(5, 'Capitalism', 3, 1, false, '1986-07-15', 1, 1),
(6, 'Le but', 3, 1, false, '2013-04-19', 2, 2),
(7, 'Critical chain', 3, 1, false, '2019-08-15', 2, 2),
(8, 'Evident, non ?', 3, 1, false, '2010-11-09', 2, 2),
(9, 'Réussir n''est pas une question de chance' , 3, 1, false, '2017-05-11', 2, 2),
(10, 'Un an pour sauver l''entreprise', 3, 1, false, '2003-02-04', 2, 2),
(11, 'Carnets', 3, 1, false, '2010-10-01', 3, 3),
(12, 'De la liberté', 3, 1, false, '1996-03-22', 3, 3),
(13, 'De la nature et de l''environnement', 3, 1, false, '1994-02-03', 3, 3),
(14, 'De la vie et de la mort', 3, 1, false, '1994-11-15', 3, 3),
(15, 'Dernier journal', 3, 1, false, '1997-06-17', 3, 3),
(16, 'La Flamme de l''attention', 3, 1, false, '2016-02-04', 3, 3),
(17, 'Plénitude de la vie', 3, 1, false, '2003-09-08', 3, 3),
(18, 'La Relation de l''homme au monde', 3, 1, false, '1995-02-23', 3, 3),
(19, 'La Vérité et l''évènement', 3, 1, false, '2010-10-01', 3, 3),
(20, 'Le temps aboli', 3, 1, false, '2019-09-18', 3, 3);

insert into user_account(
    user_id,
    first_name,
    name_user,
    email,
    mot_de_passe
)
values
(1, 'Elon', 'Musk', 'e.musk@gmail.com', 'eM86'),
(2, 'Steve', 'Jobs', 's_jobs@gmail.com','sJ53'),
(3, 'Jack', 'Ma', 'j-ma@gmail.com', 'jM68');

insert into loan(
    loan_id,
    loan_book,
    loan_list
)
values
(nextval('hibernate_sequence'), 1, 1),
(nextval('hibernate_sequence'), 2, 2),
(nextval('hibernate_sequence'), 3, 3);