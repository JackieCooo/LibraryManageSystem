package GUI;

import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;

public class LatestBookPanel {
    
    private JPanel latestBookPanel;

    {setupUI();}

    private void setupUI(){
        latestBookPanel = new JPanel();
        latestBookPanel.setLayout(new FormLayout("", ""));
    }

    JPanel getLatestBookPanel(){
        return latestBookPanel;
    }

}
