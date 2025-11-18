// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		
		int addNum = x1;
		int currentNum = x2;

			if (x2 < 0) {

			currentNum = -1 * x2;

		}

		for (int i = 0; i < currentNum; i ++) {

			addNum ++;

		}

		return addNum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {

		int minusNum = x1;
		int currentNum = x2;

		if (x2 < 0) {

			currentNum = -1 * x2;

		}

		for (int i = 0; i < currentNum; i ++) {

			minusNum --;

		}

		return minusNum;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {

		int currentNum = x1;

		for (int i = 1; i < x2; i ++) {
		

		currentNum =	plus(currentNum, x1);


		}


		return currentNum;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {

		int currentNum = x;

		if (n >= 0) {

			for (int i = 1; i < n; i ++) {

				currentNum = times(currentNum, x);

			}
			

		} 

	
		return currentNum;	
		
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		
		int currentNum = x1;
		int count = 0;

		while (currentNum != 0 && currentNum >= x2 ) {

			currentNum = minus(currentNum, x2);
			
			count ++;
			
		}

		return count;
		
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		
		int currentNum = x2;
		int count = 0;

		while (currentNum <= x1) {

			currentNum = plus(currentNum, x2);
			count ++;
			
		}


		return count;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		
		int currentNum = 1;
		int beforePluse = 0;
		int isX = 0;

		while( isX != x ) {
			
			isX = times(currentNum, currentNum);

			beforePluse = currentNum;

			currentNum = plus(currentNum, 1);

			if (isX > x) {

				return beforePluse;

			}

		}
		
		return beforePluse;
	}	  	  
}