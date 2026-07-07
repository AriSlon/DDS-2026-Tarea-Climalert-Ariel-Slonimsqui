package ar.edu.utn.frba.ddsi.climalert.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherApiResponseDTO {

  private LocationDTO location;

  private CurrentDTO current;

  public WeatherApiResponseDTO() {
  }

  public WeatherApiResponseDTO(LocationDTO location,
                               CurrentDTO current) {

    this.location = location;
    this.current = current;
  }
}