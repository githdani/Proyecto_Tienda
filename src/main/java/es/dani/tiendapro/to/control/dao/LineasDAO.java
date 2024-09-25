/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package es.dani.tiendapro.to.control.dao;

import es.dani.tiendapro.to.control.modelo.Lineaspedido;
import java.util.List;

/**
 *
 * @author dani1
 */
public interface LineasDAO {
    
    public boolean insertarDet(Lineaspedido d);

    public boolean eliminarDet(Integer num);

    public boolean modificarDet(Lineaspedido dNuevo);

    public Lineaspedido getDet(Integer num);

    public List<Lineaspedido> getTodosDet();

    public boolean modificarOrInsertarDet(Lineaspedido dep);
    
    public List<Lineaspedido> getDetallesPed(Integer idped);
    
    public int ultimoIdLin();
    
    public double getTotal(Integer num);
}
