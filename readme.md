# Aplicação Spring Boot com Arquitetura Hexagonal

Este projeto é uma aplicação Spring Boot estruturada de acordo com a Arquitetura Hexagonal, também conhecida como
Arquitetura de Portas e Adaptadores. A arquitetura promove modularidade e testabilidade ao separar as preocupações em
camadas distintas.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

- `DemoApplication.java`: Este é o ponto de entrada principal da aplicação Spring Boot.

### Camada de Adaptadores

- `IRestfull.java`: Esta interface define um conjunto de endpoints RESTful para gerenciar entidades.
- `PessoaController.java`: Este é o controlador REST responsável por lidar com requisições HTTP relacionadas à
  entidade "pessoa". Ele implementa a interface `IRestfull`.
- `PessoaMapper.java`: Esta classe fornece a mapeação entre `PessoaDTO` (DTO) e `Pessoa` (entidade).

### Camada de Aplicação

- `IServicePort.java`: Esta interface define o contrato de serviço para gerenciar entidades.
- `PessoaServicePort.java`: Esta classe implementa o contrato de serviço definido em `IServicePort` para a entidade "
  pessoa". Ela interage com o repositório e aplica lógica de negócio.
- `PessoaRepository.java`: Esta interface estende `JpaRepository` e fornece métodos de acesso aos dados para a
  entidade "pessoa".

### Camada de Domínio

- `AEntity.java`: Esta classe abstrata fornece uma implementação genérica para entidades com um ID gerado.
- `Pessoa.java`: Esta classe representa a entidade "pessoa" com atributos como `nome`, `sobrenome` e `dtNascimento`.

### DTOs

- `Adto.java`: Esta classe abstrata representa um DTO com um campo de ID genérico.
- `PessoaDTO.java`: Esta classe representa o DTO para a entidade "pessoa" com atributos `nome`, `sobrenome`
  e `dtNascimento`.

### Testes de Integração

- `PessoaControllerTester.java`: Esta classe contém testes de integração para o `PessoaController` usando o MockMvc. Ela
  testa a criação de uma nova "pessoa".

## Executando a Aplicação

Para executar a aplicação, execute o método `main` em `DemoApplication.java`. A aplicação será iniciada na porta 8080
por padrão.

## Testes

O projeto inclui testes de integração para o `PessoaController`. Esses testes verificam o comportamento dos endpoints
REST.

## Dependências

- Spring Boot
- Spring Data JPA
- Spring Web
- Banco de dados H2 (para testes)

## Primeiros Passos

1. Clone o repositório.
2. Verifique se você tem Java e Maven instalados.
3. Compile e execute a aplicação.
