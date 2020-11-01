import java.util.InputMismatchException;
import java.util.Scanner;

public class KeyboardManager {

    private static volatile KeyboardManager instance;

    public static KeyboardManager getInstance() {
        if (instance == null) {
            synchronized (KeyboardManager.class) {
                if (instance == null) {
                    instance = new KeyboardManager();
                }
            }
        }
        return instance;
    }

    private KeyboardManager() {}

    public int getNumber() {
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }
}
