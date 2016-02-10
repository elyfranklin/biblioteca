package biblioteca;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Livro extends Item {
	
	private Usuario bloqueadoPor;
	private Date dtBloqueio;
	private Date dtDesbloqueio;
	
	public Livro(String tit){
		super.titulo = tit;
		this.bloqueadoPor = null;
	}
	
	public boolean isDisponivel(){
		Date hoje = new Date();
		return this.retiradoPor == null && (this.bloqueadoPor == null || this.dtDesbloqueio.before(hoje));
	}
	
	public boolean isBloqueado(){
		Date hoje = new Date();
		return this.retiradoPor == null && 
				!(this.bloqueadoPor == null) &&
				!(this.dtDesbloqueio.before(hoje));
	}
	
	public boolean bloqueia(Usuario u, int prazo){
		GregorianCalendar cal = new GregorianCalendar();
		if(this.isDisponivel() && u.isProfessor()){
			this.bloqueadoPor = u;
			this.dtBloqueio = cal.getTime();
			cal.add(Calendar.DATE, (prazo > 20 ? 20 : prazo));
			this.dtDesbloqueio = cal.getTime();
			return true;
		}
		return false;
	}
	
	public boolean desbloqueia(Usuario u){
		if(u == this.bloqueadoPor){
			this.bloqueadoPor = null;
			return true;
		}
		return false;
	}
	
	
	
	public String toString(){
		String st = new String();
		if(isDisponivel()){
			return this.titulo + " disponível";
		}
		if(isEmprestado()){
			st = " retirado por " +retiradoPor + " em " + dma(this.dtEmprestimo) + 
					" ate " + dma(dtDevolucao);
		}
		else{
			st = " bloqueado por " + bloqueadoPor + " em " + dma(this.dtBloqueio) + 
					" ate " + dma(dtDesbloqueio);
		}
		return titulo + st;
	}
	
}
