package com.timurradko.logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MultiFileLogger extends BasicLogger {
    OutputStream[] arrayOutputStreams;
    private final static int VALUE_LOGS = 3;

    @Override
    public void writeLog(String result) {
        arrayOutputStreams = new OutputStream[VALUE_LOGS];
        for (int i = 0; i < arrayOutputStreams.length; i++) {
            String fileName = "log" + (i + 1) + ".txt";
            try {
                arrayOutputStreams[i] = new FileOutputStream(fileName, true);
                byte[] buffer = result.getBytes();
                (arrayOutputStreams[i]).write(buffer);
                (arrayOutputStreams[i]).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
