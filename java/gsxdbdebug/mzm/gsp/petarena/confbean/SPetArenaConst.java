/*     */ package mzm.gsp.petarena.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SPetArenaConst
/*     */ {
/*  13 */   private static volatile SPetArenaConst oldInstance = null;
/*     */   
/*  15 */   private static SPetArenaConst instance = new SPetArenaConst();
/*     */   
/*     */   public int OPEN_LEVEL;
/*     */   public int FIGHT_WIN_ADD_POINT;
/*     */   public int FIGHT_LOSE_ADD_POINT;
/*     */   
/*     */   public static SPetArenaConst getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SPetArenaConst getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int TOP_NUM;
/*     */   
/*     */   public int LOW_NUM;
/*     */   
/*     */   public int FREE_CHALLENGE_COUNT;
/*     */   public int ROBOT_NUM;
/*     */   public int TOP_NUM_HIDE_SCORE;
/*     */   public int TOP_NUM_HIDE_FORMATION;
/*     */   public int TOP_NUM_HIDE_PART;
/*     */   public int TOP_NUM_HIDE_ALL;
/*     */   public int AWARD_TIME_CFG_ID;
/*     */   public int REFRESH_CD;
/*     */   public int RANK_MAIL_CFG_ID;
/*     */   public int MAX_RANK_MAIL_CFG_ID;
/*     */   public int FIRST_BUY_YUANBAO_PRICE;
/*     */   public int YUANBAO_PRICE_ADD_NUM;
/*     */   public int ACTIVITY_CFG_ID;
/*     */   public int MAX_POINT;
/*     */   public int FORMATION_PARAM;
/*     */   public int MAX_BUY_COUNT;
/*     */   public int MONEY_TYPE;
/*     */   public int ROBOT_PET_LEVEL;
/*     */   public int MAX_RECORD_NUM;
/*     */   public int MAX_RANK_MAIL_CFG_ID_PROMOTE;
/*     */   public int ADD_POINT_FIGHT_MAX_NUM;
/*     */   public int ROBOT_LEVEL;
/*     */   public int FIGHT_WIN_AWARD;
/*     */   public int FIGHT_LOSE_AWARD;
/*  60 */   public String ROBOT_NAME = "";
/*     */   public int PET_ARENA_FIGHT_MAX_TIME;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  65 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  70 */     String path = dir + "mzm.gsp.petarena.confbean.SPetArenaConst.xml";
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
/*  90 */       this.OPEN_LEVEL = Integer.valueOf(((Element)data.get("OPEN_LEVEL")).attributeValue("value")).intValue();
/*  91 */       this.FIGHT_WIN_ADD_POINT = Integer.valueOf(((Element)data.get("FIGHT_WIN_ADD_POINT")).attributeValue("value")).intValue();
/*  92 */       this.FIGHT_LOSE_ADD_POINT = Integer.valueOf(((Element)data.get("FIGHT_LOSE_ADD_POINT")).attributeValue("value")).intValue();
/*  93 */       this.TOP_NUM = Integer.valueOf(((Element)data.get("TOP_NUM")).attributeValue("value")).intValue();
/*  94 */       this.LOW_NUM = Integer.valueOf(((Element)data.get("LOW_NUM")).attributeValue("value")).intValue();
/*  95 */       this.FREE_CHALLENGE_COUNT = Integer.valueOf(((Element)data.get("FREE_CHALLENGE_COUNT")).attributeValue("value")).intValue();
/*  96 */       this.ROBOT_NUM = Integer.valueOf(((Element)data.get("ROBOT_NUM")).attributeValue("value")).intValue();
/*  97 */       this.TOP_NUM_HIDE_SCORE = Integer.valueOf(((Element)data.get("TOP_NUM_HIDE_SCORE")).attributeValue("value")).intValue();
/*  98 */       this.TOP_NUM_HIDE_FORMATION = Integer.valueOf(((Element)data.get("TOP_NUM_HIDE_FORMATION")).attributeValue("value")).intValue();
/*  99 */       this.TOP_NUM_HIDE_PART = Integer.valueOf(((Element)data.get("TOP_NUM_HIDE_PART")).attributeValue("value")).intValue();
/* 100 */       this.TOP_NUM_HIDE_ALL = Integer.valueOf(((Element)data.get("TOP_NUM_HIDE_ALL")).attributeValue("value")).intValue();
/* 101 */       this.AWARD_TIME_CFG_ID = Integer.valueOf(((Element)data.get("AWARD_TIME_CFG_ID")).attributeValue("value")).intValue();
/* 102 */       this.REFRESH_CD = Integer.valueOf(((Element)data.get("REFRESH_CD")).attributeValue("value")).intValue();
/* 103 */       this.RANK_MAIL_CFG_ID = Integer.valueOf(((Element)data.get("RANK_MAIL_CFG_ID")).attributeValue("value")).intValue();
/* 104 */       this.MAX_RANK_MAIL_CFG_ID = Integer.valueOf(((Element)data.get("MAX_RANK_MAIL_CFG_ID")).attributeValue("value")).intValue();
/* 105 */       this.FIRST_BUY_YUANBAO_PRICE = Integer.valueOf(((Element)data.get("FIRST_BUY_YUANBAO_PRICE")).attributeValue("value")).intValue();
/* 106 */       this.YUANBAO_PRICE_ADD_NUM = Integer.valueOf(((Element)data.get("YUANBAO_PRICE_ADD_NUM")).attributeValue("value")).intValue();
/* 107 */       this.ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/* 108 */       this.MAX_POINT = Integer.valueOf(((Element)data.get("MAX_POINT")).attributeValue("value")).intValue();
/* 109 */       this.FORMATION_PARAM = Integer.valueOf(((Element)data.get("FORMATION_PARAM")).attributeValue("value")).intValue();
/* 110 */       this.MAX_BUY_COUNT = Integer.valueOf(((Element)data.get("MAX_BUY_COUNT")).attributeValue("value")).intValue();
/* 111 */       this.MONEY_TYPE = Integer.valueOf(((Element)data.get("MONEY_TYPE")).attributeValue("value")).intValue();
/* 112 */       this.ROBOT_PET_LEVEL = Integer.valueOf(((Element)data.get("ROBOT_PET_LEVEL")).attributeValue("value")).intValue();
/* 113 */       this.MAX_RECORD_NUM = Integer.valueOf(((Element)data.get("MAX_RECORD_NUM")).attributeValue("value")).intValue();
/* 114 */       this.MAX_RANK_MAIL_CFG_ID_PROMOTE = Integer.valueOf(((Element)data.get("MAX_RANK_MAIL_CFG_ID_PROMOTE")).attributeValue("value")).intValue();
/* 115 */       this.ADD_POINT_FIGHT_MAX_NUM = Integer.valueOf(((Element)data.get("ADD_POINT_FIGHT_MAX_NUM")).attributeValue("value")).intValue();
/* 116 */       this.ROBOT_LEVEL = Integer.valueOf(((Element)data.get("ROBOT_LEVEL")).attributeValue("value")).intValue();
/* 117 */       this.FIGHT_WIN_AWARD = Integer.valueOf(((Element)data.get("FIGHT_WIN_AWARD")).attributeValue("value")).intValue();
/* 118 */       this.FIGHT_LOSE_AWARD = Integer.valueOf(((Element)data.get("FIGHT_LOSE_AWARD")).attributeValue("value")).intValue();
/* 119 */       this.ROBOT_NAME = String.valueOf(((Element)data.get("ROBOT_NAME")).attributeValue("value"));
/* 120 */       this.PET_ARENA_FIGHT_MAX_TIME = Integer.valueOf(((Element)data.get("PET_ARENA_FIGHT_MAX_TIME")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 124 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 129 */     String path = dir + "mzm.gsp.petarena.confbean.SPetArenaConst.xml";
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
/* 149 */       this.OPEN_LEVEL = Integer.valueOf(((Element)data.get("OPEN_LEVEL")).attributeValue("value")).intValue();
/* 150 */       this.FIGHT_WIN_ADD_POINT = Integer.valueOf(((Element)data.get("FIGHT_WIN_ADD_POINT")).attributeValue("value")).intValue();
/* 151 */       this.FIGHT_LOSE_ADD_POINT = Integer.valueOf(((Element)data.get("FIGHT_LOSE_ADD_POINT")).attributeValue("value")).intValue();
/* 152 */       this.TOP_NUM = Integer.valueOf(((Element)data.get("TOP_NUM")).attributeValue("value")).intValue();
/* 153 */       this.LOW_NUM = Integer.valueOf(((Element)data.get("LOW_NUM")).attributeValue("value")).intValue();
/* 154 */       this.FREE_CHALLENGE_COUNT = Integer.valueOf(((Element)data.get("FREE_CHALLENGE_COUNT")).attributeValue("value")).intValue();
/* 155 */       this.ROBOT_NUM = Integer.valueOf(((Element)data.get("ROBOT_NUM")).attributeValue("value")).intValue();
/* 156 */       this.TOP_NUM_HIDE_SCORE = Integer.valueOf(((Element)data.get("TOP_NUM_HIDE_SCORE")).attributeValue("value")).intValue();
/* 157 */       this.TOP_NUM_HIDE_FORMATION = Integer.valueOf(((Element)data.get("TOP_NUM_HIDE_FORMATION")).attributeValue("value")).intValue();
/* 158 */       this.TOP_NUM_HIDE_PART = Integer.valueOf(((Element)data.get("TOP_NUM_HIDE_PART")).attributeValue("value")).intValue();
/* 159 */       this.TOP_NUM_HIDE_ALL = Integer.valueOf(((Element)data.get("TOP_NUM_HIDE_ALL")).attributeValue("value")).intValue();
/* 160 */       this.AWARD_TIME_CFG_ID = Integer.valueOf(((Element)data.get("AWARD_TIME_CFG_ID")).attributeValue("value")).intValue();
/* 161 */       this.REFRESH_CD = Integer.valueOf(((Element)data.get("REFRESH_CD")).attributeValue("value")).intValue();
/* 162 */       this.RANK_MAIL_CFG_ID = Integer.valueOf(((Element)data.get("RANK_MAIL_CFG_ID")).attributeValue("value")).intValue();
/* 163 */       this.MAX_RANK_MAIL_CFG_ID = Integer.valueOf(((Element)data.get("MAX_RANK_MAIL_CFG_ID")).attributeValue("value")).intValue();
/* 164 */       this.FIRST_BUY_YUANBAO_PRICE = Integer.valueOf(((Element)data.get("FIRST_BUY_YUANBAO_PRICE")).attributeValue("value")).intValue();
/* 165 */       this.YUANBAO_PRICE_ADD_NUM = Integer.valueOf(((Element)data.get("YUANBAO_PRICE_ADD_NUM")).attributeValue("value")).intValue();
/* 166 */       this.ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/* 167 */       this.MAX_POINT = Integer.valueOf(((Element)data.get("MAX_POINT")).attributeValue("value")).intValue();
/* 168 */       this.FORMATION_PARAM = Integer.valueOf(((Element)data.get("FORMATION_PARAM")).attributeValue("value")).intValue();
/* 169 */       this.MAX_BUY_COUNT = Integer.valueOf(((Element)data.get("MAX_BUY_COUNT")).attributeValue("value")).intValue();
/* 170 */       this.MONEY_TYPE = Integer.valueOf(((Element)data.get("MONEY_TYPE")).attributeValue("value")).intValue();
/* 171 */       this.ROBOT_PET_LEVEL = Integer.valueOf(((Element)data.get("ROBOT_PET_LEVEL")).attributeValue("value")).intValue();
/* 172 */       this.MAX_RECORD_NUM = Integer.valueOf(((Element)data.get("MAX_RECORD_NUM")).attributeValue("value")).intValue();
/* 173 */       this.MAX_RANK_MAIL_CFG_ID_PROMOTE = Integer.valueOf(((Element)data.get("MAX_RANK_MAIL_CFG_ID_PROMOTE")).attributeValue("value")).intValue();
/* 174 */       this.ADD_POINT_FIGHT_MAX_NUM = Integer.valueOf(((Element)data.get("ADD_POINT_FIGHT_MAX_NUM")).attributeValue("value")).intValue();
/* 175 */       this.ROBOT_LEVEL = Integer.valueOf(((Element)data.get("ROBOT_LEVEL")).attributeValue("value")).intValue();
/* 176 */       this.FIGHT_WIN_AWARD = Integer.valueOf(((Element)data.get("FIGHT_WIN_AWARD")).attributeValue("value")).intValue();
/* 177 */       this.FIGHT_LOSE_AWARD = Integer.valueOf(((Element)data.get("FIGHT_LOSE_AWARD")).attributeValue("value")).intValue();
/* 178 */       this.ROBOT_NAME = String.valueOf(((Element)data.get("ROBOT_NAME")).attributeValue("value"));
/* 179 */       this.PET_ARENA_FIGHT_MAX_TIME = Integer.valueOf(((Element)data.get("PET_ARENA_FIGHT_MAX_TIME")).attributeValue("value")).intValue();
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
/* 190 */     String path = dir + "mzm.gsp.petarena.confbean.SPetArenaConst.bny";
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
/* 205 */         this.OPEN_LEVEL = _os_.unmarshal_int();
/* 206 */         this.FIGHT_WIN_ADD_POINT = _os_.unmarshal_int();
/* 207 */         this.FIGHT_LOSE_ADD_POINT = _os_.unmarshal_int();
/* 208 */         this.TOP_NUM = _os_.unmarshal_int();
/* 209 */         this.LOW_NUM = _os_.unmarshal_int();
/* 210 */         this.FREE_CHALLENGE_COUNT = _os_.unmarshal_int();
/* 211 */         this.ROBOT_NUM = _os_.unmarshal_int();
/* 212 */         this.TOP_NUM_HIDE_SCORE = _os_.unmarshal_int();
/* 213 */         this.TOP_NUM_HIDE_FORMATION = _os_.unmarshal_int();
/* 214 */         this.TOP_NUM_HIDE_PART = _os_.unmarshal_int();
/* 215 */         this.TOP_NUM_HIDE_ALL = _os_.unmarshal_int();
/* 216 */         this.AWARD_TIME_CFG_ID = _os_.unmarshal_int();
/* 217 */         this.REFRESH_CD = _os_.unmarshal_int();
/* 218 */         this.RANK_MAIL_CFG_ID = _os_.unmarshal_int();
/* 219 */         this.MAX_RANK_MAIL_CFG_ID = _os_.unmarshal_int();
/* 220 */         this.FIRST_BUY_YUANBAO_PRICE = _os_.unmarshal_int();
/* 221 */         this.YUANBAO_PRICE_ADD_NUM = _os_.unmarshal_int();
/* 222 */         this.ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 223 */         this.MAX_POINT = _os_.unmarshal_int();
/* 224 */         this.FORMATION_PARAM = _os_.unmarshal_int();
/* 225 */         this.MAX_BUY_COUNT = _os_.unmarshal_int();
/* 226 */         this.MONEY_TYPE = _os_.unmarshal_int();
/* 227 */         this.ROBOT_PET_LEVEL = _os_.unmarshal_int();
/* 228 */         this.MAX_RECORD_NUM = _os_.unmarshal_int();
/* 229 */         this.MAX_RANK_MAIL_CFG_ID_PROMOTE = _os_.unmarshal_int();
/* 230 */         this.ADD_POINT_FIGHT_MAX_NUM = _os_.unmarshal_int();
/* 231 */         this.ROBOT_LEVEL = _os_.unmarshal_int();
/* 232 */         this.FIGHT_WIN_AWARD = _os_.unmarshal_int();
/* 233 */         this.FIGHT_LOSE_AWARD = _os_.unmarshal_int();
/* 234 */         this.ROBOT_NAME = _os_.unmarshal_String("UTF-8");
/* 235 */         this.PET_ARENA_FIGHT_MAX_TIME = _os_.unmarshal_int();
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
/* 246 */     String path = dir + "mzm.gsp.petarena.confbean.SPetArenaConst.bny";
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
/* 261 */         this.OPEN_LEVEL = _os_.unmarshal_int();
/* 262 */         this.FIGHT_WIN_ADD_POINT = _os_.unmarshal_int();
/* 263 */         this.FIGHT_LOSE_ADD_POINT = _os_.unmarshal_int();
/* 264 */         this.TOP_NUM = _os_.unmarshal_int();
/* 265 */         this.LOW_NUM = _os_.unmarshal_int();
/* 266 */         this.FREE_CHALLENGE_COUNT = _os_.unmarshal_int();
/* 267 */         this.ROBOT_NUM = _os_.unmarshal_int();
/* 268 */         this.TOP_NUM_HIDE_SCORE = _os_.unmarshal_int();
/* 269 */         this.TOP_NUM_HIDE_FORMATION = _os_.unmarshal_int();
/* 270 */         this.TOP_NUM_HIDE_PART = _os_.unmarshal_int();
/* 271 */         this.TOP_NUM_HIDE_ALL = _os_.unmarshal_int();
/* 272 */         this.AWARD_TIME_CFG_ID = _os_.unmarshal_int();
/* 273 */         this.REFRESH_CD = _os_.unmarshal_int();
/* 274 */         this.RANK_MAIL_CFG_ID = _os_.unmarshal_int();
/* 275 */         this.MAX_RANK_MAIL_CFG_ID = _os_.unmarshal_int();
/* 276 */         this.FIRST_BUY_YUANBAO_PRICE = _os_.unmarshal_int();
/* 277 */         this.YUANBAO_PRICE_ADD_NUM = _os_.unmarshal_int();
/* 278 */         this.ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 279 */         this.MAX_POINT = _os_.unmarshal_int();
/* 280 */         this.FORMATION_PARAM = _os_.unmarshal_int();
/* 281 */         this.MAX_BUY_COUNT = _os_.unmarshal_int();
/* 282 */         this.MONEY_TYPE = _os_.unmarshal_int();
/* 283 */         this.ROBOT_PET_LEVEL = _os_.unmarshal_int();
/* 284 */         this.MAX_RECORD_NUM = _os_.unmarshal_int();
/* 285 */         this.MAX_RANK_MAIL_CFG_ID_PROMOTE = _os_.unmarshal_int();
/* 286 */         this.ADD_POINT_FIGHT_MAX_NUM = _os_.unmarshal_int();
/* 287 */         this.ROBOT_LEVEL = _os_.unmarshal_int();
/* 288 */         this.FIGHT_WIN_AWARD = _os_.unmarshal_int();
/* 289 */         this.FIGHT_LOSE_AWARD = _os_.unmarshal_int();
/* 290 */         this.ROBOT_NAME = _os_.unmarshal_String("UTF-8");
/* 291 */         this.PET_ARENA_FIGHT_MAX_TIME = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 296 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SPetArenaConst newInstance)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\confbean\SPetArenaConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */