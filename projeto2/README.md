# Documentação da API de Busca de Cidades Brasileiras

## Visão Geral

Esta API oferece uma rota para buscar informações sobre todas as cidades do Brasil, permitindo a ordenação utilizando diferentes algoritmos.

## Rota Disponível

### Buscar Todas as Cidades do Brasil

- **Rota**: `/busca_cidades`
- **Método HTTP**: GET
- **Parâmetros da URL**:
  - `sort`: Especifica o algoritmo de ordenação a ser utilizado. Pode ser `merge`, `bubble` ou `quick`. Se não fornecido, retornará uma mensagem de erro.
- **Descrição**: Retorna todas as cidades do Brasil ordenadas de acordo com o método de ordenação definido pelo usuário, além de retornar o tempo de execução em segundos e o número de comparações realizadas.
- **Exemplo de Requisição**:
  ```http
  GET /busca_cidades?sort=merge HTTP/1.1
