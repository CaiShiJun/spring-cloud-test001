package com.battcn.security.auth.token.extractor;

/**
 * 实现这个接口应该返回原Base-64编码
 * 表示Token
 *
 * @author Levin
 * @since 2017-05-25
 */
public interface TokenExtractor {
    String extract(String payload);
}
