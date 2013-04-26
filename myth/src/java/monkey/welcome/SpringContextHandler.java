package monkey.welcome;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringContextHandler {

	public void init(){

        Resource rs =
            new ClassPathResource("beans-config.xml");
        BeanFactory factory = new XmlBeanFactory(rs);

        HelloWorld hello =
            (HelloWorld) factory.getBean("helloBean");
        System.out.println(hello.getHelloStr());

	}
}