package domain;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;

public class DAO {

    // private Statistics stats;
    protected SessionFactory sessionFactory;

    DAO(SessionFactory sessionFactory) {
        super();
        // this.stats = null;
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
    	this.sessionFactory = sessionFactory;
    }
    
    protected void getStats() {
    	// this.stats = this.getSessionFactory().getStatistics();
        // stats.setStatisticsEnabled(true);
    }

}
