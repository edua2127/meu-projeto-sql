package view;

import controller.AlunoController;
import model.Aluno;

import java.util.List;
import java.util.Scanner;

public class AlunoView {
    AlunoController alunoController = new AlunoController();
    Scanner scanner = new Scanner(System.in);

    public void cadastrarAlunos() {
        Aluno aluno = new Aluno();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome do Aluno: ");
        aluno.setNomeAluno(scanner.nextLine());
        System.out.print("Nome da Escola: ");
        aluno.setNomeEscola(scanner.nextLine());
        alunoController.cadastrarFuncionarios(aluno);
    }

    public void editarAlunos() {
        this.listarAlunos();
        int id;
        int opcao;
        String conteudo = null;
        System.out.print("digite o id do aluno a ser editado: ");
        id = Integer.parseInt(scanner.nextLine());
        System.out.println("[1] editar o nome do aluno ");
        System.out.println("[2] editar o nome da escola");
        opcao = Integer.parseInt(scanner.nextLine());
        switch (opcao) {
            case 1 -> {
                System.out.print("digite o novo nome do aluno: ");
                conteudo = scanner.nextLine();
            }
            case 2 -> {
                System.out.print("digite o novo nome da escola: ");
                conteudo = scanner.nextLine();
            }
            default -> {
                System.out.println("opcao invalida");
                return;
            }
        }
        alunoController.editarAlunos(id,opcao,conteudo);
    }
    public void linha() {
        System.out.println("-------------------------------------------------");
    }
    public void remover() {
        this.linha();
        this.listarAlunos();
        this.linha();
        System.out.print("digite o id do aluno a ser removido");
        int id = Integer.parseInt(scanner.nextLine());
        alunoController.remover(id);
    }
    public void listarAlunos() {
        List<Aluno> alunos = alunoController.listarAlunos();
        for (Aluno aluno : alunos) {
            System.out.println("id do aluno: " + aluno.getIdAluno() + " nome do aluno: " + aluno.getNomeAluno() + " nome da escola: " + aluno.getNomeEscola());
        }
    }
}
