package org.example.Service;

import org.example.Model.Estudiante;
import org.example.Model.RegistroAsistencia;
import org.example.Model.EstadoAsistencia;

import java.util.List;

// Define las operaciones del sistema de asistencia (solo declara métodos)
public interface AsistenciaService {

    // Registra un estudiante
    Estudiante registrarEstudiante(int id, String nombre);

    // Marca la asistencia de un estudiante
    RegistroAsistencia marcarAsistencia(Estudiante estudiante, String fecha, EstadoAsistencia estado);

    // Obtiene todas las asistencias de un estudiante
    List<RegistroAsistencia> consultarAsistenciaPorEstudiante(Estudiante estudiante);

    // Elimina un registro de asistencia
    void eliminarRegistro(RegistroAsistencia registro);

}
