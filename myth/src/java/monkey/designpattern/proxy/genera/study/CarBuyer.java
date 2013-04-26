package monkey.designpattern.proxy.genera.study;

public class CarBuyer {


	public void buyCar(){
		//�ҵ���Ӧ�ĳ���
		CarSubject car = new CarCreator() ;
		//����Ӧ�Ĵ����̹�������
		CarSellerProxy carProxy = new CarSellerProxy(car) ;
		carProxy.sellCar("��������") ;
	}

	public static void main(String args[]){

		new CarBuyer().buyCar() ;
	}

}
