package ec.edu.espe.examenandresnoboa.controller;

import ec.edu.espe.examenandresnoboa.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioservice;


    public UsuarioController(UsuarioService usuarioservice) {
        this.usuarioservice = usuarioservice;
    }
}
