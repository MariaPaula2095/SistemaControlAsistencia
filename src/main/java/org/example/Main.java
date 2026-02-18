package org.example;

import org.example.Controller.AsistenciaController;
import org.example.Model.Estudiante;
import org.example.Model.EstadoAsistencia;
import org.example.Model.RegistroAsistencia;
import org.example.Service.AsistenciaService;
import org.example.Service.AsistenciaServiceImpl;
import org.example.View.AsistenciaView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Service
        AsistenciaService service = new AsistenciaServiceImpl();

        // View
        AsistenciaView view = new AsistenciaView();

        // Controller
        AsistenciaController controller = new AsistenciaController(service, view);

        Scanner sc = new Scanner(System.in);

        boolean continuar = true;

        // 🔹 Lista de estudiantes
        List<Estudiante> estudiantes = new ArrayList<>();

        RegistroAsistencia ultimoRegistro = null;

        do {

            System.out.println("\n===== SISTEMA DE ASISTENCIA =====");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Marcar asistencia");
            System.out.println("3. Consultar asistencia");
            System.out.println("4. Eliminar último registro");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                // ===============================
                // REGISTRAR ESTUDIANTE
                // ===============================
                case 1 -> {
                    System.out.print("ID del estudiante: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre del estudiante: ");
                    String nombre = sc.nextLine();

                    Estudiante nuevo =
                            controller.registrarEstudiante(id, nombre);

                    estudiantes.add(nuevo);
                }

                // ===============================
                // MARCAR ASISTENCIA
                // ===============================
                case 2 -> {

                    if (estudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                        break;
                    }

                    // Mostrar lista
                    System.out.println("Estudiantes registrados:");
                    for (Estudiante e : estudiantes) {
                        System.out.println("ID: " + e.getIdEstudiante() +
                                " - Nombre: " + e.getNombre());
                    }

                    System.out.print("Ingrese ID del estudiante: ");
                    int idBuscar = sc.nextInt();
                    sc.nextLine();

                    Estudiante seleccionado = null;

                    for (Estudiante e : estudiantes) {
                        if (e.getIdEstudiante() == idBuscar) {
                            seleccionado = e;
                            break;
                        }
                    }

                    if (seleccionado == null) {
                        System.out.println("Estudiante no encontrado.");
                        break;
                    }

                    System.out.print("Fecha (YYYY-MM-DD): ");
                    String fecha = sc.nextLine();

                    System.out.println("Estado: 1. ASISTIO  2. NO_ASISTIO");
                    int estadoOp = sc.nextInt();
                    sc.nextLine();

                    EstadoAsistencia estado =
                            (estadoOp == 1)
                                    ? EstadoAsistencia.ASISTIO
                                    : EstadoAsistencia.NO_ASISTIO;

                    ultimoRegistro =
                            controller.marcarAsistencia(seleccionado, fecha, estado);
                }

                // ===============================
                // CONSULTAR ASISTENCIA
                // ===============================
                case 3 -> {

                    if (estudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                        break;
                    }

                    System.out.println("Estudiantes registrados:");
                    for (Estudiante e : estudiantes) {
                        System.out.println("ID: " + e.getIdEstudiante() +
                                " - Nombre: " + e.getNombre());
                    }

                    System.out.print("Ingrese ID del estudiante: ");
                    int idBuscar = sc.nextInt();
                    sc.nextLine();

                    Estudiante seleccionado = null;

                    for (Estudiante e : estudiantes) {
                        if (e.getIdEstudiante() == idBuscar) {
                            seleccionado = e;
                            break;
                        }
                    }

                    if (seleccionado == null) {
                        System.out.println("Estudiante no encontrado.");
                        break;
                    }

                    controller.consultarAsistencia(seleccionado);
                }

                // ===============================
                // ELIMINAR ÚLTIMO REGISTRO
                // ===============================
                case 4 -> {

                    if (ultimoRegistro == null) {
                        System.out.println("No hay registros para eliminar.");
                        break;
                    }

                    controller.eliminarRegistro(ultimoRegistro);
                    ultimoRegistro = null;
                }

                // ===============================
                // SALIR
                // ===============================
                case 5 -> {
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                }

                default -> System.out.println("Opción inválida.");
            }

        } while (continuar);

        sc.close();
    }
}
