package monkey.designpattern.proxy.reali.study;

public class CarSellerProxy implements CarInterface{

	private CarInterface  carSeller ;


	public CarSellerProxy(CarInterface carSeller){
		this.carSeller  =  carSeller  ;
	}

	@Override
	public void sellCar(String carType) {

//		System.out.println("��");
		carSeller.sellCar(carType) ;
		doCarInsure() ;
		// TODO Auto-generated method stub

	}
	/**
	 * <p>������
	 * */
	private void doCarInsure(){
		System.out.println("�Գ���������");
	}

}
