/*     */ package mzm.gsp.homeland.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SBanquetConsts
/*     */ {
/*  13 */   private static volatile SBanquetConsts oldInstance = null;
/*     */   
/*  15 */   private static SBanquetConsts instance = new SBanquetConsts();
/*     */   
/*     */ 
/*     */   public int ACTIVITY_ID;
/*     */   
/*     */ 
/*     */   public static SBanquetConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SBanquetConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*  32 */   public int HOLD_BANQUEST_NPC = 0;
/*  33 */   public int HOLD_BANQUEST_NPC_SERVICE = 150205400;
/*  34 */   public int HOLD_BANQUEST_ROLE_LEVEL = 30;
/*  35 */   public int JOIN_BANQUEST_PEOPLE_UPPER = 50;
/*  36 */   public int HOLD_BANQUEST_TIME_LIMIT = 10;
/*  37 */   public int BANQUEST_RESERVE_TIME = 60;
/*  38 */   public int DISHES_INTERVAL_TIME = 120;
/*  39 */   public int DISHES_TIP_TIME = 10;
/*  40 */   public int CLEAR_CONTROLLER_INTERVAL = 100;
/*  41 */   public int DISHES_COUNT_MAX = 5;
/*  42 */   public int TRANSFORM_MAP_ID = 0;
/*  43 */   public int DAY_CAN_GET_MAX = 5;
/*  44 */   public int EACH_BANQUEST_CAN_GET_MAX = 5;
/*  45 */   public int EACH_DISH_CAN_GET_MAX = 1;
/*  46 */   public int DAY_CAN_HOLD_BANQUEST_MAX = 1;
/*  47 */   public int CHECK_ID = 1;
/*  48 */   public int JOIN_LEVEL_MIN = 30;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  52 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  57 */     String path = dir + "mzm.gsp.homeland.confbean.SBanquetConsts.xml";
/*     */     try
/*     */     {
/*  60 */       SAXReader reader = new SAXReader();
/*  61 */       org.dom4j.Document doc = reader.read(new File(path));
/*  62 */       Element root = doc.getRootElement();
/*  63 */       Map<String, Element> data = new java.util.HashMap();
/*  64 */       java.util.List<?> nodeList = root.elements();
/*  65 */       int len = nodeList.size();
/*  66 */       for (int i = 0; i < len; i++)
/*     */       {
/*  68 */         Element element = (Element)nodeList.get(i);
/*  69 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  72 */           String name = element.attributeValue("name");
/*  73 */           if (data.put(name, element) != null)
/*  74 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  77 */       this.ACTIVITY_ID = Integer.valueOf(((Element)data.get("ACTIVITY_ID")).attributeValue("value")).intValue();
/*  78 */       this.HOLD_BANQUEST_NPC = Integer.valueOf(((Element)data.get("HOLD_BANQUEST_NPC")).attributeValue("value")).intValue();
/*  79 */       this.HOLD_BANQUEST_NPC_SERVICE = Integer.valueOf(((Element)data.get("HOLD_BANQUEST_NPC_SERVICE")).attributeValue("value")).intValue();
/*  80 */       this.HOLD_BANQUEST_ROLE_LEVEL = Integer.valueOf(((Element)data.get("HOLD_BANQUEST_ROLE_LEVEL")).attributeValue("value")).intValue();
/*  81 */       this.JOIN_BANQUEST_PEOPLE_UPPER = Integer.valueOf(((Element)data.get("JOIN_BANQUEST_PEOPLE_UPPER")).attributeValue("value")).intValue();
/*  82 */       this.HOLD_BANQUEST_TIME_LIMIT = Integer.valueOf(((Element)data.get("HOLD_BANQUEST_TIME_LIMIT")).attributeValue("value")).intValue();
/*  83 */       this.BANQUEST_RESERVE_TIME = Integer.valueOf(((Element)data.get("BANQUEST_RESERVE_TIME")).attributeValue("value")).intValue();
/*  84 */       this.DISHES_INTERVAL_TIME = Integer.valueOf(((Element)data.get("DISHES_INTERVAL_TIME")).attributeValue("value")).intValue();
/*  85 */       this.DISHES_TIP_TIME = Integer.valueOf(((Element)data.get("DISHES_TIP_TIME")).attributeValue("value")).intValue();
/*  86 */       this.CLEAR_CONTROLLER_INTERVAL = Integer.valueOf(((Element)data.get("CLEAR_CONTROLLER_INTERVAL")).attributeValue("value")).intValue();
/*  87 */       this.DISHES_COUNT_MAX = Integer.valueOf(((Element)data.get("DISHES_COUNT_MAX")).attributeValue("value")).intValue();
/*  88 */       this.TRANSFORM_MAP_ID = Integer.valueOf(((Element)data.get("TRANSFORM_MAP_ID")).attributeValue("value")).intValue();
/*  89 */       this.DAY_CAN_GET_MAX = Integer.valueOf(((Element)data.get("DAY_CAN_GET_MAX")).attributeValue("value")).intValue();
/*  90 */       this.EACH_BANQUEST_CAN_GET_MAX = Integer.valueOf(((Element)data.get("EACH_BANQUEST_CAN_GET_MAX")).attributeValue("value")).intValue();
/*  91 */       this.EACH_DISH_CAN_GET_MAX = Integer.valueOf(((Element)data.get("EACH_DISH_CAN_GET_MAX")).attributeValue("value")).intValue();
/*  92 */       this.DAY_CAN_HOLD_BANQUEST_MAX = Integer.valueOf(((Element)data.get("DAY_CAN_HOLD_BANQUEST_MAX")).attributeValue("value")).intValue();
/*  93 */       this.CHECK_ID = Integer.valueOf(((Element)data.get("CHECK_ID")).attributeValue("value")).intValue();
/*  94 */       this.JOIN_LEVEL_MIN = Integer.valueOf(((Element)data.get("JOIN_LEVEL_MIN")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  98 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 103 */     String path = dir + "mzm.gsp.homeland.confbean.SBanquetConsts.xml";
/*     */     try
/*     */     {
/* 106 */       SAXReader reader = new SAXReader();
/* 107 */       org.dom4j.Document doc = reader.read(new File(path));
/* 108 */       Element root = doc.getRootElement();
/* 109 */       Map<String, Element> data = new java.util.HashMap();
/* 110 */       java.util.List<?> nodeList = root.elements();
/* 111 */       int len = nodeList.size();
/* 112 */       for (int i = 0; i < len; i++)
/*     */       {
/* 114 */         Element element = (Element)nodeList.get(i);
/* 115 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 118 */           String name = element.attributeValue("name");
/* 119 */           if (data.put(name, element) != null)
/* 120 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 123 */       this.ACTIVITY_ID = Integer.valueOf(((Element)data.get("ACTIVITY_ID")).attributeValue("value")).intValue();
/* 124 */       this.HOLD_BANQUEST_NPC = Integer.valueOf(((Element)data.get("HOLD_BANQUEST_NPC")).attributeValue("value")).intValue();
/* 125 */       this.HOLD_BANQUEST_NPC_SERVICE = Integer.valueOf(((Element)data.get("HOLD_BANQUEST_NPC_SERVICE")).attributeValue("value")).intValue();
/* 126 */       this.HOLD_BANQUEST_ROLE_LEVEL = Integer.valueOf(((Element)data.get("HOLD_BANQUEST_ROLE_LEVEL")).attributeValue("value")).intValue();
/* 127 */       this.JOIN_BANQUEST_PEOPLE_UPPER = Integer.valueOf(((Element)data.get("JOIN_BANQUEST_PEOPLE_UPPER")).attributeValue("value")).intValue();
/* 128 */       this.HOLD_BANQUEST_TIME_LIMIT = Integer.valueOf(((Element)data.get("HOLD_BANQUEST_TIME_LIMIT")).attributeValue("value")).intValue();
/* 129 */       this.BANQUEST_RESERVE_TIME = Integer.valueOf(((Element)data.get("BANQUEST_RESERVE_TIME")).attributeValue("value")).intValue();
/* 130 */       this.DISHES_INTERVAL_TIME = Integer.valueOf(((Element)data.get("DISHES_INTERVAL_TIME")).attributeValue("value")).intValue();
/* 131 */       this.DISHES_TIP_TIME = Integer.valueOf(((Element)data.get("DISHES_TIP_TIME")).attributeValue("value")).intValue();
/* 132 */       this.CLEAR_CONTROLLER_INTERVAL = Integer.valueOf(((Element)data.get("CLEAR_CONTROLLER_INTERVAL")).attributeValue("value")).intValue();
/* 133 */       this.DISHES_COUNT_MAX = Integer.valueOf(((Element)data.get("DISHES_COUNT_MAX")).attributeValue("value")).intValue();
/* 134 */       this.TRANSFORM_MAP_ID = Integer.valueOf(((Element)data.get("TRANSFORM_MAP_ID")).attributeValue("value")).intValue();
/* 135 */       this.DAY_CAN_GET_MAX = Integer.valueOf(((Element)data.get("DAY_CAN_GET_MAX")).attributeValue("value")).intValue();
/* 136 */       this.EACH_BANQUEST_CAN_GET_MAX = Integer.valueOf(((Element)data.get("EACH_BANQUEST_CAN_GET_MAX")).attributeValue("value")).intValue();
/* 137 */       this.EACH_DISH_CAN_GET_MAX = Integer.valueOf(((Element)data.get("EACH_DISH_CAN_GET_MAX")).attributeValue("value")).intValue();
/* 138 */       this.DAY_CAN_HOLD_BANQUEST_MAX = Integer.valueOf(((Element)data.get("DAY_CAN_HOLD_BANQUEST_MAX")).attributeValue("value")).intValue();
/* 139 */       this.CHECK_ID = Integer.valueOf(((Element)data.get("CHECK_ID")).attributeValue("value")).intValue();
/* 140 */       this.JOIN_LEVEL_MIN = Integer.valueOf(((Element)data.get("JOIN_LEVEL_MIN")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 144 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 148 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 151 */     String path = dir + "mzm.gsp.homeland.confbean.SBanquetConsts.bny";
/*     */     try
/*     */     {
/* 154 */       File file = new File(path);
/* 155 */       if (file.exists())
/*     */       {
/* 157 */         byte[] bytes = new byte['Ѐ'];
/* 158 */         FileInputStream fis = new FileInputStream(file);
/* 159 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 160 */         int len = 0;
/* 161 */         while ((len = fis.read(bytes)) > 0)
/* 162 */           baos.write(bytes, 0, len);
/* 163 */         fis.close();
/* 164 */         bytes = baos.toByteArray();
/* 165 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 166 */         this.ACTIVITY_ID = _os_.unmarshal_int();
/* 167 */         this.HOLD_BANQUEST_NPC = _os_.unmarshal_int();
/* 168 */         this.HOLD_BANQUEST_NPC_SERVICE = _os_.unmarshal_int();
/* 169 */         this.HOLD_BANQUEST_ROLE_LEVEL = _os_.unmarshal_int();
/* 170 */         this.JOIN_BANQUEST_PEOPLE_UPPER = _os_.unmarshal_int();
/* 171 */         this.HOLD_BANQUEST_TIME_LIMIT = _os_.unmarshal_int();
/* 172 */         this.BANQUEST_RESERVE_TIME = _os_.unmarshal_int();
/* 173 */         this.DISHES_INTERVAL_TIME = _os_.unmarshal_int();
/* 174 */         this.DISHES_TIP_TIME = _os_.unmarshal_int();
/* 175 */         this.CLEAR_CONTROLLER_INTERVAL = _os_.unmarshal_int();
/* 176 */         this.DISHES_COUNT_MAX = _os_.unmarshal_int();
/* 177 */         this.TRANSFORM_MAP_ID = _os_.unmarshal_int();
/* 178 */         this.DAY_CAN_GET_MAX = _os_.unmarshal_int();
/* 179 */         this.EACH_BANQUEST_CAN_GET_MAX = _os_.unmarshal_int();
/* 180 */         this.EACH_DISH_CAN_GET_MAX = _os_.unmarshal_int();
/* 181 */         this.DAY_CAN_HOLD_BANQUEST_MAX = _os_.unmarshal_int();
/* 182 */         this.CHECK_ID = _os_.unmarshal_int();
/* 183 */         this.JOIN_LEVEL_MIN = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 188 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 194 */     String path = dir + "mzm.gsp.homeland.confbean.SBanquetConsts.bny";
/*     */     try
/*     */     {
/* 197 */       File file = new File(path);
/* 198 */       if (file.exists())
/*     */       {
/* 200 */         byte[] bytes = new byte['Ѐ'];
/* 201 */         FileInputStream fis = new FileInputStream(file);
/* 202 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 203 */         int len = 0;
/* 204 */         while ((len = fis.read(bytes)) > 0)
/* 205 */           baos.write(bytes, 0, len);
/* 206 */         fis.close();
/* 207 */         bytes = baos.toByteArray();
/* 208 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 209 */         this.ACTIVITY_ID = _os_.unmarshal_int();
/* 210 */         this.HOLD_BANQUEST_NPC = _os_.unmarshal_int();
/* 211 */         this.HOLD_BANQUEST_NPC_SERVICE = _os_.unmarshal_int();
/* 212 */         this.HOLD_BANQUEST_ROLE_LEVEL = _os_.unmarshal_int();
/* 213 */         this.JOIN_BANQUEST_PEOPLE_UPPER = _os_.unmarshal_int();
/* 214 */         this.HOLD_BANQUEST_TIME_LIMIT = _os_.unmarshal_int();
/* 215 */         this.BANQUEST_RESERVE_TIME = _os_.unmarshal_int();
/* 216 */         this.DISHES_INTERVAL_TIME = _os_.unmarshal_int();
/* 217 */         this.DISHES_TIP_TIME = _os_.unmarshal_int();
/* 218 */         this.CLEAR_CONTROLLER_INTERVAL = _os_.unmarshal_int();
/* 219 */         this.DISHES_COUNT_MAX = _os_.unmarshal_int();
/* 220 */         this.TRANSFORM_MAP_ID = _os_.unmarshal_int();
/* 221 */         this.DAY_CAN_GET_MAX = _os_.unmarshal_int();
/* 222 */         this.EACH_BANQUEST_CAN_GET_MAX = _os_.unmarshal_int();
/* 223 */         this.EACH_DISH_CAN_GET_MAX = _os_.unmarshal_int();
/* 224 */         this.DAY_CAN_HOLD_BANQUEST_MAX = _os_.unmarshal_int();
/* 225 */         this.CHECK_ID = _os_.unmarshal_int();
/* 226 */         this.JOIN_LEVEL_MIN = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 231 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SBanquetConsts newInstance)
/*     */   {
/* 237 */     oldInstance = instance;
/* 238 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 243 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\confbean\SBanquetConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */