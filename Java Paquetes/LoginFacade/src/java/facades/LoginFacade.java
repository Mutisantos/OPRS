/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Cliente;
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
public class LoginFacade extends AbstractFacade<Cliente> implements LoginFacadeRemote {

    @PersistenceContext(unitName = "LoginFacadePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LoginFacade() {
        super(Cliente.class);
    }

    public boolean logginearCliente(String nombre, String password) {
        boolean sies = false;
        List<Cliente> cls = this.findAll();
        for (Cliente cl : cls) {
            if (cl.getNuser().equalsIgnoreCase(nombre)) {
                if (cl.getNpassword().equalsIgnoreCase(password)) {
                    sies = true;
                }
            }
        }
        return sies;

    }

}
