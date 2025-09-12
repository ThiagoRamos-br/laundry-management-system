# Sistema de Gerenciamento de Lavanderia

Este é um projeto simples em Java que simula o sistema de gerenciamento de uma lavanderia, permitindo o registro de clientes, a adição de peças de roupa e o cálculo do valor total do serviço. O projeto utiliza programação orientada a objetos para organizar as funcionalidades e garantir um código limpo e modular.

---

## 🚀 Como Executar

Para rodar a aplicação, certifique-se de ter um ambiente de desenvolvimento Java (JDK) instalado.

1.  **Clone o repositório:**
    ```
    git clone [URL_DO_SEU_REPOSITORIO]
    ```
2.  **Compile o projeto:**
    ```
    javac Main.java
    ```
3.  **Execute o programa:**
    ```
    java Main
    ```

---

## ✨ Funcionalidades

O programa oferece as seguintes funcionalidades principais:

* **Registro de Clientes:** Permite registrar um novo cliente com nome, CPF e telefone.
* **Adição de Peças:** Adiciona múltiplas peças de roupa ao serviço do cliente, com informações como tipo, cor e marca.
* **Escolha do Serviço:** Permite selecionar o tipo de lavagem (Normal, A Seco, Delicada).
* **Cálculo do Total:** Calcula o valor final do serviço somando o custo de todas as peças ao preço base do tipo de lavagem escolhido.
* **Geração de Recibo:** No final da execução, um resumo do serviço é exibido, incluindo informações do cliente, tipo de serviço, produtos e o valor total.

---

## 📁 Estrutura do Projeto

O projeto é organizado em pacotes para melhor separação das responsabilidades:

* `model.Program`: Contém a classe principal (`Main.java`) que inicia a aplicação e interage com o usuário.
* `model.entities`: Armazena as classes que representam as entidades do negócio:
    * `Client.java`: Representa um cliente da lavanderia.
    * `Product.java`: Representa uma peça de roupa.
    * `PieceValue.java`: Associa um produto a um valor, permitindo calcular o custo de cada peça.
* `model.enums`: Contém a classe `laundryServices.java`, um `enum` que define os tipos de serviços de lavagem disponíveis, cada um com sua descrição e preço base.
* `model.Exception.Domain`: Contém a classe de exceção personalizada (`LaundryException.java`) para tratar erros específicos do domínio da aplicação.
* `model.Service`: Contém a classe `PaymentService.java` que gerencia toda a lógica de negócio do pagamento, incluindo a lista de peças e o cálculo do valor total.
* `model.Service.ServiceInterface`: Uma interface para definir os contratos do serviço.

---

## 🛠️ Tecnologias Utilizadas

* **Java:** Linguagem de programação principal.
* **Orientação a Objetos (POO):** Usada para estruturar o código de forma modular e reutilizável.
* **Manipulação de Exceções:** Implementada para lidar com entradas inválidas e outras falhas.

---

## ✒️ Autor

Seu Nome
