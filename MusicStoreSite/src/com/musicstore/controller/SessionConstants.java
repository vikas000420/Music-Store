package com.musicstore.controller;

import javax.servlet.http.HttpSession;

public class SessionConstants {

	public static final String cdAttr = "cd";
	public static final String cartAttr = "cart";
	public static String accountAttr = "userAccount";

	/**
	 * @param session
	 * @param attrib
	 */
	public static void clearSession(HttpSession session, String attrib) {
		session.removeAttribute(attrib);
	}
}
