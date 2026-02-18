package org.example.Model;

public class Estudiante {

    //ATRIBUTOS DE LA CLASE
    private int idEstudiante;
    private String nombre;

    // CONSTRUCTOR VACIO
    public Estudiante() {
    }

    // CONSTRUCTOR CON PARAMETROS
    public Estudiante(int idEstudiante, String nombre) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
    }

    // CREACION DE GET
    public int getIdEstudiante() {
        return idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    // CREACION DE SET
    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // CREACION DE TO STRING
    @Override
    public String toString() {
        return "Estudiante{" +
                "idEstudiante=" + idEstudiante +
                ", nombre='" + nombre + '\'' +
                '}';
    }


}
