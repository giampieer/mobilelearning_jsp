package JPA;

import JPA.Asistencia;
import JPA.Curso;
import JPA.Matricula;
import JPA.MatriculaHasCursoPK;
import JPA.Notas;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-26T20:35:35")
@StaticMetamodel(MatriculaHasCurso.class)
public class MatriculaHasCurso_ { 

    public static volatile SingularAttribute<MatriculaHasCurso, Curso> curso;
    public static volatile CollectionAttribute<MatriculaHasCurso, Asistencia> asistenciaCollection;
    public static volatile CollectionAttribute<MatriculaHasCurso, Notas> notasCollection;
    public static volatile SingularAttribute<MatriculaHasCurso, Matricula> matricula;
    public static volatile SingularAttribute<MatriculaHasCurso, MatriculaHasCursoPK> matriculaHasCursoPK;

}