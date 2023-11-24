FROM openjdk:11

COPY ./target/grupo01_HIA_TPFinal-0.0.1-SNAPSHOT.jar /

ENTRYPOINT [ "java", "-jar", "/grupo01_HIA_TPFinal-0.0.1-SNAPSHOT.jar" ]
