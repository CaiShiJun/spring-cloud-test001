package com.battcn.security.auth.token.verifier;

/**
 * Token验证
 *
 * @author Levin
 * @since 2017-05-25
 */
public interface TokenVerifier {
    boolean verify(String jti);
}
