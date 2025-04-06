public final class DigitalWallet {
    private static volatile DigitalWallet instance;
    private DigitalWallet() {}
    public static DigitalWallet getInstance() {
        DigitalWallet result = instance;
        if (result != null) {
            return result;
        }
        synchronized (DigitalWallet.class) {
            if (instance == null) {
                instance = new DigitalWallet();
            }
            return instance;
        }
    }
}
