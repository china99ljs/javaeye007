package monkey.aop;

public class CbuServiceMockImpl implements CbuServiceMockInterface{
	
	@ServiceForCBU(getMemberMethod = "getMemberId",replaceMemberMethod="setMemberId", memberInfo = "monkey.aop.CrmMemberInfo", index=0)
	public void createOrder(CrmMemberInfo member, Order order) {
		System.out.println("创建订单成功 ，订单编号:"+order.getOrderNo()+";"+"该订单的客户memberId:"+member.getMemberId()); 
	}

	public void createAccount(String memberId, Account acount) {
		System.out.println("为客户:"+memberId+"创建账户成功 ，账户编号:"+acount.getAccountNo()+";"); 
	}

	public void searchOrderByMember(CrmMemberInfo member, String orderNo) {
		System.out.println("客户:"+member.getMemberId()+"订单号为:"+orderNo+"的订单查询成功"); 
		
	}

	public void searchOrderByid(String memberId, String orderNo) {
		System.out.println("客户:"+memberId+"订单号为:"+orderNo+"的订单查询成功; 方法:searchOrderByid"); 
	}

}
