package monkey.designpattern.proxy.genera.study;

public class CarSellerProxy extends CarSubject{

	private CarSubject  carSubject ;


	public CarSellerProxy(CarSubject carSubject){
		this.carSubject  =  carSubject  ;
	}

	@Override
	public void sellCar(String carType) {

//		System.out.println("买车");
		carSubject.sellCar(carType) ;
		doCarInsure() ;

	}
	/**
	 * <p>做车保
	 * */
	private void doCarInsure(){
		System.out.println("对车辆做保险");
	}

}
