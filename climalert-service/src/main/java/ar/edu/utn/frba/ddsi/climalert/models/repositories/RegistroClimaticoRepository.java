package ar.edu.utn.frba.ddsi.climalert.models.repositories;


import java.util.List;

import ar.edu.utn.frba.ddsi.climalert.models.entities.RegistroClimatico;


public interface RegistroClimaticoRepository {

  void guardar(RegistroClimatico registro);

  RegistroClimatico obtenerUltimo();

  List<RegistroClimatico> obtenerTodos();

}