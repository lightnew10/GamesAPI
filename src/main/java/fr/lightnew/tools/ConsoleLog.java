package fr.lightnew.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleLog {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[36m";

    private static final String prefix = "GamesAPI";

    private static final String prefixError = ANSI_RED + "["+prefix+" ERROR] ";
    private static final String prefixInfo = ANSI_BLUE + "["+prefix+" INFO] ";
    private static final String prefixSuccess = ANSI_GREEN + "["+prefix+" SUCCESS] ";
    private static final String prefixDebug = "["+prefix+" DEBUG] ";

    public static void debug(Object str) {
        System.out.println(prefixDebug + str + ANSI_RESET);
    }

    public static void error(Object str) {
        System.out.println(prefixError + str + ANSI_RESET);
    }

    public static void info(Object str) {
        System.out.println(prefixInfo + str + ANSI_RESET);
    }

    public static void success(Object str) {
        System.out.println(prefixSuccess + str + ANSI_RESET);
    }

    private static String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "[" + sdf.format(new Date()) + "] ";
    }
}
