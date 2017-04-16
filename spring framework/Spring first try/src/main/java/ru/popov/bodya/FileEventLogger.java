package ru.popov.bodya;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.Charset;

public class FileEventLogger implements EventLogger {

    private File file;
    private String filename;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    protected void init() {
        file = new File(filename);
        if (file.exists() && !file.canWrite()) {
            throw new IllegalArgumentException("Can't write to file " + filename);
        } else if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                throw new IllegalArgumentException("Can't create file", e);
            }

        }
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.write(file, event.toString(), Charset.defaultCharset(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
