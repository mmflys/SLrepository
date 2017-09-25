package cn.smbms.units;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * <h1>JNDI jdbc</h1>
 * <h1>author</h1> SuLiang
 * <h1>Description</h1> connection to DB,do update,delete,insert and query with JNDI
 * <h1>Parameters</h1> obj the type of entity
 * <h1>date</h1> 2017骞�8鏈�29鏃� 涓嬪崍9:01:34
 */
public class Base {
	private Connection con = null;
	private Object obj = null;
	private String jndiDatasource = "java:comp/env/jdbc/stu";

	/**
	 * @Description: init con
	 */
	public Base() {
		try {
			getCon();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Description: must set the obj
	 * @param: @param obj the type of entity
	 * @return: void
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}

	/**
	 * 
	 * @Description: connect to database using JNDI
	 * @param: @throws NamingException
	 * @param: @throws SQLException
	 * @return: void
	 */
	private void getCon() throws NamingException, SQLException {
		Context context = new InitialContext();
		DataSource dt = (DataSource) context.lookup(jndiDatasource);
		con = dt.getConnection();
	}

	/**
	 * 
	 * @Description: do update,insert,delete
	 * @param: @param sql
	 * @param: @param params
	 * @param: @throws SQLException
	 * @param: @throws NamingException
	 * @return: int the result of update operation
	 */
	public int update(String sql, Object... params) throws SQLException, NamingException {
		PreparedStatement ps = this.con.prepareStatement(sql);
		if (params != null) {
			for (int i = 1; i <= params.length; i++) {
				ps.setObject(i, params[i - 1]);
			}
		}
		return ps.executeUpdate();
	}

	/**
	 * 
	 * @Description: get resultset
	 * @param: @param sql
	 * @param: @param params
	 * @param: @throws SQLException
	 * @param: @throws NamingException
	 * @return: ResultSet
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public List<Object> query(String sql, Object... params)
			throws SQLException, NamingException, InstantiationException, IllegalAccessException {
		PreparedStatement ps = this.con.prepareStatement(sql);
		if (params != null) {
			for (int i = 1; i <= params.length; i++) {
				ps.setObject(i, params[i - 1]);
			}

		}
		ResultSet rs = ps.executeQuery();
		// 鐢ㄥ弽灏勫姩鎬佸缓瀵硅薄骞跺垵濮嬪寲
		List<Object> objList = new ArrayList<Object>();
		Class c = obj.getClass();// 鑾峰彇鍘熺被
		Field[] field = c.getDeclaredFields();// 鑾峰彇璇ョ被澹版槑鐨勫瓧娈�
		while (rs.next()) {
			Object o = c.newInstance();// 鑾峰彇涓�涓绫荤殑瀹炰緥
			int i = 1;
			for (Field f : field) {
				f.setAccessible(true);// 瑙ｉ櫎灏佽
				f.set(o, rs.getObject(i));// 璁剧疆灞炴�у��
				i++;
			}
			objList.add(o);
		}
		return objList;
	}

	public void close() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
