package com.study.ssm.demo.web.controller;

import java.io.Serializable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(tags = "UserinfoCtrl", description = "用户信息相关")
public class UserInfoCtrl
{
 
    @RequestMapping("/getInfo")
    @ApiOperation(value = "获取用户信息", httpMethod = "GET", notes = "显示用户信息，不显示密码")
    public Object getInfo(){
        return new String("User Information");
    }
    @ApiOperation(value = "登录", httpMethod = "POST", notes = "说明。。。")
    @ApiImplicitParams({
//    	@ApiImplicitParam(name = "name", value = "用户名", required = true, paramType = "query", dataType = "String"),
//    	@ApiImplicitParam(name = "password", value = "密码(MD5)", required = true, paramType = "query", dataType = "String"),
//    	@ApiImplicitParam(name = "rememberMe",value = "是否记住登录状态", defaultValue = "false", paramType = "query", dataType = "boolean")
    })
    @RequestMapping("/login")
    @ResponseBody
    public Object login(@RequestBody LoginVO user, @RequestParam(defaultValue = "false") Boolean rememberMe){
    	return new String("userlogin success");
    }
    
    
   
}


