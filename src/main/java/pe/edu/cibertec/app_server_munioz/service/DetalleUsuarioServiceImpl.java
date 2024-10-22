package pe.edu.cibertec.app_server_munioz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.app_server_munioz.model.Usuario;
import pe.edu.cibertec.app_server_munioz.repository.UsuarioRepository;

@RequiredArgsConstructor
@Service
public class DetalleUsuarioServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username){
        Usuario usuario = usuarioRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username + "Este usuario no existe X"));
        return org.springframework.security.core.userdetails.User.withUsername(usuario.getCodigo()).password(usuario.getPassword()).build();
    }
    public void saveUsuario(String username, String password) {
        Usuario usuario = new Usuario();
        usuario.setCodigo(username);
        usuario.setPassword(passwordEncoder.encode(password));
        usuarioRepository.save(usuario);
    }
}
