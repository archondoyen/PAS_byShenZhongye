package com.archon.util;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GenerateEntity {
    private Base base;
    private Map<String,String> typeMap;


    public GenerateEntity() {
        base = new Base();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            ResolveTables resolveTables = new ResolveTables();
            saxParser.parse(new File("src/main/resources/config.xml"),resolveTables);
            typeMap = resolveTables.getMap();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    /**
     * get filename of ".Class" files
     * change first letter to upperCase;
     */
    public void start() throws Exception{
        List<String> list = base.queryTableName();
        for (String s : list) {
            LinkedHashMap<String, String> map = base.queryFields(s);
            LinkedHashMap<String,String> hashMap = new LinkedHashMap<>();
            for (String str : map.keySet()) {
                String s1 = map.get(str);
                String type = typeMap.get(s1.toUpperCase());
                if(type == null){
                    throw new Exception("type is null!");
                }
                hashMap.put(paresFieldName(str),type);
            }
            generateEntity(paresClassName(s),hashMap);
        }
    }

    /**
     * create "?.class" for entities
     * @param entityName String
     * @param map LinkedHashMap<String,String>
     */
    private void generateEntity(String entityName,LinkedHashMap<String,String> map) throws Exception {
        File file = new File("src/main/java/com/archon/po/" + entityName+".java");
        File file1 = new File("src/main/java/com/archon/po/");
        if(file.exists())
            throw new Exception(entityName+".class has already existed!");
        if(!file1.exists())
            file1.mkdirs();
        StringBuilder str = new StringBuilder();

        str.append("package com.archon.po;\n\n");
        str.append("import java.io.Serializable;\n");
        Collection<String> values = map.values();
        if(values.contains("BigDecimal"))
            str.append("import java.math.BigDecimal;\n");
        if(values.contains("Timestamp"))
            str.append("import java.sql.Timestamp;\n\n");
        //serializable
        str.append("public class "+entityName+" implements Serializable {\n\n");
        //字段
        for (String name: map.keySet()) {
            String newName = String.valueOf(name.charAt(0)).toLowerCase()+name.substring(1,name.length());
            if(name.toLowerCase().endsWith("password")){
                str.append("\tprivate transient "+map.get(name)+" "+newName+";\n");
            }else {
                str.append("\tprivate "+map.get(name)+" "+newName+";\n");
            }
        }
        str.append("\n");
        //无参构造方法
        str.append("\tpublic "+entityName+"() {\n\n\t}\n\n");
        //getter&setter
        for (String s : map.keySet()) {
            String field = s;
            String type = map.get(s);
            String newField = String.valueOf(field.charAt(0)).toLowerCase()+field.substring(1,field.length());
            String upField = String.valueOf(s.charAt(0)).toUpperCase()+s.substring(1,s.length());
            str.append("\tpublic "+type+" get"+upField+"() {\n\t\treturn "+newField+";\n\t}\n\n");
            str.append("\tpublic void set"+upField+"("+type+" "+newField+") {\n\t\tthis."+newField+" = "+newField+";\n\t}\n\n");
        }
        //toString
        str.append("\t@Override\n");
        str.append("\tpublic String toString() {\n");
        str.append("\t\treturn \""+entityName+"{\" +\n");
        for (String element : map.keySet()) {
            String newElement = String.valueOf(element.charAt(0)).toLowerCase()+element.substring(1,element.length());
            str.append("\t\t\t\t\" "+newElement+"=\" + "+newElement+" +\n");
        }
        str.append("\t\t\t\t\"}\";\n");
        str.append("\t}\n");
        str.append("}");
        //close
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            bw.write(str.toString().toCharArray());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Congratulations! "+entityName+".class has already completed!");
    }



    /**
     * change first letter of className to lowerCase;
     * @param className String
     * @return newClassName String
     */
    private String paresClassName(String className){
        if (className == null) {
            throw new NullPointerException();
        }
        String[] split = className.split("_");
        String str = "";
        for (String s : split) {
            if(s == null){
                break;
            }
            String s1 = s.trim().toLowerCase();
            str += String.valueOf(s1.charAt(0)).toUpperCase();
            str += s1.substring(1,s1.length());
        }

        return str.trim();
    }

    /**
     *
     * @param fieldName String
     * @return newFieldName String
     */
    private String paresFieldName(String fieldName){
        String s = paresClassName(fieldName);
/*        String str = String.valueOf(s.charAt(0));
        str += s.substring(1,s.length());*/
        return s.trim();

    }



}
