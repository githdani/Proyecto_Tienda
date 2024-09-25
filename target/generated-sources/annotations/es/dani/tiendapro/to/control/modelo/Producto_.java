package es.dani.tiendapro.to.control.modelo;

import es.dani.tiendapro.to.control.modelo.Cesta;
import es.dani.tiendapro.to.control.modelo.Comentario;
import es.dani.tiendapro.to.control.modelo.Lineaspedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-31T00:13:23")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, Double> precio;
    public static volatile SingularAttribute<Producto, String> categoria;
    public static volatile CollectionAttribute<Producto, Cesta> cestaCollection;
    public static volatile SingularAttribute<Producto, String> imagen;
    public static volatile SingularAttribute<Producto, Integer> idProducto;
    public static volatile SingularAttribute<Producto, String> nombre;
    public static volatile CollectionAttribute<Producto, Lineaspedido> lineaspedidoCollection;
    public static volatile CollectionAttribute<Producto, Comentario> comentarioCollection;

}