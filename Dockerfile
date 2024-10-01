# Usando uma imagem mais recente do Maven e JDK 11
FROM maven:3.8.4-jdk-8 AS build

# Copiando o arquivo pom.xml e a pasta src para o diretório de build
COPY pom.xml /app/
COPY src /app/src

# Definindo o diretório de trabalho
WORKDIR /app

# Rodando o Maven para instalar as dependências e compilar o projeto
RUN mvn clean install -DskipTests

# Usando uma imagem mais leve do OpenJDK para rodar o jar
FROM openjdk:8-jre-slim

# Copiando o arquivo jar gerado pelo build para o container final
COPY --from=build /app/target/docker-manager-0.0.1-SNAPSHOT.jar /app/app.jar

# Definindo o diretório de trabalho
WORKDIR /app

# Expondo a porta que a aplicação vai usar
EXPOSE 8080

# Definindo o comando de execução da aplicação
CMD ["java", "-jar", "app.jar"]