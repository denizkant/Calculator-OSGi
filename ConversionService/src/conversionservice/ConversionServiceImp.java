package conversionservice;


import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class ConversionServiceImp implements ConversionService{
	 private static final Map<String, BigInteger> WORD_TO_NUMBER_TURKISH = new HashMap<>();
	 private static final Map<String, BigInteger> WORD_TO_NUMBER_ENGLISH = new HashMap<>();
	 private static final BigInteger MAX_SUPPORTED_NUMBER = new BigInteger("999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
	    static {
	        // English numbers
	    	WORD_TO_NUMBER_ENGLISH.put("zero", BigInteger.ZERO);
	    	WORD_TO_NUMBER_ENGLISH.put("one", BigInteger.ONE);
	    	WORD_TO_NUMBER_ENGLISH.put("two", BigInteger.valueOf(2));
	    	WORD_TO_NUMBER_ENGLISH.put("three", BigInteger.valueOf(3));
	        WORD_TO_NUMBER_ENGLISH.put("four", BigInteger.valueOf(4));
	        WORD_TO_NUMBER_ENGLISH.put("five", BigInteger.valueOf(5));
	        WORD_TO_NUMBER_ENGLISH.put("six", BigInteger.valueOf(6));
	        WORD_TO_NUMBER_ENGLISH.put("seven", BigInteger.valueOf(7));
	        WORD_TO_NUMBER_ENGLISH.put("eight", BigInteger.valueOf(8));
	        WORD_TO_NUMBER_ENGLISH.put("nine", BigInteger.valueOf(9));
	        WORD_TO_NUMBER_ENGLISH.put("ten", BigInteger.TEN);
	        WORD_TO_NUMBER_ENGLISH.put("eleven", BigInteger.valueOf(11));
	        WORD_TO_NUMBER_ENGLISH.put("twelve", BigInteger.valueOf(12));
	        WORD_TO_NUMBER_ENGLISH.put("thirteen", BigInteger.valueOf(13));
	        WORD_TO_NUMBER_ENGLISH.put("fourteen", BigInteger.valueOf(14));
	        WORD_TO_NUMBER_ENGLISH.put("fifteen", BigInteger.valueOf(15));
	        WORD_TO_NUMBER_ENGLISH.put("sixteen", BigInteger.valueOf(16));
	        WORD_TO_NUMBER_ENGLISH.put("seventeen", BigInteger.valueOf(17));
	        WORD_TO_NUMBER_ENGLISH.put("eighteen", BigInteger.valueOf(18));
	        WORD_TO_NUMBER_ENGLISH.put("nineteen", BigInteger.valueOf(19));
	        WORD_TO_NUMBER_ENGLISH.put("twenty", BigInteger.valueOf(20));
	        WORD_TO_NUMBER_ENGLISH.put("thirty", BigInteger.valueOf(30));
	        WORD_TO_NUMBER_ENGLISH.put("forty", BigInteger.valueOf(40));
	        WORD_TO_NUMBER_ENGLISH.put("fifty", BigInteger.valueOf(50));
	        WORD_TO_NUMBER_ENGLISH.put("sixty", BigInteger.valueOf(60));
	        WORD_TO_NUMBER_ENGLISH.put("seventy", BigInteger.valueOf(70));
	        WORD_TO_NUMBER_ENGLISH.put("eighty", BigInteger.valueOf(80));
	        WORD_TO_NUMBER_ENGLISH.put("ninety", BigInteger.valueOf(90));
	        WORD_TO_NUMBER_ENGLISH.put("hundred", BigInteger.valueOf(100));
	        WORD_TO_NUMBER_ENGLISH.put("thousand", BigInteger.valueOf(1000));
	        WORD_TO_NUMBER_ENGLISH.put("million", BigInteger.valueOf(1000000));
	        WORD_TO_NUMBER_ENGLISH.put("billion", BigInteger.valueOf(1000000000));

	        // Turkish numbers
	        WORD_TO_NUMBER_TURKISH.put("sıfır", BigInteger.ZERO);
	        WORD_TO_NUMBER_TURKISH.put("bir", BigInteger.ONE);
	        WORD_TO_NUMBER_TURKISH.put("iki", BigInteger.valueOf(2));
	        WORD_TO_NUMBER_TURKISH.put("üç", BigInteger.valueOf(3));
	        WORD_TO_NUMBER_TURKISH.put("dört", BigInteger.valueOf(4));
	        WORD_TO_NUMBER_TURKISH.put("beş", BigInteger.valueOf(5));
	        WORD_TO_NUMBER_TURKISH.put("altı", BigInteger.valueOf(6));
	        WORD_TO_NUMBER_TURKISH.put("yedi", BigInteger.valueOf(7));
	        WORD_TO_NUMBER_TURKISH.put("sekiz", BigInteger.valueOf(8));
	        WORD_TO_NUMBER_TURKISH.put("dokuz", BigInteger.valueOf(9));
	        WORD_TO_NUMBER_TURKISH.put("on", BigInteger.TEN);
	        WORD_TO_NUMBER_TURKISH.put("yirmi", BigInteger.valueOf(20));
	        WORD_TO_NUMBER_TURKISH.put("otuz", BigInteger.valueOf(30));
	        WORD_TO_NUMBER_TURKISH.put("kırk", BigInteger.valueOf(40));
	        WORD_TO_NUMBER_TURKISH.put("elli", BigInteger.valueOf(50));
	        WORD_TO_NUMBER_TURKISH.put("altmış", BigInteger.valueOf(60));
	        WORD_TO_NUMBER_TURKISH.put("yetmiş", BigInteger.valueOf(70));
	        WORD_TO_NUMBER_TURKISH.put("seksen", BigInteger.valueOf(80));
	        WORD_TO_NUMBER_TURKISH.put("doksan", BigInteger.valueOf(90));
	        WORD_TO_NUMBER_TURKISH.put("yüz", BigInteger.valueOf(100));
	        WORD_TO_NUMBER_TURKISH.put("bin", BigInteger.valueOf(1000));
	        WORD_TO_NUMBER_TURKISH.put("milyon", BigInteger.valueOf(1000000));
	        WORD_TO_NUMBER_TURKISH.put("milyar", BigInteger.valueOf(1000000000));
	        WORD_TO_NUMBER_TURKISH.put("trilyon", new BigInteger("1000000000000"));
	        WORD_TO_NUMBER_TURKISH.put("katrilyon", new BigInteger("1000000000000000"));
	        WORD_TO_NUMBER_TURKISH.put("kentilyon", new BigInteger("1000000000000000000"));
	        WORD_TO_NUMBER_TURKISH.put("sekstilyon", new BigInteger("1000000000000000000000"));
	        WORD_TO_NUMBER_TURKISH.put("septilyon", new BigInteger("1000000000000000000000000"));
	        WORD_TO_NUMBER_TURKISH.put("oktilyon", new BigInteger("1000000000000000000000000000"));
	        WORD_TO_NUMBER_TURKISH.put("nonilyon", new BigInteger("1000000000000000000000000000000"));
	        WORD_TO_NUMBER_TURKISH.put("desilyon", new BigInteger("1000000000000000000000000000000000"));
	    }
   

    private static Language language = Language.Turkish;
    
    
    public void setLanguage(Language language) 
    {
    	ConversionServiceImp.language = language;
    }
    

    @Override
    public BigInteger textToNumber(String text) {
        try {
            return convertToNumber(text);
        } catch (IllegalArgumentException e) {
            try {
                BigInteger number = new BigInteger(text);
                if (number.compareTo(BigInteger.ZERO) < 0 || number.compareTo(MAX_SUPPORTED_NUMBER) > 0) {
                	if(language == Language.Turkish) {
                		JOptionPane.showMessageDialog(null, "Girilen sayı aralık dışında. Lütfen bir sayı girin." );
                	}else {
                    JOptionPane.showMessageDialog(null, "Input number is out of range. Please enter a number." );
                	}
                }
                return null;
            } catch (NumberFormatException ex) {
            	if(language == Language.Turkish) {
            		 JOptionPane.showMessageDialog(null, "Girdiğiniz sayıların harflerle girilmesi ve aynı dilde olması gerekmektedir. \n Örnek: \"six\"-\"seventeen\" veya \"altı\"-\"on yedi\"");
            	}else {
                JOptionPane.showMessageDialog(null, "The numbers you enter must be entered in letters and must be in the same language. \n Example: \\\"six\\\"-\\\"seventeen\\\" veya \\\"altı\\\"-\\\"on yedi\\\"");
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
              
              BigInteger value = BigInteger.ZERO;
              if(language == Language.English) 
              {
            	   value = WORD_TO_NUMBER_ENGLISH.get(word); 
              }else 
              {
            	   value = WORD_TO_NUMBER_TURKISH.get(word);
              }           
              
              
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
          TURKISH_NUMBER_MAP.put(BigInteger.valueOf(11), "on bir");
          TURKISH_NUMBER_MAP.put(BigInteger.valueOf(12), "on iki");
          TURKISH_NUMBER_MAP.put(BigInteger.valueOf(13), "on üç");
          TURKISH_NUMBER_MAP.put(BigInteger.valueOf(14), "on dört");
          TURKISH_NUMBER_MAP.put(BigInteger.valueOf(15), "on beş");
          TURKISH_NUMBER_MAP.put(BigInteger.valueOf(16), "on altı");
          TURKISH_NUMBER_MAP.put(BigInteger.valueOf(17), "on yedi");
          TURKISH_NUMBER_MAP.put(BigInteger.valueOf(18), "on sekiz");
          TURKISH_NUMBER_MAP.put(BigInteger.valueOf(19), "on dokuz");
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

     }

    }
    

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
