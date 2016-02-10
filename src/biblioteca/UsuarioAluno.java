package biblioteca;

import java.util.Date;

public class UsuarioAluno extends Usuario {

	private Date dataLimite;
	
	
	public UsuarioAluno(int codigo, String st, String user, String pass) {
		super(codigo, st, user, pass);
		// TODO Auto-generated constructor stub
	}

	public void renovaCartao(Date dt){
		this.dataLimite = dt;
	}
	
	public boolean isRegular(){
		Date hoje = new Date();
		return dataLimite.after(hoje);
	}
	
	public boolean isARenovar(){
		return !isRegular();
	}
	
	public int getCotaMaxima(){
		return (isRegular() ? 3 : super.getCotaMaxima());
	}
	
	public int getPrazoMaximo(){
		return (isRegular() ? 7 : super.getPrazoMaximo());
	}
	
	public String toString(){
		return (super.getCodigo()+ " aluno " +getNome());
	}
	
	

	
	
}
