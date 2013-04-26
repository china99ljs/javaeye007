package monkey.common.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeTest;

public abstract  class BaseTest {
    private final Logger     log = LoggerFactory.getLogger(getClass());
	private static String[] basePathList  = new String[]{"conf/base-config.xml"} ;
	protected static ClassPathXmlApplicationContext context = null ;
	@BeforeTest
	public void init(){
		String[] pathList  =  null ;
		String[] bizContextPaths  = initBizContext();
		if(pathList==null){

		}
		if(bizContextPaths!=null&&bizContextPaths.length>0){
			pathList =  new String[bizContextPaths.length+basePathList.length] ;

			for(int i =0 ; i<basePathList.length ; i ++ ){
				pathList[i]= basePathList[i] ;
			}
			for(int i = 0 ; i < bizContextPaths.length ;i ++ ){
				pathList[basePathList.length+i]=bizContextPaths[i] ;
			}
		}else{

			pathList = basePathList ;
		}
		log.debug("-------------start load context ---------- ") ;
	    context = new ClassPathXmlApplicationContext(pathList);
		log.debug("------------- load context-- {} ---successful -------------",pathList.length) ;
	}

	public  ClassPathXmlApplicationContext getContext(){
		return context ;
	}

	abstract public String[] initBizContext( ) ;


}
