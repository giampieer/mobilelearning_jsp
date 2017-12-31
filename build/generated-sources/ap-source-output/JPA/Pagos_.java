package JPA;

import JPA.Matricula;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-26T20:35:35")
@StaticMetamodel(Pagos.class)
public class Pagos_ { 

    public static volatile SingularAttribute<Pagos, Double> monto;
    public static volatile SingularAttribute<Pagos, Integer> idPagos;
    public static volatile SingularAttribute<Pagos, String> tipomoneda;
    public static volatile CollectionAttribute<Pagos, Matricula> matriculaCollection;
    public static volatile SingularAttribute<Pagos, String> nombrepago;

}