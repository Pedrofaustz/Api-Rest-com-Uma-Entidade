# 🚀 API REST — Usuários e Tarefas

Projeto desenvolvido em **Java** com **Spring Boot** para gerenciar usuários e serviços, seguindo as melhores práticas de arquitetura em camadas e tratamento de exceções.

---

## 📌 Tecnologias Utilizadas

* **Java**
* **Spring Boot**
* **Spring Data JPA**
* **H2 Database**

---

## 🗂️ Estrutura do Projeto

O projeto está organizado na seguinte arquitetura de camadas:

* **`Entity`**: Classes que representam as tabelas e dados do banco (`User`).
* **`Repository`**: Interfaces responsáveis pelas consultas e persistência (`UserRepository`).
* **`Service`**: Regras de negócio e mediação entre controllers e o banco (`UserService`).
* **`Controller`**: Endpoints e rotas da API REST (`UserController`).
* **`Exception`**: Tratamento centralizado de erros e respostas de exceções (`ExceptionAll`).

---

## ⚙️ Funcionalidades e Rotas

A API disponibiliza operações para gerenciamento de dados:

* `GET /user/test` — Endpoint de teste do servidor Tomcat.
* **Operações CRUD de Usuários:**
  * Listagem, busca por ID, criação, atualização e deleção.
* **Tratamento de Exceções:**
  * Retorno de respostas HTTP personalizadas para erros de requisição e buscas inexistentes.

---

## 📝 Observações

Este projeto evoluiu de uma API inicial de entidade única para uma estrutura completa com serviços e controladores desacoplados. Ideal para práticas avançadas de Spring Boot!
