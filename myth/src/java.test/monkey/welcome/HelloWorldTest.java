package monkey.welcome;

import monkey.common.base.BaseTest;

import org.testng.annotations.Test;

public class HelloWorldTest extends BaseTest{
//	@BeforeClass
//	public void init(){
//
//	}

	@Test
	public void sayHelloWordTest(){
		HelloWorld  world = (HelloWorld) context.getBean("helloBean");
		world.sayHelloWord() ;

	}

	@Override
	public String[] initBizContext() {
		// TODO Auto-generated method stub
		return null;
	}

}
