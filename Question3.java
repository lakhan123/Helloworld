import java.util.*; 
public class Question3 { 
  
    static void findBracket(String expression, int index) { 
        int i; 
  
        if (expression.charAt(index) != '[') { 
            System.out.print(expression + ", "
                    + index + ": -1\n"); 
            return; 
        } 
  
        Stack<Integer> st = new Stack<>(); 
  
        for (i = index; i < expression.length(); i++) { 
  
              
            if (expression.charAt(i) == '[') { 
                st.push((int) expression.charAt(i)); 
            }  
            else if (expression.charAt(i) == ']') { 
                st.pop(); 
                if (st.empty()) { 
                    System.out.print(expression + ", "
                            + index + ": " + i + "\n"); 
                    return; 
                } 
            } 
        } 
  
        System.out.print(expression + ", "
                + index + ": -1\n"); 
    } 

    public static void main(String[] args) { 
        findBracket("[ABC[23]][89]", 0); 
        findBracket("ABC[58]", 3); 
        
    } 
}