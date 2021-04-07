package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Aluno;
import br.com.senac.service.AlunoService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	
	
	@GetMapping("/listaAlunos")
	public ModelAndView listaTodosAlunos() {
		
		ModelAndView mv = new ModelAndView("aluno/paginaListaAlunos");
		mv.addObject("alunos", alunoService.buscarTodosAlunos());
		return mv;
		
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarAlunos() {
		
		ModelAndView mv = new ModelAndView("aluno/cadastraAluno");
		mv.addObject("aluno", new Aluno() );
		return mv;
		
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarAluno(Aluno aluno) {
		
		alunoService.salvar(aluno);
		return listaTodosAlunos();
	}
	
	@GetMapping("/alterar/{idAluno}")
	public ModelAndView alterarAluno(@PathVariable("idAluno") Integer idAluno) throws ObjectNotFoundException{
		
		Aluno aluno = alunoService.buscaPorId(idAluno);
		
		ModelAndView mv = new ModelAndView("aluno/alteraAluno");
		mv.addObject("aluno", aluno );
		return mv;
		
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterarAluno(Aluno aluno) throws ObjectNotFoundException {
		
		alunoService.salvarAlteracao(aluno);
		return listaTodosAlunos();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluirAluno(@PathVariable("id") Integer id) {
		alunoService.excluir(id);
		return listaTodosAlunos();
	}
	
	
}
