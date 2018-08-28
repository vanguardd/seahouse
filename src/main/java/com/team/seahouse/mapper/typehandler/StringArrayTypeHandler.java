package com.team.seahouse.mapper.typehandler;

import com.team.seahouse.commons.utils.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Title:
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/08/26
 */
public class StringArrayTypeHandler extends BaseTypeHandler<String[]> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String[] strings, JdbcType jdbcType) throws SQLException {
        String result = StringUtils.arrayToString(strings);
        ps.setString(i, result);
    }

    @Override
    public String[] getNullableResult(ResultSet rs, String s) throws SQLException {
        return getStringArray(s);
    }

    @Override
    public String[] getNullableResult(ResultSet rs, int i) throws SQLException {
        return getStringArray(rs.getString(i));
    }

    @Override
    public String[] getNullableResult(CallableStatement cs, int i) throws SQLException {
        return this.getStringArray(cs.getString(i));
    }

    /**
     * 字符串转化为数组对象
     * @param columnValue
     * @return
     */
    private String[] getStringArray(String columnValue) {
        if (columnValue == null) {
            return null;
        }
        return columnValue.split(",");
    }
}
