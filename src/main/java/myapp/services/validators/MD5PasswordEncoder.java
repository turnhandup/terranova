package myapp.services.validators;

import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;

/**
 * Created by PANNA on 05.04.2017.
 */
public class MD5PasswordEncoder extends MessageDigestPasswordEncoder {

    public MD5PasswordEncoder() {
        super("MD5");
    }
}
