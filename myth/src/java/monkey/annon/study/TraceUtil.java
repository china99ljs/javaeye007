package monkey.annon.study;

public class TraceUtil {


	@TraceAround(before="doClear",arfter="doCommit")
	public void doBiz(){
		System.out.println("doBiz runing .....");
	}

}
