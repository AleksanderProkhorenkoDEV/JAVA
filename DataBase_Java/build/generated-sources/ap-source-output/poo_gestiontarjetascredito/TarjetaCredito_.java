package poo_gestiontarjetascredito;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import poo_gestiontarjetascredito.Movimiento;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-05-23T16:59:19", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(TarjetaCredito.class)
public class TarjetaCredito_ { 

    public static volatile SingularAttribute<TarjetaCredito, String> cvv;
    public static volatile SingularAttribute<TarjetaCredito, String> pin;
    public static volatile SingularAttribute<TarjetaCredito, Integer> mesCaducidad;
    public static volatile SingularAttribute<TarjetaCredito, String> nif;
    public static volatile SingularAttribute<TarjetaCredito, Integer> añoCaducidad;
    public static volatile ListAttribute<TarjetaCredito, Movimiento> movimientos;
    public static volatile SingularAttribute<TarjetaCredito, Integer> limite;
    public static volatile SingularAttribute<TarjetaCredito, String> numeroTarjeta;
    public static volatile SingularAttribute<TarjetaCredito, String> titular;

}