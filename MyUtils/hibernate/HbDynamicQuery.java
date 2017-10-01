package per.sl.hb.stu.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * HibernateDynamicQuery util type.
 * Sql eg: from user where 1=1 and attr1>= ? and attr1<= ? and attr2......
 * >=startValue,<=endValue,=uniqueValue.
 * Get sql firstly,then get params.
 * @author SuLiang
 * @date: 2017年10月1日 下午3:57:15
 */
public class HbDynamicQuery {
    private List<Map<String, Object>> conditionList = new ArrayList<Map<String, Object>>();
    private StringBuffer sql = null;
    private List<Object> params = new ArrayList<Object>();

    /**
     * set conditionList contain map of params and condition
     * @param  conditionList get it from request
     * @return: void
     */
    public void setconditionList(List<Map<String, Object>> conditionList) {
        this.conditionList = conditionList;
    }

    public void addParamRange(String name, Object startValue, Object endValue) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("name", name);
        paramMap.put("startValue", startValue);
        paramMap.put("endValue", endValue);
        conditionList.add(paramMap);
    }

    public void addParamMin(String name, Object startValue) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("name", name);
        paramMap.put("startValue", startValue);
        conditionList.add(paramMap);
    }

    public void addParamMax(String name, Object endValue) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("name", name);
        paramMap.put("endValue", endValue);
        conditionList.add(paramMap);
    }

    public void addParamUnique(String name, Object uniqueValue) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("name", name);
        paramMap.put("uniqueValue", uniqueValue);
        conditionList.add(paramMap);
    }

    public void setSelectClause(String select) {
        this.sql = new StringBuffer(select.trim() + " where 1=1");
    }

    public String getSql() {
        for (Map<String, Object> map : conditionList) {
            Object startValue = map.get("startValue");
            Object endValue = map.get("endValue");
            Object uniqueValue = map.get("uniqueValue");
            if (startValue != null && endValue != null) {
                String condition = " and " + map.get("name") + " >= ? and "
                        + map.get("name") + " <= ?";
                params.add(startValue);
                params.add(endValue);
                this.sql.append(condition);
            } else if (startValue != null && endValue == null) {
                String condition = " and " + map.get("name") + " >= ?";
                params.add(startValue);
                this.sql.append(condition);
            } else if (startValue == null && endValue != null) {
                String condition = " and " + map.get("name") + " <= ?";
                params.add(endValue);
                this.sql.append(condition);
            } else {
                String condition = " and " + map.get("name") + " = ?";
                params.add(uniqueValue);
                this.sql.append(condition);
            }
        }
        System.out.println(this.sql);
        return this.sql.toString();
    }

    public List<Object> getParams() {
        return this.params;
    }

}
