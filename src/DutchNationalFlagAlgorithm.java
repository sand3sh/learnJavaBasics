
public class DutchNationalFlagAlgorithm {

	public static void main(String args[]){
		String[] a = new String[]{"1","1","0","2","2","0","1","0","2","1"};
		
		System.out.println("BEFORE");
		//Before
		for(String s : a){
			System.out.print(s+" ");
		}
		System.out.println();
		
		//ALGORITHM
		int i,j,k; i=j=0; k = a.length - 1;
		//ALGORITHM
		while(j<=k){
			if(a[j].equals("0")){
				swap(a,i,j); i++;; j++;
			}else if(a[j].equals("1")){
				j++;
			}else if(a[j].equals("2")){
				swap(a,j,k); k--;
			}
		}
		
		System.out.println("AFTER");
		//Before
		for(String s : a){
			System.out.print(s+" ");
		}
		
	}
	
	  private static void swap(String[] arr, int a, int b) {
		  	String tmp = arr[a];
	        arr[a] = arr[b];
	        arr[b] = tmp;
	    }
}
