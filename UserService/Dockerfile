FROM adoptopenjdk/openjdk11
RUN mkdir /build-user
COPY . /build-user/
WORKDIR /build-user
#RUN ./mvnw package
ENTRYPOINT ["java","-jar","-Dserver.tomcat.protocol_header=x-forwarded-proto","-Dserver.tomcat.remote_ip_header=x-forwarded-for","/build-user/target/UserService-0.0.1-SNAPSHOT.jar"]