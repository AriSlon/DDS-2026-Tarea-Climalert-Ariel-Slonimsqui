package ar.edu.utn.frba.ddsi.climalert.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConditionDTO {

  private String text;

  public ConditionDTO() {
  }

  public ConditionDTO(String text) {
    this.text = text;
  }
}