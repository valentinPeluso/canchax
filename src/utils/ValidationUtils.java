package utils;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ValidationUtils {

	 public static void initializeNullStrings(Object object) {
	        for (Field field : object.getClass().getDeclaredFields()) {
	            field.setAccessible(true);
	            if (field.getType().equals(String.class)) {
	                try {
	                    try {
	                        if (field.get(object) == null) {
	                            try {
	                                field.set(object, "");
	                            } catch (IllegalArgumentException ex) {
	                                Logger.getLogger(ValidationUtils.class.getName()).log(Level.SEVERE, null, ex);
	                            } catch (IllegalAccessException ex) {
	                                System.out.println("Access Exception");
	                                Logger.getLogger(ValidationUtils.class.getName()).log(Level.SEVERE, null, ex);
	                            }
	                        }
	                    } catch (IllegalArgumentException ex) {
	                        Logger.getLogger(ValidationUtils.class.getName()).log(Level.SEVERE, null, ex);
	                    } catch (IllegalAccessException ex) {
	                        Logger.getLogger(ValidationUtils.class.getName()).log(Level.SEVERE, null, ex);
	                    }
	                } catch (SecurityException ex) {
	                    Logger.getLogger(ValidationUtils.class.getName()).log(Level.SEVERE, null, ex);
	                }
	            }
	        }
	    }
	    
	    public static boolean isNullOrEmpty(String string) {
	        return (string == null || string.isEmpty());
	    }
}
