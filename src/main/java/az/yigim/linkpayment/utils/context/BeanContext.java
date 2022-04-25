package az.yigim.linkpayment.utils.context;

import az.yigim.linkpayment.repository.userRepository.UserRepositoryImpl;
import az.yigim.linkpayment.repository.userRepository.UserRepositoryInter;
import az.yigim.linkpayment.service.userService.UserServiceImpl;
import az.yigim.linkpayment.service.userService.UserServiceInter;
import az.yigim.linkpayment.utils.dbConnection.DbConnectionImpl;
import az.yigim.linkpayment.utils.dbConnection.DbConnectionInter;
import az.yigim.linkpayment.utils.encrypter.EncrypterImpl;
import az.yigim.linkpayment.utils.encrypter.EncrypterInter;

public class BeanContext {

    public static DbConnectionInter dbConnectionImpl() {
        return new DbConnectionImpl();
    }

    public static UserRepositoryInter userRepositoryImpl() {
        return new UserRepositoryImpl();
    }

    public static UserServiceInter userServiceImpl() {
        return new UserServiceImpl();
    }

    public static EncrypterInter encrypterImpl() {
        return new EncrypterImpl();
    }
}
