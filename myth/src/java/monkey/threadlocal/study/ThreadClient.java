package monkey.threadlocal.study;


public class ThreadClient implements Runnable{
	private ThreadLocalDemo demo ;


	public ThreadClient(){

	}
	public ThreadClient(ThreadLocalDemo demo ){
		this.demo = demo ;

	}

		@Override
		public void run() {

			demo.doBiz() ;
//			demo.doBizLocal() ;

			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}




	public static void main(String args[]){
		ThreadClient m = new ThreadClient() ;
		//多线程访问非线程安全变量
		System.out.println("多线程访问非线程安全变量");
		m.doMultiTest() ;
		/*System.out.println("多线程访问线程安全变量");
		m.doThreadLocalTest();*/

	}
	private void doMultiTest(){
		ThreadLocalDemo xx  = new ThreadLocalDemo();
		for (int i =0 ; i <10 ; i ++){
			ThreadClient m = new ThreadClient(xx) ;
			new Thread(m).start() ;
		}




	}

}
