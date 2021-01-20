/**
 * 
 */
package com.training.hamburger.interceptor;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import lombok.extern.log4j.Log4j2;

/**
 * @author balaji
 *
 */

@Component
@Log4j2
public class RequestValidatorInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

		log.info("Before Handler execution");

		try {
			String user = request.getHeaders("USER").nextElement();
			log.info("Header user Param: {}", user);
		} catch (NoSuchElementException | NullPointerException e) {
			log.info("User doesn't exist in the header");
			response.sendRedirect("/auth-failed");
			return false;
		}

		return true;
	}

}
