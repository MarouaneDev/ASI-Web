FROM adoptopenjdk/openjdk11
RUN mkdir /build-room
COPY . /build-room/
WORKDIR /build-room
#RUN ./mvnw package
ENTRYPOINT ["java","-jar","-Dserver.tomcat.protocol_header=x-forwarded-proto","-Dserver.tomcat.remote_ip_header=x-forwarded-for","/build-room/target/RoomService-0.0.1-SNAPSHOT.jar"]