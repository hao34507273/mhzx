/*     */ package mzm.gsp.item.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class ItemCfgConsts
/*     */ {
/*  13 */   private static volatile ItemCfgConsts oldInstance = null;
/*     */   
/*  15 */   private static ItemCfgConsts instance = new ItemCfgConsts();
/*     */   
/*     */   public int ITEM_RANDOM_SEED;
/*     */   public int USE_TASK_ITEM_WAIT_TIME;
/*     */   public int BAG_FULL_MAIL_ID;
/*     */   
/*     */   public static ItemCfgConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static ItemCfgConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int GIVE_ITEM_MAIL_ID;
/*     */   
/*     */   public int SYSTEM_OFFER_MAIL_ID;
/*     */   
/*     */   public int SECONDS_FOR_LOTTERY_SLOW_DOWN;
/*     */   
/*     */   public int SECONDS_FOR_STOP;
/*     */   public int FLOWER_POINT_CLEAR_TIME;
/*     */   public int LOTTERY_DELAY_INTERVAL;
/*     */   public int SHANGHUI_PRICE_RATE;
/*     */   public int MAX_EXCHANGE_COUNT;
/*     */   public int GIVE_RECEIVE_FLOWER_LEVEL_DELTA;
/*     */   public int FLOWER_POINT_RANK_VERSION;
/*     */   public int STORAGE_NAME_LENGTH;
/*     */   public int GIVE_FLOWER_MESSAGE_LENGTH;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  49 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  54 */     String path = dir + "mzm.gsp.item.confbean.ItemCfgConsts.xml";
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
/*  74 */       this.ITEM_RANDOM_SEED = Integer.valueOf(((Element)data.get("ITEM_RANDOM_SEED")).attributeValue("value")).intValue();
/*  75 */       this.USE_TASK_ITEM_WAIT_TIME = Integer.valueOf(((Element)data.get("USE_TASK_ITEM_WAIT_TIME")).attributeValue("value")).intValue();
/*  76 */       this.BAG_FULL_MAIL_ID = Integer.valueOf(((Element)data.get("BAG_FULL_MAIL_ID")).attributeValue("value")).intValue();
/*  77 */       this.GIVE_ITEM_MAIL_ID = Integer.valueOf(((Element)data.get("GIVE_ITEM_MAIL_ID")).attributeValue("value")).intValue();
/*  78 */       this.SYSTEM_OFFER_MAIL_ID = Integer.valueOf(((Element)data.get("SYSTEM_OFFER_MAIL_ID")).attributeValue("value")).intValue();
/*  79 */       this.SECONDS_FOR_LOTTERY_SLOW_DOWN = Integer.valueOf(((Element)data.get("SECONDS_FOR_LOTTERY_SLOW_DOWN")).attributeValue("value")).intValue();
/*  80 */       this.SECONDS_FOR_STOP = Integer.valueOf(((Element)data.get("SECONDS_FOR_STOP")).attributeValue("value")).intValue();
/*  81 */       this.FLOWER_POINT_CLEAR_TIME = Integer.valueOf(((Element)data.get("FLOWER_POINT_CLEAR_TIME")).attributeValue("value")).intValue();
/*  82 */       this.LOTTERY_DELAY_INTERVAL = Integer.valueOf(((Element)data.get("LOTTERY_DELAY_INTERVAL")).attributeValue("value")).intValue();
/*  83 */       this.SHANGHUI_PRICE_RATE = Integer.valueOf(((Element)data.get("SHANGHUI_PRICE_RATE")).attributeValue("value")).intValue();
/*  84 */       this.MAX_EXCHANGE_COUNT = Integer.valueOf(((Element)data.get("MAX_EXCHANGE_COUNT")).attributeValue("value")).intValue();
/*  85 */       this.GIVE_RECEIVE_FLOWER_LEVEL_DELTA = Integer.valueOf(((Element)data.get("GIVE_RECEIVE_FLOWER_LEVEL_DELTA")).attributeValue("value")).intValue();
/*  86 */       this.FLOWER_POINT_RANK_VERSION = Integer.valueOf(((Element)data.get("FLOWER_POINT_RANK_VERSION")).attributeValue("value")).intValue();
/*  87 */       this.STORAGE_NAME_LENGTH = Integer.valueOf(((Element)data.get("STORAGE_NAME_LENGTH")).attributeValue("value")).intValue();
/*  88 */       this.GIVE_FLOWER_MESSAGE_LENGTH = Integer.valueOf(((Element)data.get("GIVE_FLOWER_MESSAGE_LENGTH")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  92 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  97 */     String path = dir + "mzm.gsp.item.confbean.ItemCfgConsts.xml";
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
/* 117 */       this.ITEM_RANDOM_SEED = Integer.valueOf(((Element)data.get("ITEM_RANDOM_SEED")).attributeValue("value")).intValue();
/* 118 */       this.USE_TASK_ITEM_WAIT_TIME = Integer.valueOf(((Element)data.get("USE_TASK_ITEM_WAIT_TIME")).attributeValue("value")).intValue();
/* 119 */       this.BAG_FULL_MAIL_ID = Integer.valueOf(((Element)data.get("BAG_FULL_MAIL_ID")).attributeValue("value")).intValue();
/* 120 */       this.GIVE_ITEM_MAIL_ID = Integer.valueOf(((Element)data.get("GIVE_ITEM_MAIL_ID")).attributeValue("value")).intValue();
/* 121 */       this.SYSTEM_OFFER_MAIL_ID = Integer.valueOf(((Element)data.get("SYSTEM_OFFER_MAIL_ID")).attributeValue("value")).intValue();
/* 122 */       this.SECONDS_FOR_LOTTERY_SLOW_DOWN = Integer.valueOf(((Element)data.get("SECONDS_FOR_LOTTERY_SLOW_DOWN")).attributeValue("value")).intValue();
/* 123 */       this.SECONDS_FOR_STOP = Integer.valueOf(((Element)data.get("SECONDS_FOR_STOP")).attributeValue("value")).intValue();
/* 124 */       this.FLOWER_POINT_CLEAR_TIME = Integer.valueOf(((Element)data.get("FLOWER_POINT_CLEAR_TIME")).attributeValue("value")).intValue();
/* 125 */       this.LOTTERY_DELAY_INTERVAL = Integer.valueOf(((Element)data.get("LOTTERY_DELAY_INTERVAL")).attributeValue("value")).intValue();
/* 126 */       this.SHANGHUI_PRICE_RATE = Integer.valueOf(((Element)data.get("SHANGHUI_PRICE_RATE")).attributeValue("value")).intValue();
/* 127 */       this.MAX_EXCHANGE_COUNT = Integer.valueOf(((Element)data.get("MAX_EXCHANGE_COUNT")).attributeValue("value")).intValue();
/* 128 */       this.GIVE_RECEIVE_FLOWER_LEVEL_DELTA = Integer.valueOf(((Element)data.get("GIVE_RECEIVE_FLOWER_LEVEL_DELTA")).attributeValue("value")).intValue();
/* 129 */       this.FLOWER_POINT_RANK_VERSION = Integer.valueOf(((Element)data.get("FLOWER_POINT_RANK_VERSION")).attributeValue("value")).intValue();
/* 130 */       this.STORAGE_NAME_LENGTH = Integer.valueOf(((Element)data.get("STORAGE_NAME_LENGTH")).attributeValue("value")).intValue();
/* 131 */       this.GIVE_FLOWER_MESSAGE_LENGTH = Integer.valueOf(((Element)data.get("GIVE_FLOWER_MESSAGE_LENGTH")).attributeValue("value")).intValue();
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
/* 142 */     String path = dir + "mzm.gsp.item.confbean.ItemCfgConsts.bny";
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
/* 157 */         this.ITEM_RANDOM_SEED = _os_.unmarshal_int();
/* 158 */         this.USE_TASK_ITEM_WAIT_TIME = _os_.unmarshal_int();
/* 159 */         this.BAG_FULL_MAIL_ID = _os_.unmarshal_int();
/* 160 */         this.GIVE_ITEM_MAIL_ID = _os_.unmarshal_int();
/* 161 */         this.SYSTEM_OFFER_MAIL_ID = _os_.unmarshal_int();
/* 162 */         this.SECONDS_FOR_LOTTERY_SLOW_DOWN = _os_.unmarshal_int();
/* 163 */         this.SECONDS_FOR_STOP = _os_.unmarshal_int();
/* 164 */         this.FLOWER_POINT_CLEAR_TIME = _os_.unmarshal_int();
/* 165 */         this.LOTTERY_DELAY_INTERVAL = _os_.unmarshal_int();
/* 166 */         this.SHANGHUI_PRICE_RATE = _os_.unmarshal_int();
/* 167 */         this.MAX_EXCHANGE_COUNT = _os_.unmarshal_int();
/* 168 */         this.GIVE_RECEIVE_FLOWER_LEVEL_DELTA = _os_.unmarshal_int();
/* 169 */         this.FLOWER_POINT_RANK_VERSION = _os_.unmarshal_int();
/* 170 */         this.STORAGE_NAME_LENGTH = _os_.unmarshal_int();
/* 171 */         this.GIVE_FLOWER_MESSAGE_LENGTH = _os_.unmarshal_int();
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
/* 182 */     String path = dir + "mzm.gsp.item.confbean.ItemCfgConsts.bny";
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
/* 197 */         this.ITEM_RANDOM_SEED = _os_.unmarshal_int();
/* 198 */         this.USE_TASK_ITEM_WAIT_TIME = _os_.unmarshal_int();
/* 199 */         this.BAG_FULL_MAIL_ID = _os_.unmarshal_int();
/* 200 */         this.GIVE_ITEM_MAIL_ID = _os_.unmarshal_int();
/* 201 */         this.SYSTEM_OFFER_MAIL_ID = _os_.unmarshal_int();
/* 202 */         this.SECONDS_FOR_LOTTERY_SLOW_DOWN = _os_.unmarshal_int();
/* 203 */         this.SECONDS_FOR_STOP = _os_.unmarshal_int();
/* 204 */         this.FLOWER_POINT_CLEAR_TIME = _os_.unmarshal_int();
/* 205 */         this.LOTTERY_DELAY_INTERVAL = _os_.unmarshal_int();
/* 206 */         this.SHANGHUI_PRICE_RATE = _os_.unmarshal_int();
/* 207 */         this.MAX_EXCHANGE_COUNT = _os_.unmarshal_int();
/* 208 */         this.GIVE_RECEIVE_FLOWER_LEVEL_DELTA = _os_.unmarshal_int();
/* 209 */         this.FLOWER_POINT_RANK_VERSION = _os_.unmarshal_int();
/* 210 */         this.STORAGE_NAME_LENGTH = _os_.unmarshal_int();
/* 211 */         this.GIVE_FLOWER_MESSAGE_LENGTH = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 216 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(ItemCfgConsts newInstance)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\ItemCfgConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */