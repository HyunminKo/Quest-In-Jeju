package util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Utils {
    public static String getValueInCookie(HttpServletRequest request,String key) {
        Cookie[] cookies = request.getCookies();
        String result = null;
        for( int i = 0 ; i < cookies.length ; i++ ) {
            if( ( key ).equals(cookies[i].getName()) ) {
                result = cookies[i].getValue();
                break;
            }
        }
        return result;
    }
}
