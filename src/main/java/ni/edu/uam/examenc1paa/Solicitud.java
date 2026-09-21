package ni.edu.uam.examenc1paa;

public class Solicitud {
    private String numeroSolicitud;
    private String cliente;
    private String fecha;
    private String tipoSolicitud;
    private String descripcion;
    private String estado;

    public Solicitud() {
    }

    public Solicitud(String numeroSolicitud, String cliente, String fecha,
                     String tipoSolicitud, String descripcion, String estado) {
        this.numeroSolicitud = numeroSolicitud;
        this.cliente = cliente;
        this.fecha = fecha;
        this.tipoSolicitud = tipoSolicitud;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(String numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}