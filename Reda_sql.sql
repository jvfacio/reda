CREATE TABLE user
(
   id_user int PRIMARY KEY NOT NULL,
   username varchar(30),
   password varchar(12),
   st_registro int,
   fh_creacion timestamp,
   fh_actualizacion timestamp
)
;
CREATE UNIQUE INDEX PRIMARY ON user(id_user)
;



CREATE TABLE customer
(
   id int NOT NULL,
   name varchar(45) NOT NULL,
   surname varchar(45) NOT NULL
)
;


