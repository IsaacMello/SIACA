package siaca.com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import siaca.com.br.entity.Disciplina;
import siaca.com.br.repository.DisciplinaRepository;

@Controller
public class DisciplinaController {
	@Autowired
	private DisciplinaRepository disciplinaRepo;

	@GetMapping("/cadastroDisciplina")
	public String showRegistrationFormDisciplina(Model model) {
		model.addAttribute("disciplina", new Disciplina());
		return "formularioCadastroDisciplina";
	}

	@GetMapping("/disciplinas")
	public String listDisciplinas(Model model) {
		List<Disciplina> listDisciplinas = disciplinaRepo.findAll();
		model.addAttribute("listDisciplinas", listDisciplinas);
		return "disciplinas";
	}

	@PostMapping("/registroDisciplina")
	public String processRegister(Disciplina disciplina) {
		disciplinaRepo.save(disciplina);
		return "cadastroDisciplinaSucesso";
	}
	
	
	

}
