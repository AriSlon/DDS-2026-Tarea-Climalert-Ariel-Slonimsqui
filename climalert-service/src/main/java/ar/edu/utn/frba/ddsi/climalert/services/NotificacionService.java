package ar.edu.utn.frba.ddsi.climalert.services;


import ar.edu.utn.frba.ddsi.climalert.adapter.MailAdapter;


import ar.edu.utn.frba.ddsi.climalert.models.entities.Alerta;
import ar.edu.utn.frba.ddsi.climalert.models.entities.RegistroClimatico;
import org.springframework.stereotype.Service;



@Service
public class NotificacionService {


  private final MailAdapter mailAdapter;



  public NotificacionService(
      MailAdapter mailAdapter
  ){

    this.mailAdapter = mailAdapter;

  }



  public void enviarAlerta(
      Alerta alerta,
      RegistroClimatico registro
  ){


    String asunto =
        "Alerta climática detectada";



    String mensaje = construirMensaje(
        alerta,
        registro
    );



    mailAdapter.enviar(
        "destinatario@gmail.com",
        asunto,
        mensaje
    );

  }



  private String construirMensaje(
      Alerta alerta,
      RegistroClimatico registro
  ){


    return """
                ALERTA CLIMÁTICA

                Motivo:
                %s


                Detalle del clima:

                Ciudad: %s

                Temperatura: %.2f °C

                Sensación térmica: %.2f °C

                Humedad: %d %%

                Velocidad del viento: %.2f km/h

                Condición: %s

                Fecha:
                %s

                """.formatted(
        alerta.getMensaje(),
        registro.getCiudad(),
        registro.getTemperatura(),
        registro.getSensacionTermica(),
        registro.getHumedad(),
        registro.getVelocidadViento(),
        registro.getCondicion(),
        registro.getFechaHora()
    );


  }

}