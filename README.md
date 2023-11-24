# TP Producer et API RabbitMQ

Ce projet est un TP avec une api rest qui permet de creer un utilisateur avec prenom et email. Le tout est stocker dans une queue rabbitMQ


## Prérequis

1- Clonner le projet : https://github.com/juva-quentin/TP-AMQP.git
2- Clonner le projet du consumer pour que le projet soit complet : https://github.com/juva-quentin/TpRabbitConsumer.git
3- Docker et docker compose doivent être installé sur votre machine

## Configuration du réseau docker

Avant de lancer les conteneurs, un réseau docker nommé 'mon_reseau' doit être créer pour permettrela communication entre les conteneurs.
Exécutez la commande suivante pour créer le réseau :

```shell
docker network create mon_reseau
```

## Demarrage des services

Pour demarrer les services, dans la racine du projet, lancer cette commande :
```shell
docker compose up --build
```

Pour utiliser l'api vous pouvez via postman envoyer une requette POST (localhost:8080/users/register) de ce type : 
body : 
{
"username": String,
"email": String
}