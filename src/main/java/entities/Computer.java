package entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity //Hibernate, occupati di fare persistenza degli oggetti di questa classe sul db
public class Computer extends BaseEntity
{
	private String model;

	//LISTA DI FIGLI
	//List è un SUPERTIPO di ARRAYLIST, esistono molti tipi di liste
	//che discendono da List, arrayList è solo uno di essi
	//a livello di utilizzo cambia NULLA
	//OneToMany indica che è la parte 1 di una relazione 1-N
	//in mappedBy dobbiamo mettere il nome della proprietà riferimento al padre nel figlio
	//Il NOME DELLA PROPRIETÀ in componente soprà cui c'è ManyToOne
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "computerPadre")
	private List<Componente> componenti = new ArrayList<>();

	public Computer(){}

	public Computer(Long id, String model)
	{
		this.id = id;
		this.model = model;
	}


	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public List<Componente> getComponenti()
	{
		return componenti;
	}

	public void setComponenti(List<Componente> componenti)
	{
		this.componenti = componenti;
	}
}
