/*     */ package mzm.gsp.activity.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SFestivalAwardConst
/*     */ {
/*  13 */   private static volatile SFestivalAwardConst oldInstance = null;
/*     */   
/*  15 */   private static SFestivalAwardConst instance = new SFestivalAwardConst();
/*     */   
/*     */ 
/*     */   public int festivalNpcid;
/*     */   
/*     */ 
/*     */   public static SFestivalAwardConst getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SFestivalAwardConst getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void loadXml(String dir)
/*     */   {
/*  35 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  40 */     String path = dir + "mzm.gsp.activity.confbean.SFestivalAwardConst.xml";
/*     */     try
/*     */     {
/*  43 */       SAXReader reader = new SAXReader();
/*  44 */       org.dom4j.Document doc = reader.read(new File(path));
/*  45 */       Element root = doc.getRootElement();
/*  46 */       Map<String, Element> data = new java.util.HashMap();
/*  47 */       java.util.List<?> nodeList = root.elements();
/*  48 */       int len = nodeList.size();
/*  49 */       for (int i = 0; i < len; i++)
/*     */       {
/*  51 */         Element element = (Element)nodeList.get(i);
/*  52 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  55 */           String name = element.attributeValue("name");
/*  56 */           if (data.put(name, element) != null)
/*  57 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  60 */       this.festivalNpcid = Integer.valueOf(((Element)data.get("festivalNpcid")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  64 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  69 */     String path = dir + "mzm.gsp.activity.confbean.SFestivalAwardConst.xml";
/*     */     try
/*     */     {
/*  72 */       SAXReader reader = new SAXReader();
/*  73 */       org.dom4j.Document doc = reader.read(new File(path));
/*  74 */       Element root = doc.getRootElement();
/*  75 */       Map<String, Element> data = new java.util.HashMap();
/*  76 */       java.util.List<?> nodeList = root.elements();
/*  77 */       int len = nodeList.size();
/*  78 */       for (int i = 0; i < len; i++)
/*     */       {
/*  80 */         Element element = (Element)nodeList.get(i);
/*  81 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  84 */           String name = element.attributeValue("name");
/*  85 */           if (data.put(name, element) != null)
/*  86 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  89 */       this.festivalNpcid = Integer.valueOf(((Element)data.get("festivalNpcid")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  93 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*  97 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 100 */     String path = dir + "mzm.gsp.activity.confbean.SFestivalAwardConst.bny";
/*     */     try
/*     */     {
/* 103 */       File file = new File(path);
/* 104 */       if (file.exists())
/*     */       {
/* 106 */         byte[] bytes = new byte['Ѐ'];
/* 107 */         FileInputStream fis = new FileInputStream(file);
/* 108 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 109 */         int len = 0;
/* 110 */         while ((len = fis.read(bytes)) > 0)
/* 111 */           baos.write(bytes, 0, len);
/* 112 */         fis.close();
/* 113 */         bytes = baos.toByteArray();
/* 114 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 115 */         this.festivalNpcid = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 120 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 126 */     String path = dir + "mzm.gsp.activity.confbean.SFestivalAwardConst.bny";
/*     */     try
/*     */     {
/* 129 */       File file = new File(path);
/* 130 */       if (file.exists())
/*     */       {
/* 132 */         byte[] bytes = new byte['Ѐ'];
/* 133 */         FileInputStream fis = new FileInputStream(file);
/* 134 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 135 */         int len = 0;
/* 136 */         while ((len = fis.read(bytes)) > 0)
/* 137 */           baos.write(bytes, 0, len);
/* 138 */         fis.close();
/* 139 */         bytes = baos.toByteArray();
/* 140 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 141 */         this.festivalNpcid = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 146 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SFestivalAwardConst newInstance)
/*     */   {
/* 152 */     oldInstance = instance;
/* 153 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 158 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\confbean\SFestivalAwardConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */