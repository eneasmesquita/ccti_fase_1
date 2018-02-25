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
import org.ccti.sistema.facade.CategoriaFacade;
import org.ccti.sistema.modelo.Categoria;

@ManagedBean
@SessionScoped
public class CategoriaControle {

    Categoria categoria;
    CategoriaFacade categoriaFacade;
    List<Categoria> categorias;
    private DataModel<Categoria> categoriaModelo;

    public CategoriaControle() {
        if (categoria == null) {
            categoria = new Categoria();
        }
        if (categoriaFacade == null) {
            categoriaFacade = new CategoriaFacade();
        }
    }

    public void salvar() {
        if (categoria.getId() == null) {
            categoriaFacade.save(categoria);
            System.out.println("inserndo!");
            limpaCampo();
        } else {
            categoriaFacade.update(categoria);
            System.out.println("atualizando!");
            limpaCampo();
        }
    }

    private void limpaCampo() {
        categoria = new Categoria();
    }

    public String editar() {
        categoria = categoriaModelo.getRowData();
        System.out.println(categoria.getId());
        return "cadastro?faces-redirect=true";
    }

    public String excluir() {
        categoria = categoriaModelo.getRowData();
        categoriaFacade.delete(categoria);
        categoria = new Categoria();
        return "lista?faces-redirect=true";
    }

    public void excluirVoid() {
        categoria = categoriaModelo.getRowData();
        categoriaFacade.delete(categoria);
        getCategoriaModelo();
    }

    public String novaCategoria() {
        categoria = new Categoria();
        return "/paginas/categoria/cadastro?faces-redirect=true";
    }

    public String listar() {
        return "/paginas/categoria/lista?faces-redirect=true";
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public CategoriaFacade getCategoriaFacade() {
        return categoriaFacade;
    }

    public void setCategoriaFacade(CategoriaFacade categoriaFacade) {
        this.categoriaFacade = categoriaFacade;
    }

    public List<Categoria> getCategorias() {
        categorias = categoriaFacade.getAll();
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public DataModel<Categoria> getCategoriaModelo() {
        getCategorias();
        categoriaModelo = new ListDataModel<>(categorias);
        return categoriaModelo;
    }

    public void setCategoriaModelo(DataModel<Categoria> categoriaModelo) {
        this.categoriaModelo = categoriaModelo;
    }
}
