import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.symmetric.AES;

public class test {
    public static void main(String[] args) {
        //随机⽣成密钥
        AES aes = new AES(Mode.CBC, Padding.PKCS5Padding, "0MoJRm6Vyw8D8jvo".getBytes(), "0202050406060808".getBytes());
        String context = "admin";
        //加密为16进制表示

        String encryptHex = aes.encryptHex(context);
        System.out.println(encryptHex);
        System.out.println(aes.decryptStr(encryptHex));
    }
}