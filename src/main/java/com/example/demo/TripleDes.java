package com.example.demo;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class TripleDes {

    public static void main(String[] args) throws Exception {

        String text = "jhhjj";

        byte[] codedtext = new TripleDes().encrypt(text);
        String decodedtext = new TripleDes().decrypt(codedtext);

        System.out.println("****Coded Text="+codedtext);
        System.out.println("****Encoded Text="+decodedtext);
        
        System.exit(0);
    }

    public byte[] encrypt(String message) throws Exception {
        final MessageDigest md = MessageDigest.getInstance("SHA-256");
        final byte[] digestOfPassword = md.digest("HG58YZ3CR9".getBytes(StandardCharsets.UTF_8));
        final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        for (int j = 0, k = 16; j < 8;) {
            keyBytes[k++] = keyBytes[j++];
        }

        final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
        final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
        final Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);

        final byte[] plainTextBytes = message.getBytes(StandardCharsets.UTF_8);
        final byte[] cipherText = cipher.doFinal(plainTextBytes);

        return cipherText;
    }

    public String decrypt(byte[] message) throws Exception {
        final MessageDigest md = MessageDigest.getInstance("SHA-256");
        final byte[] digestOfPassword = md.digest("HG58YZ3CR9".getBytes(StandardCharsets.UTF_8));
        final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        for (int j = 0, k = 16; j < 8;) {
            keyBytes[k++] = keyBytes[j++];
        }

        final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
        final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
        final Cipher decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        decipher.init(Cipher.DECRYPT_MODE, key, iv);

        final byte[] plainText = decipher.doFinal(message);

        return new String(plainText, StandardCharsets.UTF_8);
    }
}
