package org.delta.service;

import java.io.File;

public class FileManagementService {

    public boolean deleteFile(String filePath) {
        File file = new File(filePath);
        return file.delete();
    }

    public boolean fileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }
}
