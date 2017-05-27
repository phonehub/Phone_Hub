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

import com.sun.xml.internal.ws.util.StringUtils;


/**
 * Servlet Filter implementation class PowerFilter
 * 
 * 判断用户是否登录
 */
public class PowerFilter implements Filter {
	
	private String excludedPages;       
	private String[] excludedPageArray; 

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
		
		String requestUrl = request.getRequestURI();
		System.out.print(requestUrl);
		
		requestUrl = requestUrl.substring(requestUrl.lastIndexOf("/")+1);
		
		boolean isExcludedPage = false;     
		for (String page : excludedPageArray) {//判断是否在过滤url之外     
			if(requestUrl.equals(page)){     
				isExcludedPage = true;
				System.out.print("test");
				break;
			}
		}
		
		if(isExcludedPage){
			chain.doFilter(req, resp); 
		}
		else{
			HttpSession session = request.getSession();
			String power = (String) session.getAttribute("power");
			if(power==null)
				response.sendRedirect(request.getContextPath()+"\\login.jsp");
		}
		
		
		
//		else{
//			if(request.getRequestURI().equals("myStore.jsp")){
//				if(Integer.parseInt(power)<2)
//					
//			}
//		}
		
		// pass the request along the filter chain
//		chain.doFilter(req, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
		excludedPages = fConfig.getInitParameter("excludedPages");     
		if (excludedPages != null) {
			excludedPageArray = excludedPages.split(",");
			for(int i = 0;i<excludedPageArray.length;i++){
				System.out.println(excludedPageArray[i]);
			}
			
		}     
		return; 
	}

}
