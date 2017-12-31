package JPA;

import JPA.Administrador;
import JPA.Alumno;
import JPA.MatriculaHasCurso;
import JPA.Pagos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-26T20:35:35")
@StaticMetamodel(Matricula.class)
public class Matricula_ { 

    public static volatile SingularAttribute<Matricula, String> seccion;
    public static volatile SingularAttribute<Matricula, Administrador> administrador;
    public static volatile SingularAttribute<Matricula, String> ciclo;
    public static volatile CollectionAttribute<Matricula, MatriculaHasCurso> matriculaHasCursoCollection;
    public static volatile SingularAttribute<Matricula, Integer> idmatricula;
    public static volatile SingularAttribute<Matricula, Alumno> alumno;
    public static volatile SingularAttribute<Matricula, Pagos> pagos;

}