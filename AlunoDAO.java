package dao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AlunoDAO {

    // 🔹 INSERT
    public void inserirAluno(String nome, int idade) {

        String sql = "INSERT INTO aluno (nome, idade) VALUES (?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nome);
            ps.setInt(2, idade);

            ps.executeUpdate();
            System.out.println("Aluno inserido com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 SELECT
    public void listarAlunos() {

        String sql = "SELECT * FROM aluno";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");

                System.out.println("ID: " + id +
                                   " | Nome: " + nome +
                                   " | Idade: " + idade);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 UPDATE
    public void atualizarAluno(int id, String nome, int idade) {

        String sql = "UPDATE aluno SET nome = ?, idade = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nome);
            ps.setInt(2, idade);
            ps.setInt(3, id);

            int linhas = ps.executeUpdate();

            if (linhas > 0) {
                System.out.println("Aluno atualizado com sucesso!");
            } else {
                System.out.println("Aluno não encontrado.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 DELETE
    public void deletarAluno(int id) {

        String sql = "DELETE FROM aluno WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            int linhas = ps.executeUpdate();

            if (linhas > 0) {
                System.out.println("Aluno deletado com sucesso!");
            } else {
                System.out.println("Aluno não encontrado.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}