package ar.edu.utn.frba.ddsi.climalert.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrentDTO {

  @JsonProperty("temp_c")
  private double temperatura;

  private int humidity;

  @JsonProperty("feelslike_c")
  private double sensacionTermica;

  @JsonProperty("wind_kph")
  private double velocidadViento;

  private ConditionDTO condition;

  public CurrentDTO() {
  }

  public CurrentDTO(double temperatura, int humidity, double sensacionTermica, double velocidadViento, ConditionDTO condition) {

    this.temperatura = temperatura;
    this.humidity = humidity;
    this.sensacionTermica = sensacionTermica;
    this.velocidadViento = velocidadViento;
    this.condition = condition;

  }
}