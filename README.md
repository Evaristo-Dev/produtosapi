# Produtos API

## Descrição

A **Produtos API** é uma aplicação RESTful desenvolvida em Spring Boot para gerenciamento de produtos. Permite operações CRUD (Criar, Ler, Atualizar, Deletar) sobre produtos, armazenados em um banco de dados MySQL. A aplicação é conteinerizada com Docker para facilitar o deployment e isolamento de dependências.

### Funcionalidades Principais
- **Criação de Produtos**: Adicionar novos produtos ao catálogo.
- **Listagem de Produtos**: Recuperar todos os produtos disponíveis.
- **Atualização de Produtos**: Modificar informações de produtos existentes.
- **Exclusão de Produtos**: Remover produtos do catálogo.
- **Integração com Banco de Dados**: Persistência de dados em MySQL com JPA/Hibernate.

## Tecnologias Utilizadas

- **Java 21**: Linguagem de programação principal.
- **Spring Boot 3.5.3**: Framework para desenvolvimento de aplicações Java.
- **Spring Data JPA**: Para acesso e manipulação de dados no banco.
- **Hibernate**: ORM para mapeamento objeto-relacional.
- **MySQL 8.0**: Banco de dados relacional.
- **Docker & Docker Compose**: Conteinerização e orquestração de serviços.
- **Maven**: Gerenciamento de dependências e build.
- **Lombok**: Redução de boilerplate code.

## Pré-requisitos

Antes de executar a aplicação, certifique-se de ter instalado:

- **Java 21** ou superior.
- **Maven 3.9+** (ou use o wrapper `./mvnw`).
- **Docker** e **Docker Compose**.
- **Git** (opcional, para clonagem do repositório).

## Instalação e Configuração

1. **Clone o Repositório**:
   ```bash
   git clone <url-do-repositorio>
   cd produtosapi
   ```

2. **Configure o Banco de Dados**:
   - A aplicação está configurada para conectar ao MySQL via Docker Compose.
   - Credenciais padrão: usuário `root`, senha `testes`, banco `produtosapi`.

3. **Build da Aplicação**:
   ```bash
   ./mvnw clean package -DskipTests
   ```

## Executando com Docker

A aplicação inclui um arquivo `docker-compose.yml` para executar a API e o MySQL em containers separados.

1. **Inicie os Serviços**:
   ```bash
   docker-compose up --build
   ```

2. **Verifique o Status**:
   - API: `http://localhost:8080`
   - MySQL: `localhost:3306`

3. **Pare os Serviços**:
   ```bash
   docker-compose down
   ```

O Docker Compose garante que o MySQL esteja saudável antes de iniciar a API, evitando erros de conectividade.

## Endpoints da API

A API expõe os seguintes endpoints em `/products`:

### 1. Criar Produto
- **Método**: `POST`
- **URL**: `/products`
- **Corpo da Requisição** (JSON):
  ```json
  {
    "id": "string",
    "name": "string",
    "description": "string",
    "price": 0.0
  }
  ```
- **Resposta**: `201 Created` com o produto criado.

### 2. Listar Todos os Produtos
- **Método**: `GET`
- **URL**: `/products`
- **Resposta**: `200 OK` com lista de produtos em JSON.

### 3. Atualizar Produto
- **Método**: `PUT`
- **URL**: `/products/{id}`
- **Corpo da Requisição**: Mesmo formato do POST.
- **Resposta**: `200 OK` com o produto atualizado ou `404 Not Found`.

### 4. Deletar Produto
- **Método**: `DELETE`
- **URL**: `/products/{id}`
- **Resposta**: `204 No Content` ou `404 Not Found`.

### Exemplo de Uso com cURL

```bash
# Criar produto
curl -X POST http://localhost:8080/products \
  -H "Content-Type: application/json" \
  -d '{"id": "1", "name": "Produto Exemplo", "description": "Descrição", "price": 10.99}'

# Listar produtos
curl http://localhost:8080/products

# Atualizar produto
curl -X PUT http://localhost:8080/products/1 \
  -H "Content-Type: application/json" \
  -d '{"name": "Produto Atualizado", "description": "Nova descrição", "price": 15.99}'

# Deletar produto
curl -X DELETE http://localhost:8080/products/1
```

## Modelo de Dados

### Entidade Product
- **id** (String): Identificador único do produto.
- **name** (String): Nome do produto.
- **description** (String): Descrição detalhada.
- **price** (double): Preço do produto.

### Esquema do Banco
```sql
CREATE TABLE products (
    id VARCHAR(255) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL
);
```

## Testes

Execute os testes unitários com Maven:
```bash
./mvnw test
```

Para testes de integração com Docker, use:
```bash
docker-compose -f docker-compose.test.yml up --build
```

## Configuração Avançada

- **application.yml**: Configurações de datasource, JPA e Hibernate.
- **CORS**: Configurado em `CorsConfig.java` para permitir requisições de origens específicas.
- **Logs**: Configurados para exibir queries SQL em desenvolvimento.

## Contribuição

1. Faça um fork do projeto.
2. Crie uma branch para sua feature: `git checkout -b feature/nova-funcionalidade`.
3. Commit suas mudanças: `git commit -m 'Adiciona nova funcionalidade'`.
4. Push para a branch: `git push origin feature/nova-funcionalidade`.
5. Abra um Pull Request.

## Licença

Este projeto é licenciado sob a [MIT License](LICENSE).

## Suporte

Para dúvidas ou issues, abra uma issue no repositório ou entre em contato com a equipe de desenvolvimento.