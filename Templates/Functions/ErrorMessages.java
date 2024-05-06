import java.util.ArrayList;

public class ErrorMessages extends Prints{
    static ArrayList<String> stackedError = new ArrayList<String>();

    static public void addStackedError(String errMessage){
        stackedError.add(errMessage);
    }

    static public boolean stackedErrorFilled(){
        return (stackedError.size() > 0) ? true : false;
    }

    static public String printStackedError(){
        String errMessage = "Your Input Consists of " + ((stackedError.size() > 1) ? "These Errors" : "This Error") + ":\n";
        for(int i = 0; i < stackedError.size(); i++){
            errMessage += ((i + 1) + ". " + stackedError.get(i) + ((i < stackedError.size() - 1) ? ",\n" : ""));
        }
        stackedError.clear();
        return errMessage;
    }

    static public String patternErrors(String errName){
        switch(errName.toLowerCase()){
            case "lowercase":
                return "Your Input Contains Lowercase Characters!";
            case "uppercase":
                return "Your Input Contains Uppercase Characters!";
        }
        return "Invalid";
    }

    static public String commonErrors(String errName){
        switch(errName.toLowerCase()){
            case "empty input":
                return "Your Input is Empty!";
        }
        return "Invalid";
    }

    static public String numberErrors(String errName){
        switch(errName.toLowerCase()){
            case "surpass int":
                return "Your Input Surpassed Integer Limits!";
            case "not an int":
                return "Your Input is Not an Integer!";
            case "lower than min":
                return "Your Input is Lower Than ";
            case "higher than max":
                return "Your Input is Higher Than ";
        }
        return "Invalid Integer";
    }

    static public String exceptionErrors(String errName){
        switch(errName.toLowerCase()){
            case "number format":
                return "Your Number is Invalid!";
            case "program exitted":
                System.out.println("Program Was Force Closed!");
                System.exit(0);
            default:
                return "Something Went Wrong!";
        }
    }
}
