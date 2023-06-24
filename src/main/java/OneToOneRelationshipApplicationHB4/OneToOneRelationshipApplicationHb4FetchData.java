package OneToOneRelationshipApplicationHB4;

import OneToOneRelationshipApplicationHB4.domain.User;
import OneToOneRelationshipApplicationHB4.domain.Vehical;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Iterator;
import java.util.List;

public class OneToOneRelationshipApplicationHb4FetchData {
    public static void main(String[] args) {

        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction tsx = session.beginTransaction();

        TypedQuery query = session.createQuery("from User user");
        List<User>list = query.getResultList();
        Iterator<User>iterator = list.listIterator();

        while (iterator.hasNext())
        {
            User u2 = iterator.next();
            System.out.println(u2.getName()+" "+u2.getAdress()+" "+u2.getEmail());

            Vehical v2 = u2.getVehical();
            System.out.println(v2.getVehical_name()+" "+v2.getType()+" "+v2.getPrice());
        }
        session.close();
        System.out.println("Fetch data Successfully ----- ok!");
    }
}
