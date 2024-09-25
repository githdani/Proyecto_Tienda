/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.dani.tiendapro.to.control;

import es.dani.tiendapro.to.control.dao.UsuarioDAO;
import es.dani.tiendapro.to.control.modelo.Usuario;
import es.dani.tiendapro.to.control.sesion.InicioSesion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author dani1
 */

@Controller
public class Controlador {
    
    @Autowired
    UsuarioDAO usuDAO;
    
    @RequestMapping("/")
    public String mostrarIndex(Model modelo){
        return "index";
    }
    
    @PostMapping("/iniciarSesion")
    public RedirectView inicioSesion(@RequestParam("usuario") String usuario, @RequestParam("passw") String pasw){
        
        
        
        String ret = "http://localhost:8085/CompTore/";
        
        if(usuario.equals("admin") && pasw.equals("admin")){
            return new RedirectView("http://localhost:8085/CompTore/usuarios/lista");
        } else {
            List<Usuario> lista = usuDAO.getTodosCli();
            
            for(Usuario usu : lista){
                
                if(usu.getNombre().equals(usuario) && usu.getContrasena().equals(pasw)){
                    
                    InicioSesion.setIdUsu(usu.getIdUsuario());
                    
                    ret = "http://localhost:8085/CompTore/tienda/lista";
                }
            }
        }

        return new RedirectView(ret);
    }
    
    @PostMapping("/registrar")
    public String registrar(@RequestParam("usuario") String usuario, @RequestParam("passw") String pasw,
            @RequestParam("email") String email, @RequestParam("direccion") String dir, @RequestParam("codP") String cp){
        
        Usuario usu = new Usuario();
        
        usu.setIdUsuario(usuDAO.ultimoIdUsuario());
        
        usu.setNombre(usuario);
        usu.setContrasena(pasw);
        usu.setEmail(email);
        usu.setDireccion(dir);
        usu.setCodigoPostal(cp);
        usu.setPerfil("/recursos/Imagenes/default.jpg");
        
        usuDAO.modificarOrInsertarCli(usu);
        
        return "index";
    }
}
