package monkey.annon.study;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import monkey.common.base.BaseTest;

import org.testng.annotations.Test;

public class TraceUtilTest extends BaseTest {

	@Test
	public void doBizTestReflect(){

		TraceUtil traceUtil  = (TraceUtil)context.getBean("traceUtil")    ;

		try {
			processAnnoation(traceUtil) ;
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   /**@author junsong.liangjs
    * @exception IllegalArgumentException, IllegalAccessException, InvocationTargetException
    * @param Object
    * @return void
    * <p>����annoation<br>
    * ֻ�Դ��ϱ�ǵķ��������� ������TraceAround��������ڷ�����ִ��֮ǰ��֮��������
    * */
	private void processAnnoation(TraceUtil traceUtil) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		Class tt  = traceUtil.getClass() ;
		Method [] methods  =   tt.getMethods() ;
		for(int i= 0 ;i < methods.length ; i ++){
			Method method  = methods[i] ;
			Annotation[] annotations = method.getAnnotations() ;
			for(Annotation annotaion  : annotations){
				if(annotaion.annotationType().isAssignableFrom(TraceAround.class)){
					if(((TraceAround)annotaion).before().equals("doClear")){
						System.out.println("before .....delete all data ");
					}else {
						System.out.println("before .....bu no command  ");
					}

					method.invoke(traceUtil) ;

					if(((TraceAround)annotaion).arfter().equals("doCommit")){
						System.out.println("after .....do commit all data ");
					}else{
						System.out.println("after .....bu no command  ");
					}

				}
			}
		}
	}


	/**
	 * <p>��־���Է���<br>
	 * ��Ҫ�ǲ����ڵ���TraceUtil��doBiz()ʱ ���� TraceAround ���߼�����
	 * @author junsong.liangjs
	 * @param null
	 *
	 * */
	@Test
	public void doTraceTest(){



	}

	@Override
	public String[] initBizContext() {;
		String [] s = new String[]{"conf/annon/annon-config.xml"} ;
		return s  ;
	}


}
