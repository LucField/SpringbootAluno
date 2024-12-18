package br.edu.ifg.poo2.alunoAPI;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.edu.ifg.poo2.alunoAPI.model.Aluno;
import br.edu.ifg.poo2.alunoAPI.service.AlunoService;

@SpringBootApplication
public class SpringAlunApplication implements CommandLineRunner {

    @Autowired
    private AlunoService alunoService;

    public static void main(String[] args) {
        SpringApplication.run(SpringAlunApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Menu CRUD");
            System.out.println("1. Create (POST)");
            System.out.println("2. Request (GET)");
            System.out.println("3. Update (PUT)");
            System.out.println("4. Delete (DELETE)");
            System.out.println("-----------------------------");
            System.out.println("5. PARAR");
            System.out.print("Digite um número: ");
            int str = scanner.nextInt();
            scanner.nextLine();  

            switch (str) {
                case 1:
                    System.out.print("Digite o nome do aluno: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a data de nascimento: ");
                    String dataNascimento = scanner.nextLine();
                    System.out.print("Digite o email: ");
                    String email = scanner.nextLine();
                    System.out.print("Digite o telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Digite o endereço: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Digite o curso: ");
                    String curso = scanner.nextLine();
                    System.out.print("Digite o CPF: ");
                    String cpf = scanner.nextLine();

                    Aluno alunoc = new Aluno();
                    alunoc.setNome(nome);
                    alunoc.setData_nascimento(dataNascimento);
                    alunoc.setEmail(email);
                    alunoc.setTelefone(telefone);
                    alunoc.setEndereco(endereco);
                    alunoc.setCurso(curso);
                    alunoc.setCpf(cpf);
                    alunoService.save(alunoc); // Corrigido aqui
                    System.out.println("Aluno criado com sucesso!");
                break;

                case 2: 
                    System.out.print("Digite a matrícula do aluno: ");
                    long matriculaConsultar = scanner.nextLong();
                    scanner.nextLine(); 
                    Aluno alunor = alunoService.findById(matriculaConsultar).orElse(null);

                    if (alunor != null) {
                        System.out.println("Aluno consultado: ");
                        System.out.println("Nome: " + alunor.getNome());
                        System.out.println("Data de nascimento: " + alunor.getData_nascimento());
                        System.out.println("Email: " + alunor.getEmail());
                        System.out.println("Telefone: " + alunor.getTelefone());
                        System.out.println("Endereço: " + alunor.getEndereco());
                        System.out.println("Curso: " + alunor.getCurso());
                        System.out.println("CPF: " + alunor.getCpf());
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                break;

                case 3: 
                    System.out.print("Digite a matrícula do aluno a ser atualizado: ");
                    long matriculaAtualizar = scanner.nextLong();
                    scanner.nextLine(); 

                    Aluno alunou = alunoService.findById(matriculaAtualizar).orElse(null);
                    if (alunou != null) {
                        System.out.print("Novo nome: ");
                        alunou.setNome(scanner.nextLine());
                        System.out.print("Nova data de nascimento: ");
                        alunou.setData_nascimento(scanner.nextLine());
                        System.out.print("Novo email: ");
                        alunou.setEmail(scanner.nextLine());
                        System.out.print("Novo telefone: ");
                        alunou.setTelefone(scanner.nextLine());
                        System.out.print("Novo endereço: ");
                        alunou.setEndereco(scanner.nextLine());
                        System.out.print("Novo Curso: ");
                        alunou.setCurso(scanner.nextLine());
                        alunoService.save(alunou);
                        System.out.println("Aluno atualizado com sucesso!");
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                break;

                case 4: 
                    System.out.print("Digite a matrícula do aluno a ser deletado: ");
                    long matriculaParaDeletar = scanner.nextLong(); // Corrigido aqui
                    scanner.nextLine(); 

                    if (alunoService.findById(matriculaParaDeletar).isPresent()) {
                        alunoService.delete(matriculaParaDeletar);
                        System.out.println("Aluno deletado com sucesso!");
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                break;

                case 5: 
                    System.out.println("Adios");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }        
        }
    }
}
