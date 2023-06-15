package ec.edu.espe.examenandresnoboa.repository;

import ec.edu.espe.examenandresnoboa.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByIdAndMail(Integer id, String mail);
}