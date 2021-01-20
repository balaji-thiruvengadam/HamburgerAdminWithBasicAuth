/**
 * 
 */
package com.training.hamburger.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;

/**
 * @author balaji
 *
 */
@Component
@Log4j2
public class ExecutionTimeInterceptor implements HandlerInterceptor  {
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception arg3)
			throws Exception {
		
		long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
		log.info("Request URL: {}", request.getRequestURL());
		log.info("Total Time Taken: {}", (endTime - startTime));
	}


	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object object) throws Exception {
		
		long startTime = System.currentTimeMillis();
	    request.setAttribute("startTime", startTime);
	    //request.setAttribute("tenant-id",tenant.getTenantId())
		return true;
	}

}
