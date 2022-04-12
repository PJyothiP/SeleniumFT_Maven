package Exceptions;

public class UnCheckedExceptionDemo {

	public static void main(String[] args) {
		int a[] = {14,13,18,40};
		
		try {
			System.out.println("This is my last element of array : "+a[4]);
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}catch(ArithmeticException e) {
			System.out.println("Arithmetic exception is caught");
		}finally {
			System.out.println("This is finally block");
		}
		System.out.println("After exception");
		System.out.println("----------------------");
		
		int age = 20;
		if(age<18) {
			throw new ArithmeticException("Person is not eligible for vote");
		}else {
			System.out.println("Person is eligible for vote");
		}
		
		int b = 0;
		double div = (age/b);
		System.out.println("division output is : "+div);
	}

}
