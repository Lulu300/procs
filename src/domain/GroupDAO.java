package domain;

import java.util.ArrayList;
import java.util.List;

import models.Contact;
import models.Group;

public class GroupDAO extends DAO {

	public GroupDAO() {
		super();
	}
	
	public List<Group> getAllGroups() {
		List<Group> contacts = new ArrayList<Group>();
		
		super.beginTransaction();
		try {
			contacts = super.getSession().createQuery("from Group group").list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
		return contacts;
	}
	
	public Group getGroup(int id) {
		Group group = null;
		super.beginTransaction();
		try {
			group = (Group) super.getSession().get(Group.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
		return group;	
	}
	
	public void addGroup(Group group) {
		super.beginTransaction();
		try {
			super.getSession().save(group);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
	}
}
