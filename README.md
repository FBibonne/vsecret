# Secret Voldemore API

 API REST pour le jeu secret Voldemore
 
## Actions disponibles dans l'API

 * [-] Créer partie :
   * [X] Contrat : `PartieApi.creerPartie`
   * [X] implémentation
   * [X] javadoc api
   * [ ] javadoc services
   * [ ] tests
 * [ ] Créer joueur :
   * [X] Contrat : `PartieApi.creerJoueur`
   * [X] implémentation
   * [X] javadoc api
   * [ ] javadoc services
   * [ ] tests
* [ ] Révéler les rôles aux mange mort
* [ ] Afficher le ministre candidat
* [ ] Lister directeurs elligibles
* [ ] Choisir directeur :
   * [X] Contrat : `ElectionApi.designerCandidatDirecteur`
* [ ]  Voter :
    * [X] Contrat : `ElectionApi.voter` 
* [ ] ministre / directeur consulte sa main : n'importe quel joueur peut consulter sa main
* [X] Défausser
* [ ] Promulguer
  * [X] Contrat : `SessionLegislativeApi.IdJoueurIncorrectException` 
* [ ] Pouvoirs
 
## Traitements sous jacents
 
 * [?] Commencer partie (lorsque tous les joueurs sont créés)
 * [X] Distribuer rôles aux joueurs
 * [ ] Commencer tour au commencement d'une partie
 * [ ] Commencer nouveau tour à la fin d'un tour
 * [ ] Désignation du ministre
 * [X] Tirer 3 proclamations et les mettre dans la main du ministre
 * [ ] Suivi élections (gestion du résultat sur le nombre d'élection du tour. Eventuellement fin de partie )
 * [ ] Suivi partie
 
## Sujets techniques

* Ajouter couche Web 
* Voir l'organisation des packages dans le model
* Externaliser les noms des champs de l'API pour rendre la sémantique du jeu paramétrable
* couche web : Identifier chaque joueur à l'origine de la requête et fournir une référence sur l'objet joueur associé dans les appels de la couche API 
 
## Etat des tests 
 
 
 
 