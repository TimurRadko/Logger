package com.timurradko.logger;

public abstract class AbstractLogger implements Logger {

    @Override
    public abstract String log(String message);

    @Override
    public abstract String log(Object o, String message);

    @Override
    public abstract String log(LogType logType);

    @Override
    public abstract String log(Throwable e);

    public abstract void writeLog(String result);

    public abstract String constructMessage(Object o, String message);

    public abstract String constructMessage(String message);

    public abstract String constructMessage(LogType logType);

    public abstract String constructMessage(Throwable e);

}
