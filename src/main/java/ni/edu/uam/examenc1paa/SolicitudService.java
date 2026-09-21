package ni.edu.uam.examenc1paa;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SolicitudService {

    private static final SolicitudService instancia = new SolicitudService();

    private ObservableList<Solicitud> solicitudes;
    private int ultimoNumero;
    private Solicitud solicitudSeleccionada;

    private SolicitudService() {
        solicitudes = FXCollections.observableArrayList();
        solicitudes.add(new Solicitud("SOL-001", "Maria Gonzalez", "18/09/2026", "Soporte tecnico", "La computadora no enciende.", "Pendiente"));
        solicitudes.add(new Solicitud("SOL-002", "Juan Martinez", "19/09/2026", "Mantenimiento", "La impresora necesita revision.", "En proceso"));
        solicitudes.add(new Solicitud("SOL-003", "Empresa Delta", "20/09/2026", "Instalacion", "Instalacion de un equipo nuevo.", "Resuelta"));
        ultimoNumero = 3;
    }

    public static SolicitudService getInstancia() {
        return instancia;
    }

    public ObservableList<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public String generarNumero() {
        ultimoNumero++;
        return "SOL-" + String.format("%03d", ultimoNumero);
    }

    public void registrar(Solicitud solicitud) {
        solicitudes.add(solicitud);
    }

    public void actualizarEstado(Solicitud solicitud, String estado) {
        solicitud.setEstado(estado);
    }

    public void eliminar(Solicitud solicitud) {
        solicitudes.remove(solicitud);
    }

    public Solicitud getSolicitudSeleccionada() {
        return solicitudSeleccionada;
    }

    public void setSolicitudSeleccionada(Solicitud solicitudSeleccionada) {
        this.solicitudSeleccionada = solicitudSeleccionada;
    }
}