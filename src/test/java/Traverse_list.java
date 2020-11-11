import com.hello.pojo.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Traverse_list {
    //List<User> list = new ArrayList<User>();

    public static void main(String[] args) {
        List<User> list = new ArrayList<User>();
        for(int i=1;i<5;i++)
        {
            User user = new User();
            user.setUid(i);
            user.setUname("modige"+i);
            user.setUage(i*i);
            list.add(user);
        }
        //高级for循环
        for(User a:list)
        {
            System.out.print(a.getUid());
            System.out.print("  ");
            System.out.print(a.getUname());
            System.out.print("  ");
            System.out.println(a.getUage());
        }
        //低级for循环
        for(int i=0;i<list.size();i++)
        {
            User user = (User)list.get(i);
            System.out.println(user.getUname());
        }
        //迭代器
        Iterator<User> item = list.iterator();
        while(item.hasNext())
        {
            User user = (User) item.next();
            System.out.println(user.getUname());
        }

    }
}
