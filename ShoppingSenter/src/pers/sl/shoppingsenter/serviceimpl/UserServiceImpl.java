package pers.sl.shoppingsenter.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.sl.shoppingsenter.dao.UserDao;
import pers.sl.shoppingsenter.entity.User;
import pers.sl.shoppingsenter.service.UserService;

@Service(value = "UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User getUserById(int user_id) {
        return userDao.getUserById(user_id);
    }

    @Override
    public List<User> listUser() {
        return userDao.listUser();
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(int user_id) {
        userDao.deleteUser(user_id);
    }

}
