
As part of an educational project at Javarush University (https://javarush.com/university)

It is necessary to perform versatile tasks in the finished project.

---

### Use [startComposeClear.sh](scripts/startComposeClear.sh) for start docker-compose with db & nginx
### Use [stopComposeAndDeleteAppImage.sh](scripts/stopComposeAndDeleteAppImage.sh) for stop docker-compose and remove all data

---

## Completed Tasks

1. ***Task***: Familiarize oneself with the project structure (onboarding).
    - ***Done***:
        - Studied the project structure.
        - Identified the main modules and their connections.
        - Each module is an isolated part of the application to reduce dependencies between them.

---

2. ***Task***: Remove the social networks: vk, yandex.
    - ***Done***:
        - Removed the handler classes for interactions with VK and Yandex.
        - Created and applied a Liquibase migration to remove references to VK and Yandex from the database.

---

3. ***Task***: Move sensitive information to a separate properties file.
    - ***Done***:
        - Sensitive information has been moved to [application-secrets.yaml](src/main/resources/application-secrets.yaml).
        - application-secrets.yaml is imported into the main file.
        - Implemented a system to read properties from environment variables at server start-up.
        - Default properties have been set for convenience during the current review and check.

---

4. ***Task***: Refactor tests to use TestContainers during testing.
    - ***Done***:
        - Refactored tests to use TestContainers.

---

5. ***Task***: Write tests for all the public methods of the ProfileRestController.
    - ***Done***:
        - Wrote tests to validate both successful and unsuccessful scenarios.

---

6. ***Task***: Refactor the method com.javarush.jira.bugtracking.attachment.FileUtil#upload to use a modern approach for file system handling.
    - ***Done***:
        - Refactored the FileUtil#upload method (now using MultipartFile, Path, Files).

---

7. ***Task***: Introduce a new feature: add tags to tasks (REST API + service implementation).
    - ***Done***:
        - Added the addTags method in TaskController.
        - Introduced the addTagsToTask method in TaskService.

---

8. ***Task***: Calculate the time a task has been in work and testing.
    - ***Done***:
        - Added two methods to the service to compute the time in work and testing.
        - Introduced the getStatusChangeTime method in ActivityRepository.
        - Created and applied a Liquibase migration to add relevant rows in the ACTIVITY table.
        - EXTRA: added tests - [TaskServiceTest.java](src/test/java/com/javarush/jira/bugtracking/task/TaskServiceTest.java).

---

9. ***Task***: Write a Dockerfile for the main server.
    - ***Done***:
        - Drafted the [Dockerfile](Dockerfile) for the main server.

---

10. ***Task***: Draft a docker-compose file to initiate the server container together with the database and nginx.
    - ***Done***:
        - Wrote the [docker-compose.yml](docker-compose.yml) file.
        - Server, database, and nginx are initiated in linked containers using two internal networks.
        - The [docker-compose.env](config/docker-compose.env) file is utilized.
        - EXTRA: [bash script](scripts/startComposeClear.sh) for initiating docker-compose.
        - EXTRA: [bash script](scripts/startComposeClear.sh) utilizes [HealthCheck](src/main/java/com/javarush/jira/util/HealthCheck.java) to wait for the app to start and automatically pops up a browser window once nginx is ready.

---

11. ***Task***: Add localization for a minimum of two languages for email templates (mails) and the index.html landing page.
    - ***Done***:
        - Localization support for email templates and the landing page was added, including all "Thymeleaf fragments".
        - Implemented support for three languages.

---

## [REST API](http://localhost:8080/doc)

```
  url: jdbc:postgresql://localhost:2345/jira
  username: jira
  password: JiraRush
```