package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Util.HibernateUtil;
import entities.Client;


//Cette va nous permettre d'éffectuer les opérations CRUD sur l'entité Client
public class DaoClient {
	
	//addClient permet d'ajouter un nouveau client à la base
	public Client addClient(Client temp){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); // débuter la transaction
			// on crée une instance de la classe de données
			//Client c1 = new Client(600, "Alain", "Claude");

			session.save(temp);
			tx.commit();// ” commit” de la transaction
		} 
		catch (Exception e) {
			//System.out.println("Un problème dans la base");
			if (tx != null) {
				tx.rollback();// on effectue un roll back en cas d’exception
                    // afin de garder la cohérence des données
				session.close();
			}
			session.close();// fermeture de la session hibernate
		}
		
		return temp;
	}
	
	//getClient permet dechercher un client avec idC = id
	public Client getClient(int id)
	{
		Client c=null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); // débuter la transaction
			
			 c= (Client)session.load(Client.class,id);
			tx.commit();
		} 
		catch (Exception e) {
			//System.out.println("Un problème dans la base");
			if (tx != null) {
				tx.rollback();// on effectue un roll back en cas d’exception
                    // afin de garder la cohérence des données
				session.close();
			}
			session.close();// fermeture de la session hibernate
		}
		
		return c;
		
		
	}

	
	//deleteClient permet de supprimer un client avec id
		public Client deleteClient(int id)
		{
			Client c=null;
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction(); // débuter la transaction
				
				 c= (Client)session.load(Client.class,id);
				 session.delete(c) ; //suppression de l’objet « c »
				tx.commit();
			} 
			catch (Exception e) {
				//System.out.println("Un problème dans la base");
				if (tx != null) {
					tx.rollback();// on effectue un roll back en cas d’exception
	                    // afin de garder la cohérence des données
					session.close();
				}
				session.close();// fermeture de la session hibernate
			}
			
			return c;
			
			
		}
	//update
	//getAll
}
