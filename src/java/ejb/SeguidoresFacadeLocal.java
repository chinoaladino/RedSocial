/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import modelo.Seguidores;

/**
 *
 * @author dell
 */
@Local
public interface SeguidoresFacadeLocal {

    void create(Seguidores seguidores);

    void edit(Seguidores seguidores);

    void remove(Seguidores seguidores);

    Seguidores find(Object id);

    List<Seguidores> findAll();

    List<Seguidores> findRange(int[] range);

    int count();
    
}
