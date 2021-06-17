package uaslp.objetos.exam;

import java.time.LocalDate;

public class PacienteBuilder{

    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private LocalDate fechaNacimiento;
    private String curp;
    private String fullName;
    private String espacio = " ";


    public PacienteBuilder nombres(String nombres){
        this.nombres = nombres;
        return this;
    }


    public PacienteBuilder apellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
        return this;
    }


    public PacienteBuilder apellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
        return this;
    }

    public PacienteBuilder fechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }


    public PacienteBuilder curp(String curp) {
        this.curp = curp;
        return this;
    }

    public PacienteBuilder fullName(String fullName) {
        this.fullName = fullName;
        return this;

    }

    public Paciente build() {
        return new Paciente(nombres,apellidoPaterno,apellidoMaterno,fechaNacimiento,curp,fullName);
    }
}
