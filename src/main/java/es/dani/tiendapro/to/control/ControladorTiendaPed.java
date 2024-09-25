/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.dani.tiendapro.to.control;

import es.dani.tiendapro.to.control.dao.LineasDAO;
import es.dani.tiendapro.to.control.dao.PedidoDAO;
import es.dani.tiendapro.to.control.dao.ProductoDAO;
import es.dani.tiendapro.to.control.dao.UsuarioDAO;
import es.dani.tiendapro.to.control.modelo.Lineaspedido;
import es.dani.tiendapro.to.control.modelo.Pedido;
import es.dani.tiendapro.to.control.modelo.Usuario;
import es.dani.tiendapro.to.control.sesion.InicioSesion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author dani1
 */
@Controller
@RequestMapping("/tiendaPed")
public class ControladorTiendaPed {
    
    @Autowired
    UsuarioDAO usuDAO;
    
    @Autowired
    PedidoDAO pedDAO;
    
    @Autowired
    LineasDAO linDAO;
    
    
    
    @RequestMapping("lista") 
    public String listarPedidos(Model modelo) {
        
        int i = InicioSesion.getIdUsu();
        
        List<Pedido> lista = pedDAO.getPedidosCli(i);
        
        
        
        Usuario usu = usuDAO.getCli(i);
        
        modelo.addAttribute("User", usu);
        modelo.addAttribute("ListaPed", lista);
        
        return "tiendaPed";
    }
    
    @RequestMapping(value = "/listarDetalles") 
    public String listarPedido(@RequestParam("idPed") Integer idped, Model modelo) {

        int i = InicioSesion.getIdUsu();
        
        List<Lineaspedido> lista = linDAO.getDetallesPed(idped);
        double total = linDAO.getTotal(idped);
        
        Usuario usu = usuDAO.getCli(i);
        
        modelo.addAttribute("TotalPrecio", total);
        modelo.addAttribute("User", usu);
        modelo.addAttribute("laLista", lista);
        return "tiendaDet";
    }
    
}
