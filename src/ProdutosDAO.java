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
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try 
        {
           // con = conexao.connectDB();
            stm = con.createStatement();
            stm.executeUpdate("INSERT INTO produtos (Nome, Valor, Status) VALUES ('" + produto.getNome() + "', '" + produto.getValor() + "', '" + produto.getStatus() + "')");
            JOptionPane.showMessageDialog(null,"Dados inseridos.");
        }
        catch (SQLException sqle) 
        {
            JOptionPane.showMessageDialog(null, "Erro inserindo: " + sqle.getMessage());

        }
    }

    
    
    public ResultSet listarProdutos() {
           try {
                stm = con.createStatement();
            return stm.executeQuery("SELECT * FROM produtos");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
      
  }


