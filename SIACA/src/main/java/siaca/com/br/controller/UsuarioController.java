package siaca.com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import siaca.com.br.entity.Usuario;
import siaca.com.br.repository.UsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("")
	public String viewPaginaInicial() {
		return "index";
	}

	@GetMapping("/cadastro")
	public String showRegistrationForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "formularioCadastro";
	}

	@PostMapping("/registroCadastro")
	public String processRegister(Usuario usuario) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(encodedPassword);
		usuarioRepository.save(usuario);

		return "cadastroSucesso";

	}

	@GetMapping("/usuarios")
	public String listUsers(Model model) {
		List<Usuario> listUsers = usuarioRepository.findAll();
		model.addAttribute("listUsers", listUsers);
		return "usuarios";
	}
	
	@GetMapping("/aluno")
	public String viewAluno() {
		return "aluno";
	}

}
