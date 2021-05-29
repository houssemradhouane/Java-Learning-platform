import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class LoginGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
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
	public LoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 835, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(105, 105, 105));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setForeground(new Color(85, 107, 47));
		layeredPane.setBackground(new Color(85, 107, 47));
		panel.add(layeredPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(211, 211, 211), new Color(211, 211, 211), new Color(211, 211, 211), new Color(211, 211, 211)));
		panel_1.setBackground(Color.GRAY);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBounds(215, 171, 414, 292);
		layeredPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Binevenue !");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel_1.setBounds(91, 10, 232, 53);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Se connecter");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignInGUI login = new SignInGUI();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(91, 84, 210, 38);
		panel_1.add(btnNewButton);
		
		JButton btnCrerUnCompte = new JButton("Cr\u00E9er un compte");
		btnCrerUnCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SignUpGUI();
			}
		});
		btnCrerUnCompte.setBackground(Color.LIGHT_GRAY);
		btnCrerUnCompte.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCrerUnCompte.setBounds(91, 148, 210, 38);
		panel_1.add(btnCrerUnCompte);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBackground(Color.LIGHT_GRAY);
		btnQuitter.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnQuitter.setBounds(91, 209, 210, 38);
		panel_1.add(btnQuitter);
		
		JLabel lblNewLabel = new JLabel("JLP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(247, 68, 309, 63);
		layeredPane.add(lblNewLabel);
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Source Code Pro Semibold", Font.BOLD, 74));
	}
}
