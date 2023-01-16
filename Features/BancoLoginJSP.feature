Feature: Realizacion de casos ingresando nombre de usuario y contraseña

  Scenario: Ingresar nombre de usuario y contraseña correctos.
    Given Abrir Chrome
    When el usuario ingresa Username "muribe" y Password "12345" correctos.
    Then Entonces se le da la bienvenida al sitio "dashboard"
		And Cierra el navegador
		
  Scenario: Ingresar nombre de usuario y contraseña incorrecto.
    Given Abrir Chrome
    When el usuario ingresa ingresa Username "userincorrecto" y Password "passwordincorrecto" incorrectos
    Then Entonces debería mostrar error de "Credenciales invalidas!"
		And Cierra el navegador
		
  Scenario: Ingresar valores vacíos.
    Given Abrir Chrome
    When el usuario ingresa ingresa Username y Password vacios
    Then Entonces debería mostrar error de "Inserte Username y Password!"
		And Cierra el navegador