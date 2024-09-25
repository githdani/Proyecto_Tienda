/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.dani.tiendapro.to.control.dao;

import es.dani.tiendapro.to.control.modelo.Comentario;
import java.util.List;
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
public class ComentDAOImp implements ComentDAO{

    @Autowired      
    SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public boolean insertarCom(Comentario d) {
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
    public boolean eliminarCom(Integer num) {
        boolean exito = false;
        Session sesion = sessionFactory.openSession();
        try {
            sesion.getTransaction().begin();
            Comentario dep = sesion.get(Comentario.class, num);
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
    public boolean modificarCom(Comentario dNuevo) {
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
    public Comentario getCom(Integer num) {
        Session sesion = sessionFactory.openSession();    
        Comentario dep = sesion.get(Comentario.class, num); 
        sesion.close();
        return dep;
    }

    @Override
    @Transactional
    public List<Comentario> getTodosCom() {
        Session session = sessionFactory.openSession();   
        org.hibernate.query.Query q = session.createQuery("from Comentario c");   
        List<Comentario> lista = q.getResultList();  
        session.close();
        
        return lista;
    }

    @Override
    @Transactional
    public boolean modificarOrInsertarCom(Comentario dep) {
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
    public int ultimoIdCom() {
        
        Session session = sessionFactory.openSession();     
        org.hibernate.query.Query q = session.createQuery("select u.idComent from Comentario u order by u.idComent desc");
        q.setMaxResults(1);
        Integer id = (Integer) q.getSingleResult();
        Integer result= id +1;
        
        return result;
        
    }

    @Override
    @Transactional
    public List<Comentario> getComPro(Integer idPro) {
        
        Session session = sessionFactory.openSession();     
        org.hibernate.query.Query q = session.createQuery("from Comentario c where c.idProducto.idProducto = :num");    
        q.setParameter("num", idPro);
        List<Comentario> lista = q.getResultList();    
        session.close();
        
        return lista;
        
    }
    
}
