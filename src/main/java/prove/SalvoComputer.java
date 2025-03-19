package prove;

import entities.Computer;
import org.hibernate.Session;
import utility.HibernateUtil;

public class SalvoComputer
{
	public static void main(String[] args)
	{
		//crea la connessione "intelligente" verso il db specificato in hibernate.cfg.xml
		Session session = HibernateUtil.getSessionFactory().openSession();

		//UNA TRANSACTION è una unità di lavoro verso il db
		//un insieme di operazioni che vengono eseguite o tutte o nessuna
		//è uno Statement plus
		session.beginTransaction();
		Computer c = new Computer();
		c.setGpu("GTX 760");
		c.setHddGb(1000);
		c.setRamGb(16);
		c.setModel("Catorcios");

		//chiedo ad hibernate di fare inserimento sul db
		session.save(c);

		//termino la transazione, rendendo tutto permanente
		session.getTransaction().commit();

		//finiamo la sessione
		session.close();
	}
}
