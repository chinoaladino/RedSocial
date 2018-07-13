/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Mensaje;

/**
 *
 * @author dell
 */
@Stateless
public class MensajeFacade extends AbstractFacade<Mensaje> implements MensajeFacadeLocal {

    @PersistenceContext(unitName = "RedSocialPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MensajeFacade() {
        super(Mensaje.class);
    }

    @Override
    public boolean findMensaje(int idMensaje) {
        Query query = em.createQuery("SELECT m FROM Mensaje m WHERE m.idMensaje = :idMensaje");
        query.setParameter("idMensaje", idMensaje);

        if (query.getResultList().size() > 0) {
            return true;

        }
        return false;
    }
    
}
