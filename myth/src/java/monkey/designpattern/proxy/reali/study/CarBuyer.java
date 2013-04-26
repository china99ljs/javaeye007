package monkey.designpattern.proxy.reali.study;

public class CarBuyer {

	CarInterface carInterface ;

	public void buyCar(){
		//找到对应的厂商
		CarInterface car = new CarCreator() ;
		//到对应的代理商购买汽车
		CarSellerProxy carProxy = new CarSellerProxy(car) ;
		carProxy.sellCar("凯迪拉克") ;
	}

	public static void main(String args[]){

		new CarBuyer().buyCar() ;
	}

}
