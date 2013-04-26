package services.trasce.study;

import org.testng.annotations.Test;

import monkey.common.base.BaseTest;
import monkey.services.trace.study.OrderService;

public class OrderServiceImplTest extends BaseTest{
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@Test
	public void doBizOrderTest(){
		try {

			orderService   = (OrderService) context.getBean("orderService");
			orderService.doBizOrder() ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String[] initBizContext() {;
		String [] s = new String[]{"conf/biz-services.xml","conf/biz-bo.xml","conf/biz-aop.xml"} ;
		return s  ;
	//return null;
	}

}
