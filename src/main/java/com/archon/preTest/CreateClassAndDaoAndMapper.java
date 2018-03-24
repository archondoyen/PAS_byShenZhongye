package com.archon.preTest;
import org.mybatis.generator.ant.GeneratorAntTask;
/*id的类型是long或者Decimal,有点难用*/
public class CreateClassAndDaoAndMapper {
    public static void main(String[] args) {
        try {
            GeneratorAntTask task = new GeneratorAntTask();
            //配置文件的路径。
            String genCfg = "src/main/resources/poAndSqlConfig.xml";
            task.setConfigfile(genCfg);  //（配置文件具体path）
            task.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}