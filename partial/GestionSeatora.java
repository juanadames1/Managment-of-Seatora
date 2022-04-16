package partial;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class GestionSeatora {

    private final String ruta;

// GESTION PACIENTE
    public GestionSeatora() {
        this.ruta = "./src/Archivos/misPacientes.txt";
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

    public void nuevoPaciente() {
        String cod0, nom, fechanac,fechait, fechaft = null, tipot, nombreodon, x;
        char gen0;

        
        cod0 = JOptionPane.showInputDialog("Digite la cédula del paciente");

        nom = JOptionPane.showInputDialog("Digite el nombre completo del paciente");


        do {
            gen0 = JOptionPane.showInputDialog("Digite el genero del paciente").charAt(0);
            if (!(gen0 == 'F' || gen0 == 'M')) {
                JOptionPane.showMessageDialog(null, "Género invalido ingrese un valor valido (F -mujer) (M -hombre)");
            }
        } while (!(gen0 == 'F' || gen0 == 'M'));
        
        
        fechanac= JOptionPane.showInputDialog("Ingrese la fecha de nacimiento del paciente de la forma DD/MM/AAAA");
        
        fechait= JOptionPane.showInputDialog("Ingrese la fecha de inicio del traramiento del paciente de la forma DD/MM/AAAA");
        
        tipot= JOptionPane.showInputDialog("Ingrese el tipo de tratamiento");  
      
        fechaft= JOptionPane.showInputDialog("Ingrese la fecha de la finalización del tratamiento del paciente de la forma DD/MM/AAAA");
        
        nombreodon= JOptionPane.showInputDialog("Ingrese el nombre del odontólogo que está tratando al paciente");
        
        Paciente pacient = new Paciente(cod0, nom, gen0, fechanac, fechait, tipot, fechaft, nombreodon);

        this.guardarPacientes(pacient);

    }


    private void guardarPacientes(Paciente pacient){
        try{
            File file = new File(this.ruta);
            FileWriter fr = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fr);
                pw.println(pacient);
            pw.close();
            JOptionPane.showMessageDialog(null, "El paciente ha sido guardado en el archivo");
        }catch (IOException cosito){
            JOptionPane.showMessageDialog(null, "No se pudo guardar el paciente");
        }
    }

    public void verPaciente(){
        String cedula;
        cedula = JOptionPane.showInputDialog("Digite la cédula a buscar:");

        Paciente pat = this.buscarPaciente(cedula);

        if(pat != null){
            System.out.println(pat);
        }else{
            JOptionPane.showMessageDialog(null, "Ese cédula no existe...");
        }
    }

    private Paciente buscarPaciente(String cedula){
        FileReader file;
        BufferedReader br;
        String registro;
        Paciente pat = null;

        try{
            file = new FileReader(this.ruta);
            br = new BufferedReader(file);
            while((registro = br.readLine()) != null){
                String[] campos = registro.split(", ");
                if(campos[0].equals(cedula)){
                    pat = new Paciente(campos[0], campos[1], campos[2].charAt(0), campos[3], campos[4], campos[5], campos [6], campos[7]);
                    break;
                }
            }
        }catch (IOException ex){
            System.out.println("FallO buscando pacientee");
        }
        return pat;
    }

    public boolean hayPacientes(){
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
            System.out.println("FallO buscando paciente");
        }
        return band;
    }

    private ArrayList<Paciente> getPacientes(){
        FileReader file;
        BufferedReader br;
        String registro;
        Paciente pat = null;
        ArrayList<Paciente> pacients = new ArrayList();

        try{
            file = new FileReader(this.ruta);
            br = new BufferedReader(file);
            while((registro = br.readLine()) != null){
                String[] campos = registro.split(",");

                pat = new Paciente(campos[0], campos[1], campos[2].charAt(0), campos[3], campos[4], campos[5], campos [6], campos[7]);

                pacients.add(pat);

            }
        }catch (IOException ex){
            System.out.println("FallO buscando paciente");
        }
        return pacients;
    }

    public void verTodos() {

        ArrayList<Paciente> pacients = this.getPacientes();


        for (Paciente pat : pacients) {
            System.out.println(pat.toString() + "\n");
        }
    }



    public void eliminarPacientes() {
        String cedula, newDato0;

        ArrayList<Paciente> pacient = this.getPacientes();
        cedula = JOptionPane.showInputDialog("Digite la cédula del paciente a eliminar");
        for (Paciente pat : pacient) {
            if (pat.getCedula().equals(cedula)) {
                pacient.remove(pat);
                this.reemplazarArchivo(pacient);
                JOptionPane.showMessageDialog(null, "Paciente eliminado");
                break;
            }
        }

    }




    public void modificarCodigo() {
        String cedula, newDato0;
        boolean existe = false;
        ArrayList<Paciente> pacient = this.getPacientes();

        cedula = JOptionPane.showInputDialog("Digite la cédula a modificar");
        for (Paciente pat : pacient) {
            if (pat.getCedula().equals(cedula)) {
//
                newDato0 = JOptionPane.showInputDialog("Digite la nueva cédula del paciente");
//
                pat.setCedula(newDato0);
                this.reemplazarArchivo(pacient);
                JOptionPane.showMessageDialog(null, "Cédula modificada");
                existe = false;
                break;
            }
        }

    }

    private void reemplazarArchivo(ArrayList<Paciente> pacients){
        try{
            File file = new File(this.ruta);
            FileWriter fr = new FileWriter(file, false);
            PrintWriter pw = new PrintWriter(fr);
            for(Paciente pacient:pacients)
                pw.println(pacient);
            pw.close();

        }catch (IOException ex){
            JOptionPane.showMessageDialog(null, "No se pudo modificar el paciente");
        }
    }



    public void modificarNombre() {
        String cedula, newDato0;
        ArrayList<Paciente> pacient = this.getPacientes();

        cedula = JOptionPane.showInputDialog("Digite la cedula del paciente a modificar");
        for (Paciente pat : pacient) {
            if (pat.getCedula().equals(cedula)) {
//
                newDato0 = JOptionPane.showInputDialog("Digite el nuevo nombre del paciente");
//
                pat.setNombre(newDato0);
                this.reemplazarArchivo(pacient);
                JOptionPane.showMessageDialog(null, "Nombre modificado");
                break;
            }
        }
    }

    public void modificarGenero() {
        String cedula;
        char newDato;
        ArrayList<Paciente> pacient = this.getPacientes();
        cedula = JOptionPane.showInputDialog("Digite la cédula del paciente a modificar");
        for (Paciente pat : pacient) {
            if (pat.getCedula().equals(cedula)) {
                do {
                    newDato = JOptionPane.showInputDialog("Digite el nuevo génereo del paciente").charAt(0);
                    if (!(newDato == 'm' || newDato == 'h')) {
                        JOptionPane.showMessageDialog(null, "Genero invalido ingrese un valor valido (F -mujer) (H -hombre)");
                    }
                } while (!(newDato == 'm' || newDato == 'h'));
                pat.setGenero(newDato);
                this.reemplazarArchivo(pacient);
                JOptionPane.showMessageDialog(null, "Género modificado");
                break;
            }
        }
    }
    
    public void modificarFechadeNacimiento(){
        String cedula, newDato0;
        ArrayList<Paciente> pacient = this.getPacientes();
        cedula=JOptionPane.showInputDialog("Digite la cédula del paciente a modificar");
        for (Paciente pat : pacient) {
            if (pat.getCedula().equals(cedula)) {
                newDato0 = JOptionPane.showInputDialog("Digite la nueva fecha de nacimiento de la forma DD/MM/AAAA");
                
                pat.setFechanacimiento(newDato0);
                this.reemplazarArchivo(pacient);
                JOptionPane.showMessageDialog(null, "Fecha de nacimiento modificada");
                break;
            }
        }
        
    }
    
    public void modificarFechaInicio(){
        String cedula, newDato0;
        ArrayList<Paciente> pacient = this.getPacientes();
        cedula=JOptionPane.showInputDialog("Digite la cédula del paciente a modificar");
        for (Paciente pat : pacient) {
            if (pat.getCedula().equals(cedula)) {
                newDato0 = JOptionPane.showInputDialog("Digite la nueva fecha de inicio del tratamiento de la forma DD/MM/AAAA");
                
                pat.setFechaitratamiento(newDato0);
                this.reemplazarArchivo(pacient);
                JOptionPane.showMessageDialog(null, "Fecha de inicio del tratamiento modificada");
                break;
            }
        }
        
    }
    public void modificarFechaFinal(){
        String cedula, newDato0;
        ArrayList<Paciente> pacient = this.getPacientes();
        cedula=JOptionPane.showInputDialog("Digite la cédula del paciente a modificar");
        for (Paciente pat : pacient) {
            if (pat.getCedula().equals(cedula)) {
                newDato0 = JOptionPane.showInputDialog("Digite la nueva fecha de fin del tratamiento de la forma DD/MM/AAAA");
                
                pat.setFechaftratamiento(newDato0);
                this.reemplazarArchivo(pacient);
                JOptionPane.showMessageDialog(null, "Fecha de fin del tratamiento modificada");
                break;
            }
        }
        
        
    }
    public void modificarTipoTratamiento(){
        String cedula, newDato0;
        ArrayList<Paciente> pacient = this.getPacientes();
        cedula=JOptionPane.showInputDialog("Digite la cédula del paciente a modificar");
        for (Paciente pat : pacient) {
            if (pat.getCedula().equals(cedula)) {
                newDato0 = JOptionPane.showInputDialog("Ingrese el nuevo tratamiento del paciente");
                
                pat.setTipotratamiento(newDato0);
                this.reemplazarArchivo(pacient);
                JOptionPane.showMessageDialog(null, "Nuevo tipo de tratamiento asignado");
                break;
            }
        }
        
    }
    public void modificarOdontologo(){
        String cedula, newDato0;
        ArrayList<Paciente> pacient = this.getPacientes();
        cedula=JOptionPane.showInputDialog("Digite la cédula del paciente a modificar");
        for (Paciente pat : pacient) {
            if (pat.getCedula().equals(cedula)) {
                newDato0 = JOptionPane.showInputDialog("Digite el nombre del nuevo Odontólogo");
                
                pat.setOdontologo(newDato0);
                this.reemplazarArchivo(pacient);
                JOptionPane.showMessageDialog(null, "Nuevo Odontólogo Asignado");
                break;
            }
        }
    }
}

