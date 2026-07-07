package ar.edu.utn.frba.ddsi.climalert.models.repositories;
import ar.edu.utn.frba.ddsi.climalert.models.entities.Alerta;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class InMemoryAlertaRepository implements AlertaRepository {

  private final List<Alerta> alertas = new ArrayList<>();

  @Override
  public void guardar(Alerta alerta) {

    alertas.add(alerta);

  }

  @Override
  public List<Alerta> obtenerTodas() {

    return alertas;

  }

}