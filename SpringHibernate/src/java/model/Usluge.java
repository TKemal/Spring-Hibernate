package model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Usluge {

    public static Session kreirajSesiju() {
        Configuration c = new Configuration().configure();
        StandardServiceRegistryBuilder builder
                = new StandardServiceRegistryBuilder().
                        applySettings(c.getProperties());
        SessionFactory f = c.buildSessionFactory(builder.build());
        return f.openSession();
    }

    public static void unesi(Korisnik k) // insert
    {
        Session session = kreirajSesiju();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            //session.save(k);
            session.persist(k);
            tr.commit();
        } catch (HibernateException e) {
            tr.rollback();
        } finally {
            session.close();
        }
    }

}

