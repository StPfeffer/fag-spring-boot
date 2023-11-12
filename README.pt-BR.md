# Transaction API

_Leia isso em outros idiomas_:
[English](README.md)

## Visão Geral

## Funcionalidades Principais

### Criação de Transações:

- Permite aos usuários criar novas transações fornecendo detalhes como remetente, destinatário e valor.

### Listagem de Transações:

- Apresenta uma visão abrangente de todas as transações realizadas.
- Permite a filtragem por remetente, destinatário e outros critérios.

### Notificações em Tempo Real:

- Envia notificações automáticas para os usuários envolvidos em uma transação bem-sucedida através de um serviço externo.

### Autorização de Transações:

- Incorpora um serviço de autorização externo (Mocky) para validar transações antes da conclusão.

## Estrutura do Projeto

![img.png](assets/img.png)

## Como Usar

### Java e Maven

Primeiramente, certifique-se de ter o [Java](https://www.oracle.com/java/technologies/downloads/) e o
[Maven](https://maven.apache.org/download.cgi) instalados.

### Instalar as dependências

- Spring Boot
- H2 Database
- Jakarta Persistence API

```
mvn clean install
```

### Banco de Dados

Configure as propriedades do banco de dados no arquivo `src/main/resources/application.properties`.

**Obs**: Por padrão, está configurado um banco de dados `H2` em memória.

### Postman

Nos diretórios do projeto, existe uma pasta chamada `postman`, contendo uma _collection_, com todos os endpoints da API.

Para utilizá-la, basta copiar o conteúdo do arquivo `postman/collections/Transaction API.json` e colar no _Postman_:

![img1.png](assets/img1.png)

Caso utilize o [IntelliJ](https://www.jetbrains.com/idea/), é possível realizar as requisições HTTP pela IDE:

![img2.png](assets/img2.png)

### Execute a aplicação:

Para iniciar a aplicação, utilize o comando:

```
mvn spring-boot:run
```

Por padrão, a aplicação irá abrir na porta 8080.
