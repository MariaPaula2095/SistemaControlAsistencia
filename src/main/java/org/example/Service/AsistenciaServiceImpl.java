package org.example.Service;

import org.example.Model.Estudiante;
import org.example.Model.RegistroAsistencia;
import org.example.Model.EstadoAsistencia;

import java.util.ArrayList;
import java.util.List;

// Implementa las operaciones del sistema de asistencia
public class AsistenciaServiceImpl implements AsistenciaService {

    // Lista donde se guardan los estudiantes
    private List<Estudiante> estudiantes = new ArrayList<>();

    // Lista donde se guardan los registros de asistencia
    private List<RegistroAsistencia> registros = new ArrayList<>();


    // Registra un nuevo estudiante
    @Override
    public Estudiante registrarEstudiante(int id, String nombre) {

        Estudiante estudiante = new Estudiante(id, nombre);

        estudiantes.add(estudiante);

        return estudiante;
    }


    // Marca la asistencia de un estudiante en una fecha
    @Override
    public RegistroAsistencia marcarAsistencia(Estudiante estudiante, String fecha, EstadoAsistencia estado) {

        // Validar que no exista ya un registro para ese estudiante en esa fecha
        for (RegistroAsistencia r : registros) {
            if (r.getEstudiante().getIdEstudiante() == estudiante.getIdEstudiante()
                    && r.getFecha().equals(fecha)) {

                throw new IllegalArgumentException("Ya existe asistencia para este estudiante en esa fecha");
            }
        }

        // Crear el registro
        RegistroAsistencia registro = new RegistroAsistencia(estudiante, fecha, estado);

        // Guardarlo
        registros.add(registro);

        return registro;
    }


    // Consulta todas las asistencias de un estudiante
    @Override
    public List<RegistroAsistencia> consultarAsistenciaPorEstudiante(Estudiante estudiante) {

        List<RegistroAsistencia> resultado = new ArrayList<>();

        for (RegistroAsistencia r : registros) {
            if (r.getEstudiante().getIdEstudiante() == estudiante.getIdEstudiante()) {
                resultado.add(r);
            }
        }

        return resultado;
    }


    // Elimina un registro de asistencia
    @Override
    public void eliminarRegistro(RegistroAsistencia registro) {

        registros.remove(registro);
    }

}
