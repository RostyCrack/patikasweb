FROM openjdk
COPY target/proyecto_arqui-0.0.1-SNAPSHOT.jar proyecto_arqui-0.0.1-SNAPSHOT.jar
VOLUME /log
EXPOSE 8080/tcp
ENTRYPOINT [ "java", "-jar", "proyecto_arqui-0.0.1-SNAPSHOT.jar"]