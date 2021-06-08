FROM adoptopenjdk/openjdk11
RUN mkdir /build-card
COPY . /build-card/
WORKDIR /build-card
RUN ./mvnw package
ENTRYPOINT ["java","-jar","-Dserver.tomcat.protocol_header=x-forwarded-proto","-Dserver.tomcat.remote_ip_header=x-forwarded-for","/build-card/target/CardService-0.0.1-SNAPSHOT.jar"]