package user.zc.spider.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.apache.log4j.Logger;

public class CoreInterceptor extends HandlerInterceptorAdapter {

	//private static Logger logger = LoggerFactory.getLogger(CoreInterceptor.class);
	private static Logger logger = Logger.getLogger(CoreInterceptor.class);

	/**
	 * This implementation is empty.
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	}
	/**
	 * This implementation is empty.
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		CoreInterceptor.logger.info("===== " + request.getServletPath() + " =====end=====");
	}

	/**
	 * This implementation always returns {@code true}.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		CoreInterceptor.logger.info("=====" + request.getMethod() + " " + request.getServletPath() + " =====start=====");
		return true;
	}

}
