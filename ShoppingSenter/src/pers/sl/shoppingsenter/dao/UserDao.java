package pers.sl.shoppingsenter.dao;

import java.util.List;

import pers.sl.shoppingsenter.entity.User;

public interface UserDao {
    // ����id��ȡ�û�
    User getUserById(int user_id);

    // ��ȡ�����û�
    List<User> listUser();

    // �½��û�
    void saveUser(User user);

    // �����û�
    void updateUser(User user);

    // ɾ���û�
    void deleteUser(int user_id);
}
