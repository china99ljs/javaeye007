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
		//���̷߳��ʷ��̰߳�ȫ����
		System.out.println("���̷߳��ʷ��̰߳�ȫ����");
		m.doMultiTest() ;
		/*System.out.println("���̷߳����̰߳�ȫ����");
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
