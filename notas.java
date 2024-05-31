import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AplicativoNotas extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JButton saveButton;

    public AplicativoNotas() {
        setTitle("Aplicativo de Notas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        
        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

      
        saveButton = new JButton("Salvar");
        saveButton.addActionListener(this);
        add(saveButton, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(this);

            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                    BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
                    writer.write(textArea.getText());
                    writer.close();
                    JOptionPane.showMessageDialog(this, "Notas salvas com sucesso!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao salvar as notas.");
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AplicativoNotas().setVisible(true);
        });
    }
}
