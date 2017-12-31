package JPA;

import JPA.Alumno;
import JPA.Libro;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-26T20:35:35")
@StaticMetamodel(Reservalibro.class)
public class Reservalibro_ { 

    public static volatile SingularAttribute<Reservalibro, String> fechaentrega;
    public static volatile SingularAttribute<Reservalibro, String> fechadevolucion;
    public static volatile SingularAttribute<Reservalibro, Libro> libro;
    public static volatile SingularAttribute<Reservalibro, Integer> idReservaLibro;
    public static volatile SingularAttribute<Reservalibro, Alumno> alumno;

}