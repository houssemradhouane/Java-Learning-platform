import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignInGUI {

	private JFrame frmSignin;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private BaseUtilisateurs base = new BaseUtilisateurs();
	private JLabel message;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new SignInGUI();
	}

	/**
	 * Create the application.
	 */
	public SignInGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignin = new JFrame();
		frmSignin.setTitle("Sign-in");
		frmSignin.setResizable(false);
		frmSignin.setVisible(true);
		frmSignin.getContentPane().setBackground(SystemColor.controlDkShadow);
		frmSignin.setBounds(100, 100, 563, 394);
		frmSignin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.scrollbar, SystemColor.scrollbar));
		panel.setBackground(SystemColor.controlShadow);
		panel.setBounds(85, 36, 378, 268);
		frmSignin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Identifiant : ");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(51, 96, 112, 25);
		panel.add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe : ");
		lblMotDePasse.setForeground(Color.WHITE);
		lblMotDePasse.setFont(new Font("Consolas", Font.BOLD, 15));
		lblMotDePasse.setBounds(51, 131, 128, 25);
		panel.add(lblMotDePasse);
		
		textField = new JTextField() {
			@Override public void setBorder(Border border) {
		        // Commentaire inutile : le but est d'éliminer le border
		    }
		};
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBackground(SystemColor.controlDkShadow);
		textField.setBounds(177, 96, 137, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField() {
			@Override public void setBorder(Border border) {
		        // Commentaire inutile : le but est d'éliminer le border
		    }
		};
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordField.setBackground(SystemColor.controlDkShadow);
		passwordField.setBounds(177, 134, 137, 19);
		panel.add(passwordField);
		
		btnNewButton = new JButton("Retour au menu principal");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSignin.dispose();
			}
		});
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(137, 237, 231, 21);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("ok!");
		btnNewButton_1.setBackground(SystemColor.controlShadow);
		btnNewButton_1.setForeground(SystemColor.controlLtHighlight);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFont(new Font("Consolas", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = textField.getText();
				String password = passwordField.getText();
			      if (base.authentifier(userName, password)) {
			         message.setText(" Hello " + userName + "");
			      } else {
			         message.setText(" Invalid user.. ");
			      }
			}
		});
		btnNewButton_1.setBounds(137, 189, 81, 19);
		panel.add(btnNewButton_1);
		
		message = new JLabel("");
		message.setForeground(Color.RED);
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setBounds(124, 166, 137, 13);
		panel.add(message);
	}
}
