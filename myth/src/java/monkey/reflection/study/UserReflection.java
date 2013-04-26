package monkey.reflection.study;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class UserReflection {
    
    
    public static void main(String args[]) throws IllegalArgumentException, IllegalAccessException{
        
        User user = new User();
        Constructor cc[] = User.class.getConstructors();
        
        Field ff[]= User.class.getDeclaredFields();
        
        for(Field f: ff){
            System.out.println("字段名:"+f.getName());
            System.out.println( "值:"+f.get(user));
            System.out.println("是否安全检查:"+f.isAccessible());
        }
        
        
    }

}
