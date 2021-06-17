package com.order.orderdemo.jwt;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.order.orderdemo.model.ResultCode;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
	private static final long serialVersionUID = -8970718410437077606L;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			org.springframework.security.core.AuthenticationException authException)
			throws IOException, ServletException {

		String errorJson = "{\"resultCode\":\"" + ResultCode.UNAUTHORIZED.getCode() + "\"," + "\"resultStatus\":\""
				+ HttpStatus.UNAUTHORIZED.name() + "\"," + "\"message\":\"" + ResultCode.UNAUTHORIZED.getMessage()
				+ "\"}";

		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.getOutputStream().println(errorJson);

	}
}