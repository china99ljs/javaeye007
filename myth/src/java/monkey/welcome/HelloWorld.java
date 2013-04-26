package monkey.welcome;


public class HelloWorld {
	private String helloStr  ;

	public String getHelloStr() {
		return helloStr;
	}

	public void setHelloStr(String helloStr) {
		this.helloStr = helloStr;
	}

	public void sayHelloWord(){
		System.out.println("the computer says :"+helloStr);
//		Collections.synchronizedMap(new HashMap());
	}

}
