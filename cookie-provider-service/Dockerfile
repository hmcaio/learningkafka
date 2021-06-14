# Stage 1
FROM openjdk:8-jdk-alpine as builder
ARG JAR_FILE=target/cookie-producer.jar
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
#RUN mvn dependency:go-offline  # Trying to avoid install downloading all dependencies every time the image is built
COPY src src

RUN ./mvnw install -DskipTests
RUN java -Djarmode=layertools -jar ${JAR_FILE} extract

# Stage 2
FROM openjdk:8-jdk-alpine
ARG BASE_DIR=/workspace/app

COPY --from=builder ${BASE_DIR}/dependencies/ ./
COPY --from=builder ${BASE_DIR}/snapshot-dependencies/ ./
COPY --from=builder ${BASE_DIR}/spring-boot-loader/ ./
COPY --from=builder ${BASE_DIR}/application/ ./

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]

# docker image build --tag cookie-producer-service .
# docker container run -it --rm -p 8080:8080 --network learningkafka_default cookie-producer-service
