package cn.microvideo.framework3.component.weixin.token.util;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.symmetric.AES;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;

public class WeixinTokenAesUtil {

    /**
     * 解决java不支持AES/CBC/PKCS7Padding模式解密
     */
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    /**
     * aes解密
     *
     * @param data
     * @param key
     * @param iv
     * @return
     */
    public static String aesDecrypt(String data, String key, String iv) {
        // 构建
        AES aes = new AES("CBC", "PKCS7Padding",
                // 密钥，可以自定义
                key.getBytes(),
                // iv加盐，按照实际需求添加
                iv.getBytes());
        return aes.decryptStr(data, CharsetUtil.CHARSET_UTF_8);
    }

    /**
     * aes加密
     *
     * @param data
     * @param key
     * @param iv
     * @return
     */
    public static String aesEncrypt(String data, String key, String iv) {
        // 构建
        AES aes = new AES("CBC", "PKCS7Padding",
                // 密钥，可以自定义
                key.getBytes(),
                // iv加盐，按照实际需求添加
                iv.getBytes());
        return aes.encryptHex(data, CharsetUtil.CHARSET_UTF_8);
    }

    public static void main(String[] args) {
        String a ="123123";
        String aa = aesEncrypt(a,"qwertyuiopqwerty","qazwsxedcrfvtgby");
        String aaa = aesDecrypt(aa,"qwertyuiopqwerty","qazwsxedcrfvtgby");
        System.out.println(aa);
        System.out.println(aaa);
    }

}
