/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package es.dani.tiendapro.to.control.dao;

import es.dani.tiendapro.to.control.modelo.Usuario;
import java.util.List;

/**
 *
 * @author dani1
 */
public interface UsuarioDAO {
    
    public boolean insertarCli(Usuario d);

    public boolean eliminarCli(Integer num);

    public Usuario getCli(Integer num);

    public List<Usuario> getTodosCli();

    public boolean modificarOrInsertarCli(Usuario dep);
    
    public int ultimoIdUsuario();
    
    public boolean usuarioTiene(int id);
}
