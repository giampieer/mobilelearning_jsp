package JPA;

import JPA.Matricula;
import JPA.Reservaactividad;
import JPA.Reservalaboratorio;
import JPA.Reservalibro;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-26T20:35:35")
@StaticMetamodel(Alumno.class)
public class Alumno_ { 

    public static volatile SingularAttribute<Alumno, String> clave;
    public static volatile CollectionAttribute<Alumno, Reservaactividad> reservaactividadCollection;
    public static volatile SingularAttribute<Alumno, Integer> idalumno;
    public static volatile CollectionAttribute<Alumno, Reservalaboratorio> reservalaboratorioCollection;
    public static volatile SingularAttribute<Alumno, String> apellido;
    public static volatile SingularAttribute<Alumno, String> correo;
    public static volatile SingularAttribute<Alumno, String> usuario;
    public static volatile CollectionAttribute<Alumno, Matricula> matriculaCollection;
    public static volatile SingularAttribute<Alumno, Integer> sexo;
    public static volatile SingularAttribute<Alumno, String> nombre;
    public static volatile SingularAttribute<Alumno, Integer> edad;
    public static volatile CollectionAttribute<Alumno, Reservalibro> reservalibroCollection;

}