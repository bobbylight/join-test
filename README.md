# join-test
A playground to see what queries are created by our JPA/Hibernate/querydsl
cocktail.

Hibernate logging in `application.yml` is cranked up to show the queries
being made against our dummy h2 database.

Pay particular attention to joins made when filtering on fields defined in
child tables with a one-to-one FK relationship to the parent.

## Playing Around
```bash
./gradlew clean build
./gradlew bootRun
```
This starts a server at `localhost:8080`.  It should hot-deploy any
changes thanks to `spring-boot-devtools`.

Debug the `bootRun` task in an IDE like IntelliJ if you need to.

## REST API
```
/api/parents
```
Returns an array of all parent (top-level) entities.

```
/api/parents/:parentId
```
Returns a specific parent entity.

```
TODO: Keep going
```
