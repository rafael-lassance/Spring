package br.com.senac;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.domain.Aluno;
import br.com.senac.domain.Professor;
import br.com.senac.service.AlunoService;
import br.com.senac.service.ProfessorService;

@Component
public class Inicializacao implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	AlunoService alunoService;
	
	@Autowired
	ProfessorService professorService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Rafael");
		aluno1.setSobrenome("Martinez");		
		
		alunoService.salvar(aluno1);
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Pedro");
		aluno2.setSobrenome("Marques");
		
		alunoService.salvar(aluno2);
		
		List<Aluno> listaAlunos = alunoService.buscarTodosAlunos();
		
		for(Aluno aluno : listaAlunos) {
			System.out.println(aluno.getNome());			
		}
		
		
		Professor prof1 = new Professor();
		prof1.setNome("Joao");
		prof1.setSobrenome("da Silva");
		
		professorService.salvar(prof1);
		
		Professor prof2 = new Professor();
		prof2.setNome("Maria");
		prof2.setSobrenome("de Souza");
		
		professorService.salvar(prof2);
		
		List<Professor> listaProf = professorService.buscarTodosProfessores();
		
		for(Professor prof : listaProf) {
			System.out.println(prof.getNome());			
		}
		
	}
	
	
}
