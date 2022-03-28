package environment;

public class ConfigSetup extends ConfigReader{

    public static String getBaseUrl() {
        return getValue("BASE_URL");
    }

    public static String getMainUser() {
        return getValue("MAIN_USER");
    }

    public static String getDefaultPsw() {
        return getValue("DEFAULT_PSW");
    }
}
