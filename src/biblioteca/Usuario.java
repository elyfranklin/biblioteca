package biblioteca;

import java.util.ArrayList;
import java.util.Iterator;

public class Usuario {
	private int codigo;
	private String	nome;
	private ArrayList<Livro> livrosRetirados;
	private String login;
	private String senha;
	
	/**
	 * Criar um Usuario
	 * @param st nome do Usuario
	 */
	public Usuario(int codigo, String st, String user, String pass){
		this.nome = st;
		this.codigo = codigo;
		this.livrosRetirados =  new ArrayList<Livro>();
		this.login = user;
		this.senha = pass;
	}
		
	
	/**
	 * Retirar um Livro
	 * @param it livro a ser retirado
	 * @return 
	 */
	public boolean retiraLivro(Livro it){
		return true;
	}
	public boolean devolveLivro(Livro it){
		return true;
	}
	
	public int getCotaMaxima(){
		return 2;
	}
	
	public int getPrazoMaximo(){
		return 4;
	}
	
	public int getCodigo(){
		return this.codigo;
	}
	
	public boolean isADevolver(){
		return (this.livrosRetirados.size() >= this.getCotaMaxima() );
	}
	
	public boolean isAptoARetirar(){
		return (!this.isADevolver());
	}
	
	public boolean temPrazoVencido(){
		Livro livro;
		Iterator<Livro> it = livrosRetirados.iterator();
		
		while(it.hasNext()){
			livro = it.next();
			if(livro.isEmAtraso()){
				return true;
			}
		}
		return false;
	}
	
	public boolean retira(Livro it){
		if(this.isAptoARetirar()){
			if(it.empresta(this, getPrazoMaximo())){
				this.livrosRetirados.add(it);
				return true;
			}
			else{
				return false;
			}
		}
		return false;
	}
	public boolean devolve(Livro it){
		if(it.retorna(this)){
			this.livrosRetirados.remove(it);
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isProfessor(){
		return false;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String toString(){
		return "Usuario " + nome;
	}
	
	public void listaCarga(){
		System.out.println(this.toString() + " Limite: " + this.getCotaMaxima() + " Carga atual: " + this.livrosRetirados.size());
		
		Iterator<Livro> it = this.livrosRetirados.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
}
