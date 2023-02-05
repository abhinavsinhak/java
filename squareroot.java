import java.util.*;
import java.lang.Math;

class squareroot{
    public static void main(String[] args) {
        
       Scanner scr = new Scanner(System.in);
       double x;
       System.out.println("enter the number");
       x = scr.nextDouble();
       double sqrt = fun1(x);
       if(sqrt==Math.floor(sqrt)){
       System.out.println("is perfect square of "+sqrt);
       }
       else{
        System.out.println("is not a perfect square");
       }

    }
    static double fun1(double x){
        double sqrt = Math.sqrt(x);

        return sqrt;


    }
}