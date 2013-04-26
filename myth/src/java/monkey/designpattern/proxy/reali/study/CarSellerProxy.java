package monkey.designpattern.proxy.reali.study;

public class CarSellerProxy implements CarInterface{

	private CarInterface  carSeller ;


	public CarSellerProxy(CarInterface carSeller){
		this.carSeller  =  carSeller  ;
	}

	@Override
	public void sellCar(String carType) {

//		System.out.println("买车");
		carSeller.sellCar(carType) ;
		doCarInsure() ;
		// TODO Auto-generated method stub

	}
	/**
	 * <p>做车保
	 * */
	private void doCarInsure(){
		System.out.println("对车辆做保险");
	}

}
