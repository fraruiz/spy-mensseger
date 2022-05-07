package ar.edu.ungs.spymensseger.apps.swing;

import ar.edu.ungs.spymensseger.apps.shared.Application;
import ar.edu.ungs.spymensseger.apps.swing.views.View;
import ar.edu.ungs.spymensseger.apps.swing.views.main.MainView;

import java.awt.*;

public final class SwingApplication implements Application {
	@Override
	public void run() {
		EventQueue.invokeLater(() -> {
			try {
				View window = new MainView();
				window.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
