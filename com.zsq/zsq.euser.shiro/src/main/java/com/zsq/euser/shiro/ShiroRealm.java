/*
 * 文件名称:          ShiroRealm.java
 * 版权所有@ 2013-2014 无锡城市云计算中心有限公司，保留所有权利
 * 编译器:           JDK1.7.0_25
 * 时间:             下午12:43:26
 */

package com.zsq.euser.shiro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zsq.euser.EncryptService;
import com.zsq.euser.IEUserService;
import com.zsq.euser.entity.Resource;
import com.zsq.euser.entity.Role;
import com.zsq.euser.entity.User;

/**
 * 用于最小的RBAC模型的SHIRO 简单用户信息认证
 * <p>
 * <p>
 * @版本:       CloudView V1.8
 * <p>
 * @作者:       zhuyy
 * <p>
 * @日期:       2014-7-22
 * <p>
 * @负责人:     zhuyy
 * <p>
 * @负责小组:   commons
 * <p>
 * <p>
 */
public class ShiroRealm extends AuthorizingRealm
{
    private static final Logger log = LoggerFactory.getLogger(ShiroRealm.class);
    
    @ Autowired
    private IEUserService seUser;
    
    @Autowired
    private EncryptService seEncrypt;

    /**
     * 构造器（塞入认证对象）
     */
    public ShiroRealm()
    {
        setAuthenticationTokenClass(UsernamePasswordToken.class);
    }


    /**
     * 鉴权回调函数：即shiro判断到需要鉴权时会回调此函数
     * @param principals 鉴权时登录者携带shiro信息
     * @return 鉴权信息
     */
    @ Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
    {
    	User user = null;
    	String loginName = principals.getPrimaryPrincipal().toString();
    	log.info("read {} permission and roles ",loginName);
    	user = seUser.findUserByLoginName(loginName);
    	String userId = user.getId();
    	List<Role> roles = seUser.getUserRoles(userId);
    	List<Resource> perms = seUser.getUserResources(userId);
    	Set<String> roleNames = new HashSet<String>();
        Set<String> permissions = new HashSet<String>();
        for (Role role : roles)
        {
            roleNames.add(role.getName());
        }
        
        for (Resource permission : perms)
        {
            permissions.add(permission.getCode());
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
        info.setStringPermissions(permissions);
    	return info;
    }

    /**
     * 认证回调函数：即shiro判断到需要认证时会回调此函数
     * @param authcToken 类似于认证的钥匙
     * @return AuthenticationToken
     * @throws AuthenticationException 认证异常
     */
    @ Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
        throws AuthenticationException
    {
       if (null == authcToken)
        {
            return null;
        }
        UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
        String loginName = token.getUsername();
       	User user = seUser.findUserByLoginName(loginName);
       	if(user == null){
       		throw new UnknownAccountException();
       	}
       	if(!user.getPassword().equals(seEncrypt.encrypt(new String(token.getPassword())))){
       		throw new IncorrectCredentialsException();
       	}
        log.info("authToken is {}", authcToken);
        return new SimpleAuthenticationInfo(token.getUsername(), token.getPassword(), getName());
    }
}
