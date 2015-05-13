package com.tour.web;

import com.tour.commons.base.BaseAction;
import com.tour.model.SmUser;
import com.tour.service.ifc.SmUserServiceIFC;

@SuppressWarnings( "serial" )
public class LoginAction extends BaseAction {
    
    /**
     * @Description: 业务代理对象
     */
    private SmUserServiceIFC smUserServiceProxy;
    
    public static final String LOGIN_SUCCESS = "LOGIN_SUCCESS";
    public static final String LOGIN_FAILE = "LOGIN_FAILE";
    
    private String           username;
    private String           password;
    private String           validcode;
    
    /**
     * 登陆
     * 
     * @author chenrh
     * @return
     */
    public String login() {
        // 1、验证验证码是否匹配
        // 2、判断用户名是否存在
        SmUser smUser = smUserServiceProxy.checkUsername(username);
        if(smUser == null) {
            System.out.println("用户名不存在");
            request.setAttribute("login_msg", "用户名不存在"); // 用户对象
            return LOGIN_FAILE;
        }
        // 3、判断密码是否正确
        if( !password.equals( smUser.getPassword() )) {
            System.out.println("密码错误");
            request.setAttribute("login_msg", "密码错误"); // 用户对象
            return LOGIN_FAILE;
        }
        
        // 登陆成功，设置用户为在线
        request.setAttribute("login_msg", "登陆成功");
        System.out.println("登陆成功");
        smUser.setStatus( 1 );
        smUserServiceProxy.saveEditSmUser( smUser );
        // TODO 验证成功, 获取权限等...
        
        return LOGIN_SUCCESS;
    }
    
    public SmUserServiceIFC getSmUserServiceProxy() {
        return smUserServiceProxy;
    }
    
    public void setSmUserServiceProxy( SmUserServiceIFC smUserServiceProxy ) {
        this.smUserServiceProxy = smUserServiceProxy;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername( String username ) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword( String password ) {
        this.password = password;
    }
    
    public String getValidcode() {
        return validcode;
    }
    
    public void setValidcode( String validcode ) {
        this.validcode = validcode;
    }
    
}
