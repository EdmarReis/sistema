/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author edmar_sr
 */
public class TesteCliente {
    
    Cliente cliente = new Cliente();
    Produto produto = new Produto();
    
    public String testeNome(){
        cliente.setNome("Edmar");
        return cliente.getNome();
    }
}
