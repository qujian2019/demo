package com.hngsxy.web.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.springframework.stereotype.Service;
//shiro退出登陆清空缓存实现
@Service
public class SystemLogoutFilter extends LogoutFilter {
	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		// 在这里执行退出系统前需要清空的数据
		Subject subject = getSubject(request, response);

		String redirectUrl = getRedirectUrl(request, response, subject);

		try {

			subject.logout();

		} catch (SessionException ise) {

			ise.printStackTrace();

		}

		issueRedirect(request, response, redirectUrl);

		// 返回false表示不执行后续的过滤器，直接返回跳转到登录页面

		return false;

	}
}
