package com.hello.controller;

import com.hello.pojo.Word;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class WordController{
    public Word word;
    public ArrayList<Word> list;
    public void  setList(ArrayList<Word> list){list = this.list;}
    public ArrayList<Word> getList(ArrayList<Word> list){return list;}
    public static void main(String[] args) {
       // List<Word>

    }
@Test
    public void wordFindByIdTest(){
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
        //传入参数查询，返回结果
        List<Word> w=new ArrayList<Word>();
        w = session.selectList("findAllWord");
    System.out.println(w.size());
        //输出结果
    for (Word ws:w)
        System.out.println(ws.getWord_name());
        //关闭session
        session.close();

    }

    public List<Word> SelectAllTest()

    {
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
        //传入参数查询，返回结果
        List<Word> list = new ArrayList<Word>();
        list=session.selectList("findAllWord");

        //输出结果
//        for(Word a:list)
//        {
//            System.out.print(a.getWord_id());
//            System.out.print("  ");
//            System.out.print(a.getWord_name());
//            System.out.print("  ");
//            System.out.println(a.getWord_meaning());
//            System.out.print("  ");
//            System.out.println(a.getWord_buchong());
//        }
        //关闭session
        session.close();
        return list;
    }
}