## Desafio Sistema de Seguradora

Projeto desenvolvido em Java 17 com Spring Boot 3.3.5. O projeto foi configurado para usar o banco H2 em memória (ideal para testes).

### Objetivo

Este projeto tem como finalidade demonstrar a implementação de um sistema simples de venda e gestão de seguros, onde é possível gerenciar clientes, bens segurados e apólices de seguro.
O foco principal é evidenciar uma estrutura limpa, modular e aderente aos princípios SOLID.

###### DADOS ARMAZENADO EM BANCO REAL NÃO ESCOLHIDO DADOS H2 QUE SERIA DADOS EM CACHE

### Tecnologias Utilizadas
Java 17 <br>
Spring Boot 3.3.5 <br>
Spring Web <br>
Spring Data JPA <br>
H2 (em memória) <br>
Bean Validation (Jakarta Validation) <br>
Spring Boot DevTools <br>
Maven - experiencia com o maestro da aplicação (Banco do Brasil - BBPrevidencia) <br>
Testes Postgran chamada HTTPS/ falta por conta do tempo facilidade ao existir front-end: JUnit Mokito 


### Informações da aplicação 
#### Conceitos Aplicados <br>
Princípios SOLID, 
DTOs e Camada de Serviço, 
Validação de dados com Bean Validation.

O projeto está configurado para utilizar o banco H2 em memória por padrão, portanto não é necessário instalar um banco externo para executar os testes.
Instruções rápidas para executar localmente:

- Compilar o projeto:

```powershell
mvn -f "c:\\Users\\Lucas\\Downloads\\Projeto\\pom.xml" clean package -DskipTests
```

- Executar a aplicação (ou use sua IDE):

```powershell
mvn -f "c:\\Users\\Lucas\\Downloads\\Projeto\\pom.xml" spring-boot:run
```

- Acesse a API em `http://localhost:8080` e o console H2 em `http://localhost:8080/h2-console` (driver: `org.h2.Driver`, JDBC URL: `jdbc:h2:mem:seguradora_db`, user: `sa`, senha vazia).
 
Projeto criado do zero inicializado  fonte - http://spring.io/projects/spring-boot

