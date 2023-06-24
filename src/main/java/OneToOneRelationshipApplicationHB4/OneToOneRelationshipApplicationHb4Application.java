package OneToOneRelationshipApplicationHB4;


import OneToOneRelationshipApplicationHB4.domain.User;
import OneToOneRelationshipApplicationHB4.domain.Vehical;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class OneToOneRelationshipApplicationHb4Application {

	public static void main(String[] args) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata =new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = metadata.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction txs = session.beginTransaction();

		User u1 = new User();
		u1.setName("Ajay");
		u1.setAdress("India");
		u1.setEmail("aj@gmail.com");

		Vehical v1 = new Vehical();
		v1.setVehical_name("Kawasaki");
		v1.setType("Bike");
		v1.setPrice(500000);

		u1.setVehical(v1);
		v1.setUser(u1);

		session.persist(u1);
		txs.commit();

		session.close();
		System.out.println("Ok ! Successful Done");
	}
}
