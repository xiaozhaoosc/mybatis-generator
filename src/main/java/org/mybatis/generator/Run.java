package org.mybatis.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by wuwen on 2017/5/9.
 */
public class Run {

    static ConfigurationParser cp = null;
    static Configuration config = null;


    public static void main(String[] args) {
        try {
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            //File configFile = new File("./src/main/resource/db/generatorConfig-oracle.xml");
            File configFile = new File("./src/main/resource/db/generatorConfig-mysql.xml");
            cp = new ConfigurationParser(warnings);
            config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null, null, null, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
