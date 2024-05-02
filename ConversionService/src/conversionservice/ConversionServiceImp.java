package conversionservice;

import java.text.DecimalFormat;

public class ConversionServiceImp implements ConversionService{

    private final String[] numberWords = {"", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz"};
    private final String[] tensWords = {"", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};
    private final String[] magnitudeWords = {"", "bin", "milyon", "milyar", "trilyon", "katrilyon", "kentilyon", "seksilyon", "septilyon", "oktilyon", "nonilyon", "desilyon"};

    private final String[] tensWordsEnglish = { ""," ten"," twenty"," thirty"," forty"," fifty"," sixty"," seventy"," eighty"," ninety"};    
    private final String[] numberWordsEnglish = {""," one", " two","three", "four", "five",  "six", "seven","eight", "nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen", "eighteen","nineteen"};
    private final String[] magnitudeWordsEnglish = {"", "thousand", "million", "billion", "trillion"};
    
    private Language language = Language.Turkish;
    
    
    public void setLanguage(Language language) 
    {
    	this.language = language;
    }
    
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
     }

    }
    
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
