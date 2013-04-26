package monkey.threadlocal.study;


public class ThreadsafeClient implements Runnable{
	private ThreadLocalDemo demo ;


	public ThreadsafeClient(){

	}
	public ThreadsafeClient(ThreadLocalDemo demo ){
		this.demo = demo ;

	}

		@Override
		public void run() {

			demo.doBizLocal() ;

			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}




	public static void main(String args[]){
		ThreadsafeClient m = new ThreadsafeClient() ;
		System.out.println("多线程访问线程安全变量");
		m.doThreadLocalTest();

	}
	private void doThreadLocalTest(){
		ThreadLocalDemo xx  = new ThreadLocalDemo();
		for (int i =0 ; i <10 ; i ++){
			ThreadsafeClient m = new ThreadsafeClient(xx) ;
			new Thread(m).start() ;
		}

	}


}
