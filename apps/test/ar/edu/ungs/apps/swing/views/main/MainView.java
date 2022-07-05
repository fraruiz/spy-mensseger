package ar.edu.ungs.apps.swing.views.main;

import ar.edu.ungs.apps.swing.views.View;
import ar.edu.ungs.apps.swing.views.datasource.ChooseDatasourceView;

import javax.swing.*;
import java.awt.*;

public class MainView extends View {
    private JButton runButton;
    private JLabel titleLabel;
    
    public MainView() {
        initComponents();
    }

    private void initComponents() {
        titleLabel = new JLabel();
        runButton = new JButton();

        setTitleLabelProperties();

        setRunButtonProperties();

        buildLayout();

        pack();
    }

    private void setTitleLabelProperties() {
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setText("SPY MESSENGER");
    }

    private void setRunButtonProperties() {
        runButton.setText("Search minimum communication network panning");
        runButton.addActionListener(e -> {
            this.dispose();

            EventQueue.invokeLater(() -> {
                View window = new ChooseDatasourceView();
                window.setVisible(true);
            });
        });
    }

    private void buildLayout() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(runButton)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(runButton)
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }
}
