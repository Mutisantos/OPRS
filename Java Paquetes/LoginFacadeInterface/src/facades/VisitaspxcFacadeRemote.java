/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Visitaspxc;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author sala_a
 */
@Remote
public interface VisitaspxcFacadeRemote {

    void create(Visitaspxc visitaspxc);

    void edit(Visitaspxc visitaspxc);

    void remove(Visitaspxc visitaspxc);

    Visitaspxc find(Object id);

    List<Visitaspxc> findAll();

    List<Visitaspxc> findRange(int[] range);

    int count();
    
}
