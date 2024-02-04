/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import utils.ConnectionFactory;
import view.CadastroProdutos;

/**
 *
 * @author edmar_sr
 */
public class ClienteCadastroDAO {
    
    java.sql.Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void alterarCliente(String nome, String endereco, String telefone, String email, String cpfCnpj, boolean ativo, boolean inativo) throws SQLException {
        conexao = ConnectionFactory.conector(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = "update clientes set nome = ?, endereco = ?, telefone = ?, email = ?, ativo = ? where cpf_cnpj = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, endereco);
            pst.setString(3, telefone);
            pst.setString(4, email);
            pst.setString(6, cpfCnpj);
            if(ativo){
                pst.setBoolean(5, true);
            }
            if(inativo){
                pst.setBoolean(5, false);
            }
            int alteracao = pst.executeUpdate();
            

            if (alteracao > 0) {
                JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso");
                //pesquisarClientes();
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma alteração foi realizada.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        conexao.close();
    }      
    
    public void salvarCliente(String nome, String endereco, String cpfCnpj, String celular, String email, boolean ativo, boolean inativo) throws SQLException {
        conexao = ConnectionFactory.conector(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);       
        //String sql = "insert into clientes (nome,endereco,cpf_cnpj,telefone,email) values (?,?,?,?,?)";
        String sql = "insert into clientes (nome,endereco,cpf_cnpj,telefone,email,ativo) values (?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, endereco);
            pst.setString(3, cpfCnpj);
            pst.setString(4, celular);
            pst.setString(5, email);
            if(ativo){
                pst.setBoolean(6, true);
            }
            if(inativo){
                pst.setBoolean(6, false);
            }
            pst.execute();

            JOptionPane.showMessageDialog(null, "Cliente incluído com sucesso");

        } catch (SQLIntegrityConstraintViolationException e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "Não é possível inserir o mesmo CPF/CNPJ duas vezes." + "\n" + e, "Erro!", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        conexao.close();
    }
    
}
