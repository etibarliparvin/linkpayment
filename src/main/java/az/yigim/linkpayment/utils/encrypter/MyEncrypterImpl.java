package az.yigim.linkpayment.utils.encrypter;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class MyEncrypterImpl implements MyEncrypterInter {

    private static final int ITERATIONS = 65536;
    private static final char[] ALPHABET = "0123456789ABCDEF".toCharArray();

    @Override
    public byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    @Override
    public byte[] generateHash(String password, byte[] salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeySpec tmp = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, 16 * 8);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        return factory.generateSecret(tmp).getEncoded();
    }

    @Override
    public String encode(
            byte[] generatedHash
    ) {
        char[] chr = new char[generatedHash.length * 2];
        for (int j = 0; j < generatedHash.length; j++) {
            int v = generatedHash[j] & 0xFF;
            chr[j * 2] = ALPHABET[v >>> 4];
            chr[j * 2 + 1] = ALPHABET[v & 0x0F];
        }
        return new String(chr);
    }

    @Override
    public byte[] decode(
            String hex
    ) {
        int length = hex.length();
        byte[] data = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4) + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }
}
