package ar.edu.utn.frba.ddsi.climalert.models.repositories;

import java.util.List;
import ar.edu.utn.frba.ddsi.climalert.models.entities.Alerta;

public interface AlertaRepository {

  void guardar(Alerta alerta);

  List<Alerta> obtenerTodas();

}