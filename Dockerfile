FROM openjdk:8
ADD build/libs/fast-food-0.0.1-SNAPSHOT.jar fast-food.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "fast-food.jar"]