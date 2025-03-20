package prove;

import entities.Componente;
import entities.Computer;
import org.hibernate.Session;
import utility.HibernateUtil;

public class AggiungereComponente
{
	public static void main(String[] args)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();


		Componente componente = new Componente("RTXML 5090","GPU",3000);

		//Leggo computer padre dal db
//		Computer padre =session.get(Computer.class,1);
		Computer padre = session.createQuery("SELECT c FROM Computer c WHERE c.model='MimmoX'", Computer.class).getSingleResult();

		//imposto il computer come proprietà di riferimento del componente
		componente.setComputerPadre(padre);

		//salvo, ho finito
		session.save(componente);







		session.getTransaction().commit();
		session.close();
	}
}
