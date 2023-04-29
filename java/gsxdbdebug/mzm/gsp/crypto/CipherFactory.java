/*    */ package mzm.gsp.crypto;
/*    */ 
/*    */ import javax.crypto.Cipher;
/*    */ import javax.crypto.SecretKeyFactory;
/*    */ import javax.crypto.spec.DESKeySpec;
/*    */ import javax.crypto.spec.SecretKeySpec;
/*    */ 
/*    */ public class CipherFactory
/*    */ {
/*    */   public static Cipher getCipher(String crypt, int mode, String key) throws Exception
/*    */   {
/* 12 */     Cipher cip = null;
/* 13 */     if (crypt.equals("DES")) {
/* 14 */       DESKeySpec desKS = new DESKeySpec(key.getBytes());
/* 15 */       SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
/* 16 */       javax.crypto.SecretKey keySpec = skf.generateSecret(desKS);
/* 17 */       cip = Cipher.getInstance(crypt);
/* 18 */       if (mode == 2) {
/* 19 */         cip.init(2, keySpec);
/* 20 */       } else if (mode == 1)
/* 21 */         cip.init(1, keySpec);
/* 22 */     } else if (crypt.equals("Blowfish")) {
/* 23 */       SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "Blowfish");
/* 24 */       cip = Cipher.getInstance(crypt);
/* 25 */       if (mode == 2) {
/* 26 */         cip.init(2, keySpec);
/* 27 */       } else if (mode == 1)
/* 28 */         cip.init(1, keySpec);
/* 29 */     } else if (crypt.equals("AES")) {
/* 30 */       SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
/* 31 */       cip = Cipher.getInstance(crypt);
/* 32 */       if (mode == 2) {
/* 33 */         cip.init(2, keySpec);
/* 34 */       } else if (mode == 1)
/* 35 */         cip.init(1, keySpec);
/* 36 */     } else if ((crypt.equals("NULL")) || (crypt.equals("null")) || (crypt.equals("Null")) || (crypt.isEmpty())) {
/* 37 */       return new javax.crypto.NullCipher();
/*    */     }
/* 39 */     return cip;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crypto\CipherFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */