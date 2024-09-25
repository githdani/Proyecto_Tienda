/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.dani.tiendapro.to.control.dao;

import es.dani.tiendapro.to.control.modelo.Producto;
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
public class ProductoDAOImp implements ProductoDAO {

    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public boolean insertarPro(Producto d) {
        boolean exito = false;
        Session sesion = sessionFactory.openSession();  //Obtener la sesion  
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
    public boolean eliminarPro(Integer num) {
        boolean exito = false;
        Session sesion = sessionFactory.openSession();
        try {
            sesion.getTransaction().begin();
            Producto prod = sesion.get(Producto.class, num);
            if (prod != null) {
                sesion.remove(prod);
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
    public Producto getPro(Integer num) {
        Session sesion = sessionFactory.openSession();    
        Producto prod = sesion.get(Producto.class, num); 
        sesion.close();
        return prod;
    }

    @Override
    public List<Producto> getTodosPro() {
        
        Session session = sessionFactory.openSession();  
        org.hibernate.query.Query q = session.createQuery("from Producto c");   
        List<Producto> lista = q.getResultList();    
        session.close();
        
        return lista;
        
    }

    @Override
    @Transactional
    public boolean modificarOrInsertarPro(Producto dep) {
        
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
    public double getPrecio(Integer idpro) {
        
        Session session = sessionFactory.openSession();     
        org.hibernate.query.Query q = session.createQuery("select c.precio from Producto c where c.idProducto = :num");   
        q.setParameter("num", idpro);
        double lista = Double.valueOf((double)q.getResultList().get(0));    
        session.close();
        
        return lista;
        
    }

    @Override
    @Transactional
    public List<String> obtenerCategorias() {
        
        Session session = sessionFactory.openSession();  
        org.hibernate.query.Query q = session.createQuery("select distinct p.categoria from Producto p");   
        List<String> lista = q.getResultList();    
        session.close();
        
        return lista;
        
    }

    @Override
    public List<Producto> filtrarCat(String cat) {
        
        Session session = sessionFactory.openSession();  
        org.hibernate.query.Query q = session.createQuery("select p from Producto p where p.categoria = :cat");
        q.setParameter("cat", cat);
        List<Producto> productos = q.getResultList();
        return productos;
        
    }

    @Override
    @Transactional
    public int ultimoIdPro() {
        
        Session session = sessionFactory.openSession();     
        org.hibernate.query.Query q = session.createQuery("select u.idProducto from Producto u order by u.idProducto desc");
        q.setMaxResults(1);
        Integer id = (Integer) q.getSingleResult();
        Integer result= id +1;
        
        return result;
        
    }

    @Override
    public boolean proTiene(int i) {
        
        Session sesion = sessionFactory.openSession();
        
        org.hibernate.query.Query lineasQuery = sesion.createQuery("SELECT COUNT(l) FROM Lineaspedido l WHERE l.idProducto.idProducto = :idProducto");
        lineasQuery.setParameter("idProducto", i);
        Long lineas = (Long) lineasQuery.getSingleResult();

        
        org.hibernate.query.Query comentariosQuery = sesion.createQuery("SELECT COUNT(c) FROM Comentario c WHERE c.idProducto.idProducto = :idProducto");
        comentariosQuery.setParameter("idProducto", i);
        Long comentarios = (Long) comentariosQuery.getSingleResult();

        
        org.hibernate.query.Query cestasQuery = sesion.createQuery("SELECT COUNT(c) FROM Cesta c WHERE c.idProducto.idProducto = :idProducto");
        cestasQuery.setParameter("idProducto", i);
        Long cestas = (Long) cestasQuery.getSingleResult();

        
        if (lineas > 0 || comentarios > 0 || cestas > 0) {
            return true;
        }

        return false;
        
    }
    
}
