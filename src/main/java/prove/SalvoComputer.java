package prove;

import entities.Computer;
import org.hibernate.Session;
import utility.HibernateUtil;

import java.util.Scanner;

public class SalvoComputer
{
	public static void main(String[] args)
	{
		//crea la connessione "intelligente" verso il db specificato in hibernate.cfg.xml
		Session session = HibernateUtil.getSessionFactory().openSession();

		//UNA TRANSACTION è una unità di lavoro verso il db
		//un insieme di operazioni che vengono eseguite o tutte o nessuna
		//è uno Statement plus
		Computer c = new Computer();
		c.setModel("MimmoX");
		session.beginTransaction();

		//chiedo ad hibernate di fare inserimento sul db
		session.save(c);

		//termino la transazione, rendendo tutto permanente

//		System.out.println("MA PUOI PAGARE?");
//		Scanner sc = new Scanner(System.in);

//		if(sc.nextLine().equals("SI"))
//			session.getTransaction().commit();//TERMINO LA TRANSAZIONE RENDENDO TUTTO PERMANENTE
//		else
//			session.getTransaction().rollback();//ANNULLO TUTTO CIÒ CHE È STATO FATTO NELLA TRANSAZIONE

		//alternativa è ROLLBACK
		//ROLLBACK significa ANNULLA TUTTA la transaction
		session.getTransaction().commit();

		//finiamo la sessione
		session.close();
	}
}
