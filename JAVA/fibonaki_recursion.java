import java.util.*;
class fibonaki{
	public static int fibonaki_recurson(int i){
		if(i==0)
			return 0;
		if(i==1)
			return 1;
		else
			return fibonaki_recurson(i-1)+fibonaki_recurson(i-2);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter number of elements for fibonaki series");
		int n=sc.nextInt();
		int res=0;
		int a=0,b=1;
		for(int i=0;i<n;i++){
			System.out.print(fibonaki_recurson(i)+" ");
		}
	}
}