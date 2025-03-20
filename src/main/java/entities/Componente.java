package entities;

import jakarta.persistence.*;

import java.util.StringJoiner;

@Entity
public class Componente
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome,tipo;
	private double prezzo;

	//RIFERIMENTO AL PADRE
	//ManyToOne indica che è la parte N di una relazione N-1, che è figlio
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_computer")//nome foreign key nel db
	private Computer computerPadre;

	public Componente(){}

	public Componente(Long id, String nome, String tipo, double prezzo)
	{
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.prezzo = prezzo;
	}

	public Componente( String nome, String tipo, double prezzo)
	{
		this.nome = nome;
		this.tipo = tipo;
		this.prezzo = prezzo;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getTipo()
	{
		return tipo;
	}

	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}

	public double getPrezzo()
	{
		return prezzo;
	}

	public void setPrezzo(double prezzo)
	{
		this.prezzo = prezzo;
	}

	public Computer getComputerPadre()
	{
		return computerPadre;
	}

	public void setComputerPadre(Computer computerPadre)
	{
		this.computerPadre = computerPadre;
	}

	@Override
	public String toString()
	{
		return new StringJoiner(" ", "", ".")
				.add("prezzo: " + prezzo)
				.add("tipo: " + tipo)
				.add("nome: " + nome)
				.add("id: " + id)
				.toString();
	}
}
