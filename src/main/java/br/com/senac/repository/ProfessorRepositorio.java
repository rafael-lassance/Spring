package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.domain.Professor;

@Repository
public interface ProfessorRepositorio extends JpaRepository<Professor, Integer>{

}
