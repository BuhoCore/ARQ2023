package gtx18.com.renoult.DTO;
import jakarta.persistence.*;

@Entity
@Table(name = "pago")
public class Tab_Pago {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name = "num_pago")
        private String num_pago;

        @Column(name = "fecha")
        private String  fecha;

        @Column(name = "dinero")
        private String dinero;

        @Column(name = "mensaje")
        private String mensaje;

        // getters y setters
    }


