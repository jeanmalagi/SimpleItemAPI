# SimpleItemAPI

Bem-vindo à documentação da minha API! Aqui estão algumas informações básicas.

## Recursos

- [GET /api/items](#get-apiitems): Obter todos os itens.
- [POST /api/items](#post-apiitems): Criar um novo item.
- [PUT /api/items/{itemId}](#put-apiitemsitemid): Atualizar um item existente.
- [GET /api/items/{itemId}](#get-apiitemsitemid): Obter um item pelo ID.

## Endpoints

## **POST /api/items**

Cria um novo item.

Parâmetros da Requisição

```json
{"nome": "Novo Item"}
```
Exemplo de Resposta

```json
{"id": 3, "nome": "Novo Item"}
```

## **PUT /api/items/{itemId}**

Atualiza um item existente pelo ID.

Parâmetros da Requisição

```json
{ "nome": "Item Atualizado"}
```
Exemplo de Resposta
```json
{"id": 3, "nome": "Item Atualizado"}
```

# **GET /api/items/{itemId}**

Retorna um item pelo ID.

Parâmetros da Requisição
Nenhum.
Exemplo de Resposta

```json
{"id": 3, "nome": "Item Atualizado"}
```