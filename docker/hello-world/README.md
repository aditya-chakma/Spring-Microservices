# <img src="./icons/docker.png" style="width:1em"/> Docker

Getting started with docker. First download and install docker from [here](https://docs.docker.com/engine/install/ubuntu/). After the download is finished launch docke desktop from system apps.

## Setting up dummy application

At first we need an application into docker. For this, let's make a dummy application called `hello-world`. Go to [spring-starter](https://start.spring.io/) web page, add Spring Web as dependency and download. Then, make a dummy REST API or if you have an applicaiton ready, that is good too.

## Making Docker image

In order for our application to run in docker, first we need a docker image. Let's make a docker image for our application. Let's say the name of our application root directory is `APP_ROOT`.

### Build the application

First, we need to build our applicaiton.

- Got to `cd APP_ROOT`. in My case `cd /home/aditya/projects/docker/hello-world`.
- Now let's compile our appliction using `mvn clean install`. this will create a `jar` file inside `target` directory.

### Create docker script

To make a docker image we will need Dockerfile. It's like a script for docer for what to do.

- Make a docker file naming `Dockerfile` inside `APP_ROOT`. Make sure the name is exactly the same.

Now write the following code inside the Dockerfile:

```docker
FROM openjdk:21-jdk
COPY target/*.jar app.jar
EXPOSE 5000
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

Let's explain one by one what it does.

- `FROM openjdk:21-jdk`. Docker will create an image from openjdk repository with the tag `21-jdk`. Because we will need jdk-21 to run our application
- `COPY target/*.jar app.jar`. It will copy the created jar file from our **host machine** to the docker image.
- `EXPOSE 5000`. This command will expose the port 5000. Our app is configured to be launched at port 5000. Put your port number as necessary
- `ENTRYPOINT ["java", "-jar", "/app.jar"]`. This eindicates what command should be run after our container is booted up.

In this process we have built the applicaton in the host machine. And supplied the jar file to the docker image. However it is recommended that, we build and run the whole application inside the docker image. Beacause different OS and machines build a jar file differently. So, the docker image will have different jar files each time.

## Build and run app inside the docker image

For this approach, we will need maven build tool inside the docker image to build our applicaiton. So, let's first take a maven repository in order to build our application. (We need to **cd** into our app root)

Edit the Dockerfile.

```docker
FROM jelastic/maven:3.9.5-openjdk-21 AS build
WORKDIR /home/app
COPY . /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:21-jdk
EXPOSE 5000
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]
```

Let's see what's happening here:

- `FROM jelastic/maven:3.9.5-openjdk-21 AS build`. We are taking the image with maven 3.9.5 and naming this process as build
- `WORKDIR /home/app`. Setting our work directory or present directory as `/home/app`.
- `COPY . /home/app`. Copy everything in our present directory to `/home/app` directory.
- `RUN mvn -f /home/app/pom.xml clean package`. Run mvn package command to build the application.

This is only the first step.

- `FROM openjdk:21-jdk`. Build the actual image with the openjdk-21 repository.
- `EXPOSE 5000`. Expose the 5000 port to our host machine through **bride netowrk**.
- `COPY --from=build /home/app/target/*.jar app.jar`. Copy the jar file to our working directory.
- `ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]`. On startup of the container run the following command.

This process will take a while to process. That is because docker will download every dependency from the pom.xml file. If we make a change to our application (not in dependency) it will still take the same amount of time.

## Optimize build using docker layers

One thing to notice here is that, we have changed our code, but dipendencies did not change. Docker caches layers, and tries to re-use them. Each line of code is a layer to docker. So, we can break down our script into multiple layers.

```docker
# static layers
FROM jelastic/maven:3.9.5-openjdk-21 AS build
WORKDIR /home/app
COPY ./pom.xml /home/app/pom.xml
COPY ./src/main/java/com/iAxis/hello_world/HelloWorldApplication.java \
/home/app/src/main/java/com/iAxis/hello_world/HelloWorldApplication.java
RUN mvn -f /home/app/pom.xml clean package

# dynamic layers
COPY . /home/app
RUN mvn -f /home/app/pom.xml clean package

# build
FROM openjdk:21-jdk
EXPOSE 5000
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]
```

One thing to notice here is we broke down the mvn packaging into two separate layers. In the first layer, we have put our main class and the pom.xml. These two do not change generally. As a result, docker won't make any change to these layers.

On the second layer, we have copied everything from our host machine to the docker image and made the actual build. But notice, since, in the first layers, the pom.xml is cached, even if the code changed during the second layer, it will make use of the pom.xml from the previous layer. Means, the second build will always use previous layers cached downloaded dependencies.

Now, in the final layer, we are running the application as previously stated.

***There is another alternative to make docker image. We can build docker image using maven. The images maven builds are more optimized than our builds. Just run the following maven command and maven will do the rest: `mvn spring-boot:build-image`*** 😄
