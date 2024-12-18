package br.edu.ifg.poo2.alunoAPI.service;

import br.edu.ifg.poo2.alunoAPI.model.Aluno;
import br.edu.ifg.poo2.alunoAPI.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> findById(Long matricula) {
        return alunoRepository.findById(matricula);
    }

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public void delete(Long matricula) {
        alunoRepository.deleteById(matricula);
    }

}