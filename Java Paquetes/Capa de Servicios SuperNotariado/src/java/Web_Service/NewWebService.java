/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web_Service;

import Entities.Propiedadfinanciera;
import Logica.PropiedadfinancieraFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author sala_bd
 */
@WebService(serviceName = "NewWebService")
@Stateless()
public class NewWebService {
    @EJB
    private PropiedadfinancieraFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "entity") Propiedadfinanciera entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "entity") Propiedadfinanciera entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "entity") Propiedadfinanciera entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "find")
    public Propiedadfinanciera find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Propiedadfinanciera> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Propiedadfinanciera> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }
    
    @WebMethod(operationName = "validar")
    public boolean validar(String direccion, String localidad, int nCuartos, int renta)
    {
        List<Propiedadfinanciera> listaPropiedad = new ArrayList<Propiedadfinanciera>(this.findAll());
        for (Propiedadfinanciera temp : listaPropiedad) {
            if(temp.getDireccion().equalsIgnoreCase(direccion))
                if(temp.getLocalidad().equalsIgnoreCase(localidad))
                    if(Integer.parseInt(temp.getNcuartos()) == nCuartos)
                        if(Integer.parseInt(temp.getRenta())== renta)
                            return true;
        }
        return false;
    }
}
