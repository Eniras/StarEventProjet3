/*--Creation d'un utilisateur Partenaire--*/
insert into catalogueoffres values (1,'2021-10-14','diner croisiere')
insert into contrat (idContrat, filePath, text) values (1,'votre contrat','termes du contrat')
insert into entreprise values (1,'75012','RESTAURATION','Les delices','7','France','Rue daumesnil','088034567800012','Paris')
insert into profilutilisateur values (1,'description de mon profil restauration','restauration@user.com','LECORNEU','resources/images/restau.jpg','Sylvie','01 23 45 76 43')
insert into utilisateur values ('Partenaire',1,'partenaire','password','partenaire')
insert into partenaire values (1,1,1,1,1)
update contrat set partenaire_idUtilisateur=1 where idContrat=1;

/*--Creation d'un utilisateur Partenaire2--*/
insert into catalogueoffres values (2,'2021-11-11','seminaire')
insert into contrat (idContrat, filePath, text) values (2,'votre contrat 2','termes du contrat 2')
insert into entreprise values (2,'75010','SALLE','Au Calme','5','France','Rue Lavoisier','023033556800015','Paris')
insert into profilutilisateur values (4,'description de mon profil salle','salle@user.com','DU MOULIN','resources/images/profilSalle.jpg','Albert','04 45 45 78 43')
insert into utilisateur values ('Partenaire',4,'partenaire1','password','partenaire')
insert into partenaire values (4,2,2,2,4)
update contrat set partenaire_idUtilisateur=4 where idContrat=2;

/*--Creation d'un utilisateur Partenaire3--*/
insert into catalogueoffres values (3,'2021-12-14','O Bon Traiteur')
insert into contrat (idContrat, filePath, text) values (5,'votre contrat','termes du contrat')
insert into entreprise values (3,'75020','TRAITEUR','Bien Chez soi','24','France','Avenue Gambetta','013035956803015','Paris')
insert into profilutilisateur values (5,'description de mon profil traiteur','traiteur@user.com','BAUDOUIN','resources/images/traiteur.jpg','Jean-Marie','01 58 82 20 18')
insert into utilisateur values ('Partenaire',5,'partenaire2','password','partenaire')
insert into partenaire values (5,3,5,3,5)
update contrat set partenaire_idUtilisateur=5 where idContrat=3;

/*--Creation d'un utilisateur Admin--*/
insert into utilisateur values ('Admin',2,'admin','passwordAdmin','admin')
insert into profilutilisateur values (2,'description profil administrateur','admin@user.com','MERCIER','resources/images/portrait_girl.jpg','Sylvain','06 54 34 56 78')
insert into tache values (20, '2020-10-12','2020-10-12','Relance client Anatole AXA','TERMINE')
insert into tache values (21, '2020-11-16','2020-11-18','Contact partenaire Les Delices pour relance signature','EN_COURS')
insert into todo (idToDo , typeToDo) values (1,'RELANCE')
insert into todo (idToDo , typeToDo) values (2,'URGENT')
insert into todo (idToDo , typeToDo) values (3,'NORMAL')
insert into todo_tache values (1,20)
insert into todo_tache values (1,21)
insert into admin values (2,2,1)
update todo set admin_idUtilisateur=2 where idTodo=1;
update todo set admin_idUtilisateur=2 where idTodo=2;
update todo set admin_idUtilisateur=2 where idTodo=3;
​
/*--Creation de 12 offres pour le catalogue du partenaire 1--*/
insert into offre values (11,160,'Description Offre Croisiere','resources/images/imagesOffre/offreRestau/Restaurant7.jpg','information complementaire','Offre Croisiere',3500,1)
insert into offre values (12,150,'Description Offre Prestige','resources/images/imagesOffre/offreRestau/Restaurant8.jpg','information complementaire','Offre Prestige',2500,1)
insert into offre values (13,200,'Description Offre Cannibale','resources/images/imagesOffre/offreRestau/Restaurant11.jpg','information complementaire','Offre Cannibale',2500,1)
insert into offre values (14,250,'Description Offre Gala','resources/images/imagesOffre/offreRestau/Restaurant12.jpg','information complementaire','Offre Gala',4500,1)
insert into offre values (15,220,'Description Offre Bretonne','resources/images/imagesOffre/offreRestau/Restaurant13.jpg','information complementaire','Offre Bretonne',2500,1)
insert into offre values (16,230,'Description Offre Vegetarienne','resources/images/imagesOffre/offreRestau/restaurant14.jpg','information complementaire','Offre Vegetarienne',1500,1)

