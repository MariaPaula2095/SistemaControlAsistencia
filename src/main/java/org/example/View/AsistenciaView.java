package org.example.View;

import org.example.Model.RegistroAsistencia;

import java.util.List;

// Clase encargada de mostrar la información en consola
public class AsistenciaView {

    // Muestra una lista de registros de asistencia
    public void mostrarRegistros(List<RegistroAsistencia> registros) {

        System.out.println("----- REGISTROS DE ASISTENCIA -----");

        for (RegistroAsistencia r : registros) {
            System.out.println("Estudiante: " + r.getEstudiante().getNombre());
            System.out.println("Fecha: " + r.getFecha());
            System.out.println("Estado: " + r.getEstado());
            System.out.println("------------------------------");
        }
    }


    // Muestra un mensaje simple
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

}
