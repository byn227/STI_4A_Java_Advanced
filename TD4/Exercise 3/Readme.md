Créez un programme Java où deux threads essaient d’accéder à deux ressources
partagées.
Le programme doit montrer ce qu’est un deadlock et comment le prévenir en utilisant
ReentrantLock et tryLock.
• Complétez la méthode tryUse pour que chaque thread essaie de verrouiller ses deux
ressources.
• Dans le main, créez deux threads qui utilisent les ressources dans un ordre différent
pour provoquer un conflit.
• Modifiez le code pour que le deadlock soit évité grâce à tryLock.