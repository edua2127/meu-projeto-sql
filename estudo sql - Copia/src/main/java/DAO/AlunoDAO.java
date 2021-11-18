package DAO;

import fabrica.Conexao;
import model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    Connection connection;

    public AlunoDAO() {
        connection = new Conexao().getconexao();
    }

    public void criarTabelaAlunos() {
        String sql = "create table if not exists alunos(id_aluno int primary key auto_increment," +
                "nome_aluno VARCHAR(50) NOT NULL," +
                "nome_escola VARCHAR(50) NOT NULL)";
        try {
            PreparedStatement stml = connection.prepareStatement(sql);
            stml.execute();
            stml.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastrarAluno(Aluno aluno) {
        String sql = "insert into uniflow.alunos(nome_aluno, nome_escola) value(?, ?)";
        try {
            PreparedStatement stml = connection.prepareStatement(sql);
            stml.setString(1, aluno.getNomeAluno());
            stml.setString(2,aluno.getNomeEscola());
            stml.execute();
            stml.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Aluno> listarAlunos() {
        String sql = "select * from uniflow.alunos";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            List<Aluno> alunos = new ArrayList<>();
            Aluno aluno;
            while (resultSet.next()) {
                aluno = new Aluno();
                aluno.setIdAluno(resultSet.getInt("id_aluno"));
                aluno.setNomeAluno(resultSet.getString("nome_aluno"));
                aluno.setNomeEscola(resultSet.getString("nome_escola"));
                alunos.add(aluno);
            }
            return alunos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void remover(int id) {
        try {
            String sql = "delete from uniflow.alunos where id_aluno = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
            statement.close();
            System.out.println("removido con sucesso!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void editarAlunos(int id, int opcao, String conteudo) {
        String sql = null;
        switch (opcao) {
            case 1-> {
                sql = "update uniflow.alunos set nome_aluno = ? where id_aluno = ?";
            }
            case 2 -> {
                sql = "update uniflow.alunos set nome_escola = ? where id_aluno = ?";
            }
        }
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,conteudo);
            statement.setInt(2,id);
            statement.execute();
            statement.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
