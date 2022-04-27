package az.yigim.linkpayment.utils.encrypter;

public interface EncrypterInter {

//    String encode(String password);

    Boolean check(String password, String oldPassword);
}
