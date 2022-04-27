package az.yigim.linkpayment.utils.encrypter;

import org.mindrot.jbcrypt.BCrypt;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncrypterImpl implements EncrypterInter {

//    @Override
//    public String encode(String s) {
//        return BCrypt.hashpw(s, BCrypt.gensalt(s.length()));
//    }

    @Override
    public Boolean check(String password, String oldPassword) {
        return BCrypt.checkpw(password, oldPassword);
    }
}
