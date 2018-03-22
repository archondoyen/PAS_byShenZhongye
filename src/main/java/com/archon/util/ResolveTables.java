package com.archon.util;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;

public class ResolveTables extends DefaultHandler {
    private HashMap<String,String> map;
    private String driver;
    private String url;
    private String userName;
    private String password;
    private String tag;
    private String key;
    private String value;
    private String queryTableNames;
    private String queryTableFields;

    public HashMap<String, String> getMap() {
        return map;
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getQueryTableNames() {
        return queryTableNames;
    }

    public String getQueryTableFields() {
        return queryTableFields;
    }

    @Override
    public void startDocument() throws SAXException {
        map = new HashMap<>();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tag = qName;
        if("type".equals(qName)){
            for(int i = 0;i < attributes.getLength();i++){
                String qName1 = attributes.getQName(i);
                if("key".equals(qName1)){
                    key = attributes.getValue(i);
                }
                if("value".equals(qName1))
                    value = attributes.getValue(i);
            }
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        tag = null;
        if(key != null && value != null){
            map.put(key.toUpperCase(),value);
            key = null;
            value = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length);
        if(s != null && tag != null){
            if("driver".equals(tag))
                driver = s;
            if("url".equals(tag))
                url = s;
            if("userName".equals(tag))
                userName = s;
            if("password".equals(tag))
                password = s;
            if("queryTableNames".equals(tag))
                queryTableNames = s;
            if("queryTableFields".equals(tag))
                queryTableFields = s;
        }

    }

}
