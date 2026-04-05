package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/escola";
    private static final String USER = "root";
    private static final String PASSWORD = "aluno";

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver não encontrado!", e);

        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão!", e);
        }
    }
}