package es.dani.tiendapro.to.control.modelo;

import es.dani.tiendapro.to.control.modelo.Pedido;
import es.dani.tiendapro.to.control.modelo.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-31T00:13:23")
@StaticMetamodel(Lineaspedido.class)
public class Lineaspedido_ { 

    public static volatile SingularAttribute<Lineaspedido, Integer> idLineas;
    public static volatile SingularAttribute<Lineaspedido, Integer> cantidad;
    public static volatile SingularAttribute<Lineaspedido, Producto> idProducto;
    public static volatile SingularAttribute<Lineaspedido, Pedido> idPedido;
    public static volatile SingularAttribute<Lineaspedido, Double> totalPrecio;

}