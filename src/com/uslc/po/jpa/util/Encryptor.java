/*
 * Decompiled with CFR 0_115.
 */
package com.uslc.po.jpa.util;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Encryptor {
    public static Cipher dcipher;
    public static Cipher ecipher;

    public Encryptor(String passPhrase) {
        byte[] salt = new byte[]{-87, -101, -56, 50, 86, 52, -29, 3};
        int iterationCount = 19;
        try {
            PBEKeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt, iterationCount);
            SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
            ecipher = Cipher.getInstance(key.getAlgorithm());
            dcipher = Cipher.getInstance(key.getAlgorithm());
            PBEParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
            ecipher.init(1, (Key)key, paramSpec);
            dcipher.init(2, (Key)key, paramSpec);
        }
        catch (InvalidAlgorithmParameterException e) {
            System.out.println("EXCEPTION: InvalidAlgorithmParameterException");
        }
        catch (InvalidKeySpecException e) {
            System.out.println("EXCEPTION: InvalidKeySpecException");
        }
        catch (NoSuchPaddingException e) {
            System.out.println("EXCEPTION: NoSuchPaddingException");
        }
        catch (NoSuchAlgorithmException e) {
            System.out.println("EXCEPTION: NoSuchAlgorithmException");
        }
        catch (InvalidKeyException e) {
            System.out.println("EXCEPTION: InvalidKeyException");
        }
    }

    public String encrypt(String str) {
        try {
            byte[] utf10 = str.getBytes("UTF8");
            byte[] enc = ecipher.doFinal(utf10);
            return new BASE64Encoder().encode(enc);
        }
        catch (BadPaddingException utf10) {
        }
        catch (IllegalBlockSizeException utf10) {
        }
        catch (UnsupportedEncodingException utf10) {
            // empty catch block
        }
        return null;
    }

    public String decrypt(String str) {
        Cipher dcipher = null;
        try {
            byte[] salt4 = new byte[]{-87, -101, -56, 50, 86, 52, -29, 3};
            int iterationCount = 19;
            try {
                String passPhrase = "";
                PBEKeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt4, iterationCount);
                SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
                dcipher = Cipher.getInstance(key.getAlgorithm());
                PBEParameterSpec paramSpec = new PBEParameterSpec(salt4, iterationCount);
                dcipher.init(2, (Key)key, paramSpec);
            }
            catch (InvalidAlgorithmParameterException e) {
                System.out.println("EXCEPTION: InvalidAlgorithmParameterException");
            }
            catch (InvalidKeySpecException e) {
                System.out.println("EXCEPTION: InvalidKeySpecException");
            }
            catch (NoSuchPaddingException e) {
                System.out.println("EXCEPTION: NoSuchPaddingException");
            }
            catch (NoSuchAlgorithmException e) {
                System.out.println("EXCEPTION: NoSuchAlgorithmException");
            }
            catch (InvalidKeyException e) {
                System.out.println("EXCEPTION: InvalidKeyException");
            }
            byte[] dec = new BASE64Decoder().decodeBuffer(str);
            byte[] utf8 = dcipher.doFinal(dec);
            return new String(utf8, "UTF8");
        }
        catch (BadPaddingException salt4) {
        }
        catch (IllegalBlockSizeException salt4) {
        }
        catch (UnsupportedEncodingException salt4) {
        }
        catch (IOException salt4) {
            // empty catch block
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            System.out.println("Inside Helper");
            Encryptor encrypter = new Encryptor("");
            System.out.println("encrypt the String: guacalito");
            String encrypted = encrypter.encrypt("guacalito");
            System.out.println("encrypted String:" + encrypted);
            String decrypted = encrypter.decrypt(encrypted);
            System.out.println("decrypted String:" + decrypted);
        }
        catch (Exception encrypter) {
            // empty catch block
        }
    }
}

