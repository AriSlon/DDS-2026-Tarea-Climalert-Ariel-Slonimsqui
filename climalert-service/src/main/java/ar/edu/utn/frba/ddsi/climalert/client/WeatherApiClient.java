package ar.edu.utn.frba.ddsi.climalert.client;


import ar.edu.utn.frba.ddsi.climalert.dto.WeatherApiResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Component
public class WeatherApiClient {

  private final RestTemplate restTemplate;

  public WeatherApiClient(){

    this.restTemplate = new RestTemplate();

  }

  public WeatherApiResponseDTO obtenerClima(String url){

    return restTemplate.getForObject(url, WeatherApiResponseDTO.class);

  }

}