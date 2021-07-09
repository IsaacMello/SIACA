package siaca.com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import siaca.com.br.entity.Matricula;
import siaca.com.br.repository.MatriculaRepository;

@Controller
public class MatriculaController {
	@Autowired
	private MatriculaRepository matriculaRepo;
	
	
	@GetMapping("/cadastroMatricula")
	public String showRegistrationFormMatricula(Model model) {
		model.addAttribute("matricula", new Matricula());
		return "formularioMatricula"; 
	}

	@GetMapping("/matriculas")
	public String listMatriculas(Model model) {
		List<Matricula> listMatriculas = matriculaRepo.findAll();
		model.addAttribute("listMatriculas", listMatriculas);
		return "matriculas";
	}
	
	@PostMapping("/registroMatricula")
	public String processRegister(Matricula matricula) {
		matriculaRepo.save(matricula);
		return "comprovanteMatricula";

	}

}
