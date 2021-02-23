## challenge-backend

API criada com base nos requisitos do desafio proposto [pip](https://github.com/B2WMKTP/back/tree/main/challenge-backend-master/)

### Iniciando a aplicação

A aplicação pode ser utilizada a partir de um container docker. Para configurar o projeto, realizar os seguintes passos:

1. Fazer o pull do projeto.
2. Ir até o diretório raiz do projeto.
3. Fazer o build da imagem através do comando:
```bash
docker build -t api/challenge-backend:1.0.0 .
```
4. Rodar a imagem através do comando (para visualizar os logs, remover o -d do comando abaixo):
```bash
docker run --name challenge-api -p 8080:8080 -d docker.io/api/challenge-backend:1.0.0
```

5. Para parar o container: 
```bash
docker stop challenge-api
```
6. Para iniciar o container novamente: 
```bash
docker start challenge-api
```

### Usando a aplicação

Após o container ser iniciado, as seguintes rotas estarão disponíveis:

http://localhost:8080/challenge-backend/items - Consome a API do mocky, trazendo todos os dados.
http://localhost:8080/challenge-backend/items?begindate=03-10-2016&finaldate=04-10-2016 - Consome a api, filtrando por período.