insert into offre values (42,250,'Some quick example text to build on the card''s title and make up the bulk of the cards content.','resources/images/imagesOffre/offreRestau/restaurant.jpg','information complementaire', 'Offre Fest-If',1500,1)
insert into offre values (43,150,'Description Offre Promotionnelle','resources/images/imagesOffre/offreRestau/restaurant2.jpg','information complementaire', 'Offre Promotionnelle',12000,1)
insert into offre values (44,200,'Description Offre Croisiere','resources/images/imagesOffre/offreRestau/restaurant3.jpg','information complementaire', 'Offre County',3500,1)
insert into offre values (45,230,'Description Offre Prestige','resources/images/imagesOffre/offreRestau/restaurant4.jpg','information complementaire', 'Offre Plus',2500,1)
insert into offre values (46,100,'Description Offre Classique','resources/images/imagesOffre/offreRestau/restaurant5.jpg','information complementaire', 'Offre Classic',1000,1)
insert into offre values (47,110,'Description Offre Premium','resources/images/imagesOffre/offreRestau/restaurant6.jpg','information complementaire', 'Offre Premium',2000,1)


/*--Insertion des offres dans le catalogue 1--*/
insert into catalogueoffres_offre values (1,42), (1,43), (1,44), (1,45), (1,46), (1,47), (1,11),(1,13),(1,14),(1,15),(1,16);

/*--Creation de 14 offres pour le catalogue du partenaire 2--*/
insert into offre values (7,50,'Description offre Estivale','resources/images/imagesOffre/offreSalle/seminaire.jpg','information complementaire', 'Salle Conference',8000,4)
insert into offre values (8,50,'Description Offre Promotionnelle','resources/images/imagesOffre/offreSalle/Salle1.jpg','information complementaire', 'Salle Promo  ',2000,4)
insert into offre values (9,20,'Description Offre Croisiere','resources/images/imagesOffre/offreSalle/Salle2.jpg','information complementaire', 'Salle Croisiere',5000,4)
insert into offre values (10,30,'Description Offre Prestige','resources/images/imagesOffre/offreSalle/Salle3.jpg','information complementaire', 'Salle Prestige',2500,4)

insert into offre values (17,300,'Description Offre Prestige','resources/images/imagesOffre/offreSalle/Salle4.jpg','information complementaire', 'Salle Prestige Plus',2500,4)
insert into offre values (18,250,'Description Offre Croisiere','resources/images/imagesOffre/offreSalle/salle5.jpg','information complementaire', 'Salle Croisiere Plus',2500,4)
insert into offre values (19,30,'Description Offre Promotionnelle','resources/images/imagesOffre/offreSalle/salle6.jpg','information complementaire', 'Salle Promotionnelle',2500,4)
insert into offre values (20,30,'Description Offre Estivale','resources/images/imagesOffre/offreSalle/salle7.jpg','information complementaire', 'Salle Semi',2050,4)
insert into offre values (21,30,'Description Offre Estivale','resources/images/imagesOffre/offreSalle/salle8.jpg','information complementaire', 'Salle Estivale Classic',2150,4)
insert into offre values (22,30,'Description Offre Croisiere','resources/images/imagesOffre/offreSalle/salle9.jpg','information complementaire', 'Salle Croisiere Premium',2650,4)
insert into offre values (23,30,'Description Offre Promotionnelle','resources/images/imagesOffre/offreSalle/salle10.jpg','information complementaire', 'Salle Promotionnelle Plus',2350,4)
insert into offre values (24,30,'Description Offre Prestige','resources/images/imagesOffre/offreSalle/salle11.jpg','information complementaire', 'Salle Prestige Classic',3350,4)
insert into offre values (25,30,'Description Offre Croisiere','resources/images/imagesOffre/offreSalle/salle12.jpg','information complementaire', 'Salle Croisiere Classic',4350,4)
insert into offre values (26,30,'Description Offre Estivale','resources/images/imagesOffre/offreSalle/salle13.jpg','information complementaire', 'Salle Estivale Premium',3050,4)


