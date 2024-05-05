package conversionservice;

<<<<<<< HEAD
import java.math.BigInteger;

public interface ConversionService {
	BigInteger textToNumber(String text);
    String numberToText(BigInteger result);
    void setLanguage(Language language);
	
=======
public interface ConversionService {
	int textToNumber(String text);
    String numberToText(int number);
    void setLanguage(Language language);
>>>>>>> 3a5ac9e4f6619d7532ee7b8419bdaced2c4e27a5
}
