package monkey.aop;

import java.math.BigDecimal;

public interface CbuServiceMockInterface {
	
	
	public void createOrder(CrmMemberInfo member , Order order) ;
	
	public void createAccount(String memberId, Account account) ; 
	
	public void searchOrderByMember(CrmMemberInfo member, String orderNo) ; 
	
	public void searchOrderByid(String memberId , String orderNo) ; 
	


}

class CrmMemberInfo {
	
	private String name ;
	private String memberId ; 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	
}

class Order {
	
	private String orderNo ; 
	private String memberId  ; 
	
	private BigDecimal amount  ;
	
	private long salesNo  ; 
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public long getSalesNo() {
		return salesNo;
	}
	public void setSalesNo(long salesNo) {
		this.salesNo = salesNo;
	}

	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

}
class Account {
	private String accountNo  ;

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	} 
	
	
}