package gifterland3.service.impl;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {
    /**
     * Folder location for storing files
     */
    private String location = "uploaded-pic-directory";

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}