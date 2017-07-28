package pers.sl.shoppingsenter.mapper;

import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import pers.sl.shoppingsenter.dao.UserDao;
import pers.sl.shoppingsenter.entity.User;

public class UserMapper extends JdbcDaoSupport implements UserDao {

    @Override
    public User getUserById(int user_id) {
        String sql = "select * from com_user where user_id=?";
        return super.getJdbcTemplate().queryForObject(sql,
                ParameterizedBeanPropertyRowMapper.newInstance(User.class),
                user_id);
    }

    @Override
    public List<User> listUser() {
        String sql = "select * from com_user";
        return super.getJdbcTemplate().query(sql,
                ParameterizedBeanPropertyRowMapper.newInstance(User.class));
    }

    @Override
    public void saveUser(User user) {
        String sql = "insert into com_user values(null,?,?,?,?)";
        super.getJdbcTemplate().update(sql, user.getUser_name(),
                user.getUser_password(), user.getUser_score(),
                user.getUser_power());
    }

    @Override
    public void updateUser(User user) {
        String sql = "update com_user set user_name=?, user_password=?, "
                + "user_score=?, user_power=? where user_id=?";
        super.getJdbcTemplate().update(sql, user.getUser_name(),
                user.getUser_password(), user.getUser_score(),
                user.getUser_power(), user.getUser_id());
    }

    @Override
    public void deleteUser(int user_id) {
        String sql = "update com_user set user_power=? where user_id=?";
        super.getJdbcTemplate().update(sql, 0, user_id);
    }

}
