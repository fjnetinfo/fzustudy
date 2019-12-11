import com.lhn.dao.UserDaoImpl;
import com.lhn.dao.UserDaoMySQLImpl;
import com.lhn.dao.UserDaoOracleImpl;
import com.lhn.service.UserService;
import com.lhn.service.UserServiceImpl;

public class MyTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        ((UserServiceImpl) userService).setUserDao(new UserDaoImpl());
        userService.getUser();
        ((UserServiceImpl) userService).setUserDao(new UserDaoMySQLImpl());
        userService.getUser();
        ((UserServiceImpl) userService).setUserDao(new UserDaoOracleImpl());
        userService.getUser();
    }
}
