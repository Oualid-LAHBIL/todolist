# todolist

Petite application Todolist avec Spring Boot (Java 17 + Maven).

## Lancer
    mvn spring-boot:run

## Utiliser (dans un autre terminal)
Ajouter une tâche :

    curl -X POST localhost:8080/tasks -H "Content-Type: application/json" -d '{"title":"Apprendre Git"}'

Voir les tâches :

    curl localhost:8080/tasks

Marquer la tâche 1 comme faite :

    curl -X PUT localhost:8080/tasks/1

Supprimer la tâche 1 :

    curl -X DELETE localhost:8080/tasks/1

## Mettre sur Git
    git init
    git add .
    git commit -m "Initial commit"
    git branch -M main
    git remote add origin https://github.com/TON_USER/todolist.git
    git push -u origin main
