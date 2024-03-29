package monkey.enu.study;

import monkey.enu.study1.OrderState;


/**
 * 枚举用法详解
 * 
 * @author jiqinlin
 * 
 */
public class TestEnum {
    /**
     * 普通枚举
     * 
     * @author jiqinlin
     *
     */
    public enum ColorEnum {
        red, green, yellow, blue;
    }
    
    /**
     * 枚举像普通的类一样可以添加属性和方法，可以为它添加静态和非静态的属性或方法
     * 
     * @author jiqinlin
     *
     */
    public enum SeasonEnum {
        //注：枚举写在最前面，否则编译出错
        spring, summer, autumn, winter;

        private final static String position = "test";

        public static SeasonEnum getSeason() {
            if ("test".equals(position))
                return spring;
            else
                return winter;
        }
    }
    
    /**
     * 性别
     * 
     * 实现带有构造器的枚举
     * 
     * @author jiqinlin
     *
     */
    public enum Gender{
        //通过括号赋值,而且必须带有一个参构造器和一个属性跟方法，否则编译出错
        //赋值必须都赋值或都不赋值，不能一部分赋值一部分不赋值；如果不赋值则不能写构造器，赋值编译也出错
        MAN("MAN-value"), WOMEN("WOMEN-value");
        
        private final String value;

        //构造器默认也只能是private, 从而保证构造函数只能在内部使用
        Gender(String value) {
            this.value = value;
        }
        
        public String getValue() {
            return value;
        }
    }
    

    public static void main(String[] args) {
        //枚举是一种类型，用于定义变量，以限制变量的赋值；赋值时通过“枚举名.值”取得枚举中的值
        ColorEnum colorEnum = ColorEnum.blue;
        
        switch (colorEnum) {
        case red:
            System.out.println("color is red");
            break;
        case green:
            System.out.println("color is green");
            break;
        case yellow:
            System.out.println("color is yellow");
            break;
        case blue:
            System.out.println("color is blue");
            break;
        }
        
        //遍历枚举
        System.out.println("遍历ColorEnum枚举中的值");
        for(ColorEnum color : ColorEnum.values()){
            System.out.println("枚举的name属性:"+color.name());
            System.out.println("枚举的value属性:"+color.valueOf(color.name()));
            System.out.println(color);
            
        }
        
        //获取枚举的个数
        System.out.println("ColorEnum枚举中的值有"+ColorEnum.values().length+"个");
        
        //获取枚举的索引位置，默认从0开始
        System.out.println(ColorEnum.red.ordinal());//0
        System.out.println(ColorEnum.green.ordinal());//1
        System.out.println(ColorEnum.yellow.ordinal());//2
        System.out.println(ColorEnum.blue.ordinal());//3
        
        //枚举默认实现了java.lang.Comparable接口
        System.out.println(ColorEnum.red.compareTo(ColorEnum.green));//-1
        
        //--------------------------
        System.out.println("===========");
        System.err.println("季节为" + SeasonEnum.getSeason());
        
        
        //--------------
        System.out.println("==性别=========");
        for(Gender gender : Gender.values()){
            System.out.println(gender.name());
            System.out.println(gender.value);
        }
       
        //--------------
        System.out.println("===========");
        for(OrderState order : OrderState.values()){
        	System.out.println(order.toString());
            System.out.println(order.getName());
        }
    }
    
}