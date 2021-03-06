# Atelier 2 & 3
AZZOUZ Marouane
KARA Redwan
KHIRREDINE Nassim
MALDONADO Emilio

Lien du projet Github : https://github.com/MarouaneDev/ASI-Web.git  

IDE : IntelliJ IDEA
## Composition
4 Microservices :
- UserService (/user)
- AuthService (/auth)
- CardService (/card)
- RoomService (/room)  

1 Reverse proxy apache
1 collection Postman contenant toutes les routes de l'application ```ASI-WEB.postman_collection.json```  
```RESTapp/``` est l'application de base, plus utilisée pour l'atelier 3.  
Elements réalisés : 
- Docker :
	- Containerization de chaque microservice
	- Fichier docker-compose.yml pour lancer tous les conteneurs
	- 1 Dockerfile par microservice 
- Achat/Vente de carte
- Création/Authentification d'utilisateur
- Création de tests unitaires pour chaque microservice (au moins 1 par microservice)
- Travis CI : lancement des tests à chaque push + rapport Github link au rapport Travis CI
- Mise en place de Sonarcloud + rapport Github
- Déploiement sur une instance AWS à des fins pédagogique
- Librairie (factoriser le code commun) existe mais pas implémentée

Elements non réalisés :
- Jeu de carte
- Librairie pas vraiment implémentée pour le moment
- Room partiellement fonctionnel

Implication des membres :
- 25% pour chaque membre

Lancement du projet :
- package de chaque micro service (mvn package)
- ```$ docker-compose build```
- ```$ docker-compose up```

Vidéo YouTube (qualité pas géniale, dispo en WeTransfer) :
https://youtu.be/rU867Z3aVWU
