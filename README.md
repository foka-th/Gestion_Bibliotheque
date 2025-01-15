# gestion-bibliotheque

## Description

Ce projet est une application de gestion de bibliothèque. Elle a pour but de permettre la gestion des membres, des livres ainsi que des emprunts dans une bibliotheque de façon automatique.

## Fonctionnalités

- **Gestion des livres** : Ajouter un livre, Lister les livres, Rechercher un livre par titre, Supprimer un livre.
- **Gestion des membres** : Inscrire un membre, Lister les membres, Supprimer un membre.
- **EGestion des emprunts et pénalités** : Enregistrer un emprunt, Enregistrer un retour, Calculer les pénalités.
- **Système de Recherche** : Rechercher un livre par titre, auteur ou catégorie.

## Technologies Utilisées

- **Base de données** : PostgreSQL
- **Langage de programmation** : SQL pour les requêtes, Java pour le reste.
- **Environnement de développement** : Intellij IDEA

## Installation 


1. Clonez le dépôt :
   ```bash
   git clone https://github.com/foka-th/Gestion_Bibliotheque

2. Accédez au répertoire du projet :
   ```bash
   cd Gestion_Bibliotheque

3. Créez la base de données :
   ```bash
   CREATE DATABASE bibliotheque;

4. Exécutez le script de création des tables et d'insertion des données :
   ```bash
   \i chemin/vers/le/fichier_de_creation.sql
   \i chemin/vers/le/fichier_d_insertion.sql

