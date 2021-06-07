# RUN UserService
If you never generate .jar files before run 
```
$ mvn package
```

Then build the docker image 
```
$ docker build . -t asi/user-service
```

And run it 
```
$ docker run -p 8081:8080 asi/user-service
```