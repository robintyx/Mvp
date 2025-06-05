package cn.microvideo.framework3.support;

import cn.microvideo.framework3.core.pwde.MicrovideoPwdeUtil;

public class PwdeTest {
    public static void main(String[] args) {
        //随机⽣成密钥
//String context="N";
        String context = "nacos";
        //加密为 16进制表示
//spring.datasource.druid.stat-view-servlet.login-password
        //microvideo.mybatis.*.password
        String encryptHex = MicrovideoPwdeUtil.getDbAes().encryptHex(context);
        //microvideo.commono.redis.password    spring.redis.data.password
        encryptHex = MicrovideoPwdeUtil.getRedisAes().encryptHex(context);
        System.out.println(encryptHex);
        System.out.println(MicrovideoPwdeUtil.getRedisAes().decryptStr(encryptHex));
        //knife4j.basic.password
        encryptHex = MicrovideoPwdeUtil.getKnife4jAes().encryptHex(context);
        System.out.println(encryptHex);
        System.out.println(MicrovideoPwdeUtil.getKnife4jAes().decryptStr("2f9eff6300070940f8c0405bfbc58aaa5b352bdb129b871b090368a112819ef2"));
        encryptHex = MicrovideoPwdeUtil.getNacosAes().encryptHex(context);
        System.out.println(encryptHex);
        System.out.println(MicrovideoPwdeUtil.getNacosAes().decryptStr("b0357430c8ff28100bdf4725e7abe22c"));
    }
}