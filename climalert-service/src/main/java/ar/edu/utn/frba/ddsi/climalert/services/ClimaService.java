package ar.edu.utn.frba.ddsi.climalert.services;


import ar.edu.utn.frba.ddsi.climalert.adapter.WeatherApiAdapter;
import ar.edu.utn.frba.ddsi.climalert.client.WeatherApiClient;
import ar.edu.utn.frba.ddsi.climalert.config.WeatherApiConfig;
import ar.edu.utn.frba.ddsi.climalert.dto.WeatherApiResponseDTO;

import ar.edu.utn.frba.ddsi.climalert.models.entities.RegistroClimatico;
import ar.edu.utn.frba.ddsi.climalert.models.repositories.RegistroClimaticoRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ClimaService {

  private final WeatherApiClient weatherApiClient;

  private final WeatherApiAdapter weatherApiAdapter;

  private final RegistroClimaticoRepository registroRepository;

  private final WeatherApiConfig weatherApiConfig;

  private static final Logger logger =
      LoggerFactory.getLogger(ClimaService.class);

  public ClimaService(WeatherApiClient weatherApiClient, WeatherApiAdapter weatherApiAdapter, RegistroClimaticoRepository registroRepository, WeatherApiConfig weatherApiConfig){

    this.weatherApiClient = weatherApiClient;
    this.weatherApiAdapter = weatherApiAdapter;
    this.registroRepository = registroRepository;
    this.weatherApiConfig = weatherApiConfig;

  }


  @Scheduled(cron = "0 */5 * * * *")
  public void actualizarClima(){

    logger.info("==== CONSULTANDO CLIMA ====");

    String url = construirUrl();

    logger.info("URL utilizada: {}", url);

    WeatherApiResponseDTO response = weatherApiClient.obtenerClima(url);

    logger.info("Respuesta recibida de WeatherAPI");

    logger.info("Ciudad: {}", response.getLocation().getName());

    logger.info("Temperatura: {} °C", response.getCurrent().getTemperatura());

    logger.info("Sensación térmica: {} °C", response.getCurrent().getSensacionTermica());

    logger.info("Humedad: {} %", response.getCurrent().getHumidity());

    logger.info("Viento: {} km/h", response.getCurrent().getVelocidadViento());

    logger.info("Condición: {}", response.getCurrent().getCondition().getText());

    RegistroClimatico registro = weatherApiAdapter.convertir(response);

    registroRepository.guardar(registro);

    logger.info("Registro guardado correctamente");

  }



  private String construirUrl(){

    return weatherApiConfig.getUrl()
        + "?key="
        + weatherApiConfig.getKey()
        + "&q="
        + weatherApiConfig.getCiudad()
        + "&lang=es";

  }

}