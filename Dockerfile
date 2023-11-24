FROM openjdk:11

COPY target/crudapp.jar /crudapp.jar

ENTRYPOINT [ "java", "-jar", "/crudapp.jar" ]
