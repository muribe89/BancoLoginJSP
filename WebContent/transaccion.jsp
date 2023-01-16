<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>dashboard</title>
	<link rel="stylesheet" href="https://unpkg.com/bulmaswatch/default/bulmaswatch.min.css">
	<link rel="stylesheet" href="https://jenil.github.io/bulmaswatch/cerulean/bulmaswatch.min.css">	
  
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
    />
  </head>
  <body>
    <section class="hero is-primary is-fullheight">
      <div class="hero-body">
        <div class="container">
          <h1 class="title">Transferencia</h1>
          <div class="container ">
           <c:if test="${not empty sessionScope.persona}">
	            <h1>Nombre de usuario: ${sessionScope.persona.nombre}</h1>
	            <h1>Rut de usuario: ${sessionScope.persona.rut}</h1>
           </c:if>
          </div>
              <div class="box">
              <form action="transferencia" method="post">
              <input  class="input" type="hidden"  name="rut_emisor" value="${sessionScope.persona.rut}"/>
                <div class="field">
                  <label class="label">Rut Cliente</label>
                  <input class="input" type="text"  name="rut_cliente"/>
                </div>
                <div class="field">
                  <label class="label">Nombre cliente</label>
                  <input class="input" type="text"  name="nombre_cliente"/>
                </div>
                <div class="field">
                  <label class="label">Numero de cuenta</label>
                  <input class="input" type="text"  name="numero_cuenta" />
                </div>
                <div class="field">
                  <label class="label">Tipo de cuenta</label>
                  <div class="control">
                    <div class="select">
                      <select name="tipo_cuenta">
                        <option value="cuenta_corriente">Corriente</option>
                        <option value="cuenta_vista">Cuenta Vista</option>
                      </select>
                    </div>
                  </div>
                </div>
                <div class="field">
                  <label class="label">Seleccione un banco</label>
                  <div class="control">
                    <div class="select">
                      <select name="tipo_banco">
                        <option value="banco_estado">Banco Estado</option>
                        <option value="banco_chile">Banco Chile</option>
                        <option value="banco_bci">Banco BCI</option>
                      </select>
                    </div>
                  </div>
                </div>
                <div class="field">
                  <label class="label">Monto</label>
                  <input class="input" type="text" name="monto_transferencia" />
                </div>
                <button type="submit" class="button is-primary">Guardar</button>
                </form>
              </div>
        </div>
      </div>
    </section>
  </body>
</html>
