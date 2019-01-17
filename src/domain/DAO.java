package domain;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;

import util.HibernateUtil;

public class DAO {

    private Transaction tx;
    private Statistics stats;

    DAO() {
        super();
        this.tx = null;
        this.stats = null;
    }

    Session getSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    void beginTransaction() {
        try {
            this.tx = this.getSession().beginTransaction();
            this.stats = HibernateUtil.getSessionFactory().getStatistics();
            stats.setStatisticsEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void endTransaction() {
        try {
        	System.out.println("Second Level Hit Count=" + stats.getSecondLevelCacheHitCount());
			System.out.println("Second Level Miss Count=" + stats.getSecondLevelCacheMissCount());
            this.tx.commit();
            System.out.println("Second Level Hit Count=" + stats.getSecondLevelCacheHitCount());
			System.out.println("Second Level Miss Count=" + stats.getSecondLevelCacheMissCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.tx = null;
    }

}
