import java.util.Stack;

// by using stack in java
public class stringreverse1 {
    public static String recursive(char str[]){

        Stack<Character> st = new Stack<>();
        for(int i =0;i<str.length;i++){
            st.push(str[i]);
        }
        for(int i=0;i<str.length;i++){
            str[i] = st.peek();
            st.pop();
        }
        ////converting character array to string
        return String.valueOf(str);
    }

    public static void main(String[] args) {
        String str = "sushant";
        str = recursive(str.toCharArray());

        System.out.println(str);
    }
}
