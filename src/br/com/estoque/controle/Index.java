package br.com.estoque.controle;

import javax.swing.JOptionPane;

public class Index {

	public static void main(String[] args) {
		// Aqui será abordado todo o corpo do programa
		
		TelasMenu tela = new TelasMenu();

		// entrada menu principal
		int opMenu;
		do {
			// aqui sera chamado o metodo menuPrincipal

			opMenu = tela.telaPrincipal();
			// este switch é responsavel pela tela 1.0

			switch (opMenu) {
			case 0:
				opMenu = 0;
				System.out.println("Programa sendo encerrado...");
				break;
			case 1:
				int opMenuCadastro = tela.telaCadastro();
				switch (opMenuCadastro) {
				case 0:
					JOptionPane.showMessageDialog(null, "Retornando ao Menu Principal");
					break;
				case 1:
					// Este Case é o responsavel pelo cadastro de um novo produto
					String continuarInclusao = "s";
					while (continuarInclusao.equalsIgnoreCase("s")) {

						Produto produto = new Produto();
						ControleEstoque dadosProduto = new ControleEstoque();

						produto.setNomeProduto(JOptionPane.showInputDialog("NOME:").toUpperCase());
						produto.setMarcaProduto(JOptionPane.showInputDialog("MARCA:").toUpperCase());
						produto.setUnidadeMedida(JOptionPane.showInputDialog("UNIDADE MEDIDA:").toUpperCase());
						String quant = JOptionPane.showInputDialog("QUANTIDADE:");
						int quantidade = Integer.parseInt(quant);
						produto.setQuantidade(quantidade);
						produto.setQuantidadeTotalEstoque(produto.getQuantidade());
						String preco = JOptionPane.showInputDialog("PREÇO UNITÁRIO:");
						double valor = Double.parseDouble(preco);
						produto.setPrecoUnitario(valor);
						dadosProduto.adicionarProdutos(produto);
						

						continuarInclusao = JOptionPane.showInputDialog("Deseja continuar cadastrando?\n[S/n]");
					}

					break;
				case 2:
					// este case é responsavel por alterar produtos da lista
					
					Produto produtoAlterar = new Produto();
					produtoAlterar.setNomeProduto(JOptionPane.showInputDialog("PAGINA DE BUSCA DE PRODUTO\n\n"
							+ "NOME DO PRODUTO").toUpperCase()); //notebook
					produtoAlterar.setMarcaProduto(JOptionPane.showInputDialog("PAGINA DE BUSCA DE PRODUTO\n\n"
							+ "MARCA:").toUpperCase()); //lenovo
					ControleEstoque alterarProdutoLista = new ControleEstoque();
					/**localizarParaAlterar não é um objeto, ele é uma variavel do tipo produto */
					Produto localizarParaAlterar = alterarProdutoLista.buscarProduto(produtoAlterar.getNomeProduto(),
							produtoAlterar.getMarcaProduto());
					alterarProdutoLista.alterarProduto(localizarParaAlterar);
					
					break;
				case 3:
					// este case é responsavel por consultar um produto na lista
					Produto localizar = new Produto();
					localizar.setNomeProduto(JOptionPane.showInputDialog("PAGINA DE BUSCA DE PRODUTO\n\n"
							+ "NOME DO PRODUTO").toUpperCase());
					localizar.setMarcaProduto(JOptionPane.showInputDialog("PAGINA DE BUSCA DE PRODUTO\n\n"
							+ "MARCA:").toUpperCase());
					ControleEstoque buscandoProdutoLista = new ControleEstoque();
					Produto buscarDadoseImprimir = buscandoProdutoLista.buscarProduto(localizar.getNomeProduto(),
							localizar.getMarcaProduto());
					buscandoProdutoLista.buscareImprimir(buscarDadoseImprimir);
					break;
				case 4:
					//este Case é o responsavel por excluir um produto do estoque
					String continuarRemover = "s";
					while(continuarRemover.equalsIgnoreCase("s")) {
						
						ControleEstoque remocaoProduto = new ControleEstoque();
						Produto produto = new Produto();
						produto.setNomeProduto(JOptionPane.showInputDialog("PAGINA DE REMOÇÃO DE PRODUTO\n"
								+ "NOME DO PRODUTO").toUpperCase());
						produto.setMarcaProduto(JOptionPane.showInputDialog("PAGINA DE REMOÇÃO DE PRODUTO\n"
								+ "MARCA:").toUpperCase());
						Produto buscarDadoseRemover = remocaoProduto.buscarProduto(produto.getNomeProduto(),
								produto.getMarcaProduto());
						int confirmarExclusao = JOptionPane.showConfirmDialog(null, "DESEJA REMOVER?");
						if(confirmarExclusao == 0) {
							remocaoProduto.removerProduto(buscarDadoseRemover);						
						}
						
						continuarRemover = JOptionPane.showInputDialog("DESEJA CONTINUAR?");
					}
					
					
					break;
				default:
					JOptionPane.showMessageDialog(null, "Valor invalido!\nTente novamente");
				}
				break;

			
			case 2:
				//este case é responsavel pela entrada e saida de produtos
				int opMenuMovimentacao = tela.telaMovimentacao();
				switch (opMenuMovimentacao) {
				case 0:
					JOptionPane.showMessageDialog(null, "Retornando ao menu principal");
					break;
				case 1:
					
					String continuar = "s";
					while(continuar.equalsIgnoreCase("s")) {
						Produto entradaProduto = new Produto();
						ControleEstoque aumentarQuantidade = new ControleEstoque();
						int entrada = JOptionPane.showConfirmDialog(null, "VOCÊ ESTÁ NA PAGINA DE ENTRADA DE PRODUTOS.\n"
								+ "DESEJA CONTINUAR?");
						if(entrada == 0) {// zero é igual a
							
							entradaProduto.setNomeProduto(JOptionPane.showInputDialog("INFORME NOME: ").toUpperCase());
							entradaProduto.setMarcaProduto(JOptionPane.showInputDialog("INFORME MARCA:").toUpperCase());
							Produto buscar = aumentarQuantidade.buscarProduto(entradaProduto.getNomeProduto(), entradaProduto.getMarcaProduto());
							aumentarQuantidade.entradaProduto(buscar);
						}else {
							continuar = "n";
						}
						
						if(continuar != "n") {
							
							continuar = JOptionPane.showInputDialog("DESEJA CONTINUAR?");
						}
						
					}
					
					
					break;
				case 2:
					
					continuar = "s";
					while(continuar.equalsIgnoreCase("s")) {
						Produto saidaProduto = new Produto();
						ControleEstoque aumentarQuantidade = new ControleEstoque();
						int entrada = JOptionPane.showConfirmDialog(null, "VOCÊ ESTÁ NA PAGINA DE SAIDA DE PRODUTOS.\n"
								+ "DESEJA CONTINUAR?");
						if(entrada == 0) {
							
							saidaProduto.setNomeProduto(JOptionPane.showInputDialog("INFORME NOME: ").toUpperCase());
							saidaProduto.setMarcaProduto(JOptionPane.showInputDialog("INFORME MARCA:").toUpperCase());
							Produto buscar = aumentarQuantidade.buscarProduto(saidaProduto.getNomeProduto(), saidaProduto.getMarcaProduto());
							aumentarQuantidade.saidaProduto(buscar);
						}else {
							continuar = "n";
						}
						
						if(continuar != "n") {
							
							continuar = JOptionPane.showInputDialog("DESEJA CONTINUAR?");
						}
						
					}
					break;
				default:
					JOptionPane.showMessageDialog(null, "Valor invalido!\nTente novamente");

				}

				break;
			case 3:
				 String continuar = "s";
				while(continuar.equalsIgnoreCase("s")) {
					Produto ajustarProduto = new Produto();
					ControleEstoque aumentarQuantidade = new ControleEstoque();
					int entrada = JOptionPane.showConfirmDialog(null, "VOCÊ ESTÁ NA PAGINA DE REAJUSTE DE PREÇO.\n"
							+ "DESEJA CONTINUAR?");
					if(entrada == 0) {
						
						ajustarProduto.setNomeProduto(JOptionPane.showInputDialog("INFORME NOME: ").toUpperCase());
						ajustarProduto.setMarcaProduto(JOptionPane.showInputDialog("INFORME MARCA:").toUpperCase());
						Produto buscar = aumentarQuantidade.buscarProduto(ajustarProduto.getNomeProduto(), ajustarProduto.getMarcaProduto());
						aumentarQuantidade.reajustePreco(buscar);
					}else {
						continuar = "n";
					}
					
					if(continuar != "n") {
						
						continuar = JOptionPane.showInputDialog("DESEJA CONTINUAR?");
					}
					
				}
				

				break;
			case 4:
				
				// aqui será implementado as chamadas de relatorio de produto
				ControleEstoque totalProdutos = new ControleEstoque();
				totalProdutos.listaTotalProdutos();
				break;

			default:
				JOptionPane.showMessageDialog(null, "Valor invalido!\nTente novamente");
			}

		} while (opMenu != 0);

	}

}
