package monkey.designpattern.proxy.dynamic.study;

public class CarCreator implements CarInterface{

	/**
	 * <p>提供卖车服务:卖裸车
	 * @author junsong.liangjs
	 *
	 * */
	public void sellCar(String carType){
		System.out.println("出售裸车") ;
	}

}
