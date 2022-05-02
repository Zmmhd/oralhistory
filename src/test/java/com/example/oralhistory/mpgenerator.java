package com.example.oralhistory;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Test;
import org.springframework.boot.autoconfigure.security.SecurityDataConfiguration;

import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/01/11:13
 * @Description:
 */
public class mpgenerator {

    @Test
    public void run(){

        FastAutoGenerator.create("jdbc:mysql://112.74.46.133:3306/oral_history?serverTimezone=UTC", "root", "dachuang")
                .globalConfig(builder -> {
                    builder.author("Zmm") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D://projects//IdeaProjects//oralhistory//src//main//java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example.oralhistory") // 设置父包名
                            .moduleName("") // 设置父包模块名
                            .entity("entity")
                            .controller("controller")
                            .service("service")
                            .serviceImpl("impl")
                            .pathInfo(Collections.singletonMap(OutputFile.mapper.xml, "D://projects//IdeaProjects//oralhistory//src//main//resources")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addTablePrefix("tb_") // 设置过滤表前缀
                            .serviceBuilder()//Service配置
                            .formatServiceFileName("%sService")//%s = 表名  表名Service
                            .formatServiceImplFileName("%sServiceImp")//同上
                            .entityBuilder()//实体类配置 一般都是表名
                            .enableLombok()//开启Lombok 开启 swagger 模式 就没必要使用这个
                            .logicDeleteColumnName("deleted")//逻辑删除字段对应数据库那个字段
                            .logicDeletePropertyName("deleted")//逻辑删除字段对应实体类库那个字段
                            .controllerBuilder()//Controller配置
                            .formatFileName("%sController")
                            .enableRestStyle()//开启生成@RestController控制器
                            .mapperBuilder()//mapper配置
                            .formatMapperFileName("%sMapper")
                            .formatXmlFileName("%sMapper")
                            .enableMapperAnnotation()//开启@Mapper
                            .superClass(BaseMapper.class);//继承的父类
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}
