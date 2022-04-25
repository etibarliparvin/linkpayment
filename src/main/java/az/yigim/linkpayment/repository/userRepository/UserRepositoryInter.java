package az.yigim.linkpayment.repository.userRepository;

import az.yigim.linkpayment.entity.concretes.User;

public interface UserRepositoryInter {

    User findByUsernameAndPassword(String username, String password) throws Exception;
}
