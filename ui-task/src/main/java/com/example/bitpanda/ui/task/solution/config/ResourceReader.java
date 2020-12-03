package com.example.bitpanda.ui.task.solution.config;

import lombok.experimental.UtilityClass;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;

@UtilityClass
public class ResourceReader {

    private String defaultTestResourcePath() {
        return System.getProperty("user.dir") + File.pathSeparator + "src" + File.pathSeparator + "test" +
                File.pathSeparator + "resources" + File.pathSeparator;
    }


    public File loadFileFromTestResources(Class<?> clazz, String fileName) {
        File file = null;
        try {
            file = Path.of(clazz.getClassLoader().getResource(fileName).toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            file = new File(defaultTestResourcePath() + fileName);
        }
        return file;
    }

}
