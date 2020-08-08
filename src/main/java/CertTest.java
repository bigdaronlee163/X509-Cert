import com.sun.security.cert.internal.x509.X509V1CertImpl;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.bouncycastle.x509.X509V3CertificateGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

public class CertTest {

    private static String certPath = "D:\\learning\\Trash\\ddd.cer" ;


    public static void main(String[] args) {
        BaseCert baseCert = new BaseCert();

        X509Certificate cert = baseCert.generateCert("ddd");

        System.out.println(cert.toString());

//     导出为cer证书


        try {

            FileOutputStream fos = new FileOutputStream(certPath);
            fos.write(cert.getEncoded());
            fos.close();
        } catch (CertificateEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

