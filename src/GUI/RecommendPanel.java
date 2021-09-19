package GUI;

import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;

public class RecommendPanel {

    private JPanel recommendPanel;

    {setupUI();}

    private void setupUI(){
        recommendPanel = new JPanel();
        recommendPanel.setLayout(new FormLayout("", ""));
    }

    JPanel getRecommendPanel(){
        return recommendPanel;
    }

}
