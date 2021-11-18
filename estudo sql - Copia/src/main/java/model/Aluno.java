package model;

public class Aluno {
    private int idAluno;
    private String nomeAluno;
    private String nomeEscola;

    public Aluno() {
    }

    public Aluno(String nomeFuncionario, String nomeEmpresa) {
        this.nomeAluno = nomeFuncionario;
        this.nomeEscola = nomeEmpresa;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getNomeEscola() {
        return nomeEscola;
    }

    public void setNomeEscola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }
}
