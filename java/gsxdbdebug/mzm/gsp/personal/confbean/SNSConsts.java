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
/*     */ public class SNSConsts
/*     */ {
/*  13 */   private static volatile SNSConsts oldInstance = null;
/*     */   
/*  15 */   private static SNSConsts instance = new SNSConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SNSConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SNSConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int CONTENT_MAX_LEN = 30;
/*  32 */   public int RELEASE_INTERVAL = 180;
/*  33 */   public int REFRESH_INTERVAL = 5;
/*  34 */   public int PAGE_SIZE = 5;
/*  35 */   public int VALID_MAX_TIME = 720;
/*  36 */   public int ALL_SUB_TYPE_ID = 103100000;
/*     */   public int DESIRE_MASTER_SUB_TYPE_ID;
/*  38 */   public int CONTENT_MIN_LEN = 10;
/*  39 */   public int OPEN_LEVEL = 25;
/*  40 */   public int DEFAULT_HEAD_IMAGE = 102300006;
/*  41 */   public String MALE_ICON_ID = "null";
/*  42 */   public String FEMALE_ICON_ID = "null";
/*  43 */   public String UNKNOWN_GENDER_ICON_ID = "null";
/*  44 */   public int SEARCH_QUEUE_SIZE = 200;
/*  45 */   public int ROLE_LEVEL_INTERVAL = 10;
/*  46 */   public int ACTIVE_ROLE_MAX = 10000;
/*  47 */   public int SEARCH_CACHE_SIZE = 100;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  51 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  56 */     String path = dir + "mzm.gsp.personal.confbean.SNSConsts.xml";
/*     */     try
/*     */     {
/*  59 */       SAXReader reader = new SAXReader();
/*  60 */       org.dom4j.Document doc = reader.read(new File(path));
/*  61 */       Element root = doc.getRootElement();
/*  62 */       Map<String, Element> data = new java.util.HashMap();
/*  63 */       java.util.List<?> nodeList = root.elements();
/*  64 */       int len = nodeList.size();
/*  65 */       for (int i = 0; i < len; i++)
/*     */       {
/*  67 */         Element element = (Element)nodeList.get(i);
/*  68 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  71 */           String name = element.attributeValue("name");
/*  72 */           if (data.put(name, element) != null)
/*  73 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  76 */       this.CONTENT_MAX_LEN = Integer.valueOf(((Element)data.get("CONTENT_MAX_LEN")).attributeValue("value")).intValue();
/*  77 */       this.RELEASE_INTERVAL = Integer.valueOf(((Element)data.get("RELEASE_INTERVAL")).attributeValue("value")).intValue();
/*  78 */       this.REFRESH_INTERVAL = Integer.valueOf(((Element)data.get("REFRESH_INTERVAL")).attributeValue("value")).intValue();
/*  79 */       this.PAGE_SIZE = Integer.valueOf(((Element)data.get("PAGE_SIZE")).attributeValue("value")).intValue();
/*  80 */       this.VALID_MAX_TIME = Integer.valueOf(((Element)data.get("VALID_MAX_TIME")).attributeValue("value")).intValue();
/*  81 */       this.ALL_SUB_TYPE_ID = Integer.valueOf(((Element)data.get("ALL_SUB_TYPE_ID")).attributeValue("value")).intValue();
/*  82 */       this.DESIRE_MASTER_SUB_TYPE_ID = Integer.valueOf(((Element)data.get("DESIRE_MASTER_SUB_TYPE_ID")).attributeValue("value")).intValue();
/*  83 */       this.CONTENT_MIN_LEN = Integer.valueOf(((Element)data.get("CONTENT_MIN_LEN")).attributeValue("value")).intValue();
/*  84 */       this.OPEN_LEVEL = Integer.valueOf(((Element)data.get("OPEN_LEVEL")).attributeValue("value")).intValue();
/*  85 */       this.DEFAULT_HEAD_IMAGE = Integer.valueOf(((Element)data.get("DEFAULT_HEAD_IMAGE")).attributeValue("value")).intValue();
/*  86 */       this.MALE_ICON_ID = String.valueOf(((Element)data.get("MALE_ICON_ID")).attributeValue("value"));
/*  87 */       this.FEMALE_ICON_ID = String.valueOf(((Element)data.get("FEMALE_ICON_ID")).attributeValue("value"));
/*  88 */       this.UNKNOWN_GENDER_ICON_ID = String.valueOf(((Element)data.get("UNKNOWN_GENDER_ICON_ID")).attributeValue("value"));
/*  89 */       this.SEARCH_QUEUE_SIZE = Integer.valueOf(((Element)data.get("SEARCH_QUEUE_SIZE")).attributeValue("value")).intValue();
/*  90 */       this.ROLE_LEVEL_INTERVAL = Integer.valueOf(((Element)data.get("ROLE_LEVEL_INTERVAL")).attributeValue("value")).intValue();
/*  91 */       this.ACTIVE_ROLE_MAX = Integer.valueOf(((Element)data.get("ACTIVE_ROLE_MAX")).attributeValue("value")).intValue();
/*  92 */       this.SEARCH_CACHE_SIZE = Integer.valueOf(((Element)data.get("SEARCH_CACHE_SIZE")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  96 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 101 */     String path = dir + "mzm.gsp.personal.confbean.SNSConsts.xml";
/*     */     try
/*     */     {
/* 104 */       SAXReader reader = new SAXReader();
/* 105 */       org.dom4j.Document doc = reader.read(new File(path));
/* 106 */       Element root = doc.getRootElement();
/* 107 */       Map<String, Element> data = new java.util.HashMap();
/* 108 */       java.util.List<?> nodeList = root.elements();
/* 109 */       int len = nodeList.size();
/* 110 */       for (int i = 0; i < len; i++)
/*     */       {
/* 112 */         Element element = (Element)nodeList.get(i);
/* 113 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 116 */           String name = element.attributeValue("name");
/* 117 */           if (data.put(name, element) != null)
/* 118 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 121 */       this.CONTENT_MAX_LEN = Integer.valueOf(((Element)data.get("CONTENT_MAX_LEN")).attributeValue("value")).intValue();
/* 122 */       this.RELEASE_INTERVAL = Integer.valueOf(((Element)data.get("RELEASE_INTERVAL")).attributeValue("value")).intValue();
/* 123 */       this.REFRESH_INTERVAL = Integer.valueOf(((Element)data.get("REFRESH_INTERVAL")).attributeValue("value")).intValue();
/* 124 */       this.PAGE_SIZE = Integer.valueOf(((Element)data.get("PAGE_SIZE")).attributeValue("value")).intValue();
/* 125 */       this.VALID_MAX_TIME = Integer.valueOf(((Element)data.get("VALID_MAX_TIME")).attributeValue("value")).intValue();
/* 126 */       this.ALL_SUB_TYPE_ID = Integer.valueOf(((Element)data.get("ALL_SUB_TYPE_ID")).attributeValue("value")).intValue();
/* 127 */       this.DESIRE_MASTER_SUB_TYPE_ID = Integer.valueOf(((Element)data.get("DESIRE_MASTER_SUB_TYPE_ID")).attributeValue("value")).intValue();
/* 128 */       this.CONTENT_MIN_LEN = Integer.valueOf(((Element)data.get("CONTENT_MIN_LEN")).attributeValue("value")).intValue();
/* 129 */       this.OPEN_LEVEL = Integer.valueOf(((Element)data.get("OPEN_LEVEL")).attributeValue("value")).intValue();
/* 130 */       this.DEFAULT_HEAD_IMAGE = Integer.valueOf(((Element)data.get("DEFAULT_HEAD_IMAGE")).attributeValue("value")).intValue();
/* 131 */       this.MALE_ICON_ID = String.valueOf(((Element)data.get("MALE_ICON_ID")).attributeValue("value"));
/* 132 */       this.FEMALE_ICON_ID = String.valueOf(((Element)data.get("FEMALE_ICON_ID")).attributeValue("value"));
/* 133 */       this.UNKNOWN_GENDER_ICON_ID = String.valueOf(((Element)data.get("UNKNOWN_GENDER_ICON_ID")).attributeValue("value"));
/* 134 */       this.SEARCH_QUEUE_SIZE = Integer.valueOf(((Element)data.get("SEARCH_QUEUE_SIZE")).attributeValue("value")).intValue();
/* 135 */       this.ROLE_LEVEL_INTERVAL = Integer.valueOf(((Element)data.get("ROLE_LEVEL_INTERVAL")).attributeValue("value")).intValue();
/* 136 */       this.ACTIVE_ROLE_MAX = Integer.valueOf(((Element)data.get("ACTIVE_ROLE_MAX")).attributeValue("value")).intValue();
/* 137 */       this.SEARCH_CACHE_SIZE = Integer.valueOf(((Element)data.get("SEARCH_CACHE_SIZE")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 141 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 145 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 148 */     String path = dir + "mzm.gsp.personal.confbean.SNSConsts.bny";
/*     */     try
/*     */     {
/* 151 */       File file = new File(path);
/* 152 */       if (file.exists())
/*     */       {
/* 154 */         byte[] bytes = new byte['Ѐ'];
/* 155 */         FileInputStream fis = new FileInputStream(file);
/* 156 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 157 */         int len = 0;
/* 158 */         while ((len = fis.read(bytes)) > 0)
/* 159 */           baos.write(bytes, 0, len);
/* 160 */         fis.close();
/* 161 */         bytes = baos.toByteArray();
/* 162 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 163 */         this.CONTENT_MAX_LEN = _os_.unmarshal_int();
/* 164 */         this.RELEASE_INTERVAL = _os_.unmarshal_int();
/* 165 */         this.REFRESH_INTERVAL = _os_.unmarshal_int();
/* 166 */         this.PAGE_SIZE = _os_.unmarshal_int();
/* 167 */         this.VALID_MAX_TIME = _os_.unmarshal_int();
/* 168 */         this.ALL_SUB_TYPE_ID = _os_.unmarshal_int();
/* 169 */         this.DESIRE_MASTER_SUB_TYPE_ID = _os_.unmarshal_int();
/* 170 */         this.CONTENT_MIN_LEN = _os_.unmarshal_int();
/* 171 */         this.OPEN_LEVEL = _os_.unmarshal_int();
/* 172 */         this.DEFAULT_HEAD_IMAGE = _os_.unmarshal_int();
/* 173 */         this.MALE_ICON_ID = _os_.unmarshal_String("UTF-8");
/* 174 */         this.FEMALE_ICON_ID = _os_.unmarshal_String("UTF-8");
/* 175 */         this.UNKNOWN_GENDER_ICON_ID = _os_.unmarshal_String("UTF-8");
/* 176 */         this.SEARCH_QUEUE_SIZE = _os_.unmarshal_int();
/* 177 */         this.ROLE_LEVEL_INTERVAL = _os_.unmarshal_int();
/* 178 */         this.ACTIVE_ROLE_MAX = _os_.unmarshal_int();
/* 179 */         this.SEARCH_CACHE_SIZE = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 184 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 190 */     String path = dir + "mzm.gsp.personal.confbean.SNSConsts.bny";
/*     */     try
/*     */     {
/* 193 */       File file = new File(path);
/* 194 */       if (file.exists())
/*     */       {
/* 196 */         byte[] bytes = new byte['Ѐ'];
/* 197 */         FileInputStream fis = new FileInputStream(file);
/* 198 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 199 */         int len = 0;
/* 200 */         while ((len = fis.read(bytes)) > 0)
/* 201 */           baos.write(bytes, 0, len);
/* 202 */         fis.close();
/* 203 */         bytes = baos.toByteArray();
/* 204 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 205 */         this.CONTENT_MAX_LEN = _os_.unmarshal_int();
/* 206 */         this.RELEASE_INTERVAL = _os_.unmarshal_int();
/* 207 */         this.REFRESH_INTERVAL = _os_.unmarshal_int();
/* 208 */         this.PAGE_SIZE = _os_.unmarshal_int();
/* 209 */         this.VALID_MAX_TIME = _os_.unmarshal_int();
/* 210 */         this.ALL_SUB_TYPE_ID = _os_.unmarshal_int();
/* 211 */         this.DESIRE_MASTER_SUB_TYPE_ID = _os_.unmarshal_int();
/* 212 */         this.CONTENT_MIN_LEN = _os_.unmarshal_int();
/* 213 */         this.OPEN_LEVEL = _os_.unmarshal_int();
/* 214 */         this.DEFAULT_HEAD_IMAGE = _os_.unmarshal_int();
/* 215 */         this.MALE_ICON_ID = _os_.unmarshal_String("UTF-8");
/* 216 */         this.FEMALE_ICON_ID = _os_.unmarshal_String("UTF-8");
/* 217 */         this.UNKNOWN_GENDER_ICON_ID = _os_.unmarshal_String("UTF-8");
/* 218 */         this.SEARCH_QUEUE_SIZE = _os_.unmarshal_int();
/* 219 */         this.ROLE_LEVEL_INTERVAL = _os_.unmarshal_int();
/* 220 */         this.ACTIVE_ROLE_MAX = _os_.unmarshal_int();
/* 221 */         this.SEARCH_CACHE_SIZE = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 226 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SNSConsts newInstance)
/*     */   {
/* 232 */     oldInstance = instance;
/* 233 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 238 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\confbean\SNSConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */