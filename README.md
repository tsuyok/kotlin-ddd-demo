# Kotlin + DDD + Spring Boot sample project
Kotlinでドメイン駆動設計でアプリケーションを作るための雛形を作ってみました。設計思想は増田亨さんのDDDをベースにしています。
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
