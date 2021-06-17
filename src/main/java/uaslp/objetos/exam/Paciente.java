package uaslp.objetos.exam;


import java.time.LocalDate;

public class Paciente {

    private final String nombres;
    private final String apellidoPaterno;
    private final String apellidoMaterno;
    private final LocalDate fechaNacimiento;
    private final String curp;
    private String espacio = " ";
    private String fullName;


    public Paciente(String nombres, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento, String curp, String fullName){
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.curp = curp;
        this.fullName = fullName;
    }

    public String getNombres(){
        return nombres;
    }

    public String getApellidoPaterno(){
        return apellidoPaterno;
    }

    public String getApellidoMaterno(){
        return apellidoMaterno;
    }

    public LocalDate getFechaNacimiento() throws FechaDeNacimientoRequeridaException{
        if(fechaNacimiento == null){
            throw new FechaDeNacimientoRequeridaException("Fecha de nacimiento requerida");
        }
        return fechaNacimiento;
    }

    public String getCurp() throws FechaDeNacimientoRequeridaException{
        if(curp == null){
            throw new FechaDeNacimientoRequeridaException("CURP requerida");
        }
        return curp;
    }

    public String getFullName() {
        return nombres + espacio + apellidoPaterno + espacio + apellidoMaterno;
    }

    public static PacienteBuilder builder() {
        return new PacienteBuilder();
    }
}