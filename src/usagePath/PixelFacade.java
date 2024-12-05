package usagePath;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PixelFacade {
    public void criarPixel(String nome, String descricao, String agente, String habilidade) {
        try (Connection conexao = ConexaoBanco.getConexao()) {
            String sql = "INSERT INTO pixels (nome, descricao, agente, habilidade) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, nome);
                stmt.setString(2, descricao);
                stmt.setString(3, agente);
                stmt.setString(4, habilidade);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar pixel: " + e.getMessage(), e);
        }
    }

    public List<String> getPixels() {
        List<String> pixels = new ArrayList<>();
        try (Connection conexao = ConexaoBanco.getConexao()) {
            String sql = "SELECT id, nome FROM pixels";
            try (Statement stmt = conexao.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    pixels.add(rs.getInt("id") + ": " + rs.getString("nome"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar pixels: " + e.getMessage(), e);
        }
        return pixels;
    }

    public void removerPixel(int id) {
        try (Connection conexao = ConexaoBanco.getConexao()) {
            String sql = "DELETE FROM pixels WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover pixel: " + e.getMessage(), e);
        }
    }

    public void editarPixel(int id, String nome, String descricao, String agente, String habilidade) {
        try (Connection conexao = ConexaoBanco.getConexao()) {
            String sql = "UPDATE pixels SET nome = ?, descricao = ?, agente = ?, habilidade = ? WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, nome);
                stmt.setString(2, descricao);
                stmt.setString(3, agente);
                stmt.setString(4, habilidade);
                stmt.setInt(5, id);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao editar pixel: " + e.getMessage(), e);
        }
    }

    public String getDetalhesPixel(int id) {
        try (Connection conexao = ConexaoBanco.getConexao()) {
            String sql = "SELECT * FROM pixels WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return "ID: " + rs.getInt("id") +
                                "\nNome: " + rs.getString("nome") +
                                "\nDescrição: " + rs.getString("descricao") +
                                "\nAgente: " + rs.getString("agente") +
                                "\nHabilidade: " + rs.getString("habilidade");
                    } else {
                        return "Pixel não encontrado.";
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar detalhes do pixel: " + e.getMessage(), e);
        }
    }
    public String verPixel(int id) {
        try (Connection conexao = ConexaoBanco.getConexao()) {
            String sql = "SELECT * FROM pixels WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return "ID: " + rs.getInt("id") +
                                "\nNome: " + rs.getString("nome") +
                                "\nDescrição: " + rs.getString("descricao") +
                                "\nAgente: " + rs.getString("agente") +
                                "\nHabilidade: " + rs.getString("habilidade");
                    } else {
                        return "Pixel não encontrado.";
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar detalhes do pixel: " + e.getMessage(), e);
        }
    }
}
