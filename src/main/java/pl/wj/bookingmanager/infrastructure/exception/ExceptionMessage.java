package pl.wj.bookingmanager.infrastructure.exception;

import java.util.Locale;
import java.util.ResourceBundle;

public class ExceptionMessage {
    private static String RESOURCE_FILE_NAME = "messages";
    private static String MAPPER_EXCEPTION_PREFIX = "mapper";
    private static String RESOURCE_ALREADY_EXISTS_EXCEPTION_PREFIX = "resource-already-exists";
    private static String RESOURCE_NOT_FOUND_EXCEPTION_PREFIX = "resource-not-found";


    public static String getMapperMessage(String key, String parameterType) {
        String message = ResourceBundle.getBundle(RESOURCE_FILE_NAME, Locale.getDefault())
                .getString(MAPPER_EXCEPTION_PREFIX + "." + key);
        return String.format(message, parameterType);
    }
    public static String getResourceAlreadyExistsMessage(String resourceName, long id) {
        String message = ResourceBundle.getBundle(RESOURCE_FILE_NAME, Locale.getDefault())
                .getString(RESOURCE_ALREADY_EXISTS_EXCEPTION_PREFIX);
        return String.format(message, resourceName, id);
    }
    public static String getResourceNotFoundMessage(String resourceName, long id) {
        String message = ResourceBundle.getBundle(RESOURCE_FILE_NAME, Locale.getDefault())
                .getString(RESOURCE_NOT_FOUND_EXCEPTION_PREFIX);
        return String.format(message, resourceName, id);
    }
}
