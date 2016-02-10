package biblioteca;

import java.awt.Window;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JFrame;


public class Janela extends JFrame{

	private ArrayList<Usuario> usuarios;
	
	public void carregaUsuarios(){
		usuarios = new ArrayList<Usuario>();
		
		try {
			FileInputStream fis = new FileInputStream("usuarios");
			ObjectInputStream ois = new ObjectInputStream(fis);
			try{
				while(true){
					Usuario temp = (Usuario) ois.readObject();
					System.out.println(temp);
				}
			}catch(EOFException eofe){
				//Nothing to do here
				//System.out.println("Fim do Arquivo Atingido");
			}catch(ClassNotFoundException cnfe){
				//Nothing to do here
				//System.out.println(cnfe.getMessage());
			}finally {
				ois.close();
			}
			
		} catch (FileNotFoundException e) {
			//criar usuário
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	public Janela() {		
		super("Biblioteca");
		
		carregaUsuarios();
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		this.add(new Cadastro());
	}

}
