package per.sl.appsys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import per.sl.appsys.utils.Constants;

public class LoginValidateInterceptor extends HandlerInterceptorAdapter {
    private Logger log = Logger.getLogger(LoginValidateInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        log.debug("LoginValidateInterceptor preHandle!");
        HttpSession session = request.getSession();
        Object user = session.getAttribute(Constants.USER_SESSION);
        Object admin = session.getAttribute(Constants.ADMIN_SESSION);
        if (user == null && admin == null) {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
            return false;
        }
        return true;
    }
}
