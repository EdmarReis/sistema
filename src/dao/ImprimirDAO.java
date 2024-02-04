/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import static java.math.BigDecimal.ZERO;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;
import utils.ConnectionFactory;

/**
 *
 * @author Camila
 */
public class ImprimirDAO {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void imprime(String numeroPedido) throws SQLException {

        conexao = ConnectionFactory.conector(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        String dataF = "dd/MM/yyyy";
        String horaF = "H:mm - a";
        String data, hora;
        Date tempoAtual = new Date();
        SimpleDateFormat formata = new SimpleDateFormat(dataF);
        data = formata.format(tempoAtual);

        formata = new SimpleDateFormat(horaF);
        hora = formata.format(tempoAtual);

        String conteudoImprimir = "";

        String operador = "";
        String cliente = "";
        String codigoProduto = "";
        String nomeProduto = "";
        float quantidade = 0;
        float valor = 0;
        float total = 0;
        float desconto = 0;
        float totalComDesconto = 0;
        String formaPagamento = "";
        float quantidadeValorUnitario = 0;
        float totalSemDesconto = 0;

        String sql = "select * from vendaproduto where id_pedido = " + numeroPedido;
        //int numero = 0;
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codigoProduto = rs.getString("codigo_produto");
                nomeProduto = rs.getString("nome_produto");
                quantidade = rs.getFloat("quantidade");
                valor = rs.getFloat("preco_unitario");
                quantidadeValorUnitario = valor*quantidade;
                totalSemDesconto += quantidadeValorUnitario;
                total += rs.getFloat("total");  // total com desconto
                desconto += rs.getFloat("desconto");
                operador = rs.getString("operador");
                cliente = rs.getString("nome_cliente");
                formaPagamento = rs.getString("forma_pagamento");

                conteudoImprimir += quantidade + "  " + valor + "  " + nomeProduto + "\n\r";

                

            }
            
            totalComDesconto = totalSemDesconto-desconto;
            System.out.println("Teste "+totalSemDesconto+"\n"+conteudoImprimir);
            BigDecimal bTotalComDesconto = new BigDecimal(totalComDesconto).setScale(2, RoundingMode.HALF_UP);
            BigDecimal bDesconto = new BigDecimal(desconto);
            BigDecimal bTotalSemDesconto = new BigDecimal(totalSemDesconto);
            
            this.imprimir(
                    "\n\r"
                    +"\n\r"
                    +"           Artigos B&R           \r\n"
                    + "Estrada Joao Gaspar Delgado 633 \n\r" 
                    + "   Ferraz de Vasconcelos - SP   \n\r" 
                    + "    CNPJ: 00.000.000/0001-00    \n\r"
                    + "     Fone: (11) 97456-4486      \n\r"       
                    + "--------------------------------\n\r"
                    + "        Cupom Nao Fiscal        \n\r"
                    + "--------------------------------\n\r"
                    + "QTD  Preco(R$) Descricao        \n\r"
                    + conteudoImprimir +""
                    + "--------------------------------\n\r"
                    + "Valor Bruto: R$ " + bTotalSemDesconto.setScale(2, RoundingMode.HALF_UP) + "\n\r"
                    + "  Desconto: R$ " + bDesconto.setScale(2, RoundingMode.HALF_UP) + " \n\r"
                    + "Valor total: R$ " + bTotalComDesconto.setScale(2, RoundingMode.HALF_UP) + "\n\r"
                    + "Forma de pagamento: "+ formaPagamento + "\n\r"        
                    + "--------------------------------\n\r"
                    + data + " - " + hora + "          \n\r"
                    + "Numero Pedido: "+numeroPedido+ "\n\r"
                    + "Operador: "+ operador+ "        \n\r"
                    + "Cliente: "+cliente+ "           \n\r"
                    + "                                \n\r"
                    + "     Obrigado e volte Sempre    \n\r"
                    + "       Deus seja Louvado        \n\r"
                    + "                                \n\r"
                    + "                                \n\r"
                    + "\f"
            );
            conexao.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao montar arquivo para impressão \n"+e,"ERRO",JOptionPane.ERROR_MESSAGE);
            conexao.close();
        }

    }
    
    public void imprimir(String pTexto){
        
        try {
            
            InputStream prin = new ByteArrayInputStream(pTexto.getBytes());
            DocFlavor docFlavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            SimpleDoc documentoTexto = new SimpleDoc(prin, docFlavor, null);
            PrintService impressora = PrintServiceLookup.lookupDefaultPrintService();
            
            PrintRequestAttributeSet printAttributes = new HashPrintRequestAttributeSet();
            printAttributes.add(new JobName("impressao", null));
            printAttributes.add(OrientationRequested.PORTRAIT);
            printAttributes.add(MediaSizeName.ISO_A4);
            
            DocPrintJob printJob = impressora.createPrintJob();
            
            try {
                printJob.print(documentoTexto, (PrintRequestAttributeSet) printAttributes);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nao foi possivel realizar a impressao! \n"+e, "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
            prin.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel realizar a impressao! \n"+e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
       
    }
    
}
