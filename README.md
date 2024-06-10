<h1 align="center">Processamento Pedidos</h1>

### Topics
:small_blue_diamond: [About](#about-book)  
:small_blue_diamond: [Features](#features-wrench)  
:small_blue_diamond: [Running Application](#running-application-with-image-arrow_forward)  
:small_blue_diamond: [Developers Team](#developers-team-octocat)  

## About :book:
<p align="justify">
    Microservice that generates and consumes a mocked queue and persists it in the database. Making data available via REST APIs
</p>
<p align="center">
    <a href="https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html" target="_blank">
        <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 17">
    </a>
    <a href="https://spring.io/projects/spring-boot" target="_blank">
        <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=flat-square&logo=Spring&logoColor=white" alt="Spring Boot">
    </a>
    <a href="https://maven.apache.org/download.cgi" target="_blank">
        <img src="https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white" alt="Maven">
    </a>
    <a href="https://www.rabbitmq.com/" target="_blank">
        <img src="https://img.shields.io/badge/Rabbitmq-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white" alt="RabbitMQ">
    </a>
    <a href="https://www.mysql.com/" target="_blank">
        <img src="https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL">
    </a>
    <a href="https://docs.docker.com/" target="_blank">
        <img src="https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white" alt="Docker">
    </a>
    <a href="https://www.jetbrains.com/pt-br/idea/" target="_blank">
        <img src="https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white" alt="Intellij">
    </a>
</p>

<p align="center">
    Kanban Board and Diagrams
</p>
<p align="center">
    <a href="https://matheuslmessias09.atlassian.net/jira/software/projects/DPDP/boards/3" target="_blank">
        <img src="https://img.shields.io/badge/jira-%230A0FFF.svg?style=for-the-badge&logo=jira&logoColor=white" alt="Jira">
    </a>
    <a href="https://miro.com/welcomeonboard/MVBLQ3dTc3RDY01YVWg1WFlqWFBPWnZXdHBES0l3Y0RLV1dhS213c255YnRpSFgxOWVlSUUybkxBeGtWaTlYUnwzNDU4NzY0NTkxMzk1Mjk2MzA2fDI=?share_link_id=846127350215" target="_blank">
        <img src="https://img.shields.io/badge/Canva-%2300C4CC.svg?style=for-the-badge&logo=Canva&logoColor=white" alt="Miro">
    </a>
</p>

<p align="center">
    <img src="http://img.shields.io/static/v1?label=STATUS&message=FINISHED&color=GREEN&style=for-the-badge" alt="Status">
</p>

## Features :wrench:
- [X] Mock queue producer for RabbitMQ
- [X] RabbitMQ queue consumer
- [X] REST API Total order value
- [X] REST API Number of requests per customer
- [X] REST API List of requests made by the customer

## Running Application with image :arrow_forward:
First, configure docker:
```
https://docs.docker.com/
```
Configure docker-compose:
```
https://github.com/MatheusLMessias/processamento-pedidos/blob/main/docker-compose.yml
```
Run docker containers:
```
docker compose up
```
## Running Application local :arrow_forward:
First, clone this repository:
```
git clone https://github.com/MatheusLMessias/processamento-pedidos.git
```
Environment setup:
```
https://docs.docker.com/
https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
https://maven.apache.org/download.cgi
```
In the project folder, install dependencies:
```
mvn clean install
```
Run docker containers:
```
docker compose up
```
Run project:
```
mvn spring-boot:run
```
## Running http test:
REST API Total order value
```
http://localhost:8080/api/v1/totalValue 
{
  "codeRequest": 1011 
}
```
REST API Number of requests per customer
```
http://localhost:8080/api/v1/client/count 
{
  "codeClient": 1 
}
```
REST API List of requests made by the customer
```
http://localhost:8080/api/v1/client/list
{
  "codeClient": 1 
}
```

Follow good development practices:
```
https://www.alura.com.br/artigos/git-flow-o-que-e-como-quando-utilizar
```

## Developers Team :octocat:
| [<img src="https://avatars.githubusercontent.com/u/101664656" width=115><br><sub>Matheus Messias</sub>](https://github.com/MatheusLMessias) | 
| :---: |
