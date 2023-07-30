# INF1163_Ete23_Projet1
Le projet TimeLog est un système de gestion du temps et de la paie pour les employés d'une entreprise. 
Il offre une interface en ligne de commande interactive pour effectuer différentes tâches liées au suivi du temps et à la génération de rapports.

Fonctionnalités

Rapport d'état des projets choisis : Affiche l'état de chaque projet sélectionné, y compris le nombre d'heures travaillées par discipline et le pourcentage d'avancement estimé.

Rapport d'état global : Fournit un rapport d'état global de l'ensemble des projets, indiquant les heures travaillées par discipline et le pourcentage d'avancement total.

Rapport des heures travaillées par employé : Génère un rapport des heures travaillées par un employé donné depuis une date et heure spécifiées, avec le salaire brut correspondant pour chaque projet.

Talon de paie pour un employé : Permet de générer le talon de paie pour la dernière période de paie ou pour une date de paie spécifiée.

Rapport des totaux des salaires : Affiche les totaux des salaires bruts et nets de tous les employés.

Modification des paramètres et des données : Permet à l'administrateur de modifier les paramètres du système, y compris la liste des projets, des employés et les affectations.

Gestion des disciplines : Possibilité de spécifier une liste de disciplines de travail personnalisée au démarrage du logiciel.

Persistance des données : Le système enregistre les informations sur des fichiers texte au format JSON.

Assignation d'employés aux projets : L'administrateur peut assigner des employés à des projets, avec une limite configurable du nombre de projets par employé.

Authentification admin : L'administrateur se connecte avec le nom d'utilisateur "admin" et le mot de passe "admin" (modifiable).

Gestion des comptes employés : L'administrateur peut modifier les noms d'utilisateur et les identifiants de tous les employés, y compris les siens.

Gestion des projets et des employés : L'administrateur peut modifier la liste des projets, leurs caractéristiques, la liste des employés et leurs assignations.

Authentification employé : Un employé se connecte en fournissant son nom d'utilisateur et son ID.

Signalement des heures de travail : Les employés peuvent signaler le début et la fin de leurs activités.

Demande d'heures travaillées : Les employés peuvent demander le nombre d'heures travaillées de base et supplémentaires pour une période spécifiée.

Format des sorties
Toutes les sorties du système sont au format JSON bien indenté, facilitant la lecture et l'analyse des données.

