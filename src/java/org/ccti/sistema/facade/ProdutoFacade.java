/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ccti.sistema.facade;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.ccti.sistema.dao.GenericDAOImp;
import org.ccti.sistema.dao.JPAMF;
import org.ccti.sistema.modelo.Produto;

/**
 *
 * @author PMBV-163987
 */
public class ProdutoFacade extends GenericDAOImp<Produto> {

    public ProdutoFacade() {
        super(Produto.class);
    }

    EntityManager em = new JPAMF().getEntityManager();

    public Produto buscaProdutoPorId(Long id) {
        Query q = em.createQuery("select p from Produto p WHERE p.id  = :id");
        q.setParameter("id", id);
        return (Produto) q.getSingleResult();
    }

}
