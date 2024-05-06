import java.util.function.Consumer;
public class YapFunctions extends NewPrints{
    public static void yall(
        IntInitializer init,
        IntCondition condition,
        IntUpdater update,
        Consumer<Integer> action) {
            int i = init.initialize();
            while (condition.test(i)) {
                action.accept(i);
                i = update.update(i);
            }
    }

    public static void impostor(boolean condition, Runnable action) {
        if (condition) {
            action.run();
        }
    }

interface IntInitializer {
    int initialize();
}

interface IntCondition {
    boolean test(int i);
}

interface IntUpdater {
    int update(int i);
}
}