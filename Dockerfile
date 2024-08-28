# Select image jdk project
FROM openjdk

# Docker port (user -> container -> application)
EXPOSE 8080

# Path .jar and rename file to snapshoes
ADD /target/store-0.0.1-SNAPSHOT.jar strideX.jar

# Executed application (main docker)
ENTRYPOINT ["java", "-jar", "strideX.jar"]