package monkey.aop;

public class CbuServiceMockImpl implements CbuServiceMockInterface{
	
	@ServiceForCBU(getMemberMethod = "getMemberId",replaceMemberMethod="setMemberId", memberInfo = "monkey.aop.CrmMemberInfo", index=0)
	public void createOrder(CrmMemberInfo member, Order order) {
		System.out.println("���������ɹ� ���������:"+order.getOrderNo()+";"+"�ö����Ŀͻ�memberId:"+member.getMemberId()); 
	}

	public void createAccount(String memberId, Account acount) {
		System.out.println("Ϊ�ͻ�:"+memberId+"�����˻��ɹ� ���˻����:"+acount.getAccountNo()+";"); 
	}

	public void searchOrderByMember(CrmMemberInfo member, String orderNo) {
		System.out.println("�ͻ�:"+member.getMemberId()+"������Ϊ:"+orderNo+"�Ķ�����ѯ�ɹ�"); 
		
	}

	public void searchOrderByid(String memberId, String orderNo) {
		System.out.println("�ͻ�:"+memberId+"������Ϊ:"+orderNo+"�Ķ�����ѯ�ɹ�; ����:searchOrderByid"); 
	}

}
