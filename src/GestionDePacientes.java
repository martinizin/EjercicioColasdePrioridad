import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GestionDePacientes {
    private PriorityQueue<Pacientes>colaPacientes;

    public GestionDePacientes() {
        colaPacientes = new PriorityQueue<>();
    }

    public void agregarPaciente(String nombre, String apellido, int prioridad) {
        Pacientes paciente = new Pacientes(nombre, apellido, prioridad);
        colaPacientes.add(paciente);
    }

    public Pacientes atenderPaciente() {
        return colaPacientes.poll(); //Retornamos el paciente con mayor prioridad en la cola
    }

    public boolean verificarPacientes() {
        return !colaPacientes.isEmpty();
    }
    public List<Pacientes> obtenerListaPacientes() {
        return new ArrayList<>(colaPacientes);
    }
}
