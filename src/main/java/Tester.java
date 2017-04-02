import myapp.persistence.dao.DepartmentDao;
import myapp.persistence.dao.UserDao;
import myapp.persistence.entities.DepartmentEntity;
import myapp.persistence.entities.UserEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Created by PANNA on 01.04.2017.
 */
public class Tester {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("SpringBeans.xml");


        UserDao userDao=(UserDao)context.getBean("userDao");
        DepartmentDao departmentDao=(DepartmentDao)context.getBean("departmentDao");
        UserEntity user=new UserEntity("turnhandup1","12345",1,1);
        DepartmentEntity department=new DepartmentEntity(0, "Kyiv, Cvetaevoj 14B", "panna1997@yandex.ru", "+380638508525");
//        departmentDao.insert(department);
        //userDao.remove(user);
    }
}
