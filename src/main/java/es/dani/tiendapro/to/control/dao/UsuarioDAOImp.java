/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.dani.tiendapro.to.control.dao;

import es.dani.tiendapro.to.control.modelo.Usuario;
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
public class UsuarioDAOImp implements UsuarioDAO{

    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public boolean insertarCli(Usuario d) {
        
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
    public boolean eliminarCli(Integer num) {
       
        boolean exito = false;
        Session sesion = sessionFactory.openSession();
        try {
            sesion.getTransaction().begin();
            Usuario cliente = sesion.get(Usuario.class, num);
            if (cliente != null) {
                sesion.remove(cliente);
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
    public Usuario getCli(Integer num) {
        
        Session sesion = sessionFactory.openSession();    
        Usuario cliente = sesion.get(Usuario.class, num); 
        sesion.close();
        return cliente;
        
    }

    @Override
    @Transactional
    public List<Usuario> getTodosCli() {
        
        Session session = sessionFactory.openSession();     
        org.hibernate.query.Query q = session.createQuery("from Usuario u");    
        List<Usuario> lista = q.getResultList();    
        session.close();
        
        return lista;
        
    }

    @Override
    @Transactional
    public boolean modificarOrInsertarCli(Usuario dep) {
        
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
    public int ultimoIdUsuario() {
        
        Session session = sessionFactory.openSession();     
        org.hibernate.query.Query q = session.createQuery("select u.idUsuario from Usuario u order by u.idUsuario desc");
        q.setMaxResults(1);
        Integer id = (Integer) q.getSingleResult();
        Integer result= id +1;
        
        return result;
        
    }

    @Override
    @Transactional
    public boolean usuarioTiene(int i) {
        
        Session sesion = sessionFactory.openSession();
        
        org.hibernate.query.Query pedidosQuery = sesion.createQuery("SELECT COUNT(p) FROM Pedido p WHERE p.idUsuario.idUsuario = :idUsuario");
        pedidosQuery.setParameter("idUsuario", i);
        Long pedidos = (Long) pedidosQuery.getSingleResult();

        
        org.hibernate.query.Query comentariosQuery = sesion.createQuery("SELECT COUNT(c) FROM Comentario c WHERE c.idUsuario.idUsuario = :idUsuario");
        comentariosQuery.setParameter("idUsuario", i);
        Long comentarios = (Long) comentariosQuery.getSingleResult();

        
        org.hibernate.query.Query cestasQuery = sesion.createQuery("SELECT COUNT(c) FROM Cesta c WHERE c.idUsuario.idUsuario = :idUsuario");
        cestasQuery.setParameter("idUsuario", i);
        Long cestas = (Long) cestasQuery.getSingleResult();

        
        if (pedidos > 0 || comentarios > 0 || cestas > 0) {
            return true;
        }

        return false;
        
    }
    
}
