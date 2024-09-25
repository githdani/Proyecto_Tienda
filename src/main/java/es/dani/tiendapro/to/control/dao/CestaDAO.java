/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package es.dani.tiendapro.to.control.dao;


import es.dani.tiendapro.to.control.modelo.Cesta;
import java.util.List;

/**
 *
 * @author dani1
 */
public interface CestaDAO {
    
    public boolean insertarCes(Cesta d);

    public boolean eliminarCes(Integer num);

    public boolean modificarCes(Cesta dNuevo);

    public Cesta getCes(Integer num);

    public List<Cesta> getTodosCes();

    public boolean modificarOrInsertarCes(Cesta dep);
    
    public int ultimoIdCes();
    
    public List<Cesta> getCesUs(Integer num);
    
    public double getTotal(Integer num);
    
}
