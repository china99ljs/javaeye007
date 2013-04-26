package monkey.perf4j.study;

import org.perf4j.StopWatch;
import org.perf4j.slf4j.Slf4JStopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Perf4jStep {

//	public void

	Logger log  = LoggerFactory.getLogger(getClass());

	public Object getMessage(int n , int sw){
		Object content = null ;
		switch (sw){
		case 1:
			content = initMessage(new String("the same result") , n  );
			break ;
		case 2 :
			content =initMessage(new StringBuffer("the same result") , n  );
			break ;
		case 3 :
			content =initMessage(new StringBuilder("the same result") , n  );
			break ;
		default :
			log.warn("you give me a wrong switch command: {} , please check it again ",sw) ;
			break ;

		}


		log.info("you get the final result is {}" , content ) ;

		return content  ;

	}

	private Object initMessage(Object content , int n ){
		for(int i =0 ; i < n ; i ++){
			if(content instanceof String){
				content = (String)content+i+";" ;
			}else if(content instanceof StringBuffer){
				content = ((StringBuffer)content).append(i+";");
			}else if (content instanceof StringBuilder){
				content = ((StringBuilder)content).append(i+";");
			}else{

			}
		}
		return content  ;

	}


	public static  void main(String args[]){
		System.out.println("test is 利用perf4j 比较string ,stringBuffer , StringBuilder 的性能 ") ;
		//
		//String
		StopWatch stopWatch = new Slf4JStopWatch("getMessage","string");
		new Perf4jStep().getMessage(10000 , 1);
		stopWatch.stop();

		//StringBuffer
		StopWatch stopWatch2 = new Slf4JStopWatch("getMessage");
		new Perf4jStep().getMessage(10000 , 2);
		stopWatch2.stop();
		//StringBuilder
		StopWatch stopWatch3 = new Slf4JStopWatch("getMessage");
		new Perf4jStep().getMessage(10000 , 3);
		stopWatch3.stop();
		System.out.println("test is end ") ;

	}

}
