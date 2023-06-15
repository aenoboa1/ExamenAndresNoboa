package ec.edu.espe.examenandresnoboa.service;


import ec.edu.espe.examenandresnoboa.model.Usuario;
import ec.edu.espe.examenandresnoboa.model.UsuarioPerfil;
import ec.edu.espe.examenandresnoboa.repository.UsuarioPerfilRepository;
import ec.edu.espe.examenandresnoboa.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioPerfilRepository usuarioPerfilRepository;


    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioPerfilRepository usuarioPerfilRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioPerfilRepository = usuarioPerfilRepository;
    }

    // write a method that list all Usuarios in a Perfil
    public List<UsuarioPerfil> listAllUsuariosInPerfil(Integer idPerfil){
        return this.usuarioPerfilRepository.findByCodUsuario(idPerfil);
    }

    @Transactional
    public Usuario createUsuario(Usuario usuario) {
        Usuario usuarioOpt = this.usuarioRepository.findByIdAndMail(usuario.getId(), usuario.getMail());
        if (usuarioOpt == null) {
            throw new RuntimeException("El email ya esta en uso");
        } else {
            return usuarioRepository.save(usuario);
        }
    }
    @Transactional
    public Usuario update(Usuario usuario){
        Optional<Usuario> usuarioOpt = this.usuarioRepository.findById(usuario.getId());
        if(usuarioOpt.isPresent())
        {
            Usuario usuarioTmp = usuarioOpt.get();
            usuarioTmp.setMail(usuario.getMail());
            usuarioTmp.setNombre(usuario.getNombre());
            usuarioTmp.setClave(usuario.getClave());
            usuarioTmp.setIntentosFallidos(usuario.getIntentosFallidos());
            usuarioTmp.setSueldo(usuario.getSueldo());
            this.usuarioRepository.save(usuarioTmp);
            return usuarioTmp;
        }
        else{
            throw new RuntimeException("No existe el usuario");
        }
    }

}
