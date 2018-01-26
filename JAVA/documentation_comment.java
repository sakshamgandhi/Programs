	import java.util.*;



	/** The Calculator class provides methods to get addition and subtraction of given 2 numbers.*/  
public class documentation_comment {  
	/** The add() method returns addition of given numbers.*/  
public static int add(int a, int b){return a+b;}  
/** The sub() method returns subtraction of given numbers.*/  
public static int sub(int a, int b){return a-b;}  

	public static void main(String[] args) {
		
int a;
int b;
Scanner sc=new Scanner(System.in);
a=sc.nextInt();
b=sc.nextInt();
int res1=add(a,b);
int res2=sub(a,b);
System.out.println(res1+" "+res2);
}  
}