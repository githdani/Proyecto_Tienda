/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.dani.tiendapro.to.control;

import es.dani.tiendapro.to.control.dao.PedidoDAO;
import es.dani.tiendapro.to.control.dao.UsuarioDAO;
import es.dani.tiendapro.to.control.modelo.Pedido;
import es.dani.tiendapro.to.control.modelo.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author dani1
 */

@Controller
@RequestMapping("/pedidos")
public class ControladorPed {
    
    @Autowired    
    PedidoDAO pedDAO;
    
    @Autowired
    UsuarioDAO usuarioDAO;
    
    //-------------------------------------------------------------------------
    //LISTAR LOS PEDIDO
    @RequestMapping(value ="/listaped") 
    public String listarPedidos(Model modelo) {
        //obtener los clientes del dao
        List<Pedido> lista = pedDAO.getTodosPed();
        //agregar los clientes al modelo
        modelo.addAttribute("ListaPed", lista);
        return "pedidos";
    }
    
    //------------------------------------------------------------------------
    // FORMULARIO NUEVO PEDIDO
    @RequestMapping(value ="/formularioNuevoPedido")
    public String formularioPedido(Model modelo) {
        Pedido ped = new Pedido();
        List<Usuario> lista = usuarioDAO.getTodosCli();
       
        modelo.addAttribute("ListaUsu", lista);
        modelo.addAttribute("elPed", ped);
        return "formularioPedido";
    }

    // INSERTAR PEDIDO  -----------------------------
    @PostMapping(value ="/insertarPedido")
    public String insertarPedido(@ModelAttribute("elPed") Pedido ped) {
        
        if(ped.getIdPedido() == null){
            ped.setIdPedido(pedDAO.ultimoIdPed());
        }
            
        pedDAO.modificarOrInsertarPed(ped);
        return "redirect:/pedidos/listaped";
    }

    //------------------------------------------------------------------------
    // FORMULARIO ACTUALIZAR PEDIDO
    
    @GetMapping(value="/formularioActualizarPedido")
    public String mostrarActualizarPedido(@RequestParam("idPed") Integer idPed, Model modelo) {
        Pedido ped = pedDAO.getPed(idPed);
        List<Usuario> lista = usuarioDAO.getTodosCli();
       
        modelo.addAttribute("ListaUsu", lista);
        modelo.addAttribute("elPed", ped);
        return "formularioPedido";
        
    }

    // ACTUALIZAR PEDIDO
    @PostMapping(value="/actualizarPedido")
    public String actualizarPedido(@ModelAttribute("elPed") Pedido ped) {
        
        
        pedDAO.modificarOrInsertarPed(ped);
        return "redirect:/pedidos/listaped";
    }

    //--------------------------------------------------------------
    // ELIMINAR PEDIDO
    
    @GetMapping(value="/eliminarPedido")
    public String eliminarPedido(@RequestParam("idPed") Integer idPed) {
        
        if (pedDAO.pedidoTiene(idPed)) {
        
            return "avisoEliminar";
        } else {
            pedDAO.eliminarPed(idPed);
            return "redirect:/pedidos/listaped";
        }
  
    }
    
}
