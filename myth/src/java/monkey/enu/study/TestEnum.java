package monkey.enu.study;

import monkey.enu.study1.OrderState;


/**
 * ö���÷����
 * 
 * @author jiqinlin
 * 
 */
public class TestEnum {
    /**
     * ��ͨö��
     * 
     * @author jiqinlin
     *
     */
    public enum ColorEnum {
        red, green, yellow, blue;
    }
    
    /**
     * ö������ͨ����һ������������Ժͷ���������Ϊ����Ӿ�̬�ͷǾ�̬�����Ի򷽷�
     * 
     * @author jiqinlin
     *
     */
    public enum SeasonEnum {
        //ע��ö��д����ǰ�棬����������
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
     * �Ա�
     * 
     * ʵ�ִ��й�������ö��
     * 
     * @author jiqinlin
     *
     */
    public enum Gender{
        //ͨ�����Ÿ�ֵ,���ұ������һ���ι�������һ�����Ը�����������������
        //��ֵ���붼��ֵ�򶼲���ֵ������һ���ָ�ֵһ���ֲ���ֵ���������ֵ����д����������ֵ����Ҳ����
        MAN("MAN-value"), WOMEN("WOMEN-value");
        
        private final String value;

        //������Ĭ��Ҳֻ����private, �Ӷ���֤���캯��ֻ�����ڲ�ʹ��
        Gender(String value) {
            this.value = value;
        }
        
        public String getValue() {
            return value;
        }
    }
    

    public static void main(String[] args) {
        //ö����һ�����ͣ����ڶ�������������Ʊ����ĸ�ֵ����ֵʱͨ����ö����.ֵ��ȡ��ö���е�ֵ
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
        
        //����ö��
        System.out.println("����ColorEnumö���е�ֵ");
        for(ColorEnum color : ColorEnum.values()){
            System.out.println("ö�ٵ�name����:"+color.name());
            System.out.println("ö�ٵ�value����:"+color.valueOf(color.name()));
            System.out.println(color);
            
        }
        
        //��ȡö�ٵĸ���
        System.out.println("ColorEnumö���е�ֵ��"+ColorEnum.values().length+"��");
        
        //��ȡö�ٵ�����λ�ã�Ĭ�ϴ�0��ʼ
        System.out.println(ColorEnum.red.ordinal());//0
        System.out.println(ColorEnum.green.ordinal());//1
        System.out.println(ColorEnum.yellow.ordinal());//2
        System.out.println(ColorEnum.blue.ordinal());//3
        
        //ö��Ĭ��ʵ����java.lang.Comparable�ӿ�
        System.out.println(ColorEnum.red.compareTo(ColorEnum.green));//-1
        
        //--------------------------
        System.out.println("===========");
        System.err.println("����Ϊ" + SeasonEnum.getSeason());
        
        
        //--------------
        System.out.println("==�Ա�=========");
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