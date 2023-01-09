#language:es
  @FeatureName:contactUs
  Característica:contact Us

    dejar una consulta en la caja
    de comentarios en el apartado
    de contact Us

  @ScenarioName:dejarUnaConsultaEnContactUsLlenandoTodosLosCampos
  Escenario: dejar una consulta en contactUs llenando todos los campos
    Dado que el cliente esta en la pagina de inicio
    Cuando se dirige al apartado de contactUs
    Y diligencia todos los campos
    Entonces la pagina muestra un mensaje exitoso

  @ScenarioName:hacerUnaConsultaEnContactUsDejandoCamposVacios
  Escenario: hacer una consulta en contactUs dejando campos vacios
    Dado que el cliente esta en la pagina de inicio
    Cuando se dirige al apartado de contactUs
    Y diligencia algunos los campos
    Entonces la pagina muestra un mensajes de advertencia