package com.tour.web;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.tour.commons.base.BaseAction;
import com.tour.commons.utils.ZTreeBean;
import com.tour.model.SmAutho;
import com.tour.model.SmRole;
import com.tour.model.SmUser;
import com.tour.service.ifc.SmRoleServiceIFC;
import com.tour.service.ifc.SmUserServiceIFC;

@SuppressWarnings( "serial" )
public class LoginAction extends BaseAction {
    
    /**
     * @Description: 业务代理对象
     */
    private SmUserServiceIFC smUserServiceProxy;
    private SmRoleServiceIFC smRoleServiceProxy;
    
    public static final String LOGIN_SUCCESS = "LOGIN_SUCCESS";
    public static final String LOGIN_FAILE = "LOGIN_FAILE";
    
    private String           username;
    private String           password;
    private String           validcode;
    
    private JSONArray jsonArr = null;
    
    /**
     * 登陆
     * 
     * @author chenrh
     * @return
     */
    public String login() throws Exception {
        // 1、验证验证码是否匹配
        // 2、判断用户名是否存在
        SmUser smUser = smUserServiceProxy.checkUsername(username);
        if(smUser == null) {
            System.out.println("用户名不存在");
            request.setAttribute("login_msg", "用户名不存在"); // 用户对象
            return LOGIN_FAILE;
        }
        // 3、判断是否是管理员
        if( smUser.getIsAdmin() != 1) {
            System.out.println("不是管理员");
            request.setAttribute("login_msg", "该用户没有管理员权限"); // 用户对象
            return LOGIN_FAILE;
        }
        // 4、判断密码是否正确
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
        // 设置密码为空
        smUser.setPassword( "" );
        // 设置用户session
        request.setAttribute("loginUser", smUser);
        // 设置角色session
        Integer userId = smUser.getId();
        List<SmRole> list = smUserServiceProxy.getRoleList(userId);
        StringBuffer loginRoleName = new StringBuffer();
        List<Integer> roleIds = new ArrayList<Integer>();
        if(list == null || list.size() == 0) {
            System.out.println("该用户没有角色");
            return LOGIN_SUCCESS;
        }
        
        for (SmRole r : list) {
            loginRoleName.append( r.getRoleName() ).append( "," );
            roleIds.add( r.getId() );
        }
        request.setAttribute("loginRoleName", loginRoleName);

        // 设置权限session
        List<SmAutho> authoList = smRoleServiceProxy.getAuthoList( roleIds );
        
        ZTreeBean ztree = null;
        List<ZTreeBean> ztreeList = new ArrayList<ZTreeBean>();
        for (SmAutho a : authoList) {
            ztree = new ZTreeBean();
            ztree.setId(a.getId());
            ztree.setName(a.getAuthoName());
            ztree.setOpen(Boolean.TRUE);
            ztree.setFile(a.getUrl());
            ztree.setpId(a.getSuperId());
            ztreeList.add(ztree);
        }
        
        if(ztreeList == null || ztreeList.size() == 0) {
            System.out.println("该用户没有权限");
            return LOGIN_SUCCESS;
        }
        jsonArr = JSONArray.fromObject(ztreeList);
        request.setAttribute("loginAuthoList", jsonArr); // 拥有的模块列表
        
        return LOGIN_SUCCESS;
    }
    
    public SmUserServiceIFC getSmUserServiceProxy() {
        return smUserServiceProxy;
    }
    
    public void setSmUserServiceProxy( SmUserServiceIFC smUserServiceProxy ) {
        this.smUserServiceProxy = smUserServiceProxy;
    }
    
    public SmRoleServiceIFC getSmRoleServiceProxy() {
        return smRoleServiceProxy;
    }
    
    public void setSmRoleServiceProxy( SmRoleServiceIFC smRoleServiceProxy ) {
        this.smRoleServiceProxy = smRoleServiceProxy;
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
