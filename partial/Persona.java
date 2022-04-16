/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package partial;

/**
 *
 * @author juanc
 */
public class Persona {
    //atributos
    protected String cedula;
    protected String nombre;
    protected char genero;
    protected String fechanacimiento;
    
    //Constructores
    public Persona() {
        this.cedula = "";
        this.nombre = "";
        this.genero = '*';
        this.fechanacimiento="";
    }
    
    public Persona(String cedula, String nombre, char genero, String fechanacimiento){
        this.cedula = cedula;
        this.nombre = nombre;
        this.genero = genero;
        this.fechanacimiento = fechanacimiento;
    }

    //Métodos analizadores y modificadores

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }
    
    @Override
    public String toString() {
        return this.cedula + "," + this.nombre + "," + this.genero + "," + this.fechanacimiento;  
    }
}
