package com.hello.controller;

import com.hello.pojo.User;
import com.hello.pojo.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Select {
    public User user;
    public ArrayList<User> list;
    public void  setList(ArrayList<User> list){list = this.list;}
    public ArrayList<User> getList(ArrayList<User> list){return list;}
    public static void main(String[] args) {

    }
    @Test
    public void userFindByIdTest(){
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
        User user=session.selectOne("findById",1);
        //输出结果
        System.out.println(user.getUname());
        //关闭session
        session.close();

    }
    @Test
    public List<User> SelectAllTest()
//    public void SelectAllTest()
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
        List<User> list = new ArrayList<User>();
        list=session.selectList("findAll");

        //输出结果
        for(User a:list)
        {
            System.out.print(a.getUid());
            System.out.print("  ");
            System.out.print(a.getUname());
            System.out.print("  ");
            System.out.println(a.getUage());
        }
        //关闭session
        session.close();
        return list;


    }
}