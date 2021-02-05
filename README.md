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
