/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ccti.sistema.facade;

import org.ccti.sistema.dao.GenericDAOImp;
import org.ccti.sistema.modelo.Categoria;

/**
 *
 * @author PMBV-163987
 */
public class CategoriaFacade extends GenericDAOImp<Categoria> {

    public CategoriaFacade() {
        super(Categoria.class);
    }

}
