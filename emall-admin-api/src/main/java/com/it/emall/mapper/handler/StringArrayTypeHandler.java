package com.it.emall.mapper.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author libingyang
 * @create 2023/1/13 15:36
 */

/**
 * Mybatis的类型处理器:varchar <---> String[]
 */
@Component
public class StringArrayTypeHandler implements TypeHandler<String[]> {

    // Jackson的json解析工具对象
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType) throws SQLException {
        // String[] 转换为json数组
        String json = "[]";
        try {
            json = objectMapper.writeValueAsString(parameter);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        ps.setString(i,json);
    }

    @Override
    public String[] getResult(ResultSet rs, String columName) throws SQLException {
        String json = rs.getString(columName);
        String[] arr = new String[0];
        try {
            arr = objectMapper.readValue(json,String[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return arr;
    }

    @Override
    public String[] getResult(ResultSet rs, int columIndex) throws SQLException {
        String json = rs.getString(columIndex);
        String[] arr = new String[0];
        try {
            arr = objectMapper.readValue(json,String[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return arr;
    }

    @Override
    public String[] getResult(CallableStatement cs, int columIndex) throws SQLException {
        String json = cs.getString(columIndex);
        String[] arr = new String[0];
        try {
            arr = objectMapper.readValue(json,String[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return arr;
    }
}
