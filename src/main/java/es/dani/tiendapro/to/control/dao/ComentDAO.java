/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package es.dani.tiendapro.to.control.dao;


import es.dani.tiendapro.to.control.modelo.Comentario;
import java.util.List;

/**
 *
 * @author dani1
 */
public interface ComentDAO {
    
     public boolean insertarCom(Comentario d);

    public boolean eliminarCom(Integer num);

    public boolean modificarCom(Comentario dNuevo);

    public Comentario getCom(Integer num);

    public List<Comentario> getTodosCom();

    public boolean modificarOrInsertarCom(Comentario dep);
    
    public int ultimoIdCom();
    
    public List<Comentario> getComPro(Integer idPro);
}
