import java.util.*;

class fibonaki{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter number of elements for fibonaki series");
		int n=sc.nextInt();
		int res=0;
		if(n==0)
			System.out.print("0");
		else if(n==1)
			System.out.print("0 1");
		else{
		    int a=0;
		    int b=1;
			for(int i=1;i<=n;i++){
			res=a+b;
			System.out.print(res+" ");
			a=b;
			b=res;
		}
		}
		
	}
}