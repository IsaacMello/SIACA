package siaca.com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import siaca.com.br.entity.Turma;
import siaca.com.br.repository.TurmaRepository;

@Controller
public class TurmaController {
	
	@Autowired
	private TurmaRepository turmaRepo;
	
	@GetMapping("/cadastroTurma")
	public String showRegistrationFormTurma(Model model) {
		model.addAttribute("turma", new Turma());
		return "formularioCadastroTurma";
	}

	@GetMapping("/turmas")
	public String listTurmas(Model model) {
		List<Turma> listTurmas = turmaRepo.findAll();
		model.addAttribute("listTurmas", listTurmas);
		return "turmas";
	}
	
	@PostMapping("/registroTurma")
	public String processRegister(Turma turma) {
		turmaRepo.save(turma);
		return "cadastroTurmaSucesso";

	}
	

}
