/*     */ package mzm.gsp.loginaward.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SLoginAwardCfgConsts
/*     */ {
/*  13 */   private static volatile SLoginAwardCfgConsts oldInstance = null;
/*     */   
/*  15 */   private static SLoginAwardCfgConsts instance = new SLoginAwardCfgConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SLoginAwardCfgConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SLoginAwardCfgConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int LOGIN_ACTIVITY_CFG_ID = 0;
/*  32 */   public int LOGIN_SUM_ACTIVITY_CFG_ID = 0;
/*  33 */   public int LOGIN_ACTIVITY_CFG_ID_1 = 0;
/*  34 */   public int LOGIN_ACTIVITY_CFG_ID_2 = 0;
/*  35 */   public int LOGIN_ACTIVITY_CFG_ID_3 = 0;
/*  36 */   public int LOGIN_ACTIVITY_CFG_ID_4 = 0;
/*  37 */   public int LOGIN_ACTIVITY_CFG_ID_5 = 0;
/*  38 */   public int LOGIN_SUM_ACTIVITY_CFG_ID_1 = 0;
/*  39 */   public int LOGIN_SUM_ACTIVITY_CFG_ID_2 = 0;
/*  40 */   public int LOGIN_SUM_ACTIVITY_CFG_ID_3 = 0;
/*  41 */   public int LOGIN_SUM_ACTIVITY_CFG_ID_4 = 0;
/*  42 */   public int LOGIN_SUM_ACTIVITY_CFG_ID_5 = 0;
/*  43 */   public int LOGIN_SIGN_ACTIVITY_CFG_ID = 0;
/*  44 */   public int LOGIN_SIGN_ACTIVITY_LEVEL_LIMIT = 20;
/*     */   public int BEGINNER_LOGIN_SIGN_ACTIVITY_CFG_ID;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  49 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  54 */     String path = dir + "mzm.gsp.loginaward.confbean.SLoginAwardCfgConsts.xml";
/*     */     try
/*     */     {
/*  57 */       SAXReader reader = new SAXReader();
/*  58 */       org.dom4j.Document doc = reader.read(new File(path));
/*  59 */       Element root = doc.getRootElement();
/*  60 */       Map<String, Element> data = new java.util.HashMap();
/*  61 */       java.util.List<?> nodeList = root.elements();
/*  62 */       int len = nodeList.size();
/*  63 */       for (int i = 0; i < len; i++)
/*     */       {
/*  65 */         Element element = (Element)nodeList.get(i);
/*  66 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  69 */           String name = element.attributeValue("name");
/*  70 */           if (data.put(name, element) != null)
/*  71 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  74 */       this.LOGIN_ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("LOGIN_ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/*  75 */       this.LOGIN_SUM_ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("LOGIN_SUM_ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/*  76 */       this.LOGIN_ACTIVITY_CFG_ID_1 = Integer.valueOf(((Element)data.get("LOGIN_ACTIVITY_CFG_ID_1")).attributeValue("value")).intValue();
/*  77 */       this.LOGIN_ACTIVITY_CFG_ID_2 = Integer.valueOf(((Element)data.get("LOGIN_ACTIVITY_CFG_ID_2")).attributeValue("value")).intValue();
/*  78 */       this.LOGIN_ACTIVITY_CFG_ID_3 = Integer.valueOf(((Element)data.get("LOGIN_ACTIVITY_CFG_ID_3")).attributeValue("value")).intValue();
/*  79 */       this.LOGIN_ACTIVITY_CFG_ID_4 = Integer.valueOf(((Element)data.get("LOGIN_ACTIVITY_CFG_ID_4")).attributeValue("value")).intValue();
/*  80 */       this.LOGIN_ACTIVITY_CFG_ID_5 = Integer.valueOf(((Element)data.get("LOGIN_ACTIVITY_CFG_ID_5")).attributeValue("value")).intValue();
/*  81 */       this.LOGIN_SUM_ACTIVITY_CFG_ID_1 = Integer.valueOf(((Element)data.get("LOGIN_SUM_ACTIVITY_CFG_ID_1")).attributeValue("value")).intValue();
/*  82 */       this.LOGIN_SUM_ACTIVITY_CFG_ID_2 = Integer.valueOf(((Element)data.get("LOGIN_SUM_ACTIVITY_CFG_ID_2")).attributeValue("value")).intValue();
/*  83 */       this.LOGIN_SUM_ACTIVITY_CFG_ID_3 = Integer.valueOf(((Element)data.get("LOGIN_SUM_ACTIVITY_CFG_ID_3")).attributeValue("value")).intValue();
/*  84 */       this.LOGIN_SUM_ACTIVITY_CFG_ID_4 = Integer.valueOf(((Element)data.get("LOGIN_SUM_ACTIVITY_CFG_ID_4")).attributeValue("value")).intValue();
/*  85 */       this.LOGIN_SUM_ACTIVITY_CFG_ID_5 = Integer.valueOf(((Element)data.get("LOGIN_SUM_ACTIVITY_CFG_ID_5")).attributeValue("value")).intValue();
/*  86 */       this.LOGIN_SIGN_ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("LOGIN_SIGN_ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/*  87 */       this.LOGIN_SIGN_ACTIVITY_LEVEL_LIMIT = Integer.valueOf(((Element)data.get("LOGIN_SIGN_ACTIVITY_LEVEL_LIMIT")).attributeValue("value")).intValue();
/*  88 */       this.BEGINNER_LOGIN_SIGN_ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("BEGINNER_LOGIN_SIGN_ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  92 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  97 */     String path = dir + "mzm.gsp.loginaward.confbean.SLoginAwardCfgConsts.xml";
/*     */     try
/*     */     {
/* 100 */       SAXReader reader = new SAXReader();
/* 101 */       org.dom4j.Document doc = reader.read(new File(path));
/* 102 */       Element root = doc.getRootElement();
/* 103 */       Map<String, Element> data = new java.util.HashMap();
/* 104 */       java.util.List<?> nodeList = root.elements();
/* 105 */       int len = nodeList.size();
/* 106 */       for (int i = 0; i < len; i++)
/*     */       {
/* 108 */         Element element = (Element)nodeList.get(i);
/* 109 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 112 */           String name = element.attributeValue("name");
/* 113 */           if (data.put(name, element) != null)
/* 114 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 117 */       this.LOGIN_ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("LOGIN_ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/* 118 */       this.LOGIN_SUM_ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("LOGIN_SUM_ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/* 119 */       this.LOGIN_ACTIVITY_CFG_ID_1 = Integer.valueOf(((Element)data.get("LOGIN_ACTIVITY_CFG_ID_1")).attributeValue("value")).intValue();
/* 120 */       this.LOGIN_ACTIVITY_CFG_ID_2 = Integer.valueOf(((Element)data.get("LOGIN_ACTIVITY_CFG_ID_2")).attributeValue("value")).intValue();
/* 121 */       this.LOGIN_ACTIVITY_CFG_ID_3 = Integer.valueOf(((Element)data.get("LOGIN_ACTIVITY_CFG_ID_3")).attributeValue("value")).intValue();
/* 122 */       this.LOGIN_ACTIVITY_CFG_ID_4 = Integer.valueOf(((Element)data.get("LOGIN_ACTIVITY_CFG_ID_4")).attributeValue("value")).intValue();
/* 123 */       this.LOGIN_ACTIVITY_CFG_ID_5 = Integer.valueOf(((Element)data.get("LOGIN_ACTIVITY_CFG_ID_5")).attributeValue("value")).intValue();
/* 124 */       this.LOGIN_SUM_ACTIVITY_CFG_ID_1 = Integer.valueOf(((Element)data.get("LOGIN_SUM_ACTIVITY_CFG_ID_1")).attributeValue("value")).intValue();
/* 125 */       this.LOGIN_SUM_ACTIVITY_CFG_ID_2 = Integer.valueOf(((Element)data.get("LOGIN_SUM_ACTIVITY_CFG_ID_2")).attributeValue("value")).intValue();
/* 126 */       this.LOGIN_SUM_ACTIVITY_CFG_ID_3 = Integer.valueOf(((Element)data.get("LOGIN_SUM_ACTIVITY_CFG_ID_3")).attributeValue("value")).intValue();
/* 127 */       this.LOGIN_SUM_ACTIVITY_CFG_ID_4 = Integer.valueOf(((Element)data.get("LOGIN_SUM_ACTIVITY_CFG_ID_4")).attributeValue("value")).intValue();
/* 128 */       this.LOGIN_SUM_ACTIVITY_CFG_ID_5 = Integer.valueOf(((Element)data.get("LOGIN_SUM_ACTIVITY_CFG_ID_5")).attributeValue("value")).intValue();
/* 129 */       this.LOGIN_SIGN_ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("LOGIN_SIGN_ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/* 130 */       this.LOGIN_SIGN_ACTIVITY_LEVEL_LIMIT = Integer.valueOf(((Element)data.get("LOGIN_SIGN_ACTIVITY_LEVEL_LIMIT")).attributeValue("value")).intValue();
/* 131 */       this.BEGINNER_LOGIN_SIGN_ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("BEGINNER_LOGIN_SIGN_ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 135 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 139 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 142 */     String path = dir + "mzm.gsp.loginaward.confbean.SLoginAwardCfgConsts.bny";
/*     */     try
/*     */     {
/* 145 */       File file = new File(path);
/* 146 */       if (file.exists())
/*     */       {
/* 148 */         byte[] bytes = new byte['Ѐ'];
/* 149 */         FileInputStream fis = new FileInputStream(file);
/* 150 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 151 */         int len = 0;
/* 152 */         while ((len = fis.read(bytes)) > 0)
/* 153 */           baos.write(bytes, 0, len);
/* 154 */         fis.close();
/* 155 */         bytes = baos.toByteArray();
/* 156 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 157 */         this.LOGIN_ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 158 */         this.LOGIN_SUM_ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 159 */         this.LOGIN_ACTIVITY_CFG_ID_1 = _os_.unmarshal_int();
/* 160 */         this.LOGIN_ACTIVITY_CFG_ID_2 = _os_.unmarshal_int();
/* 161 */         this.LOGIN_ACTIVITY_CFG_ID_3 = _os_.unmarshal_int();
/* 162 */         this.LOGIN_ACTIVITY_CFG_ID_4 = _os_.unmarshal_int();
/* 163 */         this.LOGIN_ACTIVITY_CFG_ID_5 = _os_.unmarshal_int();
/* 164 */         this.LOGIN_SUM_ACTIVITY_CFG_ID_1 = _os_.unmarshal_int();
/* 165 */         this.LOGIN_SUM_ACTIVITY_CFG_ID_2 = _os_.unmarshal_int();
/* 166 */         this.LOGIN_SUM_ACTIVITY_CFG_ID_3 = _os_.unmarshal_int();
/* 167 */         this.LOGIN_SUM_ACTIVITY_CFG_ID_4 = _os_.unmarshal_int();
/* 168 */         this.LOGIN_SUM_ACTIVITY_CFG_ID_5 = _os_.unmarshal_int();
/* 169 */         this.LOGIN_SIGN_ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 170 */         this.LOGIN_SIGN_ACTIVITY_LEVEL_LIMIT = _os_.unmarshal_int();
/* 171 */         this.BEGINNER_LOGIN_SIGN_ACTIVITY_CFG_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 176 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 182 */     String path = dir + "mzm.gsp.loginaward.confbean.SLoginAwardCfgConsts.bny";
/*     */     try
/*     */     {
/* 185 */       File file = new File(path);
/* 186 */       if (file.exists())
/*     */       {
/* 188 */         byte[] bytes = new byte['Ѐ'];
/* 189 */         FileInputStream fis = new FileInputStream(file);
/* 190 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 191 */         int len = 0;
/* 192 */         while ((len = fis.read(bytes)) > 0)
/* 193 */           baos.write(bytes, 0, len);
/* 194 */         fis.close();
/* 195 */         bytes = baos.toByteArray();
/* 196 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 197 */         this.LOGIN_ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 198 */         this.LOGIN_SUM_ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 199 */         this.LOGIN_ACTIVITY_CFG_ID_1 = _os_.unmarshal_int();
/* 200 */         this.LOGIN_ACTIVITY_CFG_ID_2 = _os_.unmarshal_int();
/* 201 */         this.LOGIN_ACTIVITY_CFG_ID_3 = _os_.unmarshal_int();
/* 202 */         this.LOGIN_ACTIVITY_CFG_ID_4 = _os_.unmarshal_int();
/* 203 */         this.LOGIN_ACTIVITY_CFG_ID_5 = _os_.unmarshal_int();
/* 204 */         this.LOGIN_SUM_ACTIVITY_CFG_ID_1 = _os_.unmarshal_int();
/* 205 */         this.LOGIN_SUM_ACTIVITY_CFG_ID_2 = _os_.unmarshal_int();
/* 206 */         this.LOGIN_SUM_ACTIVITY_CFG_ID_3 = _os_.unmarshal_int();
/* 207 */         this.LOGIN_SUM_ACTIVITY_CFG_ID_4 = _os_.unmarshal_int();
/* 208 */         this.LOGIN_SUM_ACTIVITY_CFG_ID_5 = _os_.unmarshal_int();
/* 209 */         this.LOGIN_SIGN_ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 210 */         this.LOGIN_SIGN_ACTIVITY_LEVEL_LIMIT = _os_.unmarshal_int();
/* 211 */         this.BEGINNER_LOGIN_SIGN_ACTIVITY_CFG_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 216 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SLoginAwardCfgConsts newInstance)
/*     */   {
/* 222 */     oldInstance = instance;
/* 223 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 228 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\loginaward\confbean\SLoginAwardCfgConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */