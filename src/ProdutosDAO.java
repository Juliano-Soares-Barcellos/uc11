/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;

public class ProdutosDAO {

    private Connection con;
    private conectaDAO conexao;
    private Statement stm = null;
    private PreparedStatement prep;
    private ResultSet resultset;

    public ProdutosDAO() {
        this.conexao = new conectaDAO();
        this.con = this.conexao.connectDB();
    }

    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public void cadastrarProduto(ProdutosDTO produto) {
        try {
           // con = conexao.connectDB();
            stm = con.createStatement();
            stm.executeUpdate("INSERT INTO produtos (Nome, Valor, Status) VALUES ('" + produto.getNome() + "', '" + produto.getValor() + "', '" + produto.getStatus() + "')");
            System.out.println("Dados inseridos.");
        } catch (SQLException sqle) {
            System.out.println("Erro inserindo: " + sqle.getMessage());

        }
    }

    public ArrayList<ProdutosDTO> listarProdutos() {

        return listagem;
    }

}
