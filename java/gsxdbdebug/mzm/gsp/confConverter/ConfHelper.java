/*    */ package mzm.gsp.confConverter;
/*    */ 
/*    */ import com.thoughtworks.xstream.XStream;
/*    */ import java.io.BufferedInputStream;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import javax.crypto.Cipher;
/*    */ import mzm.gsp.crypto.FileCrypt;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConfHelper
/*    */ {
/*    */   static Object FromXstream(XStream xstream, InputStream reader, Cipher cip)
/*    */   {
/*    */     try
/*    */     {
/* 44 */       InputStream ips = FileCrypt.decryptStream(reader, ConfManager.testkey.getBytes(), cip);
/* 45 */       Object obj = xstream.fromXML(ips);
/* 46 */       ips.close();
/* 47 */       reader.close();
/* 48 */       return obj;
/*    */     } catch (Exception e) {
/* 50 */       e.printStackTrace(); }
/* 51 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   static int detectObjectForFile(File file, XStream xStream, XStreamObjectProcessor processor, Cipher cip)
/*    */     throws IOException
/*    */   {
/* 58 */     FileInputStream fr = new FileInputStream(file);
/* 59 */     BufferedInputStream br = new BufferedInputStream(fr);
/* 60 */     Object obj = null;
/* 61 */     if ((obj = FromXstream(xStream, br, cip)) != null) {
/* 62 */       if (!processor.onObjectDetected(obj)) {
/* 63 */         fr.close();
/* 64 */         return -1;
/*    */       }
/* 66 */     } else return -1;
/* 67 */     br.close();
/* 68 */     fr.close();
/* 69 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   static void detectObjectForDirectory(File directory, FileFilter filter, XStreamObjectProcessor processor, Cipher cip)
/*    */     throws IOException
/*    */   {
/* 76 */     if (!directory.isDirectory())
/* 77 */       throw new Error("processDir should be a dirrectory");
/* 78 */     if (!directory.exists()) {
/* 79 */       throw new Error("processDir is not exist");
/*    */     }
/*    */     
/* 82 */     File[] subFiles = directory.listFiles();
/* 83 */     XStream xStream = new XStream();
/* 84 */     xStream.autodetectAnnotations(true);
/* 85 */     for (File subfile : subFiles) {
/* 86 */       if ((filter.filter(subfile)) && 
/* 87 */         (detectObjectForFile(subfile, xStream, processor, cip) != 0)) {
/* 88 */         throw new Error("unmarshal " + subfile.getAbsolutePath() + " error");
/*    */       }
/* 90 */       if (subfile.isDirectory()) {
/* 91 */         detectObjectForDirectory(subfile, filter, processor, cip);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\confConverter\ConfHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */