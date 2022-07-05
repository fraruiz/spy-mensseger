package ar.edu.ungs.apps.swing.views;

import javax.swing.*;
import java.awt.*;

public abstract class View extends JFrame {
	public View() {
		setLookAndFeel();
		setDefaultFrame();
		centerFrame();
	}

	protected void showMessageDialog(Component component, String message) {
		JOptionPane.showMessageDialog(component, new JLabel(message));
	}

	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
		         UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setDefaultFrame() {
		this.setBackground(Color.WHITE);
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
	}

	private void centerFrame() {
		/* frame center */
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}


	public void dispose() {
		super.dispose();
		this.setVisible(false);
	}
}
