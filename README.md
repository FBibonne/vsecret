# Secret Voldemore API

 API REST pour le jeu secret Voldemore
 
## Actions disponibles dans l'API

 * [ ] Créer partie :
   * [X] Contrat : `PartieApi.creerPartie`
 * [ ] Créer joueur :
   * [X] Contrat : `PartieApi.creerJoueur`
 * [X] Choix du ministre :
   * A priori automatique au début du tour : à déplacer dans traitements sous jacents
 * [ ] Choisir directeur :
   * [X] Contrat : `ElectionApi.designerCandidatDirecteur`
 * [ ]  Voter :
   * [X] Contrat : `ElectionApi.voter` 
 * [X] Défausser
 * [ ] Promulguer
   * [X] Contrat : `SessionLegislativeApi.IdJoueurIncorrectException` 
 * [ ] Pouvoirs
 
## Traitements sous jacents
 
 * [ ] Commencer partie (lorsque tous les joueurs sont créés)
 * [ ] Commencer tour
 * [X] Tirer 3 proclamations
 * [ ] Suivi élections (gestion du résultat sur le nombre d'élection du tour. Eventuellement fin de partie )
 * [ ] Suivi partie
 * [ ] sélection du candidat ministre
 
## Sujets techniques

* Ajouter couche Web 
* Voir l'organisation des packages dans le model
* Externaliser les noms des champs de l'API pour rendre la sémantique du jeu paramétrable
 
## Etat des tests 
 
 
 
 