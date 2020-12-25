import com.hello.pojo.User;
import com.hello.pojo.Users;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
//两个无返回值函数
//1.按id查找
//2.查找全部

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Select {
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
        System.out.println(user.getUser_name());
        //关闭session
        session.close();

    }
    @Test
    public void SelectAllTest()
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
        ArrayList<User> user_list = new ArrayList<User>();

        Users userlist = new Users();

        //输出结果
        for(User a:list)
        {
            user_list.add(a);
            System.out.print(a.getUser_id());
            System.out.print("  ");
            System.out.print(a.getUser_name());
            System.out.print("  ");
            System.out.println(a.getEmails());
        }
        userlist.setList(user_list);
        //关闭session
        session.close();


    }
}