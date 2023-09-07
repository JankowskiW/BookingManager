package pl.wj.bookingmanager.infrastructure.exception;

import java.util.Locale;
import java.util.ResourceBundle;

public class ExceptionMessage {
    private static final String RESOURCE_FILE_NAME = "messages";
    private static final String MAPPER_EXCEPTION_PREFIX = "mapper";
    private static final String RESOURCE_ALREADY_EXISTS_EXCEPTION_PREFIX = "resource-already-exists";
    private static final String RESOURCE_ALREADY_EXISTS_EXCEPTION_CUSTOM_FIELD_PREFIX = RESOURCE_ALREADY_EXISTS_EXCEPTION_PREFIX+".custom-field";
    private static final String RESOURCE_NOT_FOUND_EXCEPTION_PREFIX = "resource-not-found";
    private static final String RESOURCE_NOT_FOUND_EXCEPTION_PREFIX_CUSTOM_FIELD_PREFIX = RESOURCE_NOT_FOUND_EXCEPTION_PREFIX+".custom-field";


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
    public static String getResourceAlreadyExistsMessage(String resourceName, String fieldName, String fieldValue) {
        String message = ResourceBundle.getBundle(RESOURCE_FILE_NAME, Locale.getDefault())
                .getString(RESOURCE_ALREADY_EXISTS_EXCEPTION_CUSTOM_FIELD_PREFIX);
        return String.format(message, resourceName, fieldName, fieldValue);
    }
    public static String getResourceNotFoundMessage(String resourceName, long id) {
        String message = ResourceBundle.getBundle(RESOURCE_FILE_NAME, Locale.getDefault())
                .getString(RESOURCE_NOT_FOUND_EXCEPTION_PREFIX);
        return String.format(message, resourceName, id);
    }

    public static String getResourceNotFoundMessage(String resourceName, String fieldName, String fieldValue) {
        String message = ResourceBundle.getBundle(RESOURCE_FILE_NAME, Locale.getDefault())
                .getString(RESOURCE_NOT_FOUND_EXCEPTION_PREFIX_CUSTOM_FIELD_PREFIX);
        return String.format(message, resourceName, fieldName, fieldValue);
    }
}
