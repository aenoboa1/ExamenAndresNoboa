package ec.edu.espe.examenandresnoboa.service;

import ec.edu.espe.examenandresnoboa.model.Perfil;
import ec.edu.espe.examenandresnoboa.model.Usuario;
import ec.edu.espe.examenandresnoboa.model.UsuarioPerfil;
import ec.edu.espe.examenandresnoboa.repository.PerfilRepository;
import ec.edu.espe.examenandresnoboa.repository.UsuarioPerfilRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PerfilService {

    private final PerfilRepository perfilRepository;
    private final UsuarioPerfilRepository usuarioPerfilRepository;

    public PerfilService(PerfilRepository perfilRepository, UsuarioPerfilRepository usuarioPerfilRepository) {
        this.perfilRepository = perfilRepository;
        this.usuarioPerfilRepository = usuarioPerfilRepository;
    }
    public List<Perfil> obtainByNombreOrder() {
        return this.perfilRepository.findAllByOrderByNombreAsc();
    }

    @Transactional
    public Perfil createPerfil(Perfil perfil) {
        Optional<Perfil> PerfilOpt = this.perfilRepository.findById(perfil.getCodPerfil());
        if(PerfilOpt == null) {
            throw new RuntimeException("El perfil ya existe");
        }else {
            return perfilRepository.save(perfil);
        }
    }

}
