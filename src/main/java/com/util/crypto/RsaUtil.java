package com.util.crypto;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import static com.util.crypto.ConvertUtil.base642byte;
import static com.util.crypto.ConvertUtil.bytes2base64;

/**
 * Created by tangcheng on 2017/2/13.
 */
public class RsaUtil {
    public static KeyPair getKeyPair() throws NoSuchAlgorithmException {
        String algorithm = "RSA";
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        keyPairGenerator.initialize(512);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return keyPair;
    }

    public static final String getPublicKey(KeyPair keyPair) {
        PublicKey publicKey = keyPair.getPublic();
        byte[] encoded = publicKey.getEncoded();
        return bytes2base64(encoded);
    }

    public static final String getPrivateKey(KeyPair keyPair) {
        PrivateKey privateKey = keyPair.getPrivate();
        byte[] encoded = privateKey.getEncoded();
        return bytes2base64(encoded);
    }

    public static PublicKey string2PublicKey(String pubStr) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] keyBytes = base642byte(pubStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory rsa = KeyFactory.getInstance("RSA");
        PublicKey publicKey = rsa.generatePublic(keySpec);
        return publicKey;
    }

    public static PrivateKey string2PrivateKey(String priStr) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] keyBytes = base642byte(priStr);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory rsa = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = rsa.generatePrivate(keySpec);
        return privateKey;

    }

    public static byte[] publicEncrypt(byte[] content, PublicKey publicKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] bytes = cipher.doFinal(content);
        return bytes;
    }

    public static byte[] privateDecrypt(byte[] content, PrivateKey privateKey) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] bytes = cipher.doFinal(content);
        return bytes;
    }


}
