# Documentação da API de Busca de Cidades Brasileiras

## Visão Geral

Esta API fornece duas rotas para buscar informações sobre cidades brasileiras:

1. `busca_cidades`: Retorna todas as cidades do Brasil.
2. `busca_cidades_estado`: Retorna todas as cidades de um estado específico.

## Rotas Disponíveis

### 1. Buscar Todas as Cidades do Brasil

- **Rota**: `/busca_cidades`
- **Método HTTP**: GET
- **Descrição**: Retorna todas as cidades do Brasil.
- **Exemplo de Requisição**:
  ```http
  GET /busca_cidades

### Exemplo de resposta

[
    "São Paulo",
    "Rio de Janeiro",
    "Belo Horizonte",
    ...
]

### 2. Buscar Cidades de um Estado Específico

- **Rota**: `/busca_cidades_estado`
- **Método HTTP**: GET
- **Parâmetros da URL**:
  - `estado`: Sigla do estado brasileiro (por exemplo, sp para São Paulo, rj para Rio de Janeiro, etc.).
- **Descrição**: Retorna todas as cidades de um estado específico.
- **Exemplo de Requisição**:
  ```http
  GET /busca_cidades_estado?uf=sp

### Exemplo de resposta

[
    "estado": "MG",
    "cidades: ["Alfenas", "Passos", "São Sebastião do Paraíso ]
]

