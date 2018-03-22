package com.archon.util;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Base {
    private static  String DRIVER;
    private static String URL;
    private static String USER_NAME;
    private static String PASSWORD;
    private static String QUERY_TABLE_NAMES;
    private static String QUERY_TABLE_FIELDS;


    static {
        init();
    }


    /**
     * do property
     */
    private static void init(){

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            ResolveTables resolveTables = new ResolveTables();
            saxParser.parse(new File("src/main/resources/config.xml"),resolveTables);
            DRIVER = resolveTables.getDriver();
            URL = resolveTables.getUrl();
            USER_NAME = resolveTables.getUserName();
            PASSWORD = resolveTables.getPassword();
            QUERY_TABLE_NAMES = resolveTables.getQueryTableNames();
            QUERY_TABLE_FIELDS = resolveTables.getQueryTableFields();
            Class.forName(DRIVER);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    /**
     *get connection
     * @return conn Connection
     */
    private Connection getConn(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     *get table Name from database
     * @return nameList List<String>
     */
    public List<String> queryTableName(){
        List<String> list = new ArrayList<>();
        Connection conn = getConn();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(QUERY_TABLE_NAMES);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null)
                return list;
            while (resultSet.next()){
                String table_name = resultSet.getString("table_name");
                list.add(table_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(preparedStatement,resultSet,conn);
        }
        return list;

    }

    /**
     * get fields from database
     * @param tableName String
     * @return  hashMap<String,String> field&type with field as key and type as value;
     * auto distinguish Integer&Double for example number(11) as Integer and number(11,2) as Double
     */
    public LinkedHashMap<String,String> queryFields(String tableName){
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        Connection conn = getConn();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(QUERY_TABLE_FIELDS);
            preparedStatement.setObject(1,tableName);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null)
                return map;
            while (resultSet.next()){
                String str = resultSet.getString("COLUMN_NAME");
                String type = resultSet.getString("DATA_TYPE");
                String data_scale = resultSet.getString("DATA_SCALE");

                if(data_scale != null && Integer.parseInt(data_scale) > 0){
                    type = "NUMBER2";
                }
                map.put(str,type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(preparedStatement,resultSet,conn);
        }
        return map;

    }


    /**
     * close sourses and streams
     * @param ps PreparedStatement
     * @param rs ResultSet
     * @param conn Connection
     */
    private void close(PreparedStatement ps,ResultSet rs,Connection conn){
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
