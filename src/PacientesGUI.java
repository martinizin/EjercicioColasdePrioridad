import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PacientesGUI {
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JButton AGREGARPACIENTEButton;
    private JButton MOSTRARLISTADEPACIENTESButton;
    private JTextArea textArea1;
    private JButton ATENDERPACIENTEButton;
    private JPanel pGeneral;
    private GestionDePacientes gestionDePacientes;

public PacientesGUI() {
    gestionDePacientes= new GestionDePacientes();

    comboBox1.addItem("Prioridad Alta (1)");
    comboBox1.addItem("Prioridad Media (2)");
    comboBox1.addItem("Prioridad Baja (3)");


    AGREGARPACIENTEButton.addActionListener(new ActionListener() {
        @Override

            public void actionPerformed(ActionEvent e) {
                String nombre = textField1.getText();
                String apellido = textField2.getText();
                int prioridad = comboBox1.getSelectedIndex() + 1; // Convertir selección en prioridad (1, 2 o 3)

                if (!nombre.isEmpty() && !apellido.isEmpty()) {
                    gestionDePacientes.agregarPaciente(nombre, apellido, prioridad);
                    JOptionPane.showMessageDialog(null, "Paciente agregado: " + nombre + " " + apellido);
                    textField1.setText(""); // Limpiar campo de nombre
                    textField2.setText(""); // Limpiar campo de apellido
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese nombre y apellido del paciente.");
                }
            }


    });
    MOSTRARLISTADEPACIENTESButton.addActionListener(new ActionListener() {
        @Override

            public void actionPerformed(ActionEvent e) {
                StringBuilder listaPacientes = new StringBuilder("Lista de Pacientes en espera:\n");

                for (Pacientes paciente : gestionDePacientes.obtenerListaPacientes()) {
                    listaPacientes.append(paciente).append("\n");
                }

                textArea1.setText(listaPacientes.toString());
            }


    });
    ATENDERPACIENTEButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (gestionDePacientes.verificarPacientes()) {
                    Pacientes paciente = gestionDePacientes.atenderPaciente();
                    JOptionPane.showMessageDialog(null, "Atendiendo a: " + paciente);
                } else {
                    JOptionPane.showMessageDialog(null, "No hay pacientes en la cola.");
                }
            }


    });
}

    public static void main(String[] args) {
        JFrame frame = new JFrame("PacientesGUI");
        frame.setContentPane(new PacientesGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