/*--Insertion des offres dans le catalogue 2--*/
insert into catalogueoffres_offre values (2,7), (2,8), (2,9),(2,10),(2,17),(2,18),(2,19),(2,20),(2,21),(2,22),(2,23),(2,24),(2,25),(2,26);

/*--Creation 15 offres pour le catalogue du partenaire 3--*/
insert into offre values (27,20,'Bienvenue a la table où la volaile regne en maître! Pigeonnauds, Perdrix, Canard, Poulet, Autruche tout ce qui est a plume peut vous être servi','resources/images/imagesOffre/offreTraiteur/traiteur1.jpg','Voir recettes proposees selon la saisonnalite', 'Offre Cuistots migrateurs',800,5)
insert into offre values (28,80,'Deneuville Dorian organise vos evenements prives ou professionnels, issu d une famille de charcutier, il developpe son activite dans le monde des traiteurs.','resources/images/imagesOffre/offreTraiteur/traiteur2.jpg','Passionne, il vous fera partager son experience et son amour des produits locaux.', 'Deneuville Traiteur',4000,5)
insert into offre values (29,60,'Traiteurs depuis 2005, nous organisons toutes vos receptions privees ou professionnelles','resources/images/imagesOffre/offreTraiteur/traiteur3.jpg','60 personnes maximum', 'Les Negociants',3500,5)
insert into offre values (30,120,'Karoline et Camille, reputes et reconnue par les VIP depuis quelques annees, resultat d’un immense travail et professionnalisme.','resources/images/imagesOffre/offreTraiteur/traiteur4.jpg','ouvert du mercredi au dimanche', '100 % sur-mesure',12000,5)
insert into offre values (31,100,'Traiteurs : 15 ans d experiences, Yoan vous fera partager son savoir faire pour organiser et realiser vos receptions privees ou professionnelles','resources/images/imagesOffre/offreTraiteur/traiteur5.jpg','Pour toutes demandes de degustations, nous nous deplacons a votre domicile!', 'Au faim Delice',5000,5)
insert into offre values (32,50,'Depuis 2003, La Poelee, specialisee dans les mariages originaux, organisera votre evenement prive ou professionnel selon vos attentes et vos exigences.','resources/images/imagesOffre/offreTraiteur/traiteur6.jpg','Carte change chaque mois', 'Offre Mon Chef',2500,5)

