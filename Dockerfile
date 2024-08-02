#Usa uma imagem externa de um JDK de acordo com a necessidade do projeto
FROM openjdk

#Porta que a aplicação estara exposta para o container (user -> container -> application)
EXPOSE 8080

#Path do .jar and rename file to snapshoes
ADD /target/store-0.0.1-SNAPSHOT.jar snapshoes.jar

#Comando para subir a aplicacao
ENTRYPOINT ["java", "-jar", "snapshoes.jar"]