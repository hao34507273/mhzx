/*     */ package mzm.gsp.visiblemonsterfight.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SLuanShiYaoMoConsts
/*     */ {
/*  13 */   private static volatile SLuanShiYaoMoConsts oldInstance = null;
/*     */   
/*  15 */   private static SLuanShiYaoMoConsts instance = new SLuanShiYaoMoConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SLuanShiYaoMoConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SLuanShiYaoMoConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int ACTIVITYID = 0;
/*  32 */   public int VISIBLE_MONSTER_ID1 = 0;
/*  33 */   public int AWARD_ID1 = 500000000;
/*  34 */   public int VISIBLE_MONSTER_ID2 = 0;
/*  35 */   public int AWARD_ID2 = 500000000;
/*  36 */   public int REWARD_LIMIT = 10;
/*  37 */   public int AWARD_VIGOR_ID = 1;
/*  38 */   public int AWARD_VIGOR_COUNT_PERDAY = 5;
/*  39 */   public int CONTROLLERID = 0;
/*  40 */   public int REFRESH_INTERVAL_SEC = 300;
/*  41 */   public double STORE_EXP_TRANSFOR_RATE = 0.5D;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  45 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  50 */     String path = dir + "mzm.gsp.visiblemonsterfight.confbean.SLuanShiYaoMoConsts.xml";
/*     */     try
/*     */     {
/*  53 */       SAXReader reader = new SAXReader();
/*  54 */       org.dom4j.Document doc = reader.read(new File(path));
/*  55 */       Element root = doc.getRootElement();
/*  56 */       Map<String, Element> data = new java.util.HashMap();
/*  57 */       java.util.List<?> nodeList = root.elements();
/*  58 */       int len = nodeList.size();
/*  59 */       for (int i = 0; i < len; i++)
/*     */       {
/*  61 */         Element element = (Element)nodeList.get(i);
/*  62 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  65 */           String name = element.attributeValue("name");
/*  66 */           if (data.put(name, element) != null)
/*  67 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  70 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/*  71 */       this.VISIBLE_MONSTER_ID1 = Integer.valueOf(((Element)data.get("VISIBLE_MONSTER_ID1")).attributeValue("value")).intValue();
/*  72 */       this.AWARD_ID1 = Integer.valueOf(((Element)data.get("AWARD_ID1")).attributeValue("value")).intValue();
/*  73 */       this.VISIBLE_MONSTER_ID2 = Integer.valueOf(((Element)data.get("VISIBLE_MONSTER_ID2")).attributeValue("value")).intValue();
/*  74 */       this.AWARD_ID2 = Integer.valueOf(((Element)data.get("AWARD_ID2")).attributeValue("value")).intValue();
/*  75 */       this.REWARD_LIMIT = Integer.valueOf(((Element)data.get("REWARD_LIMIT")).attributeValue("value")).intValue();
/*  76 */       this.AWARD_VIGOR_ID = Integer.valueOf(((Element)data.get("AWARD_VIGOR_ID")).attributeValue("value")).intValue();
/*  77 */       this.AWARD_VIGOR_COUNT_PERDAY = Integer.valueOf(((Element)data.get("AWARD_VIGOR_COUNT_PERDAY")).attributeValue("value")).intValue();
/*  78 */       this.CONTROLLERID = Integer.valueOf(((Element)data.get("CONTROLLERID")).attributeValue("value")).intValue();
/*  79 */       this.REFRESH_INTERVAL_SEC = Integer.valueOf(((Element)data.get("REFRESH_INTERVAL_SEC")).attributeValue("value")).intValue();
/*  80 */       this.STORE_EXP_TRANSFOR_RATE = Double.valueOf(((Element)data.get("STORE_EXP_TRANSFOR_RATE")).attributeValue("value")).doubleValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  84 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  89 */     String path = dir + "mzm.gsp.visiblemonsterfight.confbean.SLuanShiYaoMoConsts.xml";
/*     */     try
/*     */     {
/*  92 */       SAXReader reader = new SAXReader();
/*  93 */       org.dom4j.Document doc = reader.read(new File(path));
/*  94 */       Element root = doc.getRootElement();
/*  95 */       Map<String, Element> data = new java.util.HashMap();
/*  96 */       java.util.List<?> nodeList = root.elements();
/*  97 */       int len = nodeList.size();
/*  98 */       for (int i = 0; i < len; i++)
/*     */       {
/* 100 */         Element element = (Element)nodeList.get(i);
/* 101 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 104 */           String name = element.attributeValue("name");
/* 105 */           if (data.put(name, element) != null)
/* 106 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 109 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/* 110 */       this.VISIBLE_MONSTER_ID1 = Integer.valueOf(((Element)data.get("VISIBLE_MONSTER_ID1")).attributeValue("value")).intValue();
/* 111 */       this.AWARD_ID1 = Integer.valueOf(((Element)data.get("AWARD_ID1")).attributeValue("value")).intValue();
/* 112 */       this.VISIBLE_MONSTER_ID2 = Integer.valueOf(((Element)data.get("VISIBLE_MONSTER_ID2")).attributeValue("value")).intValue();
/* 113 */       this.AWARD_ID2 = Integer.valueOf(((Element)data.get("AWARD_ID2")).attributeValue("value")).intValue();
/* 114 */       this.REWARD_LIMIT = Integer.valueOf(((Element)data.get("REWARD_LIMIT")).attributeValue("value")).intValue();
/* 115 */       this.AWARD_VIGOR_ID = Integer.valueOf(((Element)data.get("AWARD_VIGOR_ID")).attributeValue("value")).intValue();
/* 116 */       this.AWARD_VIGOR_COUNT_PERDAY = Integer.valueOf(((Element)data.get("AWARD_VIGOR_COUNT_PERDAY")).attributeValue("value")).intValue();
/* 117 */       this.CONTROLLERID = Integer.valueOf(((Element)data.get("CONTROLLERID")).attributeValue("value")).intValue();
/* 118 */       this.REFRESH_INTERVAL_SEC = Integer.valueOf(((Element)data.get("REFRESH_INTERVAL_SEC")).attributeValue("value")).intValue();
/* 119 */       this.STORE_EXP_TRANSFOR_RATE = Double.valueOf(((Element)data.get("STORE_EXP_TRANSFOR_RATE")).attributeValue("value")).doubleValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 123 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 127 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 130 */     String path = dir + "mzm.gsp.visiblemonsterfight.confbean.SLuanShiYaoMoConsts.bny";
/*     */     try
/*     */     {
/* 133 */       File file = new File(path);
/* 134 */       if (file.exists())
/*     */       {
/* 136 */         byte[] bytes = new byte['Ѐ'];
/* 137 */         FileInputStream fis = new FileInputStream(file);
/* 138 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 139 */         int len = 0;
/* 140 */         while ((len = fis.read(bytes)) > 0)
/* 141 */           baos.write(bytes, 0, len);
/* 142 */         fis.close();
/* 143 */         bytes = baos.toByteArray();
/* 144 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 145 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 146 */         this.VISIBLE_MONSTER_ID1 = _os_.unmarshal_int();
/* 147 */         this.AWARD_ID1 = _os_.unmarshal_int();
/* 148 */         this.VISIBLE_MONSTER_ID2 = _os_.unmarshal_int();
/* 149 */         this.AWARD_ID2 = _os_.unmarshal_int();
/* 150 */         this.REWARD_LIMIT = _os_.unmarshal_int();
/* 151 */         this.AWARD_VIGOR_ID = _os_.unmarshal_int();
/* 152 */         this.AWARD_VIGOR_COUNT_PERDAY = _os_.unmarshal_int();
/* 153 */         this.CONTROLLERID = _os_.unmarshal_int();
/* 154 */         this.REFRESH_INTERVAL_SEC = _os_.unmarshal_int();
/* 155 */         this.STORE_EXP_TRANSFOR_RATE = _os_.unmarshal_float();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 160 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 166 */     String path = dir + "mzm.gsp.visiblemonsterfight.confbean.SLuanShiYaoMoConsts.bny";
/*     */     try
/*     */     {
/* 169 */       File file = new File(path);
/* 170 */       if (file.exists())
/*     */       {
/* 172 */         byte[] bytes = new byte['Ѐ'];
/* 173 */         FileInputStream fis = new FileInputStream(file);
/* 174 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 175 */         int len = 0;
/* 176 */         while ((len = fis.read(bytes)) > 0)
/* 177 */           baos.write(bytes, 0, len);
/* 178 */         fis.close();
/* 179 */         bytes = baos.toByteArray();
/* 180 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 181 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 182 */         this.VISIBLE_MONSTER_ID1 = _os_.unmarshal_int();
/* 183 */         this.AWARD_ID1 = _os_.unmarshal_int();
/* 184 */         this.VISIBLE_MONSTER_ID2 = _os_.unmarshal_int();
/* 185 */         this.AWARD_ID2 = _os_.unmarshal_int();
/* 186 */         this.REWARD_LIMIT = _os_.unmarshal_int();
/* 187 */         this.AWARD_VIGOR_ID = _os_.unmarshal_int();
/* 188 */         this.AWARD_VIGOR_COUNT_PERDAY = _os_.unmarshal_int();
/* 189 */         this.CONTROLLERID = _os_.unmarshal_int();
/* 190 */         this.REFRESH_INTERVAL_SEC = _os_.unmarshal_int();
/* 191 */         this.STORE_EXP_TRANSFOR_RATE = _os_.unmarshal_float();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 196 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SLuanShiYaoMoConsts newInstance)
/*     */   {
/* 202 */     oldInstance = instance;
/* 203 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 208 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\confbean\SLuanShiYaoMoConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */