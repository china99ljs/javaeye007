package monkey.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.* ;

public class LoadProp {
    
    public void printProp(){
        
        InputStream in = this.getClass().getResourceAsStream("/demo.properties");
        
        Properties prop = new Properties();  
        
        try {
            prop.load(in);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(prop.getProperty("welcome.value"));
        
    
        
     
    }
    
    public static void main(String args[]){
        
        new LoadProp().printProp();
    }

}
