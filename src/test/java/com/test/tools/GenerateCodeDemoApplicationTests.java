package com.test.tools;

import com.lwt.tools.Tools;
import com.lwt.tools.model.GenerateParam;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GenerateCodeDemoApplication.class)
class GenerateCodeDemoApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() {
        String path = this.getClass().getResource("").getPath().replace("target/test-classes/", "src/main/java/").substring(1);
        GenerateParam param = new GenerateParam(
                path,//启动类的路径
                "t_system_user",//需要生成代码的数据库表名
                "Gino",//作者名
                dataSource,//数据库DataSource
                //是否使用Swagger
                true,
                //  自定义目录，可选属性，如果没有该属性默认将生成的代码放入默认
                //  目录（插件默认会添加domian、mapper、controller、service(含service下的impl)以及在resources目录下添加mybatis文件夹）
                "system"
        );
        try {
            new Tools().generatorCode(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
