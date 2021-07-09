package siaca.com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import siaca.com.br.entity.Curso;
import siaca.com.br.repository.CursoRepository;

@Controller
public class CursoController {
	@Autowired
	private CursoRepository cursoRepo;

	@GetMapping("/cadastroCurso")
	public String showRegistrationFormCurso(Model model) {
		model.addAttribute("curso", new Curso());
		return "formularioCadastroCurso";
	}

	@GetMapping("/cursos")
	public String listCursos(Model model) {
		List<Curso> listCursos = cursoRepo.findAll();
		model.addAttribute("listCursos", listCursos);
		return "cursos";
	}

	@PostMapping("/registroCurso")
	public String processRegister(Curso curso) {
		cursoRepo.save(curso);
		return "cadastroCursoSucesso";

	}

}
