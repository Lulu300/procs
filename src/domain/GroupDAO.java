package domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import models.Group;

public class GroupDAO extends DAO {

	public GroupDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public List<Group> getAllGroups() {
		List<Group> contacts = new ArrayList<Group>();
		
		// super.beginTransaction();
		try {
			contacts = super.getSessionFactory().getCurrentSession().createQuery("from Group group").list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// super.endTransaction();
		}
		
		return contacts;
	}
	
	public Group getGroup(int id) {
		Group group = null;
		
		// super.beginTransaction();
		try {
			group = (Group) super.getSessionFactory().getCurrentSession().get(Group.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// super.endTransaction();
		}
		
		return group;	
	}
	
	public boolean addGroup(Group group) {
		boolean success;
		
		// super.beginTransaction();
		try {
			super.getSessionFactory().getCurrentSession().save(group);
			success = true;
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
		} finally {
			// super.endTransaction();
		}
		
		return success;
	}
	
}
