package monkey.designpattern.proxy.reali.study;

public class CarBuyer {

	CarInterface carInterface ;

	public void buyCar(){
		//�ҵ���Ӧ�ĳ���
		CarInterface car = new CarCreator() ;
		//����Ӧ�Ĵ����̹�������
		CarSellerProxy carProxy = new CarSellerProxy(car) ;
		carProxy.sellCar("��������") ;
	}

	public static void main(String args[]){

		new CarBuyer().buyCar() ;
	}

}
