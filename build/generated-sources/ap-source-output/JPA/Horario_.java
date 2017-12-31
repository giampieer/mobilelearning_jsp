package JPA;

import JPA.Anuncios;
import JPA.Curso;
import JPA.Profesor;
import JPA.Recursos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-26T20:35:35")
@StaticMetamodel(Horario.class)
public class Horario_ { 

    public static volatile SingularAttribute<Horario, String> fechainicio;
    public static volatile SingularAttribute<Horario, String> horafin;
    public static volatile SingularAttribute<Horario, Curso> curso;
    public static volatile SingularAttribute<Horario, Integer> idhorario;
    public static volatile SingularAttribute<Horario, String> fechafin;
    public static volatile SingularAttribute<Horario, Profesor> profesor;
    public static volatile SingularAttribute<Horario, String> horainicio;
    public static volatile CollectionAttribute<Horario, Anuncios> anunciosCollection;
    public static volatile CollectionAttribute<Horario, Recursos> recursosCollection;

}