package perf4j.study;

import monkey.common.base.BaseTest;

import org.testng.annotations.Test;

public class Perf4jStepTest extends BaseTest{

//	public void


	private Perf4jStep perfjStep  ;

	public void setPerfjStep(Perf4jStep perfjStep) {
		this.perfjStep = perfjStep;
	}



	@Test
	public void getMessageTest(){
		System.out.println("start...");
		perfjStep = (Perf4jStep) context.getBean("perfjStep") ;
		for (int i =0 ; i < 2 ; i ++)
			perfjStep.getMessage(10000, 1) ;
//		perfjStep.getMessage(10000, 2) ;
//		perfjStep.getMessage(10000, 3) ;

		try {
			//ÐÝÃß10Ãë
			Thread.sleep(10000) ;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end...");


	}
	@Override
	public String[] initBizContext() {
		String [] s = new String[]{"conf/biz-services.xml","conf/biz-bo.xml","conf/biz-aop.xml"} ;
		return s  ;
	}

}
