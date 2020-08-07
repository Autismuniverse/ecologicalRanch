//package com.ecologicalRanch.common.shiro;
//
//import java.io.UnsupportedEncodingException;
//import java.util.Date;
//
//public class JWTUtil {
//
//    // 过期时间5分钟
//    private static final long EXPIRE_TIME = 5*60*1000;
//
//    /**
//     * 校验token是否正确
//     * @param token 密钥
//     * @param secret 用户的密码
//     * @return 是否正确
//     */
//    public static boolean verify(String token, String username, String secret) {
//        try {
//
//            JWTVerifier verifier = JWT.require(algorithm)
//                    .withClaim("username", username)
//                    .build();
//            DecodedJWT jwt = verifier.verify(token);
//            return true;
//        } catch (Exception exception) {
//            return false;
//        }
//    }
//
//    /**
//     * 获得token中的信息无需secret解密也能获得
//     * @return token中包含的用户名
//     */
//    public static String getUsername(String token) {
//        try {
//            DecodedJWT jwt = JWT.decode(token);
//            return jwt.getClaim("username").asString();
//        } catch (JWTDecodeException e) {
//            return null;
//        }
//    }
//
//    /**
//     * 生成签名,5min后过期
//     * @param username 用户名
//     * @param secret 用户的密码
//     * @return 加密的token
//     */
//    public static String sign(String username, String secret) {
//        try {
//            Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
//            // 附带username信息
//            return JWT.create()
//                    .withClaim("username", username)
//                    .withExpiresAt(date)
//                    .sign(secret);
//        } catch (UnsupportedEncodingException e) {
//            return null;
//        }
//    }
//}
//
//作者：Smith15445
//        链接：https://juejin.im/post/6844903506535071758
//        来源：掘金
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。