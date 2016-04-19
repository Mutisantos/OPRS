/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Propiedad;
import entities.Visitaspxc;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sala_a
 */
@Stateless
public class VisitaspxcFacade extends AbstractFacade<Visitaspxc> implements facades.VisitaspxcFacadeRemote {
    @PersistenceContext(unitName = "LoginFacadePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VisitaspxcFacade() {
        super(Visitaspxc.class);
    }
    /**
     * Método para traer todas las visitas hechas por el usuario cuando tiene propiedades visitadas
     * @return lista de vistas 
     */
    public List<Propiedad> verVisitasCliente(String cliente){
        List<Propiedad> visitas = new ArrayList<>() ;
        List<Visitaspxc> todas = this.findAll();
        for (Visitaspxc vpc : todas) {
            if(vpc.getIdcliente().getNuser().equals(cliente)){
                visitas.add(vpc.getIdpropiedad());//Agrega la referencia de propiedades que tenga visitadas
            }
  
        }        
        return visitas;
    }
    
}
