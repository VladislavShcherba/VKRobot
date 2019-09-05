package utility;

import encoder.Encoder;
import exception.EncoderException;

import java.util.Scanner;

/**
 * Execute EncoderUtility {@link #main(String...)} method to encrypt or decrypt {@code String}
 * entered into the console. EncoderUtility uses the same encryption algorithm provided by
 * {@link encoder.Encoder} as the whole project. It allows to encrypt or
 * decrypt your secret information to store it in the resources files.
 */
public class EncoderUtility {

    public static void main(String... args) throws EncoderException {
        encrypt();
        decrypt();
    }

    private static void encrypt() throws EncoderException {
        System.out.println("Enter string to encrypt (or empty string to skip step)");
        Scanner scanner = new Scanner(System.in);
        String stringToEncrypt = scanner.nextLine();
        if(!stringToEncrypt.isEmpty()){
            System.out.println(Encoder.getInstance().encrypt(stringToEncrypt));
        }
    }

    private static void decrypt() throws EncoderException {
        System.out.println("Enter string to decrypt (or empty string to skip step)");
        Scanner scanner = new Scanner(System.in);
        String stringToDecrypt = scanner.nextLine();
        if(!stringToDecrypt.isEmpty()) {
            System.out.println(Encoder.getInstance().decrypt(stringToDecrypt));
        }
    }

}
