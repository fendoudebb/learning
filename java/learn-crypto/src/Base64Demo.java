import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * zbj: created on 2021/4/20 21:50.
 */
public class Base64Demo {

    public static void main(String[] args) {
        byte[] bytes = Base64.decodeBase64("BDf7DVkhHpGGIZYhvxj20A==");
        String s = Hex.encodeHexString(bytes);
        System.out.println(s);
    }

}
