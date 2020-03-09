package com.timurradko.logger;

public class TestLoggers {
    public static void main(String[] args) {
        BasicLogger basicLogger = new BasicLogger();
        MultiFileLogger multiFileLogger = new MultiFileLogger();
        MultiStreamLogger multiStreamLogger = new MultiStreamLogger();
        multiFileLogger.writeLog(basicLogger.log(LogType.INFO));
        multiStreamLogger.writeLog(basicLogger.log(LogType.INFO));
        multiFileLogger.writeLog(basicLogger.log(LogType.WARNING));
        multiFileLogger.writeLog(basicLogger.log(LogType.ERROR));
        try {
            int i = 5/0;
        } catch (ArithmeticException e) {
            multiFileLogger.writeLog(basicLogger.log(e));
        }
        multiFileLogger.writeLog(basicLogger.log("The system work slow"));
        multiFileLogger.writeLog(basicLogger.log(basicLogger, "Breaking the program that still doesn't work "));

    }
}
