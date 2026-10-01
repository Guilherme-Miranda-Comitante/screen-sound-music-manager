# Screen Sound / Screen Music - CLI Application

Uma aplicação de linha de comando (CLI) desenvolvida em **Java** projetada para gerenciar e catalogar dados sobre músicas e artistas favoritos. Este projeto foi o desafio final focado em consolidar conhecimentos em persistência de dados e bancos de dados relacionais com o ecossistema Spring da Alura.

O objetivo principal foi aplicar na prática os conceitos fundamentais de **Programação Orientada a Objetos (POO)**, mapeamento objeto-relacional (ORM) com **Spring Data JPA** e a comunicação eficiente com um banco de dados relacional.

## Funcionalidades

O programa roda de forma interativa no console e oferece o seguinte menu de opções:
- **Cadastrar artistas:** Registra um artista especificando seu nome e tipo (Solo, Dupla ou Banda).
- **Cadastrar músicas:** Associa novas músicas a um artista previamente cadastrado no sistema, garantindo o relacionamento correto entre os dados.
- **Listar músicas:** Exibe todas as músicas salvas no banco de dados com seus respectivos artistas.
- **Buscar músicas por artistas:** Filtra o banco de dados e exibe o repertório completo de um artista específico digitado pelo usuário.

## Tecnologias e Conceitos Utilizados

- **Java 17** 
- **Spring Boot & Spring Data JPA:** Utilizados para gerenciar o ciclo de vida da aplicação e simplificar a camada de persistência.
- **PostgreSQL:** Banco de dados relacional utilizado para armazenar e persistir as informações.
- **Mapeamento JPA (@ManyToOne / @OneToMany):** Implementação de relacionamentos entre as entidades `Artista` e `Musica`.
- **Derived Queries:** Criação de métodos de busca personalizados nas interfaces de repositório utilizando as convenções de nome do Spring Data JPA.
- **Java Streams & Enumerations (Enum):** Uso de Enums para categorizar os tipos de artistas e Streams para formatação e manipulação eficiente de coleções.

## Arquitetura e Modelagem de Dados

O projeto segue boas práticas de separação de responsabilidades para manter o código limpo:
- `model/`: Entidades JPA que mapeiam as tabelas do banco de dados (`Artista`, `Musica` e o Enum `TipoArtista`).
- `repository/`: Interfaces que estendem `JpaRepository`, responsáveis pelas consultas ao banco de dados utilizando Derived Queries.
- `principal/`: Classe de controle que gerencia a interface no terminal e dita as regras de negócio do sistema.

## Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/Guilherme-Miranda-Comitante/screen-sound-music-manager.git
   cd screen-sound-music-manager/screen-music
   ```
2. Abra o projeto no **IntelliJ IDEA** (ou outra IDE de sua preferência).
3. Configure as credenciais do seu banco de dados no arquivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/sua_base_de_dados
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```
4. Execute a classe principal da aplicação Spring Boot.

## Exemplo de Uso (Terminal)

```text
*** Screen Sound Músicas ***

1- Cadastrar artista
2- Cadastrar músicas
3- Listar músicas
4- Buscar músicas por artista

9 - Sair

Digite a opção desejada:
> 4

Digite o nome do artista que deseja pesquisar:
> Linkin Park

Músicas encontradas para o artista Linkin Park:
- In the End
- Numb
- Faint
```

---
Desafio desenvolvido com fins educacionais como parte do ecossistema de aprendizado da **Alura**.
