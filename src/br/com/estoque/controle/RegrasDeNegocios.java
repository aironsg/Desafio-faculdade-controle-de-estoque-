package br.com.estoque.controle;

public interface RegrasDeNegocios {
	
	public void adicionarProdutos(Produto produto);
	public void removerProduto(Produto produto);
	public Produto buscarProduto(String nome, String marca);
	public void buscareImprimir(Produto produto);
	public void alterarProduto(Produto produto);
	public void entradaProduto(Produto produto);
	public void saidaProduto(Produto produto);
	public void reajustePreco(Produto produto);

}
