package controller;

import DAO.AlunoDAO;
import model.Aluno;

import java.util.List;

public class AlunoController {
    AlunoDAO alunoDAO = new AlunoDAO();

    public void cadastrarFuncionarios(Aluno aluno) {
        alunoDAO.cadastrarAluno(aluno);
    }

    public List<Aluno> listarAlunos() {
        return alunoDAO.listarAlunos();
    }
    public void editarAlunos(int id, int opcao, String conteudo) {
        alunoDAO.editarAlunos(id,opcao,conteudo);
    }
    public void remover(int id) {
        alunoDAO.remover(id);
    }
}
