package estdados;
// Bibliotecas importadas para o funcionamento do código
import java.util.ArrayList;
import java.util.Scanner;

public class InfluencerChallenge {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Scanner para a leitura de informações dadas pelo usuário
		
		// Listas das seguintes coisas que serão usadas no código
		ArrayList <String> uploads = new ArrayList<String>();
		ArrayList <String> historico = new ArrayList<String>();
		ArrayList <String> seguidores = new ArrayList<String>();
		seguidores.add("@java_master");
		seguidores.add("@assembly_wizkid");
		seguidores.add("@front_end_ninja");
		
		// Menu de Comandos
		System.out.println("\nMenu de Comandos");
		System.out.println("Digite 'U' para adicionar algo à fila  de uploads.");
		System.out.println("Digite 'H' para adicionar algo à pilha do histórico.");
		System.out.println("Digite 'P' para postar algo que esteja na fila de uploads.");
		System.out.println("Digite 'Z' para desfazer algo da pilha do histórico.");
		System.out.println("Digite 'A' para adicionar um usuário da forma normal.");
		System.out.println("Digite 'V' para adicionar um usuário VIP à lista.");
		System.out.println("Digite 'B' para banir um usuário.");
		System.out.println("Digite 'C' para verificar o estado de cada uma das listas.");
		System.out.println("Digite 'S' para sair.");
		
		while (true) {
			try {
				System.out.println("Digite um comando:");
				String comando = scanner.nextLine();
				
				if (comando.equalsIgnoreCase("s")) {
					System.out.println("Encerrando...");
					break;
				}
				
				else if (comando.equalsIgnoreCase("u")) {
					System.out.println("Qual arquivo deseja adicionar?");
					String arquivo = scanner.nextLine();
					
					if (!arquivo.trim().isEmpty()) {
						String midia = arquivo.substring(0, 1).toUpperCase() + arquivo.substring(1).toLowerCase();
						uploads.add(midia);
						System.out.println(midia + " foi adicionado à lista.");
						System.out.println("Qtde. de itens na fila de uploads: " + uploads.size() + " | Fila de uploads: " + uploads);
 					}
				}
				
				else if (comando.equalsIgnoreCase("p")) {
					String arquivoPostado = uploads.remove(0);
					System.out.println(arquivoPostado + " foi postado.");
					System.out.println("Qtde. de arquivos restantes: " + uploads.size() + " | Fila de uploads: " + uploads);
				}
				
				else if (comando.equalsIgnoreCase("h")) {
					System.out.println("O que deseja adicionar ao histórico?");
					String addHistorico = scanner.nextLine();
					
					if (!addHistorico.trim().isEmpty()) {
						String itemHistorico = addHistorico.substring(0, 1).toUpperCase() + addHistorico.substring(1).toLowerCase();
						historico.add(itemHistorico);
						System.out.println(itemHistorico + " foi adicionado ao histórico.");
						System.out.println("Qtde. de itens no histórico: " + historico.size() + " | Itens no histórico: " + historico);
					}
				}
				
				else if (comando.equalsIgnoreCase("z")) {
					String historicoUndo = historico.remove(historico.size() - 1);
					System.out.println("Usuário apertou remover... Item removido: " + historicoUndo);
					System.out.println("Qtde. de itens restantes: " + historico.size() + " | Itens no histórico: " + historico);
				}
				
				else if (comando.equalsIgnoreCase("a")) {
					System.out.println("Qual o nome de usuário a ser adicionado à lista de seguidores? Use o '@' antes do nome de usuário.");
					String addSeguidor = scanner.nextLine();
					seguidores.add(addSeguidor);
					System.out.println(addSeguidor + " foi adicionado à lista.");
					System.out.println("Qtde. de seguidores: " + seguidores.size() + " | Seguidores: " + seguidores);
				}
				
				
				else if (comando.equalsIgnoreCase("v")) {
					System.out.println("Qual seu nome de usuário, senhor usuário VIP? Não se esqueça de usar o '@' antes do nome de usuário.");
					String addSeguidorVIP = scanner.nextLine();
					seguidores.add(0, addSeguidorVIP);
					System.out.println("Seja bem-vindo! " + addSeguidorVIP);
					System.out.println("Qtde. de seguidores: " + seguidores.size() + " | Seguidores: " + seguidores);
				}
				
				else if (comando.equalsIgnoreCase("b")) {
					System.out.println("Qual usuário deseja banir?");
					String banirUsuario = scanner.nextLine();
					
					if (seguidores.contains(banirUsuario)) {
						seguidores.remove(banirUsuario);
						System.out.println(banirUsuario + " foi banido, até nunca!");
						System.out.println("Qtde. de seguidores: " + seguidores.size() + " | Seguidores: " + seguidores);
					}
					
					else {
						System.out.println("O usuário não existe.");
					}
				}
				
				else if (comando.equalsIgnoreCase("c")) {
					System.out.println("Qtde. de itens na fila de uploads: " + uploads.size() + " | Fila de uploads: " + uploads);
					System.out.println("Qtde. de itens no histórico: " + historico.size() + " | Itens no histórico: " + historico);
					System.out.println("Qtde. de seguidores: " + seguidores.size() + " | Seguidores: " + seguidores);
				}
				
				else {
					System.out.println("O comando não existe. Tente novamente.");
				}
			}
			
			catch (IndexOutOfBoundsException ioobe) {
				System.out.println("A lista está vazia. Tente novamente.");
			}
		}
		scanner.close();
	}
}
