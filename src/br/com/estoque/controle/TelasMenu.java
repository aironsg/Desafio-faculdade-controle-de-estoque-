package br.com.estoque.controle;

import javax.swing.JOptionPane;

public class TelasMenu implements Menu {

	/**
	 * Entendendo a classe TelasMenu
	 * 
	 * a classe telas menu será responsavel apenas pela implementação dos menus na
	 * tela com o objetivo de aliviar a classe Produto devido a complexidade dos
	 * metodos utlizados na classe produto será muito mais viavel, fazer chamadas de
	 * um objeto tela assim , a classe produto ficará responsavel apenas pelos seus
	 * metodos de inclusão, alteração e remoção em todos seus ramos do sistema
	 */

	// neste momento estou enviando o projeto sem todas as implementações de menu
	// o objetivo é da um norte na montagem do projeto

	@Override
	public int telaPrincipal() {
		int opcao;
		String opcaoMenuPrincipal = JOptionPane.showInputDialog(

				"EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.\n" + "SISTEMA DE CONTROLE DE ESTOQUE\n"
						+ "=============================\n" + "**************** MENU ****************\n"
						+ "=============================\n" + "1- CADASTRO DE PRODUTOS\n" + "2- MOVIMENTAÇÃO         \n"
						+ "3- REAJUSTE DE PREÇOS   \n" + "4- RELATÓRIOS           \n" + "0- FINALIZAR            \n"
						+ "OPÇÃO: ");
		opcao = Integer.parseInt(opcaoMenuPrincipal);
		return opcao;

	}

	@Override
	public int telaCadastro() {
		int opcao;
		String opcaoMenuCadastro = JOptionPane.showInputDialog("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.\n"
				+ "SISTEMA DE CONTROLE DE ESTOQUE\n" + "=============================\n"
				+ "*************CADASTRO*************\n" + "=============================\n" + "1- INCLUSÃO \n"
				+ "2- ALTERAÇÃO\n" + "3- CONSULTA \n" + "4- EXCLUSÃO \n" + "0- RETORNAR \n" + "OPÇÃO: ");
		opcao = Integer.parseInt(opcaoMenuCadastro);
		return opcao;

	}

	@Override
	public int telaMovimentacao() {
		int opcao;
		String opcaoMenuMovimentação = JOptionPane
				.showInputDialog("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.\n" + "SISTEMA DE CONTROLE DE ESTOQUE\n"
						+ "=============================\n" + "*********MOVIMENTAÇÃO*********\n"
						+ "=============================\n" + "1- ENTRADA \n" + "2- SAIDA\n" + "0- RETORNAR \n");
		opcao = Integer.parseInt(opcaoMenuMovimentação);
		return opcao;

	}

}
