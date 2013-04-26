package monkey.designpattern.proxy.genera.study;

public class CarSellerProxy extends CarSubject{

	private CarSubject  carSubject ;


	public CarSellerProxy(CarSubject carSubject){
		this.carSubject  =  carSubject  ;
	}

	@Override
	public void sellCar(String carType) {

//		System.out.println("��");
		carSubject.sellCar(carType) ;
		doCarInsure() ;

	}
	/**
	 * <p>������
	 * */
	private void doCarInsure(){
		System.out.println("�Գ���������");
	}

}
