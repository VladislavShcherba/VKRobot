package encoder;


import exception.EncoderException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Base64;

/**
 * A singleton which function is to read a key file, initialize encoding algorithm
 * based on that key and provide encoding functionality to outer world without
 * rereading the key file again.
 */
public class Encoder {

    private static final String keyFileName = "src/main/resources/Key.key";
    private static final String algorithm = "AES";

    /* Singleton instance */
    private static Encoder encoder;

    private Cipher encrypt;
    private Cipher decrypt;

    /**
     * Returns the instance of that {@link Encoder}.
     * @return  {@link Encoder} instance.
     */
    public static Encoder getInstance() throws EncoderException {
        if( encoder == null ) {
            encoder = new Encoder();
        }
        return encoder;
    }

    private Encoder() throws EncoderException {
        try(BufferedReader reader = new BufferedReader(new FileReader(keyFileName))){

            String keyString = reader.readLine();
            SecretKeySpec key = new SecretKeySpec(keyString.getBytes(), algorithm);

            encrypt = Cipher.getInstance(algorithm);
            encrypt.init(Cipher.ENCRYPT_MODE, key);
            decrypt = Cipher.getInstance(algorithm);
            decrypt.init(Cipher.DECRYPT_MODE, key);

        } catch (Exception e) {
            throw new EncoderException(e);
        }
    }

    /**
     * Encrypts provided string.
     * @param string string to encrypt.
     * @return encrypted string.
     */
    public String encrypt(String string) throws EncoderException {
        String returnValue = null;
        try {
            returnValue = Base64.getEncoder().encodeToString(encrypt.doFinal(string.getBytes()));
        } catch (Exception e) {
            throw new EncoderException(e);
        }
        return returnValue;
    }

    /**
     * Decrypts provided string.
     * @param string string to decrypt.
     * @return decrypted string.
     */
    public String decrypt(String string) throws EncoderException {
        String returnValue = null;
        try {
            returnValue = new String(decrypt.doFinal(Base64.getDecoder().decode(string)));
        } catch (Exception e) {
            throw new EncoderException(e);
        }
        return returnValue;
    }

}
