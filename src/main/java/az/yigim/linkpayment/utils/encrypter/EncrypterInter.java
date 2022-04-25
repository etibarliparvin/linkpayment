package az.yigim.linkpayment.utils.encrypter;

import java.security.NoSuchAlgorithmException;

public interface EncrypterInter {

    String encode(String s) throws NoSuchAlgorithmException;
}
