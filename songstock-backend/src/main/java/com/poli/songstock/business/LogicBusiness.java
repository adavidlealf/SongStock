package com.poli.songstock.business;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogicBusiness {

	/**
	 * Revisa si algo esta vacio.
	 * @param obj Object cualquier cosa.
	 * @return true si esta vacio es nulo.
	 */
	public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof String) {
            return ((String) obj).isEmpty();
        }
        if (obj instanceof java.util.Collection) {
            return ((java.util.Collection<?>) obj).isEmpty();
        }
        if (obj instanceof java.util.Map) {
            return ((java.util.Map<?, ?>) obj).isEmpty();
        }
        if (obj.getClass().isArray()) {
            return java.lang.reflect.Array.getLength(obj) == 0;
        }
        return false; // Si no es ninguno de los tipos anteriores, no lo consideramos vacío.
    }
	
	/**
	 * Valida si un correo tiene el formato correcto.
	 * @param email String correo a validar
	 * @return boolean true en caso que tenga el formato correcto.
	 */
	public static boolean isValidEmail(String email) {
		if(isEmpty(email)) return false;
		final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	/**
	 * Genera una lista de las palabras separadas por punto y coma.
	 * @param s String lista de palabras separadas por punto y coma.
	 * @return List<String> instancia de las listas de palabras.
	 */
	public static List<String> splitBySemicolon(String s){
		if(isEmpty(s)) return null;
		return Arrays.asList(s.split(";"));
	}
}