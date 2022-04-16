package partial;

import javax.swing.*;

public class Seatora {

    private final GestionSeatora gestorSeatora;
    private final GestionEmpleadoSeatora gestorEmpleados;
    private final GestionOdontologo gestorOdontologo;

    public static void main(String[] args) {
        new Seatora();
        
    }

    public Seatora() {
        this.gestorEmpleados= new GestionEmpleadoSeatora();
        this.gestorSeatora = new GestionSeatora();
        this.gestorOdontologo=new GestionOdontologo();
        this.menuP();    
    }

    //Menú principal
    private void menuP(){
        char opcion;
        String x;
         do {
            x = JOptionPane.showInputDialog("====OPCIONES==== \n" +
                    "1. Gestionar Pacientes \n" +
                    "2. Gestionar Empleados \n" +
                    "3. Gestionar Odontologos \n" +
                    "0. Salir");
            opcion = x.charAt(0);

            switch (opcion) {

                case '1':
                    this.menupac();
                    break;
                case '2':
                    this.menuempl();
                    break;
                case '3':
                    this.menuodon();
                    break;
                case '0':
                    JOptionPane.showMessageDialog(null, "Hasta luego, tenga un buen día");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
                    break;

            }
        } while (opcion != '0');
    }
    
    //Menú pacientes
        private void menupac() {
        char opcion;
        String x;
        do {
            x = JOptionPane.showInputDialog("====OPCIONES==== \n" +
                    "1. Ingresar paciente \n" +
                    "2. Buscar Paciente \n" +
                    "3. Ver todos los Pacientes \n" +
                    "4. Modificar Pacientes \n" +
                    "5. Eliminar Paciente \n" +
                    "0. Salir \n");

            opcion = x.charAt(0);

            switch (opcion) {

                case '1':
                    this.gestorSeatora.nuevoPaciente();
                    break;
                case '2':
                    if (!this.gestorSeatora.hayPacientes()) {
                        JOptionPane.showMessageDialog(null, "No hay pacientes registrados");
                    } else {
                        this.gestorSeatora.verPaciente();
                    }
                    break;
                case '3':
                    if (!this.gestorSeatora.hayPacientes()) {
                        JOptionPane.showMessageDialog(null, "No hay pacientes registrados");
                    } else {
                        this.gestorSeatora.verTodos();
                    }
                    break;
                case '4':
                    if (!this.gestorSeatora.hayPacientes()) {
                        JOptionPane.showMessageDialog(null, "No hay pacientes registrados");
                    } else {
                        this.menuModificar();
                    }
                    break;
                case '5':
                    if (!this.gestorSeatora.hayPacientes()) {
                        JOptionPane.showMessageDialog(null, "No hay pacientes registrados");
                    } else {
                        this.gestorSeatora.eliminarPacientes();
                    }
                    break;
                case '0':
                    JOptionPane.showMessageDialog(null, "Regresando al menú principal");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
                    break;

            }
        } while (opcion != '0');
    }

