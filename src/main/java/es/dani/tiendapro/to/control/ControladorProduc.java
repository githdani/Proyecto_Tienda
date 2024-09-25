/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.dani.tiendapro.to.control;

import es.dani.tiendapro.to.control.dao.ProductoDAO;
import es.dani.tiendapro.to.control.modelo.Producto;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author dani1
 */

@Controller
@RequestMapping("/productos")
public class ControladorProduc {
    
    @Autowired
    ProductoDAO prodDAO;
    
    //-------------------------------------------------------------------------
    //LISTAR LOS PRODUCTOS
    @RequestMapping("/lista")
    public String listarProductos(Model modelo) {
        
        List<Producto> lista = prodDAO.getTodosPro();
        
        modelo.addAttribute("ListaProd", lista);
        return "productos";
    }
    
    //------------------------------------------------------------------------
    // FORMULARIO NUEVO PRODUCTOS
    @RequestMapping(value = "/formularioNuevoProducto")
    public String formularioProducto(Model modelo) {
        Producto prod = new Producto();
        modelo.addAttribute("elProd", prod);//"elCliente" será el vehículo donde viajará los datos del cliente
        return "formularioProducto";
    }

    // INSERTAR PRODUCTOS  -----------------------------
    @PostMapping(value = "/insertarProducto")
    public String insertarProducto(@ModelAttribute("elProd") Producto prod, 
            @RequestParam("file") MultipartFile file, HttpServletRequest request) {
        
        if(prod.getIdProducto() == null){
            prod.setIdProducto(prodDAO.ultimoIdPro());
        }
            
        if (!file.isEmpty()) {
            try{ 
                String rutaPro = "/recursos/Imagenes/Productos/" + file.getOriginalFilename();
                String destino = request.getSession().getServletContext().getRealPath("/recursos/Imagenes/Productos/") + file.getOriginalFilename();
                File destinoFile = new File(destino);
                FileCopyUtils.copy(file.getBytes(), destinoFile);

                prod.setImagen(rutaPro);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
         
        prodDAO.modificarOrInsertarPro(prod);
        return "redirect:/productos/lista";
    }

    //------------------------------------------------------------------------
    // FORMULARIO ACTUALIZAR PRODUCTOS
    
    @GetMapping(value = "/formularioActualizarProducto")
    public String mostrarActualizarProducto(@RequestParam("idPro") Integer idProd, Model modelo) {
        Producto prod = prodDAO.getPro(idProd);
        modelo.addAttribute("elProd", prod);
        return "formularioProducto";
        
    }

    // ACTUALIZAR PRODUCTOS
    @PostMapping(value = "/actualizarProducto")
    public String actualizarProducto(@ModelAttribute("elProd") Producto prod,
            @RequestParam("file") MultipartFile file, HttpServletRequest request) {
        
        if (!file.isEmpty()) {
            try{ 
                String rutaPro = "/recursos/Imagenes/Productos/" + file.getOriginalFilename();
                String destino = request.getSession().getServletContext().getRealPath("/recursos/Imagenes/Productos/") + file.getOriginalFilename();
                File destinoFile = new File(destino);
                FileCopyUtils.copy(file.getBytes(), destinoFile);

                prod.setImagen(rutaPro);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        prodDAO.modificarOrInsertarPro(prod);
        return "redirect:/productos/lista";
    }

    //--------------------------------------------------------------
    // ELIMINAR PRODUCTOS
    
    @GetMapping(value = "/eliminarProducto")
    public String eliminarProducto(@RequestParam("idPro") Integer idProd) {
        
        if (prodDAO.proTiene(idProd)) {
        
            return "avisoEliminar";
        } else {
            prodDAO.eliminarPro(idProd);
            return "redirect:/productos/lista";
        }
        
        
    }
}
