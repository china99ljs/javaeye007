package monkey.reflection.study;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class UserReflection {
    
    
    public static void main(String args[]) throws IllegalArgumentException, IllegalAccessException{
        
        User user = new User();
        Constructor cc[] = User.class.getConstructors();
        
        Field ff[]= User.class.getDeclaredFields();
        
        for(Field f: ff){
            System.out.println("�ֶ���:"+f.getName());
            System.out.println( "ֵ:"+f.get(user));
            System.out.println("�Ƿ�ȫ���:"+f.isAccessible());
        }
        
        
    }

}
