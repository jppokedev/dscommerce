# 🛍️ DSCommerce - Backend API RESTful

## 📌 Sobre o projeto

**DSCommerce** é uma API RESTful backend construída em **Java usando Spring Boot**, com foco em fornecer os recursos essenciais de um sistema de e-commerce robusto e escalável.  
Este projeto demonstra boas práticas de arquitetura backend, organização de camadas, persistência com JPA/Hibernate e integração com banco de dados relacional — ideal para fortalecer seu portfólio para vagas de emprego.

---

## 🧠 Tecnologias utilizadas

### ✅ Backend
- **Java** (linguagem principal)
- **Spring Boot**
- **Spring Web (REST)**
- **Spring Data JPA**
- **Hibernate**
- **Maven**
- **Banco de dados:** H2 / MySQL / PostgreSQL (configurável)
- **Swagger / OpenAPI** para documentação de API

---

## Modelo conceitual

![ORM](https://github.com/jppokedev/assets/blob/main/ORM.png)

## 📦 Funcionalidades

### 🧑‍💻 Usuários
- Cadastro de usuários
- Autenticação
- Controle de papéis/permissões (Ex: ROLE_USER, ROLE_ADMIN)

### 📦 Produtos
- CRUD completo de produtos
- Consulta de produtos
- Paginação e ordenação (se configurado)

### 🛒 Pedidos
- Criação de pedido (com cálculo automático de total)
- Listagem de pedidos por usuário
- Regras básicas de negócio

### 📄 Documentação
- A API está documentada via Swagger/OpenAPI
- Interface interativa para testar endpoints

---

## 🚀 Como executar o projeto

### 🧩 Pré-requisitos

Antes de iniciar, certifique-se de ter instalado:

- **Java 17+**
- **Maven** (não obrigatório se usar o wrapper `mvnw`)
- Um banco de dados (pode usar H2 para desenvolvimento local)

---

### 📌 Clonar repositório

```bash
git clone https://github.com/jppokedev/dscommerce.git

```
### 🧠 Executar backend

```bash
mvnw.cmd spring-boot:run
```

### 🛠️ Configuração de banco de dados

Você pode usar o H2 (in memory) ou configurar uma instância real de MySQL/PostgreSQL no arquivo application.properties, por exemplo:

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/dscommerce
spring.datasource.username=root
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

### 📁 Estrutura do projeto

O código segue uma arquitetura em camadas:

```bash
src/
 └── main/
     ├── java/
     │   └── com/dscommerce/
     │       ├── controllers/
     │       ├── services/
     │       ├── repositories/
     │       └── models/
     └── resources/
         ├── application.properties
```
### 🧑‍💻 Autor

Desenvolvido por João Paulo (jppokedev)
📌 GitHub: https://github.com/jppokedev

📫 LinkedIn: https://www.linkedin.com/in/jo%C3%A3o-paulo-fonseca-6b261a23b
