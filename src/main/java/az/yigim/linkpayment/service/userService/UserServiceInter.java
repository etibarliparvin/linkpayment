package az.yigim.linkpayment.service.userService;

import az.yigim.linkpayment.entity.concretes.User;

public interface UserServiceInter {

    User findUserByUsernameAndPassword(String username, String password) throws Exception;
}
