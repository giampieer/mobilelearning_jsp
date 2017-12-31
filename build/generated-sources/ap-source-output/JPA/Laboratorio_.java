package JPA;

import JPA.Reservalaboratorio;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-26T20:35:35")
@StaticMetamodel(Laboratorio.class)
public class Laboratorio_ { 

    public static volatile SingularAttribute<Laboratorio, Integer> idLaboratorio;
    public static volatile SingularAttribute<Laboratorio, String> estado;
    public static volatile CollectionAttribute<Laboratorio, Reservalaboratorio> reservalaboratorioCollection;
    public static volatile SingularAttribute<Laboratorio, String> nombre;

}