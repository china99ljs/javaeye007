package monkey.services.trace.study.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import monkey.services.trace.study.OrderService;
import monkey.services.trace.study.bo.AccountBo;
import monkey.services.trace.study.bo.OrderBo;

public class OrderServiceImpl implements OrderService{

	Logger logger  = LoggerFactory.getLogger(OrderServiceImpl.class)  ;
	private OrderBo  orderBo;
	private AccountBo accountBo ;
	
	private static String ss ; 

	public void setOrderBo(OrderBo orderBo) {
		this.orderBo = orderBo;
	}

	public void setAccountBo(AccountBo accountBo) {
		
		this.accountBo = accountBo;
	}


	@Override
	public String doBizOrder() throws Exception {
		// TODO Auto-generated method stub
		logger.debug("start orderService ....") ;
		System.out.println("start orderService ....") ;

		logger.debug("start orderService ....") ;
		orderBo.doBizOrder() ;
		accountBo.doBizAccount() ;
		logger.debug("end orderService ....") ;

		return null ;
	}
	
	private String test(){
//		String temp = "aaaaa" ; 
		String temp = new String("aaaaa") ; 
		return temp ;
	}
	
	public static void main(String args[]){
		
		OrderServiceImpl t = new OrderServiceImpl();
		OrderServiceImpl t1 = new OrderServiceImpl();
		System.out.println(t.test().hashCode());
		System.out.println(t1.test().hashCode());
		
		
	}
			

}
