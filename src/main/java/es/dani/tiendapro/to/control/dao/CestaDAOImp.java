/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.dani.tiendapro.to.control.dao;

import es.dani.tiendapro.to.control.modelo.Cesta;

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
public class CestaDAOImp implements CestaDAO{

    @Autowired      
    SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public boolean insertarCes(Cesta d) {
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
    public boolean eliminarCes(Integer num) {
        boolean exito = false;
        Session sesion = sessionFactory.openSession();
        try {
            sesion.getTransaction().begin();
            Cesta dep = sesion.get(Cesta.class, num);
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
    public boolean modificarCes(Cesta dNuevo) {
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
    public Cesta getCes(Integer num) {
        Session sesion = sessionFactory.openSession();    
        Cesta dep = sesion.get(Cesta.class, num); 
        sesion.close();
        return dep;
    }

    @Override
    @Transactional
    public List<Cesta> getTodosCes() {
        Session session = sessionFactory.openSession();   
        org.hibernate.query.Query q = session.createQuery("from Cesta c");   
        List<Cesta> lista = q.getResultList();  
        session.close();
        
        return lista;
    }

    @Override
    @Transactional
    public boolean modificarOrInsertarCes(Cesta dep) {
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
    public int ultimoIdCes() {
        
        Session session = sessionFactory.openSession();     
        org.hibernate.query.Query q = session.createQuery("select u.idCesta from Cesta u order by u.idCesta desc");
        q.setMaxResults(1);
        Integer id = (Integer) q.getSingleResult();
        Integer result= id +1;
        
        return result;
        
    }

    @Override
    @Transactional
    public List<Cesta> getCesUs(Integer num) {
        
        Session session = sessionFactory.openSession();     
        org.hibernate.query.Query q = session.createQuery("from Cesta c where c.idUsuario.idUsuario = :num");    
        q.setParameter("num", num);
        List<Cesta> lista = q.getResultList();    
        session.close();
        
        return lista;
        
    }

    @Override
    @Transactional
    public double getTotal(Integer num) {
        
        Session session = sessionFactory.openSession();     
        org.hibernate.query.Query q = session.createQuery("select sum(c.totalPrecio) from Cesta c where c.idUsuario.idUsuario = :num");    
        q.setParameter("num", num);
        double total = (Double) Optional.ofNullable(q.uniqueResult()).orElse(0.0);
        
        session.close();
        
        return total;
    }
    
    
    
}
