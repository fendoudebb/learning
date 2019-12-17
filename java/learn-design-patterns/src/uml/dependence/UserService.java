package uml.dependence;

/**
 * dependence: 依赖关系
 * UserService在类中用到了UserDao, User
 */
public class UserService {

    private UserDao userDao;

    //可以是构造，也可以用Spring注入
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser(User user) {
        userDao.save(user);
    }

}
