package monkey.aop;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户messi 
 * 
 * memberId : messi 
 * uid : u1001
 * aliid :1001
 * belongto : ICBU
 * 
 * 用户raul 
 * 
 * memberId : raul 
 * uid : u1007
 * aliid :1007
 * belongto : ICBU
 * 
 * 用户: 小梁子
 * memberId : china99ljs 
 * uid : u2001
 * aliid :2001
 * belongto : CBU
 * */
public class HavanMemberCenter{
	private static Map memberMap = null ; 
	
	static {
		HaMemberInfo m1  = new HaMemberInfo() ; 
		m1.setAliId(1001) ;
		m1.setUid("u1001") ;
		m1.setMemberId("messi") ;
		m1.setComments("a super star of agren football ") ;
		m1.setBelongto("ICBU") ;
		
		HaMemberInfo m2  = new HaMemberInfo() ; 
		m2.setAliId(1007) ;
		m2.setUid("u1007") ;
		m2.setMemberId("raul") ;
		m2.setComments("a super star of spanish football ") ;
		m2.setBelongto("ICBU") ;
		
		
		
		HaMemberInfo m3  = new HaMemberInfo() ; 
		m3.setAliId(2001) ;
		m3.setUid("u2001") ;
		m3.setMemberId("china99ljs") ;
		m3.setComments("苦逼的阿里巴巴程序猿，你也可以认为他是个攻城狮 ") ;
		m3.setBelongto("CBU") ;memberMap = new HashMap();
		
		memberMap.put(m1.getMemberId() , m1);
		memberMap.put(m2.getMemberId() , m2);
		memberMap.put(m3.getMemberId() , m3);
	}
	
	public static HaMemberInfo getMemberByMemberId(String memberId){
		return (HaMemberInfo) memberMap.get(memberId); 
		
	}
	
	
	public static void main(String args[]){
		
		HavanMemberCenter hm  = new HavanMemberCenter();
		HaMemberInfo member = hm.getMemberByMemberId("messi");
		System.out.println("会员信息AliId:"+member.getAliId());
		System.out.println("会员信息MemberId:"+member.getMemberId());
		System.out.println("会员信息comments:"+member.getComments());
		
	}
}


class HaMemberInfo {
	public long getAliId() {
		return aliId;
	}

	public void setAliId(long aliId) {
		this.aliId = aliId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private long aliId;
	private String memberId;
	private String uid;
	private String name;
	public String getBelongto() {
		return belongto;
	}

	public void setBelongto(String belongto) {
		this.belongto = belongto;
	}

	private String belongto ;
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	private String comments ; 

}
