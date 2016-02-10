package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Pede a inserção de valores a partir de uma lista de opções, lê strings, inteiros e double.
 * @author Ely Franklin
 * @version 0.1
 */
public class InterfaceMenu {
	
	/**
	 * Monta e exibe um menu para o usuário e aguarda um valor válido ser inserido.
	 * @param opcoes Lista com opções a exibir
	 * @return opção escolhida pelo usuário
	 */
	public static int getOpcao(ArrayList<String> opcoes) {
		int opcao;
		int counter = 0;
		String chamada = "Escolha uma opcao: ";

		for (String campo : opcoes) {
			counter++;
			chamada = chamada + "\n" + counter + " - " + campo;
		}
		do {
			System.out.println("");
			opcao = InterfaceMenu.getInt(chamada);
			if (opcao <= 0 || opcao > counter) {
				opcao = 0;
			}
		} while (opcao == 0);
		return opcao;
	}
	
	/**
	 * Lê e retorna uma string
	 * @param str Mensagem a ser exibida ao usuário
	 * @return String lida
	 */
	@SuppressWarnings("resource")
	public static String getString(String str, boolean tipo){
		Scanner r = new Scanner(System.in).useDelimiter("\r\n");
		if(tipo){
			System.out.println("Informe "+ str);			
		}else{
			System.out.println(str);
		}
		if(r.hasNext()){
			return r.next();
		}
		@SuppressWarnings("unused")
		String st = r.next();
		System.out.println("Erro na leitura de dados!");
		return null;
	}
	
	/**
	 * Lê e retorna um double
	 * @param str Mensagem a ser exibida ao usuário
	 * @return double lido
	 */
	@SuppressWarnings("resource")
	public static double getDouble(String str){
		Scanner r = new Scanner(System.in).useDelimiter("\r\n");
		System.out.println("Informe "+ str);
		if(r.hasNextDouble()){
			return r.nextDouble();
		}
		@SuppressWarnings("unused")
		String st = r.next();
		System.out.println("Erro na leitura de dados!");
		return 0;
	}
	
	/**
	 * Lê e retorna um inteiro
	 * @param str Mensagem a ser exibida ao usuário
	 * @return inteiro lido
	 */
	@SuppressWarnings("resource")
	public static int getInt(String str){
		Scanner r = new Scanner(System.in);
		System.out.println("Informe "+ str);
		if(r.hasNextInt()){
			return r.nextInt();
		}
		@SuppressWarnings("unused")
		String st = r.next();
		System.out.println("Erro na leitura de dados!");
		return 0;
	}
}
