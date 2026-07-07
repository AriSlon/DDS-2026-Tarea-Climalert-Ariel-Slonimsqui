package ar.edu.utn.frba.ddsi.climalert.models.entities;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class RegistroClimatico {

  private String ciudad;

  private double temperatura;

  private int humedad;

  private String condicion;

  private double sensacionTermica;

  private double velocidadViento;

  private LocalDateTime fechaHora;

  public RegistroClimatico(){

    this.fechaHora = LocalDateTime.now();

  }

  public RegistroClimatico(String ciudad, double temperatura, int humedad, String condicion, double sensacionTermica, double velocidadViento){

    this.ciudad = ciudad;
    this.temperatura = temperatura;
    this.humedad = humedad;
    this.condicion = condicion;
    this.sensacionTermica = sensacionTermica;
    this.velocidadViento = velocidadViento;
    this.fechaHora = LocalDateTime.now();

  }

}