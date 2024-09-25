/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.dani.tiendapro.to.control;


import es.dani.tiendapro.to.control.dao.ComentDAO;
import es.dani.tiendapro.to.control.dao.ProductoDAO;
import es.dani.tiendapro.to.control.dao.UsuarioDAO;
import es.dani.tiendapro.to.control.modelo.Comentario;

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
@RequestMapping("comentario")
public class ControladorCom {
    
    @Autowired
    ComentDAO comDAO;
    
    @Autowired
    ProductoDAO proDAO;
    
    @Autowired
    UsuarioDAO usuDAO;
            
    //-------------------------------------------------------------------------
    //LISTAR LOS DETALLE
    @RequestMapping(value = "/lista") 
    public String listarDetalles(Model modelo) {
        //obtener los clientes del dao
        List<Comentario> lista = comDAO.getTodosCom();
        //agregar los clientes al modelo
        modelo.addAttribute("ListaCo", lista);
        return "comentario";
    }
    
    //------------------------------------------------------------------------
    // FORMULARIO NUEVO DETALLE
    @RequestMapping(value = "/formularioNuevoCo")
    public String formularioDetalle(Model modelo) {
        Comentario det = new Comentario();
        List<Usuario> listUs = usuDAO.getTodosCli();
        List<Producto> listPro = proDAO.getTodosPro();
       
        modelo.addAttribute("listaProd", listPro);
        modelo.addAttribute("listaUsu", listUs);
        modelo.addAttribute("elCo", det);//"elCliente" será el vehículo donde viajará los datos del cliente
        return "formularioComentario";
    }
    
    // INSERTAR DETALLE  -----------------------------
    @PostMapping(value = "/insertarCo")
    public String insertarDetalle(@ModelAttribute("elCo") Comentario det) {
        
        if(det.getIdComent() == null){
            det.setIdComent(comDAO.ultimoIdCom());
        }
            
        comDAO.modificarOrInsertarCom(det);
        return "redirect:/comentario/lista";
    }

    //------------------------------------------------------------------------
    // FORMULARIO ACTUALIZAR DETALLE
    
    @GetMapping(value = "/formularioActualizarCo")
    public String mostrarActualizarDetalle(@RequestParam("idCo") Integer idCo, Model modelo) {
        Comentario det = comDAO.getCom(idCo);
        List<Usuario> listUsu = usuDAO.getTodosCli();
        List<Producto> listPro = proDAO.getTodosPro();
       
        modelo.addAttribute("listaProd", listPro);
        modelo.addAttribute("listaUsu", listUsu);
        modelo.addAttribute("elCo", det);
        return "formularioComentario";
        
    }

    // ACTUALIZAR DETALLE
    @PostMapping(value = "/actualizarCo")
    public String actualizarDetalle(@ModelAttribute("elCo") Comentario det) {
        
        
        
        comDAO.modificarOrInsertarCom(det);
        return "redirect:/comentario/lista";
    }

    //--------------------------------------------------------------
    // ELIMINAR DETALLE
    
    @GetMapping(value = "/eliminarCo")
    public String eliminarDetalle(@RequestParam("idCo") Integer idDet) {
        comDAO.eliminarCom(idDet);
        return "redirect:/comentario/lista";
    }
    
}
