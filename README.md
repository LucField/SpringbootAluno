# Springboot Flyway 

Este é um projeto SUPER legal, sobre a aplicação do Springboot Flyway no cadastro de uma entidade qualquer de minha escolha.

## 🤡 As definições 🤡

A entidade usada de referência foi "aluno". Assim, a entidade "aluno" terá os seguintes atributos:

- **Matrícula**
- **Nome**
- **Data de nascimento**
- **E-mail**
- **Telefone**
- **Endereço**
- **Curso**
- **CPF**

---

## 🦐 Antes de tudo 🦐

### 1. O que foi utilizado
Saiba que este projeto foi construído com os seguintes elementos:
1. Java ☕
2. Postgres 🐘
3. Complementos como Maven e Springvoot 👾
4. VsCode como IDE 🖥️
5. Postman 🧑‍🚀

Assim, caso prefira utilizar outros, pode ser que mude a construção deste README e o próprio projeto.

---

### 2. Configurando o projeto

Após fazer o ``git clone`` do projeto, primeiramente é necessário revisar as dependências e as versões no pom.xml, para averiguar que não haja conflitos. Logo após, verifique o ``application.properties`` e mude os campos das credenciais como bem quiser:

```text
spring.datasource.url=jdbc:postgresql://localhost:5432/alunos //mude o nome do banco se precisar
spring.datasource.username=megauser // mude o nome do usuário
spring.datasource.password=senha //mude a senha deste usuário
```

## 🪿 Brincando com o projeto 🪿

### Passo 1 🥚

Execute este comando para compilar o projeto pro maven

   ```text
       mvn clean install  
   ```

### Passo 2 🐣

Execute este comando para executar o flyway que fará conexão com o banco de dados definido na rota do application.properties, e criará naquele banco de dados a criação da tabela "aluno"

   ```text
       mvn spring-boot:run 
   ```

### Passo 3.1 🐥

Existe três formas de executar este código e verificar a conexão do projeto com o banco de dados, sendo a primeira forma através do terminal, mais precisamente o ``SpringAlunApplication.java``. 
Caso tenha percebido no terminal em que você executou o passo 2, já terá o arquivo.java em execução, com esta tela:

```text
        Menu CRUD
        1. Create (POST)
        1. Create (POST)
        2. Request (GET)
        3. Update (PUT)
        4. Delete (DELETE)
        -----------------------------
        5. PARAR
        Digite um número:
   ``` 
Agora, você poderá escolher entre as opções um número, que pedirá pelos parâmetros necessários para executar o comando sql do método escolhido. Assim podendo escolher o número 5 ``caso queira parar os testes``, depois de parar o terminal ficará impossibilitado de ser usado para o Menu CRUD e terá que executá-lo novamente.   

### Passo 3.2 🐔

A segunda forma de testar o projeto é utilizando as URL's com o Postman, tendo os segundos comandos:

#### Método GET para todos os alunos:

URL:
```
    http://localhost:8080/api/alunos
```

#### Método GET para um aluno:

URL:
```
    http://localhost:8080/api/alunos/[matrícula]
```

#### Método POST usando o json:

URL:
```
    http://localhost:8080/api/alunos
```

JSON:
```json
    {
        "nome": "Aluno",
        "data_nascimento": "18/12/2024",
        "email": "aluno.aluno@gmail.com",
        "telefone": "11223344",
        "endereco": "Rua X...",
        "curso": "Informática",
        "cpf": "000.000.000-00"
    }
```
#### Método PUT para um aluno:

URL:
```
    http://localhost:8080/api/alunos/[matrícula]
```

JSON:
```json
    {
        "nome": "onulA",
        "data_nascimento": "2024/12/18",
        "email": "aluno.aluno@gmail.com",
        "telefone": "44332211",
        "endereco": "Rua Y...",
        "curso": "Informática"
    }
```

#### Método DELETE:

URL:
```
    http://localhost:8080/api/alunos/<matrícula>
```

### Passo 3.3 🦖

A terceira forma de testar o projeto é utilizando as cURL's no terminal:

GET para todos os alunos:
```bash
    curl -X GET http://localhost:8080/api/alunos
```

GET para apenas um aluno:
```bash
    curl -X GET http://localhost:8080/api/alunos/[matrícula]
```

POST:
```bash
    curl -X POST http://localhost:8080/api/alunos \
     -H "Content-Type: application/json" \
     -d '{
           "nome": "Aluno",
            "data_nascimento": "18/12/2024",
            "email": "aluno.aluno@gmail.com",
            "telefone": "11223344",
            "endereco": "Rua X...",
            "curso": "Informática",
            "cpf": "000.000.000-00"
         }'
```

PUT: 
```bash
    curl -X PUT http://localhost:8080/api/alunos/[matrícula] \
     -H "Content-Type: application/json" \
     -d '{
           "nome": "onulA",
            "data_nascimento": "2024/12/18",
            "email": "aluno.aluno@gmail.com",
            "telefone": "44332211",
            "endereco": "Rua Y...",
            "curso": "Informática"
         }'

```

### Passo 3.4 ☄️

Apertar Alt + F4 e ir tomar um ar, por que o projeto acabou :D


##  🤫 Finalização 🧏‍♂️
Autor: Lucas R.
Última Atualização: 18/12/2024;
