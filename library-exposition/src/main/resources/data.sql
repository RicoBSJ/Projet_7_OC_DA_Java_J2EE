insert into category (
    id,
    name
)
values
(1,'roman'),
(2,'management'),
(3,'spiritualité');

insert into author(
    id,
    first_name,
    name
)
values
(1,'Ayn', 'Rand'),
(2,'Eliyahu M.', 'Goldratt'),
(3,'Jiddu', 'Krishnamurti');

insert into book(
    id,
    quantity,
    quantity_loan,
    renewal_loan,
    title,
    year,
    author_id,
    category_id
)
values
(1, 3, 1, false, 'La grève', '2017-03-09', 1, 1),
(2, 3, 1, false, 'Le but', '2013-04-19', 2, 2),
(3, 3, 1, false, 'Carnets', '2010-10-01', 3, 3),
(4, 3, 1, false, 'De la liberté', '1996-03-22', 3, 3),
(5, 3, 1, false, 'De la nature et de l''environnement', '1994-02-03', 3, 3),
(6, 3, 1, false, 'De la vie et de la mort', '1994-11-15', 3, 3),
(7, 3, 1, false, 'Dernier journal', '1997-06-17', 3, 3),
(8, 3, 1, false, 'La Flamme de l''attention', '2016-02-04', 3, 3),
(9, 3, 1, false, 'Plénitude de la vie', '2003-09-08', 3, 3),
(10, 3, 1, false, 'La Relation de l''homme au monde', '1995-02-23', 3, 3),
(11, 3, 1, false, 'La Vérité et l''évènement', '2010-10-01', 3, 3),
(12, 3, 1, false, 'Le temps aboli', '2019-09-18', 3, 3),
(13, 3, 1, false, 'Critical chain', '2019-08-15', 2, 2),
(14, 3, 1, false, 'Evident, non ?', '2010-11-09', 2, 2),
(15, 3, 1, false, 'Réussir n''est pas une question de chance' , '2017-05-11', 2, 2),
(16, 3, 1, false, 'Un an pour sauver l''entreprise', '2003-02-04', 2, 2),
(17, 3, 1, false, 'La source vive', '2018-03-01', 1, 1),
(18, 3, 1, false, 'La Vertu d’Égoïsme', '2008-01-09', 1, 1),
(19, 3, 1, false, 'We the Living', '2011-06-07', 1, 1),
(20, 3, 1, false, 'Capitalism', '1986-07-15', 1, 1);

insert into user(
    id,
    first_name,
    name,
    email,
    mot_de_passe
)
values
(1, 'e.musk@gmail.com', 'Musk', 'eM86', 'Elon'),
(2, 's_jobs@gmail.com', 'Jobs', 'sJ53','Steve'),
(3, 'j-ma@gmail.com', 'Ma', 'jM68', 'Jack');

insert into loan(
    id
)
values
(1),
(2),
(3);