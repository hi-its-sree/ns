import java.security.*;
import java.util.Base64;
public class DigitalSignature
{
public static void main(String[] args)throws Exception
{
KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance("RSA");
keyPairGenerator.initialize(2048);
KeyPair keyPair=keyPairGenerator.generateKeyPair();
Signature signature =Signature.getInstance("SHA256withRSA");
signature.initSign(keyPair.getPrivate());
byte[] data="Hello,this is a message to be signed!".getBytes();
signature.update(data);
byte[] digitalSignature=signature.sign();
System.out.println(
    "Digital Signature:"+Base64.getEncoder().encodeToString(digitalSignature));
Signature signatureVerifier=Signature.getInstance("SHA256withRSA");
signatureVerifier.update(data);
boolean isSignatureValid=signatureVerifier.verify(digitalSignature);
System.out.println("Is Signature valid?"+isSignatureValid);
}


}