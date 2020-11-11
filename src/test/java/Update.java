import com.hello.pojo.User;
import java.util.ArrayList;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Update {
    @Test
    public void UpdateById(){
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

        List<User> listBefore = new ArrayList<User>();
        listBefore=session.selectList("findAll");
        //记录修改前状态

        int i = 4;
        session.update("updateById",i);
        session.commit();

        List<User> listAfter = new ArrayList<User>();
        listAfter=session.selectList("findAll");
        //输出结果
        System.out.println("修改之前的users表为");
        for(User a:listBefore)
        {
            System.out.print(a.getUid());
            System.out.print("  ");
            System.out.print(a.getUname());
            System.out.print("  ");
            System.out.println(a.getUage());
        }

        System.out.println("修改之前的users表为");
        for(User a:listAfter)
        {
            System.out.print(a.getUid());
            System.out.print("  ");
            System.out.print(a.getUname());
            System.out.print("  ");
            System.out.println(a.getUage());
        }

        //输出结果
        System.out.println("删除成功");
        //关闭session
        session.close();

    }
}