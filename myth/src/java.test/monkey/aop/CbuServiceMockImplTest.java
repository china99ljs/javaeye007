package monkey.aop;

import java.math.BigDecimal;

import monkey.common.base.BaseTest;

import org.testng.annotations.Test;

public class CbuServiceMockImplTest extends BaseTest{

	private CbuServiceMockImpl cbuService;

	public CbuServiceMockImpl getCbuService() {
		return cbuService;
	}

	public void setCbuService(CbuServiceMockImpl cbuService) {
		this.cbuService = cbuService;
	}

	@Test
	public void doBizOrderForCbuTest(){
		try {
			CrmMemberInfo member = new CrmMemberInfo() ; 
			member.setMemberId("china99ljs") ;
			
			
			Order order  = new Order() ; 
			order.setOrderNo("1111111111111111111") ;
			order.setAmount(new BigDecimal(1688)); 
			order.setMemberId("china99ljs") ;
			order.setSalesNo(10805);
			
			cbuService   = (CbuServiceMockImpl) context.getBean("cbuService");
			cbuService.createOrder(member, order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void doBizOrderForICbuTest(){
		try {
			CrmMemberInfo member = new CrmMemberInfo() ; 
			member.setMemberId("messi") ;
			
			
			Order order  = new Order() ; 
			order.setOrderNo("22222222222222") ;
			order.setAmount(new BigDecimal(1688)); 
			order.setMemberId("messi") ;
			order.setSalesNo(10805);
			
			cbuService   = (CbuServiceMockImpl) context.getBean("cbuService");
			cbuService.createOrder(member, order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String[] initBizContext() {;
		String [] s = new String[]{"conf/biz-services.xml","conf/biz-aop.xml"} ;
		return s  ;
	//return null;
	}
	
	

}
