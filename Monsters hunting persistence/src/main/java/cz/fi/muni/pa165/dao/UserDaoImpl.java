package cz.fi.muni.pa165.dao;

import cz.fi.muni.pa165.entity.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.inject.Named;
import java.util.List;

@Named
public class UserDaoImpl implements UserDao {
	@Override
	public void create(User user) {
		throw new NotImplementedException();
	}

	@Override
	public void delete(User user) {
		throw new NotImplementedException();
	}

	@Override
	public User findById(Long id) {
		throw new NotImplementedException();
	}

	@Override
	public List<User> getAll() {
		throw new NotImplementedException();
	}
}
