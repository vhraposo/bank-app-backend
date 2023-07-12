# FX Money

## Descrição

🏦 FX Money é uma aplicação web desenvolvida para permitir que os usuários administradores acessem e visualizem todo o histórico de seus clientes. O projeto utiliza tecnologias como MySQL como banco de dados, Java 17 com Spring Boot 3, JWT, Angular, Angular Material, Bootstrap e jsPDF.

- Este projeto foi desenvolvido para como desafio final da 5 academia de Java da Atos/Ufn
 
## Recursos

🔐 A aplicação oferece os seguintes recursos:

- Autenticação de usuário utilizando JWT (JSON Web Token).
- Interface intuitiva e responsiva desenvolvida com Angular e Bootstrap.
- Visualização do histórico completo dos clientes.
- Geração de relatórios em formato PDF utilizando jsPDF.

## Pré-requisitos

Antes de executar a aplicação, certifique-se de ter o seguinte instalado:

- Java 17: [Download](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- MySQL: [Download](https://dev.mysql.com/downloads/)
- Node.js: [Download](https://nodejs.org/en/download/)

## Tecnologias
Neste projeto, foram utilizadas as seguintes tecnologias:

Java 17 :rocket: <br>
Spring Boot 3 :seedling: <br>
MySQL :floppy_disk: <br>
JWT :closed_lock_with_key: <br>
Angular :a: <br>
Angular Material :art: <br>
Bootstrap :globe_with_meridians: <br>

## Deploy 
- Acesse a aplicação online através do link : https://fxbank.vercel.app/  <br>
  Usuário teste : admin  <br>
  senha teste   : 12345

## Configuração

Siga as etapas abaixo para configurar e executar o projeto:

1. Clone o repositório do projeto:
- gh repo clone vhraposo/bank-app-backend

  
2. Configure o banco de dados MySQL:

- Crie um novo banco de dados chamado `fx_bank`.
- No arquivo `application-test.properties`, localizado em `src/main/resources`, atualize as configurações de conexão com o banco de dados:
  spring.datasource.url=jdbc:mysql://localhost:3306/fx_bank
  spring.datasource.username=seu-usuario
  spring.datasource.password=sua-senha

 3. Para executar o projeto é necessário antes alterar o perfil para test no arquivo: `application.properties`.
    
 4. Execute o projeto Spring, ele irá criar as tabelas automaticamente através do JPA/Hibernate e ficará disponível para receber requisições.


## Uso
É necessário realizar as alterações de CORS na aplicação Angular, como descomentar as linhas que estão permitindo o CORS da aplicação online para a aplicação local.


## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para enviar pull requests com melhorias, correções de bugs ou novos recursos. Abra uma issue para discutir grandes mudanças antes de iniciar qualquer trabalho.




  
