import java.util.*;
public class map{
    public static void main(String[] args) {
        HashMap<String,Integer> scr = new HashMap<>();
          
        scr.put("sushant", 1000);
        scr.put("gaurav", 500);
        scr.put("aashu",2000);
        
        // System.out.println(scr);
        // System.out.println(scr.containsKey("sushant"));
        // System.out.println(scr.get("aashu"));

        for(Map.Entry<String,Integer> it :scr.entrySet()){
            System.out.println(it.getValue());
        }

        Set<String> keys = scr.keySet();
        for(String key:keys){
            System.out.println(key+" "+scr.get(key));
        }
        
    }
}