package ar.edu.utn.frba.ddsi.climalert.services;




import ar.edu.utn.frba.ddsi.climalert.models.entities.Alerta;
import ar.edu.utn.frba.ddsi.climalert.models.entities.RegistroClimatico;
import ar.edu.utn.frba.ddsi.climalert.models.repositories.AlertaRepository;
import ar.edu.utn.frba.ddsi.climalert.models.repositories.RegistroClimaticoRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AlertaService {

  private final RegistroClimaticoRepository registroRepository;

  private final AlertaRepository alertaRepository;

  private final NotificacionService notificacionService;

  private static final Logger logger = LoggerFactory.getLogger(AlertaService.class);

  public AlertaService(RegistroClimaticoRepository registroRepository, AlertaRepository alertaRepository, NotificacionService notificacionService){

    this.registroRepository = registroRepository;
    this.alertaRepository = alertaRepository;
    this.notificacionService = notificacionService;

  }

  @Scheduled(cron = "0 * * * * *")
  public void procesarAlertas(){

    logger.info("==== REVISANDO ALERTAS ====");

    RegistroClimatico registro = registroRepository.obtenerUltimo();

    if(registro == null){
      return;
    }

    logger.info("Evaluando: {} °C - {} %", registro.getTemperatura(), registro.getHumedad());

    if(registro.getTemperatura() > 35 && registro.getHumedad() > 60){

      logger.info("CONDICION DE ALERTA DETECTADA");

      Alerta alerta = new Alerta("Temperatura y humedad elevadas");

      alertaRepository.guardar(alerta);

      notificacionService.enviarAlerta(alerta, registro);
    }
    else{

      logger.info("No se requiere alerta");

    }

  }

}