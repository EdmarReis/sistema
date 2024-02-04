/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.FornecedorDAO;
import dao.UsuarioDAO;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import net.proteanit.sql.DbUtils;
import utils.ConnectionFactory;


/**
 *
 * @author Camila
 */
public class CadastroUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form CadastroClientes
     */
    public CadastroUsuarios() {
        conexao = ConnectionFactory.conector(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //JFrame frame = new JFrame("CadastroClientes");
        //frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        initComponents();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        lblNome = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtPerfil = new javax.swing.JTextField();
        btnLimparFornecedor = new javax.swing.JButton();
        btnSalvarUsuario = new javax.swing.JButton();
        btnAlterarUsuario = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lbl = new javax.swing.JLabel();
        lblOperador = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblEndereco1 = new javax.swing.JLabel();
        rbAtivo = new javax.swing.JRadioButton();
        rbInativo = new javax.swing.JRadioButton();
        txtRepitaSenha = new javax.swing.JPasswordField();
        txtSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modulo de Fornecedores");
        setResizable(false);

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblUsuarios);

        lblNome.setText("Login");

        lblCelular.setText("Perfil");

        lblEmail.setText("Senha");

        lblEndereco.setText("Repita a senha");

        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLoginKeyReleased(evt);
            }
        });

        btnLimparFornecedor.setText("Limpar");
        btnLimparFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparFornecedorActionPerformed(evt);
            }
        });

        btnSalvarUsuario.setText("Incluir");
        btnSalvarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarUsuarioActionPerformed(evt);
            }
        });

        btnAlterarUsuario.setText("Editar");
        btnAlterarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarUsuarioActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        lbl.setText("Usuário:");

        lblOperador.setText("usuario");

        lblEndereco1.setText("Status");
        lblEndereco1.setToolTipText("");

        buttonGroup1.add(rbAtivo);
        rbAtivo.setSelected(true);
        rbAtivo.setText("Ativo");

        buttonGroup1.add(rbInativo);
        rbInativo.setText("Inativo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEndereco1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbAtivo)
                    .addComponent(rbInativo))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rbAtivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbInativo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblEndereco1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnLimparFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalvarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAlterarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblEmail)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblEndereco))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblNome)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(lblCelular)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPerfil)
                                    .addComponent(txtRepitaSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(lbl)
                                .addGap(18, 18, 18)
                                .addComponent(lblOperador)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNome)
                            .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCelular)
                            .addComponent(txtPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(lblEndereco)
                    .addComponent(txtRepitaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl)
                            .addComponent(lblOperador)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimparFornecedor)
                    .addComponent(btnSalvarUsuario)
                    .addComponent(btnAlterarUsuario)
                    .addComponent(btnSair))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getAccessibleContext().setAccessibleName("Modulo de Usuários\n");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnAlterarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarUsuarioActionPerformed
        // TODO add your handling code here:
        UsuarioDAO usuarioDao = new UsuarioDAO();
        conexao = ConnectionFactory.conector(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //UsuarioDAO usuarioDAO = new UsuarioDAO();
        String pass = txtSenha.getText();
        String repetPass = txtRepitaSenha.getText();
        System.out.println(pass+" \n"+repetPass+"\n ");
        int verificaPerfil = 0;
        try {
            verificaPerfil = usuarioDao.verificaPerfil(lblOperador.getText());
        } catch (SQLException ex) {
            Logger.getLogger(CadastroUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (verificaPerfil == 1) {
            int question = JOptionPane.showConfirmDialog(null, "Deseja Salvar as alterações?", "Atenção", JOptionPane.YES_NO_OPTION);
            if ((txtLogin.getText().isBlank() || txtRepitaSenha.getText().isBlank() || txtPerfil.getText().isBlank() || txtSenha.getText().isBlank()) && (txtLogin.getText().isBlank() && txtPerfil.getText().isBlank())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            } else {
                if (question == JOptionPane.YES_OPTION && pass.equals(repetPass) && !(txtSenha.getText().isBlank() && txtRepitaSenha.getText().isBlank())) {
                    try {
                        usuarioDao.alterarUsuario(txtLogin.getText(),txtPerfil.getText(),txtSenha.getText(), rbAtivo.isSelected(),rbInativo.isSelected());
                    } catch (SQLException ex) {
                        Logger.getLogger(CadastroUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    limpaTelaUsuario();
                    try {
                        pesquisarUsuario();
                    } catch (SQLException ex) {
                        Logger.getLogger(CadastroUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Alterou senha");
                } else if(question == JOptionPane.YES_OPTION && (!txtLogin.getText().isBlank() && !txtPerfil.getText().isBlank()) && (txtSenha.getText().isBlank() && txtRepitaSenha.getText().isBlank())){    
                    try {
                        usuarioDao.alterarUsuarioSemSenha(txtLogin.getText(),txtPerfil.getText(), rbAtivo.isSelected(),rbInativo.isSelected());
                    } catch (SQLException ex) {
                        Logger.getLogger(CadastroUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    limpaTelaUsuario();
                    try {
                        pesquisarUsuario();
                    } catch (SQLException ex) {
                        Logger.getLogger(CadastroUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Alterou perfil ou status");
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possivel seguir com a alteração.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Perfil não autorizado para essa transação", "Erro", JOptionPane.ERROR_MESSAGE);
            limpaTelaUsuario();
        }
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAlterarUsuarioActionPerformed

    private void btnSalvarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarUsuarioActionPerformed
        // TODO add your handling code here:
        UsuarioDAO usuarioDao = new UsuarioDAO();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        int verificaPerfil = 0;
        try {
            verificaPerfil = usuarioDao.verificaPerfil(lblOperador.getText());
        } catch (SQLException ex) {
            Logger.getLogger(CadastroUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (verificaPerfil == 1) {
            if (txtLogin.getText().isBlank() || txtPerfil.getText().isBlank() || txtSenha.getText().isBlank() || txtRepitaSenha.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Existem campos vazios");
            } else{
                if(!txtSenha.getText().equals(txtRepitaSenha.getText())){
                    JOptionPane.showMessageDialog(null, "Senhas não conferem");
                }else{
                    try {
                        usuarioDao.salvarUsuario(txtLogin.getText(),txtPerfil.getText(),txtSenha.getText(),rbAtivo.isSelected(),rbInativo.isSelected());
                    } catch (SQLException ex) {
                        Logger.getLogger(CadastroUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    limpaTelaUsuario();
                }   
            }
        } else {
            JOptionPane.showMessageDialog(null, "Perfil não autorizado para essa transação", "Erro", JOptionPane.ERROR_MESSAGE);
            limpaTelaUsuario();
        }
    }//GEN-LAST:event_btnSalvarUsuarioActionPerformed

    private void btnLimparFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparFornecedorActionPerformed
        // TODO add your handling code here:
        limpaTelaUsuario();
    }//GEN-LAST:event_btnLimparFornecedorActionPerformed

    private void txtLoginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyReleased
        try {
            // TODO add your handling code here:
            pesquisarUsuario();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtLoginKeyReleased

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        // TODO add your handling code here:
        setCamposUsuario();
    }//GEN-LAST:event_tblUsuariosMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroUsuarios().setVisible(true);
            }
        });
    }
    
    private void limpaTelaUsuario() {
        txtLogin.setText(null);
        txtPerfil.setText(null);
        txtSenha.setText(null);
        txtRepitaSenha.setText(null);
        //txtIdCliente.setText(null);
        DefaultTableModel model = (DefaultTableModel) tblUsuarios.getModel();
        model.setRowCount(0);
    }
    
    public void pesquisarUsuario() throws SQLException {
        conexao = ConnectionFactory.conector(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = "select id, nome, perfil, ativo from login where nome like ? ORDER BY nome ASC";
        //String sql = "select * from clientes where nome like ? and ativo = true";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtLogin.getText() + "%");
            rs = pst.executeQuery();

            tblUsuarios.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
        conexao.close();

    }
    
    private void setCamposUsuario() {
        int setar = tblUsuarios.getSelectedRow();
        //txtIdCliente.setText(tblClientes.getModel().getValueAt(setar, 0).toString());
        txtLogin.setText(tblUsuarios.getModel().getValueAt(setar, 1).toString());
        txtPerfil.setText(tblUsuarios.getModel().getValueAt(setar, 2).toString());
        if(tblUsuarios.getValueAt(setar, 3).equals(true)){
            rbAtivo.setSelected(true);
        }
        if(tblUsuarios.getValueAt(setar, 3).equals(false)){
            rbInativo.setSelected(true);
        }
    }
    
    void exportarNome(Cliente usuario) {
        lblOperador.setText(usuario.getNome());
        //lbl.setText(usuario.getNome());
    }
    
    //JLabel lblFoto = new JLabel("Foto");
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private JTable table;
    private String caminhoFoto;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarUsuario;
    private javax.swing.JButton btnLimparFornecedor;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvarUsuario;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEndereco1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblOperador;
    public javax.swing.JRadioButton rbAtivo;
    public javax.swing.JRadioButton rbInativo;
    private javax.swing.JTable tblUsuarios;
    public javax.swing.JTextField txtLogin;
    public javax.swing.JTextField txtPerfil;
    private javax.swing.JPasswordField txtRepitaSenha;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
