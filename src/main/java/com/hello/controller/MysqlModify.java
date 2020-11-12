package com.hello.controller;

import com.hello.pojo.Table;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
public class MysqlModify {
@Test
    public void ShowTables()
    {
        //定义读取文件名
        String resources = "mybatis-config.xml";
        //创建流
        Reader reader=null;
        try {
            //读取mybatis-config.xml文件到reader对象中
            reader= Resources.getResourceAsReader(resources);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //初始化mybatis,创建SqlSessionFactory类的实例
        SqlSessionFactory sqlMapper=new SqlSessionFactoryBuilder().build(reader);
        //创建session实例
        SqlSession session=sqlMapper.openSession();
        List<HashMap> list = new ArrayList<HashMap>();
        //传入参数查询，返回结果
//        session.insert("Insert");
//        session.commit();
        String st = "";
        st = session.selectOne("ShowTables");
//        list =session.selectList("ShowTables");
        //输出结果
//        System.out.println(list.size());
        System.out.println(st);
        //关闭session
//        for(HashMap a:list)
//            for(Object key:a.keySet())
//            {
//                System.out.println(a.get(key));
//            System.out.print(a.get("name"));
//            System.out.print("  ");
//            System.out.print(a.getName());
//            System.out.print("  ");
//            System.out.println(a.getDescrib());
//        }
        session.close();
        //return  list;

    }

}
