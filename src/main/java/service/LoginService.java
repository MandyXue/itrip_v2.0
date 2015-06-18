package service;


import dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2015/6/5.
 */
@Transactional
@Service
public class LoginService {
    @Autowired
    private LoginDao loginDao;

    public String check(String username, String password) {
        return loginDao.checklogin(username, password);
    }

}
