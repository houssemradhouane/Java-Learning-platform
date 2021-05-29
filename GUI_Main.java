
/**
 * GUI_Main
 * @author Flavien Mithieux
 * Description : Main Interface after log in
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.tree.*;

public class GUI_Main extends JPanel {
    private Themes th = new Themes();
    private String themes[][] = th.themes;

    private static JPanel tabs = new JPanel(new CardLayout());

    JTabbedPane typeDonnees = new JTabbedPane();
    JTabbedPane chaineCaractere = new JTabbedPane();
    JTabbedPane tableaux = new JTabbedPane();
    JTabbedPane exceptions = new JTabbedPane();
    JTabbedPane collections = new JTabbedPane();

    GUI_Main() {
        initComponents();
    }

    public static void themeSwitch(String newTheme) {

        CardLayout cl = (CardLayout) (tabs.getLayout());
        cl.show(tabs, newTheme);

    }

    private DefaultMutableTreeNode buildTree() {
        DefaultMutableTreeNode treeThemes = new DefaultMutableTreeNode("Thèmes");

        DefaultMutableTreeNode basique = new DefaultMutableTreeNode("Basique");
        DefaultMutableTreeNode intermediaire = new DefaultMutableTreeNode("Intermédiaire");
        DefaultMutableTreeNode avance = new DefaultMutableTreeNode("Avancé");

        treeThemes.add(basique);
        DefaultMutableTreeNode typeDonnees = new DefaultMutableTreeNode(themes[0][0]);
        DefaultMutableTreeNode chaineCaracteres = new DefaultMutableTreeNode(themes[0][1]);
        DefaultMutableTreeNode tableaux = new DefaultMutableTreeNode(themes[0][2]);
        basique.add(typeDonnees);
        basique.add(chaineCaracteres);
        basique.add(tableaux);

        treeThemes.add(intermediaire);
        DefaultMutableTreeNode exceptions = new DefaultMutableTreeNode(themes[1][0]);
        intermediaire.add(exceptions);

        treeThemes.add(avance);
        DefaultMutableTreeNode collections = new DefaultMutableTreeNode(themes[2][0]);
        avance.add(collections);

        return treeThemes;
    }

    private void buildCours() {
        JEditorPane coursTypeDonnees = new Cours(themes[0][0]);
        typeDonnees.addTab("Cours", coursTypeDonnees);
        tabs.add(themes[0][0], typeDonnees);

        JEditorPane coursChaineCaractere = new Cours(themes[0][1]);
        chaineCaractere.addTab("Cours", coursChaineCaractere);
        tabs.add(themes[0][1], chaineCaractere);

        JEditorPane coursTableaux = new Cours(themes[0][2]);
        tableaux.addTab("Cours", coursTableaux);
        tabs.add(themes[0][2], tableaux);

        JEditorPane coursExceptions = new Cours(themes[1][0]);
        exceptions.addTab("Cours", coursExceptions);
        tabs.add(themes[1][0], exceptions);

        JEditorPane coursCollections = new Cours(themes[2][0]);
        collections.addTab("Cours", coursCollections);
        tabs.add(themes[2][0], collections);
    }

    private void buildQcm(Quizs quizs) {

        Qcm[] quiz_All = quizs.quizQcm();

        for (int i = 0; i < quiz_All.length; i++) {
            if (quiz_All[i].getTheme().equals(themes[0][0])) {
                JPanel pan = new QcmFrame(quiz_All[i]);
                typeDonnees.addTab("QCM", pan);
            }
            else if (quiz_All[i].getTheme().equals(themes[0][1])) {
                JPanel pan = new QcmFrame(quiz_All[i]);
                chaineCaractere.addTab("QCM", pan);
            }
            else if (quiz_All[i].getTheme().equals(themes[0][2])) {
                JPanel pan = new QcmFrame(quiz_All[i]);
                tableaux.addTab("QCM", pan);
            }
            else if (quiz_All[i].getTheme().equals(themes[1][0])) {
                JPanel pan = new QcmFrame(quiz_All[i]);
                exceptions.addTab("QCM", pan);
            }
            else if (quiz_All[i].getTheme().equals(themes[2][0])) {
                JPanel pan = new QcmFrame(quiz_All[i]);
                collections.addTab("QCM", pan);
            }
        }

    }

    private void buildQrc(Quizs quizs) {
        Qrc[] quiz_All = quizs.quizQrc();

        for (int i = 0; i < quiz_All.length; i++) {
            if (quiz_All[i].getTheme().equals(themes[0][0])) {
                JPanel pan = new QrcFrame(quiz_All[i]);
                typeDonnees.addTab("QRC", pan);
            }
            else if (quiz_All[i].getTheme().equals(themes[0][1])) {
                JPanel pan = new QrcFrame(quiz_All[i]);
                chaineCaractere.addTab("QRC", pan);
            }
            else if (quiz_All[i].getTheme().equals(themes[0][2])) {
                JPanel pan = new QrcFrame(quiz_All[i]);
                tableaux.addTab("QRC", pan);
            }
            else if (quiz_All[i].getTheme().equals(themes[1][0])) {
                JPanel pan = new QrcFrame(quiz_All[i]);
                exceptions.addTab("QRC", pan);
            }
            else if (quiz_All[i].getTheme().equals(themes[2][0])) {
                JPanel pan = new QrcFrame(quiz_All[i]);
                collections.addTab("QRC", pan);
            }
        }
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Build the tree
        DefaultMutableTreeNode treeThemes = buildTree();

        // Tree to navigate between themes
        JTree tree = new JTree(treeThemes);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setToggleClickCount(1);

        Event_TreeSelection treeListener = new Event_TreeSelection();
        tree.addTreeSelectionListener(treeListener);

        JScrollPane scrollTree = new JScrollPane(tree);
        scrollTree.setMinimumSize(new Dimension(200, 150));

        // Tabs to access courses, exercises or questions
        tabs.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

        buildCours();

        Quizs quizs = new Quizs();

        buildQcm(quizs);
        buildQrc(quizs);

        // Separation of the 2 main components
        JSplitPane mainSeparator = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollTree, tabs);
        mainSeparator.setResizeWeight(0.1);

        add(mainSeparator);
    }

}