package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Aluno;
import br.com.senac.domain.Professor;
import br.com.senac.repository.ProfessorRepositorio;
import javassist.tools.rmi.ObjectNotFoundException;


@Service
public class ProfessorService {
	
	@Autowired
	ProfessorRepositorio repoProfessor;
	
	public Professor salvar(Professor professor) {
		
		return repoProfessor.save(professor);
	}
	
	public List<Professor> buscarTodosProfessores(){
		
		return repoProfessor.findAll();
	}
	
	public Professor buscaPorId(Integer idProfessor) throws ObjectNotFoundException{
		
		 Optional<Professor> professor = repoProfessor.findById(idProfessor);
		 return professor.orElseThrow( () -> new ObjectNotFoundException("Professor não encontrado: " + idProfessor) );
		
	}
	
	public Professor salvarAlteracao (Professor professorAlterado) throws ObjectNotFoundException{
		
		Professor professor = buscaPorId(professorAlterado.getId());
		professor.setNome(professorAlterado.getNome());
		
		return salvar(professor);
	}
	
	public void excluir(Integer id) {
		
		repoProfessor.deleteById(id);		
	}
	

}
