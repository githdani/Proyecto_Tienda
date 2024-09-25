package es.dani.tiendapro.to.control.modelo;

import es.dani.tiendapro.to.control.modelo.Producto;
import es.dani.tiendapro.to.control.modelo.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-31T00:13:23")
@StaticMetamodel(Cesta.class)
public class Cesta_ { 

    public static volatile SingularAttribute<Cesta, Integer> idCesta;
    public static volatile SingularAttribute<Cesta, Usuario> idUsuario;
    public static volatile SingularAttribute<Cesta, Integer> cantidad;
    public static volatile SingularAttribute<Cesta, Producto> idProducto;
    public static volatile SingularAttribute<Cesta, Double> totalPrecio;

}