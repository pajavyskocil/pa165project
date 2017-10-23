package cz.fi.muni.pa165.dao;

import cz.fi.muni.pa165.entity.User;

import java.util.List;

public interface UserDao {
	void create(User user);
	List<User> getAll();
}
