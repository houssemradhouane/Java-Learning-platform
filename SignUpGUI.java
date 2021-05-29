import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Houssem Radhouane
 *
 */

public class SignUpGUI {

	private JFrame frmSignUp;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_3;
	private BaseUtilisateurs base = new BaseUtilisateurs();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	       new SignUpGUI();
	}

	/**
	 * Create the application.
	 */
	public SignUpGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignUp = new JFrame();
		frmSignUp.setTitle("Sign up");
		frmSignUp.setResizable(false);
		frmSignUp.setVisible(true);
		frmSignUp.getContentPane().setBackground(SystemColor.controlDkShadow);
		frmSignUp.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.scrollbar, SystemColor.scrollbar));
		panel.setBackground(SystemColor.controlShadow);
		panel.setBounds(159, 81, 419, 530);
		frmSignUp.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblVoustes = new JLabel("Vous \u00EAtes : ");
		lblVoustes.setForeground(Color.WHITE);
		lblVoustes.setFont(new Font("Consolas", Font.BOLD, 15));
		lblVoustes.setBounds(113, 111, 96, 25);
		panel.add(lblVoustes);
		
		JLabel lblIdentifiant = new JLabel("nom : ");
		lblIdentifiant.setForeground(Color.WHITE);
		lblIdentifiant.setFont(new Font("Consolas", Font.BOLD, 15));
		lblIdentifiant.setBounds(161, 154, 48, 25);
		panel.add(lblIdentifiant);
		
		JLabel lblPrnom = new JLabel("pr\u00E9nom : ");
		lblPrnom.setForeground(Color.WHITE);
		lblPrnom.setFont(new Font("Consolas", Font.BOLD, 15));
		lblPrnom.setBounds(138, 189, 72, 25);
		panel.add(lblPrnom);
		
		JLabel lblNewLabel_3 = new JLabel("Identifiant : ");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Consolas", Font.BOLD, 15));
		lblNewLabel_3.setBounds(98, 224, 112, 25);
		panel.add(lblNewLabel_3);
		
		JLabel lblMotDePasse = new JLabel("mot de passe : ");
		lblMotDePasse.setForeground(Color.WHITE);
		lblMotDePasse.setFont(new Font("Consolas", Font.BOLD, 15));
		lblMotDePasse.setBounds(90, 259, 120, 25);
		panel.add(lblMotDePasse);
		
		JLabel lbloptionnel = new JLabel("(optionnel)");
		lbloptionnel.setForeground(Color.WHITE);
		lbloptionnel.setFont(new Font("Consolas", Font.BOLD, 15));
		lbloptionnel.setBounds(71, 351, 96, 25);
		panel.add(lbloptionnel);
		
		JLabel lblVotreEnseignant = new JLabel("Votre enseignant : ");
		lblVotreEnseignant.setForeground(Color.WHITE);
		lblVotreEnseignant.setFont(new Font("Consolas", Font.BOLD, 15));
		lblVotreEnseignant.setBounds(61, 329, 152, 25);
		panel.add(lblVotreEnseignant);
		
		textField_3 = new JTextField() {
			public void setBorder(Border border) {
			}
		};
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setBackground(SystemColor.controlDkShadow);
		textField_3.setBounds(235, 331, 137, 19);
		panel.add(textField_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().toString().equals("Enseignant")) {
					lbloptionnel.setVisible(false);
					lblVotreEnseignant.setVisible(false);
					textField_3.setVisible(false);
				} else {
					lbloptionnel.setVisible(true);
					lblVotreEnseignant.setVisible(true);
					textField_3.setVisible(true);
				}
			}
		});
		comboBox.setFont(new Font("Consolas", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Etudiant", "Enseignant"}));
		comboBox.setBounds(235, 113, 136, 21);
		panel.add(comboBox);
		
		textField = new JTextField() {
			public void setBorder(Border border) {
			}
		};
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setColumns(10);
		textField.setBackground(SystemColor.controlDkShadow);
		textField.setBounds(235, 154, 137, 19);
		panel.add(textField);
		
		textField_1 = new JTextField() {
			public void setBorder(Border border) {
			}
		};
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.controlDkShadow);
		textField_1.setBounds(234, 191, 137, 19);
		panel.add(textField_1);
		
		textField_2 = new JTextField() {
			public void setBorder(Border border) {
			}
		};
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.controlDkShadow);
		textField_2.setBounds(234, 226, 137, 19);
		panel.add(textField_2);
		
		JLabel lblRentrezMotDe = new JLabel("R\u00E9entrez \r\nmot de passe : ");
		lblRentrezMotDe.setForeground(Color.WHITE);
		lblRentrezMotDe.setFont(new Font("Consolas", Font.BOLD, 15));
		lblRentrezMotDe.setBounds(20, 294, 192, 25);
		panel.add(lblRentrezMotDe);
		
		passwordField = new JPasswordField() {
			public void setBorder(Border border) {
			}
		};
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordField.setBackground(SystemColor.controlDkShadow);
		passwordField.setBounds(234, 261, 137, 19);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField() {
			public void setBorder(Border border) {
			}
		};
		passwordField_1.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordField_1.setBackground(SystemColor.controlDkShadow);
		passwordField_1.setBounds(234, 296, 137, 19);
		panel.add(passwordField_1);
		
		
		JLabel lblNewLabel = new JLabel("Sign up");
		lblNewLabel.setForeground(SystemColor.controlDkShadow);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 28));
		lblNewLabel.setBounds(154, 41, 143, 43);
		panel.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(61, 386, 290, 25);
		panel.add(lblNewLabel_1);
		frmSignUp.setBounds(100, 100, 757, 707);
		frmSignUp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean champsRemplis;
				champsRemplis = !(textField.getText().isEmpty()) && !(textField_1.getText().isEmpty()) && !(textField_2.getText().isEmpty()) &&
						                                                                                  !(passwordField.getText().isEmpty()) &&
						                                                                                  !(passwordField_1.getText().isEmpty());
				if (base.utilisateurExistant(textField_2.getText())) {
					lblNewLabel_1.setText(" Identifiant déja utilisé ");
				} else if (!champsRemplis) {
					lblNewLabel_1.setText(" Remplir tout les champs obligatoires s.v.p ");
				} else {
					if (!passwordField_1.getText().equals(passwordField.getText())) {
						lblNewLabel_1.setText(" Unmatching Passwords ");
					} else {
						if ((comboBox.getSelectedItem().toString().equals("Etudiant")) && (!textField_3.getText().isEmpty()) && (!base.enseignantExistant(textField_3.getText()))) {
							lblNewLabel_1.setText(" Enseignant Non existant ");
						} else {
							if (comboBox.getSelectedItem().toString().equals("Enseignant")) {
								base.ajouterEnseignant(textField_2.getText(), passwordField.getText(), textField.getText(), textField_1.getText());
								new SignUPSuccessfulGUI();
								frmSignUp.dispose();
							} else {
								if (textField_3.getText().isEmpty()) {
									base.ajouterEtudiant(textField_2.getText(), passwordField.getText(), textField.getText(), textField_1.getText(),"admin");
									new SignUPSuccessfulGUI();
									frmSignUp.dispose();
								} else {
									base.ajouterEtudiant(textField_2.getText(), passwordField.getText(), textField.getText(), textField_1.getText(),textField_3.getText());
									new SignUPSuccessfulGUI();
									frmSignUp.dispose();
								}
							}
						}
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Consolas", Font.BOLD, 16));
		btnNewButton.setBounds(150, 426, 120, 37);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Retour au menu principal");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSignUp.dispose();
			}
		});
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(92, 482, 231, 21);
		panel.add(btnNewButton_1);
	}
}
