package ec.edu.espe.examenandresnoboa.repository;

import ec.edu.espe.examenandresnoboa.model.UsuarioPerfil;
import ec.edu.espe.examenandresnoboa.model.UsuarioPerfilPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfil, UsuarioPerfilPK> {

    UsuarioPerfil findByCodUsuarioAndCodPerfil(Integer codUsuario, String codPerfil);
    List<UsuarioPerfil> findByCodUsuario(Integer codUsuario);

}