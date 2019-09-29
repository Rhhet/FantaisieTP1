--> Groupe: William MARTIN & Téri GRANDPIERRE

###########   TP1 -- FANTAISIE    ###########
#                                           #
#      Téri   GRANDPIERRE   ---- READ ME    #
#                                           #
###########        -------        ###########

Ceci correspond au projet Maven du TP1 


---Peut s'importer sous Eclipse---

Modifications vis-à-vis du sujet:

-package principal: fantaisie_TP1

-main method: App.java dans package
 fantaisie_TP1.mainJava

-ajout de packages supplémentaires
 pour organiser les différentes 
 classes, notamment par inheritance

-ajout/modification de certaines methodes

-MODIF PRINCIPALES: 
 --ajout dans les constructeurs de Pouvoir
   (classes héritées) et Arc de conditions 
   pour qu'un nouvel arc (resp. pouvoir) 
   avec un nb > 0 de flèches initiales 
   (resp. nb d'utilisations initiales > 0)
   soit directement operationnel (pas besoin
   de le regenerer alors qu'il vient d'être 
   généré)
 --Les constructeurs des classes héritant de 
   Pouvoir ont pour argument 
   nbUtilisationPouvoirInitial  et pas
   nbUtilisationPouvoir  ce qui est plus 
   logique.

(Version de ce TP sans modifications dispo
dans le .zip)