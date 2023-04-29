/*    */ package mzm.event;
/*    */ 
/*    */ import com.thoughtworks.xstream.XStream;
/*    */ import java.io.BufferedInputStream;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.util.Arrays;
/*    */ import java.util.Comparator;
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
/*    */ public class Utils
/*    */ {
/*    */   static Object FromXstream(XStream xstream, InputStream reader)
/*    */   {
/*    */     try
/*    */     {
/* 42 */       return xstream.fromXML(reader);
/*    */     }
/*    */     catch (Exception e) {}
/*    */     
/* 46 */     return null;
/*    */   }
/*    */   
/*    */   static int detectObjectForFile(File file, XStream xStream, XStreamObjectProcessor processor)
/*    */     throws IOException
/*    */   {
/* 52 */     FileInputStream fr = new FileInputStream(file);
/* 53 */     BufferedInputStream br = new BufferedInputStream(fr);
/* 54 */     Object obj = null;
/* 55 */     if ((obj = FromXstream(xStream, br)) != null)
/*    */     {
/* 57 */       if (!processor.onObjectDetected(obj))
/*    */       {
/* 59 */         br.close();
/* 60 */         return -1;
/*    */       }
/*    */     }
/* 63 */     br.close();
/* 64 */     return 0;
/*    */   }
/*    */   
/*    */   static void detectObjectForDirectory(File directory, FileFilter filter, XStreamObjectProcessor processor)
/*    */     throws IOException
/*    */   {
/* 70 */     if (!directory.isDirectory())
/*    */     {
/* 72 */       throw new Error("processDir should be a dirrectory");
/*    */     }
/* 74 */     if (!directory.exists())
/*    */     {
/* 76 */       throw new Error("processDir is not exist");
/*    */     }
/*    */     
/* 79 */     File[] subFiles = directory.listFiles();
/*    */     
/* 81 */     Arrays.sort(subFiles, new Comparator()
/*    */     {
/*    */ 
/*    */       public int compare(File o1, File o2)
/*    */       {
/* 86 */         return o1.getName().compareTo(o2.getName());
/*    */       }
/*    */       
/* 89 */     });
/* 90 */     XStream xStream = new XStream();
/*    */     
/* 92 */     for (File subfile : subFiles)
/*    */     {
/* 94 */       if (filter.filter(subfile))
/*    */       {
/* 96 */         detectObjectForFile(subfile, xStream, processor);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\event\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */