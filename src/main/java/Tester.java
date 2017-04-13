import javafx.scene.shape.Arc;
import myapp.persistence.dao.*;
import myapp.persistence.entities.*;
import myapp.pojo.Response;
import myapp.services.convertors.ArchitectorConverter;
import myapp.services.convertors.Fields;
import myapp.services.utils.*;
import myapp.services.validators.MD5PasswordEncoder;
import myapp.views.DepartmentView;
import myapp.views.OrdererView;
import myapp.views.UserView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ejb.NoSuchEntityException;
import javax.naming.event.ObjectChangeListener;
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
        DepartmentEntity department=new DepartmentEntity();
        department=departmentDao.get(1);

        //department=departmentDao.get(1);
        //System.out.println(department.toString());
        //userDao.insert(user);
        ArchitectorDao architectorDao=(ArchitectorDao)context.getBean("architectorDao");
       // architector=architectorDao.get(1);
        //System.out.println(architector.toString());
        DirectorDao directorDao=(DirectorDao)context.getBean("directorDao");
//        DirectorEntity director=new DirectorEntity(0,2,1,"Goryachok Mary","Cvetaevoj 15",null,0);
        //directorDao.insert(director);
        ArchitectorService architectorService=(ArchitectorService) context.getBean("architectorService");
       // architectorService.getAllArchitectors(0,0);


//        Set<String> field=new HashSet<String>();
//        field.add("departmentemail");
//        field.add("pib");
//        ArchitectorConverter architectorConverter=new ArchitectorConverter();
//
//
//        ArchitectorEntity architectorEntity=new ArchitectorEntity();
//        architectorEntity.setPib("Poliakov Anna Anatoliivna");
//        architectorEntity.setHours(0);
//        UserEntity user=new UserEntity();
//        user.setLogin("hello2");
//        user.setPassword("12345");
//        architectorEntity.setUserEntity(user);
        //architectorDao.insert(architectorEntity);
//        architectorEntity.setEmail("panna1999@yandex.ru");
//        architectorService.updateArchitector(architectorEntity);
//        System.out.println(architectorEntity.toString());
//        OrdererDao ordererDao=(OrdererDao) context.getBean("ordererDao");
//        OrdererService ordererService=(OrdererService) context.getBean("ordererService");
//        OrdererEntity ordererEntity1=ordererService.getOrdererById(1);
        //System.out.println(ordererEntity1.toString());
//        System.out.println(ordererEntity1.toString());
//        ordererEntity1.setPib("HELLO");
//        System.out.println(ordererEntity1.toString());
//        ordererService.updateOrderer(ordererEntity1);
//        System.out.println(ordererEntity1.toString());

        //ordererDao.insert(ordererEntity);
        //ordererDao.remove(ordererEntity);
//        OrdererView ordererView=new OrdererView();
//        ordererView.setId_orderer(1);
//        ordererView.setId_user(9);
//        ordererView.setId_department(1);
//        ordererView.setPib("Poliakova Anna");
//        ordererView.setCompany_name("Love");
//        UserView userView=new UserView();
//        userView.setLogin("turnhandup3");
//        userView.setPassword("12345");
//        userView.setId_user(ordererView.getId_user());
//        ordererView.setUserView(userView);
//        DepartmentView departmentView=new DepartmentView();
//        departmentView.setEmail("terranova@gmail.com");
//        departmentView.setAddress("Cvetaevoj 14B");
//        departmentView.setPhonenumber("=38083580185");
//        departmentView.setId_department(ordererView.getId_department());
//        ordererView.setDepartmentView(departmentView);
//        System.out.println("USERVIEW "+userView.toString());
//        OrdererEntity ordererEntity=ordererService.updateOrderer(ordererView);
//        System.out.println("ENTITY"+ordererEntity.toString());


//        UserEntity userEntity=new UserEntity();
//        DirectorDao directorDao1=(DirectorDao) context.getBean("directorDao");
//        DirectorEntity directorEntity=directorDao.get(6);
//        directorDao.remove(directorEntity);
//        OrdererView ordererView=new OrdererView();
//        ordererView.setId_department(1);
//        ordererView.setPib("Glybovets Mykola");
//        ordererView.setEmail("glyb@yandex.ru");
//        ordererView.setAddress("Obolon");
//        ordererView.setCompany_name("Epum");
//        ordererView.setPassport_data("KD123456");
//        UserView userView=new UserView();
//        userView.setPassword("12345");
//        userView.setLogin("glybovets");
//        ordererView.setUser(userView);
//        OrdererService ordererService1=(OrdererService) context.getBean("ordererService");
//        ordererService.create(ordererView);
//        System.out.println( ordererService.create(ordererView));
        //System.out.println(ordererService1.getOrdererById(id));
//        Set<String> field2=new HashSet<String>();
//        field2.add("id_architector");
//        field2.add("id_object");
//        field2.add("status");
//        ObjectService objectService=(ObjectService) context.getBean("objectService");
//        List<Map<String, Object>> object=objectService.getAllObjectsByArchitectorMap(0,0,1,field2);
//        for(Map<String,Object> l:object){
//            System.out.println(l.values());
//        }
//        ObjectDao objectDao = (ObjectDao) context.getBean("objectDao");
//        List<ObjectEntity> object2=objectDao.getObjectByArchitector(1);
//        for(ObjectEntity l:object2){
//            System.out.println(l.toString());
//        }

//        OrderEntity oe = new OrderEntity();
//        oe.setHours(25);
//        oe.setObjects(1);
//        oe.setWorkers(2);
//        oe.setSalary(20000);
//        oe.setId_orderer(1);
//        oe.setOrderer_id_department(1);

        CustomQueriesDao cq=(CustomQueriesDao)context.getBean("customQueries");
//        orderDao.insert(oe);
//        OrderEntity oe = orderDao.getById(2);
//        System.out.println(oe.toString());
//        oe.setSalary(25000);
//        orderDao.update(oe);
        System.out.println(cq.workDone().toString());


    }
}
