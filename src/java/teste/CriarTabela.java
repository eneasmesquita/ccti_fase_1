/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import javax.persistence.Persistence;

/**
 *
 * @author PMBV-163987
 */
public class CriarTabela {
    
    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("projetoResiduosMatutinoPU");
    }
}
