package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Aluno;
import br.com.senac.domain.Professor;
import br.com.senac.service.ProfessorService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("professor")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;
	
	
	@GetMapping("/listaProfessores")
	public ModelAndView listaTodosProfessores() {
		
		ModelAndView mv = new ModelAndView("professor/paginaListaProfessores");
		mv.addObject("professores", professorService.buscarTodosProfessores());
		return mv;
		
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarProfessores() {
		
		ModelAndView mv = new ModelAndView("professor/cadastraProfessor");
		mv.addObject("professor", new Professor() );
		return mv;
		
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarProfessor(Professor professor) {
		
		professorService.salvar(professor);
		return listaTodosProfessores();
	}
	
	@GetMapping("/alterar/{idProfessor}")
	public ModelAndView alterarProfessor(@PathVariable("idProfessor") Integer idProfessor) throws ObjectNotFoundException{
		
		Professor professor = professorService.buscaPorId(idProfessor);
		
		ModelAndView mv = new ModelAndView("professor/alteraProfessor");
		mv.addObject("professor", professor );
		return mv;
		
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterarProfessor(Professor professor) throws ObjectNotFoundException {
		
		professorService.salvarAlteracao(professor);
		return listaTodosProfessores();
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView excluirProfessor(@PathVariable("id") Integer id) {
		professorService.excluir(id);
		return listaTodosProfessores();
	}
	
	
}
