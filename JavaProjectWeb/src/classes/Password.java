package classes;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

//256 byte hashed pass, 32 byte salt

public class Password {

  private static final Random RANDOM = new SecureRandom();
  private static final int ITERATIONS = 10000;
  private static final int KEY_LENGTH = 256;

  private Password() { }

  public static byte[] getNextSalt() {
    byte[] salt = new byte[32];
    RANDOM.nextBytes(salt);
    return salt;
  }
  
  public static byte[] hash(char[] password, byte[] salt) {
    PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
    Arrays.fill(password, Character.MIN_VALUE);
    try {
      SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
      return skf.generateSecret(spec).getEncoded();
    } catch (Exception e) {
      throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
    } finally {
      spec.clearPassword();
    }
  }

  
  public static boolean isCorrectPassword(String password, String salt, String expectedHash) {
	  char[] passwordf = password.toCharArray();
	  byte[] saltf = salt.getBytes();
	  byte[] hashf = expectedHash.getBytes();
	  
	  byte[] pwdHash = hash(passwordf, saltf);
	    Arrays.fill(passwordf, Character.MIN_VALUE);
	    if (pwdHash.length != hashf.length) return false;
	    for (int i = 0; i < pwdHash.length; i++) {
	      if (pwdHash[i] != hashf[i]) return false;
	    }
	    return true;
	  }
  
}