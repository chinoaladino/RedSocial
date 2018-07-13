/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Seguidores;

/**
 *
 * @author dell
 */
@Stateless
public class SeguidoresFacade extends AbstractFacade<Seguidores> implements SeguidoresFacadeLocal {

    @PersistenceContext(unitName = "RedSocialPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeguidoresFacade() {
        super(Seguidores.class);
    }
    
}
