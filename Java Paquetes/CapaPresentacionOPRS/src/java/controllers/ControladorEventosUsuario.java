/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Cliente;
import facades.LoginFacadeRemote;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Properties;
import javax.naming.InitialContext;

/**
 *
 * @author sala_a
 */
@Named(value = "controladorEventosUsuario")
@SessionScoped
public class ControladorEventosUsuario implements Serializable {
    
    private Cliente cl = new Cliente();
    /**
     * Creates a new instance of ControladorEventosUsuario
     */
    public ControladorEventosUsuario() {
    }
    
  
    public Cliente getCl() {
        return cl;
    }

    public void setCl(Cliente cl) {
        this.cl = cl;
    }
    
    public String loggin (){
    
        boolean valido = false;
        try {
            Properties prop = new Properties();
            prop.setProperty("org.omg.CORBA.ORBInitialHost", "10.5.2.98");
            prop.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            InitialContext ctx = new InitialContext(prop);
            LoginFacadeRemote bean = (LoginFacadeRemote) ctx.lookup("java:global/LoginFacade/LoginFacade");

             valido = bean.logginearCliente(cl.getNuser(), cl.getNpassword()); //Invoco metodo de authenticacion remoto

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (valido){
            
        return "menu";
        }else{
        
        return "error";
        
        }
     
    }
    
    
    
}
