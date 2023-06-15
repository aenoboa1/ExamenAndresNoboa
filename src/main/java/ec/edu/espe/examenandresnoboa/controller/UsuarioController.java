package ec.edu.espe.examenandresnoboa.controller;

import ec.edu.espe.examenandresnoboa.model.Usuario;
import ec.edu.espe.examenandresnoboa.model.UsuarioPerfil;
import ec.edu.espe.examenandresnoboa.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioservice;


    public UsuarioController(UsuarioService usuarioservice) {
        this.usuarioservice = usuarioservice;
    }


    @GetMapping("{perfilid}")
    public ResponseEntity<List<UsuarioPerfil>> obtainUsuarios(
            @PathVariable(name="perfilid") String codPerfil
    )  {
        List<UsuarioPerfil> usuarios = this.usuarioservice.listAllUsuariosInPerfil(codPerfil);
        return ResponseEntity.ok(usuarios);
    }
    // method that creates a new Usuario
    @GetMapping("{codUsuario}")
    public ResponseEntity<Usuario> createUsuario(Usuario usuario) {
        try {
            Usuario usuario1 = this.usuarioservice.createUsuario(usuario);
            return ResponseEntity.ok(usuario1);
        }catch (RuntimeException rte){
            return ResponseEntity.badRequest().build();
        }
    }
    // method that updates a Usuario
    @PutMapping
    public ResponseEntity<Usuario> update(Usuario usuario) {
        try {
            Usuario usuario1 = this.usuarioservice.update(usuario);
            return ResponseEntity.ok(usuario1);
        }catch (RuntimeException rte){
            return ResponseEntity.badRequest().build();
        }
    }
    // method that deletes a Usuario
    @DeleteMapping("{codUsuario}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable(name="codUsuario") Integer codUsuario) {
        try {
            this.usuarioservice.deleteUsuario(codUsuario);
            return ResponseEntity.ok(null);
        }catch (RuntimeException rte){
            return ResponseEntity.badRequest().build();
        }
    }


}
