# API RESTful com Spring Boot
<img align= "center" alt="html5" src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" /> <img align= "center" alt="html5" src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" />




Este é um projeto básico de uma **API RESTful** desenvolvida com **Spring Boot**, que implementa operações de **CRUD (Create, Read, Update, Delete)**. A aplicação foi construída com foco em **boas práticas de desenvolvimento**, **separação de responsabilidades** e **escalabilidade**.

Além das funcionalidades principais, o projeto conta com uma **camada robusta de testes unitários e de integração** utilizando **JUnit 5**, **Testcontainers** e **Rest Assured** para garantir a confiabilidade das operações de CRUD. O uso de **Swagger UI** permite explorar e validar os endpoints de forma interativa, enquanto o **CORS** está configurado para permitir o consumo seguro da API por aplicações front-end externas.

---

## 🚀 Funcionalidades

- ✅ Operações de CRUD para gerenciamento de entidades
- 🔄 Mapeamento entre entidades e DTOs utilizando [Dozer Mapper](https://github.com/DozerMapper/dozer)
- 🗄️ Integração com banco de dados **MySQL** local
- 🛠️ Versionamento e migração de banco de dados com **Flyway**
- 📘 Documentação interativa de endpoints com **Swagger UI**
- 🔗 Suporte a RESTful avançado com **HATEOAS**
- 🌍 Configuração de **CORS (Cross-Origin Resource Sharing)**
- 🧪 Testes automatizados:
  - **Testes unitários** com **JUnit 5**
  - **Testes de integração** com **Testcontainers**
  - **Validação de endpoints REST** com **Rest Assured**

---

## 🛠️ Tecnologias Utilizadas

- [Java 21](https://www.oracle.com/java/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [MySQL](https://www.mysql.com/)
- [Flyway](https://flywaydb.org/)
- [Swagger (Springfox ou Springdoc)](https://swagger.io/tools/swagger-ui/)
- [Dozer Mapper](https://github.com/DozerMapper/dozer)
- [Spring HATEOAS](https://spring.io/projects/spring-hateoas)
- [JUnit 5](https://junit.org/junit5/)
- [Testcontainers](https://www.testcontainers.org/)
- [Rest Assured](https://rest-assured.io/)
- [Maven](https://maven.apache.org/) ou [Gradle](https://gradle.org/)

---

## ✅ Requisitos

- Java 21+
- MySQL instalado e rodando localmente
- Maven ou Gradle instalado

---

## ▶️ Como Executar

1. Clone o repositório:
   ```bash
   git clone git@github.com:JoaquimCruz/API-RESTFull-with-Spring-Boot.git
   cd API-RESTFull-with-Spring-Boot
2. Configure Configure o banco de dados no arquivo application.yml
   ```bash
   spring:
     datasource:
       url: jdbc:mysql://localhost:3306/nome_do_banco
       username: seu_usuario
       password: sua_senha
3. Execute a aplicação
   ```bash
   ./mvnw spring-boot:run


## 📁 Estrutura do projeto
```bash
src
├── main
│   ├── java
│   │   └── br.com.joaquim
│   │       ├── config
│   │       ├── Controllers
│   │       ├── data.dto
│   │       ├── exception
│   │       ├── mapper
│   │       ├── model
│   │       ├── repository
│   │       ├── serialization.converter
│   │       ├── Services
│   │       └── Startup
│   └── resources
│       ├── db.migration
│       ├── static
│       ├── templates
│       └── application.yml
└── test
    └── java
        └── br.com.joaquim
            ├── config
            ├── integrationtests
            └── unittests



