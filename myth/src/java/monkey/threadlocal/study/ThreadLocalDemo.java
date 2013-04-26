package monkey.threadlocal.study;

public class ThreadLocalDemo {

	private ThreadLocal<String> ss = new ThreadLocal<String>();



	String tmp  = "init"  ;
	String temp_local = null ;

	public String getSeat(){

		return ss.get() ;
	}
	public void doBiz(){
		tmp = tmp+"a" ;

		System.out.println(tmp);
	}
	public void doBizLocal(){

		if(ss.get()==null || ss.get().isEmpty()){
			ss.set("local") ;
		}

		temp_local = ss.get()+"a" ;

		System.out.println(Thread.currentThread().getId()+":"+temp_local);
	}

}
