/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author edmar_sr
 */
public class Fornecedor {
    
    public String nomeFornecedor;
    public String enderecoFornecedor;
    public String cpfCnpjFornecedor;
    public String telefoneFornecedor;
    public String emailFornecedor;

    public String getNome() {
        return nomeFornecedor;
    }

    public void setNome(String nomeCliente) {
        this.nomeFornecedor = nomeCliente;
    }

    public String getEndereco() {
        return enderecoFornecedor;
    }

    public void setEndereco(String endereco) {
        this.enderecoFornecedor = endereco;
    }

    public String getCpf_cnpj() {
        return cpfCnpjFornecedor;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpfCnpjFornecedor = cpf_cnpj;
    }

    public String getTelefone() {
        return telefoneFornecedor;
    }

    public void setTelefone(String telefone) {
        this.telefoneFornecedor = telefone;
    }

    public String getEmail() {
        return emailFornecedor;
    }

    public void setEmail(String email) {
        this.emailFornecedor = email;
    }

    public Fornecedor() {
    }

    public Fornecedor(String nomeCliente, String endereco, String cpf_cnpj, String telefone, String email) {
        this.nomeFornecedor = nomeCliente;
        this.enderecoFornecedor = endereco;
        this.cpfCnpjFornecedor = cpf_cnpj;
        this.telefoneFornecedor = telefone;
        this.emailFornecedor = email;
    }

    public Fornecedor(String nomeCliente) {
        this.nomeFornecedor = nomeCliente;
    }

    @Override
    public String toString() {
        return nomeFornecedor;
    }
    
    
}
