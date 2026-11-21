package cl.duoc.api_gestion_movil.utils;

public class LogUtil {

    public static String maskEmail(String email) {
        if (email == null || !email.contains("@")) return "***";
        String[] parts = email.split("@");
        String name = parts[0];
        if (name.length() <= 2) return "*@" + parts[1];
        return name.charAt(0) + "***" + name.charAt(name.length() - 1) + "@" + parts[1];
    }

    public static String maskText(String text) {
        if (text == null || text.length() <= 2) return "***";
        return text.charAt(0) + "***" + text.charAt(text.length() - 1);
    }
}