/*     */ package mzm.gsp.cat.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SCatCfgConsts
/*     */ {
/*  13 */   private static volatile SCatCfgConsts oldInstance = null;
/*     */   
/*  15 */   private static SCatCfgConsts instance = new SCatCfgConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SCatCfgConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SCatCfgConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int DAILY_THE_CAT_FEED_MAX = 1;
/*  32 */   public int DAILY_FEED_MAX = 1;
/*  33 */   public int FEED_AWARD_ID = 0;
/*     */   public int RESET_PARTNER_COST;
/*  35 */   public int FEED_CLEAR_TIME = 350299000;
/*  36 */   public int CAT_NUM_MAX = 1;
/*  37 */   public int CAT_EXPLORE_END_MAIL_CFG_ID = 340007003;
/*  38 */   public int CAT_ITEM_MAIL_CFG_ID = 340000001;
/*  39 */   public int MIN_CAT_NAME_LEN = 3;
/*  40 */   public int MAX_CAT_NAME_LEN = 6;
/*  41 */   public int MAX_CAT_LEVEL = 20;
/*  42 */   public int CAT_SERVICE_ID = 0;
/*  43 */   public int CAT_ITEM_SELL_LEVEL = 5;
/*  44 */   public int CAT_FEED_RECORD_LIMIT = 10;
/*  45 */   public int CAT_VIGOR_MAX_MAIL_CFG_ID = 340008007;
/*     */   public int BIRD;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  50 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  55 */     String path = dir + "mzm.gsp.cat.confbean.SCatCfgConsts.xml";
/*     */     try
/*     */     {
/*  58 */       SAXReader reader = new SAXReader();
/*  59 */       org.dom4j.Document doc = reader.read(new File(path));
/*  60 */       Element root = doc.getRootElement();
/*  61 */       Map<String, Element> data = new java.util.HashMap();
/*  62 */       java.util.List<?> nodeList = root.elements();
/*  63 */       int len = nodeList.size();
/*  64 */       for (int i = 0; i < len; i++)
/*     */       {
/*  66 */         Element element = (Element)nodeList.get(i);
/*  67 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  70 */           String name = element.attributeValue("name");
/*  71 */           if (data.put(name, element) != null)
/*  72 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  75 */       this.DAILY_THE_CAT_FEED_MAX = Integer.valueOf(((Element)data.get("DAILY_THE_CAT_FEED_MAX")).attributeValue("value")).intValue();
/*  76 */       this.DAILY_FEED_MAX = Integer.valueOf(((Element)data.get("DAILY_FEED_MAX")).attributeValue("value")).intValue();
/*  77 */       this.FEED_AWARD_ID = Integer.valueOf(((Element)data.get("FEED_AWARD_ID")).attributeValue("value")).intValue();
/*  78 */       this.RESET_PARTNER_COST = Integer.valueOf(((Element)data.get("RESET_PARTNER_COST")).attributeValue("value")).intValue();
/*  79 */       this.FEED_CLEAR_TIME = Integer.valueOf(((Element)data.get("FEED_CLEAR_TIME")).attributeValue("value")).intValue();
/*  80 */       this.CAT_NUM_MAX = Integer.valueOf(((Element)data.get("CAT_NUM_MAX")).attributeValue("value")).intValue();
/*  81 */       this.CAT_EXPLORE_END_MAIL_CFG_ID = Integer.valueOf(((Element)data.get("CAT_EXPLORE_END_MAIL_CFG_ID")).attributeValue("value")).intValue();
/*  82 */       this.CAT_ITEM_MAIL_CFG_ID = Integer.valueOf(((Element)data.get("CAT_ITEM_MAIL_CFG_ID")).attributeValue("value")).intValue();
/*  83 */       this.MIN_CAT_NAME_LEN = Integer.valueOf(((Element)data.get("MIN_CAT_NAME_LEN")).attributeValue("value")).intValue();
/*  84 */       this.MAX_CAT_NAME_LEN = Integer.valueOf(((Element)data.get("MAX_CAT_NAME_LEN")).attributeValue("value")).intValue();
/*  85 */       this.MAX_CAT_LEVEL = Integer.valueOf(((Element)data.get("MAX_CAT_LEVEL")).attributeValue("value")).intValue();
/*  86 */       this.CAT_SERVICE_ID = Integer.valueOf(((Element)data.get("CAT_SERVICE_ID")).attributeValue("value")).intValue();
/*  87 */       this.CAT_ITEM_SELL_LEVEL = Integer.valueOf(((Element)data.get("CAT_ITEM_SELL_LEVEL")).attributeValue("value")).intValue();
/*  88 */       this.CAT_FEED_RECORD_LIMIT = Integer.valueOf(((Element)data.get("CAT_FEED_RECORD_LIMIT")).attributeValue("value")).intValue();
/*  89 */       this.CAT_VIGOR_MAX_MAIL_CFG_ID = Integer.valueOf(((Element)data.get("CAT_VIGOR_MAX_MAIL_CFG_ID")).attributeValue("value")).intValue();
/*  90 */       this.BIRD = Integer.valueOf(((Element)data.get("BIRD")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  94 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  99 */     String path = dir + "mzm.gsp.cat.confbean.SCatCfgConsts.xml";
/*     */     try
/*     */     {
/* 102 */       SAXReader reader = new SAXReader();
/* 103 */       org.dom4j.Document doc = reader.read(new File(path));
/* 104 */       Element root = doc.getRootElement();
/* 105 */       Map<String, Element> data = new java.util.HashMap();
/* 106 */       java.util.List<?> nodeList = root.elements();
/* 107 */       int len = nodeList.size();
/* 108 */       for (int i = 0; i < len; i++)
/*     */       {
/* 110 */         Element element = (Element)nodeList.get(i);
/* 111 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 114 */           String name = element.attributeValue("name");
/* 115 */           if (data.put(name, element) != null)
/* 116 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 119 */       this.DAILY_THE_CAT_FEED_MAX = Integer.valueOf(((Element)data.get("DAILY_THE_CAT_FEED_MAX")).attributeValue("value")).intValue();
/* 120 */       this.DAILY_FEED_MAX = Integer.valueOf(((Element)data.get("DAILY_FEED_MAX")).attributeValue("value")).intValue();
/* 121 */       this.FEED_AWARD_ID = Integer.valueOf(((Element)data.get("FEED_AWARD_ID")).attributeValue("value")).intValue();
/* 122 */       this.RESET_PARTNER_COST = Integer.valueOf(((Element)data.get("RESET_PARTNER_COST")).attributeValue("value")).intValue();
/* 123 */       this.FEED_CLEAR_TIME = Integer.valueOf(((Element)data.get("FEED_CLEAR_TIME")).attributeValue("value")).intValue();
/* 124 */       this.CAT_NUM_MAX = Integer.valueOf(((Element)data.get("CAT_NUM_MAX")).attributeValue("value")).intValue();
/* 125 */       this.CAT_EXPLORE_END_MAIL_CFG_ID = Integer.valueOf(((Element)data.get("CAT_EXPLORE_END_MAIL_CFG_ID")).attributeValue("value")).intValue();
/* 126 */       this.CAT_ITEM_MAIL_CFG_ID = Integer.valueOf(((Element)data.get("CAT_ITEM_MAIL_CFG_ID")).attributeValue("value")).intValue();
/* 127 */       this.MIN_CAT_NAME_LEN = Integer.valueOf(((Element)data.get("MIN_CAT_NAME_LEN")).attributeValue("value")).intValue();
/* 128 */       this.MAX_CAT_NAME_LEN = Integer.valueOf(((Element)data.get("MAX_CAT_NAME_LEN")).attributeValue("value")).intValue();
/* 129 */       this.MAX_CAT_LEVEL = Integer.valueOf(((Element)data.get("MAX_CAT_LEVEL")).attributeValue("value")).intValue();
/* 130 */       this.CAT_SERVICE_ID = Integer.valueOf(((Element)data.get("CAT_SERVICE_ID")).attributeValue("value")).intValue();
/* 131 */       this.CAT_ITEM_SELL_LEVEL = Integer.valueOf(((Element)data.get("CAT_ITEM_SELL_LEVEL")).attributeValue("value")).intValue();
/* 132 */       this.CAT_FEED_RECORD_LIMIT = Integer.valueOf(((Element)data.get("CAT_FEED_RECORD_LIMIT")).attributeValue("value")).intValue();
/* 133 */       this.CAT_VIGOR_MAX_MAIL_CFG_ID = Integer.valueOf(((Element)data.get("CAT_VIGOR_MAX_MAIL_CFG_ID")).attributeValue("value")).intValue();
/* 134 */       this.BIRD = Integer.valueOf(((Element)data.get("BIRD")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 138 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 142 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 145 */     String path = dir + "mzm.gsp.cat.confbean.SCatCfgConsts.bny";
/*     */     try
/*     */     {
/* 148 */       File file = new File(path);
/* 149 */       if (file.exists())
/*     */       {
/* 151 */         byte[] bytes = new byte['Ѐ'];
/* 152 */         FileInputStream fis = new FileInputStream(file);
/* 153 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 154 */         int len = 0;
/* 155 */         while ((len = fis.read(bytes)) > 0)
/* 156 */           baos.write(bytes, 0, len);
/* 157 */         fis.close();
/* 158 */         bytes = baos.toByteArray();
/* 159 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 160 */         this.DAILY_THE_CAT_FEED_MAX = _os_.unmarshal_int();
/* 161 */         this.DAILY_FEED_MAX = _os_.unmarshal_int();
/* 162 */         this.FEED_AWARD_ID = _os_.unmarshal_int();
/* 163 */         this.RESET_PARTNER_COST = _os_.unmarshal_int();
/* 164 */         this.FEED_CLEAR_TIME = _os_.unmarshal_int();
/* 165 */         this.CAT_NUM_MAX = _os_.unmarshal_int();
/* 166 */         this.CAT_EXPLORE_END_MAIL_CFG_ID = _os_.unmarshal_int();
/* 167 */         this.CAT_ITEM_MAIL_CFG_ID = _os_.unmarshal_int();
/* 168 */         this.MIN_CAT_NAME_LEN = _os_.unmarshal_int();
/* 169 */         this.MAX_CAT_NAME_LEN = _os_.unmarshal_int();
/* 170 */         this.MAX_CAT_LEVEL = _os_.unmarshal_int();
/* 171 */         this.CAT_SERVICE_ID = _os_.unmarshal_int();
/* 172 */         this.CAT_ITEM_SELL_LEVEL = _os_.unmarshal_int();
/* 173 */         this.CAT_FEED_RECORD_LIMIT = _os_.unmarshal_int();
/* 174 */         this.CAT_VIGOR_MAX_MAIL_CFG_ID = _os_.unmarshal_int();
/* 175 */         this.BIRD = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 180 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 186 */     String path = dir + "mzm.gsp.cat.confbean.SCatCfgConsts.bny";
/*     */     try
/*     */     {
/* 189 */       File file = new File(path);
/* 190 */       if (file.exists())
/*     */       {
/* 192 */         byte[] bytes = new byte['Ѐ'];
/* 193 */         FileInputStream fis = new FileInputStream(file);
/* 194 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 195 */         int len = 0;
/* 196 */         while ((len = fis.read(bytes)) > 0)
/* 197 */           baos.write(bytes, 0, len);
/* 198 */         fis.close();
/* 199 */         bytes = baos.toByteArray();
/* 200 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 201 */         this.DAILY_THE_CAT_FEED_MAX = _os_.unmarshal_int();
/* 202 */         this.DAILY_FEED_MAX = _os_.unmarshal_int();
/* 203 */         this.FEED_AWARD_ID = _os_.unmarshal_int();
/* 204 */         this.RESET_PARTNER_COST = _os_.unmarshal_int();
/* 205 */         this.FEED_CLEAR_TIME = _os_.unmarshal_int();
/* 206 */         this.CAT_NUM_MAX = _os_.unmarshal_int();
/* 207 */         this.CAT_EXPLORE_END_MAIL_CFG_ID = _os_.unmarshal_int();
/* 208 */         this.CAT_ITEM_MAIL_CFG_ID = _os_.unmarshal_int();
/* 209 */         this.MIN_CAT_NAME_LEN = _os_.unmarshal_int();
/* 210 */         this.MAX_CAT_NAME_LEN = _os_.unmarshal_int();
/* 211 */         this.MAX_CAT_LEVEL = _os_.unmarshal_int();
/* 212 */         this.CAT_SERVICE_ID = _os_.unmarshal_int();
/* 213 */         this.CAT_ITEM_SELL_LEVEL = _os_.unmarshal_int();
/* 214 */         this.CAT_FEED_RECORD_LIMIT = _os_.unmarshal_int();
/* 215 */         this.CAT_VIGOR_MAX_MAIL_CFG_ID = _os_.unmarshal_int();
/* 216 */         this.BIRD = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 221 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SCatCfgConsts newInstance)
/*     */   {
/* 227 */     oldInstance = instance;
/* 228 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 233 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\confbean\SCatCfgConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */