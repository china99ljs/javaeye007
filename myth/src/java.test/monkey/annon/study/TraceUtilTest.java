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
    * <p>处理annoation<br>
    * 只对打上标记的方法做处理 ，其中TraceAround表面必须在方法体执行之前和之后都做拦截
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
	 * <p>日志测试方法<br>
	 * 主要是测试在调用TraceUtil的doBiz()时 ，对 TraceAround 的逻辑处理
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
