package conversionservice;

<<<<<<< HEAD
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class ConversionServiceImp implements ConversionService{
	 private static final Map<String, BigInteger> WORD_TO_NUMBER = new HashMap<>();
	 private static final BigInteger MAX_SUPPORTED_NUMBER = new BigInteger("999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
	    static {
	        // English numbers
	        WORD_TO_NUMBER.put("zero", BigInteger.ZERO);
	        WORD_TO_NUMBER.put("one", BigInteger.ONE);
	        WORD_TO_NUMBER.put("two", BigInteger.valueOf(2));
	        WORD_TO_NUMBER.put("three", BigInteger.valueOf(3));
	        WORD_TO_NUMBER.put("four", BigInteger.valueOf(4));
	        WORD_TO_NUMBER.put("five", BigInteger.valueOf(5));
	        WORD_TO_NUMBER.put("six", BigInteger.valueOf(6));
	        WORD_TO_NUMBER.put("seven", BigInteger.valueOf(7));
	        WORD_TO_NUMBER.put("eight", BigInteger.valueOf(8));
	        WORD_TO_NUMBER.put("nine", BigInteger.valueOf(9));
	        WORD_TO_NUMBER.put("ten", BigInteger.TEN);
	        WORD_TO_NUMBER.put("eleven", BigInteger.valueOf(11));
	        WORD_TO_NUMBER.put("twelve", BigInteger.valueOf(12));
	        WORD_TO_NUMBER.put("thirteen", BigInteger.valueOf(13));
	        WORD_TO_NUMBER.put("fourteen", BigInteger.valueOf(14));
	        WORD_TO_NUMBER.put("fifteen", BigInteger.valueOf(15));
	        WORD_TO_NUMBER.put("sixteen", BigInteger.valueOf(16));
	        WORD_TO_NUMBER.put("seventeen", BigInteger.valueOf(17));
	        WORD_TO_NUMBER.put("eighteen", BigInteger.valueOf(18));
	        WORD_TO_NUMBER.put("nineteen", BigInteger.valueOf(19));
	        WORD_TO_NUMBER.put("twenty", BigInteger.valueOf(20));
	        WORD_TO_NUMBER.put("thirty", BigInteger.valueOf(30));
	        WORD_TO_NUMBER.put("forty", BigInteger.valueOf(40));
	        WORD_TO_NUMBER.put("fifty", BigInteger.valueOf(50));
	        WORD_TO_NUMBER.put("sixty", BigInteger.valueOf(60));
	        WORD_TO_NUMBER.put("seventy", BigInteger.valueOf(70));
	        WORD_TO_NUMBER.put("eighty", BigInteger.valueOf(80));
	        WORD_TO_NUMBER.put("ninety", BigInteger.valueOf(90));
	        WORD_TO_NUMBER.put("hundred", BigInteger.valueOf(100));
	        WORD_TO_NUMBER.put("thousand", BigInteger.valueOf(1000));
	        WORD_TO_NUMBER.put("million", BigInteger.valueOf(1000000));
	        WORD_TO_NUMBER.put("billion", BigInteger.valueOf(1000000000));

	        // Turkish numbers
	        WORD_TO_NUMBER.put("sıfır", BigInteger.ZERO);
	        WORD_TO_NUMBER.put("bir", BigInteger.ONE);
	        WORD_TO_NUMBER.put("iki", BigInteger.valueOf(2));
	        WORD_TO_NUMBER.put("üç", BigInteger.valueOf(3));
	        WORD_TO_NUMBER.put("dört", BigInteger.valueOf(4));
	        WORD_TO_NUMBER.put("beş", BigInteger.valueOf(5));
	        WORD_TO_NUMBER.put("altı", BigInteger.valueOf(6));
	        WORD_TO_NUMBER.put("yedi", BigInteger.valueOf(7));
	        WORD_TO_NUMBER.put("sekiz", BigInteger.valueOf(8));
	        WORD_TO_NUMBER.put("dokuz", BigInteger.valueOf(9));
	        WORD_TO_NUMBER.put("on", BigInteger.TEN);
	        WORD_TO_NUMBER.put("yirmi", BigInteger.valueOf(20));
	        WORD_TO_NUMBER.put("otuz", BigInteger.valueOf(30));
	        WORD_TO_NUMBER.put("kırk", BigInteger.valueOf(40));
	        WORD_TO_NUMBER.put("elli", BigInteger.valueOf(50));
	        WORD_TO_NUMBER.put("altmış", BigInteger.valueOf(60));
	        WORD_TO_NUMBER.put("yetmiş", BigInteger.valueOf(70));
	        WORD_TO_NUMBER.put("seksen", BigInteger.valueOf(80));
	        WORD_TO_NUMBER.put("doksan", BigInteger.valueOf(90));
	        WORD_TO_NUMBER.put("yüz", BigInteger.valueOf(100));
	        WORD_TO_NUMBER.put("bin", BigInteger.valueOf(1000));
	        WORD_TO_NUMBER.put("milyon", BigInteger.valueOf(1000000));
	        WORD_TO_NUMBER.put("milyar", BigInteger.valueOf(1000000000));
	        WORD_TO_NUMBER.put("trilyon", new BigInteger("1000000000000"));
	        WORD_TO_NUMBER.put("katrilyon", new BigInteger("1000000000000000"));
	        WORD_TO_NUMBER.put("kentilyon", new BigInteger("1000000000000000000"));
	        WORD_TO_NUMBER.put("sekstilyon", new BigInteger("1000000000000000000000"));
	        WORD_TO_NUMBER.put("septilyon", new BigInteger("1000000000000000000000000"));
	        WORD_TO_NUMBER.put("oktilyon", new BigInteger("1000000000000000000000000000"));
	        WORD_TO_NUMBER.put("nonilyon", new BigInteger("1000000000000000000000000000000"));
	        WORD_TO_NUMBER.put("desilyon", new BigInteger("1000000000000000000000000000000000"));
	    }
   
=======
import java.text.DecimalFormat;

public class ConversionServiceImp implements ConversionService{

    private final String[] numberWords = {"", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz"};
    private final String[] tensWords = {"", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};
    private final String[] magnitudeWords = {"", "bin", "milyon", "milyar", "trilyon", "katrilyon", "kentilyon", "seksilyon", "septilyon", "oktilyon", "nonilyon", "desilyon"};

    private final String[] tensWordsEnglish = { ""," ten"," twenty"," thirty"," forty"," fifty"," sixty"," seventy"," eighty"," ninety"};    
    private final String[] numberWordsEnglish = {""," one", " two","three", "four", "five",  "six", "seven","eight", "nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen", "eighteen","nineteen"};
    private final String[] magnitudeWordsEnglish = {"", "thousand", "million", "billion", "trillion"};
    
>>>>>>> 3a5ac9e4f6619d7532ee7b8419bdaced2c4e27a5
    private Language language = Language.Turkish;
    
    
    public void setLanguage(Language language) 
    {
    	this.language = language;
    }
    
<<<<<<< HEAD
    @Override
    public BigInteger textToNumber(String text) {
        try {
            return convertToNumber(text);
        } catch (IllegalArgumentException e) {
            try {
                BigInteger number = new BigInteger(text);
                if (number.compareTo(BigInteger.ZERO) < 0 || number.compareTo(MAX_SUPPORTED_NUMBER) > 0) {
                	if(language == Language.Turkish) {
                		JOptionPane.showMessageDialog(null, "Girilen sayı aralık dışında. Lütfen 0 ile arasında bir sayı girin." );
                	}else {
                    JOptionPane.showMessageDialog(null, "Input number is out of range. Please enter a number between 0 and " );
                	}
                }
                return null;
            } catch (NumberFormatException ex) {
            	if(language == Language.Turkish) {
            		 JOptionPane.showMessageDialog(null, "Girdiğiniz sayıların harflerle girilmesi ve aynı dilde olması gerekmektedir. \\ Örnek: \"six\"-\"six\" veya \"yedi\"-\"yedi\"");
            	}else {
                JOptionPane.showMessageDialog(null, "The numbers you enter must be entered in letters and must be in the same language. \\ Example: \"yedi\"-\"yedi\" or \"six\"-\"six\"");
            	}
                return null;
            }
        }
    }

      public static BigInteger convertToNumber(String words) {
          String[] wordArray = words.split(" ");
          BigInteger number = BigInteger.ZERO;
          BigInteger temp = BigInteger.ZERO;
          boolean negative = false;
          for (String word : wordArray) {
              if (word.equals("and") || word.equals("ve")) {
                  continue; 
              }
              if (word.equals("minus") || word.equals("eksi")) {
                  negative = true; 
                  continue; 
              }
              BigInteger value = WORD_TO_NUMBER.get(word);
              if (value == null) {
                  throw new IllegalArgumentException("Unknown word: " + word);
              }
              if (value.equals(BigInteger.valueOf(100))) {
                  temp = temp.multiply(value);
              } else if (value.compareTo(BigInteger.valueOf(1000)) >= 0) {
                  number = number.add(temp.multiply(value));
                  temp = BigInteger.ZERO;
              } else {
                  temp = temp.add(value);
              }
              
          }
          number = number.add(temp);
          if (negative) {
              number = number.negate(); 
          }
          return number;
      }

      
      private static final Map<BigInteger, String> ENGLISH_NUMBER_MAP = new HashMap<>();
      private static final Map<BigInteger, String> TURKISH_NUMBER_MAP = new HashMap<>();

      static {
          // English numbers
          ENGLISH_NUMBER_MAP.put(BigInteger.ZERO, "zero");
          ENGLISH_NUMBER_MAP.put(BigInteger.ONE, "one");
          ENGLISH_NUMBER_MAP.put(BigInteger.valueOf(2), "two");
          ENGLISH_NUMBER_MAP.put(BigInteger.valueOf(3), "three");
          ENGLISH_NUMBER_MAP.put(BigInteger.valueOf(4), "four");
          ENGLISH_NUMBER_MAP.put(BigInteger.valueOf(5), "five");
          ENGLISH_NUMBER_MAP.put(BigInteger.valueOf(6), "six");
          ENGLISH_NUMBER_MAP.put(BigInteger.valueOf(7), "seven");
          ENGLISH_NUMBER_MAP.put(BigInteger.valueOf(8), "eight");
          ENGLISH_NUMBER_MAP.put(BigInteger.valueOf(9), "nine");
          ENGLISH_NUMBER_MAP.put(BigInteger.TEN, "ten");
          ENGLISH_NUMBER_MAP.put(BigInteger.valueOf(11), "eleven");
          ENGLISH_NUMBER_MAP.put(BigInteger.valueOf(12), "twelve");
          ENGLISH_NUMBER_MAP.put(BigInteger.valueOf(13), "thirteen");
          ENGLISH_NUMBER_MAP.put(BigInteger.valueOf(14), "fourteen");
          ENGLISH_NUMBER_MAP.put(BigInteger.valueOf(15), "fifteen");
          ENGLISH_NUMBER_MAP.put(BigInteger.valueOf(16), "sixteen");
          ENGLISH_NUMBER_MAP.put(BigInteger.valueOf(17), "seventeen");
          ENGLISH_NUMBER_MAP.put(BigInteger.valueOf(18), "eighteen");
          ENGLISH_NUMBER_MAP.put(BigInteger.valueOf(19), "nineteen");
          ENGLISH_NUMBER_MAP.put(BigInteger.valueOf(20), "twenty");
          ENGLISH_NUMBER_MAP.put(BigInteger.valueOf(30), "thirty");
          ENGLISH_NUMBER_MAP.put(BigInteger.valueOf(40), "forty");
          ENGLISH_NUMBER_MAP.put(BigInteger.valueOf(50), "fifty");
          ENGLISH_NUMBER_MAP.put(BigInteger.valueOf(60), "sixty");
          ENGLISH_NUMBER_MAP.put(BigInteger.valueOf(70), "seventy");
          ENGLISH_NUMBER_MAP.put(BigInteger.valueOf(80), "eighty");
          ENGLISH_NUMBER_MAP.put(BigInteger.valueOf(90), "ninety");

          // Turkish numbers
          TURKISH_NUMBER_MAP.put(BigInteger.ZERO, "sıfır");
          TURKISH_NUMBER_MAP.put(BigInteger.ONE, "bir");
          TURKISH_NUMBER_MAP.put(BigInteger.valueOf(2), "iki");
          TURKISH_NUMBER_MAP.put(BigInteger.valueOf(3), "üç");
          TURKISH_NUMBER_MAP.put(BigInteger.valueOf(4), "dört");
          TURKISH_NUMBER_MAP.put(BigInteger.valueOf(5), "beş");
          TURKISH_NUMBER_MAP.put(BigInteger.valueOf(6), "altı");
          TURKISH_NUMBER_MAP.put(BigInteger.valueOf(7), "yedi");
          TURKISH_NUMBER_MAP.put(BigInteger.valueOf(8), "sekiz");
          TURKISH_NUMBER_MAP.put(BigInteger.valueOf(9), "dokuz");
          TURKISH_NUMBER_MAP.put(BigInteger.TEN, "on");
          TURKISH_NUMBER_MAP.put(BigInteger.valueOf(20), "yirmi");
          TURKISH_NUMBER_MAP.put(BigInteger.valueOf(30), "otuz");
          TURKISH_NUMBER_MAP.put(BigInteger.valueOf(40), "kırk");
          TURKISH_NUMBER_MAP.put(BigInteger.valueOf(50), "elli");
          TURKISH_NUMBER_MAP.put(BigInteger.valueOf(60), "altmış");
          TURKISH_NUMBER_MAP.put(BigInteger.valueOf(70), "yetmiş");
          TURKISH_NUMBER_MAP.put(BigInteger.valueOf(80), "seksen");
          TURKISH_NUMBER_MAP.put(BigInteger.valueOf(90), "doksan");
      }
      
    public String numberToText(BigInteger number) 
    {
     if(language == Language.Turkish) 
     {
    	 return convertToText(number,true);
     }else 
     {
    	 return convertToText(number,false);
=======
      @Override
    public int textToNumber(String text) {
        if(language == Language.Turkish) 
        {
       	 return textToNumberTurkishImp(text);
        }else 
        {
       	 return textToNumberEnglishImp(text);
        }
    }

    private int textToNumberTurkishImp(String text) {
        text = text.toLowerCase().trim();
        String[] parts = text.split(" ");			
        int number = 0;
        long currentNumber = 0;
        long currentMagnitude = 1;
        for (String part : parts) {
            boolean found = false;
            for (int i = 0; i < numberWords.length; i++) {
                if (part.equals(numberWords[i])) {
                    currentNumber += i;
                    found = true;
                    break;
                }
            }
            if (!found) {
                for (int i = 0; i < tensWords.length; i++) {
                    if (part.equals(tensWords[i])) {
                        currentNumber += i * 10;
                        found = true;
                        break;
                    }
                }
            }
            if (!found && part.equals("yüz")) {
                currentNumber = (currentNumber == 0 ? 1 : currentNumber) * 100;
                found = true;
            }
            if (!found) {
                for (int i = 0; i < magnitudeWords.length; i++) {
                    if (part.equals(magnitudeWords[i])) {
                        currentMagnitude = (long) Math.pow(10, i * 3);
                        if (currentNumber == 0) {
                            currentNumber = 1;
                        }
                        break;
                    }
                }
            }
            if (currentNumber > 0 && currentMagnitude > 1) {
                number += currentNumber * currentMagnitude;
                currentNumber = 0;
                currentMagnitude = 1;
            }
        }
        number += currentNumber * currentMagnitude;
        return number;
    }
    
    private int textToNumberEnglishImp(String text) {
        text = text.toLowerCase().trim();
        String[] parts = text.split(" ");			
        int number = 0;
        long currentNumber = 0;
        long currentMagnitude = 1;
        for (String part : parts) {
            boolean found = false;
            for (int i = 0; i < numberWordsEnglish.length; i++) {
                if (part.equals(numberWordsEnglish[i])) {
                    currentNumber += i;
                    found = true;
                    break;
                }
            }
            if (!found) {
                for (int i = 0; i < tensWordsEnglish.length; i++) {
                    if (part.equals(tensWordsEnglish[i])) {
                        currentNumber += i * 10;
                        found = true;
                        break;
                    }
                }
            }
            if (!found && part.equals("hundred")) {
                currentNumber = (currentNumber == 0 ? 1 : currentNumber) * 100;
                found = true;
            }
            if (!found) {
                for (int i = 0; i < magnitudeWordsEnglish.length; i++) {
                    if (part.equals(magnitudeWordsEnglish[i])) {
                        currentMagnitude = (long) Math.pow(10, i * 3);
                        if (currentNumber == 0) {
                            currentNumber = 1;
                        }
                        break;
                    }
                }
            }
            if (currentNumber > 0 && currentMagnitude > 1) {
                number += currentNumber * currentMagnitude;
                currentNumber = 0;
                currentMagnitude = 1;
            }
        }
        number += currentNumber * currentMagnitude;
        return number;
    }
    
    @Override
    public String numberToText(int number) 
    {
     if(language == Language.Turkish) 
     {
    	 return numberToTextTurkishImp(number);
     }else 
     {
    	 return numberToTextEnglishImp(number);
>>>>>>> 3a5ac9e4f6619d7532ee7b8419bdaced2c4e27a5
     }

    }
    
<<<<<<< HEAD
    public static String convertToText(BigInteger number, boolean isTurkish) {
        if (number.equals(BigInteger.ZERO)) {
            return isTurkish ? "sıfır" : "zero";
        }

        if (number.compareTo(BigInteger.ZERO) < 0) {
            return isTurkish ? "eksi " + convertToText(number.negate(), true) : "minus " + convertToText(number.negate(), false);
        }

        Map<BigInteger, String> numberMap = isTurkish ? TURKISH_NUMBER_MAP : ENGLISH_NUMBER_MAP;

        String text = "";
        BigInteger quintillion = new BigInteger("1000000000000000000");
        BigInteger quadrillion = new BigInteger("1000000000000000");
        BigInteger trillion = new BigInteger("1000000000000");
        BigInteger billion = BigInteger.valueOf(1000000000);
        BigInteger million = BigInteger.valueOf(1000000);
        BigInteger thousand = BigInteger.valueOf(1000);
        BigInteger hundred = BigInteger.valueOf(100);
        
        if (number.compareTo(quintillion) >= 0) {
            text += convertToText(number.divide(quintillion), isTurkish) + (isTurkish ? " desilyon " : " quintillion ");
            number = number.remainder(quintillion);
        }

        if (number.compareTo(quadrillion) >= 0) {
            text += convertToText(number.divide(quadrillion), isTurkish) + (isTurkish ? " katrilyon " : " quadrillion ");
            number = number.remainder(quadrillion);
        }

        if (number.compareTo(trillion) >= 0) {
            text += convertToText(number.divide(trillion), isTurkish) + (isTurkish ? " trilyon " : " trillion ");
            number = number.remainder(trillion);
        }

        if (number.compareTo(billion) >= 0) {
            text += convertToText(number.divide(billion), isTurkish) + (isTurkish ? " milyar " : " billion ");
            number = number.remainder(billion);
        }

        if (number.compareTo(million) >= 0) {
            text += convertToText(number.divide(million), isTurkish) + (isTurkish ? " milyon " : " million ");
            number = number.remainder(million);
        }

        if (number.compareTo(thousand) >= 0) {
            text += convertToText(number.divide(thousand), isTurkish) + (isTurkish ? " bin " : " thousand ");
            number = number.remainder(thousand);
        }

        if (number.compareTo(hundred) >= 0) {
            text += numberMap.get(number.divide(hundred)) + (isTurkish ? " yüz " : " hundred ");
            number = number.remainder(hundred);
        }

        if (number.compareTo(BigInteger.valueOf(20)) >= 0) {
            text += numberMap.get(number.divide(BigInteger.TEN).multiply(BigInteger.TEN));
            number = number.remainder(BigInteger.TEN);

            if (!number.equals(BigInteger.ZERO)) {
                text += isTurkish ? " " : " and "; 
            }
        }

        if (number.compareTo(BigInteger.ZERO) > 0) {
            if (!text.isEmpty()) {
                text += isTurkish ? " " : " "; 
            }
            text += numberMap.get(number);
        }

        return text;
    }


      
}
=======
    private String numberToTextTurkishImp(int number) 
    {
    	if(number == 0) {
    		return "sıfır";
    	}
    	
    	String snumber = Long.toString(number);

      
        String mask = "000000000000";
        DecimalFormat decimalformat = new DecimalFormat(mask);
        snumber = decimalformat.format(number);

        
        int billions = Integer.parseInt(snumber.substring(0,3));
        
        int millions  = Integer.parseInt(snumber.substring(3,6));
        
        int hundredThousands = Integer.parseInt(snumber.substring(6,9));
        
        int thousands = Integer.parseInt(snumber.substring(9,12));

        
        String tradBillions;
        switch (billions) {
        case 0:
          tradBillions = "";
          break;
        case 1 :
          tradBillions = convertLessThanOneThousandTurkish(billions)
          + " milyar ";
          break;
        default :
          tradBillions = convertLessThanOneThousandTurkish(billions)
          + " milyar ";
        }
        String result =  tradBillions;

        
        String tradMillions;
        switch (millions) {
        case 0:
          tradMillions = "";
          break;
        case 1 :
          tradMillions = convertLessThanOneThousandTurkish(millions)
             + " milyon ";
          break;
        default :
          tradMillions = convertLessThanOneThousandTurkish(millions)
             + " milyon ";
        }
        result =  result + tradMillions;

        
        String tradHundredThousands;
        switch (hundredThousands) {
        case 0:
          tradHundredThousands = "";
          break;
        case 1 :
          tradHundredThousands = "bin ";
          break;
        default :
          tradHundredThousands = convertLessThanOneThousandTurkish(hundredThousands)
             + " bin ";
        }
        result =  result + tradHundredThousands;

        String tradThousand;
        tradThousand = convertLessThanOneThousandTurkish(thousands);
        result =  result + tradThousand;

        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }
    
    
    private String convertLessThanOneThousandTurkish(int number) {
        String tempResult;

        if (number % 100 < 10){
          tempResult = numberWords[number % 100];
          number /= 100;
        }
        else {
          tempResult = numberWords[number % 10];
          number /= 10;

          tempResult = tensWords[number % 10] + " " + tempResult;
          number /= 10;
        }
        if (number == 0) return tempResult;
        if(number == 1){
        	 return "yüz " + tempResult;
        }
        return numberWords[number] + " yüz " + tempResult;
      } 
    
    
    private String numberToTextEnglishImp(int number) 
    {
    	if(number == 0) {
    		return "zero";
    	}
    	
    	String snumber = Long.toString(number);

        String mask = "000000000000";
        DecimalFormat df = new DecimalFormat(mask);
        snumber = df.format(number);

        int billions = Integer.parseInt(snumber.substring(0,3));

        int millions  = Integer.parseInt(snumber.substring(3,6));
    
        int hundredThousands = Integer.parseInt(snumber.substring(6,9));
      
        int thousands = Integer.parseInt(snumber.substring(9,12));
        

        String tradBillions;
        switch (billions) {
        case 0:
          tradBillions = "";
          break;
        case 1 :
          tradBillions = convertLessThanOneThousandEnglish(billions)
          + " milyar ";
          break;
        default :
          tradBillions = convertLessThanOneThousandEnglish(billions)
          + " milyar ";
        }
        String result =  tradBillions;

        
        String tradMillions;
        switch (millions) {
        case 0:
          tradMillions = "";
          break;
        case 1 :
          tradMillions = convertLessThanOneThousandEnglish(millions)
             + " milyon ";
          break;
        default :
          tradMillions = convertLessThanOneThousandEnglish(millions)
             + " milyon ";
        }
        result =  result + tradMillions;

        
        String tradHundredThousands;
        switch (hundredThousands) {
        case 0:
          tradHundredThousands = "";
          break;
        case 1 :
          tradHundredThousands = "bin ";
          break;
        default :
          tradHundredThousands = convertLessThanOneThousandEnglish(hundredThousands)
             + " bin ";
        }
        result =  result + tradHundredThousands;

        String tradThousand;
        tradThousand = convertLessThanOneThousandEnglish(thousands);
        result =  result + tradThousand;

        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }
    
    
    private String convertLessThanOneThousandEnglish(int number) {
        String tempResult;

        if (number % 100 < 20){
          tempResult = numberWordsEnglish[number % 100];
          number /= 100;
        }
        else {
          tempResult = numberWordsEnglish[number % 10];
          number /= 10;

          tempResult = tensWordsEnglish[number % 10] + " " + tempResult;
          number /= 10;
        }
        if (number == 0) return tempResult;
        return numberWordsEnglish[number] + " hundred " + tempResult;
      } 
    
    
}
>>>>>>> 3a5ac9e4f6619d7532ee7b8419bdaced2c4e27a5
