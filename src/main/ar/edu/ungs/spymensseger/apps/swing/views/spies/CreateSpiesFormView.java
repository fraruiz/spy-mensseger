package ar.edu.ungs.spymensseger.apps.swing.views.spies;

import ar.edu.ungs.spymensseger.apps.swing.views.View;
import ar.edu.ungs.spymensseger.apps.swing.views.network.CreateCommunicationNetworkView;
import ar.edu.ungs.spymensseger.modules.networks.application.save.CommunicationNetworkSaver;
import ar.edu.ungs.spymensseger.modules.networks.infrastructure.singleton.CommunicationNetworkSaverSingleton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class CreateSpiesFormView extends View {
    private JButton addSpyNameButton;
    private JButton finishButton;
    private JLabel enterSpyNameLabel;
    private JScrollPane jScrollPane1;
    private JTextField spyNameTextField;
    private JLabel titleLabel;

    private JTable spiesTable;

    private Set<String> spyNames;

    public CreateSpiesFormView() {
        super();

        this.spyNames = new HashSet<>();

        initComponents();
    }

    private void initComponents() {
        titleLabel = new JLabel();
        jScrollPane1 = new JScrollPane();
        spiesTable = new JTable();
        spyNameTextField = new JTextField();
        addSpyNameButton = new JButton();
        finishButton = new JButton();
        enterSpyNameLabel = new JLabel();

        setTitleLabelProperties();

        setSpiesTableProperties();

        setSpyNameTextFieldProperties();

        setAddSpyNameButtonProperties();

        setFinishButtonProperties();

        setEnterSpyNameLabelProperties();

        buildLayout();

        pack();
    }

    private void setFinishButtonProperties() {
        finishButton.setText("Finish");

        finishButton.addActionListener(e -> {
            if (this.spyNames.isEmpty()) {
                showMessageDialog(finishButton, "Please, enter an any spy name");
                return;
            }

            if (this.spyNames.size() <= 2) {
                showMessageDialog(finishButton, "Please, enter two or more spies");
                return;
            }

            this.dispose();

            EventQueue.invokeLater(() -> {
                CommunicationNetworkSaver saver = CommunicationNetworkSaverSingleton.instance();
                View window = new CreateCommunicationNetworkView(this.spyNames, saver);
                window.setVisible(true);
            });
        });
    }

    private void setEnterSpyNameLabelProperties() {
        enterSpyNameLabel.setText("Enter spy name");
    }

    private void buildLayout() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(spyNameTextField, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addSpyNameButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(finishButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(enterSpyNameLabel)))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(enterSpyNameLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spyNameTextField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(finishButton)
                            .addComponent(addSpyNameButton))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }

    private void setAddSpyNameButtonProperties() {
        addSpyNameButton.setText("Add");
        addSpyNameButton.setToolTipText("Add");

        addSpyNameButton.addActionListener(e -> {
            if (this.spyNameTextField.getText().isBlank()) {
                showMessageDialog(addSpyNameButton, "Enter a spy name");
                return;
            }

            this.spyNames.add(this.spyNameTextField.getText());
            this.spyNameTextField.setText("");
            this.spyNameTextField.requestFocus();
            setSpiesTableProperties();
        });
    }

    private void setSpyNameTextFieldProperties() {
        spyNameTextField.setHorizontalAlignment(JTextField.CENTER);
        spyNameTextField.setToolTipText("Spy name");
    }

    private void setSpiesTableProperties() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Name", this.spyNames.toArray());
        spiesTable.setModel(tableModel);

        jScrollPane1.setViewportView(spiesTable);
        if (spiesTable.getColumnModel().getColumnCount() > 0) {
            spiesTable.getColumnModel().getColumn(0).setResizable(false);
        }
    }

    private void setTitleLabelProperties() {
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setText("Create spies");
    }
}
