package cn.edu.ldu.grad.intercepter;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtOperation {
	public static String LOGON_COOKIE = "JWT_STR_LONON";
	public static String SECRET = "ldu.edu.cn" + "1qaz2wsx";
	public static String PUBLISHER = "ldu";

	public static boolean verifyToken(HttpServletRequest request, HttpServletResponse response) {
		boolean flag = false;
		String token = request.getHeader("authorization");
		if (token == null||token.equals("")) {
			token=request.getParameter("grad_token");
		}
		String requestURI = request.getRequestURL().toString();
		if (requestURI.indexOf("/login") > 0) {
			return true;
		}
		try {
			Enumeration headerNames = request.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String key = (String) headerNames.nextElement();
				String value = request.getHeader(key);
				System.out.println(key+":"+value);
			}
			
			if (token == null||token.equals("")) {
				flag = false;
			} else {
				Algorithm algorithm = Algorithm.HMAC256(SECRET);
				JWTVerifier verifier = JWT.require(algorithm).withIssuer(PUBLISHER).build(); // Reusable
				DecodedJWT jwt = verifier.verify(token);
				/*
				jwt = JWT.decode(token);
				Date expiresDate = jwt.getExpiresAt();
				Claim claim = jwt.getClaim("username");
				String username = claim.asString();
				if (expiresDate.getTime() - new Date().getTime() < 1000 * 20 * 60) {
					long times = expiresDate.getTime() + 60 * 2 * 60 * 1000;
					expiresDate.setTime(times);
					Builder token1 = JWT.create().withIssuer(PUBLISHER).withClaim("username", username)
							.withExpiresAt(expiresDate);
					String tokenStr1 = token1.sign(algorithm);
					cookie.setValue(tokenStr1);
					cookie.setMaxAge(-1);
					response.addCookie(cookie);
				}
				
				*/
				flag = true;
			}
			// .sign(algorithm);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}

	public static Cookie findCookie(Cookie[] cookies, String cookieName) {
		if (cookies == null)
			return null;
		else {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(cookieName))
					return cookie;
			}
		}
		return null;
	}
}
