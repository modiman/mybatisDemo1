import com.hello.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class InsertInto {
    @Test
    public void InsertInto(){
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

        List<User> listBefore = new ArrayList<User>();
        listBefore=session.selectList("findAll");
        //记录修改前状态

        //传入参数查询，返回结果
        User user_hm = new User();
        user_hm.setUser_id(0);
        user_hm.setUser_name("zozo");

        session.insert("InsertInto",user_hm);
        session.commit();
        //User user=session.selectOne("findById",1);
        //输出结果
        List<User> listAfter = new ArrayList<User>();
        listAfter=session.selectList("findAll");
        //输出结果
        System.out.println("修改之前的users表为");
        for(User a:listBefore)
        {
            System.out.print(a.getUser_id());
            System.out.print("  ");
            System.out.print(a.getUser_name());
            System.out.print("  ");
            System.out.println(a.getEmails());
        }

        System.out.println("修改之后的users表为");
        for(User a:listAfter)
        {
            System.out.print(a.getUser_id());
            System.out.print("  ");
            System.out.print(a.getUser_name());
            System.out.print("  ");
            System.out.println(a.getEmails());
        }
        if (listBefore.size()<listAfter.size())
            System.out.println("删除成功");
        else
            System.out.println("删除失败");
      //  System.out.println(user.getUname());
        //关闭session
        session.close();

    }
}

