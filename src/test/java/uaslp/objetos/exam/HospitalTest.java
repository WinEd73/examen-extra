package uaslp.objetos.exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class HospitalTest {

    @Test
    public void test1() {

        // Given / When:
        Paciente paciente = Paciente.builder()
                .nombres("Jose Francisco")
                .apellidoPaterno("Lopez")
                .apellidoMaterno("Sanchez")
                .fechaNacimiento(LocalDate.of(2005, Month.AUGUST, 10))
                .curp("SAOJ050810HSPRDV10")
                .build();

        // Then:
        Assertions.assertEquals("Jose Francisco", paciente.getNombres());
        Assertions.assertEquals("Lopez", paciente.getApellidoPaterno());
        Assertions.assertEquals("Sanchez", paciente.getApellidoMaterno());
        Assertions.assertEquals(2005, paciente.getFechaNacimiento().getYear());
        Assertions.assertEquals(Month.AUGUST, paciente.getFechaNacimiento().getMonth());
        Assertions.assertEquals(10, paciente.getFechaNacimiento().getDayOfMonth());
        Assertions.assertEquals("Jose Francisco Lopez Sanchez", paciente.getFullName());
    }

    @Test
    public void test2() {

        // Given / When:
        Exception ex = Assertions.assertThrows(FechaDeNacimientoRequeridaException.class, () -> Paciente.builder()
                .nombres("Jose Francisco")
                .apellidoPaterno("Lopez")
                .apellidoMaterno("Sanchez")
                .curp("SAOJ050810HSPRDV10")
                .build());

        // Then:
        Assertions.assertTrue(ex instanceof HospitalException);
        Assertions.assertEquals("Fecha de nacimiento requerida", ex.getMessage());
    }

    @Test
    public void test3() {

        // Given / When:
        Exception ex = Assertions.assertThrows(FechaDeNacimientoRequeridaException.class, () -> Paciente.builder()
                .nombres("Jose Francisco")
                .apellidoPaterno("Lopez")
                .apellidoMaterno("Sanchez")
                .build());

        // Then:
        Assertions.assertTrue(ex instanceof HospitalException);
        Assertions.assertEquals("CURP requerida", ex.getMessage());
    }

    @Test
    public void test4() {

        // Given:
        Paciente paciente = Paciente.builder()
                .nombres("Jose Francisco")
                .apellidoPaterno("Lopez")
                .apellidoMaterno("Sanchez")
                .fechaNacimiento(LocalDate.of(2005, Month.AUGUST, 10))
                .curp("SAOJ050810HSPRDV10")
                .build();
        TratamientosPaciente tratamientosPaciente = new TratamientosPaciente(paciente);

        tratamientosPaciente.addTratamiento(Tratamiento.TOS);
        tratamientosPaciente.addTratamiento(Tratamiento.GRIPA);
        tratamientosPaciente.addTratamiento(Tratamiento.DOLOR_CABEZA);

        // Then:
        Paciente pacienteTratado = tratamientosPaciente.getPaciente();
        List<Tratamiento> tratamientos = tratamientosPaciente.getTratamientos();

        Assertions.assertEquals("Jose Francisco", pacienteTratado.getNombres());
        Assertions.assertEquals("Lopez", pacienteTratado.getApellidoPaterno());
        Assertions.assertEquals("Sanchez", pacienteTratado.getApellidoMaterno());
        Assertions.assertEquals(2005, pacienteTratado.getFechaNacimiento().getYear());
        Assertions.assertEquals(Month.AUGUST, pacienteTratado.getFechaNacimiento().getMonth());
        Assertions.assertEquals(10, pacienteTratado.getFechaNacimiento().getDayOfMonth());
        Assertions.assertEquals("Jose Francisco Lopez Sanchez", pacienteTratado.getFullName());

        Assertions.assertEquals(3, tratamientos.size());

        Assertions.assertTrue(Tratamiento.TOS instanceof Tratamiento);
        Assertions.assertTrue(Tratamiento.GRIPA instanceof Tratamiento);
        Assertions.assertTrue(Tratamiento.DOLOR_CABEZA instanceof Tratamiento);
        Assertions.assertTrue(Tratamiento.CALENTURA instanceof Tratamiento);
    }

    @Test
    public void test5() {

        // Given:
        Paciente paciente = Paciente.builder()
                .nombres("Jose Francisco")
                .apellidoPaterno("Lopez")
                .apellidoMaterno("Sanchez")
                .fechaNacimiento(LocalDate.of(2005, Month.AUGUST, 10))
                .curp("SAOJ050810HSPRDV10")
                .build();
        TratamientosPaciente tratamientosPaciente = new TratamientosPaciente(paciente);

        try {
            tratamientosPaciente.addTratamiento(Tratamiento.TOS);
            tratamientosPaciente.addTratamiento(Tratamiento.GRIPA);
            tratamientosPaciente.addTratamiento(Tratamiento.DOLOR_CABEZA);
            tratamientosPaciente.addTratamiento(Tratamiento.CALENTURA);
            Assertions.fail("addTratamiento debe lanzar excepción al añadir CALENTURA");
        }catch (HospitalException ex){
            Assertions.assertTrue(ex instanceof TratamientoNoSoportadoException);
            Assertions.assertEquals("Tratamiento CALENTURA no soportada", ex.getMessage());
        }
    }
}
