package by.academy.tikhomirov.validation;

import java.util.regex.Pattern;

public class DataValidation {
	private static final String LOGIN_REGEX = "^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$";
	private static final String PASSWORD_REGEX = "^[\\w\\d]*$";
	private static final String NAME_REGEX = "[A-Za-z0-9_à-ÿÀ-ß¸¨]{1,30}";
	private static final String COUNTRY_REGEX = "[A-Za-z0-9_à-ÿÀ-ß¸¨]{1,30}";
	private static final String CITY_REXGEX = "[A-Za-z0-9_à-ÿÀ-ß¸¨]{1,30}";
	private static final String TELEPHONE_REGEX = "^[0-9]{12}$";
	

	public static boolean isLogin(String login) {
		return Pattern.compile(LOGIN_REGEX).matcher(login).find();
	}

	public static boolean isPassword(String password) {
		return Pattern.compile(PASSWORD_REGEX).matcher(password).find();
	}

	public static boolean isName(String name) {
		return Pattern.compile(NAME_REGEX).matcher(name).find();
	}
	public static boolean isCountry(String country) {
		return Pattern.compile(COUNTRY_REGEX).matcher(country).find();
	}
	public static boolean isCity(String city) {
		return Pattern.compile(CITY_REXGEX).matcher(city).find();
	}

	public static boolean isTelephone(String telephone) {
		return Pattern.compile(TELEPHONE_REGEX).matcher(telephone).find();
	}

}
