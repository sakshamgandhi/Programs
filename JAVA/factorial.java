import java.util.*;

class factorial{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter number");
		int n=sc.nextInt();
		int res=1;
		for(int i=1;i<=n;i++){
			res=res*i;
		}
		System.out.println("Factorial is : "+ res);
	}
}