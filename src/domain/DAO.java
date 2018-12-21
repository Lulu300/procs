package domain;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class DAO {

    private Transaction tx;

    DAO() {
        super();
        this.tx = null;
    }

    Session getSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    void beginTransaction() {
        try {
            this.tx = this.getSession().beginTransaction();
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
