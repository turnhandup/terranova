import myapp.persistence.dao.ArchitectorDao;
import myapp.persistence.dao.DepartmentDao;
import myapp.persistence.dao.DirectorDao;
import myapp.persistence.dao.UserDao;
import myapp.persistence.entities.ArchitectorEntity;
import myapp.persistence.entities.DepartmentEntity;
import myapp.persistence.entities.DirectorEntity;
import myapp.persistence.entities.UserEntity;
import myapp.services.validators.MD5PasswordEncoder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * Created by PANNA on 01.04.2017.
 */
public class Tester {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("SpringBeans.xml");


        UserDao userDao=(UserDao)context.getBean("userDao");
        DepartmentDao departmentDao=(DepartmentDao)context.getBean("departmentDao");
        //UserEntity user=new UserEntity();
        //user.setLogin("turnhandup5");
        //user.setPassword("123456");
        //user.setRole("USER");
        userDao.isValidUser("turnhandup","1212kolya1212");
        DepartmentEntity department=new DepartmentEntity();
        //department=departmentDao.get(1);
        //System.out.println(department.toString());
        //userDao.insert(user);
        ArchitectorDao architectorDao=(ArchitectorDao)context.getBean("architectorDao");
        ArchitectorEntity architector=new ArchitectorEntity(0,1,"Poliakova Anna Anatoliivna",0,0,null,null);
       // architector=architectorDao.get(1);
        //System.out.println(architector.toString());
        DirectorDao directorDao=(DirectorDao)context.getBean("directorDao");
        DirectorEntity director=new DirectorEntity(0,2,1,"Goryachok Mary","Cvetaevoj 15",null,0);
        //directorDao.insert(director);
        MD5PasswordEncoder encoderMD5 = new MD5PasswordEncoder();
        String securePass = encoderMD5.encodePassword("123456", null);
        System.out.println(encoderMD5.encodePassword("123456",null));
        System.out.println(encoderMD5.isPasswordValid(securePass,"12345", null));
    }
}
