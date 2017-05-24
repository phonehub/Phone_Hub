package cn.edu.zhku.phonehub.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class PowerFilter
 * 
 * 判断用户是否登录
 */
public class PowerFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PowerFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
//		String requestUrl = request.getRequestURI();
//		System.out.print(requestUrl);
		
//		requestUrl = requestUrl.substring(requestUrl.lastIndexOf("\\")+1);
		
		HttpSession session = request.getSession();
		String power = (String) session.getAttribute("power");
		if(power==null)
			response.sendRedirect(request.getContextPath()+"\\login.jsp");
		
//		else{
//			if(request.getRequestURI().equals("myStore.jsp")){
//				if(Integer.parseInt(power)<2)
//					
//			}
//		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
