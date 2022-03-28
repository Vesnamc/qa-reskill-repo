package constants;

public class ApiEndpoints {

    //crocodiles
    public static final String PUBLIC_CROCODILES = "/public/crocodiles/";
    public static String SINGLE_PUBLIC_CROCODILE(String id) {return PUBLIC_CROCODILES + id + "/";}

    public static final String MY_CROCODILES = "/my/crocodiles/";
    public static String SINGLE_CROCODILE(String id) {return MY_CROCODILES + id + "/";}
}
