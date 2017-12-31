package JPA;

import JPA.Matricula;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-26T20:35:35")
@StaticMetamodel(Administrador.class)
public class Administrador_ { 

    public static volatile SingularAttribute<Administrador, Integer> idadministrador;
    public static volatile SingularAttribute<Administrador, String> clave;
    public static volatile SingularAttribute<Administrador, String> apellido;
    public static volatile SingularAttribute<Administrador, String> correo;
    public static volatile SingularAttribute<Administrador, String> usuario;
    public static volatile CollectionAttribute<Administrador, Matricula> matriculaCollection;
    public static volatile SingularAttribute<Administrador, Integer> sexo;
    public static volatile SingularAttribute<Administrador, String> nombre;
    public static volatile SingularAttribute<Administrador, Integer> edad;

}