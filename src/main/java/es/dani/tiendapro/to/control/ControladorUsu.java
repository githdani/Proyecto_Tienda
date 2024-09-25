/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.dani.tiendapro.to.control;

import es.dani.tiendapro.to.control.dao.UsuarioDAO;
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
@RequestMapping("/usuarios")
public class ControladorUsu {
    
    @Autowired
    UsuarioDAO usuarioDAO;
    
    @RequestMapping("lista")
    public String listarUsuarios(Model modelo){
        
        List<Usuario> lista = usuarioDAO.getTodosCli();
        
        modelo.addAttribute("ListaUsu", lista);
        return "usuarios";
    }
    
    //------------------------------------------------------------------------
    // FORMULARIO NUEVO Usuario
    @RequestMapping("/formularioNuevoUsuario")
    public String formularioCliente(Model modelo) {
        Usuario usuario = new Usuario();
        modelo.addAttribute("elUsuario", usuario);
        return "formularioUsuario";
    }

    // INSERTAR Usuario  -----------------------------
    @PostMapping("/insertarUsuario")
    public String insertarCliente(@ModelAttribute("elUsuario") Usuario usuario) {
        
        if(usuario.getIdUsuario() == null){
            usuario.setIdUsuario(usuarioDAO.ultimoIdUsuario());
        }
        usuario.setPerfil("/recursos/Imagenes/default.jpg");
        
        usuarioDAO.modificarOrInsertarCli(usuario);
        return "redirect:/usuarios/lista";
    }
    
    //------------------------------------------------------------------------
    // FORMULARIO ACTUALIZAR USUARIO
    
    @GetMapping(value = "/formularioActualizarUsuario")
    public String mostrarActualizarCliente(@RequestParam("idUsu") Integer idUsuario, Model modelo) {
        Usuario usuario = usuarioDAO.getCli(idUsuario);
        modelo.addAttribute("elUsuario", usuario);
        return "formularioUsuario";
        
    }

    // ACTUALIZAR USUARIO
    @PostMapping(value = "/actualizarUsuario")
    public String actualizarCliente(@ModelAttribute("elUsuario") Usuario usuario) {
        usuarioDAO.modificarOrInsertarCli(usuario);
        return "redirect:/usuarios/lista";
    }

    //--------------------------------------------------------------
    // ELIMINAR USUARIO
    
    @GetMapping(value = "/eliminarUsuario")
    public String eliminarCliente(@RequestParam("idUsu") Integer idUsuario) {
        
        if (usuarioDAO.usuarioTiene(idUsuario)) {
        
            return "avisoEliminar";
        } else {
            usuarioDAO.eliminarCli(idUsuario);
            return "redirect:/usuarios/lista";
        }
        
    }
}
