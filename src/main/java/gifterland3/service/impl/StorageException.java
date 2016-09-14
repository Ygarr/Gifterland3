package gifterland3.service.impl;

/**
 * Created by kdiv on 9/14/16.
 */
public class StorageException extends RuntimeException {
    public StorageException(String message) {
        super(message);
    }
    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}