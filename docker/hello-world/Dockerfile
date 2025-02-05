############### create a simple docker image by building in owr own machine ##############
#FROM openjdk:21-jdk
#COPY target/*.jar app.jar
#EXPOSE 5000
#ENTRYPOINT ["java", "-jar", "/app.jar"]

########### Copy files and build + run inside docker ############
#FROM jelastic/maven:3.9.5-openjdk-21 AS build
#WORKDIR /home/app
#COPY . /home/app
#RUN mvn -f /home/app/pom.xml clean package
#
#FROM openjdk:21-jdk
#EXPOSE 5000
#COPY --from=build /home/app/target/*.jar app.jar
#ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]

############# Break the built into multiple steps ##########
# static layers
FROM jelastic/maven:3.9.5-openjdk-21 AS build
WORKDIR /home/app
COPY ./pom.xml /home/app/pom.xml
COPY ./src/main/java/com/iAxis/hello_world/HelloWorldApplication.java /home/app/src/main/java/com/iAxis/hello_world/HelloWorldApplication.java
RUN mvn -f /home/app/pom.xml clean package

# dynamic layers
COPY . /home/app
RUN mvn -f /home/app/pom.xml clean package

# build
FROM openjdk:21-jdk
EXPOSE 5000
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]