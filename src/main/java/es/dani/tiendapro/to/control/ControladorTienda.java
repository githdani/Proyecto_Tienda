/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.dani.tiendapro.to.control;

import es.dani.tiendapro.to.control.dao.CestaDAO;
import es.dani.tiendapro.to.control.dao.ComentDAO;
import es.dani.tiendapro.to.control.dao.ProductoDAO;
import es.dani.tiendapro.to.control.dao.UsuarioDAO;
import es.dani.tiendapro.to.control.modelo.Cesta;
import es.dani.tiendapro.to.control.modelo.Comentario;
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
@RequestMapping("/tienda")
public class ControladorTienda {
    
    @Autowired
    ProductoDAO proDAO;
    
    @Autowired
    UsuarioDAO usuDAO;
    
    @Autowired
    CestaDAO cesDAO;
    
    @Autowired
    ComentDAO coDAO;
    
    @RequestMapping("lista")
    public String listarTienda(Model modelo){
        
        List<Producto> pro = proDAO.getTodosPro();
        
        List<String> cat = proDAO.obtenerCategorias();
        
        Usuario usu = usuDAO.getCli(InicioSesion.getIdUsu());
        
        modelo.addAttribute("listaPro", pro);
        modelo.addAttribute("listaCat", cat);
        modelo.addAttribute("User", usu);
        
        return "tienda";
    }
    
    @RequestMapping("listarCate")
    public String FiltrarCate(@RequestParam("cate") String cate, Model modelo){
        
        List<Producto> pro = proDAO.filtrarCat(cate);
        
        List<String> cat = proDAO.obtenerCategorias();
        
        Usuario usu = usuDAO.getCli(InicioSesion.getIdUsu());
        
        modelo.addAttribute("listaPro", pro);
        modelo.addAttribute("listaCat", cat);
        modelo.addAttribute("User", usu);
        
        return "tienda";
    }
    
    @GetMapping("agregarCarro")
    public String agregarCarro(@RequestParam("idPro") Integer idPro) {
        
        Cesta cesta = new Cesta();
        
        cesta.setIdCesta(cesDAO.ultimoIdCes());
        cesta.setIdProducto(proDAO.getPro(idPro));
        cesta.setIdUsuario(usuDAO.getCli(InicioSesion.getIdUsu()));
        cesta.setCantidad(1);
        cesta.setTotalPrecio(proDAO.getPrecio(idPro));
        
        cesDAO.modificarOrInsertarCes(cesta);
        
        return "redirect:/tienda/lista";
    }
    
    @GetMapping("verDetalle")
    public String productoDetalle(@RequestParam("idPro") Integer idPro, Model modelo){
        
        Producto pro = proDAO.getPro(idPro);
        
        List<String> cat = proDAO.obtenerCategorias();
        
        List<Comentario> coment = coDAO.getComPro(idPro);
        
        Usuario usu = usuDAO.getCli(InicioSesion.getIdUsu());
        
        modelo.addAttribute("Produc", pro);
        modelo.addAttribute("listaCat", cat);
        modelo.addAttribute("Coment", coment);
        modelo.addAttribute("User", usu);
        
        return "detallesPro";
    }
    
    @PostMapping("/anadirCo")
    public String registrar(@RequestParam("punto") int punto, @RequestParam("text") String text,
            @RequestParam("idPro") int idPro, Model modelo){
        
        Comentario coment = new Comentario();
        
        coment.setIdComent(coDAO.ultimoIdCom());
        coment.setIdProducto(proDAO.getPro(idPro));
        coment.setIdUsuario(usuDAO.getCli(InicioSesion.getIdUsu()));
        coment.setPuntuacion(punto);
        coment.setTexto(text);
        
        coDAO.modificarOrInsertarCom(coment);
        
        Producto pro = proDAO.getPro(idPro);
        
        List<String> cat = proDAO.obtenerCategorias();
        
        List<Comentario> com = coDAO.getComPro(idPro);
        
        Usuario usu = usuDAO.getCli(InicioSesion.getIdUsu());
        
        modelo.addAttribute("Produc", pro);
        modelo.addAttribute("listaCat", cat);
        modelo.addAttribute("Coment", com);
        modelo.addAttribute("User", usu);
        
        return "detallesPro";
    }
    
}
