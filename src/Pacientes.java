public class Pacientes implements Comparable<Pacientes> {
    private String Nombre;
    private String Apellido;
    private  int prioridad=0;

    public Pacientes(String nombre, String apellido, int prioridad) {
        Nombre = nombre;
        Apellido = apellido;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(Pacientes otro) {
        return Integer.compare(this.prioridad, otro.prioridad);
    }


    @Override
    public String toString() {
        return Nombre + " " + Apellido + " (Prioridad: " + prioridad + ")";
    }
}



