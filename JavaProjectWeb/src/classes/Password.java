package classes;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
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
  
  
  public static String md5(String salt,String plainText) throws NoSuchAlgorithmException{
	  MessageDigest md = MessageDigest.getInstance("MD5");

	  if (salt!=null){
		  md.update(salt.getBytes());
	  }
	  md.update(plainText.getBytes());
	  byte byteData[]=md.digest();
	  StringBuffer sb=new StringBuffer();
	  for (int i = 0; i < byteData.length; i++) {
	        sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
	                .substring(1));
	    }
	    return sb.toString();
	  
	  
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

  public static boolean isCorrectmd5(String hashed, String salt, String password) throws NoSuchAlgorithmException {
	  String s= md5(salt,password);
	  System.out.println(s+"."+hashed);
	  if (s.toString().trim().equals(hashed.toString().trim())){
		  System.out.println("yes");
		  return true;
	  }
	  else{
		  return false;
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