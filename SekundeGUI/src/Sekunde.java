import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Sekunde {

	private JFrame frmOvoJeMoj;
	private JTextField textField;
	int sekunde;
	int sati;
	int minuti;
	int preostaliMinuti;
	int preostaleSekunde;
	private JLabel lblIznos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sekunde window = new Sekunde();
					window.frmOvoJeMoj.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Sekunde() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOvoJeMoj = new JFrame();
		frmOvoJeMoj.setTitle("Ovo je moj program za pretvaranje sekundi");
		frmOvoJeMoj.getContentPane().setBackground(new Color(245, 222, 179));
		frmOvoJeMoj.setBounds(100, 100, 450, 300);
		frmOvoJeMoj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOvoJeMoj.getContentPane().setLayout(null);
		
		JLabel lblKonverterSekundi = new JLabel("KONVERTER SEKUNDI");
		lblKonverterSekundi.setFont(new Font("Dialog", Font.BOLD, 14));
		lblKonverterSekundi.setBounds(130, 12, 174, 15);
		frmOvoJeMoj.getContentPane().add(lblKonverterSekundi);
		
		JLabel lblUnesiteSekunde = new JLabel("Unesite sekunde");
		lblUnesiteSekunde.setBounds(38, 70, 143, 15);
		frmOvoJeMoj.getContentPane().add(lblUnesiteSekunde);
		
		textField = new JTextField();
		textField.setForeground(Color.BLUE);
		textField.setText(" ");
		textField.setBounds(177, 68, 189, 19);
		frmOvoJeMoj.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblRezultat = new JLabel("Rezultat");
		lblRezultat.setBounds(39, 182, 66, 15);
		frmOvoJeMoj.getContentPane().add(lblRezultat);
		
		JButton btnKonvertuj = new JButton("KONVERTUJ");
		btnKonvertuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try { 
				
				sekunde = (int) Double.parseDouble(textField.getText());
				sati = sekunde / 3600;
				minuti = sekunde / 60;
				preostaliMinuti = minuti % 60;
				preostaleSekunde = sekunde % 60;
				
				lblIznos.setText(sati + " h " + preostaliMinuti + " m " + preostaleSekunde + " s.");
				
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(frmOvoJeMoj, e.getMessage());
				}
			
			}
		});
		btnKonvertuj.setBounds(67, 117, 114, 25);
		frmOvoJeMoj.getContentPane().add(btnKonvertuj);
		
		lblIznos = new JLabel(" ");
		lblIznos.setForeground(Color.RED);
		lblIznos.setBounds(177, 182, 189, 15);
		frmOvoJeMoj.getContentPane().add(lblIznos);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblIznos.setText("0 h : 0 m : 0 s");
				textField.setText(" ");
			}
		});
		btnReset.setBounds(252, 117, 114, 25);
		frmOvoJeMoj.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(290, 209, 114, 25);
		frmOvoJeMoj.getContentPane().add(btnExit);
		
		JMenuBar menuBar = new JMenuBar();
		frmOvoJeMoj.setJMenuBar(menuBar);
		
		JMenu mnOpcije = new JMenu("Opcije");
		menuBar.add(mnOpcije);
		
		JMenuItem mntmReset = new JMenuItem("Reset");
		mntmReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblIznos.setText("0 h : 0 m : 0 s");
				textField.setText(" ");
			}
		});
		mnOpcije.add(mntmReset);
		
		JMenuItem mntmOProgramu = new JMenuItem("O Programu");
		mntmOProgramu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mntmOProgramu,"                                                      Ovo je moj prvi program. "
						+ "\n Potrebno je da unesete sekunde da bi izračunali koliko je to sati, minuta i preostalih sekundi."
						+ "\n                                                       Created by Emir Totić");
			}
		});
		mnOpcije.add(mntmOProgramu);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnOpcije.add(mntmExit);
		
		
		
	}
}
