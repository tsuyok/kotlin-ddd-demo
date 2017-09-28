# Kotlin + Spring Boot sample project
```
cp src/main/resources/config/application.yml.sample src/main/resources/config/application.yml
docker-compose up -d
mysql -u root -h 127.0.0.1 -e 'create database kotlin_sample;'
mysql -u root -h 127.0.0.1 -e 'create database kotlin_sample_test;'
./gradlew bootRun
```

# 設計の参考
サンプルを作る上で、増田さんのドメイン駆動設計のサンプルを参考にさせていただきました。

https://github.com/system-sekkei/isolating-the-domain
