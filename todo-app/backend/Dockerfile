FROM openjdk:17-jdk-slim as builder

WORKDIR /app

COPY build.gradle .
COPY src ./src

RUN apt-get update && apt-get install -y wget unzip \
    && wget https://services.gradle.org/distributions/gradle-8.5-bin.zip \
    && unzip gradle-8.5-bin.zip \
    && mv gradle-8.5 /opt/gradle \
    && ln -s /opt/gradle/bin/gradle /usr/local/bin/gradle

RUN gradle build --no-daemon

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar


EXPOSE 8080

CMD ["java", "-jar", "app.jar"]