insert into offre values (33,80,'Pates, Pizzas, Brushquetta, venez savourer des plats maisons','resources/images/imagesOffre/offreTraiteur/traiteur7.jpg','Pates, Pizzas, Brushquetta, veniez savourer des plats maisons', ' Saveurs Italie',3500,5)
insert into offre values (34,120,'La catalogne vient jusque dans vos assiettes ! Tous nos plats sont issues de recettes traditionnelles','resources/images/imagesOffre/offreTraiteur/traiteur8.jpg','Nous pouvons faire des plats pour 200 personnes', 'A la Catalane',2400,5)
insert into offre values (35,70,'Vous recherchez l originalite dans vos assiettes? Prenez new diner! Nous vous faisons des burgers sous toutes les formes et saveurs','resources/images/imagesOffre/offreTraiteur/traiteur9.jpg','Possibilite de produit Halal et Casher', 'New Diner',1050,5)
insert into offre values (36,50,'Plats japonais traditionels et sushi sont a notre carte ! Sushi peuvent être fait a la minutes devant vos convives.','resources/images/imagesOffre/offreTraiteur/traiteur10.jpg','information complementaire', 'Le Nippon',3000,5)
insert into offre values (37,40,'Bienvenue en Asie, plats chinois, vietnamien et thai','resources/images/imagesOffre/offreTraiteur/traiteur11.jpg','Tous nos plats sont Halal', 'Le Soleil Levant',1000,5)
insert into offre values (38,100,'Le petit gargantua organise vos mariages ainsi que tout type d evenement avec creativite et inventivite.','resources/images/imagesOffre/offreTraiteur/traiteur12.jpg','information complementaire', 'Le  petit Gargantua',10000,5)
insert into offre values (39,80,'Recettes et plats exclusivement venant du sud de la France !','resources/images/imagesOffre/offreTraiteur/traiteur13.jpg','information complementaire', 'Offre du Soleil',2800,5)
insert into offre values (40,150,'Vous souhaitez du Yassa, Mafe ou encore du Tiep pour votre mariage ou evenement!','resources/images/imagesOffre/offreTraiteur/traiteur14.jpg','ouvert du mardi au dimanche midi et soir', 'Le Tombouchtou',4500,5)
insert into offre values (41,50,'Le panier des gourmets organise vos evenements prives ou professionnels.','resources/images/imagesOffre/offreTraiteur/traiteur15.jpg','Ils peuvent vous livrer sur le lieu de votre choix ou être a vos côtes!', 'Panier des Gourmets',3500,5)

/*--Insertion des offres dans le catalogue--*/
insert into catalogueoffres_offre values (3,27), (3,28), (3,29),(3,30),(3,31),(3,32),(3,33),(3,34),(3,35),(3,36),(3,37),(3,38),(3,39),(3,40),(3,41);

/*--Creation d'un utilisateur Client et son dashboard avec un event a 3 reservations--*/
insert into utilisateur values ('Client', 3, 'marie.dubos', 'marie', 'client')
insert into profilutilisateur values (3,'description de mon profil Marie','m.dubos@wanadoo.com','DUBOS','resources/images/PhotoNolwenn.jpg','Marie','06 32 54 33 92')
insert into dashboardclient values (1)
insert into client values (3,1,3)
/*-- Creation d'un premier evenement--*/
insert into evenement (id_evenement, statut, titreEvenement) values (256, 'EN_ATTENTE_VALIDATION', 'Anniversaire Marissa')

insert into reservation values (257, '2020-10-20', '2020-10-21', 30, 'EN_ATTENTE_VALIDATION',256,42,1)
insert into reservation values (258, '2020-10-22', '2020-10-22', 15, 'EN_COURS',256,46,1)
insert into reservation values (259, '2020-10-23', '2020-10-25', 25, 'EN_ATTENTE_VALIDATION',256,44,1)

update evenement set dashboardclient_idDashboard=1 where id_evenement=256

/*-- Creation d'un deuxieme evenement*/
insert into evenement (id_evenement, statut, titreEvenement) values (260, 'TERMINE', 'Bar Mitzvah')

insert into reservation values (261, '2020-10-01', '2020-10-01', 50, 'TERMINE',260,18,4)
insert into reservation values (262, '2020-10-02', '2020-10-02', 60, 'TERMINE',260,19,4)
insert into reservation values (263, '2020-10-03', '2020-10-03', 30, 'TERMINE',260,20,4)

update evenement set dashboardclient_idDashboard=1 where id_evenement=260

/*-- Creation d'un deuxieme evenement*/
insert into evenement (id_evenement, statut, titreEvenement) values (270, 'EN_COURS', 'Mariage Annie-Laure & Baptiste')

insert into reservation values (271, '2020-10-21', '2020-10-21', 15, 'TERMINE',270,14,1)
insert into reservation values (272, '2020-10-22', '2020-10-22', 15, 'EN_COURS',270,34,5)
insert into reservation values (273, '2020-10-23', '2020-10-23', 15, 'EN_COURS',270,23,4)

update evenement set dashboardclient_idDashboard=1 where id_evenement=270


