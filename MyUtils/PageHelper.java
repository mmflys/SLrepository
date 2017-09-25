package per.sl.appsys.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

/**
 * a paging util within mybatis
 * @author SuLiang
 * @Description: TODO
 * @date: 2017年9月25日 下午4:42:01
 * @param <T> the pojo corresponding this dao
 * @param dao <p> mapping the xml with in mybatis
 * @param countMethodName <p> the name of countMethod from dao, it has a default name "count",you can custom it
 * @param pagingMethodName <p> the name of countMethod from dao, it has a default name "pageObj",you can custom it
 */
@Component
public class PageHelper<T> {
    private Object dao;
    private String countMethodName = "count";
    private String pagingMethodName = "pageObj";

    /**
     * this class can register as a singleton bean
     */
    public PageHelper() {
    }

    /**
     * countMethodName and pagingMethodName have a default name "count","pageObj"
     * @param dao
     */
    public PageHelper(Object dao) {
        this.dao = dao;
    }

    /**
     * custome the name of countMethodName and pagingMethodName
     * @param dao
     * @param countMethodName
     * @param pagingMethodName
     */
    public PageHelper(Object dao, String countMethodName,
            String pagingMethodName) {
        super();
        this.dao = dao;
        this.countMethodName = countMethodName;
        this.pagingMethodName = pagingMethodName;
    }

    /**
     * if this class registered as a bean,the dao should to set;
     * 
     * @param dao
     * @param countMethodName
     * @param pagingMethodName
     * @return void
     */
    public void initPageHelper(Object dao, String countMethodName,
            String pagingMethodName) {
        this.dao = dao;
        this.countMethodName = countMethodName;
        this.pagingMethodName = pagingMethodName;
    }

    /**
     * set dao,countMethodName,pagingMethodName have default value
     * @Description: init
     * @param: @param dao
     * @return: void
     */
    public void initPageHelper(Object dao) {
        this.dao = dao;
    }

    /**
     * count the page,query within special conditino
     * @param operator the name of operation, it contain: first,last,next,pre,""
     * you can get first page by name of operation "first"
     * if you haven`t set the name ,you will get null
     * @param pageNum page number
     * @param pageSize howmany obj per page
     * @param record condition of filter
     * @param Exception
     * @return Map<String,Object> <p> it contaion the keyName "meg","list","totalage"<p>
     * meg: success or error ,when the result is null meg is error
     * list: result of query
     * totalPage: total page number
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> pageObj(String operator, int pageNum,
            int pageSize, T record) throws Exception {
        Long startTime = System.currentTimeMillis();
        // 反射获取类类型
        Class daoType = dao.getClass();
        List<T> objList = new ArrayList<T>();
        Map<String, Object> objMap = new HashMap<String, Object>();
        // 反射获取两个方法
        Method pageMethod = daoType.getDeclaredMethod(pagingMethodName,
                RowBounds.class, record.getClass());
        Method countMethod = daoType.getDeclaredMethod(countMethodName,
                record.getClass());
        // 获取总记录数
        int totalRecord = (int) countMethod.invoke(dao, record);
        int totalPage = (totalRecord / pageSize) % 2 == 0
                ? totalRecord / pageSize : totalRecord / pageSize + 1;
        // 自动判断页操作
        switch (operator) {
        case "first": {
            objList = (List<T>) pageMethod.invoke(dao,
                    new RowBounds(0, pageSize), record);
            break;
        }
        case "last": {
            objList = (List<T>) pageMethod.invoke(dao,
                    new RowBounds((totalPage - 1) * pageSize, pageSize),
                    record);
            break;
        }
        case "pre": {
            if (pageNum - 1 < 0)
                objList = null;
            else
                objList = (List<T>) pageMethod.invoke(dao,
                        new RowBounds((pageNum - 2) * pageSize, pageSize),
                        record);
            break;
        }
        case "next": {
            if (pageNum + 1 > totalPage)
                objList = null;
            else
                objList = (List<T>) pageMethod.invoke(dao,
                        new RowBounds(pageNum * pageSize, pageSize), record);
            break;
        }
        case "": {
            objList = (List<T>) pageMethod.invoke(dao,
                    new RowBounds((pageNum - 1) * pageSize, pageSize), record);
        }
        default: {
            objList = null;
        }
        }
        if (objList == null)
            objMap.put("meg", "error");
        else {
            objMap.put("meg", "success");
            objMap.put("list", objList);
            objMap.put("totalPage", totalPage);
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("PageHelper spend " + (endTime - startTime));
        return objMap;
    }

}
