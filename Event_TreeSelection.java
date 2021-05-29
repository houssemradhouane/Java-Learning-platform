/**
*   Event_TreeSelection
*	@author Flavien Mithieux
*	Description : Swap panels when another theme is selected
*
*/

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

public class Event_TreeSelection implements TreeSelectionListener {

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        String path = e.getPath().toString();

        //Remove brackets and commas
        path.substring(1, path.length() - 1);
        String pathSplit[] = path.split(",");

        if (pathSplit.length == 3) {
            GUI_Main.themeSwitch(pathSplit[2]);
        }
    }

}