import com.sun.deploy.security.CertUtils;
import com.sun.org.apache.bcel.internal.util.BCELifier;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.x509.X509V3CertificateGenerator;
import util.CertUtil;
import util.DateUtil;

import javax.security.auth.x500.X500Principal;
import java.security.*;
import java.security.cert.X509Certificate;


public class BaseCert {

    static {
//        Security.addProvider(new BouncyCAstleProvider());
//        Security.addProvider(new BouncyCAstleProvider());
        Security.addProvider(new BouncyCastleProvider()) ;

    }


    protected static KeyPairGenerator kpg = null ;


    /*
        构造证书产生器：
            使用的非对称算法 （不同的算法，有着不同的设置）
            密钥的长度 （大多数算法都可以指定，同时，密钥越长，安全性越高）
     */

    public BaseCert(){
        try {
            // 使用类的静态工厂方法得到，不同密钥对生成实例，
            // 这里采用的是RSA算法，所以产生的密钥对，也是RSA的。
            kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(1024);
        } catch (NoSuchAlgorithmException e ){
            e.printStackTrace();
        }
    }


    public X509Certificate generateCert(String user){
        X509Certificate cert = null ;
        try {
            // 产生密钥对
            KeyPair keyPair = this.kpg.generateKeyPair();
            // 获取密钥对中的公钥
            PublicKey publicKey = keyPair.getPublic();
            // 获取密钥对中的私钥
            PrivateKey privateKey = keyPair.getPrivate();

            X509V3CertificateGenerator certGen = new X509V3CertificateGenerator();

            // 设置序列号
            certGen.setSerialNumber(CertUtil.getNextSerialNumber());

            // 设置签名

            certGen.setSignatureAlgorithm(CAConfig.CA_SHA);
            // 设置颁发者

            certGen.setIssuerDN(new X500Principal(CAConfig.CA_ROOT_ISSUER));


            //生效时间
            certGen.setNotBefore(DateUtil.getCurrentTime());

            // 撤销时间
            certGen.setNotAfter(DateUtil.getCurrentTime());

            // 设置使用者

              certGen.setSubjectDN(new X500Principal(CAConfig.CA_DEFAULT_SUBJECT));

         // 设置公钥信息
          certGen.setPublicKey(publicKey);

        cert = certGen.generateX509Certificate(privateKey, "BC"); //设置CA证书的提供商。



        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        return  cert ;
    }



}





