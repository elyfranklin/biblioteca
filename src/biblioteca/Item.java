package biblioteca;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Item {
	protected String titulo;
	protected Usuario retiradoPor;
	protected Date dtEmprestimo;
	protected Date dtDevolucao;
	
	public boolean isDisponivel(){
		return (this.retiradoPor == null);
	}
	
	public boolean isEmprestado(){
		return !(this.retiradoPor == null);
	}
	
	public boolean isEmAtraso(){
		Date hoje =  new Date();
		return !this.dtDevolucao.before(hoje);
	}
	
	public boolean retorna(Usuario u){
		if(this.retiradoPor == u){
			this.retiradoPor = null;
			return true;
		}
		return false;
	}
	public boolean devolve(Usuario u){
		if(this.retiradoPor == u){
			this.retiradoPor = null;
			return true;
		}
		return false;
	}

	public boolean empresta(Usuario u, int prazo){
		GregorianCalendar cal = new GregorianCalendar();
		
		if(this.isDisponivel()){
			this.retiradoPor = u;
			this.dtEmprestimo = cal.getTime();
			cal.add(Calendar.DATE, prazo);
			this.dtDevolucao = cal.getTime();
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
		return titulo + st;
	}
	
	protected String dma(Date dt){
		GregorianCalendar cal  = new GregorianCalendar();
		cal.setTime(dt);
		return cal.get(Calendar.DATE) + "/" +
				(cal.get(Calendar.MONTH) + 1) + "/" +
				cal.get(Calendar.YEAR);
	}
	public String getTitulo(){
		return this.titulo;
	}
}
