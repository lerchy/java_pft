package ru.stqa.pft.addressbook.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

/**
 * Created by valeriyagagarina on 1/6/17.
 */
public class DbHelper {
    private final SessionFactory sessionFactory;

    public DbHelper(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }

    public Groups groups(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<GroupData> groups = session.createQuery( "from GroupData" ).list();
        for ( GroupData group : groups ) {
            System.out.println( group );
        }
        session.getTransaction().commit();
        session.close();
        return new Groups(groups);
    }

    public Contacts contacts(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<ContactData> contacts = session.createQuery( "from ContactData where deprecated = '0000:00:00'" ).list();
//        for ( ContactData contact : contacts() ) {
//            System.out.println( contact );
//        }
        session.getTransaction().commit();
        session.close();
        return new Contacts(contacts);
    }

    public void refresh(Object o){
        Session session = sessionFactory.openSession();
        session.refresh(o);
        session.close();
    }
}
