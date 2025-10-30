# language: pt
# encoding: utf-8

Funcionalidade: Pokemon

  Contexto:
    Dado que eu acesse a página do Pokemon

  Esquema do Cenário: 01 - Acessar Atacantes do Tipo <tipo>
    Quando eu acessar a tela de melhores atacantes do tipo "<tipo>"
    Então o título deve ser "<mensagemSucesso>"
    E o usuário deve ser encaminhado para uma nova url
      | url | <url> |

    Exemplos:
      | tipo    | mensagemSucesso                                  | url      |
      | lutador | Melhores Atacantes do tipo Lutador em Pokémon GO | fighting |
      | voador  | Melhores Atacantes do tipo Voador em Pokémon GO  | flying   |

  Esquema do Cenário: 02 - Pesquisar Pokemon <nome>
    Quando eu pesquisar "<nome>"
    Então os movimentos do pokemon serão apresentados
      | Primeiro Golpe | <primeiroGolpe> |
      | Segundo Golpe  | <segundoGolpe>  |

    Exemplos:
      | nome      | primeiroGolpe       | segundoGolpe     |
      | Pikachu   | Trovoada de Choques | Ataque Selvagem  |
      | Bulbasaur | Chicote de Vinha    | Chicote Poderoso |