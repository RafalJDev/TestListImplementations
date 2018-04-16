import org.testng.annotations.Test;
import sun.misc.PostVMInitHook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
  
  public static void main(String[] args) {
    Main main = new Main();
    main.method();
    main.method2();
  
    testJarka();
  }
  
  public static void testJarka() {
    ArrayList<String> strings = new ArrayList<String>();
  
    System.out.println("Size: " + strings);
  }
  
  public void method() {
    boolean asIs = false;
    
    try {

//            List<String> strings = new ArrayList<String>();
//            List<String> strings2n = null;
//            strings.addAll(strings2n);
    } catch (NullPointerException e) {
      System.out.println("Exception");
//            asIs = true;
    }
    System.out.println("I'm here 1");
    
    assert asIs : "AsIs assert";
  }
  
  public void method2() {
    System.out.println("I'm here 2");
    try {
    
    } catch (NullPointerException e) {
    }
    System.out.println("I'm here 22");
  }
}