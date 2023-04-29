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
/*     */ public class SActiveConst
/*     */ {
/*  13 */   private static volatile SActiveConst oldInstance = null;
/*     */   
/*  15 */   private static SActiveConst instance = new SActiveConst();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SActiveConst getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SActiveConst getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int activeResetObserverid = 0;
/*  32 */   public int mailCfgId = 0;
/*  33 */   public int activeValueShowUp = 10;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  37 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  42 */     String path = dir + "mzm.gsp.activity.confbean.SActiveConst.xml";
/*     */     try
/*     */     {
/*  45 */       SAXReader reader = new SAXReader();
/*  46 */       org.dom4j.Document doc = reader.read(new File(path));
/*  47 */       Element root = doc.getRootElement();
/*  48 */       Map<String, Element> data = new java.util.HashMap();
/*  49 */       java.util.List<?> nodeList = root.elements();
/*  50 */       int len = nodeList.size();
/*  51 */       for (int i = 0; i < len; i++)
/*     */       {
/*  53 */         Element element = (Element)nodeList.get(i);
/*  54 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  57 */           String name = element.attributeValue("name");
/*  58 */           if (data.put(name, element) != null)
/*  59 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  62 */       this.activeResetObserverid = Integer.valueOf(((Element)data.get("activeResetObserverid")).attributeValue("value")).intValue();
/*  63 */       this.mailCfgId = Integer.valueOf(((Element)data.get("mailCfgId")).attributeValue("value")).intValue();
/*  64 */       this.activeValueShowUp = Integer.valueOf(((Element)data.get("activeValueShowUp")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  68 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  73 */     String path = dir + "mzm.gsp.activity.confbean.SActiveConst.xml";
/*     */     try
/*     */     {
/*  76 */       SAXReader reader = new SAXReader();
/*  77 */       org.dom4j.Document doc = reader.read(new File(path));
/*  78 */       Element root = doc.getRootElement();
/*  79 */       Map<String, Element> data = new java.util.HashMap();
/*  80 */       java.util.List<?> nodeList = root.elements();
/*  81 */       int len = nodeList.size();
/*  82 */       for (int i = 0; i < len; i++)
/*     */       {
/*  84 */         Element element = (Element)nodeList.get(i);
/*  85 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  88 */           String name = element.attributeValue("name");
/*  89 */           if (data.put(name, element) != null)
/*  90 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  93 */       this.activeResetObserverid = Integer.valueOf(((Element)data.get("activeResetObserverid")).attributeValue("value")).intValue();
/*  94 */       this.mailCfgId = Integer.valueOf(((Element)data.get("mailCfgId")).attributeValue("value")).intValue();
/*  95 */       this.activeValueShowUp = Integer.valueOf(((Element)data.get("activeValueShowUp")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  99 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 103 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 106 */     String path = dir + "mzm.gsp.activity.confbean.SActiveConst.bny";
/*     */     try
/*     */     {
/* 109 */       File file = new File(path);
/* 110 */       if (file.exists())
/*     */       {
/* 112 */         byte[] bytes = new byte['Ѐ'];
/* 113 */         FileInputStream fis = new FileInputStream(file);
/* 114 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 115 */         int len = 0;
/* 116 */         while ((len = fis.read(bytes)) > 0)
/* 117 */           baos.write(bytes, 0, len);
/* 118 */         fis.close();
/* 119 */         bytes = baos.toByteArray();
/* 120 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 121 */         this.activeResetObserverid = _os_.unmarshal_int();
/* 122 */         this.mailCfgId = _os_.unmarshal_int();
/* 123 */         this.activeValueShowUp = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 128 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 134 */     String path = dir + "mzm.gsp.activity.confbean.SActiveConst.bny";
/*     */     try
/*     */     {
/* 137 */       File file = new File(path);
/* 138 */       if (file.exists())
/*     */       {
/* 140 */         byte[] bytes = new byte['Ѐ'];
/* 141 */         FileInputStream fis = new FileInputStream(file);
/* 142 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 143 */         int len = 0;
/* 144 */         while ((len = fis.read(bytes)) > 0)
/* 145 */           baos.write(bytes, 0, len);
/* 146 */         fis.close();
/* 147 */         bytes = baos.toByteArray();
/* 148 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 149 */         this.activeResetObserverid = _os_.unmarshal_int();
/* 150 */         this.mailCfgId = _os_.unmarshal_int();
/* 151 */         this.activeValueShowUp = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 156 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SActiveConst newInstance)
/*     */   {
/* 162 */     oldInstance = instance;
/* 163 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 168 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\confbean\SActiveConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */