package domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import domain.Group;

public class GroupDAO extends DAO {

	public GroupDAO() {
        super();
    }
	
	public String saveOrUpdateGroup(Group group) {
		String res = null;
		super.beginTransaction();
		try {
			super.getSession().saveOrUpdate(group);
			res = "Successfully saving/updating group";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
		return res;
	}
	
	public Group getGroup(int id) {
		return (Group) super.getSession().get(Group.class, id);
	}
	
	public String removeGroup(Group group) {
		String res = null;
		try {
			super.getSession().delete(group);
			res = "Successfully removing group with id " + group.getId();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.endTransaction();
		}
		return res;
	}
	
	public List<Group> getAllGroups() {
		List<Group> groups = new ArrayList<Group>();
		super.beginTransaction();
		for (final Object o : super.getSession().createCriteria(Group.class).list()) {
			groups.add((Group) o);
		}
		super.endTransaction();
		return groups;
	}
}
