/*     */ package util;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.net.URI;
/*     */ import java.net.URL;
/*     */ import java.net.URLDecoder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Enumeration;
/*     */ import java.util.List;
/*     */ import java.util.jar.JarEntry;
/*     */ import java.util.jar.JarFile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClassHelper
/*     */ {
/*     */   public static List<Class<?>> getAllClass(String pack)
/*     */   {
/*  25 */     List<Class<?>> clazzs = new ArrayList();
/*     */     
/*     */ 
/*  28 */     boolean recursive = true;
/*     */     
/*     */ 
/*  31 */     String packageName = pack;
/*     */     
/*  33 */     String packageDirName = packageName.replace('.', '/');
/*     */     
/*     */ 
/*     */     try
/*     */     {
/*  38 */       Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
/*  39 */       while (dirs.hasMoreElements()) {
/*  40 */         URL url = (URL)dirs.nextElement();
/*     */         
/*  42 */         String protocol = url.getProtocol();
/*     */         
/*  44 */         if ("file".equals(protocol))
/*     */         {
/*  46 */           String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
/*  47 */           findClassInPackageByFile(packageName, filePath, recursive, clazzs);
/*  48 */         } else if ("jar".equals(protocol)) {
/*  49 */           String[] jarFileName = url.getFile().split("!");
/*  50 */           URI uri = new URI(jarFileName[0]);
/*  51 */           File file = new File(uri);
/*  52 */           clazzs.addAll(getClasssFromJarFile(file.getAbsolutePath(), packageDirName));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/*  57 */       throw new RuntimeException(e);
/*     */     }
/*     */     
/*  60 */     return clazzs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void findClassInPackageByFile(String packageName, String filePath, boolean recursive, List<Class<?>> clazzs)
/*     */   {
/*  77 */     File dir = new File(filePath);
/*  78 */     if ((!dir.exists()) || (!dir.isDirectory())) {
/*  79 */       return;
/*     */     }
/*     */     
/*  82 */     File[] dirFiles = dir.listFiles(new FileFilter()
/*     */     {
/*     */       public boolean accept(File file)
/*     */       {
/*  86 */         boolean acceptDir = (this.val$recursive) && (file.isDirectory());
/*  87 */         boolean acceptClass = file.getName().endsWith("class");
/*  88 */         return (acceptDir) || (acceptClass);
/*     */       }
/*     */     });
/*     */     
/*  92 */     for (File file : dirFiles) {
/*  93 */       if (file.isDirectory()) {
/*  94 */         findClassInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, clazzs);
/*     */       } else {
/*  96 */         String className = file.getName().substring(0, file.getName().length() - 6);
/*     */         try {
/*  98 */           clazzs.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + "." + className));
/*     */         } catch (Exception e) {
/* 100 */           throw new RuntimeException(e);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<Class<?>> getClasssFromJarFile(String jarPath, String filePath)
/*     */   {
/* 116 */     List<Class<?>> clazzs = new ArrayList();
/*     */     
/* 118 */     JarFile jarFile = null;
/*     */     try {
/* 120 */       jarFile = new JarFile(jarPath);
/*     */     } catch (IOException e1) {
/* 122 */       throw new RuntimeException(e1);
/*     */     }
/*     */     
/* 125 */     List<JarEntry> jarEntryList = new ArrayList();
/*     */     
/* 127 */     Enumeration<JarEntry> ee = jarFile.entries();
/* 128 */     while (ee.hasMoreElements()) {
/* 129 */       JarEntry entry = (JarEntry)ee.nextElement();
/*     */       
/* 131 */       if ((entry.getName().startsWith(filePath)) && (entry.getName().endsWith(".class"))) {
/* 132 */         jarEntryList.add(entry);
/*     */       }
/*     */     }
/* 135 */     for (JarEntry entry : jarEntryList) {
/* 136 */       String className = entry.getName().replace('/', '.');
/* 137 */       className = className.substring(0, className.length() - 6);
/*     */       try
/*     */       {
/* 140 */         clazzs.add(Thread.currentThread().getContextClassLoader().loadClass(className));
/*     */       } catch (ClassNotFoundException e) {
/* 142 */         throw new RuntimeException(e);
/*     */       }
/*     */     }
/*     */     
/* 146 */     return clazzs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 154 */     List<Class<?>> clazzs = new ArrayList();
/* 155 */     String tempString = "file:\\D:\\mzmserver\\gs\\dist\\gsxdb.jar";
/* 156 */     clazzs = getClasssFromJarFile(tempString, "mzm.gsp.item.main".replace('.', '/'));
/* 157 */     for (Class<?> clazz : clazzs) {
/* 158 */       System.out.println(clazz.getName());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\util\ClassHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */