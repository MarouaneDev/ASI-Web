FROM adoptopenjdk/openjdk11
RUN mkdir /build-auth
COPY . /build-auth/
WORKDIR /build-auth
#RUN ./mvnw package
ENTRYPOINT ["java","-jar","-Dserver.tomcat.protocol_header=x-forwarded-proto","-Dserver.tomcat.remote_ip_header=x-forwarded-for","/build-auth/target/AuthService-0.0.1-SNAPSHOT.jar"]