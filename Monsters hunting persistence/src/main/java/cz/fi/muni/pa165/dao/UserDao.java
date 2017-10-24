package cz.fi.muni.pa165.dao;

import cz.fi.muni.pa165.entity.User;

import java.util.List;

public interface UserDao {
	void create(User user);
	void delete(User user);
	User findById(Long id);
	List<User> getAll();
}
