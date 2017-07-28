package pers.sl.shoppingsenter.service;

import java.util.List;

import pers.sl.shoppingsenter.entity.User;

public interface UserService {
    // 根据id获取用户
    User getUserById(int user_id);

    // 获取所有用户
    List<User> listUser();

    // 新建用户
    void saveUser(User user);

    // 更新用户
    void updateUser(User user);

    // 删除用户
    void deleteUser(int user_id);
}
