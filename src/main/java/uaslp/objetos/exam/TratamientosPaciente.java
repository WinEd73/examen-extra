package uaslp.objetos.exam;

import java.util.List;

public class TratamientosPaciente {
    private Paciente paciente;
    private Tratamiento tratamiento;
    public TratamientosPaciente(Paciente paciente) {
        this.paciente = paciente;
    }


    public void addTratamiento(Tratamiento tratamiento) throws TratamientoNoSoportadoException{
        if(tratamiento == Tratamiento.CALENTURA){
            throw new TratamientoNoSoportadoException("Tratamiento CALENTURA no soportada");
        }
        this.tratamiento = tratamiento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public List<Tratamiento> getTratamientos() {
        return (List<Tratamiento>) this;

    }
}
