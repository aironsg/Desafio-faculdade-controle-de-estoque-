package br.com.estoque.controle;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ControleEstoque implements RegrasDeNegocios {

	public static List<Produto> produtos = new ArrayList<Produto>();

	@SuppressWarnings("static-access")
	@Override
	public void adicionarProdutos(Produto produto) {

		if (!produtos.contains(produto) == true) {
			this.produtos.add(produto);
			JOptionPane.showMessageDialog(null, "PRODUTO CADASTRO COM SUCESSO!\n"
					+ produto);
			
		} else {
			JOptionPane.showMessageDialog(null, "Atenção!!!\nProduto já está cadastrado!");
		}
		// depois retirar, é apenas para teste
		System.out.println("tamanho lista = " + produtos.size());
	}

	/**
	 * Este metodo está sendo utilizando como um padrão de busca para todo o
	 * sistema.
	 */
	@Override
	public Produto buscarProduto(String nome, String marca) {

		for (Produto produtoBuscados : produtos) {
			if (produtoBuscados.getNomeProduto().contains(nome.trim())
					&& produtoBuscados.getMarcaProduto().contains(marca.trim())) {
				return produtoBuscados;
			}
		}
		return null;
	}

	/**
	 * o metodo para remover esta recebendo como parametro o objeto que tem setado
	 * dentro de si os dados recebidos através da busca feita, pelo metodo de
	 * buscar. que são nome e marca do produto
	 */
	@SuppressWarnings("static-access")
	@Override
	public void removerProduto(Produto produto) {
		if (produtos.contains(produto) == true) {
			int resp = JOptionPane.showConfirmDialog(null, "Produto Localizado.\n\n" + produto + "\n\nDeseja Remover?");
			if (resp == 0) {
				JOptionPane.showMessageDialog(null, "O Produto\n\n" + produto + "\n\nFoi removido com sucesso!");
				this.produtos.remove(produto);

			} else {
				JOptionPane.showMessageDialog(null, "OK, PRODUTO NÃO REMOVIDO");
			}
		} else {
			JOptionPane.showMessageDialog(null, "PRODUTO NÃO LOCALIZADO\nTENTE NOVAMENTE!");
		}

	}



	@Override
	public void buscareImprimir(Produto produto) {
		if (produtos.contains(produto) == true) {
			JOptionPane.showMessageDialog(null, produto);
		} else {
			JOptionPane.showMessageDialog(null, "SEU PRODUTO NÃO FOI LOCALIZADO!\n" + "Tente novamente!");
		}

	}

	@Override
	public void alterarProduto(Produto produto) {
		String continuar = "s";
		while (continuar.equalsIgnoreCase("s")) {

			for (Produto produto2 : produtos) {
				if ((produto2.getNomeProduto() == produto.getNomeProduto())
						&& (produto2.getMarcaProduto() == produto.getMarcaProduto())) {
					int entrarNaAlteracao = JOptionPane.showConfirmDialog(null,
							"Produto localizado\n" + produto2
									+ "\n\nATENÇÃO!!!\nNão é possivel fazer alterações de nome ou marca\n"
									+ "Deseja Continuar?");
					if (entrarNaAlteracao == 0) {
						String alteracao = JOptionPane.showInputDialog("Qual Alteração deseja fazer?\n"
								+ "1-UNIDADE MEDIDA.\n2-PREÇO UNITÁRIO\n3-QUANTIDADE\n");
						int altararProduto = Integer.parseInt(alteracao);
						/**
						 * o Corpo do if é responsavel pela alteração de apenas 1 atributo do produto
						 * 
						 */
						if (altararProduto == 1) {
							String novaMedida = JOptionPane.showInputDialog("NOVA UNIDADE DE MEDIDA:");
							int confirmarAlterarcao = JOptionPane.showConfirmDialog(null,
									"DESEJA CONFIRMAR ALTERAÇÃO?");
							if (confirmarAlterarcao == 0) {
								
								produto2.setUnidadeMedida(novaMedida);

								JOptionPane.showMessageDialog(null,
										"PRODUTO ALTERADO COM SUCESSO!\n" + "==== NOVOS DADOS ====\n" + produto2);
							}
						} else if (altararProduto == 2) {
							String preco = JOptionPane.showInputDialog("NOVO PREÇO:");
							int confirmarAlterarcao = JOptionPane.showConfirmDialog(null,
									"DESEJA CONFIRMAR ALTERAÇÃO?");
							if (confirmarAlterarcao == 0) {
								
								double novoPreco = Double.parseDouble(preco);
								produto2.setPrecoUnitario(novoPreco);
								JOptionPane.showMessageDialog(null,
										"PRODUTO ALTERADO COM SUCESSO!\n" + "==== NOVOS DADOS ====\n" + produto2);

							}
						} else if (altararProduto == 3) {
							String quantidade = JOptionPane.showInputDialog("NOVA QUANTIDADE:");
							int confirmarAlterarcao = JOptionPane.showConfirmDialog(null,
									"DESEJA CONFIRMAR ALTERAÇÃO?");
							if (confirmarAlterarcao == 0) {

								int novaQuantidade = Integer.parseInt(quantidade);
								produto2.setQuantidade(novaQuantidade);
								produto2.setQuantidadeTotalEstoque(produto2.getQuantidade());
								JOptionPane.showMessageDialog(null,
										"PRODUTO ALTERADO COM SUCESSO!\n" + "==== NOVOS DADOS ====\n" + produto2);
							}
						} else {
							JOptionPane.showMessageDialog(null, "opção incorreta, encerrando!");
						}
					}

				}
			}

			continuar = JOptionPane.showInputDialog("DESEJA FAZER MAIS ALGUMA ALTERAÇÃO?");
		}
	}

	@Override
	public void entradaProduto(Produto produto) {
		// TODO Auto-generated method stub
		if(produtos.contains(produto) == true) {
			String quant = JOptionPane.showInputDialog("INFORME A QUANTIDADE:");
			int quantidade = Integer.parseInt(quant);
			produto.setQuantidade(quantidade);
			int adicionarProduto = JOptionPane.showConfirmDialog(null, "DESEJA CONFIRMAR A ENTRADA?");
			if(adicionarProduto == 0) {
				
				produto.setQuantidadeTotalEstoque(produto.getQuantidadeTotalEstoque() + produto.getQuantidade());
				JOptionPane.showMessageDialog(null,"NOVOS DADOS DO PRODUTO\n\n" +  produto);
			}
		}else {
			JOptionPane.showMessageDialog(null, "PRODUTO NÃO LOCALIZADO!");
		}
		
	}

	@Override
	public void saidaProduto(Produto produto) {
		if(produtos.contains(produto) == true) {
			String quant = JOptionPane.showInputDialog("INFORME A QUANTIDADE:");
			int quantidade = Integer.parseInt(quant);
			produto.setQuantidade(quantidade);
			int saidaProduto = JOptionPane.showConfirmDialog(null, "DESEJA CONFIRMAR A ENTRADA?");
			if(saidaProduto == 0) {
				
				produto.setQuantidadeTotalEstoque(produto.getQuantidadeTotalEstoque() - produto.getQuantidade());
				JOptionPane.showMessageDialog(null,"NOVOS DADOS DO PRODUTO\n\n" +  produto);
			}
		}else {
			JOptionPane.showMessageDialog(null, "PRODUTO NÃO LOCALIZADO!");
		}
		
	}
	
	public void listaTotalProdutos() {
		for (Produto produtosTotaisEstoque : produtos) {
			JOptionPane.showMessageDialog(null, produtosTotaisEstoque);
		}
	}

	@Override
	public void reajustePreco(Produto produto) {
		if(produtos.contains(produto) == true) {
			String preco = JOptionPane.showInputDialog("INFORME O PERCENTUAL DE AUMENTO:");
			double porcentagem = Double.parseDouble(preco); 
			double novoPreco = (produto.getPrecoUnitario()
					+ (produto.getPrecoUnitario() * porcentagem ) / 100); 
			int ajustarPreco = JOptionPane.showConfirmDialog(null, "DESEJA CONFIRMAR O AJUSTE ?");
			if(ajustarPreco == 0) {
				produto.setPrecoUnitario(novoPreco);
				JOptionPane.showMessageDialog(null,"NOVOS DADOS DO PRODUTO\n\n" +  produto);
			}
		}else {
			JOptionPane.showMessageDialog(null, "PRODUTO NÃO LOCALIZADO!");
		}
		
	}

	

}
