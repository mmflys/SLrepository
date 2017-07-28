package pers.sl.shoppingsenter.service;

import java.util.List;

import pers.sl.shoppingsenter.entity.User;

public interface UserService {
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
