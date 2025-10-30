# 🧪 Projeto de Testes Web - Pokémon GO (Cucumber + Selenium)

## 📋 Descrição
Este projeto foi desenvolvido com o objetivo de automatizar testes funcionais na **interface web do site Pokémon GO**, utilizando o framework **Cucumber** com **BDD (Behavior Driven Development)**.

Os cenários foram escritos em **Gherkin**, promovendo uma comunicação clara entre as áreas técnicas e de negócio.

---

## 🚀 Funcionalidades Testadas

- 🔍 **Pesquisa de Pokémon**  
  - Pesquisa por nome.  
  - Pesquisa por tipo (voador, elétrico, etc).  
  - Pesquisa por ataque mais forte.  
  - Verificação do primeiro e segundo ataque.

- 🖱️ **Eventos de Interação**
  - Clique em botões e links.  
  - Rolagem da página para exibição de elementos.  
  - Espera explícita até o carregamento de elementos para garantir estabilidade nos testes.

---

## ⚙️ Tecnologias Utilizadas

- ☕ **Java 21**
- 🧩 **Cucumber**
- 🌐 **Selenium WebDriver**
- 🧱 **JUnit** (ou TestNG, conforme configuração)
- 🧭 **Maven**
- 🧾 **Gherkin (Given/When/Then)**

---

## 🧩 Exemplo de Cenário (Gherkin)

```gherkin
Funcionalidade: Pesquisa de Pokémon por tipo e ataque

  Cenário: Buscar Pokémon do tipo voador com ataque mais forte
    Dado que o usuário acessa o site do Pokémon GO
    Quando ele pesquisa por Pokémon do tipo "voador"
    E seleciona o Pokémon com o ataque mais forte
    Então o sistema deve exibir os detalhes do primeiro e segundo ataque

  Cenário: Rolagem e espera para evento
    Dado que o usuário está na página inicial
    Quando ele rola a página até o final
    E espera o carregamento do próximo evento
    Então o evento deve ser exibido corretamente


## ⚙️ Tecnologias Utilizadas

- ☕ **Java 21**
- 🧩 **Cucumber**
- 🌐 **Selenium WebDriver**
- 🧱 **JUnit** (ou TestNG, conforme configuração)
- 🧭 **Maven**
- 🧾 **Gherkin (Given/When/Then)**
