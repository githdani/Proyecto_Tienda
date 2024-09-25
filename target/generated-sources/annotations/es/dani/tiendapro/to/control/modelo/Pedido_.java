package es.dani.tiendapro.to.control.modelo;

import es.dani.tiendapro.to.control.modelo.Lineaspedido;
import es.dani.tiendapro.to.control.modelo.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-31T00:13:23")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, Usuario> idUsuario;
    public static volatile SingularAttribute<Pedido, Integer> idPedido;
    public static volatile CollectionAttribute<Pedido, Lineaspedido> lineaspedidoCollection;

}