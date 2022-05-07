package ar.edu.ungs.spymensseger.apps.swing.views.network;

import ar.edu.ungs.spymensseger.apps.swing.views.View;
import ar.edu.ungs.spymensseger.modules.communications.application.CommunicationResponse;
import ar.edu.ungs.spymensseger.modules.networks.application.CommunicationNetworkResponse;
import ar.edu.ungs.spymensseger.modules.networks.application.mst.MinimumCommunicationNetworkSpanningSearcher;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class ListMinimumCommunicationNetworkSpanningView extends View {
    private JTable communicationsTable;
    private JLabel titleLabel;
    private JScrollPane jScrollPane1;

    private final MinimumCommunicationNetworkSpanningSearcher networkSpanningSearcher;
    public ListMinimumCommunicationNetworkSpanningView(MinimumCommunicationNetworkSpanningSearcher networkSpanningSearcher) {
        super();
        this.networkSpanningSearcher = networkSpanningSearcher;

        initComponents();
    }

    private void initComponents() {
        titleLabel = new JLabel();
        jScrollPane1 = new JScrollPane();
        communicationsTable = new JTable();

        setTitleLabelProperties();

        setCommunicationTableProperties();

        buildLayout();

        pack();
    }

    private void setCommunicationTableProperties() {
        DefaultTableModel tableModel = instanceDefaultTableModel();

        List<String> firsSpy = new ArrayList<>();
        List<String> secondSpy = new ArrayList<>();
        List<Double> probability = new ArrayList<>();

        CommunicationNetworkResponse networkResponse = networkSpanningSearcher.search();

        for (CommunicationResponse communication : networkResponse.communications()) {
            firsSpy.add(communication.firstSpy());
            secondSpy.add(communication.secondSpy());
            probability.add(communication.probability());
        }

        tableModel.addColumn("First spy", firsSpy.toArray());
        tableModel.addColumn("Second spy", secondSpy.toArray());
        tableModel.addColumn("Probability", probability.toArray());

        communicationsTable.setModel(tableModel);
        jScrollPane1.setViewportView(communicationsTable);
        if (communicationsTable.getColumnModel().getColumnCount() > 0) {
            communicationsTable.getColumnModel().getColumn(0).setResizable(false);
            communicationsTable.getColumnModel().getColumn(1).setResizable(false);
            communicationsTable.getColumnModel().getColumn(2).setResizable(false);
        }
    }

    private DefaultTableModel instanceDefaultTableModel() {
        return new DefaultTableModel() {
            Class[] types = new Class[]{
                    String.class, String.class, Double.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
    }

    private void buildLayout() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 573, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }

    private void setTitleLabelProperties() {
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setText("Create communication network");
        titleLabel.setToolTipText("Create communication network");
    }
}
