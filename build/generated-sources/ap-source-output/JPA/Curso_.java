package JPA;

import JPA.Horario;
import JPA.MatriculaHasCurso;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-26T20:35:35")
@StaticMetamodel(Curso.class)
public class Curso_ { 

    public static volatile CollectionAttribute<Curso, MatriculaHasCurso> matriculaHasCursoCollection;
    public static volatile CollectionAttribute<Curso, Horario> horarioCollection;
    public static volatile SingularAttribute<Curso, Integer> idcurso;
    public static volatile SingularAttribute<Curso, String> nombre;

}