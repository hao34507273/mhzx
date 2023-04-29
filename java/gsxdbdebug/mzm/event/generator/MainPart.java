/*     */ package mzm.event.generator;
/*     */ 
/*     */ import com.thoughtworks.xstream.XStream;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileReader;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MainPart
/*     */ {
/*     */   public static Params getParams(String configFile)
/*     */   {
/*     */     try
/*     */     {
/*  22 */       BufferedReader br = new BufferedReader(new FileReader(configFile));
/*  23 */       Params param = new Params();
/*     */       
/*     */       String tmp;
/*  26 */       while ((tmp = br.readLine()) != null) {
/*  27 */         String[] keyValue = tmp.split("=");
/*  28 */         if (keyValue.length == 2)
/*     */         {
/*     */ 
/*  31 */           String key = keyValue[0].trim();
/*  32 */           String value = keyValue[1].trim();
/*     */           
/*  34 */           if (key.equals("base")) {
/*  35 */             param.base = value;
/*  36 */           } else if (key.equals("templatePath")) {
/*  37 */             param.templatePath = value;
/*  38 */           } else if (key.equals("processDir"))
/*  39 */             param.processDir = value;
/*     */         }
/*     */       }
/*  42 */       br.close();
/*     */       
/*  44 */       if ((param.base == null) || (param.templatePath == null) || (param.processDir == null))
/*     */       {
/*  46 */         return null;
/*     */       }
/*     */       
/*  49 */       return param;
/*     */     } catch (Exception e) {}
/*  51 */     return null;
/*     */   }
/*     */   
/*     */   public static Object FromXstream(File file, XStream xstream, InputStream reader)
/*     */   {
/*     */     try {
/*  57 */       return xstream.fromXML(reader);
/*     */     } catch (Exception e) {
/*  59 */       System.err.println("FromXStream Error. file : " + file);
/*  60 */       e.printStackTrace(); }
/*  61 */     return null;
/*     */   }
/*     */   
/*     */   public static void main(String[] arg) throws Exception
/*     */   {
/*  66 */     Params param = getParams(arg[0]);
/*  67 */     if (param == null) {
/*  68 */       System.out.println("the config file has some error");
/*  69 */       return;
/*     */     }
/*     */     
/*  72 */     File file = new File(param.processDir);
/*  73 */     if (!file.isDirectory()) {
/*  74 */       System.out.print("processDir should be a dirrectory");
/*  75 */       return; }
/*  76 */     if (!file.exists()) {
/*  77 */       System.out.print("processDir is not exist");
/*  78 */       return;
/*     */     }
/*     */     
/*  81 */     File[] subFiles = file.listFiles();
/*  82 */     XStream xStream = new XStream();
/*     */     
/*  84 */     for (File subfile : subFiles) {
/*  85 */       if (subfile.getName().endsWith(".xml")) {
/*  86 */         FileInputStream fr = new FileInputStream(subfile);
/*  87 */         BufferedInputStream br = new BufferedInputStream(fr);
/*  88 */         Object obj = null;
/*  89 */         if (((obj = FromXstream(subfile, xStream, br)) != null) && 
/*  90 */           ((obj instanceof Event[]))) {
/*  91 */           Event[] events = (Event[])obj;
/*  92 */           String moduleEventName = subfile.getName().replace(".xml", "");
/*  93 */           String first = moduleEventName.substring(0, 1);
/*  94 */           String moduleEventManagerName = first.toUpperCase().concat(moduleEventName.substring(1, moduleEventName.length() - 1)).concat("Manager");
/*     */           
/*  96 */           for (Event event : events) {
/*  97 */             System.out.println("generate event files for " + event.getModule() + "." + event.getEvent());
/*     */             
/*  99 */             event.genFiles(moduleEventManagerName, param.base, param.templatePath);
/*     */           }
/*     */         }
/*     */         
/* 103 */         br.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static class Params
/*     */   {
/*     */     public String base;
/*     */     public String templatePath;
/*     */     public String processDir;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\event\generator\MainPart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */