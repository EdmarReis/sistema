/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Produto;
import utils.ConnectionFactory;

/**
 *
 * @author edmar_sr
 */
public class VendaProdutoDAO {
    
    java.sql.Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void insertVendaProduto(String codigoProduto, String nomeProduto, Double quantidade, Object precoUnitario, Object desconto, Object precoTotal, String formaPagamento, String data, String operador, String nomeCliente) throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        conexao = ConnectionFactory.conector(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = "insert into vendaProduto (id_pedido,nome_cliente,nome_produto,codigo_produto,preco_unitario,quantidade,desconto,total,operador,data_pedido,forma_pagamento) values (?,?,?,?,?,?,?,?,?,?,?)";
        PedidoDAO numeroPedido = new PedidoDAO();
        int idPedido = numeroPedido.numeroPedido();
        
         try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, idPedido+1);
            pst.setString(2, nomeCliente);
            pst.setString(3, nomeProduto);
            pst.setString(4, codigoProduto);
            pst.setObject(5, precoUnitario);
            pst.setDouble(6, quantidade);
            pst.setObject(7, desconto);
            pst.setObject(8, precoTotal);
            pst.setString(9, operador);
            pst.setString(10, data);
            pst.setString(11, formaPagamento);
            pst.execute();
            conexao.close();
            //JOptionPane.showMessageDialog(null, "Item incluído com sucesso.");

        } catch (SQLIntegrityConstraintViolationException e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "Erro na inclusão de item" + "\n" + e, "Erro!", JOptionPane.ERROR_MESSAGE);
            conexao.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", JOptionPane.ERROR_MESSAGE);
            conexao.close();
        }
        
    }

    public void acertoEstoqueBtnLimpar(String codigoProduto, Double quantidade) throws SQLException {

        conexao = ConnectionFactory.conector(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = "update produtos set estoque = ? where codigo = ?";
        String estoqueAtual = pesquisaEstoque(Double.parseDouble(codigoProduto));
        Double atualizado = Double.parseDouble(estoqueAtual) + quantidade;

        try {
            pst = conexao.prepareStatement(sql);
            pst.setDouble(1, atualizado);
            pst.setString(2, codigoProduto);
            int result = pst.executeUpdate();
            conexao.close();
            //if (result == 1) {
            //    JOptionPane.showMessageDialog(null, "Estoque atualizado ");
            //}
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Erro ao atualizar o estoque!", JOptionPane.ERROR_MESSAGE);
            conexao.close();
        }

    }
    
    public boolean acertoEstoqueBtnAdicionar(String codigoProduto, Double subtraiEstoque, double quantidade) throws SQLException {

        conexao = ConnectionFactory.conector(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = "update produtos set estoque = ? where codigo = ?";
        String estoqueAtual = pesquisaEstoque(Double.parseDouble(codigoProduto));
        Double verificaMenorQueZero = Double.parseDouble(estoqueAtual) - quantidade;
        Double atualizado = Double.parseDouble(estoqueAtual) + subtraiEstoque;

        if (verificaMenorQueZero < 0) {
            JOptionPane.showMessageDialog(null, "Quantidade informada maior do que estoque disponivel");
            return false;
        } else {
            try {
                pst = conexao.prepareStatement(sql);
                pst.setDouble(1, atualizado);
                pst.setString(2, codigoProduto);
                int result = pst.executeUpdate();
                conexao.close();
                //if (result == 1) {
                //    JOptionPane.showMessageDialog(null, "Estoque atualizado ");
                //}
                return true;
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Erro ao atualizar o estoque!", JOptionPane.ERROR_MESSAGE);
                conexao.close();
                return false;
            }
        }
    }
    
    public String pesquisaEstoque(double codigo) throws SQLException {
        conexao = ConnectionFactory.conector(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = "select estoque from produtos where codigo = ?";
        //double estoque = 0;
        String estoque = "";
        try {
            
            pst = conexao.prepareStatement(sql);
            pst.setDouble(1, codigo);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                //estoque = rs.getDouble("estoque");
                estoque = rs.getString("estoque");
            }//else{
            //    JOptionPane.showMessageDialog(null, "Código " + codigo + " não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            //    estoque = "";
            //}
            //conexao.close();
        } catch (Exception e) {
            Logger.getLogger(VendaProdutoDAO.class.getName()).log(Level.INFO, "(VendaProdutoDAO)Erro ao pesquisar estoque!", "");
            JOptionPane.showMessageDialog(null, e, "(VendaProdutoDAO)Erro ao pesquisar o estoque!!!", JOptionPane.ERROR_MESSAGE);   
            //conexao.close();
        } 
        
        //return Double.toString(estoque);
        return estoque;
    }
    
}
