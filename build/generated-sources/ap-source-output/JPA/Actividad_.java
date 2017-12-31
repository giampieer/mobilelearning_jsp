package JPA;

import JPA.Reservaactividad;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-26T20:35:35")
@StaticMetamodel(Actividad.class)
public class Actividad_ { 

    public static volatile SingularAttribute<Actividad, String> estado;
    public static volatile SingularAttribute<Actividad, Integer> idActividad;
    public static volatile CollectionAttribute<Actividad, Reservaactividad> reservaactividadCollection;
    public static volatile SingularAttribute<Actividad, String> nombre;

}