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

## Deploy on AWS

### Deployment Dependencies

```
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-amazon-lambda-http</artifactId>
</dependency>
```

### SAM (Local)

```
sam local start-api --template target/sam.jvm.yaml --warm-containers EAGER

sam package --template-file target/sam.jvm.yaml --output-template-file packaged.yaml --s3-bucket dasniko-quarkus-demo
sam deploy --template-file packaged.yaml --capabilities CAPABILITY_IAM --stack-name quarkus-demo
```

### Serverless Framework

```
service: funqy-demo

provider:
  name: aws
  runtime: java11
  region: eu-central-1
  endpointType: REGIONAL
  memorySize: 256
  timeout: 15
  deploymentBucket: dasniko-quarkus-demo

functions:
  funqy:
    handler: io.quarkus.amazon.lambda.runtime.QuarkusStreamHandler::handleRequest
    events:
      - http:
          path: /{proxy+}
          method: any
    package:
      artifact: target/function.zip

package:
  individually: true
```
