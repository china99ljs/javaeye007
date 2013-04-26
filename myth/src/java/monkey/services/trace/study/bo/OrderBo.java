package monkey.services.trace.study.bo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderBo {

	Logger logger  = LoggerFactory.getLogger(OrderBo.class)  ;
	public void doBizOrder(){
		logger.debug("create a order " );
	}

}
