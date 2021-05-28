# RUN AuthService
If you never generate .jar files before run
```
$ mvn package
```

Then build the docker image
```
$ docker build . -t asi/auth-service
```

And run it
```
$ docker run -p 8082:8080 asi/auth-service
```