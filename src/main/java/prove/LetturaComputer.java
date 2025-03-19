package prove;

import entities.Computer;
import org.hibernate.Session;
import utility.HibernateUtil;

import java.util.List;

public class LetturaComputer
{
	public static void main(String[] args)
	{
		//crea la connessione "intelligente" verso il db specificato in hibernate.cfg.xml
		Session session = HibernateUtil.getSessionFactory().openSession();

		//UNA TRANSACTION è una unità di lavoro verso il db
		//un insieme di operazioni che vengono eseguite o tutte o nessuna
		//è uno Statement plus
		session.beginTransaction();

		//lettura singola

		//leggo il computer con id 1
		System.out.println("-------------------------------------------\nLETTURA SINGOLA");
		Computer uno = session.get(Computer.class,1);
		System.out.println(uno);
		System.out.println("-------------------------------------------");

		System.out.println("-------------------------------------------\nLETTURA COMPLETA");
		//li leggo tutti
		//											SELECT * FROM Computer dove l'oggetto lo chiamo comp
		//																				Ogni riga trasformala in un oggetto Computer
		//																								Dammi il risultato come lista
		List<Computer> tutti = session.createQuery("SELECT comp FROM Computer comp", Computer.class).getResultList();

		for(Computer c:tutti)
			System.out.println(c);

		//termino la transazione, rendendo tutto permanente
		session.getTransaction().commit();

		//finiamo la sessione
		session.close();
	}
}
