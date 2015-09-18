package com.zsq.euser.shiro.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.zsq.euser.EncryptService;
import com.zsq.euser.entity.User;
import com.zsq.euser.shiro.IShrioUserService;

/**
 * 该接口记录全局的登录以及人员的状态信息初始化,应该是全局唯一的一个实现方案,目前先标记为BEAN,省略配置
 * <br>在实际扩展的时候需要将扫描该BEAN跳过
 * @author peculiar.1@163.com
 * @version $ID: ShrioUserService.java, V1.0.0 2015年9月18日 下午8:50:39 $
 */
@Service
public class ShrioUserService implements IShrioUserService {
	
	@Autowired
	private EncryptService<User, String> seEncry;
	
	public void login(String name, String password) {
		Assert.notNull(name);
		Assert.notNull(password);
		User user = new User(name,password);
		UsernamePasswordToken token = new UsernamePasswordToken(name, seEncry.encrypt(user));
		Subject subject = SecurityUtils.getSubject();
		if(!subject.isAuthenticated()){
			subject.login(token);
		}
	}

}
