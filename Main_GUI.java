/**
 * Main_GUI
 * @author Flavien Mithieux
 * Description :
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class Main_GUI extends JPanel {

    Main_GUI() {
        initComponents();        
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        //Racine
        DefaultMutableTreeNode themes = new DefaultMutableTreeNode("Thèmes");

        //Themes classed by difficulty
        DefaultMutableTreeNode basique = new DefaultMutableTreeNode("Basique");
        DefaultMutableTreeNode intermediaire = new DefaultMutableTreeNode("Intermédiaire");
        DefaultMutableTreeNode avance = new DefaultMutableTreeNode("Avancé");

        //Basic themes
        themes.add(basique);
        DefaultMutableTreeNode typeDonnnees = new DefaultMutableTreeNode("Type de données");
        DefaultMutableTreeNode chaineCaracteres = new DefaultMutableTreeNode("Chaîne de caractères");
        DefaultMutableTreeNode tableaux = new DefaultMutableTreeNode("Tableaux");
        basique.add(typeDonnnees);
        basique.add(chaineCaracteres);
        basique.add(tableaux);

        //Medium difficult themes
        themes.add(intermediaire);
        DefaultMutableTreeNode exceptions = new DefaultMutableTreeNode("Exceptions");
        intermediaire.add(exceptions);

        //Advanced themes
        themes.add(avance);
        DefaultMutableTreeNode collections = new DefaultMutableTreeNode("Collections");
        avance.add(collections);

        //Tree to navigate between themes
        JTree tree = new JTree(themes);
        JScrollPane scrollTree = new JScrollPane(tree);
        scrollTree.setMinimumSize(new Dimension(150,150));
        
        //Tabs to access courses, exercises or questions
        JTabbedPane tabs = new JTabbedPane();
        tabs.setTabPlacement(JTabbedPane.TOP);

        //Example need implementation
        JTextArea cours1 = new JTextArea("Cours");
        tabs.add("Cours", cours1);

        JTextArea exercice = new JTextArea("Exercice");
        tabs.add("Exercice", exercice);

        //Separation of the 2 main components
        JSplitPane mainSeparator = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollTree, tabs);
        mainSeparator.setResizeWeight(0.1);
        
        add(mainSeparator);
    }
    
}