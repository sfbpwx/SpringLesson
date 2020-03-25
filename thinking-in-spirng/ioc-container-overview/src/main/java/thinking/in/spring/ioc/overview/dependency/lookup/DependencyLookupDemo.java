package thinking.in.spring.ioc.overview.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import thinking.in.spring.ioc.overview.dependency.annotation.Super;
import thinking.in.spring.ioc.overview.dependency.domain.User;

import java.util.Map;

/**
 * 依赖查找样例
 */
public class DependencyLookupDemo {


    public static void main(String[] args){
        //配置xml
        //启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-look-up-context.xml");
//        //实时查找
        lookupInrealTime(beanFactory);
//        //延时查找
        lookupInLazy(beanFactory);
        //按照类型查找
        lookupByType(beanFactory);
        //按照集合对象类型查找
        lookupByCollectionByType(beanFactory);
        //通过注解方式查找
        lookupByAnnotationType(beanFactory);
    }

    /**
     * 实时查询
     * @param beanFactory
     */
    private static void lookupInrealTime(BeanFactory beanFactory){
        //老版本强转型
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找"+user.toString());
    }

    /**
     * 非实时查询
     * @param beanFactory
     */
    private  static void lookupInLazy(BeanFactory beanFactory){
        ObjectFactory<User> objectFactory = (ObjectFactory)beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找:"+user);
    }

    /**
     * 按照类型查询
     * @param beanFactory
     */
    private static void lookupByType(BeanFactory beanFactory){
        User user = beanFactory.getBean(User.class);
        System.out.println("实时查找"+user.toString());
    }

    /**
     * 按照几何分类查询
     * @param beanFactory
     */
    private static void lookupByCollectionByType(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String,User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找所有的User集合对象："+userMap);
        }
    }

    /**
     * 按照注解方式查询
     * @param beanFactory
     */
    private static void lookupByAnnotationType(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String,User> userMap = (Map)listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找所有标注Super的User集合对象："+userMap);
        }
    }
}
