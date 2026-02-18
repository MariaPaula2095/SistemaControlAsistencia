package org.example.Model;

public class RegistroAsistencia {

    //ATRIBUTOS DE LA CLASE
    private Estudiante estudiante;
    private String fecha;
    private EstadoAsistencia estado;

    // CONSTRUCTOR VACIO
    public RegistroAsistencia() {
    }

    // CONSTRUCTOR CON PARAMETROS
    public RegistroAsistencia(Estudiante estudiante, String fecha, EstadoAsistencia estado) {
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.estado = estado;
    }

    // GETTERS AND SETTERS

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public EstadoAsistencia getEstado() {
        return estado;
    }

    public void setEstado(EstadoAsistencia estado) {
        this.estado = estado;
    }

    // CREACION TO STRING
    @Override
    public String toString() {
        return "RegistroAsistencia{" +
                "estudiante=" + estudiante +
                ", fecha='" + fecha + '\'' +
                ", estado=" + estado +
                '}';
    }
}
