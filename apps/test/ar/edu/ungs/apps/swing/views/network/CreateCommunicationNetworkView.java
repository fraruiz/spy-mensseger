package ar.edu.ungs.apps.swing.views.network;

import ar.edu.ungs.apps.swing.shared.Triplet;
import ar.edu.ungs.apps.swing.views.View;
import ar.edu.ungs.communications.application.CommunicationRequest;
import ar.edu.ungs.networks.application.CommunicationNetworkRequest;
import ar.edu.ungs.networks.application.save.CommunicationNetworkSaver;
import ar.edu.ungs.persistence.PersistenceType;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreateCommunicationNetworkView extends View {
    private JTable communicationsTable;
    private JLabel titleLabel;
    private JScrollPane jScrollPane1;
    private JButton searchMinimumCommunicationNetworkSpanningButton;
    private final CommunicationNetworkSaver communicationNetworkSaver;
    private final Set<Triplet<String, String, Double>> communications;

    public CreateCommunicationNetworkView(Set<String> spyNames, CommunicationNetworkSaver communicationNetworkSaver) {
        super();
        this.communicationNetworkSaver = communicationNetworkSaver;

        communications = new HashSet<>();

        for (String first: spyNames) {
            for (String second: spyNames) {
                Triplet<String, String, Double> possibleTriplet = new Triplet<>(first, second, null);
                Triplet<String, String, Double> otherPossibleTriplet = new Triplet<>(second, first, null);
                if (!first.equals(second) && !communications.contains(possibleTriplet) && !communications.contains(otherPossibleTriplet)) {
                    communications.add(possibleTriplet);
                }
            }
        }

        initComponents();
    }
    
    private void initComponents() {
        titleLabel = new JLabel();
        jScrollPane1 = new JScrollPane();
        communicationsTable = new JTable();
        searchMinimumCommunicationNetworkSpanningButton = new JButton();

        setTitleLabelProperties();

        setCommunicationTableProperties();

        setSearchMinimumCommunicationNetworkSpanningButtonProperties();

        buildLayout();

        pack();
    }

    private void setSearchMinimumCommunicationNetworkSpanningButtonProperties() {
        searchMinimumCommunicationNetworkSpanningButton.setText("Search minimum communication network panning");
        searchMinimumCommunicationNetworkSpanningButton.addActionListener(e -> {
            try {
                if (communicationsTable.getCellEditor() == null) {
                    return;
                }

                communicationsTable.getCellEditor().stopCellEditing();

                communicationsTable.setEnabled(false);
                communicationsTable.setCellSelectionEnabled(false);
                communicationsTable.setColumnSelectionAllowed(false);

                searchMinimumCommunicationNetworkSpanningButton.requestFocus();
                Set<CommunicationRequest> network = new HashSet<>();

                Integer rowCount = communicationsTable.getModel().getRowCount();

                for (int row = 0; row < rowCount; row++) {
                    String firstSpy = (String) communicationsTable.getModel().getValueAt(row, 0);
                    String secondSpy = (String) communicationsTable.getModel().getValueAt(row, 1);
                    Double probability = (Double) communicationsTable.getModel().getValueAt(row, 2);

                    if (probability != null) {
                        if (probability < 0 || probability > 1) {
                            showMessageDialog(searchMinimumCommunicationNetworkSpanningButton, String.format("the probability of <%s> and <%s> spies should be between 0 and 1", firstSpy, secondSpy));
                            communicationsTable.setEnabled(true);
                            communicationsTable.setCellSelectionEnabled(true);
                            communicationsTable.setColumnSelectionAllowed(true);
                            return;
                        }

                        CommunicationRequest communicationRequest = new CommunicationRequest(firstSpy, secondSpy, probability);
                        network.add(communicationRequest);
                    }
                }

                CommunicationNetworkRequest request = new CommunicationNetworkRequest(network);
                communicationNetworkSaver.save(request);

                openListCommunicationNetworkView();
            } catch (Exception exception) {
                showMessageDialog(searchMinimumCommunicationNetworkSpanningButton, exception.getMessage());
            }
        });
    }

    private void openListCommunicationNetworkView() {
        this.dispose();

        EventQueue.invokeLater(() -> {
            View window = new ListMinimumCommunicationNetworkSpanningView(PersistenceType.IN_MEMORY);
            window.setVisible(true);
        });
    }

    private void setCommunicationTableProperties() {
        DefaultTableModel tableModel = instanceDefaultTableModel();

        List<String> firsSpy = new ArrayList<>();
        List<String> secondSpy = new ArrayList<>();
        List<Double> probability = new ArrayList<>();

        for (Triplet<String, String, Double> communication : communications) {
            firsSpy.add(communication.first());
            secondSpy.add(communication.second());
            probability.add(communication.third());
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
                    false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
    }

    private void setTitleLabelProperties() {
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setText("Create communication network");
        titleLabel.setToolTipText("Create communication network");
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
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchMinimumCommunicationNetworkSpanningButton)
                .addGap(140, 140, 140))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchMinimumCommunicationNetworkSpanningButton)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }

}
