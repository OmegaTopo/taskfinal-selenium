#language: pt

  Funcionalidade: Login


    Contexto: Validar funcionalidade de login

    @wip
    Esquema do Cenario: Validar login preenchendo username e senha validos
      Dado que preencho o campo username com <username>
      E que preencho o campo senha com <senha>
      Quando clico em login
      Entao devo validar o titulo <tituloValidador> na pagina

      Exemplos:
      |   username       |  senha         |   tituloValidador  |
      |   standart_user  |  secret_sauce  |   Swag Labs        |