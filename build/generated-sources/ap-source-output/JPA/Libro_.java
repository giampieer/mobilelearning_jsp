package JPA;

import JPA.Reservalibro;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-26T20:35:35")
@StaticMetamodel(Libro.class)
public class Libro_ { 

    public static volatile SingularAttribute<Libro, String> estado;
    public static volatile SingularAttribute<Libro, Integer> idLibro;
    public static volatile SingularAttribute<Libro, Integer> ejemplares;
    public static volatile SingularAttribute<Libro, String> nombre;
    public static volatile SingularAttribute<Libro, String> autor;
    public static volatile CollectionAttribute<Libro, Reservalibro> reservalibroCollection;

}