import java.util.Arrays;
import java.util.HashSet;


public class AllTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x,y,a,b,p,q;
		x=2; y =4;
		a = b = p = q = 2;
		 //p = (Integer) (x > y? a:b == p*q);
		p = x > y? a:b;
		System.out.println(p);
		System.out.println(average(2,3));
		
		//
		String s1 = "abc";
		String s2 = "abc";
		System.out.println("s1 == s2 is:" + s1 == s2);
		//
		String s3 = "JournalDev";
		int start = 1;
		char end = 5;
		System.out.println(start + end);
		System.out.println(s3.substring(start, end));
		//
		HashSet shortSet = new HashSet();
		for (short i = 0; i < 100; i++) {
		    shortSet.add(i);//0,-1  1,0, 2,1, 3,2
		    shortSet.remove(i - 1);
		}
		System.out.println(shortSet.size());
		
		shortSet = new HashSet();
		for (short i = 0; i < 100; i++) {
		    shortSet.add(Integer.toString(i));//0,-1  1,0, 2,1, 3,2
		    shortSet.remove(Integer.toString(i - 1));
		}
		System.out.println(shortSet.size());
		//
		 
        String one = new String("Hello"); 
        String two = new String("Hello");
        //one.hashCode(); two.hashCode();
        //if(one == two) {
        if(one.equals(two)) {
            System.out.println("one == two");
        }
        else {
            System.out.println("one != two");
        }
        two="Hello";
        
        //
       
            int i = 1111;
    
                i = i-- - --i;
                System.out.println(i);
         
                i = i++ + ++i;
                System.out.println(i);
   
        //
		 Integer i1 = 127;Integer i2 = 127;		System.out.println(i1 == i2);
	     Integer i3 = 126;Integer i4 = 126;		System.out.println(i3 == i4);
	     
	     //Integer iw2 = new Integer(null); Exception in thread "main" java.lang.NumberFormatException: null
	     
	        String s = new String();
	        
	        System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
	        System.out.println(0.0d);
	        System.out.println(Double.MIN_VALUE);
	        System.out.println(Double.MAX_VALUE);
	        System.out.println(Integer.MIN_VALUE);
	        System.out.println(Integer.MAX_VALUE);
	        System.out.println(Float.MIN_VALUE);
	        System.out.println(Float.MAX_VALUE);
	        //
	        char[] chars = new char[] {'\u0097'};
	        String str = new String(chars);
	        byte[] bytes = str.getBytes();
	        System.out.println(Arrays.toString(bytes));
//
	        //swapping woithout temp
	        
	        a=10; b=9;
	        a = a + b;
	        b = a - b;   // actually (a + b) - (b), so now b is equal to a
	        a = a - b;

System.out.println(a+" "+b);
	System.out.println(reverse("sandesh"));
	}
	
    public static String reverse(String input){
        if(input == null || input.isEmpty()){
            return input;
        }
       
        return input.charAt(input.length()- 1) + reverse(input.substring(0, input.length() - 1));
    }


	
	public static double average(int a, int b)
    {
        return (double)a + b / 2;
    }

	static int methodOfA()
    {
        return (true ? null : 0);
    }
}
