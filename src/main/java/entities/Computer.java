package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.StringJoiner;

@Entity //Hibernate, occupati di fare persistenza degli oggetti di questa classe sul db
public class Computer
{
	@Id //Questo campo è una primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	private Long id;


	private String model;
	private int ramGb,hddGb;
	private String gpu;

	public Computer(){}

	public Computer(Long id, String model, int ramGb, int hddGb, String gpu)
	{
		this.id = id;
		this.model = model;
		this.ramGb = ramGb;
		this.hddGb = hddGb;
		this.gpu = gpu;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public int getRamGb()
	{
		return ramGb;
	}

	public void setRamGb(int ramGb)
	{
		this.ramGb = ramGb;
	}

	public int getHddGb()
	{
		return hddGb;
	}

	public void setHddGb(int hddGb)
	{
		this.hddGb = hddGb;
	}

	public String getGpu()
	{
		return gpu;
	}

	public void setGpu(String gpu)
	{
		this.gpu = gpu;
	}

	@Override
	public String toString()
	{
		return new StringJoiner(" ", "", ".")
				.add("id: " + id)
				.add("model: " + model)
				.add("ramGb: " + ramGb)
				.add("hddGb: " + hddGb)
				.add("gpu: " + gpu)
				.toString();
	}
}
