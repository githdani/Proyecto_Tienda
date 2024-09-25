/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.dani.tiendapro.to.control;

import es.dani.tiendapro.to.control.dao.CestaDAO;
import es.dani.tiendapro.to.control.dao.LineasDAO;
import es.dani.tiendapro.to.control.dao.PedidoDAO;
import es.dani.tiendapro.to.control.dao.ProductoDAO;
import es.dani.tiendapro.to.control.dao.UsuarioDAO;
import es.dani.tiendapro.to.control.modelo.Cesta;
import es.dani.tiendapro.to.control.modelo.Lineaspedido;
import es.dani.tiendapro.to.control.modelo.Pedido;
import es.dani.tiendapro.to.control.modelo.Producto;
import es.dani.tiendapro.to.control.modelo.Usuario;
import es.dani.tiendapro.to.control.sesion.InicioSesion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author dani1
 */
@Controller
@RequestMapping("/tiendaCarro")
public class ControladorTiendaCarro {
    
    @Autowired
    ProductoDAO proDAO;
    
    @Autowired
    UsuarioDAO usuDAO;
    
    @Autowired
    CestaDAO cesDAO;
    
    @Autowired
    PedidoDAO pedDAO;
    
    @Autowired
    LineasDAO linDAO;
    
    @RequestMapping("lista")
    public String listarTienda(Model modelo){
        
        int i = InicioSesion.getIdUsu();
        
        List<Cesta> ces = cesDAO.getCesUs(i);
        
        List<String> cat = proDAO.obtenerCategorias();
        
        Usuario usu = usuDAO.getCli(i);
        
        double total = cesDAO.getTotal(i);
        
        System.out.println(total);
        modelo.addAttribute("PrecioTotal", total);
        modelo.addAttribute("ListaCe", ces);
        modelo.addAttribute("listaCat", cat);
        modelo.addAttribute("User", usu);
        
        return "tiendaCarro";
    }
    
    @PostMapping("/modificarCantidad")
    public String guardar(@RequestParam("cant") int cant, @RequestParam("precio") double precio,
            @RequestParam("idCes") int idces){
        
        Cesta ces = cesDAO.getCes(idces);
        
        ces.setCantidad(cant);
        
        double total = precio * cant;
        
        ces.setTotalPrecio(total);
        
        cesDAO.modificarOrInsertarCes(ces);
        return "redirect:/tiendaCarro/lista";
    }
    
    @PostMapping("/comprar")
    public String comprar(){
        
        Pedido ped = new Pedido();
        ped.setIdPedido(pedDAO.ultimoIdPed());
        ped.setIdUsuario(usuDAO.getCli(InicioSesion.getIdUsu()));
        
        pedDAO.modificarOrInsertarPed(ped);
        
        List<Cesta> ces = cesDAO.getCesUs(InicioSesion.getIdUsu());
        
        for(Cesta ce : ces){
            Lineaspedido li = new Lineaspedido();
            
            li.setIdLineas(linDAO.ultimoIdLin());
            
            li.setIdPedido(ped);
            li.setIdProducto(ce.getIdProducto());
            li.setCantidad(ce.getCantidad());
            li.setTotalPrecio(ce.getTotalPrecio());
            
            linDAO.modificarOrInsertarDet(li);
            cesDAO.eliminarCes(ce.getIdCesta());
        }
        
        
        return "redirect:/tiendaCarro/lista";
    }
    
    @GetMapping(value = "/eliminarCesta")
    public String eliminarDetalle(@RequestParam("idCes") Integer idDet) {
        cesDAO.eliminarCes(idDet);
        return "redirect:/tiendaCarro/lista";
    }
}
