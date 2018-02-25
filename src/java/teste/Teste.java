/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import org.ccti.sistema.modelo.Categoria;
import org.ccti.sistema.modelo.Produto;

/**
 *
 * @author PMBV-163987
 */
public class Teste {

    public static void main(String[] args) {

        Categoria categoria = new Categoria();
        categoria.setNome("Alimento");

        Produto produto = new Produto();
        produto.setNome("Arroz");
        produto.setPreco(3.0);
        produto.setCategoria(categoria);
        
        System.out.println("Categoria: "+categoria.getNome());
        System.out.println("Nome do produto: "+produto.getNome());
        System.out.println("Preço do produto: "+produto.getPreco());

    }
}
