package ar.edu.ungs.spymensseger.apps.swing.views.datasource;

import ar.edu.ungs.spymensseger.apps.swing.views.View;
import ar.edu.ungs.spymensseger.apps.swing.views.network.ListMinimumCommunicationNetworkSpanningView;
import ar.edu.ungs.spymensseger.apps.swing.views.spies.CreateSpiesFormView;
import ar.edu.ungs.spymensseger.modules.networks.application.mst.MinimumCommunicationNetworkSpanningSearcher;
import ar.edu.ungs.spymensseger.modules.networks.domain.mst.MinimumCommunicationNetworkSpanningStrategy;
import ar.edu.ungs.spymensseger.modules.networks.infrastructure.singleton.MinimumCommunicationNetworkSpanningSearcherSingleton;
import ar.edu.ungs.spymensseger.modules.shared.persistence.PersistenceType;

import javax.swing.*;
import java.awt.*;

public class ChooseDatasourceView extends View {
    private JButton fileButton;
    private JButton manualButton;
    private JLabel titleLabel;

    public ChooseDatasourceView() {
        super();

        initComponents();
    }

    private void initComponents() {
        this.titleLabel = new JLabel();
        this.manualButton = new JButton();
        this.fileButton = new JButton();

        setTitleLabelProperties();

        setManualButtonProperties();

        setFileButtonProperties();

        buildLayout();

        pack();
    }

    private void buildLayout() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel,
                    GroupLayout.Alignment.TRAILING,
                    GroupLayout.DEFAULT_SIZE,
                    GroupLayout.DEFAULT_SIZE,
                    Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(manualButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(fileButton)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(manualButton)
                    .addComponent(fileButton))
                .addGap(0, 38, Short.MAX_VALUE))
        );
    }

    private void setFileButtonProperties() {
        fileButton.setText("JSON FIle");
        fileButton.setToolTipText("JSON FIle");

        fileButton.addActionListener(e -> {
            this.dispose();

            EventQueue.invokeLater(() -> {
                MinimumCommunicationNetworkSpanningSearcher searcher = MinimumCommunicationNetworkSpanningSearcherSingleton.instance(PersistenceType.FILE, MinimumCommunicationNetworkSpanningStrategy.PRIM);
                View window = new ListMinimumCommunicationNetworkSpanningView(searcher);
                window.setVisible(true);
            });
        });
    }

    private void setManualButtonProperties() {
        manualButton.setText("Manual");
        manualButton.setToolTipText("Manual");

        manualButton.addActionListener(e -> {
            this.dispose();

            EventQueue.invokeLater(() -> {
                View window = new CreateSpiesFormView();
                window.setVisible(true);
            });
        });
    }

    private void setTitleLabelProperties() {
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setText("Choose a datasource");
        titleLabel.setToolTipText("Choose a datasource");
    }
}
