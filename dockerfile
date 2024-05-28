# Use a imagem base do JDK 21
FROM openjdk:21-jdk-slim

# Defina o diretório de trabalho no contêiner
WORKDIR /app

# Copie o jar do aplicativo para o contêiner
COPY target/gestao_residuos.jar app.jar

# Exponha a porta em que a aplicação será executada
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
