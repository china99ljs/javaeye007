package monkey.trace;

import java.util.UUID;

import org.apache.log4j.MDC;

public class TraceUtil {

	private String TRACE_ID = "traceId" ;
	private UUID radomId  = java.util.UUID.randomUUID() ;

	public void beginTrace(){
		MDC.put(TRACE_ID, radomId.toString());
	}
	public void endTrace(){
		MDC.remove(TRACE_ID) ;
	}

}
