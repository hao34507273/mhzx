/*     */ package mzm.gsp.personal.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class PersonalConsts
/*     */ {
/*  13 */   private static volatile PersonalConsts oldInstance = null;
/*     */   
/*  15 */   private static PersonalConsts instance = new PersonalConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static PersonalConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static PersonalConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int PRAISE_MAX = 999999;
/*  32 */   public int DAYLIY_PRAISE_ROLE_MAX = 1;
/*  33 */   public int DAYLIY_PRAISE_MAX = 20;
/*  34 */   public int PRAISE_CLEAR_TIME = 350299000;
/*  35 */   public int ADVANCED_NEED_LEVEL = 4;
/*  36 */   public int MAX_AGE = 999;
/*  37 */   public int MAX_HOBBY = 5;
/*  38 */   public int DEFAULT_HEAD_IMAGE_ID = 102300000;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  42 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  47 */     String path = dir + "mzm.gsp.personal.confbean.PersonalConsts.xml";
/*     */     try
/*     */     {
/*  50 */       SAXReader reader = new SAXReader();
/*  51 */       org.dom4j.Document doc = reader.read(new File(path));
/*  52 */       Element root = doc.getRootElement();
/*  53 */       Map<String, Element> data = new java.util.HashMap();
/*  54 */       java.util.List<?> nodeList = root.elements();
/*  55 */       int len = nodeList.size();
/*  56 */       for (int i = 0; i < len; i++)
/*     */       {
/*  58 */         Element element = (Element)nodeList.get(i);
/*  59 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  62 */           String name = element.attributeValue("name");
/*  63 */           if (data.put(name, element) != null)
/*  64 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  67 */       this.PRAISE_MAX = Integer.valueOf(((Element)data.get("PRAISE_MAX")).attributeValue("value")).intValue();
/*  68 */       this.DAYLIY_PRAISE_ROLE_MAX = Integer.valueOf(((Element)data.get("DAYLIY_PRAISE_ROLE_MAX")).attributeValue("value")).intValue();
/*  69 */       this.DAYLIY_PRAISE_MAX = Integer.valueOf(((Element)data.get("DAYLIY_PRAISE_MAX")).attributeValue("value")).intValue();
/*  70 */       this.PRAISE_CLEAR_TIME = Integer.valueOf(((Element)data.get("PRAISE_CLEAR_TIME")).attributeValue("value")).intValue();
/*  71 */       this.ADVANCED_NEED_LEVEL = Integer.valueOf(((Element)data.get("ADVANCED_NEED_LEVEL")).attributeValue("value")).intValue();
/*  72 */       this.MAX_AGE = Integer.valueOf(((Element)data.get("MAX_AGE")).attributeValue("value")).intValue();
/*  73 */       this.MAX_HOBBY = Integer.valueOf(((Element)data.get("MAX_HOBBY")).attributeValue("value")).intValue();
/*  74 */       this.DEFAULT_HEAD_IMAGE_ID = Integer.valueOf(((Element)data.get("DEFAULT_HEAD_IMAGE_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  78 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  83 */     String path = dir + "mzm.gsp.personal.confbean.PersonalConsts.xml";
/*     */     try
/*     */     {
/*  86 */       SAXReader reader = new SAXReader();
/*  87 */       org.dom4j.Document doc = reader.read(new File(path));
/*  88 */       Element root = doc.getRootElement();
/*  89 */       Map<String, Element> data = new java.util.HashMap();
/*  90 */       java.util.List<?> nodeList = root.elements();
/*  91 */       int len = nodeList.size();
/*  92 */       for (int i = 0; i < len; i++)
/*     */       {
/*  94 */         Element element = (Element)nodeList.get(i);
/*  95 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  98 */           String name = element.attributeValue("name");
/*  99 */           if (data.put(name, element) != null)
/* 100 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 103 */       this.PRAISE_MAX = Integer.valueOf(((Element)data.get("PRAISE_MAX")).attributeValue("value")).intValue();
/* 104 */       this.DAYLIY_PRAISE_ROLE_MAX = Integer.valueOf(((Element)data.get("DAYLIY_PRAISE_ROLE_MAX")).attributeValue("value")).intValue();
/* 105 */       this.DAYLIY_PRAISE_MAX = Integer.valueOf(((Element)data.get("DAYLIY_PRAISE_MAX")).attributeValue("value")).intValue();
/* 106 */       this.PRAISE_CLEAR_TIME = Integer.valueOf(((Element)data.get("PRAISE_CLEAR_TIME")).attributeValue("value")).intValue();
/* 107 */       this.ADVANCED_NEED_LEVEL = Integer.valueOf(((Element)data.get("ADVANCED_NEED_LEVEL")).attributeValue("value")).intValue();
/* 108 */       this.MAX_AGE = Integer.valueOf(((Element)data.get("MAX_AGE")).attributeValue("value")).intValue();
/* 109 */       this.MAX_HOBBY = Integer.valueOf(((Element)data.get("MAX_HOBBY")).attributeValue("value")).intValue();
/* 110 */       this.DEFAULT_HEAD_IMAGE_ID = Integer.valueOf(((Element)data.get("DEFAULT_HEAD_IMAGE_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 114 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 118 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 121 */     String path = dir + "mzm.gsp.personal.confbean.PersonalConsts.bny";
/*     */     try
/*     */     {
/* 124 */       File file = new File(path);
/* 125 */       if (file.exists())
/*     */       {
/* 127 */         byte[] bytes = new byte['Ѐ'];
/* 128 */         FileInputStream fis = new FileInputStream(file);
/* 129 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 130 */         int len = 0;
/* 131 */         while ((len = fis.read(bytes)) > 0)
/* 132 */           baos.write(bytes, 0, len);
/* 133 */         fis.close();
/* 134 */         bytes = baos.toByteArray();
/* 135 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 136 */         this.PRAISE_MAX = _os_.unmarshal_int();
/* 137 */         this.DAYLIY_PRAISE_ROLE_MAX = _os_.unmarshal_int();
/* 138 */         this.DAYLIY_PRAISE_MAX = _os_.unmarshal_int();
/* 139 */         this.PRAISE_CLEAR_TIME = _os_.unmarshal_int();
/* 140 */         this.ADVANCED_NEED_LEVEL = _os_.unmarshal_int();
/* 141 */         this.MAX_AGE = _os_.unmarshal_int();
/* 142 */         this.MAX_HOBBY = _os_.unmarshal_int();
/* 143 */         this.DEFAULT_HEAD_IMAGE_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 148 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 154 */     String path = dir + "mzm.gsp.personal.confbean.PersonalConsts.bny";
/*     */     try
/*     */     {
/* 157 */       File file = new File(path);
/* 158 */       if (file.exists())
/*     */       {
/* 160 */         byte[] bytes = new byte['Ѐ'];
/* 161 */         FileInputStream fis = new FileInputStream(file);
/* 162 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 163 */         int len = 0;
/* 164 */         while ((len = fis.read(bytes)) > 0)
/* 165 */           baos.write(bytes, 0, len);
/* 166 */         fis.close();
/* 167 */         bytes = baos.toByteArray();
/* 168 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 169 */         this.PRAISE_MAX = _os_.unmarshal_int();
/* 170 */         this.DAYLIY_PRAISE_ROLE_MAX = _os_.unmarshal_int();
/* 171 */         this.DAYLIY_PRAISE_MAX = _os_.unmarshal_int();
/* 172 */         this.PRAISE_CLEAR_TIME = _os_.unmarshal_int();
/* 173 */         this.ADVANCED_NEED_LEVEL = _os_.unmarshal_int();
/* 174 */         this.MAX_AGE = _os_.unmarshal_int();
/* 175 */         this.MAX_HOBBY = _os_.unmarshal_int();
/* 176 */         this.DEFAULT_HEAD_IMAGE_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 181 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(PersonalConsts newInstance)
/*     */   {
/* 187 */     oldInstance = instance;
/* 188 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 193 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\confbean\PersonalConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */