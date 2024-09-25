package es.dani.tiendapro.to.control.modelo;

import es.dani.tiendapro.to.control.modelo.Cesta;
import es.dani.tiendapro.to.control.modelo.Comentario;
import es.dani.tiendapro.to.control.modelo.Pedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-31T00:13:23")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> codigoPostal;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, String> direccion;
    public static volatile CollectionAttribute<Usuario, Cesta> cestaCollection;
    public static volatile SingularAttribute<Usuario, String> contrasena;
    public static volatile CollectionAttribute<Usuario, Pedido> pedidoCollection;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, String> email;
    public static volatile CollectionAttribute<Usuario, Comentario> comentarioCollection;
    public static volatile SingularAttribute<Usuario, String> perfil;

}