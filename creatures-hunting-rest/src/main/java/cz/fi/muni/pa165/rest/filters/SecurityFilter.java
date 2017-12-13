package cz.fi.muni.pa165.rest.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import cz.fi.muni.pa165.dto.UserDTO;
import cz.fi.muni.pa165.facade.UserFacade;
import cz.fi.muni.pa165.rest.SecurityUtils;
import cz.fi.muni.pa165.rest.exceptions.NotAuthorizedException;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author Vojtech Sassmann &lt;vojtech.sassmann@gmail.com&gt;
 */
@WebFilter(urlPatterns = {"/auth/monsters/*", "/auth/areas/*", "/auth/weapons/*"})
public class SecurityFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		Cookie[] cookies = request.getCookies();

		if (cookies == null) {
			response.sendError(401, "Not logged in.");
			return;
		}

		String token = null;

		for (Cookie cookie : cookies) {
			if (SecurityUtils.COOKIE.equals(cookie.getName())) {
				token = SecurityUtils.decrypt(SecurityUtils.KEY, SecurityUtils.INIT_VECTOR, cookie.getValue());
			}
		}

		if (token == null) {
			response.sendError(401, "Not logged in.");
			return;
		}

		String[] data = token.split(";", 2);
		if (data.length != 2) {
			response.sendError(401, "Not logged in.");
			return;
		}

		long id;
		String email;

		try {
			id = Long.parseLong(data[0]);
		} catch (NumberFormatException e) {
			response.sendError(401, "Not logged in.");
			return;
		}
		email = data[1];

		UserFacade userFacade = WebApplicationContextUtils
				.getWebApplicationContext(servletRequest.getServletContext())
				.getBean(UserFacade.class);

		UserDTO user = userFacade.findUserById(id);
		if (!user.getEmail().equals(email)) {
			response.sendError(401, "Not logged in.");
			return;
		}

		request.setAttribute("authenticatedUser", user);

		filterChain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}
}
