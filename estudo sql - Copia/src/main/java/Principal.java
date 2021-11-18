import DAO.AlunoDAO;
import view.AlunoView;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.criarTabelaAlunos();

        AlunoView alunoView = new AlunoView();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("[1] adicionar alunos");
            System.out.println("[2] listar alunos");
            System.out.println("[3] editar alunos");
            System.out.println("[4] remover alunos");
            System.out.print("digite: ");
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1 -> alunoView.cadastrarAlunos();
                case 2 -> alunoView.listarAlunos();
                case 3 -> alunoView.editarAlunos();
                case 4 -> alunoView.remover();
            }
        }
    }
}
