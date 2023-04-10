# YourSampple-Remake

<b> Phone Bill Calculator API Server </b>

---
## Execution
```
git clone https://github.com/lomayd/YourSampple-Remake.git

cd ./YourSampple-Remake

[Write down "MYSQL_ROOT_PASSWORD" in docker-compose.yml]

docker-compose up -d

[Write down "spring.datasource.password" in /src/main/resources/application.yml]

sudo chmod 777 ./gradlew

./gradlew build

java -jar build/libs/YourSampple-Remake-0.0.1-SNAPSHOT.jar
```

## Contents
- Phone Bill Calculator API
- CSV Reader + Writer Using Sping Batch
