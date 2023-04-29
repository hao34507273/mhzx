/*     */ package mzm.gsp.activity.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class JingjiActivityCfgConsts
/*     */ {
/*  13 */   private static volatile JingjiActivityCfgConsts oldInstance = null;
/*     */   
/*  15 */   private static JingjiActivityCfgConsts instance = new JingjiActivityCfgConsts();
/*     */   public int ACTIVITYID;
/*     */   public int COMPETITOR_NUM;
/*     */   public int OPPONENT_RANK_DELTA;
/*     */   public int COMPETITOR_REFRESH_TIME;
/*     */   
/*     */   public static JingjiActivityCfgConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static JingjiActivityCfgConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int SUCCESS_REWARDID;
/*     */   
/*     */   public int FAIL_REWARDID;
/*     */   
/*     */   public int DAY_OFFER_CHALLENGE_COUNT;
/*     */   
/*     */   public int FIRST_BUY_YUANBAO_PRICE;
/*     */   
/*     */   public int YUANBAO_PRICE_ADD_NUM;
/*     */   public int INIT_WING_POINT_NUM;
/*     */   public int MIN_WING_POINT;
/*     */   public int MIN_RANK_FOR_PRIVATE_CHAT_FLAG;
/*     */   public int MIN_VICTORY_NUM_FOR_BULLETIN;
/*     */   public int MIN_RANK_FOR_MYSTERIOUS_PLAYER;
/*     */   public int MIN_COMPETITOR_FOR_DISPLAY_MYSTERIOUS_PLAYER;
/*     */   public int MIN_COMPETITOR_FOR_DELETE_ROBOT_PLAYER;
/*     */   public int JINGJI_SEASON_PERSIST_DAY;
/*     */   public int FLOAT_TIP_ID;
/*     */   public boolean IS_USE_ROBOT;
/*     */   public int PVP_FIGHT_TYPE_ID;
/*     */   public int PROPERTY_SCALE_ID;
/*     */   public int EXP_CHANGE_RATE;
/*     */   public int WINPOINT_DELTA;
/*     */   public int DAY_AWARD_MAIL_ID;
/*     */   public int AUTO_REFRESH_OPPONENT_TIME;
/*     */   public int RANDOM_WINPOINT;
/*     */   public int SEASON_AWARD_MAIL_ID;
/*     */   public int FIGHT_DELTA;
/*     */   public int UP_FIND;
/*     */   public int DOWN_FIND;
/*     */   public int HIGHER_NUM;
/*     */   public int LOWER_NUM;
/*     */   public int TOTAL_NUM;
/*     */   public int FIND_TIMES;
/*     */   public int FIGHT_REFRESH_RATE;
/*     */   public int TOP_N_FOR_SHOW_RANK;
/*     */   public int RETURN_BACK_EXP_CHANGE_RATE;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  71 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  76 */     String path = dir + "mzm.gsp.activity.confbean.JingjiActivityCfgConsts.xml";
/*     */     try
/*     */     {
/*  79 */       SAXReader reader = new SAXReader();
/*  80 */       org.dom4j.Document doc = reader.read(new File(path));
/*  81 */       Element root = doc.getRootElement();
/*  82 */       Map<String, Element> data = new java.util.HashMap();
/*  83 */       java.util.List<?> nodeList = root.elements();
/*  84 */       int len = nodeList.size();
/*  85 */       for (int i = 0; i < len; i++)
/*     */       {
/*  87 */         Element element = (Element)nodeList.get(i);
/*  88 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  91 */           String name = element.attributeValue("name");
/*  92 */           if (data.put(name, element) != null)
/*  93 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  96 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/*  97 */       this.COMPETITOR_NUM = Integer.valueOf(((Element)data.get("COMPETITOR_NUM")).attributeValue("value")).intValue();
/*  98 */       this.OPPONENT_RANK_DELTA = Integer.valueOf(((Element)data.get("OPPONENT_RANK_DELTA")).attributeValue("value")).intValue();
/*  99 */       this.COMPETITOR_REFRESH_TIME = Integer.valueOf(((Element)data.get("COMPETITOR_REFRESH_TIME")).attributeValue("value")).intValue();
/* 100 */       this.SUCCESS_REWARDID = Integer.valueOf(((Element)data.get("SUCCESS_REWARDID")).attributeValue("value")).intValue();
/* 101 */       this.FAIL_REWARDID = Integer.valueOf(((Element)data.get("FAIL_REWARDID")).attributeValue("value")).intValue();
/* 102 */       this.DAY_OFFER_CHALLENGE_COUNT = Integer.valueOf(((Element)data.get("DAY_OFFER_CHALLENGE_COUNT")).attributeValue("value")).intValue();
/* 103 */       this.FIRST_BUY_YUANBAO_PRICE = Integer.valueOf(((Element)data.get("FIRST_BUY_YUANBAO_PRICE")).attributeValue("value")).intValue();
/* 104 */       this.YUANBAO_PRICE_ADD_NUM = Integer.valueOf(((Element)data.get("YUANBAO_PRICE_ADD_NUM")).attributeValue("value")).intValue();
/* 105 */       this.INIT_WING_POINT_NUM = Integer.valueOf(((Element)data.get("INIT_WING_POINT_NUM")).attributeValue("value")).intValue();
/* 106 */       this.MIN_WING_POINT = Integer.valueOf(((Element)data.get("MIN_WING_POINT")).attributeValue("value")).intValue();
/* 107 */       this.MIN_RANK_FOR_PRIVATE_CHAT_FLAG = Integer.valueOf(((Element)data.get("MIN_RANK_FOR_PRIVATE_CHAT_FLAG")).attributeValue("value")).intValue();
/* 108 */       this.MIN_VICTORY_NUM_FOR_BULLETIN = Integer.valueOf(((Element)data.get("MIN_VICTORY_NUM_FOR_BULLETIN")).attributeValue("value")).intValue();
/* 109 */       this.MIN_RANK_FOR_MYSTERIOUS_PLAYER = Integer.valueOf(((Element)data.get("MIN_RANK_FOR_MYSTERIOUS_PLAYER")).attributeValue("value")).intValue();
/* 110 */       this.MIN_COMPETITOR_FOR_DISPLAY_MYSTERIOUS_PLAYER = Integer.valueOf(((Element)data.get("MIN_COMPETITOR_FOR_DISPLAY_MYSTERIOUS_PLAYER")).attributeValue("value")).intValue();
/* 111 */       this.MIN_COMPETITOR_FOR_DELETE_ROBOT_PLAYER = Integer.valueOf(((Element)data.get("MIN_COMPETITOR_FOR_DELETE_ROBOT_PLAYER")).attributeValue("value")).intValue();
/* 112 */       this.JINGJI_SEASON_PERSIST_DAY = Integer.valueOf(((Element)data.get("JINGJI_SEASON_PERSIST_DAY")).attributeValue("value")).intValue();
/* 113 */       this.FLOAT_TIP_ID = Integer.valueOf(((Element)data.get("FLOAT_TIP_ID")).attributeValue("value")).intValue();
/* 114 */       this.IS_USE_ROBOT = Boolean.valueOf(((Element)data.get("IS_USE_ROBOT")).attributeValue("value")).booleanValue();
/* 115 */       this.PVP_FIGHT_TYPE_ID = Integer.valueOf(((Element)data.get("PVP_FIGHT_TYPE_ID")).attributeValue("value")).intValue();
/* 116 */       this.PROPERTY_SCALE_ID = Integer.valueOf(((Element)data.get("PROPERTY_SCALE_ID")).attributeValue("value")).intValue();
/* 117 */       this.EXP_CHANGE_RATE = Integer.valueOf(((Element)data.get("EXP_CHANGE_RATE")).attributeValue("value")).intValue();
/* 118 */       this.WINPOINT_DELTA = Integer.valueOf(((Element)data.get("WINPOINT_DELTA")).attributeValue("value")).intValue();
/* 119 */       this.DAY_AWARD_MAIL_ID = Integer.valueOf(((Element)data.get("DAY_AWARD_MAIL_ID")).attributeValue("value")).intValue();
/* 120 */       this.AUTO_REFRESH_OPPONENT_TIME = Integer.valueOf(((Element)data.get("AUTO_REFRESH_OPPONENT_TIME")).attributeValue("value")).intValue();
/* 121 */       this.RANDOM_WINPOINT = Integer.valueOf(((Element)data.get("RANDOM_WINPOINT")).attributeValue("value")).intValue();
/* 122 */       this.SEASON_AWARD_MAIL_ID = Integer.valueOf(((Element)data.get("SEASON_AWARD_MAIL_ID")).attributeValue("value")).intValue();
/* 123 */       this.FIGHT_DELTA = Integer.valueOf(((Element)data.get("FIGHT_DELTA")).attributeValue("value")).intValue();
/* 124 */       this.UP_FIND = Integer.valueOf(((Element)data.get("UP_FIND")).attributeValue("value")).intValue();
/* 125 */       this.DOWN_FIND = Integer.valueOf(((Element)data.get("DOWN_FIND")).attributeValue("value")).intValue();
/* 126 */       this.HIGHER_NUM = Integer.valueOf(((Element)data.get("HIGHER_NUM")).attributeValue("value")).intValue();
/* 127 */       this.LOWER_NUM = Integer.valueOf(((Element)data.get("LOWER_NUM")).attributeValue("value")).intValue();
/* 128 */       this.TOTAL_NUM = Integer.valueOf(((Element)data.get("TOTAL_NUM")).attributeValue("value")).intValue();
/* 129 */       this.FIND_TIMES = Integer.valueOf(((Element)data.get("FIND_TIMES")).attributeValue("value")).intValue();
/* 130 */       this.FIGHT_REFRESH_RATE = Integer.valueOf(((Element)data.get("FIGHT_REFRESH_RATE")).attributeValue("value")).intValue();
/* 131 */       this.TOP_N_FOR_SHOW_RANK = Integer.valueOf(((Element)data.get("TOP_N_FOR_SHOW_RANK")).attributeValue("value")).intValue();
/* 132 */       this.RETURN_BACK_EXP_CHANGE_RATE = Integer.valueOf(((Element)data.get("RETURN_BACK_EXP_CHANGE_RATE")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 136 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 141 */     String path = dir + "mzm.gsp.activity.confbean.JingjiActivityCfgConsts.xml";
/*     */     try
/*     */     {
/* 144 */       SAXReader reader = new SAXReader();
/* 145 */       org.dom4j.Document doc = reader.read(new File(path));
/* 146 */       Element root = doc.getRootElement();
/* 147 */       Map<String, Element> data = new java.util.HashMap();
/* 148 */       java.util.List<?> nodeList = root.elements();
/* 149 */       int len = nodeList.size();
/* 150 */       for (int i = 0; i < len; i++)
/*     */       {
/* 152 */         Element element = (Element)nodeList.get(i);
/* 153 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 156 */           String name = element.attributeValue("name");
/* 157 */           if (data.put(name, element) != null)
/* 158 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 161 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/* 162 */       this.COMPETITOR_NUM = Integer.valueOf(((Element)data.get("COMPETITOR_NUM")).attributeValue("value")).intValue();
/* 163 */       this.OPPONENT_RANK_DELTA = Integer.valueOf(((Element)data.get("OPPONENT_RANK_DELTA")).attributeValue("value")).intValue();
/* 164 */       this.COMPETITOR_REFRESH_TIME = Integer.valueOf(((Element)data.get("COMPETITOR_REFRESH_TIME")).attributeValue("value")).intValue();
/* 165 */       this.SUCCESS_REWARDID = Integer.valueOf(((Element)data.get("SUCCESS_REWARDID")).attributeValue("value")).intValue();
/* 166 */       this.FAIL_REWARDID = Integer.valueOf(((Element)data.get("FAIL_REWARDID")).attributeValue("value")).intValue();
/* 167 */       this.DAY_OFFER_CHALLENGE_COUNT = Integer.valueOf(((Element)data.get("DAY_OFFER_CHALLENGE_COUNT")).attributeValue("value")).intValue();
/* 168 */       this.FIRST_BUY_YUANBAO_PRICE = Integer.valueOf(((Element)data.get("FIRST_BUY_YUANBAO_PRICE")).attributeValue("value")).intValue();
/* 169 */       this.YUANBAO_PRICE_ADD_NUM = Integer.valueOf(((Element)data.get("YUANBAO_PRICE_ADD_NUM")).attributeValue("value")).intValue();
/* 170 */       this.INIT_WING_POINT_NUM = Integer.valueOf(((Element)data.get("INIT_WING_POINT_NUM")).attributeValue("value")).intValue();
/* 171 */       this.MIN_WING_POINT = Integer.valueOf(((Element)data.get("MIN_WING_POINT")).attributeValue("value")).intValue();
/* 172 */       this.MIN_RANK_FOR_PRIVATE_CHAT_FLAG = Integer.valueOf(((Element)data.get("MIN_RANK_FOR_PRIVATE_CHAT_FLAG")).attributeValue("value")).intValue();
/* 173 */       this.MIN_VICTORY_NUM_FOR_BULLETIN = Integer.valueOf(((Element)data.get("MIN_VICTORY_NUM_FOR_BULLETIN")).attributeValue("value")).intValue();
/* 174 */       this.MIN_RANK_FOR_MYSTERIOUS_PLAYER = Integer.valueOf(((Element)data.get("MIN_RANK_FOR_MYSTERIOUS_PLAYER")).attributeValue("value")).intValue();
/* 175 */       this.MIN_COMPETITOR_FOR_DISPLAY_MYSTERIOUS_PLAYER = Integer.valueOf(((Element)data.get("MIN_COMPETITOR_FOR_DISPLAY_MYSTERIOUS_PLAYER")).attributeValue("value")).intValue();
/* 176 */       this.MIN_COMPETITOR_FOR_DELETE_ROBOT_PLAYER = Integer.valueOf(((Element)data.get("MIN_COMPETITOR_FOR_DELETE_ROBOT_PLAYER")).attributeValue("value")).intValue();
/* 177 */       this.JINGJI_SEASON_PERSIST_DAY = Integer.valueOf(((Element)data.get("JINGJI_SEASON_PERSIST_DAY")).attributeValue("value")).intValue();
/* 178 */       this.FLOAT_TIP_ID = Integer.valueOf(((Element)data.get("FLOAT_TIP_ID")).attributeValue("value")).intValue();
/* 179 */       this.IS_USE_ROBOT = Boolean.valueOf(((Element)data.get("IS_USE_ROBOT")).attributeValue("value")).booleanValue();
/* 180 */       this.PVP_FIGHT_TYPE_ID = Integer.valueOf(((Element)data.get("PVP_FIGHT_TYPE_ID")).attributeValue("value")).intValue();
/* 181 */       this.PROPERTY_SCALE_ID = Integer.valueOf(((Element)data.get("PROPERTY_SCALE_ID")).attributeValue("value")).intValue();
/* 182 */       this.EXP_CHANGE_RATE = Integer.valueOf(((Element)data.get("EXP_CHANGE_RATE")).attributeValue("value")).intValue();
/* 183 */       this.WINPOINT_DELTA = Integer.valueOf(((Element)data.get("WINPOINT_DELTA")).attributeValue("value")).intValue();
/* 184 */       this.DAY_AWARD_MAIL_ID = Integer.valueOf(((Element)data.get("DAY_AWARD_MAIL_ID")).attributeValue("value")).intValue();
/* 185 */       this.AUTO_REFRESH_OPPONENT_TIME = Integer.valueOf(((Element)data.get("AUTO_REFRESH_OPPONENT_TIME")).attributeValue("value")).intValue();
/* 186 */       this.RANDOM_WINPOINT = Integer.valueOf(((Element)data.get("RANDOM_WINPOINT")).attributeValue("value")).intValue();
/* 187 */       this.SEASON_AWARD_MAIL_ID = Integer.valueOf(((Element)data.get("SEASON_AWARD_MAIL_ID")).attributeValue("value")).intValue();
/* 188 */       this.FIGHT_DELTA = Integer.valueOf(((Element)data.get("FIGHT_DELTA")).attributeValue("value")).intValue();
/* 189 */       this.UP_FIND = Integer.valueOf(((Element)data.get("UP_FIND")).attributeValue("value")).intValue();
/* 190 */       this.DOWN_FIND = Integer.valueOf(((Element)data.get("DOWN_FIND")).attributeValue("value")).intValue();
/* 191 */       this.HIGHER_NUM = Integer.valueOf(((Element)data.get("HIGHER_NUM")).attributeValue("value")).intValue();
/* 192 */       this.LOWER_NUM = Integer.valueOf(((Element)data.get("LOWER_NUM")).attributeValue("value")).intValue();
/* 193 */       this.TOTAL_NUM = Integer.valueOf(((Element)data.get("TOTAL_NUM")).attributeValue("value")).intValue();
/* 194 */       this.FIND_TIMES = Integer.valueOf(((Element)data.get("FIND_TIMES")).attributeValue("value")).intValue();
/* 195 */       this.FIGHT_REFRESH_RATE = Integer.valueOf(((Element)data.get("FIGHT_REFRESH_RATE")).attributeValue("value")).intValue();
/* 196 */       this.TOP_N_FOR_SHOW_RANK = Integer.valueOf(((Element)data.get("TOP_N_FOR_SHOW_RANK")).attributeValue("value")).intValue();
/* 197 */       this.RETURN_BACK_EXP_CHANGE_RATE = Integer.valueOf(((Element)data.get("RETURN_BACK_EXP_CHANGE_RATE")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 201 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 205 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 208 */     String path = dir + "mzm.gsp.activity.confbean.JingjiActivityCfgConsts.bny";
/*     */     try
/*     */     {
/* 211 */       File file = new File(path);
/* 212 */       if (file.exists())
/*     */       {
/* 214 */         byte[] bytes = new byte['Ѐ'];
/* 215 */         FileInputStream fis = new FileInputStream(file);
/* 216 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 217 */         int len = 0;
/* 218 */         while ((len = fis.read(bytes)) > 0)
/* 219 */           baos.write(bytes, 0, len);
/* 220 */         fis.close();
/* 221 */         bytes = baos.toByteArray();
/* 222 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 223 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 224 */         this.COMPETITOR_NUM = _os_.unmarshal_int();
/* 225 */         this.OPPONENT_RANK_DELTA = _os_.unmarshal_int();
/* 226 */         this.COMPETITOR_REFRESH_TIME = _os_.unmarshal_int();
/* 227 */         this.SUCCESS_REWARDID = _os_.unmarshal_int();
/* 228 */         this.FAIL_REWARDID = _os_.unmarshal_int();
/* 229 */         this.DAY_OFFER_CHALLENGE_COUNT = _os_.unmarshal_int();
/* 230 */         this.FIRST_BUY_YUANBAO_PRICE = _os_.unmarshal_int();
/* 231 */         this.YUANBAO_PRICE_ADD_NUM = _os_.unmarshal_int();
/* 232 */         this.INIT_WING_POINT_NUM = _os_.unmarshal_int();
/* 233 */         this.MIN_WING_POINT = _os_.unmarshal_int();
/* 234 */         this.MIN_RANK_FOR_PRIVATE_CHAT_FLAG = _os_.unmarshal_int();
/* 235 */         this.MIN_VICTORY_NUM_FOR_BULLETIN = _os_.unmarshal_int();
/* 236 */         this.MIN_RANK_FOR_MYSTERIOUS_PLAYER = _os_.unmarshal_int();
/* 237 */         this.MIN_COMPETITOR_FOR_DISPLAY_MYSTERIOUS_PLAYER = _os_.unmarshal_int();
/* 238 */         this.MIN_COMPETITOR_FOR_DELETE_ROBOT_PLAYER = _os_.unmarshal_int();
/* 239 */         this.JINGJI_SEASON_PERSIST_DAY = _os_.unmarshal_int();
/* 240 */         this.FLOAT_TIP_ID = _os_.unmarshal_int();
/* 241 */         this.IS_USE_ROBOT = _os_.unmarshal_boolean();
/* 242 */         this.PVP_FIGHT_TYPE_ID = _os_.unmarshal_int();
/* 243 */         this.PROPERTY_SCALE_ID = _os_.unmarshal_int();
/* 244 */         this.EXP_CHANGE_RATE = _os_.unmarshal_int();
/* 245 */         this.WINPOINT_DELTA = _os_.unmarshal_int();
/* 246 */         this.DAY_AWARD_MAIL_ID = _os_.unmarshal_int();
/* 247 */         this.AUTO_REFRESH_OPPONENT_TIME = _os_.unmarshal_int();
/* 248 */         this.RANDOM_WINPOINT = _os_.unmarshal_int();
/* 249 */         this.SEASON_AWARD_MAIL_ID = _os_.unmarshal_int();
/* 250 */         this.FIGHT_DELTA = _os_.unmarshal_int();
/* 251 */         this.UP_FIND = _os_.unmarshal_int();
/* 252 */         this.DOWN_FIND = _os_.unmarshal_int();
/* 253 */         this.HIGHER_NUM = _os_.unmarshal_int();
/* 254 */         this.LOWER_NUM = _os_.unmarshal_int();
/* 255 */         this.TOTAL_NUM = _os_.unmarshal_int();
/* 256 */         this.FIND_TIMES = _os_.unmarshal_int();
/* 257 */         this.FIGHT_REFRESH_RATE = _os_.unmarshal_int();
/* 258 */         this.TOP_N_FOR_SHOW_RANK = _os_.unmarshal_int();
/* 259 */         this.RETURN_BACK_EXP_CHANGE_RATE = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 264 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 270 */     String path = dir + "mzm.gsp.activity.confbean.JingjiActivityCfgConsts.bny";
/*     */     try
/*     */     {
/* 273 */       File file = new File(path);
/* 274 */       if (file.exists())
/*     */       {
/* 276 */         byte[] bytes = new byte['Ѐ'];
/* 277 */         FileInputStream fis = new FileInputStream(file);
/* 278 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 279 */         int len = 0;
/* 280 */         while ((len = fis.read(bytes)) > 0)
/* 281 */           baos.write(bytes, 0, len);
/* 282 */         fis.close();
/* 283 */         bytes = baos.toByteArray();
/* 284 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 285 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 286 */         this.COMPETITOR_NUM = _os_.unmarshal_int();
/* 287 */         this.OPPONENT_RANK_DELTA = _os_.unmarshal_int();
/* 288 */         this.COMPETITOR_REFRESH_TIME = _os_.unmarshal_int();
/* 289 */         this.SUCCESS_REWARDID = _os_.unmarshal_int();
/* 290 */         this.FAIL_REWARDID = _os_.unmarshal_int();
/* 291 */         this.DAY_OFFER_CHALLENGE_COUNT = _os_.unmarshal_int();
/* 292 */         this.FIRST_BUY_YUANBAO_PRICE = _os_.unmarshal_int();
/* 293 */         this.YUANBAO_PRICE_ADD_NUM = _os_.unmarshal_int();
/* 294 */         this.INIT_WING_POINT_NUM = _os_.unmarshal_int();
/* 295 */         this.MIN_WING_POINT = _os_.unmarshal_int();
/* 296 */         this.MIN_RANK_FOR_PRIVATE_CHAT_FLAG = _os_.unmarshal_int();
/* 297 */         this.MIN_VICTORY_NUM_FOR_BULLETIN = _os_.unmarshal_int();
/* 298 */         this.MIN_RANK_FOR_MYSTERIOUS_PLAYER = _os_.unmarshal_int();
/* 299 */         this.MIN_COMPETITOR_FOR_DISPLAY_MYSTERIOUS_PLAYER = _os_.unmarshal_int();
/* 300 */         this.MIN_COMPETITOR_FOR_DELETE_ROBOT_PLAYER = _os_.unmarshal_int();
/* 301 */         this.JINGJI_SEASON_PERSIST_DAY = _os_.unmarshal_int();
/* 302 */         this.FLOAT_TIP_ID = _os_.unmarshal_int();
/* 303 */         this.IS_USE_ROBOT = _os_.unmarshal_boolean();
/* 304 */         this.PVP_FIGHT_TYPE_ID = _os_.unmarshal_int();
/* 305 */         this.PROPERTY_SCALE_ID = _os_.unmarshal_int();
/* 306 */         this.EXP_CHANGE_RATE = _os_.unmarshal_int();
/* 307 */         this.WINPOINT_DELTA = _os_.unmarshal_int();
/* 308 */         this.DAY_AWARD_MAIL_ID = _os_.unmarshal_int();
/* 309 */         this.AUTO_REFRESH_OPPONENT_TIME = _os_.unmarshal_int();
/* 310 */         this.RANDOM_WINPOINT = _os_.unmarshal_int();
/* 311 */         this.SEASON_AWARD_MAIL_ID = _os_.unmarshal_int();
/* 312 */         this.FIGHT_DELTA = _os_.unmarshal_int();
/* 313 */         this.UP_FIND = _os_.unmarshal_int();
/* 314 */         this.DOWN_FIND = _os_.unmarshal_int();
/* 315 */         this.HIGHER_NUM = _os_.unmarshal_int();
/* 316 */         this.LOWER_NUM = _os_.unmarshal_int();
/* 317 */         this.TOTAL_NUM = _os_.unmarshal_int();
/* 318 */         this.FIND_TIMES = _os_.unmarshal_int();
/* 319 */         this.FIGHT_REFRESH_RATE = _os_.unmarshal_int();
/* 320 */         this.TOP_N_FOR_SHOW_RANK = _os_.unmarshal_int();
/* 321 */         this.RETURN_BACK_EXP_CHANGE_RATE = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 326 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(JingjiActivityCfgConsts newInstance)
/*     */   {
/* 332 */     oldInstance = instance;
/* 333 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 338 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\confbean\JingjiActivityCfgConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */