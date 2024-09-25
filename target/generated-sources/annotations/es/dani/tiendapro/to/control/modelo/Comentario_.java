package es.dani.tiendapro.to.control.modelo;

import es.dani.tiendapro.to.control.modelo.Producto;
import es.dani.tiendapro.to.control.modelo.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-31T00:13:23")
@StaticMetamodel(Comentario.class)
public class Comentario_ { 

    public static volatile SingularAttribute<Comentario, String> texto;
    public static volatile SingularAttribute<Comentario, Integer> puntuacion;
    public static volatile SingularAttribute<Comentario, Usuario> idUsuario;
    public static volatile SingularAttribute<Comentario, Integer> idComent;
    public static volatile SingularAttribute<Comentario, Producto> idProducto;

}