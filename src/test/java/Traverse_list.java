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
            user.setUser_id(i);
            user.setUser_name("modige"+i);
            user.setEmails(i*i);
            list.add(user);
        }
        //高级for循环
        for(User a:list)
        {
            System.out.print(a.getUser_id());
            System.out.print("  ");
            System.out.print(a.getUser_name());
            System.out.print("  ");
            System.out.println(a.getEmails());
        }
        //低级for循环
        for(int i=0;i<list.size();i++)
        {
            User user = list.get(i);
            System.out.println(user.getUser_name());
        }
        //迭代器
        Iterator<User> item = list.iterator();
        while(item.hasNext())
        {
            User user = item.next();
            System.out.println(user.getUser_name());
        }

    }
}
