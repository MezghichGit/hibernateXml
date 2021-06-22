package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import entities.Client;
import Util.HibernateUtil;

public class MaClasseDeTestDAO {
	public static void main(String[] args) {
// On obtient la session hibernate courante
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); // débuter la transaction
// on crée une instance de la classe de données Reservations
			Client c1 = new Client(400, "Olivier", "Plessiet");
			session.save(c1);
			tx.commit();// ” commit” de la transaction
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();// on effectue un roll back en cas d’exception
// afin de garder la cohérence des données
				//HibernateUtil.closeSession();
				session.close();
			}
			session.close();// fermeture de la session hibernate
		}
	}
}