import java.math.BigInteger;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

public class Checkers extends ErrorMessages{
    public static boolean checkDecimal(String value){
        try {
            Integer.parseInt(value);
            return true;
       }
        catch (NumberFormatException ex) {
            return false;
       }
    }

    public static boolean checkIntLimit(String value){
        try {
            final BigInteger maxInt = BigInteger.valueOf(Integer.MAX_VALUE);
            final BigInteger minInt = BigInteger.valueOf(Integer.MIN_VALUE);
            BigInteger angka = new BigInteger(value);
            if(angka.compareTo(maxInt) > 0 && angka.compareTo(minInt) < 1){
                return false;
            } else{
                return true;
            }
       }
        catch (NumberFormatException ex) {
            return false;
       }
    }

    static public boolean checkIntInput(String text){
        try{
            if(text.matches("^([+-]?(\\d+\\.)?\\d+)$") && !text.matches("")){
                if(checkDecimal(text)){
                    return true;
                } else{
                    println("\n" + ((checkIntLimit(text)) ? numberErrors("surpass int") : numberErrors("not an int")));
                }
            } else{
                if(text.matches("") || text.matches("^[\\s]*$")){
                    println("\n" + commonErrors("empty input"));
                } else{
                    Pattern lowerLetter = Pattern.compile("[a-z]");
                    Pattern higherLetter = Pattern.compile("[A-Z]");
                    if(lowerLetter.matcher(text).find()){
                        addStackedError(patternErrors("lowercase"));
                    } 
                    if(higherLetter.matcher(text).find()){
                        addStackedError(patternErrors("uppercase"));
                    } 
                    if(!Pattern.matches("[\\p{Alnum}]+", text)){
                        addStackedError(patternErrors("symbol"));
                    }
                    if(stackedErrorFilled()){
                        printStackedError();
                    } else{
                        return true;
                    }
                }
            }
        } catch(NumberFormatException e){
            println("\n" + exceptionErrors("number format"));
        } catch(NoSuchElementException e){
            println("\n" + exceptionErrors("program exitted"));
        } catch(Exception e){
            println("\n" + exceptionErrors(""));
        }
        return false;
    }
}
