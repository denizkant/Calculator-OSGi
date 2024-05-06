package conversionservice;


import java.math.BigInteger;

public interface ConversionService {
	BigInteger textToNumber(String text);
    String numberToText(BigInteger result);
    void setLanguage(Language language);
	
}
