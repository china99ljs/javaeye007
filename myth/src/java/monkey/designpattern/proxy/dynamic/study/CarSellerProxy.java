package monkey.designpattern.proxy.dynamic.study;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CarSellerProxy implements InvocationHandler{

	private CarInterface  carSeller ;

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		return null;
	}
	public CarSellerProxy(CarInterface carSeller){
		this.carSeller  =  carSeller  ;
	}

	/**
	 * <p>做车保
	 * */
	private void doCarInsure(){
		System.out.println("对车辆做保险");
	}



}
