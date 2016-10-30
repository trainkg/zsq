package com.zsq.euser.shiro;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.web.filter.mgt.FilterChainManager;
import org.apache.shiro.web.filter.mgt.FilterChainResolver;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanInitializationException;

/**
 * 
 * 提供一个可以排除URI的FactroyBean 实现,由于SHIRO 的spring中实现的代理filter 约定了private 只好通过定制dfilter开发这样的功能
 * @author zhuyy
 *
 */
public class ShiroExcludingURIFilterFactoryBean extends ShiroFilterFactoryBean {

	//路径匹配
	private static final AntPathMatcher MATCH = new AntPathMatcher();
	private static transient final Logger log = LoggerFactory.getLogger(ShiroExcludingURIFilterFactoryBean.class);
	/**
	 * 该路径ANT匹配，shiro 无需拦截处理
	 */
	private Set<String> excludePath;
	/**
	 * 覆盖实现createInstance 使用自己的filter实现
	 */
	@Override
	protected AbstractShiroFilter createInstance() throws Exception {
		log.debug("Creating Shiro Filter instance.");

        SecurityManager securityManager = getSecurityManager();
        if (securityManager == null) {
            String msg = "SecurityManager property must be set.";
            throw new BeanInitializationException(msg);
        }

        if (!(securityManager instanceof WebSecurityManager)) {
            String msg = "The security manager does not implement the WebSecurityManager interface.";
            throw new BeanInitializationException(msg);
        }

        FilterChainManager manager = createFilterChainManager();

        //Expose the constructed FilterChainManager by first wrapping it in a
        // FilterChainResolver implementation. The AbstractShiroFilter implementations
        // do not know about FilterChainManagers - only resolvers:
        PathMatchingFilterChainResolver chainResolver = new PathMatchingFilterChainResolver();
        chainResolver.setFilterChainManager(manager);

        //Now create a concrete ShiroFilter instance and apply the acquired SecurityManager and built
        //FilterChainResolver.  It doesn't matter that the instance is an anonymous inner class
        //here - we're just using it because it is a concrete AbstractShiroFilter instance that accepts
        //injection of the SecurityManager and FilterChainResolver:
        return new SpringShiroFilter((WebSecurityManager) securityManager, chainResolver);
	}
	
	public Set<String> getExcludePath() {
		return excludePath;
	}

	public void setExcludePath(Set<String> excludePath) {
		this.excludePath = excludePath;
	}

	/**
	 * 实现自己的filter  
	 * @author zhuyy
	 */
	 private final class SpringShiroFilter extends AbstractShiroFilter {
		 
        protected SpringShiroFilter(WebSecurityManager webSecurityManager, FilterChainResolver resolver) {
            super();
            if (webSecurityManager == null) {
                throw new IllegalArgumentException("WebSecurityManager property cannot be null.");
            }
            setSecurityManager(webSecurityManager);
            if (resolver != null) {
                setFilterChainResolver(resolver);
            }
        }
        
        @Override
        protected boolean isEnabled(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        	 if(ShiroExcludingURIFilterFactoryBean.this.excludePath != null){
        		 HttpServletRequest hr = (HttpServletRequest) request;
        		 for (String path :  ShiroExcludingURIFilterFactoryBean.this.excludePath) {
 					if(MATCH.match(path, hr.getServletPath())){
 						return false;
 					}
 				 }
        	 }
        	 return super.isEnabled(request, response);
        }
        
    }
}
