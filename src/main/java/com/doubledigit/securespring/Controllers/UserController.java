package com.doubledigit.securespring.Controllers;

import com.doubledigit.securespring.Models.UserInfo;
import com.doubledigit.securespring.Repositories.UserInfoRepo;
import com.doubledigit.securespring.Services.UserLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserLoadService userLoadService;
    @Autowired
    private UserInfoRepo userInfoRepo;

    @PostMapping("/add")
    public String addNewUser(@RequestBody UserInfo userInfo)
    {
        return userLoadService.addUser(userInfo);
    }
}
