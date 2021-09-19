package GUI;

import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;

public class BookChartPanel {


    private JPanel bookChartPanel;

    {setupUI();}

    private void setupUI(){
        bookChartPanel = new JPanel();
        bookChartPanel.setLayout(new FormLayout("", ""));
    }

    JPanel getBookChartPanel(){
        return bookChartPanel;
    }

}
