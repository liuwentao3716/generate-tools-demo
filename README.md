#  自动代码生成工具使用说明
## 声明
   本插件完全由个人为减少发开代码量，提升开发效率自行开发，其中存在诸多不方便之处，若各位大神有好的建议或意见，欢迎留言讨论，以便后期完善更新。但不喜欢的请嘴下留情(给新人留点成长的机会)，请勿乱喷。同时，若本项目中有侵权内容，请联系我，我看见后会第一时间处理。
## 插件说明
   本插件基于Java开发语言，借助JUnit测试类，并通过简单的配置，帮助程序员们在实际项目开发中直接(根据数据库表、字段、字段描述)生成代码，提升项目开发速度。其生成代码包含
   Controller控制器、Service接口及其实现类、Dao持久层接口、表对应的实体类、Mapper.xml增删改查的代码，同时可以通过配置在代码中直接集成Swagger插件（复用demo中的全局异常处理和全局返回类的，生成代码可以直接运行，未复用的需做适当修改）。
   本插件目前只支持MySQL数据库，下个版本添加PgSQL和ORACLE支持。
## 配置文件引入
   引入generate-tools的jar包,jar包暂时未上传，请手动下载([点此下载jar包](https://www.baidu.com))
## 配置扫描路径
   本插件在使用时需要配置扫描路径，如果为springBoot项目需要在启动类添加注解@ComponentScan({"com.lwt.tools"});如果非Springboot项目，需要配置扫描路径com.lwt.tools。
## 使用插件
*  编写测试类


    package com.lwt.test;
    import com.lwt.generate.Tools;
    import com.lwt.generate.model.GenerateParam;
    import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.context.SpringBootTest;
    import org.springframework.test.context.junit4.SpringRunner;
    
    import javax.sql.DataSource;
    
    @RunWith(SpringRunner.class)
    @SpringBootTest(classes = TestPojectApplication.class)
    public class TestPojectApplicationTests {
    
        /**
         * 插件需要跟据传入的数据库表名，操作数据库完成代码生成，因此需要注入DataSource
         */
        @Autowired
        private DataSource dataSource;
    
        @Test
        public void contextLoads() throws Exception {
            //当前项目的目录   此处获取到的是项目启动类的目录
            String path = this.getClass().getResource("").getPath().replace("target/test-classes/", "src/main/java/").substring(1);
            //创建代码生成需要的对象
            GenerateParam param = new GenerateParam(
                    path,//启动类的路径
                    "t_system_user",//需要生成代码的数据库表名
                    "Gino",//作者名
                    dataSource,//数据库DataSource
                    true,//是否使用Swagger,不设置该属性，则默认为false即不使用swagger
                    //  自定义目录，可选属性，如果没有该属性默认将生成的代码放入默认
                    //  目录（插件默认会添加domian、mapper、controller、service(含service下的impl)以及在resources目录下添加mybatis文件夹）
                    "test"
            );
            new Tools().generatorCode(param);
        }
    
    }

*   备注  
1. 实例化GenerateParam参数对象时有三个构造方法 
    -   不启用sawggwer,且将代码放入tempLateSource参数指定的路径(有多级文件夹用"."分隔)  
    `GenerateParam(String basicPackage, String tableName, String author, DataSource dataSource, String tempLateSource)`  
    -   启用swaggwe,且将代码放入tempLateSource参数指定的路径(有多级文件夹用"."分隔)  
    `GenerateParam(String basicPackage, String tableName, String author, DataSource dataSource, boolean enabledSwagger, String tempLateSource)`
    -   不启用swagger，并将生成代码放入启用类所在路径
    `GenerateParam(String basicPackage, String tableName, String author, DataSource dataSource)`  
    -   启用swagger,并将生成代码放入启动类所在路径  
    `GenerateParam(String basicPackage, String tableName, String author, DataSource dataSource, Boolean enabledSwagger)`  
2.  由于我本人项目中自定义了分页插件和全局异常处理类及逻辑，因此在生成代码中也直接使用了该工具，如果您在使用的时候不需要这些，请您自行删除修改，相关问题下一版本处理。  
    -   全局异常处理类和全局返回类都在com.lwt.tools.utils文件夹中，复制到项目中即可
    
##  联系方式
>   邮箱：liuwentao3716@163.com
