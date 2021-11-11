package Ex12;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RunCalculate implements Runnable {
    private final int number;
    private final int count;
    private final int symbols;
    private long[] begin;
    private long[] end;
    private final int alphabet = 26;
    private final long countSymbols;
    private static volatile boolean findPassword = false;
    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();

    private static final Object lock = new Object();

    public RunCalculate(int number, int count, int symbols) {
        this.number = number;
        this.count = count;
        this.symbols = symbols;
        begin = new long[symbols];
        end = new long[symbols];
        countSymbols = (long)(Math.pow(26,symbols));
    }

    @Override
    public void run() {
        StringBuilder password = new StringBuilder("");
        createBounds();
        recPas(password, symbols - 1);
    }

    private void recPas(StringBuilder password, int level) {
        if(level != -1) {
            for (long i = begin[level]; i <= end[level]; ++i) {
                password.append((char)('a' + (int)(i)));
                recPas(password, level - 1);
                if(findPassword) {
                    return;
                }
                password.deleteCharAt(password.length() - 1);
            }
        }
        else if(hashPassword(password.toString()).equals(CreatePassword.hex)) {
                CreatePassword.password = password.toString();
                findPassword = true;
                return;
        }
    }

    private static String toHexString(byte[] bytes) {
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hex.append(HEX_DIGITS[(b & 0xff) >> 4]);
            hex.append(HEX_DIGITS[b & 0x0f]);
        }
        return hex.toString();
    }

    private static String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        digest.update(password.getBytes());
        byte[] bytes = digest.digest();
        return toHexString(bytes);
    }


    private void createBounds() {
        long startPos = (countSymbols*(number - 1))/count;
        for(int i = 1; i <= symbols; ++i) {
            begin[i - 1] = startPos%alphabet;
            startPos /= alphabet;
        }
        long endPos = (countSymbols*number)/count - 1;
        for(int i = 1; i <= symbols; ++i) {
            end[i - 1] = endPos%alphabet;
            endPos /= alphabet;
        }
    }
}
