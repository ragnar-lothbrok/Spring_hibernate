package com.home.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

public class CustomFilter implements Filter{
	
	public static final Logger logger = Logger.getLogger(CustomFilter.class);

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		logger.debug("Inside Custom Filter.....");
		
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ROLE_USER")) {
            request.getSession().setAttribute("myVale", "myvalue");
        }
        logger.debug("Request URL : "+((HttpServletRequest)req).getRequestURL());
        logger.debug("Request URI : "+((HttpServletRequest)req).getRequestURI());
        logger.debug("Request Session Id : "+((HttpServletRequest)req).getRequestedSessionId());
        logger.debug("Request Port : "+((HttpServletRequest)req).getRemotePort());
        logger.debug("Request Host : "+((HttpServletRequest)req).getRemoteHost());
        logger.debug("Request Address : "+((HttpServletRequest)req).getRemoteAddr());
        logger.debug("Request User : "+((HttpServletRequest)req).getRemoteUser());
        String queryString = ((HttpServletRequest)req).getQueryString();
        logger.debug("Request Query String : "+queryString);
        Map map = ((HttpServletRequest)req).getParameterMap();
        for(Object key : map.keySet()){
        	logger.debug("Param Name : "+key.toString()+" Param Value : "+Arrays.toString((String[])map.get(key)));
        }
        if(queryString != null && queryString.toLowerCase().indexOf("script") != -1){
        	HttpServletResponse httpResponse = (HttpServletResponse) res;
        	httpResponse.sendRedirect("/jsp/error_page.jsp");
        }
        chain.doFilter(req, res);
	}	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}

