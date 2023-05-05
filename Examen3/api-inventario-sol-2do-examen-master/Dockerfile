# Use an official Java 8 runtime as a parent image 
FROM openjdk:17-alpine 
VOLUME /tmp 
 
#Set maintainer email id 
MAINTAINER amiguel777@gmail.com  
 
# Set the working directory to /app 
WORKDIR /app 
 
# Copy the current directory contents into the container at /app 
ADD . /app 
 
# Build and create jar using maven command 
#RUN mvn package -DskipTests=true -Ddir=app 
 
# Copy the current directory contents into the container at /app 
ADD target/inventario.jar inventario.jar
 
# Make port 8092 available to the world outside this container
EXPOSE 8080
 
# Define environment variable 
ENV JAVA_OPTS="" 
 
# Run accounts-microservice.jar when the container launches 
#ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar ptreum-catalogos-microservicios.war" ]
ENTRYPOINT ["java", "-jar", "inventario.jar"]

