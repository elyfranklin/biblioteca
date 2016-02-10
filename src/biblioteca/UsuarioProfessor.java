package biblioteca;

public class UsuarioProfessor extends Usuario {

	public UsuarioProfessor(int codigo, String st) {
		super(codigo, st);
	}
	
	public boolean bloqueia(Livro it, int prazo){
		return it.bloqueia((Usuario)this, prazo);
	}

	public boolean desboqueia(Livro it){
		return it.desbloqueia((Usuario)this);
	}
	
	public int getCargaLimite(){
		return 5;
	}
	
	public int getCotaMaxima(){
		return 5;
	}
	
	public int getPrazoMaximo(){
		return 14;
	}
	
	public boolean isProfessor(){
		return true;
	}
	
	public String toString(){
		return super.getCodigo() + " prof. " + super.getNome();
	}
}
