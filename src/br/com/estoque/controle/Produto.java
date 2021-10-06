package br.com.estoque.controle;

import java.util.Objects;

public class Produto {
	
	private String nomeProduto;
	private String marcaProduto;
	private String unidadeMedida;
	private int quantidade;
	private int quantidadeTotalEstoque;
	private double precoUnitario;
	
	
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getMarcaProduto() {
		return marcaProduto;
	}
	public void setMarcaProduto(String marcaProduto) {
		this.marcaProduto = marcaProduto;
	}
	public String getUnidadeMedida() {
		return unidadeMedida;
	}
	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getQuantidadeTotalEstoque() {
		return quantidadeTotalEstoque;
	}
	public void setQuantidadeTotalEstoque(int quantidadeTotalEstoque) {
		this.quantidadeTotalEstoque = quantidadeTotalEstoque;
	}
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(marcaProduto, nomeProduto, precoUnitario, quantidade, quantidadeTotalEstoque,
				unidadeMedida);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(marcaProduto, other.marcaProduto) && Objects.equals(nomeProduto, other.nomeProduto)
				&& Double.doubleToLongBits(precoUnitario) == Double.doubleToLongBits(other.precoUnitario)
				&& quantidade == other.quantidade && quantidadeTotalEstoque == other.quantidadeTotalEstoque
				&& Objects.equals(unidadeMedida, other.unidadeMedida);
	}
	
	
	
	@Override
	public String toString() {
		return "=== PRODUTO ===\n" + 
				"NOME            : " + getNomeProduto() + 
				"\nMARCA         : " + getMarcaProduto()+
				"\nUNIDADE MEDIDA: " + getUnidadeMedida() + 
				"\nTOTAL ESTOQUE : " +getQuantidadeTotalEstoque() +
				"\nPREÇO UNITÁRIO:R$ " +getPrecoUnitario() +"\n==============";
	}
	
	
	
	
	
	
	
	

}
