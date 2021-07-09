package siaca.com.br.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import siaca.com.br.entity.Usuario;
import siaca.com.br.repository.UsuarioRepository;
 
public class CustomUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UsuarioRepository userRepo;
     
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = userRepo.findByCpf(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuário não encontrado!!");
        }
        return new CustomUserDetails(user);
    }
 
}