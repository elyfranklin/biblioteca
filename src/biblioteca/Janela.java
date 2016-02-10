package biblioteca;

import java.awt.Window;

import javax.swing.JFrame;

public class Janela extends JFrame{

	public Janela() {
		// TODO Auto-generated constructor stub/
		super("Biblioteca");
		setLocationRelativeTo(null);//centralizar
		setSize(Window.WIDTH,Window.HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
