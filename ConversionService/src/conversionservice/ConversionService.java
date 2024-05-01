package conversionservice;

public interface ConversionService {
	int textToNumber(String text);
    String numberToText(int number);
    void setLanguage(Language language);
}
