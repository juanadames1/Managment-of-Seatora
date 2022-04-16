package partial;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestionEmpleadoSeatora {

    private final String ruta;

// GESTION PACIENTE
    public GestionEmpleadoSeatora() {
        this.ruta = "./src/Archivos/misEmpleados.txt";
        this.verificArchivo();
    }

    private void verificArchivo() {

        try{
            File filex = new File(this.ruta);
            if(!filex.exists())
                filex.createNewFile();

        }
        catch(IOException ex){
            System.out.println("Problemas con la ruta");
        }
    }

    public void nuevoEmpleado() {
        String cod0, nom, fechanac, car = null, salari;
        char gen0;

        
        cod0 = JOptionPane.showInputDialog("Digite la cédula del empleado");

        nom = JOptionPane.showInputDialog("Digite el nombre completo del empleado");


        do {
            gen0 = JOptionPane.showInputDialog("Digite el genero del empleado").charAt(0);
            if (!(gen0 == 'F' || gen0 == 'M')) {
                JOptionPane.showMessageDialog(null, "Género invalido ingrese un valor valido (F -mujer) (M -hombre)");
            }
        } while (!(gen0 == 'F' || gen0 == 'M'));
        
        fechanac= JOptionPane.showInputDialog("Ingrese la fecha de nacimiento del empleado de la forma DD/MM/AAAA");
        
        car=JOptionPane.showInputDialog("Ingrese el cargo del empleado");
      
        salari = JOptionPane.showInputDialog("Ingrese el salario mensual del empleado");
        
        Empleado emplead = new Empleado(cod0, nom, gen0, fechanac, car, salari);

        this.guardarEmepleados(emplead);

    }


    private void guardarEmepleados(Empleado emplead){
        try{
            File file = new File(this.ruta);
            FileWriter fr = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fr);
                pw.println(emplead);
            pw.close();
            JOptionPane.showMessageDialog(null, "El empleado ha sido guardado en el archivo");
        }catch (IOException cosito){
            JOptionPane.showMessageDialog(null, "No se pudo guardar el empleado");
        }
    }

    public void verEmpleados(){
        String cedula;
        cedula = JOptionPane.showInputDialog("Digite la cédula a buscar:");

        Empleado emp = this.buscarEmpleados(cedula);

        if(emp != null){
            System.out.println(emp);
        }else{
            JOptionPane.showMessageDialog(null, "Ese cédula no existe");
        }
    }

    private Empleado buscarEmpleados(String cedula){
        FileReader file;
        BufferedReader br;
        String registro;
        Empleado emp = null;

        try{
            file = new FileReader(this.ruta);
            br = new BufferedReader(file);
            while((registro = br.readLine()) != null){
                String[] campos = registro.split(", ");
                if(campos[0].equals(cedula)){
                    emp = new Empleado(campos[0], campos[1], campos[2].charAt(0), campos[3], campos[4], campos[5]);
                    break;
                }
            }
        }catch (IOException ex){
            System.out.println("FallO buscando empleado");
        }
        return emp;
    }

    public boolean hayEmpleados(){
        FileReader file;
        BufferedReader br;
        String registro;
        boolean band = false;

        try{
            file = new FileReader(this.ruta);
            br = new BufferedReader(file);
            while((registro = br.readLine()) != null){
                band = true;
                break;
            }

        }catch (IOException ex){
            System.out.println("FallO buscando empleado");
        }
        return band;
    }

    private ArrayList<Empleado> getEmpleados(){
        FileReader file;
        BufferedReader br;
        String registro;
        Empleado emp;
        ArrayList<Empleado> empleads = new ArrayList();

        try{
            file = new FileReader(this.ruta);
            br = new BufferedReader(file);
            while((registro = br.readLine()) != null){
                String[] campos = registro.split(",");

                emp = new Empleado(campos[0], campos[1], campos[2].charAt(0), campos[3], campos[4], campos[5]);

                empleads.add(emp);
            }
        }catch (IOException ex){
            System.out.println("FallO buscando empleado");
        }
        return empleads;
    }

    public void verTodos() {

        ArrayList<Empleado> empleads = this.getEmpleados();


        for (Empleado emp : empleads) {
            System.out.println(emp.toString() + "\n");
        }
    }
 
    public void eliminarEmpleados() {
        String cedula, newDato0;

        ArrayList<Empleado> emplead = this.getEmpleados();
        cedula = JOptionPane.showInputDialog("Digite la cédula del empleado a eliminar");
        for (Empleado emp : emplead) {
            if (emp.getCedula().equals(cedula)) {
                emplead.remove(emp);
                this.reemplazarArchivo(emplead);
                JOptionPane.showMessageDialog(null, "Empleado eliminado");
                break;
            }
        }

    }




    public void modificarCodigo() {
        String cedula, newDato0;
        boolean existe = false;
        ArrayList<Empleado> emplead = this.getEmpleados();

        cedula = JOptionPane.showInputDialog("Digite la cédula a modificar");
        for (Empleado emp : emplead) {
            if (emp.getCedula().equals(cedula)) {
//
                newDato0 = JOptionPane.showInputDialog("Digite la nueva cédula del empleado");
//
                emp.setCedula(newDato0);
                this.reemplazarArchivo(emplead);
                JOptionPane.showMessageDialog(null, "Cédula modificada");
                existe = false;
                break;
            }
        }

    }

    private void reemplazarArchivo(ArrayList<Empleado> empleads){
        try{
            File file = new File(this.ruta);
            FileWriter fr = new FileWriter(file, false);
            PrintWriter pw = new PrintWriter(fr);
            for(Empleado emplead:empleads)
                pw.println(emplead);
            pw.close();

        }catch (IOException ex){
            JOptionPane.showMessageDialog(null, "No se pudo modificar el empleado");
        }
    }



    public void modificarNombre() {
        String cedula, newDato0;
        ArrayList<Empleado> emplead = this.getEmpleados();

        cedula = JOptionPane.showInputDialog("Digite la cedula del empleado a modificar");
        for (Empleado emp : emplead) {
            if (emp.getCedula().equals(cedula)) {
                newDato0 = JOptionPane.showInputDialog("Digite el nuevo nombre del empleado");
                emp.setNombre(newDato0);
                this.reemplazarArchivo(emplead);
                JOptionPane.showMessageDialog(null, "Nombre modificado");
                break;
            }
        }
    }



    public void modificarGenero() {
        String cedula;
        char newDato;
        ArrayList<Empleado> emplead = this.getEmpleados();
        cedula = JOptionPane.showInputDialog("Digite la cédula del empleado a modificar");
        for (Empleado emp : emplead) {
            if (emp.getCedula().equals(cedula)) {
                do {
                    newDato = JOptionPane.showInputDialog("Digite el nuevo génereo del empleado").charAt(0);
                    if (!(newDato == 'm' || newDato == 'h')) {
                        JOptionPane.showMessageDialog(null, "Genero invalido ingrese un valor valido (F -mujer) (H -hombre)");
                    }
                } while (!(newDato == 'm' || newDato == 'h'));
                emp.setGenero(newDato);
                this.reemplazarArchivo(emplead);
                JOptionPane.showMessageDialog(null, "Género modificado");
                break;
            }
        }
    }
    public void modificarFechadeNacimiento(){
        String cedula, newDato0;
        ArrayList<Empleado> emplead = this.getEmpleados();
        cedula=JOptionPane.showInputDialog("Digite la cédula del empleado a modificar");
        for (Empleado emp : emplead) {
            if (emp.getCedula().equals(cedula)) {
                newDato0 = JOptionPane.showInputDialog("Digite la nueva fecha de nacimiento de la forma DD/MM/AAAA");
                
                emp.setFechanacimiento(newDato0);
                this.reemplazarArchivo(emplead);
                JOptionPane.showMessageDialog(null, "Fecha de nacimiento modificada");
                break;
            }
        }
        
    }
    public void modificarSalario(){
         String cedula, newDato0;
        ArrayList<Empleado> emplead = this.getEmpleados();
        cedula=JOptionPane.showInputDialog("Digite la cédula del empleado a modificar");
        for (Empleado emp : emplead) {
            if (emp.getCedula().equals(cedula)) {
                newDato0 = JOptionPane.showInputDialog("Digite el nuevo salario mensual del empleado");
                
                emp.setSalario(newDato0);
                this.reemplazarArchivo(emplead);
                JOptionPane.showMessageDialog(null, "Nuevo salario asignado");
                break;
            }
        }
        
    }
    public void modificarCargo(){
        String cedula, newDato0;
        ArrayList<Empleado> emplead = this.getEmpleados();
        cedula=JOptionPane.showInputDialog("Digite la cédula del empleado a modificar");
        for (Empleado emp : emplead) {
            if (emp.getCedula().equals(cedula)) {
                newDato0 = JOptionPane.showInputDialog("Digite el nuevo cargo del empleado");
                
                emp.setCargo(newDato0);
                this.reemplazarArchivo(emplead);
                JOptionPane.showMessageDialog(null, "Cargo del empleado modificado");
                break;
            }
        }
        
    }
}

