package br.edu.ifg.poo2.alunoAPI.repository;

import br.edu.ifg.poo2.alunoAPI.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    // Métodos personalizados podem ser adicionados aqui, se necessário
}