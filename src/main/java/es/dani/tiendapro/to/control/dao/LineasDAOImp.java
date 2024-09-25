/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.dani.tiendapro.to.control.dao;

import es.dani.tiendapro.to.control.modelo.Lineaspedido;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dani1
 */

@Repository
public class LineasDAOImp implements LineasDAO{

    
    @Autowired      
    SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public boolean insertarDet(Lineaspedido d) {
        boolean exito = false;
        Session sesion = sessionFactory.openSession();    
        try {
            sesion.getTransaction().begin();
            sesion.saveOrUpdate(d);
            sesion.getTransaction().commit();
            exito = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        } finally {
            sesion.close();
            return exito;

        }
    }

    @Override
    @Transactional
    public boolean eliminarDet(Integer num) {
        boolean exito = false;
        Session sesion = sessionFactory.openSession();
        try {
            sesion.getTransaction().begin();
            Lineaspedido dep = sesion.get(Lineaspedido.class, num);
            if (dep != null) {
                sesion.remove(dep);
                exito = true;
            } 
            sesion.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        } finally {
            sesion.close();
            return exito;
        }
    }

    @Override
    @Transactional
    public boolean modificarDet(Lineaspedido dNuevo) {
        boolean exito = false;
        Session sesion = sessionFactory.openSession();    
        try {
            sesion.getTransaction().begin();
            sesion.merge(dNuevo);
            sesion.getTransaction().commit();
            exito = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        } finally {
            sesion.close();
            return exito;
        }
    }

    @Override
    @Transactional
    public Lineaspedido getDet(Integer num) {
        Session sesion = sessionFactory.openSession();    
        Lineaspedido dep = sesion.get(Lineaspedido.class, num); 
        sesion.close();
        return dep;
    }

    @Override
    @Transactional
    public List<Lineaspedido> getTodosDet() {
         Session session = sessionFactory.openSession();   
        org.hibernate.query.Query q = session.createQuery("from Lineaspedido c");   
        List<Lineaspedido> lista = q.getResultList();  
        session.close();
        
        return lista;
    }

    @Override
    @Transactional
    public boolean modificarOrInsertarDet(Lineaspedido dep) {
        boolean exito = false;
        Session sesion = sessionFactory.openSession();   
        try {
            sesion.getTransaction().begin();
            sesion.saveOrUpdate(dep);
            sesion.getTransaction().commit();
            exito = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        } finally {
            sesion.close();
            return exito;

        }
    }

    @Override
    @Transactional
    public List<Lineaspedido> getDetallesPed(Integer idped) {
        Session session = sessionFactory.openSession();     
        org.hibernate.query.Query q = session.createQuery("from Lineaspedido c where c.idPedido.idPedido = :num");    
        q.setParameter("num", idped);
        List<Lineaspedido> lista = q.getResultList();    
        session.close();
        
        return lista;
    }

    @Override
    @Transactional
    public int ultimoIdLin() {
        
        Session session = sessionFactory.openSession();     
        org.hibernate.query.Query q = session.createQuery("select u.idLineas from Lineaspedido u order by u.idLineas desc");
        q.setMaxResults(1);
        Integer id = (Integer) q.getSingleResult();
        Integer result= id +1;
        
        return result;
        
    }

    @Override
    @Transactional
    public double getTotal(Integer num) {
        
        Session session = sessionFactory.openSession();     
        org.hibernate.query.Query q = session.createQuery("select sum(c.totalPrecio) from Lineaspedido c where c.idPedido.idPedido = :num");    
        q.setParameter("num", num);
        double total = (Double) Optional.ofNullable(q.uniqueResult()).orElse(0.0);
        
        session.close();
        
        return total; 
    }
    
}