    //Menú modificador pacientes
    private void menuModificar() {
        char opcion;
        String x;
        do {
            x = JOptionPane.showInputDialog("====OPCIONES==== \n" +
                    "1. Modificar cédula \n" +
                    "2. Modificar nombre \n" +
                    "3. Modificar género \n" +
                    "4. Modificar fecha de nacimiento \n" +
                    "5. Modificar fecha de inicio de tratamiento \n"+
                    "6. Modificar fecha final de tratamiento \n" +
                    "7. Modificar tipo de tratamiento \n" +
                    "8. Modificar Odontologo tratante \n" +
                    "0. Salir \n");

            opcion = x.charAt(0);

            switch (opcion) {

                case '1':
                    this.gestorSeatora.modificarCodigo();
                    break;
                case '2':
                    this.gestorSeatora.modificarNombre();
                    break;
                case '3':
                    this.gestorSeatora.modificarGenero();
                    break;
                case '4':
                    this.gestorSeatora.modificarFechadeNacimiento();
                    break;
                case '5':
                    this.gestorSeatora.modificarFechaInicio();
                    break;
                case '6':
                    this.gestorSeatora.modificarFechaFinal();
                    break;
                case'7':
                    this.gestorSeatora.modificarTipoTratamiento();
                    break;
                case'8':
                    this.gestorSeatora.modificarOdontologo();
                    break;     
                case '0':
                    JOptionPane.showMessageDialog(null, "Regresando al menú Pacientes");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "valor invalido");
                    break;

            }
        } while (opcion != '0');
    }


         //Menú empleados
        private void menuempl() {
        char opcion;
        String x;
        do {
            x = JOptionPane.showInputDialog("====OPCIONES==== \n" +
                    "1. Ingresar empleado \n" +
                    "2. Buscar empleado \n" +
                    "3. Ver todos los empleados \n" +
                    "4. Modificar empleados \n" +
                    "5. Eliminar empleado \n" +
                    "0. Salir \n");

            opcion = x.charAt(0);

            switch (opcion) {

                case '1':
                    this.gestorEmpleados.nuevoEmpleado();
                    break;
                case '2':
                    if (!this.gestorEmpleados.hayEmpleados()) {
                        JOptionPane.showMessageDialog(null, "No hay empleados registrados");
                    } else {
                        this.gestorEmpleados.verEmpleados();
                    }
                    break;
                case '3':
                    if (!this.gestorEmpleados.hayEmpleados()) {
                        JOptionPane.showMessageDialog(null, "No hay empleados registrados");
                    } else {
                        this.gestorEmpleados.verTodos();
                    }
                   
                    break;
                case '4':
                    if (!this.gestorEmpleados.hayEmpleados()) {
                        JOptionPane.showMessageDialog(null, "No hay empleados registrados");
                    } else {
                        this.menuModificarempl();
                    }
                    break;
                case '5':
                    if (!this.gestorEmpleados.hayEmpleados()) {
                        JOptionPane.showMessageDialog(null, "No hay empleados registrados");
                    } else {
                        this.gestorEmpleados.eliminarEmpleados();
                    }
                    break;
                case '0':
                    JOptionPane.showMessageDialog(null, "Regresando al menú principal");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
                    break;

            }
        } while (opcion != '0');
    }

    //Menú modificador empleados
    private void menuModificarempl() {
        char opcion;
        String x;
        do {
            x = JOptionPane.showInputDialog("====OPCIONES==== \n" +
                    "1. Modificar cédula \n" +
                    "2. Modificar nombre \n" +
                    "3. Modificar género \n" +
                    "4. Modificar fecha de nacimiento \n" +
                    "5. Modificar Cargo \n"+
                    "6. Modificar Salario \n"+
                    "0. Salir \n");

            opcion = x.charAt(0);

            switch (opcion) {

                case '1':
                    this.gestorEmpleados.modificarCodigo();
                    break;
                case '2':
                    this.gestorEmpleados.modificarNombre();
                    break;
                case '3':
                    this.gestorEmpleados.modificarGenero();
                    break;
                case '4':
                    this.gestorEmpleados.modificarFechadeNacimiento();
                    break;
                case '5':
                    this.gestorEmpleados.modificarCargo();
                    break;
                case '6':
                    this.gestorEmpleados.modificarSalario();
                case '0':
                    JOptionPane.showMessageDialog(null, "Regresando al menú empleados");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "valor invalido");
                    break;

            }
        } while (opcion != '0');
    }
    
    //Menú Odontólogos :D
    private void menuodon(){
               char opcion;
        String x;
        do {
            x = JOptionPane.showInputDialog("====OPCIONES==== \n" +
                    "1. Ingresar Odontólogo \n" +
                    "2. Buscar Odontólogo \n" +
                    "3. Ver todos los Odontólogos \n" +
                    "4. Modificar Odontólogo \n" +
                    "5. Eliminar Odontólogo \n" +
                    "0. Salir \n");

            opcion = x.charAt(0);

            switch (opcion) {

                case '1':
                    this.gestorOdontologo.nuevoOdontologo();
                    break;
                case '2':
                    if (!this.gestorOdontologo.hayOdontologos()) {
                        JOptionPane.showMessageDialog(null, "No hay empleados registrados");
                    } else {
                        this.gestorOdontologo.verOdontologos();
                    }
                    break;
                case '3':
                    if (!this.gestorOdontologo.hayOdontologos()) {
                        JOptionPane.showMessageDialog(null, "No hay empleados registrados");
                    } else {
                        this.gestorOdontologo.verTodos();
                    }
                   
                    break;
                case '4':
                    if (!this.gestorOdontologo.hayOdontologos()) {
                        JOptionPane.showMessageDialog(null, "No hay empleados registrados");
                    } else {
                        this.menuModificarOdon();
                    }
                    break;
                case '5':
                    if (!this.gestorOdontologo.hayOdontologos()) {
                        JOptionPane.showMessageDialog(null, "No hay empleados registrados");
                    } else {
                        this.gestorOdontologo.eliminarOdontologos();
                    }
                    break;
                case '0':
                    JOptionPane.showMessageDialog(null, "Regresando al menú principal");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
                    break;

            }
        } while (opcion != '0');
    }

    //Menú modificador Odontologos
    private void menuModificarOdon() {
        char opcion;
        String x;
        do {
            x = JOptionPane.showInputDialog("====OPCIONES==== \n" +
                    "1. Modificar cédula \n" +
                    "2. Modificar nombre \n" +
                    "3. Modificar género \n" +
                    "4. Modificar fecha de nacimiento \n" +
                    "5. Modificar Especialidad \n"+
                    "6. Modificar Salario \n"+
                    "7. Modificar tarjeta profesional \n"+
                    "0. Salir \n");

            opcion = x.charAt(0);

            switch (opcion) {

                case '1':
                    this.gestorOdontologo.modificarCodigo();
                    break;
                case '2':
                    this.gestorOdontologo.modificarNombre();
                    break;
                case '3':
                    this.gestorOdontologo.modificarGenero();
                    break;
                case '4':
                    this.gestorOdontologo.modificarFechadeNacimiento();
                    break;
                case '5':
                    this.gestorOdontologo.modificarEspecialidad();
                    break;
                case '6':
                    this.gestorOdontologo.modificarSalario();
                    break;
                case '7':
                    this.gestorOdontologo.modificarTarjeta();
                    break;
                case '0':
                    JOptionPane.showMessageDialog(null, "Regresando al menú Odontólogos");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "valor invalido");
                    break;

            }
        } while (opcion != '0');
    }
}
