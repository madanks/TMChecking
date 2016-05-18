package com.cs544.mum.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import com.cs544.mum.domain.User;

public class SecurityUtil {
	private SecurityUtil() {
	}
	


	public static String getUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			return auth.getName();
		}

		return "";
	}

/*	public static User getAuthenticatedUser() {
		User u = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof User) {
			u = (User) principal;
		} else {
			u = null;
		}
		return u;
	}*/

}
