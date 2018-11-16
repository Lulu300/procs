package domain;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class DAO {

    private Session session;
    private Transaction tx;

    DAO() {
        super();
        try {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            this.tx = null;
        } catch (Exception e) {
            this.session = null;
            e.printStackTrace();
        }
    }

    Session getSession() {
        return this.session;
    }

    void beginTransaction() {
        try {
            this.tx = this.session.beginTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void endTransaction() {
        try {
            this.tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.tx = null;
    }

}
