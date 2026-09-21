package ni.edu.uam.examenc1paa;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Solicitud {
    private String numeroSolicitud;
    private String cliente;
    private String fecha;
    private String tipoSolicitud;
    private String descripcion;
    private String estado;



}