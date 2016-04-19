/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Entities.Propiedadfinanciera;
import Logica.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sala_bd
 */
@Stateless
public class PropiedadfinancieraFacade extends AbstractFacade<Propiedadfinanciera> {
    @PersistenceContext(unitName = "Capa_de_Servicios_SuperNotariadoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PropiedadfinancieraFacade() {
        super(Propiedadfinanciera.class);
    }
    
}
