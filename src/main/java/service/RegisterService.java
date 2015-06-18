package service;

import dao.RegisterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2015/6/6.
 */
@Transactional
@Service
public class RegisterService {
    @Autowired
    private RegisterDao registerDao;

    public String check(String username, String password, String email) {
        return registerDao.checkregister(username, password, email);
    }
}
