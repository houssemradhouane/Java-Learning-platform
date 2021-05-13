import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUPSuccessfulGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new SignUPSuccessfulGUI();
	}

	/**
	 * Create the application.
	 */
	public SignUPSuccessfulGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setBackground(SystemColor.controlDkShadow);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.scrollbar, SystemColor.scrollbar));
		panel.setBackground(SystemColor.controlShadow);
		panel.setBounds(76, 55, 294, 148);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Compte Cr\u00E9\u00E9 !");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(72, 34, 145, 26);
		panel.add(lblNewLabel);
		
		JLabel lblConnectezvous = new JLabel("Connectez-vous");
		lblConnectezvous.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnectezvous.setForeground(Color.WHITE);
		lblConnectezvous.setFont(new Font("Consolas", Font.BOLD, 18));
		lblConnectezvous.setBounds(60, 66, 163, 26);
		panel.add(lblConnectezvous);
		
		JButton btnNewButton = new JButton("Ok!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(99, 102, 85, 21);
		panel.add(btnNewButton);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
