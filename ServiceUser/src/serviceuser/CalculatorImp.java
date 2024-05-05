package serviceuser;

<<<<<<< HEAD
import java.math.BigInteger;

public class CalculatorImp implements Calculator {

	public BigInteger add(BigInteger num1, BigInteger num2) {
		// TODO Auto-generated method stub
		return num1.add(num2);
	}

	
	public BigInteger subtract(BigInteger num1, BigInteger num2) {
		// TODO Auto-generated method stub
		return num1.subtract(num2);
	}

	
	public BigInteger multiply(BigInteger num1, BigInteger num2) {
		// TODO Auto-generated method stub
		return num1.multiply(num2);
	}

	
	public BigInteger divide(BigInteger num1, BigInteger num2) {
		if (num2.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        }
        return num1.divide(num2);
	}
=======

public class CalculatorImp implements Calculator {


	
	
    public int add(int num1, int num2) {
    	return num1 + num2;
    }

    public int subtract(int num1, int num2) {
    	return num1 - num2;
    }

    public int multiply(int num1, int num2) {
    	return num1 * num2;
    }

    public int divide(int num1, int num2) {
    	return num1 / num2;
    }
>>>>>>> 3a5ac9e4f6619d7532ee7b8419bdaced2c4e27a5

}
