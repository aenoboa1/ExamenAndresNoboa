package ec.edu.espe.examenandresnoboa.repository;

import ec.edu.espe.examenandresnoboa.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface PerfilRepository extends JpaRepository<Perfil, String> {

    List<Perfil> findAllByOrderByNombreAsc();

}