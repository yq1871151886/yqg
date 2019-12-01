package com.fh.service;



import com.fh.bean.User;

import java.util.List;

public interface UserService {

    User queryUserByLoginName(String loginName);

}
