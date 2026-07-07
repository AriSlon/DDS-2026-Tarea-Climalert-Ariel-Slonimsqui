package ar.edu.utn.frba.ddsi.climalert.config;


import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "weather.api")
public class WeatherApiConfig {

  private String key;

  private String url;

  private String ciudad;


}