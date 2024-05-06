public class SideFunctions extends Checkers{
    public static int summarize(int ... values){
        int total = 0;
        for(int num : values){
            total += num;
        }
        return total;
    }

    public static int summarize(int[] value1, int ... values){
        int total = 0;
        for(int num1 : value1){
            total += num1;
        }
        for(int num : values){
            total += num;
        }
        return total;
    }

    public static int summarize(int[] ... values){
        int total = 0;
        for(int[] nums : values){
            for(int num : nums){
                total += num;
            }
        }
        return total;
    }
}
