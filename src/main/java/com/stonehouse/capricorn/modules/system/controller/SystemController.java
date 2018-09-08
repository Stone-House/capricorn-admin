package com.stonehouse.capricorn.modules.system.controller;

import com.stonehouse.capricorn.modules.system.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Libin
 */
@RestController
@Api(tags = "系统接口", value = "/system")
@RequestMapping("/system")
public class SystemController {


    @PostMapping("login")
    @ApiOperation("登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value="用户id", paramType = "form", dataType = "Integer"),
            @ApiImplicitParam(name = "userName", value="用户名", paramType = "form", dataType = "String", required = true),
            @ApiImplicitParam(name = "password", value="密码", paramType = "form", dataType = "String", required = true)
    })
    public Map<String, Object> login(User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("flag", false);
        if ("stonehouse".equals(user.getUserName()) && "capricorn".equals(user.getPassword())) {
            map.put("flag", true);
        }
        return map;
    }

}
