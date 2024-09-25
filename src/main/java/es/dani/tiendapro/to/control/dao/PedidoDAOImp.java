/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.dani.tiendapro.to.control.dao;

import es.dani.tiendapro.to.control.modelo.Pedido;
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
public class PedidoDAOImp implements PedidoDAO {
    
    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public boolean insertarPed(Pedido d) {
        
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
    public boolean eliminarPed(Integer num) {
        
        boolean exito = false;
        Session sesion = sessionFactory.openSession();
        try {
            sesion.getTransaction().begin();
            Pedido ped = sesion.get(Pedido.class, num);
            if (ped != null) {
                sesion.remove(ped);
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
    public boolean modificarPed(Pedido dNuevo) {
        
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
    public Pedido getPed(Integer num) {
        
        Session sesion = sessionFactory.openSession();     
        Pedido ped = sesion.get(Pedido.class, num); 
        sesion.close();
        return ped;
        
    }

    @Override
    @Transactional
    public List<Pedido> getTodosPed() {
        
        Session session = sessionFactory.openSession();  
        org.hibernate.query.Query q = session.createQuery("from Pedido c");   
        List<Pedido> lista = q.getResultList();   
        session.close();
        
        return lista;
        
    }

    @Override
    @Transactional
    public boolean modificarOrInsertarPed(Pedido dep) {
        
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
    public List<Pedido> getPedidosCli(Integer idcli) {
        
        Session session = sessionFactory.openSession();     
        org.hibernate.query.Query q = session.createQuery("from Pedido c where c.idUsuario.idUsuario = :num");    
        q.setParameter("num", idcli);
        List<Pedido> lista = q.getResultList();    
        session.close();
        
        return lista;
        
    }

    @Override
    @Transactional
    public int ultimoIdPed() {
        
        Session session = sessionFactory.openSession();     
        org.hibernate.query.Query q = session.createQuery("select u.idPedido from Pedido u order by u.idPedido desc");
        q.setMaxResults(1);
        Integer id = (Integer) q.getSingleResult();
        Integer result= id +1;
        
        return result;
        
    }

    @Override
    public boolean pedidoTiene(int i) {
        
        Session sesion = sessionFactory.openSession();
        
        org.hibernate.query.Query lineasQuery = sesion.createQuery("SELECT COUNT(l) FROM Lineaspedido l WHERE l.idPedido.idPedido = :idPedido");
        lineasQuery.setParameter("idPedido", i);
        Long lineas = (Long) lineasQuery.getSingleResult();

        
        if (lineas > 0) {
            return true;
        }

        return false;
        
    }
    
}
