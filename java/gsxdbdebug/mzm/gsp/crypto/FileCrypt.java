/*    */ package mzm.gsp.crypto;
/*    */ 
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
/*    */ import javax.crypto.Cipher;
/*    */ import javax.crypto.CipherInputStream;
/*    */ import javax.crypto.CipherOutputStream;
/*    */ 
/*    */ public class FileCrypt
/*    */ {
/*    */   public static byte[] encryptByte(byte[] dataP, byte[] ckey, Cipher cip) throws Exception
/*    */   {
/* 13 */     return cip.doFinal(dataP);
/*    */   }
/*    */   
/*    */   public static byte[] decryptByte(byte[] dataE, byte[] ckey, Cipher cip) throws Exception {
/* 17 */     return cip.doFinal(dataE);
/*    */   }
/*    */   
/*    */   public static OutputStream encryptStream(OutputStream dataP, byte[] ckey, Cipher cip) throws Exception {
/* 21 */     CipherOutputStream cipos = new CipherOutputStream(dataP, cip);
/* 22 */     return cipos;
/*    */   }
/*    */   
/*    */   public static InputStream decryptStream(InputStream dataE, byte[] ckey, Cipher cip) throws Exception {
/* 26 */     CipherInputStream cipis = new CipherInputStream(dataE, cip);
/* 27 */     return cipis;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crypto\FileCrypt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */