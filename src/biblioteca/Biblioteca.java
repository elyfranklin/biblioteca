package biblioteca;

import java.util.ArrayList;
import java.util.Iterator;


public class Biblioteca {
	
	ArrayList<Usuario> usuarios;
	ArrayList<Item> items;
	
	public Biblioteca(){
		usuarios = new ArrayList<Usuario>();
		items = new ArrayList<Item>();
	}
	public void escolhaModo(){
		
	}
	
	private void listaUsuarios(){
		Iterator<Usuario> it  =  this.usuarios.iterator();
		
		while(it.hasNext()){
			Usuario u = it.next();
			System.out.println(u.toString());
		}
	}
	
	
	public boolean acaoAdmin(String comando){
		String cmdAuxiliar;
		
		comando.toLowerCase();
		
		if(comando.contains("usuario")){
			if(comando.contains("adicionar") || comando.contains("cadastrar")){
				Usuario user;
				cmdAuxiliar = InterfaceMenu.getString("Tipo de Usuário (Aluno/Professor)", false);
				int codigo = InterfaceMenu.getInt("Codigo do Usuario");
				String nome = InterfaceMenu.getString("Nome do Usuario", true);
				
				if(cmdAuxiliar.contains("aluno")){
					user = new UsuarioAluno(codigo, nome, nome,nome);
				}else if(cmdAuxiliar.contains("professor")){
					user = new UsuarioProfessor(codigo, nome,nome,nome);	
				}else{
					user = new Usuario(codigo, nome,nome,nome);
				}
								
				this.usuarios.add(user);
								
				return true;
				
			}else if(comando.contains("remover") || comando.contains("apagar")){
				int codigo = InterfaceMenu.getInt("Codigo do Usuário");
				Usuario user = this.usuarios.get(codigo);
				if(user != null){
					if(this.usuarios.remove(user)){
						System.out.println("Usuario removido");
					}else{
						return true;
					}
				}
				return true;
			}else if(comando.contains("listar")){
				this.listaUsuarios();
				return true;
			}
		}else if(comando.contains("livro")){
			if(comando.contains("adicionar") || comando.contains("cadastrar")){
				
			}else if(comando.contains("remover") || comando.contains("apagar")){
			
			}else if(comando.contains("listar")){
				return true;
			}
		}else if(comando.contains("periodico")){
			
		}else if(comando.contains("DVD")){
			
		}else if(comando.contains("voltar") || comando.contains("retornar")){
			return false;
		}
		return false;
	}
	
	

}
