/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.dani.tiendapro.to.control;

import es.dani.tiendapro.to.control.dao.CestaDAO;
import es.dani.tiendapro.to.control.dao.ProductoDAO;
import es.dani.tiendapro.to.control.dao.UsuarioDAO;
import es.dani.tiendapro.to.control.modelo.Cesta;


import es.dani.tiendapro.to.control.modelo.Producto;
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
@RequestMapping("cesta")
public class ControladorCesta {
    
    @Autowired
    CestaDAO cesDAO;
    
    @Autowired
    ProductoDAO proDAO;
    
    @Autowired
    UsuarioDAO usuDAO;
            
    //-------------------------------------------------------------------------
    //LISTAR LOS DETALLE
    @RequestMapping(value = "/lista") 
    public String listarDetalles(Model modelo) {
        //obtener los clientes del dao
        List<Cesta> lista = cesDAO.getTodosCes();
        //agregar los clientes al modelo
        modelo.addAttribute("ListaCe", lista);
        return "cesta";
    }
    
    //------------------------------------------------------------------------
    // FORMULARIO NUEVO DETALLE
    @RequestMapping(value = "/formularioNuevaCesta")
    public String formularioDetalle(Model modelo) {
        Cesta det = new Cesta();
        List<Usuario> listUs = usuDAO.getTodosCli();
        List<Producto> listPro = proDAO.getTodosPro();
       
        modelo.addAttribute("listaProd", listPro);
        modelo.addAttribute("listaUsu", listUs);
        modelo.addAttribute("elCes", det);//"elCliente" será el vehículo donde viajará los datos del cliente
        return "formularioCesta";
    }
    
    // INSERTAR DETALLE  -----------------------------
    @PostMapping(value = "/insertarCesta")
    public String insertarDetalle(@ModelAttribute("elCes") Cesta det) {
        
        if(det.getIdCesta() == null){
            det.setIdCesta(cesDAO.ultimoIdCes());
        }
        
        Producto pro = det.getIdProducto();
        Integer id = pro.getIdProducto();
        
        double precio = proDAO.getPrecio(id);
        
        double total = precio * det.getCantidad();
        
        det.setTotalPrecio(total);
        
        cesDAO.modificarOrInsertarCes(det);
        return "redirect:/cesta/lista";
    }

    //------------------------------------------------------------------------
    // FORMULARIO ACTUALIZAR DETALLE
    
    @GetMapping(value = "/formularioActualizarCesta")
    public String mostrarActualizarDetalle(@RequestParam("idCes") Integer idCes, Model modelo) {
        Cesta det = cesDAO.getCes(idCes);
        List<Usuario> listUsu = usuDAO.getTodosCli();
        List<Producto> listPro = proDAO.getTodosPro();
       
        modelo.addAttribute("listaProd", listPro);
        modelo.addAttribute("listaUsu", listUsu);
        modelo.addAttribute("elCes", det);
        return "formularioCesta";
        
    }

    // ACTUALIZAR DETALLE
    @PostMapping(value = "/actualizarCesta")
    public String actualizarDetalle(@ModelAttribute("elCes") Cesta det) {
        Producto pro = det.getIdProducto();
        Integer id = pro.getIdProducto();
        
        double precio = proDAO.getPrecio(id);
        
        double total = precio * det.getCantidad();
        
        det.setTotalPrecio(total);
        
        
        cesDAO.modificarOrInsertarCes(det);
        return "redirect:/cesta/lista";
    }

    //--------------------------------------------------------------
    // ELIMINAR DETALLE
    
    @GetMapping(value = "/eliminarCesta")
    public String eliminarDetalle(@RequestParam("idCes") Integer idDet) {
        cesDAO.eliminarCes(idDet);
        return "redirect:/cesta/lista";
    }
    
}
