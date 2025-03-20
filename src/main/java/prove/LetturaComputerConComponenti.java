package prove;

import entities.Componente;
import entities.Computer;
import org.hibernate.Session;
import utility.HibernateUtil;

public class LetturaComputerConComponenti
{

	public static void main(String[] args)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		Computer mimmo = session.get(Computer.class,1);
		//qui non ho letto solo il Computer, ma anche tutti i suoi componenti figli

		System.out.println("Modello: "+mimmo.getModel());
		System.out.println("Componenti:");
		for(Componente c : mimmo.getComponenti())
			System.out.println(c);
	}
}
