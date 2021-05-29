import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JTree;
import java.awt.Font;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Houssem Radhouane
 *
 */

public class WorkBenchGUI {

	static int numero = 0;

	private JFrame frame;
	
	static boolean invokeJouer = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			      	WorkBenchGUI window = new WorkBenchGUI();

	}

	/**
	 * Create the application.
	 */
	public WorkBenchGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Quizs quizs = new Quizs();
		// Tous les qcm du jeu .
		Qcm[] quiz_All = quizs.quizQcm();
		// tous les qrc du jeu
		Qrc[] qrcs = quizs.quizQrc();
		frame = new JFrame();
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setBackground(SystemColor.controlDkShadow);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.controlHighlight, null));
		panel.setBackground(SystemColor.controlDkShadow);
		panel.setBounds(10, 10, 213, 635);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton_1 = new JButton("< D\u00E9butant >");
		btnNewButton_1.setBackground(SystemColor.textText);
		btnNewButton_1.setForeground(SystemColor.window);
		btnNewButton_1.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setContentAreaFilled(true);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(2, 110, 209, 21);
		panel.add(btnNewButton_1);
		JButton btnNewButton_1_1 = new JButton("./TypesDeDonn\u00E9es");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero = 1;
			}
		});
		btnNewButton_1_1.setBackground(SystemColor.controlShadow);
		btnNewButton_1_1.setOpaque(true);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnNewButton_1_1.setContentAreaFilled(true);
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBounds(2, 141, 209, 21);
		panel.add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("./String");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero = 2;
			}
		});
		btnNewButton_1_2.setBackground(SystemColor.controlShadow);
		btnNewButton_1_2.setOpaque(true);
		btnNewButton_1_2.setForeground(Color.WHITE);
		btnNewButton_1_2.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnNewButton_1_2.setContentAreaFilled(true);
		btnNewButton_1_2.setBorderPainted(false);
		btnNewButton_1_2.setBounds(2, 162, 209, 21);
		panel.add(btnNewButton_1_2);

		JButton btnNewButton_1_3 = new JButton("./Tableaux");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero = 3;
			}
		});
		btnNewButton_1_3.setBackground(SystemColor.controlShadow);
		btnNewButton_1_3.setOpaque(true);
		btnNewButton_1_3.setForeground(Color.WHITE);
		btnNewButton_1_3.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnNewButton_1_3.setContentAreaFilled(true);
		btnNewButton_1_3.setBorderPainted(false);
		btnNewButton_1_3.setBounds(2, 183, 209, 21);
		panel.add(btnNewButton_1_3);

		JButton btnNewButton_1_4 = new JButton("< Interm\u00E9diaire >");
		btnNewButton_1_4.setOpaque(true);
		btnNewButton_1_4.setForeground(Color.WHITE);
		btnNewButton_1_4.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnNewButton_1_4.setContentAreaFilled(true);
		btnNewButton_1_4.setBorderPainted(false);
		btnNewButton_1_4.setBackground(Color.BLACK);
		btnNewButton_1_4.setBounds(2, 251, 209, 21);
		panel.add(btnNewButton_1_4);

		JButton btnNewButton_1_1_1 = new JButton("./Exceptions");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero = 4;
			}
		});
		btnNewButton_1_1_1.setOpaque(true);
		btnNewButton_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnNewButton_1_1_1.setContentAreaFilled(true);
		btnNewButton_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1.setBackground(SystemColor.controlShadow);
		btnNewButton_1_1_1.setBounds(2, 282, 209, 21);
		panel.add(btnNewButton_1_1_1);

		JButton btnNewButton_1_4_1 = new JButton("< Avanc\u00E9>");
		btnNewButton_1_4_1.setOpaque(true);
		btnNewButton_1_4_1.setForeground(Color.WHITE);
		btnNewButton_1_4_1.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnNewButton_1_4_1.setContentAreaFilled(true);
		btnNewButton_1_4_1.setBorderPainted(false);
		btnNewButton_1_4_1.setBackground(Color.BLACK);
		btnNewButton_1_4_1.setBounds(2, 343, 209, 21);
		panel.add(btnNewButton_1_4_1);

		JButton btnNewButton_1_1_1_1 = new JButton("./Collections");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero = 5;
			}
		});
		btnNewButton_1_1_1_1.setOpaque(true);
		btnNewButton_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_1.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnNewButton_1_1_1_1.setContentAreaFilled(true);
		btnNewButton_1_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1_1.setBackground(SystemColor.controlShadow);
		btnNewButton_1_1_1_1.setBounds(2, 374, 209, 21);
		panel.add(btnNewButton_1_1_1_1);

		JLabel lblNewLabel = new JLabel("Th\u00E8mes");
		lblNewLabel.setBackground(SystemColor.desktop);
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(2, 2, 209, 51);
		lblNewLabel.setOpaque(true);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.controlHighlight, null));
		panel_1.setBackground(SystemColor.controlDkShadow);
		panel_1.setBounds(230, 60, 1086, 679);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Bienvenue !");
		lblNewLabel_1.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 36));
		lblNewLabel_1.setBounds(22, 23, 1054, 66);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel(
				"<html>Pour afficher un cours : <br>\r\n1) Choisis le th\u00E8me de ton pr\u00E9f\u00E9rence \u00E0 gauche .\r\n <br>2) Un clic sur le bouton \" Il s'agit de quoi? \" en haut affichera le cours associ\u00E9.\r\n<br>3) Si t'as des remarques sur le contenu, le bouton feedback te permettra de contacter <br>ton prof si t'as choisi un, sinon tu peux choisir \"admin\" comme destinataire pour nous contacter directement.");
		lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 21));
		lblNewLabel_2.setBounds(22, 99, 1054, 209);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel(
				"<html>Pour s'auto-tester : <br>\r\n1) Une fen\u00EAtre est ouverte avec celle-ci, elle contient les tests<br>haut .\r\n <br>2) Les tests sont vari\u00E9s : QCM, QRC, Code \u00E0 \u00E9crire ...\r\n<br>3) Chaque question a un temps limite et \u00E0 la fin du test ton score sera affich\u00E9.\r\n<br>4) NE FERMES CETTE FENETRE QUE SI TU VAS QUITTER L'APPLICATION\r\n<br> ( On est encore en version beta :) )");
		lblNewLabel_2_1.setFont(new Font("Consolas", Font.BOLD, 21));
		lblNewLabel_2_1.setBounds(22, 349, 1038, 180);
		panel_1.add(lblNewLabel_2_1);

		JButton btnSeDconnecter = new JButton("Se d\u00E9connecter");
		btnSeDconnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignInGUI signin = new SignInGUI();
				frame.dispose();
			}
		});
		btnSeDconnecter.setFont(new Font("Consolas", Font.BOLD, 16));
		btnSeDconnecter.setBounds(10, 702, 213, 37);
		frame.getContentPane().add(btnSeDconnecter);

		JButton btnFeedback = new JButton("Feedback");
		btnFeedback.setFont(new Font("Consolas", Font.BOLD, 16));
		btnFeedback.setBounds(10, 655, 213, 37);
		frame.getContentPane().add(btnFeedback);

		JButton btnFeedback_1 = new JButton("Il s'agit de quoi?");
		btnFeedback_1.setFont(new Font("Consolas", Font.BOLD, 16));
		btnFeedback_1.setBounds(238, 13, 213, 37);
		frame.getContentPane().add(btnFeedback_1);

		JLabel btnFautChoisirUn = new JLabel("Faut choisir un th\u00E8me d'abord");
		btnFautChoisirUn.setOpaque(false);
		btnFautChoisirUn.setBounds(684, 20, 231, 21);
		btnFautChoisirUn.setVisible(false);
		frame.getContentPane().add(btnFautChoisirUn);
		frame.setBounds(100, 100, 1340, 786);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		Jouer jeu = new Jouer();
	}
}
