/*     */ package mzm.gsp.market.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SMarketConsts
/*     */ {
/*  13 */   private static volatile SMarketConsts oldInstance = null;
/*     */   
/*  15 */   private static SMarketConsts instance = new SMarketConsts();
/*     */   public int AUCTION_TIME;
/*     */   public int PUBLIC_TIME;
/*     */   public int TIME_BEFORE_END_PUBLIC;
/*     */   public int AUCTION_GRID_NUM;
/*     */   
/*     */   public static SMarketConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SMarketConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int COLLECTION_NUM;
/*     */   
/*     */   public int SELL_TAX_RATE;
/*     */   
/*     */   public int MAX_SELL_TAX;
/*     */   
/*     */   public int GET_MONEY_TAX_RATE;
/*     */   
/*     */   public int FORBIDDEN_ON_SHELF_START_HOUR;
/*     */   public int FORBIDDEN_ON_SHELF_END_HOUR;
/*     */   public int PAGE_SIZE;
/*     */   public int ROLE_LEVEL_FOR_OPEN_MARKET;
/*     */   public int SEARCH_QUEUE_NUMBER;
/*     */   public int MIN_SEARCH_INTERVAL;
/*     */   public int MAX_AUCTION_NUM;
/*     */   public int AUCTION_ADD_PRICE_RATE;
/*     */   public int MAX_AUCTION_PUBLIC_TIME;
/*     */   public int AUCTION_ADD_PUBLIC_TIME;
/*     */   public int AUCTION_BE_PASSED_MAIL_ID;
/*     */   public int SELLER_AUCTION_PUBLIC_END_TIP_MAIL_ID;
/*     */   public int BUYER_AUCTION_PUBLIC_END_TIP_MAIL_ID;
/*     */   public int CONCERN_AUCTION_PUBLIC_END_TIP_MAIL_ID;
/*     */   public int AUCTION_SUCCESS_MAIL_ID;
/*     */   public int AUCTION_OFF_SHELF_MAIL_ID;
/*     */   public int TIME_BEFORE_END_AUCTION_SEND_TIP_MAIL;
/*     */   public int MARKET_BUY_SELL_LOG_MAX_NUM;
/*     */   public int CUSTOMIZED_NEED_YUANBAO_NUM;
/*     */   public int MAX_CUSTOMIZED_CONDITION_NUM;
/*     */   public int MIN_PET_CUSTOMIZED_SKILL_NUM;
/*     */   public int PET_PRICE_SKILL_NUM_PARAM;
/*     */   public int PET_PRICE_SKILL_NUM_POWER_PARAM;
/*     */   public int PET_PRICE_SKILL_NUM_RATIO_PARAM;
/*     */   public double PET_MAX_PRICE_PARAM;
/*     */   public int MARKET_ITEM_MAX_PRICE;
/*     */   public int AUCTION_GOODS_OFF_SHELF_RATE;
/*     */   public int MAX_SUPPLY_SKILL_EQUIP_NUM;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  70 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  75 */     String path = dir + "mzm.gsp.market.confbean.SMarketConsts.xml";
/*     */     try
/*     */     {
/*  78 */       SAXReader reader = new SAXReader();
/*  79 */       org.dom4j.Document doc = reader.read(new File(path));
/*  80 */       Element root = doc.getRootElement();
/*  81 */       Map<String, Element> data = new java.util.HashMap();
/*  82 */       java.util.List<?> nodeList = root.elements();
/*  83 */       int len = nodeList.size();
/*  84 */       for (int i = 0; i < len; i++)
/*     */       {
/*  86 */         Element element = (Element)nodeList.get(i);
/*  87 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  90 */           String name = element.attributeValue("name");
/*  91 */           if (data.put(name, element) != null)
/*  92 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  95 */       this.AUCTION_TIME = Integer.valueOf(((Element)data.get("AUCTION_TIME")).attributeValue("value")).intValue();
/*  96 */       this.PUBLIC_TIME = Integer.valueOf(((Element)data.get("PUBLIC_TIME")).attributeValue("value")).intValue();
/*  97 */       this.TIME_BEFORE_END_PUBLIC = Integer.valueOf(((Element)data.get("TIME_BEFORE_END_PUBLIC")).attributeValue("value")).intValue();
/*  98 */       this.AUCTION_GRID_NUM = Integer.valueOf(((Element)data.get("AUCTION_GRID_NUM")).attributeValue("value")).intValue();
/*  99 */       this.COLLECTION_NUM = Integer.valueOf(((Element)data.get("COLLECTION_NUM")).attributeValue("value")).intValue();
/* 100 */       this.SELL_TAX_RATE = Integer.valueOf(((Element)data.get("SELL_TAX_RATE")).attributeValue("value")).intValue();
/* 101 */       this.MAX_SELL_TAX = Integer.valueOf(((Element)data.get("MAX_SELL_TAX")).attributeValue("value")).intValue();
/* 102 */       this.GET_MONEY_TAX_RATE = Integer.valueOf(((Element)data.get("GET_MONEY_TAX_RATE")).attributeValue("value")).intValue();
/* 103 */       this.FORBIDDEN_ON_SHELF_START_HOUR = Integer.valueOf(((Element)data.get("FORBIDDEN_ON_SHELF_START_HOUR")).attributeValue("value")).intValue();
/* 104 */       this.FORBIDDEN_ON_SHELF_END_HOUR = Integer.valueOf(((Element)data.get("FORBIDDEN_ON_SHELF_END_HOUR")).attributeValue("value")).intValue();
/* 105 */       this.PAGE_SIZE = Integer.valueOf(((Element)data.get("PAGE_SIZE")).attributeValue("value")).intValue();
/* 106 */       this.ROLE_LEVEL_FOR_OPEN_MARKET = Integer.valueOf(((Element)data.get("ROLE_LEVEL_FOR_OPEN_MARKET")).attributeValue("value")).intValue();
/* 107 */       this.SEARCH_QUEUE_NUMBER = Integer.valueOf(((Element)data.get("SEARCH_QUEUE_NUMBER")).attributeValue("value")).intValue();
/* 108 */       this.MIN_SEARCH_INTERVAL = Integer.valueOf(((Element)data.get("MIN_SEARCH_INTERVAL")).attributeValue("value")).intValue();
/* 109 */       this.MAX_AUCTION_NUM = Integer.valueOf(((Element)data.get("MAX_AUCTION_NUM")).attributeValue("value")).intValue();
/* 110 */       this.AUCTION_ADD_PRICE_RATE = Integer.valueOf(((Element)data.get("AUCTION_ADD_PRICE_RATE")).attributeValue("value")).intValue();
/* 111 */       this.MAX_AUCTION_PUBLIC_TIME = Integer.valueOf(((Element)data.get("MAX_AUCTION_PUBLIC_TIME")).attributeValue("value")).intValue();
/* 112 */       this.AUCTION_ADD_PUBLIC_TIME = Integer.valueOf(((Element)data.get("AUCTION_ADD_PUBLIC_TIME")).attributeValue("value")).intValue();
/* 113 */       this.AUCTION_BE_PASSED_MAIL_ID = Integer.valueOf(((Element)data.get("AUCTION_BE_PASSED_MAIL_ID")).attributeValue("value")).intValue();
/* 114 */       this.SELLER_AUCTION_PUBLIC_END_TIP_MAIL_ID = Integer.valueOf(((Element)data.get("SELLER_AUCTION_PUBLIC_END_TIP_MAIL_ID")).attributeValue("value")).intValue();
/* 115 */       this.BUYER_AUCTION_PUBLIC_END_TIP_MAIL_ID = Integer.valueOf(((Element)data.get("BUYER_AUCTION_PUBLIC_END_TIP_MAIL_ID")).attributeValue("value")).intValue();
/* 116 */       this.CONCERN_AUCTION_PUBLIC_END_TIP_MAIL_ID = Integer.valueOf(((Element)data.get("CONCERN_AUCTION_PUBLIC_END_TIP_MAIL_ID")).attributeValue("value")).intValue();
/* 117 */       this.AUCTION_SUCCESS_MAIL_ID = Integer.valueOf(((Element)data.get("AUCTION_SUCCESS_MAIL_ID")).attributeValue("value")).intValue();
/* 118 */       this.AUCTION_OFF_SHELF_MAIL_ID = Integer.valueOf(((Element)data.get("AUCTION_OFF_SHELF_MAIL_ID")).attributeValue("value")).intValue();
/* 119 */       this.TIME_BEFORE_END_AUCTION_SEND_TIP_MAIL = Integer.valueOf(((Element)data.get("TIME_BEFORE_END_AUCTION_SEND_TIP_MAIL")).attributeValue("value")).intValue();
/* 120 */       this.MARKET_BUY_SELL_LOG_MAX_NUM = Integer.valueOf(((Element)data.get("MARKET_BUY_SELL_LOG_MAX_NUM")).attributeValue("value")).intValue();
/* 121 */       this.CUSTOMIZED_NEED_YUANBAO_NUM = Integer.valueOf(((Element)data.get("CUSTOMIZED_NEED_YUANBAO_NUM")).attributeValue("value")).intValue();
/* 122 */       this.MAX_CUSTOMIZED_CONDITION_NUM = Integer.valueOf(((Element)data.get("MAX_CUSTOMIZED_CONDITION_NUM")).attributeValue("value")).intValue();
/* 123 */       this.MIN_PET_CUSTOMIZED_SKILL_NUM = Integer.valueOf(((Element)data.get("MIN_PET_CUSTOMIZED_SKILL_NUM")).attributeValue("value")).intValue();
/* 124 */       this.PET_PRICE_SKILL_NUM_PARAM = Integer.valueOf(((Element)data.get("PET_PRICE_SKILL_NUM_PARAM")).attributeValue("value")).intValue();
/* 125 */       this.PET_PRICE_SKILL_NUM_POWER_PARAM = Integer.valueOf(((Element)data.get("PET_PRICE_SKILL_NUM_POWER_PARAM")).attributeValue("value")).intValue();
/* 126 */       this.PET_PRICE_SKILL_NUM_RATIO_PARAM = Integer.valueOf(((Element)data.get("PET_PRICE_SKILL_NUM_RATIO_PARAM")).attributeValue("value")).intValue();
/* 127 */       this.PET_MAX_PRICE_PARAM = Double.valueOf(((Element)data.get("PET_MAX_PRICE_PARAM")).attributeValue("value")).doubleValue();
/* 128 */       this.MARKET_ITEM_MAX_PRICE = Integer.valueOf(((Element)data.get("MARKET_ITEM_MAX_PRICE")).attributeValue("value")).intValue();
/* 129 */       this.AUCTION_GOODS_OFF_SHELF_RATE = Integer.valueOf(((Element)data.get("AUCTION_GOODS_OFF_SHELF_RATE")).attributeValue("value")).intValue();
/* 130 */       this.MAX_SUPPLY_SKILL_EQUIP_NUM = Integer.valueOf(((Element)data.get("MAX_SUPPLY_SKILL_EQUIP_NUM")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 134 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 139 */     String path = dir + "mzm.gsp.market.confbean.SMarketConsts.xml";
/*     */     try
/*     */     {
/* 142 */       SAXReader reader = new SAXReader();
/* 143 */       org.dom4j.Document doc = reader.read(new File(path));
/* 144 */       Element root = doc.getRootElement();
/* 145 */       Map<String, Element> data = new java.util.HashMap();
/* 146 */       java.util.List<?> nodeList = root.elements();
/* 147 */       int len = nodeList.size();
/* 148 */       for (int i = 0; i < len; i++)
/*     */       {
/* 150 */         Element element = (Element)nodeList.get(i);
/* 151 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 154 */           String name = element.attributeValue("name");
/* 155 */           if (data.put(name, element) != null)
/* 156 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 159 */       this.AUCTION_TIME = Integer.valueOf(((Element)data.get("AUCTION_TIME")).attributeValue("value")).intValue();
/* 160 */       this.PUBLIC_TIME = Integer.valueOf(((Element)data.get("PUBLIC_TIME")).attributeValue("value")).intValue();
/* 161 */       this.TIME_BEFORE_END_PUBLIC = Integer.valueOf(((Element)data.get("TIME_BEFORE_END_PUBLIC")).attributeValue("value")).intValue();
/* 162 */       this.AUCTION_GRID_NUM = Integer.valueOf(((Element)data.get("AUCTION_GRID_NUM")).attributeValue("value")).intValue();
/* 163 */       this.COLLECTION_NUM = Integer.valueOf(((Element)data.get("COLLECTION_NUM")).attributeValue("value")).intValue();
/* 164 */       this.SELL_TAX_RATE = Integer.valueOf(((Element)data.get("SELL_TAX_RATE")).attributeValue("value")).intValue();
/* 165 */       this.MAX_SELL_TAX = Integer.valueOf(((Element)data.get("MAX_SELL_TAX")).attributeValue("value")).intValue();
/* 166 */       this.GET_MONEY_TAX_RATE = Integer.valueOf(((Element)data.get("GET_MONEY_TAX_RATE")).attributeValue("value")).intValue();
/* 167 */       this.FORBIDDEN_ON_SHELF_START_HOUR = Integer.valueOf(((Element)data.get("FORBIDDEN_ON_SHELF_START_HOUR")).attributeValue("value")).intValue();
/* 168 */       this.FORBIDDEN_ON_SHELF_END_HOUR = Integer.valueOf(((Element)data.get("FORBIDDEN_ON_SHELF_END_HOUR")).attributeValue("value")).intValue();
/* 169 */       this.PAGE_SIZE = Integer.valueOf(((Element)data.get("PAGE_SIZE")).attributeValue("value")).intValue();
/* 170 */       this.ROLE_LEVEL_FOR_OPEN_MARKET = Integer.valueOf(((Element)data.get("ROLE_LEVEL_FOR_OPEN_MARKET")).attributeValue("value")).intValue();
/* 171 */       this.SEARCH_QUEUE_NUMBER = Integer.valueOf(((Element)data.get("SEARCH_QUEUE_NUMBER")).attributeValue("value")).intValue();
/* 172 */       this.MIN_SEARCH_INTERVAL = Integer.valueOf(((Element)data.get("MIN_SEARCH_INTERVAL")).attributeValue("value")).intValue();
/* 173 */       this.MAX_AUCTION_NUM = Integer.valueOf(((Element)data.get("MAX_AUCTION_NUM")).attributeValue("value")).intValue();
/* 174 */       this.AUCTION_ADD_PRICE_RATE = Integer.valueOf(((Element)data.get("AUCTION_ADD_PRICE_RATE")).attributeValue("value")).intValue();
/* 175 */       this.MAX_AUCTION_PUBLIC_TIME = Integer.valueOf(((Element)data.get("MAX_AUCTION_PUBLIC_TIME")).attributeValue("value")).intValue();
/* 176 */       this.AUCTION_ADD_PUBLIC_TIME = Integer.valueOf(((Element)data.get("AUCTION_ADD_PUBLIC_TIME")).attributeValue("value")).intValue();
/* 177 */       this.AUCTION_BE_PASSED_MAIL_ID = Integer.valueOf(((Element)data.get("AUCTION_BE_PASSED_MAIL_ID")).attributeValue("value")).intValue();
/* 178 */       this.SELLER_AUCTION_PUBLIC_END_TIP_MAIL_ID = Integer.valueOf(((Element)data.get("SELLER_AUCTION_PUBLIC_END_TIP_MAIL_ID")).attributeValue("value")).intValue();
/* 179 */       this.BUYER_AUCTION_PUBLIC_END_TIP_MAIL_ID = Integer.valueOf(((Element)data.get("BUYER_AUCTION_PUBLIC_END_TIP_MAIL_ID")).attributeValue("value")).intValue();
/* 180 */       this.CONCERN_AUCTION_PUBLIC_END_TIP_MAIL_ID = Integer.valueOf(((Element)data.get("CONCERN_AUCTION_PUBLIC_END_TIP_MAIL_ID")).attributeValue("value")).intValue();
/* 181 */       this.AUCTION_SUCCESS_MAIL_ID = Integer.valueOf(((Element)data.get("AUCTION_SUCCESS_MAIL_ID")).attributeValue("value")).intValue();
/* 182 */       this.AUCTION_OFF_SHELF_MAIL_ID = Integer.valueOf(((Element)data.get("AUCTION_OFF_SHELF_MAIL_ID")).attributeValue("value")).intValue();
/* 183 */       this.TIME_BEFORE_END_AUCTION_SEND_TIP_MAIL = Integer.valueOf(((Element)data.get("TIME_BEFORE_END_AUCTION_SEND_TIP_MAIL")).attributeValue("value")).intValue();
/* 184 */       this.MARKET_BUY_SELL_LOG_MAX_NUM = Integer.valueOf(((Element)data.get("MARKET_BUY_SELL_LOG_MAX_NUM")).attributeValue("value")).intValue();
/* 185 */       this.CUSTOMIZED_NEED_YUANBAO_NUM = Integer.valueOf(((Element)data.get("CUSTOMIZED_NEED_YUANBAO_NUM")).attributeValue("value")).intValue();
/* 186 */       this.MAX_CUSTOMIZED_CONDITION_NUM = Integer.valueOf(((Element)data.get("MAX_CUSTOMIZED_CONDITION_NUM")).attributeValue("value")).intValue();
/* 187 */       this.MIN_PET_CUSTOMIZED_SKILL_NUM = Integer.valueOf(((Element)data.get("MIN_PET_CUSTOMIZED_SKILL_NUM")).attributeValue("value")).intValue();
/* 188 */       this.PET_PRICE_SKILL_NUM_PARAM = Integer.valueOf(((Element)data.get("PET_PRICE_SKILL_NUM_PARAM")).attributeValue("value")).intValue();
/* 189 */       this.PET_PRICE_SKILL_NUM_POWER_PARAM = Integer.valueOf(((Element)data.get("PET_PRICE_SKILL_NUM_POWER_PARAM")).attributeValue("value")).intValue();
/* 190 */       this.PET_PRICE_SKILL_NUM_RATIO_PARAM = Integer.valueOf(((Element)data.get("PET_PRICE_SKILL_NUM_RATIO_PARAM")).attributeValue("value")).intValue();
/* 191 */       this.PET_MAX_PRICE_PARAM = Double.valueOf(((Element)data.get("PET_MAX_PRICE_PARAM")).attributeValue("value")).doubleValue();
/* 192 */       this.MARKET_ITEM_MAX_PRICE = Integer.valueOf(((Element)data.get("MARKET_ITEM_MAX_PRICE")).attributeValue("value")).intValue();
/* 193 */       this.AUCTION_GOODS_OFF_SHELF_RATE = Integer.valueOf(((Element)data.get("AUCTION_GOODS_OFF_SHELF_RATE")).attributeValue("value")).intValue();
/* 194 */       this.MAX_SUPPLY_SKILL_EQUIP_NUM = Integer.valueOf(((Element)data.get("MAX_SUPPLY_SKILL_EQUIP_NUM")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 198 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 202 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 205 */     String path = dir + "mzm.gsp.market.confbean.SMarketConsts.bny";
/*     */     try
/*     */     {
/* 208 */       File file = new File(path);
/* 209 */       if (file.exists())
/*     */       {
/* 211 */         byte[] bytes = new byte['Ѐ'];
/* 212 */         FileInputStream fis = new FileInputStream(file);
/* 213 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 214 */         int len = 0;
/* 215 */         while ((len = fis.read(bytes)) > 0)
/* 216 */           baos.write(bytes, 0, len);
/* 217 */         fis.close();
/* 218 */         bytes = baos.toByteArray();
/* 219 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 220 */         this.AUCTION_TIME = _os_.unmarshal_int();
/* 221 */         this.PUBLIC_TIME = _os_.unmarshal_int();
/* 222 */         this.TIME_BEFORE_END_PUBLIC = _os_.unmarshal_int();
/* 223 */         this.AUCTION_GRID_NUM = _os_.unmarshal_int();
/* 224 */         this.COLLECTION_NUM = _os_.unmarshal_int();
/* 225 */         this.SELL_TAX_RATE = _os_.unmarshal_int();
/* 226 */         this.MAX_SELL_TAX = _os_.unmarshal_int();
/* 227 */         this.GET_MONEY_TAX_RATE = _os_.unmarshal_int();
/* 228 */         this.FORBIDDEN_ON_SHELF_START_HOUR = _os_.unmarshal_int();
/* 229 */         this.FORBIDDEN_ON_SHELF_END_HOUR = _os_.unmarshal_int();
/* 230 */         this.PAGE_SIZE = _os_.unmarshal_int();
/* 231 */         this.ROLE_LEVEL_FOR_OPEN_MARKET = _os_.unmarshal_int();
/* 232 */         this.SEARCH_QUEUE_NUMBER = _os_.unmarshal_int();
/* 233 */         this.MIN_SEARCH_INTERVAL = _os_.unmarshal_int();
/* 234 */         this.MAX_AUCTION_NUM = _os_.unmarshal_int();
/* 235 */         this.AUCTION_ADD_PRICE_RATE = _os_.unmarshal_int();
/* 236 */         this.MAX_AUCTION_PUBLIC_TIME = _os_.unmarshal_int();
/* 237 */         this.AUCTION_ADD_PUBLIC_TIME = _os_.unmarshal_int();
/* 238 */         this.AUCTION_BE_PASSED_MAIL_ID = _os_.unmarshal_int();
/* 239 */         this.SELLER_AUCTION_PUBLIC_END_TIP_MAIL_ID = _os_.unmarshal_int();
/* 240 */         this.BUYER_AUCTION_PUBLIC_END_TIP_MAIL_ID = _os_.unmarshal_int();
/* 241 */         this.CONCERN_AUCTION_PUBLIC_END_TIP_MAIL_ID = _os_.unmarshal_int();
/* 242 */         this.AUCTION_SUCCESS_MAIL_ID = _os_.unmarshal_int();
/* 243 */         this.AUCTION_OFF_SHELF_MAIL_ID = _os_.unmarshal_int();
/* 244 */         this.TIME_BEFORE_END_AUCTION_SEND_TIP_MAIL = _os_.unmarshal_int();
/* 245 */         this.MARKET_BUY_SELL_LOG_MAX_NUM = _os_.unmarshal_int();
/* 246 */         this.CUSTOMIZED_NEED_YUANBAO_NUM = _os_.unmarshal_int();
/* 247 */         this.MAX_CUSTOMIZED_CONDITION_NUM = _os_.unmarshal_int();
/* 248 */         this.MIN_PET_CUSTOMIZED_SKILL_NUM = _os_.unmarshal_int();
/* 249 */         this.PET_PRICE_SKILL_NUM_PARAM = _os_.unmarshal_int();
/* 250 */         this.PET_PRICE_SKILL_NUM_POWER_PARAM = _os_.unmarshal_int();
/* 251 */         this.PET_PRICE_SKILL_NUM_RATIO_PARAM = _os_.unmarshal_int();
/* 252 */         this.PET_MAX_PRICE_PARAM = _os_.unmarshal_float();
/* 253 */         this.MARKET_ITEM_MAX_PRICE = _os_.unmarshal_int();
/* 254 */         this.AUCTION_GOODS_OFF_SHELF_RATE = _os_.unmarshal_int();
/* 255 */         this.MAX_SUPPLY_SKILL_EQUIP_NUM = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 260 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 266 */     String path = dir + "mzm.gsp.market.confbean.SMarketConsts.bny";
/*     */     try
/*     */     {
/* 269 */       File file = new File(path);
/* 270 */       if (file.exists())
/*     */       {
/* 272 */         byte[] bytes = new byte['Ѐ'];
/* 273 */         FileInputStream fis = new FileInputStream(file);
/* 274 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 275 */         int len = 0;
/* 276 */         while ((len = fis.read(bytes)) > 0)
/* 277 */           baos.write(bytes, 0, len);
/* 278 */         fis.close();
/* 279 */         bytes = baos.toByteArray();
/* 280 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 281 */         this.AUCTION_TIME = _os_.unmarshal_int();
/* 282 */         this.PUBLIC_TIME = _os_.unmarshal_int();
/* 283 */         this.TIME_BEFORE_END_PUBLIC = _os_.unmarshal_int();
/* 284 */         this.AUCTION_GRID_NUM = _os_.unmarshal_int();
/* 285 */         this.COLLECTION_NUM = _os_.unmarshal_int();
/* 286 */         this.SELL_TAX_RATE = _os_.unmarshal_int();
/* 287 */         this.MAX_SELL_TAX = _os_.unmarshal_int();
/* 288 */         this.GET_MONEY_TAX_RATE = _os_.unmarshal_int();
/* 289 */         this.FORBIDDEN_ON_SHELF_START_HOUR = _os_.unmarshal_int();
/* 290 */         this.FORBIDDEN_ON_SHELF_END_HOUR = _os_.unmarshal_int();
/* 291 */         this.PAGE_SIZE = _os_.unmarshal_int();
/* 292 */         this.ROLE_LEVEL_FOR_OPEN_MARKET = _os_.unmarshal_int();
/* 293 */         this.SEARCH_QUEUE_NUMBER = _os_.unmarshal_int();
/* 294 */         this.MIN_SEARCH_INTERVAL = _os_.unmarshal_int();
/* 295 */         this.MAX_AUCTION_NUM = _os_.unmarshal_int();
/* 296 */         this.AUCTION_ADD_PRICE_RATE = _os_.unmarshal_int();
/* 297 */         this.MAX_AUCTION_PUBLIC_TIME = _os_.unmarshal_int();
/* 298 */         this.AUCTION_ADD_PUBLIC_TIME = _os_.unmarshal_int();
/* 299 */         this.AUCTION_BE_PASSED_MAIL_ID = _os_.unmarshal_int();
/* 300 */         this.SELLER_AUCTION_PUBLIC_END_TIP_MAIL_ID = _os_.unmarshal_int();
/* 301 */         this.BUYER_AUCTION_PUBLIC_END_TIP_MAIL_ID = _os_.unmarshal_int();
/* 302 */         this.CONCERN_AUCTION_PUBLIC_END_TIP_MAIL_ID = _os_.unmarshal_int();
/* 303 */         this.AUCTION_SUCCESS_MAIL_ID = _os_.unmarshal_int();
/* 304 */         this.AUCTION_OFF_SHELF_MAIL_ID = _os_.unmarshal_int();
/* 305 */         this.TIME_BEFORE_END_AUCTION_SEND_TIP_MAIL = _os_.unmarshal_int();
/* 306 */         this.MARKET_BUY_SELL_LOG_MAX_NUM = _os_.unmarshal_int();
/* 307 */         this.CUSTOMIZED_NEED_YUANBAO_NUM = _os_.unmarshal_int();
/* 308 */         this.MAX_CUSTOMIZED_CONDITION_NUM = _os_.unmarshal_int();
/* 309 */         this.MIN_PET_CUSTOMIZED_SKILL_NUM = _os_.unmarshal_int();
/* 310 */         this.PET_PRICE_SKILL_NUM_PARAM = _os_.unmarshal_int();
/* 311 */         this.PET_PRICE_SKILL_NUM_POWER_PARAM = _os_.unmarshal_int();
/* 312 */         this.PET_PRICE_SKILL_NUM_RATIO_PARAM = _os_.unmarshal_int();
/* 313 */         this.PET_MAX_PRICE_PARAM = _os_.unmarshal_float();
/* 314 */         this.MARKET_ITEM_MAX_PRICE = _os_.unmarshal_int();
/* 315 */         this.AUCTION_GOODS_OFF_SHELF_RATE = _os_.unmarshal_int();
/* 316 */         this.MAX_SUPPLY_SKILL_EQUIP_NUM = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 321 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SMarketConsts newInstance)
/*     */   {
/* 327 */     oldInstance = instance;
/* 328 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 333 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\confbean\SMarketConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */