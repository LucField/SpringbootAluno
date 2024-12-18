package br.edu.ifg.poo2.alunoAPI.controller;

import br.edu.ifg.poo2.alunoAPI.model.Aluno;
import br.edu.ifg.poo2.alunoAPI.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunoService.findAll();
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Aluno> getAlunoByMatricula(@PathVariable("matricula") Long matricula) {
        return alunoService.findById(matricula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return alunoService.save(aluno);
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable("matricula") Long matricula, @RequestBody Aluno aluno) {
        if (!alunoService.findById(matricula).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        aluno.setMatricula(matricula);
        return ResponseEntity.ok(alunoService.save(aluno));
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> deleteAluno(@PathVariable("matricula") Long matricula) {
        if (!alunoService.findById(matricula).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        alunoService.delete(matricula);
        return ResponseEntity.noContent().build();
    }
}

