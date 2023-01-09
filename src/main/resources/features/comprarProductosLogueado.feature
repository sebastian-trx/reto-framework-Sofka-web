#language: es
  @FeatureName:comprarProductosLogueado
  Característica: comprar productos estando logeado
    probar el carro de compras involucrando
    la compra de productos con usuario logeado

  @ScenarioName:comprarProductosEstandoLogeado
  Escenario: comprar exitosa estando logeado
    Dado que el cliente esta en la pagina de inicio
    Cuando se registra y queda logeado
    Y realiza una compra
    Entonces el sistema responde con los datos correctos del usuario


  @ScenarioName:compraFallidaDeProductosEstandoLogeado
  Escenario: compra fallida estando logeado
    Dado que el cliente esta en la pagina de inicio
    Cuando se registra y queda logeado
    Y realiza la compra llenando algunos campos del formulario de detalles de pago
    Entonces el sistema mostrara un mensaje en los campos obligatorios vacios

