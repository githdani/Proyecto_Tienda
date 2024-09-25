/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package es.dani.tiendapro.to.control.dao;

import es.dani.tiendapro.to.control.modelo.Pedido;
import java.util.List;

/**
 *
 * @author dani1
 */
public interface PedidoDAO {
    
    public boolean insertarPed(Pedido d);

    public boolean eliminarPed(Integer num);

    
    public boolean modificarPed(Pedido dNuevo);
    
    
    public Pedido getPed(Integer num);

    public List<Pedido> getTodosPed();

    public boolean modificarOrInsertarPed(Pedido dep);
    
    public List<Pedido> getPedidosCli(Integer idcli);
    
    public int ultimoIdPed();
    
    public boolean pedidoTiene(int id);
    
}
