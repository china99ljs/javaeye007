package monkey.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;

@Aspect
public class CbuServiceAspect implements Ordered {

	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Pointcut("execution(public * monkey.aop.*Impl.*(..)) && @annotation (monkey.aop.ServiceForCBU) ")
	public void pointCutMethod() {

	}

	
	@Before("pointCutMethod()")
	public Object doServiceMethod(JoinPoint pjp) {
			HaMemberInfo hm =  null ; 
		try {
			Class targetClass  = pjp.getTarget().getClass() ;
			Method[] methods  = targetClass.getMethods() ;
			if(methods[0].isAnnotationPresent(ServiceForCBU.class)){
				ServiceForCBU sf = methods[0].getAnnotation(ServiceForCBU.class);  
				//需要替换的会员的类名
				String memberInfo  = sf.memberInfo() ; 
				//获取原始值的方法
				String getMc  = sf.getMemberMethod() ;
				//替换的方法
				String replaceMc  = sf.replaceMemberMethod() ;
				//待处理会员实例在参数列表的下标 
				int index  = sf.index() ; 
	             //目标方法的入参列表
	            Object obj[] = pjp.getArgs();
	            //需要处理的会员实例
	            Class memberClass  = obj[index].getClass() ;
	            
	            Method tt= memberClass.getMethod(getMc, null) ;
	            
	            
	            String memberId  = (String) tt.invoke(obj[index], null) ;
	            
	            hm  = HavanMemberCenter.getMemberByMemberId(memberId);
	            
	            
	            if(hm == null){
					return null ; 
				}
				if (hm.getBelongto().equals("ICBU")){
					System.out.println("欢迎ICBU的小伙子 , 你的memberId 确实是咱青衣帮的通关令牌 ："+memberId+" ，进去喝酒吃肉吧");
				}else if(hm.getBelongto().equals("CBU")){
					System.out.println("CBU的小伙 ，你的memberId 是青衣帮的通关令牌 ："+memberId+" ，你跑到虎头帮来做什么 ？哥帮你乔装打扮，带你脱离苦海: 这里我要篡改给目标方法的参数了。。。：）");
		            Method tmp= memberClass.getMethod(replaceMc,String.class) ;
		            String finalId  = String.valueOf(hm.getAliId() );
		            tmp.invoke(obj[index],finalId) ;
					
				}else{
				}
//				pjp.proceed();
	            return null ;
			}
			
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
/*	@Before("pointCutMethod()")
	public Object doServiceMethod(JoinPoint pjp) {
			HaMemberInfo hm =  null ; 
		try {
			
			
			Class targetClass  = pjp.getTarget().getClass() ;
			
			Method[] methods  = targetClass.getMethods() ;
			
			
			if(methods[0].isAnnotationPresent(ServiceForCBU.class)){
				
				ServiceForCBU sf = methods[0].getAnnotation(ServiceForCBU.class);  
				//需要替换的会员的类名
				String memberInfo  = sf.memberInfo() ; 
				//获取原始值的方法
				String getMc  = sf.getMemberMethod() ;
				//替换的方法
				String replaceMc  = sf.replaceMemberMethod() ;
				//待处理会员实例在参数列表的下标 
				int index  = sf.index() ; 
				
	             //目标方法的入参列表
	            Object obj[] = pjp.getArgs();
	            //需要处理的会员实例
	            Class memberClass  = obj[index].getClass() ;
	            
	            
	            
	            
	            Method tt= memberClass.getMethod(getMc, null) ;
	            String memberId  = (String) tt.invoke(obj[index], null) ;
	            
	            hm  = HavanMemberCenter.getMemberByMemberId(memberId);
	            if(hm == null){
					return null ; 
				}
				if (hm.getBelongto().equals("ICBU")){
					System.out.println("欢迎ICBU的小伙子 , 你的memberId 确实是咱青衣帮的通关令牌 ："+memberId+" ，进去喝酒吃肉吧");
				}else if(hm.getBelongto().equals("CBU")){
					System.out.println("CBU的小伙 ，你的memberId 是青衣帮的通关令牌 ："+memberId+" ，你跑到虎头帮来做什么 ？哥帮你乔装打扮，带你脱离苦海: 这里我要篡改给目标方法的参数了。。。：）");
					
		            Method tmp= memberClass.getMethod(replaceMc,String.class) ;
		            String finalId  = String.valueOf(hm.getAliId() );
		            tmp.invoke(obj[index],finalId) ;
					
				}else{
					
				}
//				pjp.proceed();
	            
	            return null ;
				
			}
			
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/

}
