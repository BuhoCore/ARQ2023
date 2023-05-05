package gtx18.com.renoult.DTO;
import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;

@Data
@Entity
@Table(name = "pago")
public class Tab_PagoDTO {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
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

        public Tab_PagoDTO() {
        }

        public Tab_PagoDTO(Long id, String num_pago, String fecha, String dinero, String mensaje) {
                this.id = id;
                this.num_pago = num_pago;
                this.fecha = fecha;
                this.dinero = dinero;
                this.mensaje = mensaje;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getNum_pago() {
                return num_pago;
        }

        public void setNum_pago(String num_pago) {
                this.num_pago = num_pago;
        }

        public String getFecha() {
                return fecha;
        }

        public void setFecha(String fecha) {
                this.fecha = fecha;
        }

        public String getDinero() {
                return dinero;
        }

        public void setDinero(String dinero) {
                this.dinero = dinero;
        }

        public String getMensaje() {
                return mensaje;
        }

        public void setMensaje(String mensaje) {
                this.mensaje = mensaje;
        }
}


