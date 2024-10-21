# Projet de Gestion de Restaurant et Mini-RPG

Ce projet est composé de plusieurs modules Java, chacun avec ses propres fonctionnalités. Il comprend un système de gestion de restaurant, un mini-jeu RPG, et des exemples de tests unitaires utilisant JUnit, Mockito, et Hamcrest.

## Structure du Projet

Le projet est divisé en plusieurs sous-projets :

1. **tpj2.3-mockito** : Système de gestion de restaurant
2. **tp1_mini_rpg_cicd** : Mini-jeu RPG avec intégration continue
3. **j2.1-hamcrestt** : Exemples de tests avec Hamcrest
4. **tp01-junit-start** : Introduction aux tests JUnit

## Fonctionnalités Principales

### Système de Gestion de Restaurant
- Gestion des plats (ajout, liste)
- Interface utilisateur en console
- Stockage des données en mémoire ou dans un fichier

### Mini-RPG
- Création de personnages avec nom, classe et niveau
- Tests unitaires pour les fonctionnalités de base

### Tests et Validation
- Utilisation de JUnit pour les tests unitaires
- Mockito pour les tests avec des objets simulés
- Hamcrest pour des assertions plus lisibles
- Exemples de tests paramétrés et de suites de tests

## Configuration et Exécution

Chaque sous-projet contient son propre fichier `pom.xml` pour la gestion des dépendances Maven.

mvn test
