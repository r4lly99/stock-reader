# Stock-Reader-service

Simple service to consume message broker from `broadcast` service.

## Description

For coding pretest Backend Developer 

## Getting Started

### Dependencies

* Kafka
* Java8 / Java11
* Docker(optional)

### Installing

* Clone this repository
* Enabled annotation processing
* Start `broadcast` services   
* To run kafka(zookeper & broker) from dockerfile(using port 2181 & 9092)
```
docker-compose up -d
```

### Executing program

* Run only

```
./gradlew build run
```

* Using native image
```
./gradlew nativeImage
```

## Description

* After application running it will consume a topic and calculated/process message  
  with job scheduler (45s)


## Authors

[Rully](https://github.com/r4lly99)