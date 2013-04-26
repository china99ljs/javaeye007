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
				//��Ҫ�滻�Ļ�Ա������
				String memberInfo  = sf.memberInfo() ; 
				//��ȡԭʼֵ�ķ���
				String getMc  = sf.getMemberMethod() ;
				//�滻�ķ���
				String replaceMc  = sf.replaceMemberMethod() ;
				//�������Աʵ���ڲ����б���±� 
				int index  = sf.index() ; 
	             //Ŀ�귽��������б�
	            Object obj[] = pjp.getArgs();
	            //��Ҫ����Ļ�Աʵ��
	            Class memberClass  = obj[index].getClass() ;
	            
	            Method tt= memberClass.getMethod(getMc, null) ;
	            
	            
	            String memberId  = (String) tt.invoke(obj[index], null) ;
	            
	            hm  = HavanMemberCenter.getMemberByMemberId(memberId);
	            
	            
	            if(hm == null){
					return null ; 
				}
				if (hm.getBelongto().equals("ICBU")){
					System.out.println("��ӭICBU��С���� , ���memberId ȷʵ�������°��ͨ������ ��"+memberId+" ����ȥ�ȾƳ����");
				}else if(hm.getBelongto().equals("CBU")){
					System.out.println("CBU��С�� �����memberId �����°��ͨ������ ��"+memberId+" �����ܵ���ͷ������ʲô ���������װ��磬��������ຣ: ������Ҫ�۸ĸ�Ŀ�귽���Ĳ����ˡ���������");
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
				//��Ҫ�滻�Ļ�Ա������
				String memberInfo  = sf.memberInfo() ; 
				//��ȡԭʼֵ�ķ���
				String getMc  = sf.getMemberMethod() ;
				//�滻�ķ���
				String replaceMc  = sf.replaceMemberMethod() ;
				//�������Աʵ���ڲ����б���±� 
				int index  = sf.index() ; 
				
	             //Ŀ�귽��������б�
	            Object obj[] = pjp.getArgs();
	            //��Ҫ����Ļ�Աʵ��
	            Class memberClass  = obj[index].getClass() ;
	            
	            
	            
	            
	            Method tt= memberClass.getMethod(getMc, null) ;
	            String memberId  = (String) tt.invoke(obj[index], null) ;
	            
	            hm  = HavanMemberCenter.getMemberByMemberId(memberId);
	            if(hm == null){
					return null ; 
				}
				if (hm.getBelongto().equals("ICBU")){
					System.out.println("��ӭICBU��С���� , ���memberId ȷʵ�������°��ͨ������ ��"+memberId+" ����ȥ�ȾƳ����");
				}else if(hm.getBelongto().equals("CBU")){
					System.out.println("CBU��С�� �����memberId �����°��ͨ������ ��"+memberId+" �����ܵ���ͷ������ʲô ���������װ��磬��������ຣ: ������Ҫ�۸ĸ�Ŀ�귽���Ĳ����ˡ���������");
					
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
