# Funqy Demo

## Functions & Classes

* `GreetingFunction`
* `Greeting`
* `GreetingService`
* `Person`
* `Family`

## Docker Image

```
docker build -f src/main/docker/Dockerfile.jvm -t funqy-demo .
docker run --rm -p 8080:8080 funqy-demo
```

## Build Native

```
quarkus.native.container-build=true
quarkus.native.container-runtime=docker
```

---

## Deploy on Azure


### Application Properties

```
quarkus.http.root-path=/api
```

### Deployment Dependencies

```
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-azure-functions-http</artifactId>
</dependency>
```

...and some more plugins.

Also, see folder `/azure-config`.

### Deployment w/ Maven

```
mvn clean install azure-functions:run
```

```
mvn clean install azure-functions:deploy
```

### Native Deployment

Noy yet supported by Quarkus/Azure.
