package poo_gestiontarjetascredito;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import poo_gestiontarjetascredito.TarjetaCredito;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-05-23T16:59:19", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Movimiento.class)
public class Movimiento_ { 

    public static volatile SingularAttribute<Movimiento, LocalDateTime> fecha;
    public static volatile SingularAttribute<Movimiento, Integer> movimientoId;
    public static volatile SingularAttribute<Movimiento, TarjetaCredito> numerotarjeta;
    public static volatile SingularAttribute<Movimiento, String> concepto;
    public static volatile SingularAttribute<Movimiento, Double> cantidad;

}