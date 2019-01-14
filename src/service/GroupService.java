package service;

import java.util.List;

import domain.GroupDAO;
import models.Group;

public class GroupService {
	
	private GroupDAO groupDAO;
	
	public GroupService() {	}
	
	public void setGroupDAO(GroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}
	
	public List<Group> getAllGroups() {
		return this.groupDAO.getAllGroups();
	}
	
	public Group getGroup(int id) {
		return this.groupDAO.getGroup(id);
	}
	
	public boolean addGroup(Group group) {
		return this.groupDAO.addGroup(group);
	}

}
