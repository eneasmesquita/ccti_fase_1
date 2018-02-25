/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ccti.sistema.controle;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.ccti.sistema.facade.ProdutoFacade;
import org.ccti.sistema.modelo.Produto;

/**
 *
 * @author PMBV-163987
 */
@ManagedBean
@SessionScoped
public class ProdutoControle {

    private Produto produto;
    private ProdutoFacade produtoFacade;
    private List<Produto> produtos;
    private DataModel<Produto> produtoModelo;

    public ProdutoControle() {
        if (produto == null) {
            produto = new Produto();
        }
        if (produtoFacade == null) {
            produtoFacade = new ProdutoFacade();
        }
    }

    public void salvar() {
        if (produto.getId() == null) {
            produtoFacade.save(produto);
            System.out.println("inserndo!");
            produto = new Produto();
        } else {
            produtoFacade.update(produto);
            System.out.println("atualizando!");
            produto = new Produto();
        }
    }

    public String editar() {
//        produto = produtoFacade.buscaProdutoPorId(id);
        produto = produtoModelo.getRowData();
        System.out.println(produto.getId());
        return "cadastro?faces-redirect=true";
    }

    public String excluir(){
        produto = produtoModelo.getRowData();
        produtoFacade.delete(produto);
        produto = new Produto();
        return "lista?faces-redirect=true";
    }
    
    public void excluirVoid(){
        produto = produtoModelo.getRowData();
        produtoFacade.delete(produto);
        getProdutoModelo();
    }
    
    public String novoProduto() {
        produto = new Produto();
        return "/paginas/produto/cadastro?faces-redirect=true";
    }
    
    
    public String listar() {
        return "/paginas/produto/lista?faces-redirect=true";
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ProdutoFacade getProdutoFacade() {
        return produtoFacade;
    }

    public void setProdutoFacade(ProdutoFacade produtoFacade) {
        this.produtoFacade = produtoFacade;
    }

    public List<Produto> getProdutos() {
        produtos = produtoFacade.getAll();
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public DataModel<Produto> getProdutoModelo() {
        getProdutos();
        produtoModelo = new ListDataModel<>(produtos);
        return produtoModelo;
    }

    public void setProdutoModelo(DataModel<Produto> produtoModelo) {
        this.produtoModelo = produtoModelo;
    }

}
