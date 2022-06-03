package file_downloader;

import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.validator.routines.UrlValidator;

/**
 * Class to validate a URL by various methods.
 * @autor Valery Zahurski
 * @version 2.1
 */
public class UrlMultiValidator {
    /**
     * We can use java.net.URL class to validate a URL. The idea is to create a URL object from the specified string
     * representation. A MalformedURLException will be thrown if no protocol is specified, or an unknown protocol is
     * found, or spec is null. Then we call the toURI() method that throws a URISyntaxException if the URL is not
     * formatted strictly according to RFC 2396 and cannot be converted to a URI.
     */
    public static boolean urlValidUsingURL(String url)
    {
        try {
            new URL(url).toURI();
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }
    // https://owasp.org/www-community/OWASP_Validation_Regex_Repository
    private static final String URL_REGEX =
            "^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                    "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
                    "([).!';/?:,][[:blank:|:blank:]])?$";
    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
    /**
     * We can use OWASP Validation Regex, which is considered to be very safe, to validate a URL.
     */
    public static boolean urlValidUsingOwaspRegex(String url)
    {
        Matcher matcher = URL_PATTERN.matcher(url);
        return matcher.matches();
    }
    // Using Apache Commons Validator https://www.techiedelight.com/validate-url-java/
    // Download https://mvnrepository.com/artifact/commons-validator/commons-validator/1.7
    public static boolean urlValidUsingApacheValidator(String url)
    {
         return new UrlValidator().isValid(url);
    }
}
