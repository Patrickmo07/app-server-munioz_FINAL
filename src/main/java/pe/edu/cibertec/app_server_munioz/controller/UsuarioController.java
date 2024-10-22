package pe.edu.cibertec.app_server_munioz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.app_server_munioz.service.DetalleUsuarioServiceImpl;

@RestController
@RequestMapping("exm/auth")
public class UsuarioController {
    @Autowired
    private DetalleUsuarioServiceImpl detalleUsuarioService;

    @PostMapping("/registro")
    public void registerUser(
            @RequestParam("usuario")
            String usuario,
            @RequestParam("password")
            String password) {
        detalleUsuarioService.saveUsuario(usuario, password);
    }
}
