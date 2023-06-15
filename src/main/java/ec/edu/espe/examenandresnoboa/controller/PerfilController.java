package ec.edu.espe.examenandresnoboa.controller;

import ec.edu.espe.examenandresnoboa.model.Perfil;
import ec.edu.espe.examenandresnoboa.service.PerfilService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;



@RestController
@RequestMapping("/api/v1/perfiles")
public class PerfilController {

    private final PerfilService perfilservice;
    public PerfilController(PerfilService perfilservice) {
        this.perfilservice = perfilservice;
    }

    @GetMapping
    public ResponseEntity<List<Perfil>> obtainByNombreOrderByNombre()  {
        List<Perfil> perfiles = this.perfilservice.obtainByNombreOrder();
        return ResponseEntity.ok(perfiles);
    }
    @PostMapping
    public ResponseEntity<Perfil> createPerfil(Perfil perfil) {
        try {
            Perfil perfil1 = this.perfilservice.createPerfil(perfil);
            return ResponseEntity.ok(perfil1);
        }catch (RuntimeException rte){
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping
    public ResponseEntity<Perfil> update(Perfil perfil) {
        try {
            Perfil perfil1 = this.perfilservice.update(perfil);
            return ResponseEntity.ok(perfil1);
        }catch (RuntimeException rte){
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("{codPerfil}")
    public ResponseEntity<Void> deletePerfil(@PathVariable(name="codPerfil") String codPerfil) {
        try {
            this.perfilservice.deletePerfil(codPerfil);
            return ResponseEntity.ok(null);
        }catch (RuntimeException rte){
            return ResponseEntity.badRequest().build();
        }
    }
}
