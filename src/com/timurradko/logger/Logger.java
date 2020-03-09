package com.timurradko.logger;

import java.io.IOException;

public interface Logger {
    String log(String message) throws IOException;
    String log(LogType logType) throws IOException;
    String log(Object o, String message) throws IOException;
    String log(Throwable t) throws IOException;
}
