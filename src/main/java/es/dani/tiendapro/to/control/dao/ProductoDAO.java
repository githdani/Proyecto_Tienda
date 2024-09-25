/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package es.dani.tiendapro.to.control.dao;

import es.dani.tiendapro.to.control.modelo.Producto;
import java.util.List;

/**
 *
 * @author dani1
 */
public interface ProductoDAO {
    
    public boolean insertarPro(Producto d);

    public boolean eliminarPro(Integer num);

    public Producto getPro(Integer num);

    public List<Producto> getTodosPro();

    public boolean modificarOrInsertarPro(Producto dep);
    
    public double getPrecio(Integer idpro);
    
    public List<String> obtenerCategorias();
    
    public List<Producto> filtrarCat(String cat);
    
    public int ultimoIdPro();
    
    public boolean proTiene(int id);
}
