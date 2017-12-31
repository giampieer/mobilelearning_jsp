package JPA;

import JPA.Alumno;
import JPA.Laboratorio;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-26T20:35:35")
@StaticMetamodel(Reservalaboratorio.class)
public class Reservalaboratorio_ { 

    public static volatile SingularAttribute<Reservalaboratorio, Integer> idReservaLaboratorio;
    public static volatile SingularAttribute<Reservalaboratorio, String> horafin;
    public static volatile SingularAttribute<Reservalaboratorio, Alumno> alumno;
    public static volatile SingularAttribute<Reservalaboratorio, String> horainicio;
    public static volatile SingularAttribute<Reservalaboratorio, Laboratorio> laboratorio;

}