package ar.edu.utn.frba.ddsi.climalert.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDTO {

  private String name;

  public LocationDTO() {
  }

  public LocationDTO(String name) {
    this.name = name;
  }
}