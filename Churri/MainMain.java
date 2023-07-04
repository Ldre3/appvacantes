import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MainMain {

	private JFrame frame;
	private JTextField Ruta;
	Gestor gst = new Gestor();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMain window = new MainMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		Ruta = new JTextField();
		Ruta.setBounds(109, 84, 86, 20);
		frame.getContentPane().add(Ruta);
		Ruta.setColumns(10);
		
		JLabel Etiqueta = new JLabel("Ruta:");
		Etiqueta.setBounds(29, 87, 46, 14);
		frame.getContentPane().add(Etiqueta);
		
		JButton Boton = new JButton("Buscar");
		Boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ruta = Ruta.getText();
				try {
					int resultado = gst.Contar(ruta);
					JDialog ventana = new Ventana();
					ventana.setLocationRelativeTo(null);
					ventana.getContentPane().add(new JLabel("Hay "+resultado+" plazas de PT a media jornada",SwingConstants.CENTER));
					ventana.setVisible(true);
				} catch (Exception e1) {
					JDialog ventana = new Ventana();
					ventana.setLocationRelativeTo(null);
					ventana.getContentPane().add(new JLabel("Error churri mete el archivo bien",SwingConstants.CENTER));
					ventana.setVisible(true);
				}
			}
		});
		Boton.setBounds(213, 83, 89, 23);
		frame.getContentPane().add(Boton);
	}
}
