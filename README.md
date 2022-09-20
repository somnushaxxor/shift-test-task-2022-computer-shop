# SHIFT TEST TASK 2022: Computer Shop

# Building and running:
Run the application by using ./gradlew bootRun from project root folder.
Alternatively, you can build the JAR file by using ./gradlew build and then run the JAR file, as follows:
java -jar build/libs/computer-shop-0.0.1-SNAPSHOT-plain.jar

# Configuring:
Configuration of the spring boot application could be done by managing the src/main/resources/application.yaml file.
For example, it is possible to change the username and password for H2 database.
To populate some data that is needed on application startup (predefined pc form factors and laptop sizes)
you should write SQL queries in src/main/resources/data.sql.