# Hometask #16
### _@Hibernate_
1. Git repo+
2. README file with rules from lecture+
3. create new maven/gradle project+
4. Create 2 POJO classes with 1 to 1 relation+
5. Create DB schema for classes from #4+
6. Add JPA + hibernate libs to project+
7. Configure POJO mapping with JPA annotations+
8. Create DAO (use EntityManager) for POJOs with 2 method: save(pojo) and find(id)+
9. Tests+
### Start script
* `docker-compose up -d`
* `mvn clean package`
* `java -jar target\lecture-16-1.0-SNAPSHOT.jar`

### Standard links
+ [Pom xml](pom.xml)
+ [Main class](src/main/java/by/itacademy/javaenterprise/goralchuk/App.java)
+ [Migration path](src/main/resources/database/migration)
+ [Database properties](src/main/resources/database/database.properties)

