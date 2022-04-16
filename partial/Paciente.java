package partial;

public class Paciente extends Persona {
    //atributos
    private String fechaitratamiento;
    private String fechaftratamiento;
    private String tipotratamiento;
    private String odontologo;

    //constructor
    public Paciente(String cedula, String nombre, char genero, String fechanacimiento, String fechainicio,String tipotra , String fechafinal, String nombreod) {
        super(cedula, nombre, genero, fechanacimiento);
        this.fechaitratamiento= fechainicio;
        this.tipotratamiento=tipotra;
        this.fechaftratamiento= fechafinal;
        this.odontologo= nombreod; 
    }

    //Métodos analizadores y modificadores

    public String getFechaitratamiento() {
        return fechaitratamiento;
    }

    public void setFechaitratamiento(String fechaitratamiento) {
        this.fechaitratamiento = fechaitratamiento;
    }

    public String getFechaftratamiento() {
        return fechaftratamiento;
    }

    public void setFechaftratamiento(String fechaftratamiento) {
        this.fechaftratamiento = fechaftratamiento;
    }

    public String getTipotratamiento() {
        return tipotratamiento;
    }

    public void setTipotratamiento(String tipotratamiento) {
        this.tipotratamiento = tipotratamiento;
    }

    public String getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(String odontologo) {
        this.odontologo = odontologo;
    }
    
    @Override
    public String toString() {
        return this.cedula + "," + this.nombre + "," + this.genero + "," + this.fechanacimiento + "," + this.fechaitratamiento + "," + this.fechaftratamiento + "," + this.tipotratamiento + "," + this.odontologo;
    }
}
