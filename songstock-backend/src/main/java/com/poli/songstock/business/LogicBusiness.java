package com.poli.songstock.business;

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
}