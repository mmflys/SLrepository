package per.sl.jndi.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

public class Paging {
    private int totalPageCount;
    private int pageSize;
    private int currentPage = 1;
    private int totalCount;
    private String sql;
    private Object[] params;
    Base base = new Base();

    public void setTotalCount(String sql, Object... params)
            throws SQLException, NamingException {
        ResultSet rs = base.query(sql, params);
        if (rs.next()) {
            Number n = (Number) rs.getObject(1);
            totalCount = n.intValue();
        }
    }

    public void setTotalPageCount(String sql, Object... params)
            throws SQLException, NamingException {
        setTotalCount(sql, params);
        if (totalCount % pageSize == 0) {
            totalPageCount = totalCount / pageSize;
        }
        else {
            totalPageCount = totalCount / pageSize + 1;
        }

    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public ResultSet toPage(int control) throws SQLException, NamingException {
        if (control == -1)
            setCurrentPage(currentPage - 1);
        else if (control == 1)
            setCurrentPage(currentPage + 1);
        String sqls = sql + " limit " + (currentPage - 1) * pageSize + ","
                + pageSize;
        System.out.println(sqls);
        ResultSet rs = base.query(sqls, params);
        return rs;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

}
