package com.dpl.order.filter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
@Order(1)
public class AuthFiter implements javax.servlet.Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
			throws IOException, ServletException {
		System.out.println("Hitting the filter");
		HttpServletRequest req = (HttpServletRequest) request;
		String xsid = req.getHeader("x-s-id");
		String mobile = req.getHeader("mobile");
		if (ObjectUtils.isEmpty(xsid) || ObjectUtils.isEmpty(mobile)) {
			return;
		}
		if (!verifyToken(mobile, xsid)) {
			return;
		}

		/*
		 * if (req.getHeader("x-s-id") == null || req.getHeader("mobile") == null) {
		 * HttpServletResponse httpResponse = (HttpServletResponse) response;
		 * httpResponse.setContentType("application/json");
		 * httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST,
		 * "Required headers not specified in the request"); return; }
		 */
		filterchain.doFilter(request, response);
	}

	public void init(FilterConfig filterconfig) throws ServletException {
	}

	public boolean include(Object element) {
		return false;
	}

	private boolean verifyToken(String mobile, String xsid) {
		String uri = "https://rest.medlife.com/sso/v2/user/" + mobile;
		System.out.println(uri);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).header("Content-Type", "application/json")
				.header("x-s-id", xsid).build();

		HttpResponse<String> response = null;
		try {
			response = client.send(request, BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		if (ObjectUtils.isEmpty(response)) {
			return false;
		}
		if (response.statusCode() == 200) {
			return true;
		}
		return false;
	}
}
