# Meta Diária

O Meta Diária é um sistema simples e eficiente de gerenciamento de tarefas, criado para compor portfólio profissional e demonstrar boas práticas de desenvolvimento utilizando Spring Boot.

O objetivo do projeto é permitir que o usuário organize suas metas diárias de forma prática, com funcionalidades essenciais como criação, edição, conclusão e remoção de tarefas.

## 🚀 Objetivo do Projeto

Construir uma aplicação completa para portfólio, utilizando **Spring Boot**, boas práticas e pronta para **deploy** em ambiente real.

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Spring Boot
    -  Spring Web
    -  Spring Data JPA
    -  Spring Validation
    -  Spring Security (caso adicione autenticação)
- Banco de Dados: PostgreSQL ou MySQL
- Ferramentas de Build: Maven
- Documentação da API: Swagger / Springdoc OpenAPI
- Deploy: Railway, Render, Fly.io, ou outro serviço de sua escolha

## 📌 Funcionalidades (MVP)

- Criar uma nova tarefa
- Listar todas as tarefas
- Atualizar título/descrição da tarefa
- Marcar como concluída
- Excluir tarefa
- Registrar automaticamente a data de criação
- Versionamento com Git e futuras melhorias

## 📂 Estrutura Inicial

```
meta-diaria/
 ├── src/
 │   ├── main/
 │   │   ├── java/
 │   │   │   └── com.project.metadiaria/
 │   │   │       ├── controller/
 │   │   │       ├── service/
 │   │   │       ├── repository/
 │   │   │       ├── dto/
 │   │   │       └── model/
 │   │   └── resources/
 │   │       ├── application.properties
 │   │       └── schema.sql (opcional)
 └── pom.xml
```

## 🔧 Como Rodar o Projeto Localmente

**1.** Clone o repositório:

```
bash

git clone https://github.com/seu-usuario/meta-diaria.git

```

**2.** Entre na pasta:

```
bash

cd meta-diaria

```

**3.** Configure o banco de dados em `application.yaml`.

**4.** Execute o projeto:

```
bash

./mvnw spring-boot:run

```