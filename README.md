# Développez le nouveau système d’information de la bibliothèque d’une grande ville

## Contexte

Vous travaillez au sein de la Direction du Système d’Information (DSI)  de la mairie d’une grande ville, sous la direction de Patricia, la responsable du service. La DSI est en charge de tous les traitements numériques pour la mairie et les structures qui lui sont rattachées, comme la gestion du site web de la ville par exemple. À ce titre, Patricia est contactée par le service culturel de la ville qui souhaite moderniser la gestion de ses bibliothèques. John, architecte logiciel, sera chargé de la validation technique du projet.

Patricia vous transfère son dernier échange avec Luc, le directeur du service culturel :

## Objet : Récapitulatif de notre discussion

    Re-bonjour Patricia,

Suite à notre réunion de ce matin, tu trouveras ci-dessous le récapitulatif de nos attentes concernant le projet d’outils numériques à destination des bibliothèques de notre très chère ville.

Je reste à dispo si tu as des questions,

Bien à toi,

Luc

Directeur du service culturel

----

Nous souhaitons confier à la DSI la création d’un ensemble d’outils numériques pour les différents acteurs des bibliothèques de la ville. En voici la liste :

Un site web et une application mobile pour les usagers de la bibliothèque.
Un logiciel pour le personnel des bibliothèques.
Un logiciel pour des traitements automatisés (mails de relance).
Le site web permettra aux usagers de suivre les prêts de leurs ouvrages. Il pourront :

Rechercher des ouvrages et voir le nombre d’exemplaires disponibles.
Consulter leurs prêts en cours. Les prêts sont pour une période de 4 semaines.
Prolonger un prêt en cours. Le prêt d’un ouvrage n’est prolongeable qu’une seule fois. La prolongation ajoute une nouvelle période de prêt (4 semaines) à la période initiale.
Nous attendons également une application mobile iOS et Android qui fournira les mêmes services que le site web.

Le logiciel pour le personnel des bibliothèques permettra notamment de gérer les emprunts et les livres rendus.

Le logiciel pour les traitements automatisés, que tu as désigné par le terme “batch” il me semble, permettra d’envoyer des mails de relance aux usagers n’ayant pas rendu les livres en fin de période de prêt. L’envoi est automatique à la fréquence d’un par jour.

Vous êtes missionné pour la réalisation des premiers produits !

Patricia vous fournit le plan de travail suivant tout en vous précisant que vous serez chargé uniquement de la Release 1.0 :

## Release 1.0

    API Web

    Application web

    Batch

## Release 2.0

    Logiciel pour le personnel

## Release 3.0

    Application mobile

Vous recevez également le compte rendu de la réunion pour la conception technique du projet :

## Contexte : Projet bibliothèque

    Présents : 

Patricia, responsable du service de DSI,
John, architecte logiciel,
Linda, lead tech
Objet : Choix de la solution technique pour le projet “Bibliothèque”.

    Choix techniques retenus :

API web en REST ou en SOAP (à voir avec le développeur) : les clients (site web, batch, logiciel pour les personnels, application mobile) communiqueront à travers une API web. Factorisation de la logique métier.
Application web avec un framework MVC (Spring MVC, Struts, …)
Packaging avec Maven
Pour l’application mobile et le logiciel des personnels, une autre réunion sera organisée.

À noter : Dès la release 1.0, les actions de création d’un prêt et retour d’un prêt seront implémentés même si elles ne seront utilisés par le logiciel pour les personnels uniquement à la release 2.0.

Vous trouvez également cette note sur votre bureau, vous reconnaissez l’écriture de Patricia :

Ajoute bien un fichier readme.md à la racine de ton repository pour expliquer comment déployer l’application (cela servira de base pour rédiger la documentation par la suite).
NB : n'oublie pas de respecter les bonnes pratiques de développement ;)

    - Patricia

Vous avez tous les éléments en main pour vous lancer !

## Livrables attendus
Vous livrerez, sur GitHub ou GitLab (dans un seul dépôt Git dédié) :

Le code source des composants à développer de la Release 1.
Les scripts SQL de création de la base de données avec un jeu de données de démonstration.
Une documentation succincte (un fichier README.md  suffit) expliquant comment déployer l'application.
Vous donnerez un accès en lecture à votre/vos dépôt(s) Git à votre mentor et au mentor qui vous fera passer la soutenance.

## Soutenance
Avant la soutenance
Le mentor doit être en mesure de déployer le système d’information chez lui pour le tester avant la soutenance.

Déroulement de la soutenance
Il vous est demandé de vous mettre en situation réelle : en effet, il s'agit d'une réunion professionnelle. Vous vous adresserez à John, l’architecte logiciel de la DSIO, qui doit valider votre travail sur le projet.‌

## La soutenance, d’une durée d’environ 25-30 minutes, se déroulera comme ceci :

    Partie 1 – 20-25 minutes : Simulation d'une réunion professionnelle
L’évaluateur jouera le rôle de l’architecte logiciel de votre entreprise.
[~ 5 minutes]  Vous lui ferez une démonstration rapide de votre application web et du batch
[~ 5 minutes] Vous lui présenterez la solution technique : architecture et technologies utilisées
[10 minutes] Vous présenterez l’implémentation de l’architecture mise en oeuvre et les points importants du développement.
    Partie 2 – 5-10 minutes : Retour sur la soutenance
L’évaluateur pourra vous demander d’approfondir certains aspects ou vous questionner sur vos livrables.
L’évaluateur vous fera un debrief sur votre prestation en soutenance.

    Référentiel d'évaluation
Concevoir une application web avec une approche par composants

L’application web est consommatrice d’une API web.
Un framework MVC est utilisé.
Le scope fonctionnel est respecté.
Créer une API web avec un web service SOAP ou un microservice REST

La logique métier est implémentée au sein d’un composant qui expose une API web.
Interagir avec des composants externes

L’API web communique avec la base de données.
Sélectionner les langages de programmation adaptés pour le développement de l’application

Différents frameworks sont mis en oeuvre en fonction des choix techniques.
Les choix techniques sont justifiés à l’oral.
Respecter les bonnes pratiques de développement en vigueur

Le packaging est géré avec Apache Maven.
Chaque composant a un cycle de développement qui lui est propre.
Une architecture n-tiers est mise en oeuvre.
Le patron de conception ‘Inversion de contrôle’ est mis en oeuvre.

## Compétences évaluées
Créer une API web avec un web service SOAP ou un microservice REST
Concevoir une application web avec une approche par composants
Respecter les bonnes pratiques de développement en vigueur
Sélectionner les langages de programmation adaptés pour le développement de l’application
Interagir avec des composants externes
