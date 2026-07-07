package ar.edu.utn.frba.ddsi.climalert.models.entities;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class Alerta {

  private String mensaje;
  private LocalDateTime fechaHora;

  public Alerta(){
    this.fechaHora = LocalDateTime.now();
  }

  public Alerta(String mensaje){

    this.mensaje = mensaje;
    this.fechaHora = LocalDateTime.now();

  }

}