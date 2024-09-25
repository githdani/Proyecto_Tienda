/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.dani.tiendapro.to.control;

import es.dani.tiendapro.to.control.dao.LineasDAO;
import es.dani.tiendapro.to.control.dao.PedidoDAO;
import es.dani.tiendapro.to.control.dao.ProductoDAO;
import es.dani.tiendapro.to.control.modelo.Lineaspedido;
import es.dani.tiendapro.to.control.modelo.Pedido;
import es.dani.tiendapro.to.control.modelo.Producto;
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
@RequestMapping("lineas")
public class ControladorLine {
    
    @Autowired
    LineasDAO linDAO;
    
    @Autowired
    PedidoDAO pedDAO;
    
    @Autowired
    ProductoDAO proDAO;
    
    //-------------------------------------------------------------------------
    //LISTAR LOS DETALLE
    @RequestMapping(value = "/lista") 
    public String listarDetalles(Model modelo) {
        //obtener los clientes del dao
        List<Lineaspedido> lista = linDAO.getTodosDet();
        //agregar los clientes al modelo
        modelo.addAttribute("ListaLi", lista);
        return "lineas";
    }
    
    //------------------------------------------------------------------------
    // FORMULARIO NUEVO DETALLE
    @RequestMapping(value = "/formularioNuevaLinea")
    public String formularioDetalle(Model modelo) {
        Lineaspedido det = new Lineaspedido();
        List<Pedido> listPe = pedDAO.getTodosPed();
        List<Producto> listPro = proDAO.getTodosPro();
       
        modelo.addAttribute("listaProd", listPro);
        modelo.addAttribute("listaPed", listPe);
        modelo.addAttribute("elLin", det);//"elCliente" será el vehículo donde viajará los datos del cliente
        return "formularioLinea";
    }
    
    // INSERTAR DETALLE  -----------------------------
    @PostMapping(value = "/insertarLinea")
    public String insertarDetalle(@ModelAttribute("elLin") Lineaspedido det) {
        
        if(det.getIdLineas() == null){
            det.setIdLineas(linDAO.ultimoIdLin());
        }
        
        Producto pro = det.getIdProducto();
        Integer id = pro.getIdProducto();
        
        double precio = proDAO.getPrecio(id);
        
        double total = precio * det.getCantidad();
        
        det.setTotalPrecio(total);
        
        linDAO.modificarOrInsertarDet(det);
        return "redirect:/lineas/lista";
    }

    //------------------------------------------------------------------------
    // FORMULARIO ACTUALIZAR DETALLE
    
    @GetMapping(value = "/formularioActualizarLinea")
    public String mostrarActualizarDetalle(@RequestParam("idLin") Integer idLin, Model modelo) {
        Lineaspedido det = linDAO.getDet(idLin);
        List<Pedido> listPe = pedDAO.getTodosPed();
        List<Producto> listPro = proDAO.getTodosPro();
       
        modelo.addAttribute("listaProd", listPro);
        modelo.addAttribute("listaPed", listPe);
        modelo.addAttribute("elLin", det);
        return "formularioLinea";
        
    }

    // ACTUALIZAR DETALLE
    @PostMapping(value = "/actualizarLinea")
    public String actualizarDetalle(@ModelAttribute("elLin") Lineaspedido det) {
        Producto pro = det.getIdProducto();
        Integer id = pro.getIdProducto();
        
        double precio = proDAO.getPrecio(id);
        
        double total = precio * det.getCantidad();
        
        det.setTotalPrecio(total);
        
        
        linDAO.modificarOrInsertarDet(det);
        return "redirect:/lineas/lista";
    }

    //--------------------------------------------------------------
    // ELIMINAR DETALLE
    
    @GetMapping(value = "/eliminarLinea")
    public String eliminarDetalle(@RequestParam("idLin") Integer idLin) {
        
        linDAO.eliminarDet(idLin);
        return "redirect:/lineas/lista";
    }
}
