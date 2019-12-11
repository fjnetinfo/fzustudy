import com.lhn.pojo.Student;
import com.lhn.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void Test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());
    }

    @Test
    public void Test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");

        User user = context.getBean("user", User.class);
        System.out.println(user.toString());

        User user2 = context.getBean("user2", User.class);
        User user3 = context.getBean("user2", User.class);
        System.out.println(user2.toString());

        System.out.println(user == user2);
        System.out.println(user2 == user3);
    }

}
