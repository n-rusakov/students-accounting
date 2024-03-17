## students-accounting
#### Practical work on Spring Boot, students accounting shell application
***
Run: mvnw spring-boot:run


#### Available commands:
+ **add --f "first name" --l "last name" --a "age"** : add student to list
+ **print (or short "p")** : print list of  students
+ **clear (or short "c")** : clear list of students
+ **delete (or short "d") --id "id"** : delete student with specified id
+ **exit** : exit from application

#### Available configuration:
**students-accounting.auto-create-enabled** : if true, init students list of several records, false by default

User Dockerfile to build image, **STD_ACS_AUTO_CREATE** path environment to enable auto create

