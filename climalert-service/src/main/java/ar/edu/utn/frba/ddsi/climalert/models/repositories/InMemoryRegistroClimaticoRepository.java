package ar.edu.utn.frba.ddsi.climalert.models.repositories;
import ar.edu.utn.frba.ddsi.climalert.models.entities.RegistroClimatico;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryRegistroClimaticoRepository implements RegistroClimaticoRepository {

  private final List<RegistroClimatico> registros = new ArrayList<>();

  @Override
  public void guardar(RegistroClimatico registro) {

    registros.add(registro);

  }

  @Override
  public RegistroClimatico obtenerUltimo() {

    if(registros.isEmpty()) {
      return null;
    }

    return registros.get(registros.size() - 1);

  }

  @Override
  public List<RegistroClimatico> obtenerTodos() {

    return registros;

  }

}