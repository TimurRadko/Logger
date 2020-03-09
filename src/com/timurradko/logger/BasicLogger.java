package com.timurradko.logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasicLogger extends AbstractLogger {
    private static final String LOGGER_PATH = "E:\\StormNet\\LoggerSecondRealisation\\src\\com\\timurradko\\logger\\log.txt";

    @Override
    public void writeLog(String result) {
        try {
            FileOutputStream fos = new FileOutputStream(LOGGER_PATH, true);
            byte[] buffer = result.getBytes();
            fos.write(buffer);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String log(String message) {
        String result = constructMessage(message);
        writeLog(result);
        return result;
    }

    @Override
    public String log(Object o, String message) {
        String result = constructMessage(o,message);
        writeLog(result);
        return result;
    }

    @Override
    public String log(LogType logType) {
        String result = constructMessage(logType);
        writeLog(result);
        return result;
    }

    @Override
    public String log(Throwable e) {
        String result = constructMessage(e);
        writeLog(result);
        return result;
    }

    private String getDataLog() {
        String pattern = "yyyy.MM.dd 'at' HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date());
    }

    public String constructMessage(String message){
        return getDataLog() + " " + LogType.WARNING + ": " + message + "\r" + "\n";
    }

    public String constructMessage(Object o, String message) {
        return getDataLog() + " " + LogType.WARNING + ": Next Object is broken or not available " +
                o.toString() + "." + "\r" + "\n" + message + "\r" + "\n";

    }

    public String constructMessage(LogType logType) {
        return getDataLog() + " " + logType + messageView(logType) + "\r" + "\n";
    }

    private String messageView(LogType logType){
        if (logType.equals(LogType.INFO)) {
            return ": System is already running";
        }
        if (logType.equals(LogType.WARNING)) {
            return ": Attention warning zone";
        }
        if (logType.equals(LogType.ERROR)) {
            return ": System made the ERROR";
        }
        return ": Something is going wrong";
    }

    public String constructMessage(Throwable e) {
        return getDataLog() + " " + LogType.ERROR + ": " +  e.getMessage() + "\r" + "\n";
    }

}
