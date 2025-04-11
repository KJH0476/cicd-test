# 빌드
FROM gradle:7.5.1-jdk17 AS build

WORKDIR /app

COPY gradlew gradlew.bat ./
COPY gradle ./gradle
COPY settings.gradle build.gradle ./

RUN chmod +x gradlew

RUN ./gradlew build -x test --no-daemon || true

COPY . .
RUN ./gradlew build --no-daemon

RUN rm -rf /app/.gradle /app/build/tmp /app/build/classes /app/build/resources

# 실행
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]