package cn.com.norming.base.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import cn.com.norming.base.Constants;
import cn.com.norming.base.LocalContext;
import cn.com.norming.base.util.LocalHelper;
import cn.com.norming.framework.domain.UserInformation;

/**
 * 请求过滤器.
 * @author lh.jia
 * @date 2013.07.22
 *
 */
public class RequestFilter implements Filter {
	/** 无需过滤的URI */
	private String 		excludingPattern;
	private Pattern[] 	eps;
	
	private long requestCount = 0;

	private synchronized String nextThreadId() {
		return "Request-" + ++requestCount;
	}
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.excludingPattern = config.getInitParameter("excludingPattern");
		
		if (!StringUtils.isEmpty(this.excludingPattern)) {
			String[] es = this.excludingPattern.split("[,;]");
			List<Pattern> ls = new ArrayList<Pattern>();
			for (String e : es) {
				ls.add(Pattern.compile(e.trim()));
			}
			eps = new Pattern[ls.size()];
			ls.toArray(eps);
		}
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		String uri = request.getRequestURI();
		if (noCheckUrl(uri)) {
			chain.doFilter(req, resp);
			return;
		}
		
		Thread.currentThread().setName(nextThreadId());
		
		HttpSession session = request.getSession(true);
		UserInformation userInfo = (UserInformation) session.getAttribute(Constants.USER_BEAN);
		if (userInfo != null) {
			if (uri.equals(request.getContextPath() + "/")) {
				response.sendRedirect(request.getContextPath() + "/framework/homepage");
				return;
			}
			LocalContext.setUser(userInfo);
		}
		else {
			response.sendRedirect(request.getContextPath() + "/framework/login");
			return;
		}
		
		try {
			chain.doFilter(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			LocalHelper.clearContexts();
		}
	}

	private boolean noCheckUrl(String url) {
		if (eps == null || eps.length == 0) {
			return false;
		}

		for (Pattern p : eps) {
			if (p.matcher(url).find()) {
				return true;
			}
		}

		return false;
	}
	
	@Override
	public void destroy() {
	}
}