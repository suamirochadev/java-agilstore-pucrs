# AgilStore Inventory Management

Este projeto é uma aplicação em Java para gerenciar o inventário da AgilStore, uma loja de eletrônicos. Ele permite adicionar, listar, atualizar, excluir e buscar produtos no inventário de forma eficiente, seguindo os princípios SOLID.

Os comentários estão em inglês assim como o código para manter a colaboração internacional.

## Funcionalidades

- Adicionar Produto: Permite inserir um novo produto com ID gerado automaticamente.

- Listar Produtos: Mostra todos os produtos com opções de filtragem e ordenação.

- Atualizar Produto: Atualiza informações de um produto existente.

- Excluir Produto: Remove produtos obsoletos do inventário.

- Buscar Produto: Busca produtos pelo ID ou nome.

- Persistência: Salva os dados em um arquivo JSON para garantir a continuidade dos dados.

## Requisitos do Sistema

- Java: JDK 8 ou superior.

- Biblioteca Gson: Para manipulação de JSON.

- Sistema Operacional: Compatível com Windows, Linux e macOS.

### Configuração do Ambiente Local

#### 1. Instale o Java

Certifique-se de que o Java está instalado no sistema.

Para Linux

Instalação do Java:
```
sudo apt update
sudo apt install default-jdk

```

Verifique a instalação:
```
java -version


```
Para Windows

Baixe o instalador do JDK no site oficial da Oracle: https://www.oracle.com/java/technologies/javase-downloads.html.

Siga as instruções do instalador para configurar o JDK.

Configure a variável de ambiente JAVA_HOME:

Clique com o botão direito em "Este Computador" > "Propriedades" > "Configurações Avançadas do Sistema".

Clique em "Variáveis de Ambiente".

Adicione ou edite a variável JAVA_HOME apontando para a pasta de instalação do JDK.

Adicione ao PATH:
```
%JAVA_HOME%\bin


```
Verifique a instalação no terminal (Prompt de Comando ou PowerShell):
```
java -version


```

#### 2. Baixe a Biblioteca Gson

Acesse o repositório oficial do Maven ou use o comando abaixo para baixar a versão mais recente:

Para Linux
```
wget https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar


```
Para Windows

Baixe diretamente pelo navegador: Gson 2.10.1.

Mova o arquivo para o diretório lib/ dentro do projeto.

#### 3. Estrutura de Diretórios

Certifique-se de que a estrutura de diretórios está como abaixo:
```

AgilStore/
├── src/
│   ├── model/
│   │   └── Product.java
│   ├── service/
│   │   └── ProductService.java
│   └── main/
│       └── App.java
├── lib/
│   └── gson-2.10.1.jar
└── README.md

```

#### 4. Compilar o Projeto

Use o seguinte comando para compilar os arquivos Java:

Para Linux
```
javac -cp .:lib/gson-2.10.1.jar src/main/App.java


```
Para Windows

No Prompt de Comando ou PowerShell, use:
```
javac -cp .;lib\gson-2.10.1.jar src\main\App.java


```

#### 5. Executar o Projeto

Para Linux
```
java -cp .:lib/gson-2.10.1.jar src/main/App


```
Para Windows
```
java -cp .;lib\gson-2.10.1.jar src\main\App


```

## Uso da Aplicação

### Adicionar Produto:

Insira os dados solicitados no terminal.

### Listar Produtos:

Escolha listar todos os produtos, filtrar por categoria ou ordenar por nome, quantidade ou preço.

### Atualizar Produto:

Informe o ID do produto e atualize os campos desejados.

### Excluir Produto:

Confirme a exclusão de um produto específico pelo ID.

### Buscar Produto:

Forneça o ID ou o nome (ou parte dele) para buscar detalhes do produto.

### Testando a Aplicação

Para verificar a funcionalidade básica, use o seguinte código de teste no terminal:
```
import com.google.gson.Gson;

public class TestApp {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String json = gson.toJson(new String[]{"Teste", "Produto"});
        System.out.println(json);
    }
}
```

Para Linux

Compile e execute com:

```
javac -cp .:lib/gson-2.10.1.jar TestApp.java
java -cp .:lib/gson-2.10.1.jar TestApp

```

Para Windows

Compile e execute com:
```
javac -cp .;lib\gson-2.10.1.jar TestApp.java
java -cp .;lib\gson-2.10.1.jar TestApp

```

## Licença

Este projeto é de uso livre e aberto para melhorias. Feedbacks são bem-vindos!

Agora você pode gerenciar o inventário da AgilStore de forma eficiente e confiável. 🚀

Desenvolvido por [Suami Rocha](https://bento.me/suamirochadev) em 04/01/2025 às 03:07am
