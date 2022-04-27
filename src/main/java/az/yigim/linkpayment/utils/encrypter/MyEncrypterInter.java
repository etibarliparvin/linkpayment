package az.yigim.linkpayment.utils.encrypter;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface MyEncrypterInter {

    byte[] generateSalt();

    byte[] generateHash(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException;

    String encode(byte[] generatedHash);

    byte[] decode(String hex);
}
