package teste;

import dao.AlunoDAO;

public class Main {

    public static void main(String[] args) {

        AlunoDAO dao = new AlunoDAO();

        // 🔹 INSERT
        dao.inserirAluno("Pedro", 20);

        // 🔹 SELECT
        System.out.println("\n--- LISTANDO ALUNOSS ---");
        dao.listarAlunos();

        // 🔹 UPDATE
        System.out.println("\n--- ATUALIZANDO ---");
        dao.atualizarAluno(1, "Maria Silva", 18);

        // 🔹 DELETE
        System.out.println("\n--- DELETANDO ---");
        dao.deletarAluno(2);

        // 🔹 SELECT novamente
        System.out.println("\n--- LISTA FINAL ---");
        dao.listarAlunos();
    }
}