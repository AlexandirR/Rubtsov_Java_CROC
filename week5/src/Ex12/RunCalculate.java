package Ex12;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RunCalculate implements Runnable {
    private final int number;
    private final int count;
    private final int symbols;
    private long begin;
    private long end;
    private final int alphabet = 26;
    private final long countSymbols;
    private static volatile boolean findPassword = false;
    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();

    private static final Object lock = new Object();

    public RunCalculate(int number, int count, int symbols) {
        this.number = number;
        this.count = count;
        this.symbols = symbols;
        countSymbols = (long)(Math.pow(26, symbols));
        begin = (countSymbols*(number - 1))/count;
        end = (countSymbols*number)/count - 1;
    }

    @Override
    public void run() {
        System.out.println(begin + " " + end);
        for (long i = begin; i <= end && !findPassword; ++i) {
            String password = createCombination(i).toString();
            //System.out.println(password);
                if (hashPassword(password).equals(CreatePassword.hex)) {
                    CreatePassword.password = password;
                    findPassword = true;
                }
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


    private StringBuilder createCombination(long hex) {
        int[] password = new int[symbols];
        for(int i = 1; i <= symbols; ++i) {
            password[i - 1] = (int) (hex%alphabet);
            hex /= alphabet;
        }
        StringBuilder pass = new StringBuilder("");
        for(int i = 0; i < symbols; ++i) {
            pass.append((char)('a' + password[i]));
        }
        return pass;
    }
}
