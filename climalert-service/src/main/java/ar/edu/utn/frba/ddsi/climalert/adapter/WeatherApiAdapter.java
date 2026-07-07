package ar.edu.utn.frba.ddsi.climalert.adapter;


import ar.edu.utn.frba.ddsi.climalert.dto.WeatherApiResponseDTO;
import ar.edu.utn.frba.ddsi.climalert.models.entities.RegistroClimatico;

import org.springframework.stereotype.Component;



@Component
public class WeatherApiAdapter {


  public RegistroClimatico convertir(WeatherApiResponseDTO response) {

    RegistroClimatico registro = new RegistroClimatico();

    registro.setCiudad(response.getLocation().getName());

    registro.setTemperatura(response.getCurrent().getTemperatura());

    registro.setHumedad(response.getCurrent().getHumidity());

    registro.setCondicion(response.getCurrent().getCondition().getText());

    registro.setSensacionTermica(response.getCurrent().getSensacionTermica());

    registro.setVelocidadViento(response.getCurrent().getVelocidadViento());

    return registro;

  }

}