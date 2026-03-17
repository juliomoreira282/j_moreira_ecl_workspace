package estdados;
import java.util.ArrayList;
import java.util.Scanner;

public class Lanchonete {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<String> pedidos = new ArrayList<String>();
		ArrayList<String> pedidosProntos = new ArrayList<String>();
		boolean pedidosInLine = false;
		
		System.out.println("\nMenu de Comandos:");
		System.out.println("Digite 'V' para verificar os pedidos na fila de preparo e espera.");
		System.out.println("Digite 'P' para preparar um lanche.");
		System.out.println("Digite 'E' para entregar um lanche.");
		System.out.println("Digite 'S' para sair.");
		
		while(true) {
			if(!pedidosInLine) {
				System.out.println("O que deseja fazer? [I] Inserir | [S] Sair: ");
				String acao = scanner.nextLine();
				
				if(acao.equalsIgnoreCase("s")) {
					System.out.println("Encerrando...");
					break;
				}
				
				else if(acao.equalsIgnoreCase("i")) {
					System.out.println("Quantos itens deseja adicionar?");
					int qtd;
					
					try {
						qtd = Integer.parseInt(scanner.nextLine());
					}
					
					catch(NumberFormatException nfe) {
						System.out.println("Entrada inválida. Digite um número inteiro.");
						continue;
					}
					
					if(qtd > 10) {
						System.out.println("Desculpe. Não aceitamos pedidos com mais de 10 itens.");
						continue;
					}
					
					for(int i = 0; i < qtd; i++) {
						System.out.println("O que deseja adicionar?");
						String pedido = scanner.nextLine();
						
						if(!pedido.trim().isEmpty()) {
							String item = pedido.substring(0, 1).toUpperCase() + pedido.substring(1).toLowerCase();
							pedidos.add(item);
							System.out.println(item + " foi adicionado à lista.");
						}
					}
					
					if(!pedidos.isEmpty()) {
						pedidosInLine = true;
					}
				}
			}
			
			else if(pedidosInLine && (!pedidos.isEmpty() || !pedidosProntos.isEmpty())) {
				System.out.println("Escolha um comando para realizar uma ação: [V] [P] [E] [S]: ");
				String comando = scanner.nextLine();
				
				if(comando.equalsIgnoreCase("s")) {
					System.out.println("Encerrando...");
					break;
				}
				
				else if(comando.equalsIgnoreCase("v")) {
					System.out.println("Qtde. de lanches esperando para serem preparados: " + pedidos.size() + " | Lanches em espera: " + pedidos);
					System.out.println("Qtde. de lanches esperando serem entregues: " + pedidosProntos.size() + " | Lanches em espera: " + pedidosProntos);
				}
				
				else if(comando.equalsIgnoreCase("p")) {
					if(pedidos.isEmpty()) {
						System.out.println("A lista está vazia.");
					}
					
					else {
						String lancheAPreparar = pedidos.remove(pedidos.size() - 1);
						pedidosProntos.add(lancheAPreparar);
						System.out.println(lancheAPreparar + " está pronto.");
					}
				}
				
				else if(comando.equalsIgnoreCase("e")) {
					if(pedidosProntos.isEmpty()) {
						System.out.println("A lista está vazia.");
					}
					
					else {
						String lancheEntregue = pedidosProntos.remove(0);
						System.out.println(lancheEntregue + " foi entregue.");
						
						if(pedidos.isEmpty() && pedidosProntos.isEmpty()) {
							System.out.println("Todos os itens foram entregues. Encerrando...");
							break;
						}
					}
				}
				
				else {
					System.out.println("O comando não existe. Use um dos comandos mencionados anteriormente.");
				}
			}
			else {
				pedidosInLine = false;
			}
		}
		scanner.close();
	}
}