import java.util.*;
import java.lang.Math;

class prime{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter number");
		int n=sc.nextInt();
		int flag=0;
		for(int i=2;i<=Math.sqrt(n);i++){
			if(n%i==0){
			System.out.println("not a prime");
			flag=1;
			break;
			}
		}
				if(flag==0)
				System.out.println("prime");
	}
}