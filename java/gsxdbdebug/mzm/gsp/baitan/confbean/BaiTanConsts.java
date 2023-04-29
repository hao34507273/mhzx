/*     */ package mzm.gsp.baitan.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class BaiTanConsts
/*     */ {
/*  13 */   private static volatile BaiTanConsts oldInstance = null;
/*     */   
/*  15 */   private static BaiTanConsts instance = new BaiTanConsts();
/*     */   
/*     */   public int SERVICE_OPEN_LEVEL;
/*     */   public int ONSHOW_PERSIST_TIME;
/*     */   public int RECOMMAND_PRICE_UPDATE_INTERVAL;
/*     */   
/*     */   public static BaiTanConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static BaiTanConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int FREE_REFRESH_TIME_COUNTER;
/*     */   
/*     */   public int DEFAULT_REFRESH_INTERVAL;
/*     */   
/*     */   public int SELF_REFRESH_NEED_GOLD;
/*     */   
/*     */   public int DEFAULT_POS_NUM;
/*     */   public int EXPEND_TANWEI_NEED_YUANBAO;
/*     */   public int BAITAN_FEE_RATE;
/*     */   public int SELL_TAX_RATE;
/*     */   public int SINGLE_ADD_PRICE_RATE;
/*     */   public int HIGH_PRICE_RATE_LIMIT;
/*     */   public int LOW_PRICE_RATE_LIMIT;
/*     */   public int MAX_BAITAN_GRID_LIMIT;
/*     */   public int ITEM_STOCK_NUM;
/*     */   public int TAX_TIPS;
/*     */   public int BATAN_COST_TIPS;
/*     */   public int BASE_RATE;
/*     */   public int ROLE_LEVEL_PHASE;
/*     */   public int SUPPLY_INTERVAL;
/*     */   public int CHANNEL_SIZE;
/*     */   public int PAGE_SIZE;
/*     */   public int ITEM_DISPLAY_INIT_SERVER_LEVEL;
/*     */   public int SERVER_LEVEL_DELTA;
/*     */   public int CAN_SEE_EQUIP_LEVEL_DELTA;
/*     */   public int SHOW_EQUIP_START_LEVEL;
/*     */   public int RECYCLE_PRICE_RATE;
/*     */   public int RECYCLE_MIN_TIME;
/*     */   public int RECYCLE_FIX_TIME;
/*     */   public int RECYCLE_FLOAT_TIME;
/*     */   public int EQUIP_SIFT_MAX_LEVEL;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  65 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  70 */     String path = dir + "mzm.gsp.baitan.confbean.BaiTanConsts.xml";
/*     */     try
/*     */     {
/*  73 */       SAXReader reader = new SAXReader();
/*  74 */       org.dom4j.Document doc = reader.read(new File(path));
/*  75 */       Element root = doc.getRootElement();
/*  76 */       Map<String, Element> data = new java.util.HashMap();
/*  77 */       java.util.List<?> nodeList = root.elements();
/*  78 */       int len = nodeList.size();
/*  79 */       for (int i = 0; i < len; i++)
/*     */       {
/*  81 */         Element element = (Element)nodeList.get(i);
/*  82 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  85 */           String name = element.attributeValue("name");
/*  86 */           if (data.put(name, element) != null)
/*  87 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  90 */       this.SERVICE_OPEN_LEVEL = Integer.valueOf(((Element)data.get("SERVICE_OPEN_LEVEL")).attributeValue("value")).intValue();
/*  91 */       this.ONSHOW_PERSIST_TIME = Integer.valueOf(((Element)data.get("ONSHOW_PERSIST_TIME")).attributeValue("value")).intValue();
/*  92 */       this.RECOMMAND_PRICE_UPDATE_INTERVAL = Integer.valueOf(((Element)data.get("RECOMMAND_PRICE_UPDATE_INTERVAL")).attributeValue("value")).intValue();
/*  93 */       this.FREE_REFRESH_TIME_COUNTER = Integer.valueOf(((Element)data.get("FREE_REFRESH_TIME_COUNTER")).attributeValue("value")).intValue();
/*  94 */       this.DEFAULT_REFRESH_INTERVAL = Integer.valueOf(((Element)data.get("DEFAULT_REFRESH_INTERVAL")).attributeValue("value")).intValue();
/*  95 */       this.SELF_REFRESH_NEED_GOLD = Integer.valueOf(((Element)data.get("SELF_REFRESH_NEED_GOLD")).attributeValue("value")).intValue();
/*  96 */       this.DEFAULT_POS_NUM = Integer.valueOf(((Element)data.get("DEFAULT_POS_NUM")).attributeValue("value")).intValue();
/*  97 */       this.EXPEND_TANWEI_NEED_YUANBAO = Integer.valueOf(((Element)data.get("EXPEND_TANWEI_NEED_YUANBAO")).attributeValue("value")).intValue();
/*  98 */       this.BAITAN_FEE_RATE = Integer.valueOf(((Element)data.get("BAITAN_FEE_RATE")).attributeValue("value")).intValue();
/*  99 */       this.SELL_TAX_RATE = Integer.valueOf(((Element)data.get("SELL_TAX_RATE")).attributeValue("value")).intValue();
/* 100 */       this.SINGLE_ADD_PRICE_RATE = Integer.valueOf(((Element)data.get("SINGLE_ADD_PRICE_RATE")).attributeValue("value")).intValue();
/* 101 */       this.HIGH_PRICE_RATE_LIMIT = Integer.valueOf(((Element)data.get("HIGH_PRICE_RATE_LIMIT")).attributeValue("value")).intValue();
/* 102 */       this.LOW_PRICE_RATE_LIMIT = Integer.valueOf(((Element)data.get("LOW_PRICE_RATE_LIMIT")).attributeValue("value")).intValue();
/* 103 */       this.MAX_BAITAN_GRID_LIMIT = Integer.valueOf(((Element)data.get("MAX_BAITAN_GRID_LIMIT")).attributeValue("value")).intValue();
/* 104 */       this.ITEM_STOCK_NUM = Integer.valueOf(((Element)data.get("ITEM_STOCK_NUM")).attributeValue("value")).intValue();
/* 105 */       this.TAX_TIPS = Integer.valueOf(((Element)data.get("TAX_TIPS")).attributeValue("value")).intValue();
/* 106 */       this.BATAN_COST_TIPS = Integer.valueOf(((Element)data.get("BATAN_COST_TIPS")).attributeValue("value")).intValue();
/* 107 */       this.BASE_RATE = Integer.valueOf(((Element)data.get("BASE_RATE")).attributeValue("value")).intValue();
/* 108 */       this.ROLE_LEVEL_PHASE = Integer.valueOf(((Element)data.get("ROLE_LEVEL_PHASE")).attributeValue("value")).intValue();
/* 109 */       this.SUPPLY_INTERVAL = Integer.valueOf(((Element)data.get("SUPPLY_INTERVAL")).attributeValue("value")).intValue();
/* 110 */       this.CHANNEL_SIZE = Integer.valueOf(((Element)data.get("CHANNEL_SIZE")).attributeValue("value")).intValue();
/* 111 */       this.PAGE_SIZE = Integer.valueOf(((Element)data.get("PAGE_SIZE")).attributeValue("value")).intValue();
/* 112 */       this.ITEM_DISPLAY_INIT_SERVER_LEVEL = Integer.valueOf(((Element)data.get("ITEM_DISPLAY_INIT_SERVER_LEVEL")).attributeValue("value")).intValue();
/* 113 */       this.SERVER_LEVEL_DELTA = Integer.valueOf(((Element)data.get("SERVER_LEVEL_DELTA")).attributeValue("value")).intValue();
/* 114 */       this.CAN_SEE_EQUIP_LEVEL_DELTA = Integer.valueOf(((Element)data.get("CAN_SEE_EQUIP_LEVEL_DELTA")).attributeValue("value")).intValue();
/* 115 */       this.SHOW_EQUIP_START_LEVEL = Integer.valueOf(((Element)data.get("SHOW_EQUIP_START_LEVEL")).attributeValue("value")).intValue();
/* 116 */       this.RECYCLE_PRICE_RATE = Integer.valueOf(((Element)data.get("RECYCLE_PRICE_RATE")).attributeValue("value")).intValue();
/* 117 */       this.RECYCLE_MIN_TIME = Integer.valueOf(((Element)data.get("RECYCLE_MIN_TIME")).attributeValue("value")).intValue();
/* 118 */       this.RECYCLE_FIX_TIME = Integer.valueOf(((Element)data.get("RECYCLE_FIX_TIME")).attributeValue("value")).intValue();
/* 119 */       this.RECYCLE_FLOAT_TIME = Integer.valueOf(((Element)data.get("RECYCLE_FLOAT_TIME")).attributeValue("value")).intValue();
/* 120 */       this.EQUIP_SIFT_MAX_LEVEL = Integer.valueOf(((Element)data.get("EQUIP_SIFT_MAX_LEVEL")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 124 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 129 */     String path = dir + "mzm.gsp.baitan.confbean.BaiTanConsts.xml";
/*     */     try
/*     */     {
/* 132 */       SAXReader reader = new SAXReader();
/* 133 */       org.dom4j.Document doc = reader.read(new File(path));
/* 134 */       Element root = doc.getRootElement();
/* 135 */       Map<String, Element> data = new java.util.HashMap();
/* 136 */       java.util.List<?> nodeList = root.elements();
/* 137 */       int len = nodeList.size();
/* 138 */       for (int i = 0; i < len; i++)
/*     */       {
/* 140 */         Element element = (Element)nodeList.get(i);
/* 141 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 144 */           String name = element.attributeValue("name");
/* 145 */           if (data.put(name, element) != null)
/* 146 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 149 */       this.SERVICE_OPEN_LEVEL = Integer.valueOf(((Element)data.get("SERVICE_OPEN_LEVEL")).attributeValue("value")).intValue();
/* 150 */       this.ONSHOW_PERSIST_TIME = Integer.valueOf(((Element)data.get("ONSHOW_PERSIST_TIME")).attributeValue("value")).intValue();
/* 151 */       this.RECOMMAND_PRICE_UPDATE_INTERVAL = Integer.valueOf(((Element)data.get("RECOMMAND_PRICE_UPDATE_INTERVAL")).attributeValue("value")).intValue();
/* 152 */       this.FREE_REFRESH_TIME_COUNTER = Integer.valueOf(((Element)data.get("FREE_REFRESH_TIME_COUNTER")).attributeValue("value")).intValue();
/* 153 */       this.DEFAULT_REFRESH_INTERVAL = Integer.valueOf(((Element)data.get("DEFAULT_REFRESH_INTERVAL")).attributeValue("value")).intValue();
/* 154 */       this.SELF_REFRESH_NEED_GOLD = Integer.valueOf(((Element)data.get("SELF_REFRESH_NEED_GOLD")).attributeValue("value")).intValue();
/* 155 */       this.DEFAULT_POS_NUM = Integer.valueOf(((Element)data.get("DEFAULT_POS_NUM")).attributeValue("value")).intValue();
/* 156 */       this.EXPEND_TANWEI_NEED_YUANBAO = Integer.valueOf(((Element)data.get("EXPEND_TANWEI_NEED_YUANBAO")).attributeValue("value")).intValue();
/* 157 */       this.BAITAN_FEE_RATE = Integer.valueOf(((Element)data.get("BAITAN_FEE_RATE")).attributeValue("value")).intValue();
/* 158 */       this.SELL_TAX_RATE = Integer.valueOf(((Element)data.get("SELL_TAX_RATE")).attributeValue("value")).intValue();
/* 159 */       this.SINGLE_ADD_PRICE_RATE = Integer.valueOf(((Element)data.get("SINGLE_ADD_PRICE_RATE")).attributeValue("value")).intValue();
/* 160 */       this.HIGH_PRICE_RATE_LIMIT = Integer.valueOf(((Element)data.get("HIGH_PRICE_RATE_LIMIT")).attributeValue("value")).intValue();
/* 161 */       this.LOW_PRICE_RATE_LIMIT = Integer.valueOf(((Element)data.get("LOW_PRICE_RATE_LIMIT")).attributeValue("value")).intValue();
/* 162 */       this.MAX_BAITAN_GRID_LIMIT = Integer.valueOf(((Element)data.get("MAX_BAITAN_GRID_LIMIT")).attributeValue("value")).intValue();
/* 163 */       this.ITEM_STOCK_NUM = Integer.valueOf(((Element)data.get("ITEM_STOCK_NUM")).attributeValue("value")).intValue();
/* 164 */       this.TAX_TIPS = Integer.valueOf(((Element)data.get("TAX_TIPS")).attributeValue("value")).intValue();
/* 165 */       this.BATAN_COST_TIPS = Integer.valueOf(((Element)data.get("BATAN_COST_TIPS")).attributeValue("value")).intValue();
/* 166 */       this.BASE_RATE = Integer.valueOf(((Element)data.get("BASE_RATE")).attributeValue("value")).intValue();
/* 167 */       this.ROLE_LEVEL_PHASE = Integer.valueOf(((Element)data.get("ROLE_LEVEL_PHASE")).attributeValue("value")).intValue();
/* 168 */       this.SUPPLY_INTERVAL = Integer.valueOf(((Element)data.get("SUPPLY_INTERVAL")).attributeValue("value")).intValue();
/* 169 */       this.CHANNEL_SIZE = Integer.valueOf(((Element)data.get("CHANNEL_SIZE")).attributeValue("value")).intValue();
/* 170 */       this.PAGE_SIZE = Integer.valueOf(((Element)data.get("PAGE_SIZE")).attributeValue("value")).intValue();
/* 171 */       this.ITEM_DISPLAY_INIT_SERVER_LEVEL = Integer.valueOf(((Element)data.get("ITEM_DISPLAY_INIT_SERVER_LEVEL")).attributeValue("value")).intValue();
/* 172 */       this.SERVER_LEVEL_DELTA = Integer.valueOf(((Element)data.get("SERVER_LEVEL_DELTA")).attributeValue("value")).intValue();
/* 173 */       this.CAN_SEE_EQUIP_LEVEL_DELTA = Integer.valueOf(((Element)data.get("CAN_SEE_EQUIP_LEVEL_DELTA")).attributeValue("value")).intValue();
/* 174 */       this.SHOW_EQUIP_START_LEVEL = Integer.valueOf(((Element)data.get("SHOW_EQUIP_START_LEVEL")).attributeValue("value")).intValue();
/* 175 */       this.RECYCLE_PRICE_RATE = Integer.valueOf(((Element)data.get("RECYCLE_PRICE_RATE")).attributeValue("value")).intValue();
/* 176 */       this.RECYCLE_MIN_TIME = Integer.valueOf(((Element)data.get("RECYCLE_MIN_TIME")).attributeValue("value")).intValue();
/* 177 */       this.RECYCLE_FIX_TIME = Integer.valueOf(((Element)data.get("RECYCLE_FIX_TIME")).attributeValue("value")).intValue();
/* 178 */       this.RECYCLE_FLOAT_TIME = Integer.valueOf(((Element)data.get("RECYCLE_FLOAT_TIME")).attributeValue("value")).intValue();
/* 179 */       this.EQUIP_SIFT_MAX_LEVEL = Integer.valueOf(((Element)data.get("EQUIP_SIFT_MAX_LEVEL")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 183 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 187 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 190 */     String path = dir + "mzm.gsp.baitan.confbean.BaiTanConsts.bny";
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
/* 205 */         this.SERVICE_OPEN_LEVEL = _os_.unmarshal_int();
/* 206 */         this.ONSHOW_PERSIST_TIME = _os_.unmarshal_int();
/* 207 */         this.RECOMMAND_PRICE_UPDATE_INTERVAL = _os_.unmarshal_int();
/* 208 */         this.FREE_REFRESH_TIME_COUNTER = _os_.unmarshal_int();
/* 209 */         this.DEFAULT_REFRESH_INTERVAL = _os_.unmarshal_int();
/* 210 */         this.SELF_REFRESH_NEED_GOLD = _os_.unmarshal_int();
/* 211 */         this.DEFAULT_POS_NUM = _os_.unmarshal_int();
/* 212 */         this.EXPEND_TANWEI_NEED_YUANBAO = _os_.unmarshal_int();
/* 213 */         this.BAITAN_FEE_RATE = _os_.unmarshal_int();
/* 214 */         this.SELL_TAX_RATE = _os_.unmarshal_int();
/* 215 */         this.SINGLE_ADD_PRICE_RATE = _os_.unmarshal_int();
/* 216 */         this.HIGH_PRICE_RATE_LIMIT = _os_.unmarshal_int();
/* 217 */         this.LOW_PRICE_RATE_LIMIT = _os_.unmarshal_int();
/* 218 */         this.MAX_BAITAN_GRID_LIMIT = _os_.unmarshal_int();
/* 219 */         this.ITEM_STOCK_NUM = _os_.unmarshal_int();
/* 220 */         this.TAX_TIPS = _os_.unmarshal_int();
/* 221 */         this.BATAN_COST_TIPS = _os_.unmarshal_int();
/* 222 */         this.BASE_RATE = _os_.unmarshal_int();
/* 223 */         this.ROLE_LEVEL_PHASE = _os_.unmarshal_int();
/* 224 */         this.SUPPLY_INTERVAL = _os_.unmarshal_int();
/* 225 */         this.CHANNEL_SIZE = _os_.unmarshal_int();
/* 226 */         this.PAGE_SIZE = _os_.unmarshal_int();
/* 227 */         this.ITEM_DISPLAY_INIT_SERVER_LEVEL = _os_.unmarshal_int();
/* 228 */         this.SERVER_LEVEL_DELTA = _os_.unmarshal_int();
/* 229 */         this.CAN_SEE_EQUIP_LEVEL_DELTA = _os_.unmarshal_int();
/* 230 */         this.SHOW_EQUIP_START_LEVEL = _os_.unmarshal_int();
/* 231 */         this.RECYCLE_PRICE_RATE = _os_.unmarshal_int();
/* 232 */         this.RECYCLE_MIN_TIME = _os_.unmarshal_int();
/* 233 */         this.RECYCLE_FIX_TIME = _os_.unmarshal_int();
/* 234 */         this.RECYCLE_FLOAT_TIME = _os_.unmarshal_int();
/* 235 */         this.EQUIP_SIFT_MAX_LEVEL = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 240 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 246 */     String path = dir + "mzm.gsp.baitan.confbean.BaiTanConsts.bny";
/*     */     try
/*     */     {
/* 249 */       File file = new File(path);
/* 250 */       if (file.exists())
/*     */       {
/* 252 */         byte[] bytes = new byte['Ѐ'];
/* 253 */         FileInputStream fis = new FileInputStream(file);
/* 254 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 255 */         int len = 0;
/* 256 */         while ((len = fis.read(bytes)) > 0)
/* 257 */           baos.write(bytes, 0, len);
/* 258 */         fis.close();
/* 259 */         bytes = baos.toByteArray();
/* 260 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 261 */         this.SERVICE_OPEN_LEVEL = _os_.unmarshal_int();
/* 262 */         this.ONSHOW_PERSIST_TIME = _os_.unmarshal_int();
/* 263 */         this.RECOMMAND_PRICE_UPDATE_INTERVAL = _os_.unmarshal_int();
/* 264 */         this.FREE_REFRESH_TIME_COUNTER = _os_.unmarshal_int();
/* 265 */         this.DEFAULT_REFRESH_INTERVAL = _os_.unmarshal_int();
/* 266 */         this.SELF_REFRESH_NEED_GOLD = _os_.unmarshal_int();
/* 267 */         this.DEFAULT_POS_NUM = _os_.unmarshal_int();
/* 268 */         this.EXPEND_TANWEI_NEED_YUANBAO = _os_.unmarshal_int();
/* 269 */         this.BAITAN_FEE_RATE = _os_.unmarshal_int();
/* 270 */         this.SELL_TAX_RATE = _os_.unmarshal_int();
/* 271 */         this.SINGLE_ADD_PRICE_RATE = _os_.unmarshal_int();
/* 272 */         this.HIGH_PRICE_RATE_LIMIT = _os_.unmarshal_int();
/* 273 */         this.LOW_PRICE_RATE_LIMIT = _os_.unmarshal_int();
/* 274 */         this.MAX_BAITAN_GRID_LIMIT = _os_.unmarshal_int();
/* 275 */         this.ITEM_STOCK_NUM = _os_.unmarshal_int();
/* 276 */         this.TAX_TIPS = _os_.unmarshal_int();
/* 277 */         this.BATAN_COST_TIPS = _os_.unmarshal_int();
/* 278 */         this.BASE_RATE = _os_.unmarshal_int();
/* 279 */         this.ROLE_LEVEL_PHASE = _os_.unmarshal_int();
/* 280 */         this.SUPPLY_INTERVAL = _os_.unmarshal_int();
/* 281 */         this.CHANNEL_SIZE = _os_.unmarshal_int();
/* 282 */         this.PAGE_SIZE = _os_.unmarshal_int();
/* 283 */         this.ITEM_DISPLAY_INIT_SERVER_LEVEL = _os_.unmarshal_int();
/* 284 */         this.SERVER_LEVEL_DELTA = _os_.unmarshal_int();
/* 285 */         this.CAN_SEE_EQUIP_LEVEL_DELTA = _os_.unmarshal_int();
/* 286 */         this.SHOW_EQUIP_START_LEVEL = _os_.unmarshal_int();
/* 287 */         this.RECYCLE_PRICE_RATE = _os_.unmarshal_int();
/* 288 */         this.RECYCLE_MIN_TIME = _os_.unmarshal_int();
/* 289 */         this.RECYCLE_FIX_TIME = _os_.unmarshal_int();
/* 290 */         this.RECYCLE_FLOAT_TIME = _os_.unmarshal_int();
/* 291 */         this.EQUIP_SIFT_MAX_LEVEL = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 296 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(BaiTanConsts newInstance)
/*     */   {
/* 302 */     oldInstance = instance;
/* 303 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 308 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\confbean\BaiTanConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */