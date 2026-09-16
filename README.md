# Retorno Java — Jornada de Retorno à Programação

> **Projeto**: `retorno-java`  
> **Java**: 21 LTS (com Java 25 para experimentação)  
> **Build**: Maven (Wrapper `./mvnw`)  
> **Framework**: Spring Boot 4.1.1  
> **IDE**: IntelliJ IDEA  
> **Versão de controle**: Git + GitHub  

---

## Sobre o projeto

Este repositório contém uma trilha de **40 aulas distribuídas em 8 semanas**, desenhada para quem está retomando a programação com Java moderno + Spring Boot. Cada sessão tem **60 minutos exatos** divididos em:

- **15 min** — teoria (leia apenas o necessário para entender o conceito do dia)
- **30 min** — prática (escreva código; evite vídeos)
- **15 min** — revisão (feche a documentação e explique o que fez)

A pergunta da revisão é:  
> *"Eu conseguiria escrever isso novamente amanhã sem copiar?"*

Não é necessário responder "sim" sempre — o objetivo é reduzir gradualmente a dependência de consulta.

---

## Estrutura do curso

### Semana 1 — Setup
- Preparar o Linux para desenvolvimento
- SDKMAN + Java (instalação de múltiplas versões)
- IntelliJ IDEA + primeiro projeto Java organizado
- Maven (pom.xml, dependências, lifecycle)
- Git no projeto

### Semana 2 — Voltar a pensar em Java
- Variáveis, tipos e métodos
- Classes e objetos
- Encapsulamento
- Interfaces e composição
- Herança x composição

### Semana 3 — Java moderno
- Collections (`List`, `Set`, `Map`)
- Generics
- Lambda
- Streams (`filter`, `map`, `sorted`, `collect`)
- Optional

### Semana 4 — Java para o trabalho
- Records
- Exceptions
- Enums e regras
- Refatoração
- Revisão Java

### Semana 5 — Entrando no Spring
- Primeiro Spring Boot
- Controller / Service / Dependency Injection
- API REST completa

### Semana 6 — Persistência
- Banco de dados + Spring Data
- CRUD com banco
- DTO
- Revisão Spring + banco

### Semana 7 — Qualidade de código
- Bean Validation
- Tratamento de erros
- Testes unitários
- Teste de Controller
- Git + refatoração

### Semana 8 — Projeto final
- Modelagem
- Criar pedido / Consulta
- Testes + erros
- Desafio final

---

## Objetivo ao final da trilha

- Criar um projeto Java do zero
- Entender e escrever código Java moderno sem copiar exemplos
- Utilizar classes, interfaces, records, collections, streams, exceptions e generics
- Trabalhar com Maven e Git
- Criar uma API REST com Spring Boot
- Estruturar Controller, Service e Repository
- Persistir dados em banco
- Escrever testes unitários e de integração
- Validar entradas e tratar erros
- Entender injeção de dependência
- Trabalhar com DTOs
- Compreender o fluxo completo de uma aplicação Spring
- Ler um código Java/Spring existente no trabalho com segurança suficiente para modificá-lo

---

## Regra do estudo

| Tempo | Atividade |
|-------|-----------|
| 15 min | Teoria — leia somente o necessário |
| 30 min | Prática — escreva código |
| 15 min | Revisão — feche docs e explique o que fez |

---

## Ambiente recomendado (do documento)

- **OS**: Ubuntu (Linux 7.0.0)
- **Java**: JDK 21 LTS (instalado via SDKMAN)
- **Java experimental**: 25.0.4-tem (via SDKMAN)
- **Gerenciador de versões**: SDKMAN
- **IDE**: IntelliJ IDEA
- **Build / Dependências**: Maven + Wrapper (`mvnw`)
- **Controle de versão**: Git / GitHub
- **Containerização**: Docker
- **Banco**: PostgreSQL
- **Cliente HTTP**: curl / HTTPie / Postman / Bruno

> *"Não vamos instalar dezenas de ferramentas."*  
> A ideia é criar um ambiente próximo ao que você encontrará profissionalmente.

---

## Estrutura do repositório

```text
retorno-java
├── pom.xml                  # Configuração Maven (Spring Boot 4.1.1, Java 21)
├── mvnw / mvnw.cmd         # Maven Wrapper
├── src
│   ├── main
│   │   ├── java/com/juliodias/
│   │   │   ├── domain/     # Modelos: Cliente, Pedido, Produto, Funcionario
│   │   │   ├── notificacao/ # Notificacoes (Email, SMS, Push, Processador)
│   │   │   ├── Pagamento/  # PagamentoCartao, PagamentoPix, TipoPagamento
│   │   │   ├── Repository/ # Repositorio
│   │   │   └── retorno/     # Main, RetornoJavaApplication
│   │   └── resources/
│   │       └── application.properties
│   └── test/
└── target/                  # Classes compiladas
```

---

## Como rodar

```bash
# Compilar e executar
./mvnw clean compile
./mvnw spring-boot:run

# Testes
./mvnw test

# Empacotar
./mvnw package
```

---


