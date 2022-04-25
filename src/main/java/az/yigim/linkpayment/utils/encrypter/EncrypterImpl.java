package az.yigim.linkpayment.utils.encrypter;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncrypterImpl implements EncrypterInter{

    @Override
    public String encode(String s) throws NoSuchAlgorithmException {
        byte[] digest = MessageDigest.getInstance("MD5").digest(s.getBytes());
        return DatatypeConverter.printHexBinary(digest).toUpperCase();
    }
}
