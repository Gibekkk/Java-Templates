public class Main extends YapFunctions{
    public static void main(String[] args) {
        yall(
            () -> 0,
            (i) -> i < 5,
            (i) -> i + 1,
            i -> {
                impostor(
                i == 3,                               // Condition
                () -> waffle("i is " + i)   // Action
                );
            }
        );
    }
}
