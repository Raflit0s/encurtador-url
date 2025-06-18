# encurtador-url
Encurtador de URLs feito através da linguagem de programação java, 
Spring framework e o banco de dados mongodb. ☕ <br>
Também foi utilizado docker para facilitar o ambiente o ambiente de desenvolvimento. 🐳

### 📋Pré-requisitos 
Java versão 21+ <br>
Docker, maven e mongodb instalados na máquina.

## 🚀Como executar
Primeiro, utilize os dois comandos a seguir, no terminal, para entrar na pasta do projeto: <br>
```bash
git clone https://github.com/Raflit0s/encurtador-url
cd encurtador-url
```
Depois, inicie os containers com o seguinte comando:
```bash
docker-compose up --build
```
Por fim, use este comando para fazer a aplicação funcionar:
```bash
docker-compose up
```
Isso iniciará a aplicação na porta 8080 e o mongodb na porta 27017.

## 🔍Endpoints
| Método | URL                | Descrição                                                                 |
|--------|--------------------|---------------------------------------------------------------------------|
| POST   | `/shorten-url`     | Recebe uma URL original no corpo da requisição e retorna a URL encurtada. |
| GET    | `/{shortUrl}`      | Redireciona a partir da URL encurtada para a URL original.                |

(body da requisição POST deverá ser: {"longUrl" : "link"}) <br>
Obs: para o método GET, basta inserir o link curto no próprio navegador que o redirecionamento ocorrerá.