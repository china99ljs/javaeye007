package monkey.designpattern.proxy.dynamic.study;

import java.io.ObjectStreamClass;

public class CarBuyer {

	CarInterface carInterface ;
	String a = "aaa" ;

	public void buyCar(){
		//�ҵ���Ӧ�ĳ���
		CarInterface car = new CarCreator() ;
		//����Ӧ�Ĵ����̹�������
		CarSellerProxy carProxy = new CarSellerProxy(car) ;
//		carProxy.sellCar("��������") ;
	}

	public static void main(String args[]){

		new CarBuyer().buyCar() ;
//		ObjectStreamClass.lookup(CarBuyer.class).getField("a").get;
	}

}
