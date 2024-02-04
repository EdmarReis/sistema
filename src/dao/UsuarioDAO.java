/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;
import utils.ConnectionFactory;

/**
 *
 * @author edmar_sr
 */
public class UsuarioDAO {
    
    java.sql.Connection conexao = null;
    PreparedStatement pst = null;
    PreparedStatement pstSelect = null;
    ResultSet rs = null;
    ResultSet rsSelect = null;
    int id = 0;
    
    public int verificaPerfil(String nome) throws SQLException{
        
        conexao = ConnectionFactory.conector(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = "select perfil from login where nome = ?";
        int perfilUsuario = 0;
        
        try {
            
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                perfilUsuario = rs.getInt("perfil");
            }
            //conexao.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            //conexao.close();
        }
        
        return perfilUsuario;
    }
    
    public int obterId(String nome) throws SQLException{
        String sql = "select * from login where nome=?";
        int id = 0;
        
        try {
            
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            
            if(rs.next()) {
                id = rs.getInt("id");
            }else{
                JOptionPane.showMessageDialog(null, "Nao foi possivel buscar o ID");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
      
        return id;
    }

    public void alterarUsuario(String login, String perfil, String senha, boolean ativo, boolean inativo) throws SQLException {
        
        conexao = ConnectionFactory.conector(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = "update login set nome = ?, senha = ?, perfil = ?, ativo = ? where id = ?";
        int id = obterId(login);
        
        try {
            
            pst = conexao.prepareStatement(sql);
            pst.setString(1, login);
            pst.setString(2, senha);
            pst.setString(3, perfil);
            if(ativo){
                pst.setBoolean(4, true);
            }
            if(inativo){
                pst.setBoolean(4, false);
            }
            pst.setInt(5, id);
            int alteracao = pst.executeUpdate();
            
            if (alteracao > 0) {
                JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso");
                //pesquisarClientes();
            } else {
                JOptionPane.showMessageDialog(null, "Nao foi possivel alterar usuario no banco de dados.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na classe DAO \n"+ e);
            
        }
        conexao.close();
    }

    public void salvarUsuario(String login, String perfil, String senha, boolean ativo, boolean inativo) throws SQLException {
        
        conexao = ConnectionFactory.conector(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);       
        //String sql = "insert into clientes (nome,endereco,cpf_cnpj,telefone,email) values (?,?,?,?,?)";
        String sql = "insert into login (nome,senha,perfil,ativo) values (?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, login);
            pst.setString(2, senha);
            pst.setString(3, perfil);
            if(ativo){
                pst.setBoolean(4, true);
            }
            if(inativo){
                pst.setBoolean(4, false);
            }
            pst.execute();

            JOptionPane.showMessageDialog(null, "Usuario incluído com sucesso");
            
        } catch (SQLIntegrityConstraintViolationException e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "Não é possível inserir o mesmo nome duas vezes." + "\n" + e, "Erro!", JOptionPane.ERROR_MESSAGE);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", JOptionPane.ERROR_MESSAGE);
            
        }
        conexao.close();
    }

    public void alterarUsuarioSemSenha(String login, String perfil, boolean ativo, boolean inativo) throws SQLException {
        
        conexao = ConnectionFactory.conector(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = "update login set nome = ?, perfil = ?, ativo = ? where id = ?";
        int id = obterId(login);
        
        try {
            
            pst = conexao.prepareStatement(sql);
            pst.setString(1, login);
            pst.setString(2, perfil);
            if(ativo){
                pst.setBoolean(3, true);
            }
            if(inativo){
                pst.setBoolean(3, false);
            }
            pst.setInt(4, id);
            int alteracao = pst.executeUpdate();
            
            if (alteracao > 0) {
                JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso");
                //pesquisarClientes();
            } else {
                JOptionPane.showMessageDialog(null, "Nao foi possivel alterar usuario no banco de dados.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na classe DAO \n"+ e);
            
        }
        
    }
    
}
