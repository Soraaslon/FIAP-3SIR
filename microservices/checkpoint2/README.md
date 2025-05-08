# Checkpoint 2 - Agência de consultas-API

API Java de um sistema de agências de consultas com Spring Boot.

## Instalação

- Limpar e criar a pasta _/target_

```
mvn clean package
```

- Configuração do Swagger

  - https://springdoc.org/properties.html

* application.properties

```
springdoc.swagger-ui.path=/
springdoc.swagger-ui.disable-swagger-default-url=true
```

## Navegação

### Executar a API

- _Executando_ **Maven**

```
mvn spring-boot:run
```

### Documentação da API (Swagger)

- http://localhost:8080/swagger-ui.html

## Referencias

- https://springdoc.org/
