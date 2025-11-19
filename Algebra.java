// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(-5,-3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(-5,-3));  // 2 - 7
 		System.out.println(times(-2,-4));  // 3 * 4
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
		
		int plusNum = x1;
		int count = x2;

		if (count > 0) {
			while (count != 0) {

				plusNum ++;
				count --;
				
			}
		}

		else if (count < 0) {
			while (count != 0) {

				plusNum --;
				count ++;
				
			}
		}

		return plusNum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {

		int minusNum = x1;
		int count = x2;

		if (count > 0) {
			while (count != 0) {

				minusNum --;
				count --;

			}

		}

		else if (count < 0) {
			while (count != 0) {
				
				minusNum ++;
				count ++;
			}
		}

		return minusNum;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {

		int absolutX1 = x1;
		int absolutX2 = x2;
		boolean isX1Neg = false;
		boolean isX2Neg = false;

		if (x1 == 0 || x2 == 0) {

			return 0;

		}

		if (x1 < 0) {

			absolutX1 = minus(0, x1);
			isX1Neg = true;

		}

		if (x2 < 0) {

			absolutX2 = minus(0, x2);
			isX2Neg = true;

		}

		int finalResult = 0;
		int count = absolutX2;
		while (count != 0) {

			finalResult = plus(finalResult, absolutX1);
			count --;
			
		}

		if ((isX1Neg && isX2Neg) || ((isX1Neg = false) && (isX2Neg = false ))) {

			return finalResult;
			
		} else {

			return minus(0, finalResult);

		}

		
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {

		if (n < 0){
			return 0;
		}

		if (n == 0) {
			return 1;
		}

		int finalResult = 1;
		int count = n;

		while (count != 0) {

			finalResult = times(finalResult, x);
			count --;
			
		}

		return finalResult;
		
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		
		int absolutX1 = x1;
		int absolutX2 = x2;
		boolean isX1Neg = false;
		boolean isX2Neg = false;

		if (x1 < 0) {

			absolutX1 = minus(0, x1);
			isX1Neg = true;
			
		}

		if (x2 < 0) {

			absolutX2 = minus(0, x2);
			isX2Neg = true;

		}
		
		int finalResult = 0;
		int currentNum = absolutX1;

		while (currentNum >= absolutX1) {

			currentNum = minus(currentNum, absolutX2);
			finalResult ++;
			
		}

		if ((isX1Neg && isX2Neg) || ((isX1Neg = false) && (isX2Neg = false ))) {

			return finalResult;
			
		} else {

			return minus(0, finalResult);

		}
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		
		if (x2 == 0) {
			return x1;
		}

		int quot = div(x1, x2);
		int prod = times(quot, x2);

		int remain = minus(x1, prod);

		return remain;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		
		if (x < 0) {
			return 0;
		}
		 int finalResult = 0;
		 int odd = 1;

		 while (x >= 0) {

			int newNm = minus(x, odd);

			if(newNm < 0) {

				break;
			}

			x = newNm;
			finalResult ++;

			odd = plus(odd, 2);
			
		 }

		 return finalResult;
	}	  	  
}