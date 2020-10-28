import java.util.*;

public class Question1{

     public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number ->");
        int n = scn.nextInt();
        List<String> list = new ArrayList<>();
        
        for (int i=0; i<n ; i++){
            System.out.print("Enter "+(i+1)+" String ");
            String str =  scn.next();
            list.add(sort(str));
        }
        
        for(String str : list){
            
            System.out.println(str);
        }
     }
     
     public static String sort(String str){
        //str = str.toLowerCase();
         
        int j = 0;
		char temp = 0;
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
				for (j = 0; j < chars.length; j++) {
						if (chars[j] > chars[i]) {
								temp = chars[i];
								chars[i] = chars[j];
								chars[j] = temp;
						}
				}
		}
         
        return new String(chars);
     }
}