package az.yigim.linkpayment.service.userService;

import az.yigim.linkpayment.entity.concretes.User;
import az.yigim.linkpayment.repository.userRepository.UserRepositoryInter;
import az.yigim.linkpayment.utils.context.BeanContext;
import az.yigim.linkpayment.utils.encrypter.MyEncrypterImpl;
import az.yigim.linkpayment.utils.encrypter.MyEncrypterInter;

public class UserServiceImpl implements UserServiceInter {

    private final UserRepositoryInter userRepository = BeanContext.userRepositoryImpl();

    @Override
    public User findUserByUsernameAndPassword(String username, String password) throws Exception {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user == null) throw new IllegalArgumentException("User doesn't exist!!!");
        return user;
    }

}
