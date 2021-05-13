# Central de Erros
Projeto Final Acelera Dev Conta Azul


## Objetivo
Em projetos modernos é cada vez mais comum o uso de arquiteturas baseadas em serviços ou microsserviços. Nestes ambientes complexos, erros podem surgir em diferentes camadas da aplicação (backend, frontend, mobile, desktop) e mesmo em serviços distintos. Desta forma, é muito importante que os desenvolvedores possam centralizar todos os registros de erros em um local, de onde podem monitorar e tomar decisões mais acertadas. Neste projeto implementou-se uma API Rest para centralizar registros de erros de aplicações.


## Tecnologias Utilizadas
- Java 1.8
- Spring Boot
- Maven
- H2
- Swagger
- Oauth 2.0


## Funcionalidades
- [x] Deve permitir a autenticação do sistema que deseja utilizar a API gerando o Token de Acesso
- [x] Pode ser acessado por multiplos sistemas
- [x] Deve permitir gravar registros de eventos de log salvando informações de Level(error, warning, info), Descrição do Evento, LOG do Evento, ORIGEM(Sistema ou Serviço que originou o evento), DATA(Data do evento), QUANTIDADE(Quantidade de Eventos de mesmo tipo)
- [x] Deve permitir a listagem dos eventos juntamente com a filtragem de eventos por qualquer parâmetro especificado acima
- [x] Deve suportar Paginação
- [x] Deve suportar Ordenação por diferentes tipos de atributos
- [x] A consulta de listagem não deve retornar os LOGs dos Eventos
- [x] Deve permitir a busca de um evento por um ID, dessa maneira exibindo o LOG desse evento em específico

# API
## Hospedagem
Nossa API encontra-se hospedada em: <br>
<a href="https://projeto-erros.herokuapp.com" taget="_blank">
  `https://projeto-erros.herokuapp.com`
</a>
## Documentação 
A documentação do swagger está disponível em: <br>
<a href="https://projeto-erros.herokuapp.com/swagger-ui.html" taget="_blank">
  `https://projeto-erros.herokuapp.com/swagger-ui.html`
</a>


# Equipe
<a href="https://github.com/alexandrefaustino">
  Alexandre Faustino
</a><br>
<a href="https://github.com/EmanuelleBrasil">
  Emanuelle Brasil
</a><br>
<a href="https://github.com/julioKauer">
  Júlio Kauer
</a>
