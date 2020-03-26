package thinking.in.spring.ioc.overview.dependency.injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import thinking.in.spring.ioc.overview.dependency.annotation.Super;
import thinking.in.spring.ioc.overview.dependency.domain.User;
import thinking.in.spring.ioc.overview.dependency.repository.UserRepository;

import java.util.Map;

/**
 * 依赖查找样例
 */
public class DependencyInjectionDemo {


    public static void main(String[] args){
        //配置xml
        //启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");
        UserRepository userRepository = beanFactory.getBean("userRepository",UserRepository.class);
//        System.out.println(userRepository.getUsers());
        //依赖注入（是否来自于同一个地方）
        System.out.println(userRepository.getBeanFactory());
//        System.out.println(userRepository.getBeanFactory() == beanFactory);
        //依赖查找
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        ObjectFactory objectFactory = userRepository.getUserObjectFactory();
        System.out.println(objectFactory.getObject());
    }

}
