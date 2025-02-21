package model;

public class Jogos{
	private int codigo;
	private String nome;
	private String empresa;
	private int quantidade;
	
	public Jogos() {
		this.codigo = -1;
		this.nome = "";
		this.empresa = "";
		this.quantidade = 0;
	}
	
	public Jogos(int codigo, String nome, String empresa, int quantidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.empresa = empresa;
		this.quantidade = quantidade;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nome=" + nome + ", empresa=" + empresa + ", quantidade=" + quantidade + "]";
	}	
}
