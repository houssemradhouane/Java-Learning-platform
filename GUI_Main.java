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
    private String themes[][]= th.themes;

    private JPanel tabs = new JPanel(new CardLayout());

    GUI_Main() {        
        initComponents();        
    }

    public static void themeSwitch(String newTheme) {
        
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

    private void initComponents() {
        setLayout(new BorderLayout());

        //Build the tree
        DefaultMutableTreeNode treeThemes = buildTree();


        //Tree to navigate between themes
        JTree tree = new JTree(treeThemes);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setToggleClickCount(1);

        Event_TreeSelection treeListener = new Event_TreeSelection();
        tree.addTreeSelectionListener(treeListener);

        JScrollPane scrollTree = new JScrollPane(tree);
        scrollTree.setMinimumSize(new Dimension(200,150));       

        

        //Tabs to access courses, exercises or questions
        tabs.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

        JTabbedPane typeDonnees = new JTabbedPane();
        JEditorPane coursTypeDonnees = new Cours(themes[0][0]);
        typeDonnees.addTab("Cours", coursTypeDonnees);
        tabs.add(themes[0][0], typeDonnees);
        
        
        //Separation of the 2 main components
        JSplitPane mainSeparator = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollTree, tabs);
        mainSeparator.setResizeWeight(0.1);
        
        add(mainSeparator);
    }
    
}