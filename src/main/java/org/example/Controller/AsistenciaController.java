package org.example.Controller;

import org.example.Model.Estudiante;
import org.example.Model.RegistroAsistencia;
import org.example.Model.EstadoAsistencia;
import org.example.Service.AsistenciaService;
import org.example.View.AsistenciaView;
import java.util.List;

// Controlador que coordina entre Service y View
public class AsistenciaController {

    private final AsistenciaService service;
    private final AsistenciaView view;

    // Constructor
    public AsistenciaController(AsistenciaService service, AsistenciaView view) {
        this.service = service;
        this.view = view;
    }


    // Registrar estudiante
    public Estudiante registrarEstudiante(int id, String nombre) {

        Estudiante estudiante = service.registrarEstudiante(id, nombre);

        view.mostrarMensaje("Estudiante registrado");

        return estudiante;
    }


    // Marcar asistencia
    public RegistroAsistencia marcarAsistencia(Estudiante estudiante, String fecha, EstadoAsistencia estado) {

        RegistroAsistencia registro = service.marcarAsistencia(estudiante, fecha, estado);

        view.mostrarMensaje("Asistencia registrada");

        return registro;
    }


    // Consultar asistencias de un estudiante
    public void consultarAsistencia(Estudiante estudiante) {

        List<RegistroAsistencia> lista = service.consultarAsistenciaPorEstudiante(estudiante);

        view.mostrarRegistros(lista);
    }


    // Eliminar registro
    public void eliminarRegistro(RegistroAsistencia registro) {

        service.eliminarRegistro(registro);

        view.mostrarMensaje("Registro eliminado");
    }

}
