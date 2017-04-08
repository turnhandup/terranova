import javafx.scene.shape.Arc;
import myapp.persistence.dao.ArchitectorDao;
import myapp.persistence.dao.DepartmentDao;
import myapp.persistence.dao.DirectorDao;
import myapp.persistence.dao.UserDao;
import myapp.persistence.entities.ArchitectorEntity;
import myapp.persistence.entities.DepartmentEntity;
import myapp.persistence.entities.DirectorEntity;
import myapp.persistence.entities.UserEntity;
import myapp.pojo.Response;
import myapp.services.convertors.ArchitectorConverter;
import myapp.services.convertors.Fields;
import myapp.services.utils.ArchitectorService;
import myapp.services.utils.ArchitectorServiceImpl;
import myapp.services.utils.ResponseFactory;
import myapp.services.validators.MD5PasswordEncoder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ejb.NoSuchEntityException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        ArchitectorService architectorService=(ArchitectorService) context.getBean("architectorService");
       // architectorService.getAllArchitectors(0,0);


        Set<String> field=new HashSet<String>();
        field.add("id_architector");
        field.add("pib");
        ArchitectorConverter architectorConverter=new ArchitectorConverter();

        ArchitectorEntity architectorEntity=new ArchitectorEntity();
        architectorEntity=architectorDao.get(1);
        System.out.println(architectorEntity.toString());
        architectorEntity.setEmail("panna1999@yandex.ru");
        architectorService.updateArchitector(architectorEntity);
        System.out.println(architectorEntity.toString());

    }
}
