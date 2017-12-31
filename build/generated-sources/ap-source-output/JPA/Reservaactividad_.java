package JPA;

import JPA.Actividad;
import JPA.Alumno;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-26T20:35:35")
@StaticMetamodel(Reservaactividad.class)
public class Reservaactividad_ { 

    public static volatile SingularAttribute<Reservaactividad, String> hora;
    public static volatile SingularAttribute<Reservaactividad, Alumno> alumno;
    public static volatile SingularAttribute<Reservaactividad, Integer> idReservaActividad;
    public static volatile SingularAttribute<Reservaactividad, String> dia;
    public static volatile SingularAttribute<Reservaactividad, Actividad> actividad;

}