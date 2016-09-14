package gifterland3.service.impl;

/**
 * Created by kdiv on 9/14/16.
 */
public class StorageFileNotFoundException extends StorageException {
    public StorageFileNotFoundException(String message) {
        super(message);
    }
    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}