/*     */ package mzm.gsp.occupation.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Document;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ 
/*     */ public class RoleCommonConstants
/*     */ {
/*  18 */   private static volatile RoleCommonConstants oldInstance = null;
/*  19 */   private static RoleCommonConstants instance = new RoleCommonConstants();
/*     */   
/*     */   public int BORN_LEVEL;
/*     */   public int MAX_LEVEL;
/*     */   public int BORN_MAP_ID;
/*     */   public int BORN_MAP_POS_X;
/*     */   public int BORN_MAP_POS_Y;
/*     */   public double BORN_MOVE_SPEED;
/*     */   public int ADD_POTEN_FUNC_LEVEL;
/*     */   public int OPEN_POINT_SYS_1_LEVEL;
/*     */   public int OPEN_POINT_SYS_2_LEVEL;
/*     */   public int OPEN_POINT_SYS_3_LEVEL;
/*     */   public int ZHUAN_SHENG_OLD_LEVEL;
/*     */   public int ZHUAN_SHENG_NEW_LEVEL;
/*     */   public int ZHUAN_SHENG_AWARD_POINT;
/*     */   public int SWITCH_PROP_SYS_COST;
/*     */   public int RENAME_ITEM_TYPE_ID;
/*     */   public int RESET_POINT_ITEM_TYPE_ID;
/*     */   public int LEVEL_UP_EFFECT;
/*     */   public int LEVEL_UP_FONT_EFFECT;
/*     */   public int ACCEPT_TASK_EFFECT;
/*     */   public int FINISH_TASK_EFFECT;
/*     */   public int SERVER_LEVEL_DESC_ID;
/*     */   public int PHY_ATK_TIPS;
/*     */   public int MAG_ATK_TIPS;
/*     */   public int PHY_DEF_TIPS;
/*     */   public int MAG_DEF_TIPS;
/*     */   public int SPEED_TIPS;
/*     */   public int SEAL_RES_TIPS;
/*     */   public int PHY_CRT_TIPS;
/*     */   public int MAG_CRT_TIPS;
/*     */   public int HP_TIPS;
/*     */   public int MP_TIPS;
/*     */   public int ANGER_TIPS;
/*     */   public int EVERYDAY_GET_OFFLINE_EXP_LIMIT;
/*     */   public int EXP_STORE_LIMIT;
/*     */   public int ONE_XIULIAN_EXP_NEED_ROLE_EXP;
/*     */   public int EVERYDAY_TRAN_ROLE_EXP2XIULIANEXP_LIMIT;
/*     */   public int ROLE_LEVEL_MORE_THAN_SERVER_LEVEL;
/*     */   public double ROLE_EXP_POOL_EXCHANGE_RATE;
/*     */   public int ROLE_EXP_POOL_CAPACITY_RATE;
/*     */   public int VIGOR_WORK_ICON;
/*     */   public int ANGER_LIMIT;
/*     */   public int VIGOR_LIMIT;
/*     */   public int ADD_VIGOR_LIMIT_PERLV;
/*     */   public int MORETHAN_VIGOR_LIMIT_MAX_VAL_RATE;
/*     */   public int VIGOR_REACH_LIMIT_TIP_RATE;
/*     */   public int VIGOR_2_SILVER;
/*     */   public int VIGOR_ITEM_USE_LIMIT_PERDAY;
/*     */   public int VIGOR_WORK_COST;
/*     */   public int VIGOR_TIPS1;
/*     */   public int VIGOR_TIPS2;
/*     */   public int VIGOR_TIPS3;
/*     */   public int VIGOR_PICID;
/*     */   public int OUTFIGHT_AUTO_RECOVERY_COST_BAOSHIDU;
/*     */   public int BAOSHIDU_LIMIT;
/*     */   public int BAOTIP_LIMIT;
/*     */   public int BAOSHIDU_ICON_COLOR_COUNT;
/*     */   public int BAOSHIDU_ICON_ID;
/*     */   public int DELETE_ROLE_RECOVERY_D;
/*     */   public int DELETE_ROLE_SERVICE_RECOVERY_D;
/*     */   public int VIGOR_REFRESH_TIME;
/*     */   public int MAX_WARDROBE_COUNT;
/*     */   public int TIME_TO_NEXT_TIP;
/*     */   public int TIP_CONTENT;
/*     */   public int PRO_TIP_CONTENT;
/*     */   public int BAOSHIDU_COST;
/*     */   public int VIGOUR_ITEM_ID;
/*     */   public int CAN_NOT_DELETE_ROLE_MORE_THAN_LEVEL;
/*     */   
/*     */   public static RoleCommonConstants getOldInstance()
/*     */   {
/*  91 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static RoleCommonConstants getInstance()
/*     */   {
/*  96 */     return instance;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 101 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/* 106 */     String path = dir + "mzm.gsp.occupation.confbean.RoleCommonConstants.xml";
/*     */     try
/*     */     {
/* 109 */       SAXReader reader = new SAXReader();
/* 110 */       Document doc = reader.read(new File(path));
/* 111 */       Element root = doc.getRootElement();
/* 112 */       Map<String, Element> data = new HashMap();
/* 113 */       List<?> nodeList = root.elements();
/* 114 */       int len = nodeList.size();
/* 115 */       for (int i = 0; i < len; i++)
/*     */       {
/* 117 */         Element element = (Element)nodeList.get(i);
/* 118 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/* 120 */           String name = element.attributeValue("name");
/* 121 */           if (data.put(name, element) != null) {
/* 122 */             throw new RuntimeException("duplicate const : " + name);
/*     */           }
/*     */         }
/*     */       }
/* 126 */       this.BORN_LEVEL = Integer.valueOf(((Element)data.get("BORN_LEVEL")).attributeValue("value")).intValue();
/* 127 */       this.MAX_LEVEL = Integer.valueOf(((Element)data.get("MAX_LEVEL")).attributeValue("value")).intValue();
/* 128 */       this.BORN_MAP_ID = Integer.valueOf(((Element)data.get("BORN_MAP_ID")).attributeValue("value")).intValue();
/* 129 */       this.BORN_MAP_POS_X = Integer.valueOf(((Element)data.get("BORN_MAP_POS_X")).attributeValue("value")).intValue();
/* 130 */       this.BORN_MAP_POS_Y = Integer.valueOf(((Element)data.get("BORN_MAP_POS_Y")).attributeValue("value")).intValue();
/* 131 */       this.BORN_MOVE_SPEED = Double.valueOf(((Element)data.get("BORN_MOVE_SPEED")).attributeValue("value")).doubleValue();
/* 132 */       this.ADD_POTEN_FUNC_LEVEL = Integer.valueOf(((Element)data.get("ADD_POTEN_FUNC_LEVEL")).attributeValue("value")).intValue();
/* 133 */       this.OPEN_POINT_SYS_1_LEVEL = Integer.valueOf(((Element)data.get("OPEN_POINT_SYS_1_LEVEL")).attributeValue("value")).intValue();
/* 134 */       this.OPEN_POINT_SYS_2_LEVEL = Integer.valueOf(((Element)data.get("OPEN_POINT_SYS_2_LEVEL")).attributeValue("value")).intValue();
/* 135 */       this.OPEN_POINT_SYS_3_LEVEL = Integer.valueOf(((Element)data.get("OPEN_POINT_SYS_3_LEVEL")).attributeValue("value")).intValue();
/* 136 */       this.ZHUAN_SHENG_OLD_LEVEL = Integer.valueOf(((Element)data.get("ZHUAN_SHENG_OLD_LEVEL")).attributeValue("value")).intValue();
/* 137 */       this.ZHUAN_SHENG_NEW_LEVEL = Integer.valueOf(((Element)data.get("ZHUAN_SHENG_NEW_LEVEL")).attributeValue("value")).intValue();
/* 138 */       this.ZHUAN_SHENG_AWARD_POINT = Integer.valueOf(((Element)data.get("ZHUAN_SHENG_AWARD_POINT")).attributeValue("value")).intValue();
/* 139 */       this.SWITCH_PROP_SYS_COST = Integer.valueOf(((Element)data.get("SWITCH_PROP_SYS_COST")).attributeValue("value")).intValue();
/* 140 */       this.RENAME_ITEM_TYPE_ID = Integer.valueOf(((Element)data.get("RENAME_ITEM_TYPE_ID")).attributeValue("value")).intValue();
/* 141 */       this.RESET_POINT_ITEM_TYPE_ID = Integer.valueOf(((Element)data.get("RESET_POINT_ITEM_TYPE_ID")).attributeValue("value")).intValue();
/* 142 */       this.LEVEL_UP_EFFECT = Integer.valueOf(((Element)data.get("LEVEL_UP_EFFECT")).attributeValue("value")).intValue();
/* 143 */       this.LEVEL_UP_FONT_EFFECT = Integer.valueOf(((Element)data.get("LEVEL_UP_FONT_EFFECT")).attributeValue("value")).intValue();
/* 144 */       this.ACCEPT_TASK_EFFECT = Integer.valueOf(((Element)data.get("ACCEPT_TASK_EFFECT")).attributeValue("value")).intValue();
/* 145 */       this.FINISH_TASK_EFFECT = Integer.valueOf(((Element)data.get("FINISH_TASK_EFFECT")).attributeValue("value")).intValue();
/* 146 */       this.SERVER_LEVEL_DESC_ID = Integer.valueOf(((Element)data.get("SERVER_LEVEL_DESC_ID")).attributeValue("value")).intValue();
/* 147 */       this.PHY_ATK_TIPS = Integer.valueOf(((Element)data.get("PHY_ATK_TIPS")).attributeValue("value")).intValue();
/* 148 */       this.MAG_ATK_TIPS = Integer.valueOf(((Element)data.get("MAG_ATK_TIPS")).attributeValue("value")).intValue();
/* 149 */       this.PHY_DEF_TIPS = Integer.valueOf(((Element)data.get("PHY_DEF_TIPS")).attributeValue("value")).intValue();
/* 150 */       this.MAG_DEF_TIPS = Integer.valueOf(((Element)data.get("MAG_DEF_TIPS")).attributeValue("value")).intValue();
/* 151 */       this.SPEED_TIPS = Integer.valueOf(((Element)data.get("SPEED_TIPS")).attributeValue("value")).intValue();
/* 152 */       this.SEAL_RES_TIPS = Integer.valueOf(((Element)data.get("SEAL_RES_TIPS")).attributeValue("value")).intValue();
/* 153 */       this.PHY_CRT_TIPS = Integer.valueOf(((Element)data.get("PHY_CRT_TIPS")).attributeValue("value")).intValue();
/* 154 */       this.MAG_CRT_TIPS = Integer.valueOf(((Element)data.get("MAG_CRT_TIPS")).attributeValue("value")).intValue();
/* 155 */       this.HP_TIPS = Integer.valueOf(((Element)data.get("HP_TIPS")).attributeValue("value")).intValue();
/* 156 */       this.MP_TIPS = Integer.valueOf(((Element)data.get("MP_TIPS")).attributeValue("value")).intValue();
/* 157 */       this.ANGER_TIPS = Integer.valueOf(((Element)data.get("ANGER_TIPS")).attributeValue("value")).intValue();
/* 158 */       this.EVERYDAY_GET_OFFLINE_EXP_LIMIT = Integer.valueOf(((Element)data.get("EVERYDAY_GET_OFFLINE_EXP_LIMIT")).attributeValue("value")).intValue();
/* 159 */       this.EXP_STORE_LIMIT = Integer.valueOf(((Element)data.get("EXP_STORE_LIMIT")).attributeValue("value")).intValue();
/* 160 */       this.ONE_XIULIAN_EXP_NEED_ROLE_EXP = Integer.valueOf(((Element)data.get("ONE_XIULIAN_EXP_NEED_ROLE_EXP")).attributeValue("value")).intValue();
/* 161 */       this.EVERYDAY_TRAN_ROLE_EXP2XIULIANEXP_LIMIT = Integer.valueOf(((Element)data.get("EVERYDAY_TRAN_ROLE_EXP2XIULIANEXP_LIMIT")).attributeValue("value")).intValue();
/* 162 */       this.ROLE_LEVEL_MORE_THAN_SERVER_LEVEL = Integer.valueOf(((Element)data.get("ROLE_LEVEL_MORE_THAN_SERVER_LEVEL")).attributeValue("value")).intValue();
/* 163 */       this.ROLE_EXP_POOL_EXCHANGE_RATE = Double.valueOf(((Element)data.get("ROLE_EXP_POOL_EXCHANGE_RATE")).attributeValue("value")).doubleValue();
/* 164 */       this.ROLE_EXP_POOL_CAPACITY_RATE = Integer.valueOf(((Element)data.get("ROLE_EXP_POOL_CAPACITY_RATE")).attributeValue("value")).intValue();
/* 165 */       this.VIGOR_WORK_ICON = Integer.valueOf(((Element)data.get("VIGOR_WORK_ICON")).attributeValue("value")).intValue();
/* 166 */       this.ANGER_LIMIT = Integer.valueOf(((Element)data.get("ANGER_LIMIT")).attributeValue("value")).intValue();
/* 167 */       this.VIGOR_LIMIT = Integer.valueOf(((Element)data.get("VIGOR_LIMIT")).attributeValue("value")).intValue();
/* 168 */       this.ADD_VIGOR_LIMIT_PERLV = Integer.valueOf(((Element)data.get("ADD_VIGOR_LIMIT_PERLV")).attributeValue("value")).intValue();
/* 169 */       this.MORETHAN_VIGOR_LIMIT_MAX_VAL_RATE = Integer.valueOf(((Element)data.get("MORETHAN_VIGOR_LIMIT_MAX_VAL_RATE")).attributeValue("value")).intValue();
/* 170 */       this.VIGOR_REACH_LIMIT_TIP_RATE = Integer.valueOf(((Element)data.get("VIGOR_REACH_LIMIT_TIP_RATE")).attributeValue("value")).intValue();
/* 171 */       this.VIGOR_2_SILVER = Integer.valueOf(((Element)data.get("VIGOR_2_SILVER")).attributeValue("value")).intValue();
/* 172 */       this.VIGOR_ITEM_USE_LIMIT_PERDAY = Integer.valueOf(((Element)data.get("VIGOR_ITEM_USE_LIMIT_PERDAY")).attributeValue("value")).intValue();
/* 173 */       this.VIGOR_WORK_COST = Integer.valueOf(((Element)data.get("VIGOR_WORK_COST")).attributeValue("value")).intValue();
/* 174 */       this.VIGOR_TIPS1 = Integer.valueOf(((Element)data.get("VIGOR_TIPS1")).attributeValue("value")).intValue();
/* 175 */       this.VIGOR_TIPS2 = Integer.valueOf(((Element)data.get("VIGOR_TIPS2")).attributeValue("value")).intValue();
/* 176 */       this.VIGOR_TIPS3 = Integer.valueOf(((Element)data.get("VIGOR_TIPS3")).attributeValue("value")).intValue();
/* 177 */       this.VIGOR_PICID = Integer.valueOf(((Element)data.get("VIGOR_PICID")).attributeValue("value")).intValue();
/* 178 */       this.OUTFIGHT_AUTO_RECOVERY_COST_BAOSHIDU = Integer.valueOf(((Element)data.get("OUTFIGHT_AUTO_RECOVERY_COST_BAOSHIDU")).attributeValue("value")).intValue();
/* 179 */       this.BAOSHIDU_LIMIT = Integer.valueOf(((Element)data.get("BAOSHIDU_LIMIT")).attributeValue("value")).intValue();
/* 180 */       this.BAOTIP_LIMIT = Integer.valueOf(((Element)data.get("BAOTIP_LIMIT")).attributeValue("value")).intValue();
/* 181 */       this.BAOSHIDU_ICON_COLOR_COUNT = Integer.valueOf(((Element)data.get("BAOSHIDU_ICON_COLOR_COUNT")).attributeValue("value")).intValue();
/* 182 */       this.BAOSHIDU_ICON_ID = Integer.valueOf(((Element)data.get("BAOSHIDU_ICON_ID")).attributeValue("value")).intValue();
/* 183 */       this.DELETE_ROLE_RECOVERY_D = Integer.valueOf(((Element)data.get("DELETE_ROLE_RECOVERY_D")).attributeValue("value")).intValue();
/* 184 */       this.DELETE_ROLE_SERVICE_RECOVERY_D = Integer.valueOf(((Element)data.get("DELETE_ROLE_SERVICE_RECOVERY_D")).attributeValue("value")).intValue();
/* 185 */       this.VIGOR_REFRESH_TIME = Integer.valueOf(((Element)data.get("VIGOR_REFRESH_TIME")).attributeValue("value")).intValue();
/* 186 */       this.MAX_WARDROBE_COUNT = Integer.valueOf(((Element)data.get("MAX_WARDROBE_COUNT")).attributeValue("value")).intValue();
/* 187 */       this.TIME_TO_NEXT_TIP = Integer.valueOf(((Element)data.get("TIME_TO_NEXT_TIP")).attributeValue("value")).intValue();
/* 188 */       this.TIP_CONTENT = Integer.valueOf(((Element)data.get("TIP_CONTENT")).attributeValue("value")).intValue();
/* 189 */       this.PRO_TIP_CONTENT = Integer.valueOf(((Element)data.get("PRO_TIP_CONTENT")).attributeValue("value")).intValue();
/* 190 */       this.BAOSHIDU_COST = Integer.valueOf(((Element)data.get("BAOSHIDU_COST")).attributeValue("value")).intValue();
/* 191 */       this.VIGOUR_ITEM_ID = Integer.valueOf(((Element)data.get("VIGOUR_ITEM_ID")).attributeValue("value")).intValue();
/* 192 */       this.CAN_NOT_DELETE_ROLE_MORE_THAN_LEVEL = Integer.valueOf(((Element)data.get("CAN_NOT_DELETE_ROLE_MORE_THAN_LEVEL")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 196 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir)
/*     */   {
/* 202 */     String path = dir + "mzm.gsp.occupation.confbean.RoleCommonConstants.xml";
/*     */     try
/*     */     {
/* 205 */       SAXReader reader = new SAXReader();
/* 206 */       Document doc = reader.read(new File(path));
/* 207 */       Element root = doc.getRootElement();
/* 208 */       Map<String, Element> data = new HashMap();
/* 209 */       List<?> nodeList = root.elements();
/* 210 */       int len = nodeList.size();
/* 211 */       for (int i = 0; i < len; i++)
/*     */       {
/* 213 */         Element element = (Element)nodeList.get(i);
/* 214 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/* 216 */           String name = element.attributeValue("name");
/* 217 */           if (data.put(name, element) != null) {
/* 218 */             throw new RuntimeException("duplicate const : " + name);
/*     */           }
/*     */         }
/*     */       }
/* 222 */       this.BORN_LEVEL = Integer.valueOf(((Element)data.get("BORN_LEVEL")).attributeValue("value")).intValue();
/* 223 */       this.MAX_LEVEL = Integer.valueOf(((Element)data.get("MAX_LEVEL")).attributeValue("value")).intValue();
/* 224 */       this.BORN_MAP_ID = Integer.valueOf(((Element)data.get("BORN_MAP_ID")).attributeValue("value")).intValue();
/* 225 */       this.BORN_MAP_POS_X = Integer.valueOf(((Element)data.get("BORN_MAP_POS_X")).attributeValue("value")).intValue();
/* 226 */       this.BORN_MAP_POS_Y = Integer.valueOf(((Element)data.get("BORN_MAP_POS_Y")).attributeValue("value")).intValue();
/* 227 */       this.BORN_MOVE_SPEED = Double.valueOf(((Element)data.get("BORN_MOVE_SPEED")).attributeValue("value")).doubleValue();
/* 228 */       this.ADD_POTEN_FUNC_LEVEL = Integer.valueOf(((Element)data.get("ADD_POTEN_FUNC_LEVEL")).attributeValue("value")).intValue();
/* 229 */       this.OPEN_POINT_SYS_1_LEVEL = Integer.valueOf(((Element)data.get("OPEN_POINT_SYS_1_LEVEL")).attributeValue("value")).intValue();
/* 230 */       this.OPEN_POINT_SYS_2_LEVEL = Integer.valueOf(((Element)data.get("OPEN_POINT_SYS_2_LEVEL")).attributeValue("value")).intValue();
/* 231 */       this.OPEN_POINT_SYS_3_LEVEL = Integer.valueOf(((Element)data.get("OPEN_POINT_SYS_3_LEVEL")).attributeValue("value")).intValue();
/* 232 */       this.ZHUAN_SHENG_OLD_LEVEL = Integer.valueOf(((Element)data.get("ZHUAN_SHENG_OLD_LEVEL")).attributeValue("value")).intValue();
/* 233 */       this.ZHUAN_SHENG_NEW_LEVEL = Integer.valueOf(((Element)data.get("ZHUAN_SHENG_NEW_LEVEL")).attributeValue("value")).intValue();
/* 234 */       this.ZHUAN_SHENG_AWARD_POINT = Integer.valueOf(((Element)data.get("ZHUAN_SHENG_AWARD_POINT")).attributeValue("value")).intValue();
/* 235 */       this.SWITCH_PROP_SYS_COST = Integer.valueOf(((Element)data.get("SWITCH_PROP_SYS_COST")).attributeValue("value")).intValue();
/* 236 */       this.RENAME_ITEM_TYPE_ID = Integer.valueOf(((Element)data.get("RENAME_ITEM_TYPE_ID")).attributeValue("value")).intValue();
/* 237 */       this.RESET_POINT_ITEM_TYPE_ID = Integer.valueOf(((Element)data.get("RESET_POINT_ITEM_TYPE_ID")).attributeValue("value")).intValue();
/* 238 */       this.LEVEL_UP_EFFECT = Integer.valueOf(((Element)data.get("LEVEL_UP_EFFECT")).attributeValue("value")).intValue();
/* 239 */       this.LEVEL_UP_FONT_EFFECT = Integer.valueOf(((Element)data.get("LEVEL_UP_FONT_EFFECT")).attributeValue("value")).intValue();
/* 240 */       this.ACCEPT_TASK_EFFECT = Integer.valueOf(((Element)data.get("ACCEPT_TASK_EFFECT")).attributeValue("value")).intValue();
/* 241 */       this.FINISH_TASK_EFFECT = Integer.valueOf(((Element)data.get("FINISH_TASK_EFFECT")).attributeValue("value")).intValue();
/* 242 */       this.SERVER_LEVEL_DESC_ID = Integer.valueOf(((Element)data.get("SERVER_LEVEL_DESC_ID")).attributeValue("value")).intValue();
/* 243 */       this.PHY_ATK_TIPS = Integer.valueOf(((Element)data.get("PHY_ATK_TIPS")).attributeValue("value")).intValue();
/* 244 */       this.MAG_ATK_TIPS = Integer.valueOf(((Element)data.get("MAG_ATK_TIPS")).attributeValue("value")).intValue();
/* 245 */       this.PHY_DEF_TIPS = Integer.valueOf(((Element)data.get("PHY_DEF_TIPS")).attributeValue("value")).intValue();
/* 246 */       this.MAG_DEF_TIPS = Integer.valueOf(((Element)data.get("MAG_DEF_TIPS")).attributeValue("value")).intValue();
/* 247 */       this.SPEED_TIPS = Integer.valueOf(((Element)data.get("SPEED_TIPS")).attributeValue("value")).intValue();
/* 248 */       this.SEAL_RES_TIPS = Integer.valueOf(((Element)data.get("SEAL_RES_TIPS")).attributeValue("value")).intValue();
/* 249 */       this.PHY_CRT_TIPS = Integer.valueOf(((Element)data.get("PHY_CRT_TIPS")).attributeValue("value")).intValue();
/* 250 */       this.MAG_CRT_TIPS = Integer.valueOf(((Element)data.get("MAG_CRT_TIPS")).attributeValue("value")).intValue();
/* 251 */       this.HP_TIPS = Integer.valueOf(((Element)data.get("HP_TIPS")).attributeValue("value")).intValue();
/* 252 */       this.MP_TIPS = Integer.valueOf(((Element)data.get("MP_TIPS")).attributeValue("value")).intValue();
/* 253 */       this.ANGER_TIPS = Integer.valueOf(((Element)data.get("ANGER_TIPS")).attributeValue("value")).intValue();
/* 254 */       this.EVERYDAY_GET_OFFLINE_EXP_LIMIT = Integer.valueOf(((Element)data.get("EVERYDAY_GET_OFFLINE_EXP_LIMIT")).attributeValue("value")).intValue();
/* 255 */       this.EXP_STORE_LIMIT = Integer.valueOf(((Element)data.get("EXP_STORE_LIMIT")).attributeValue("value")).intValue();
/* 256 */       this.ONE_XIULIAN_EXP_NEED_ROLE_EXP = Integer.valueOf(((Element)data.get("ONE_XIULIAN_EXP_NEED_ROLE_EXP")).attributeValue("value")).intValue();
/* 257 */       this.EVERYDAY_TRAN_ROLE_EXP2XIULIANEXP_LIMIT = Integer.valueOf(((Element)data.get("EVERYDAY_TRAN_ROLE_EXP2XIULIANEXP_LIMIT")).attributeValue("value")).intValue();
/* 258 */       this.ROLE_LEVEL_MORE_THAN_SERVER_LEVEL = Integer.valueOf(((Element)data.get("ROLE_LEVEL_MORE_THAN_SERVER_LEVEL")).attributeValue("value")).intValue();
/* 259 */       this.ROLE_EXP_POOL_EXCHANGE_RATE = Double.valueOf(((Element)data.get("ROLE_EXP_POOL_EXCHANGE_RATE")).attributeValue("value")).doubleValue();
/* 260 */       this.ROLE_EXP_POOL_CAPACITY_RATE = Integer.valueOf(((Element)data.get("ROLE_EXP_POOL_CAPACITY_RATE")).attributeValue("value")).intValue();
/* 261 */       this.VIGOR_WORK_ICON = Integer.valueOf(((Element)data.get("VIGOR_WORK_ICON")).attributeValue("value")).intValue();
/* 262 */       this.ANGER_LIMIT = Integer.valueOf(((Element)data.get("ANGER_LIMIT")).attributeValue("value")).intValue();
/* 263 */       this.VIGOR_LIMIT = Integer.valueOf(((Element)data.get("VIGOR_LIMIT")).attributeValue("value")).intValue();
/* 264 */       this.ADD_VIGOR_LIMIT_PERLV = Integer.valueOf(((Element)data.get("ADD_VIGOR_LIMIT_PERLV")).attributeValue("value")).intValue();
/* 265 */       this.MORETHAN_VIGOR_LIMIT_MAX_VAL_RATE = Integer.valueOf(((Element)data.get("MORETHAN_VIGOR_LIMIT_MAX_VAL_RATE")).attributeValue("value")).intValue();
/* 266 */       this.VIGOR_REACH_LIMIT_TIP_RATE = Integer.valueOf(((Element)data.get("VIGOR_REACH_LIMIT_TIP_RATE")).attributeValue("value")).intValue();
/* 267 */       this.VIGOR_2_SILVER = Integer.valueOf(((Element)data.get("VIGOR_2_SILVER")).attributeValue("value")).intValue();
/* 268 */       this.VIGOR_ITEM_USE_LIMIT_PERDAY = Integer.valueOf(((Element)data.get("VIGOR_ITEM_USE_LIMIT_PERDAY")).attributeValue("value")).intValue();
/* 269 */       this.VIGOR_WORK_COST = Integer.valueOf(((Element)data.get("VIGOR_WORK_COST")).attributeValue("value")).intValue();
/* 270 */       this.VIGOR_TIPS1 = Integer.valueOf(((Element)data.get("VIGOR_TIPS1")).attributeValue("value")).intValue();
/* 271 */       this.VIGOR_TIPS2 = Integer.valueOf(((Element)data.get("VIGOR_TIPS2")).attributeValue("value")).intValue();
/* 272 */       this.VIGOR_TIPS3 = Integer.valueOf(((Element)data.get("VIGOR_TIPS3")).attributeValue("value")).intValue();
/* 273 */       this.VIGOR_PICID = Integer.valueOf(((Element)data.get("VIGOR_PICID")).attributeValue("value")).intValue();
/* 274 */       this.OUTFIGHT_AUTO_RECOVERY_COST_BAOSHIDU = Integer.valueOf(((Element)data.get("OUTFIGHT_AUTO_RECOVERY_COST_BAOSHIDU")).attributeValue("value")).intValue();
/* 275 */       this.BAOSHIDU_LIMIT = Integer.valueOf(((Element)data.get("BAOSHIDU_LIMIT")).attributeValue("value")).intValue();
/* 276 */       this.BAOTIP_LIMIT = Integer.valueOf(((Element)data.get("BAOTIP_LIMIT")).attributeValue("value")).intValue();
/* 277 */       this.BAOSHIDU_ICON_COLOR_COUNT = Integer.valueOf(((Element)data.get("BAOSHIDU_ICON_COLOR_COUNT")).attributeValue("value")).intValue();
/* 278 */       this.BAOSHIDU_ICON_ID = Integer.valueOf(((Element)data.get("BAOSHIDU_ICON_ID")).attributeValue("value")).intValue();
/* 279 */       this.DELETE_ROLE_RECOVERY_D = Integer.valueOf(((Element)data.get("DELETE_ROLE_RECOVERY_D")).attributeValue("value")).intValue();
/* 280 */       this.DELETE_ROLE_SERVICE_RECOVERY_D = Integer.valueOf(((Element)data.get("DELETE_ROLE_SERVICE_RECOVERY_D")).attributeValue("value")).intValue();
/* 281 */       this.VIGOR_REFRESH_TIME = Integer.valueOf(((Element)data.get("VIGOR_REFRESH_TIME")).attributeValue("value")).intValue();
/* 282 */       this.MAX_WARDROBE_COUNT = Integer.valueOf(((Element)data.get("MAX_WARDROBE_COUNT")).attributeValue("value")).intValue();
/* 283 */       this.TIME_TO_NEXT_TIP = Integer.valueOf(((Element)data.get("TIME_TO_NEXT_TIP")).attributeValue("value")).intValue();
/* 284 */       this.TIP_CONTENT = Integer.valueOf(((Element)data.get("TIP_CONTENT")).attributeValue("value")).intValue();
/* 285 */       this.PRO_TIP_CONTENT = Integer.valueOf(((Element)data.get("PRO_TIP_CONTENT")).attributeValue("value")).intValue();
/* 286 */       this.BAOSHIDU_COST = Integer.valueOf(((Element)data.get("BAOSHIDU_COST")).attributeValue("value")).intValue();
/* 287 */       this.VIGOUR_ITEM_ID = Integer.valueOf(((Element)data.get("VIGOUR_ITEM_ID")).attributeValue("value")).intValue();
/* 288 */       this.CAN_NOT_DELETE_ROLE_MORE_THAN_LEVEL = Integer.valueOf(((Element)data.get("CAN_NOT_DELETE_ROLE_MORE_THAN_LEVEL")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 292 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 298 */     instance._loadBny(dir);
/*     */   }
/*     */   
/*     */   public void _loadBny(String dir)
/*     */   {
/* 303 */     String path = dir + "mzm.gsp.occupation.confbean.RoleCommonConstants.bny";
/*     */     try
/*     */     {
/* 306 */       File file = new File(path);
/* 307 */       if (file.exists())
/*     */       {
/* 309 */         byte[] bytes = new byte['Ѐ'];
/* 310 */         FileInputStream fis = new FileInputStream(file);
/* 311 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 312 */         int len = 0;
/* 313 */         while ((len = fis.read(bytes)) > 0) {
/* 314 */           baos.write(bytes, 0, len);
/*     */         }
/* 316 */         fis.close();
/* 317 */         bytes = baos.toByteArray();
/* 318 */         OctetsStream _os_ = OctetsStream.wrap(Octets.wrap(bytes));
/* 319 */         this.BORN_LEVEL = _os_.unmarshal_int();
/* 320 */         this.MAX_LEVEL = _os_.unmarshal_int();
/* 321 */         this.BORN_MAP_ID = _os_.unmarshal_int();
/* 322 */         this.BORN_MAP_POS_X = _os_.unmarshal_int();
/* 323 */         this.BORN_MAP_POS_Y = _os_.unmarshal_int();
/* 324 */         this.BORN_MOVE_SPEED = _os_.unmarshal_float();
/* 325 */         this.ADD_POTEN_FUNC_LEVEL = _os_.unmarshal_int();
/* 326 */         this.OPEN_POINT_SYS_1_LEVEL = _os_.unmarshal_int();
/* 327 */         this.OPEN_POINT_SYS_2_LEVEL = _os_.unmarshal_int();
/* 328 */         this.OPEN_POINT_SYS_3_LEVEL = _os_.unmarshal_int();
/* 329 */         this.ZHUAN_SHENG_OLD_LEVEL = _os_.unmarshal_int();
/* 330 */         this.ZHUAN_SHENG_NEW_LEVEL = _os_.unmarshal_int();
/* 331 */         this.ZHUAN_SHENG_AWARD_POINT = _os_.unmarshal_int();
/* 332 */         this.SWITCH_PROP_SYS_COST = _os_.unmarshal_int();
/* 333 */         this.RENAME_ITEM_TYPE_ID = _os_.unmarshal_int();
/* 334 */         this.RESET_POINT_ITEM_TYPE_ID = _os_.unmarshal_int();
/* 335 */         this.LEVEL_UP_EFFECT = _os_.unmarshal_int();
/* 336 */         this.LEVEL_UP_FONT_EFFECT = _os_.unmarshal_int();
/* 337 */         this.ACCEPT_TASK_EFFECT = _os_.unmarshal_int();
/* 338 */         this.FINISH_TASK_EFFECT = _os_.unmarshal_int();
/* 339 */         this.SERVER_LEVEL_DESC_ID = _os_.unmarshal_int();
/* 340 */         this.PHY_ATK_TIPS = _os_.unmarshal_int();
/* 341 */         this.MAG_ATK_TIPS = _os_.unmarshal_int();
/* 342 */         this.PHY_DEF_TIPS = _os_.unmarshal_int();
/* 343 */         this.MAG_DEF_TIPS = _os_.unmarshal_int();
/* 344 */         this.SPEED_TIPS = _os_.unmarshal_int();
/* 345 */         this.SEAL_RES_TIPS = _os_.unmarshal_int();
/* 346 */         this.PHY_CRT_TIPS = _os_.unmarshal_int();
/* 347 */         this.MAG_CRT_TIPS = _os_.unmarshal_int();
/* 348 */         this.HP_TIPS = _os_.unmarshal_int();
/* 349 */         this.MP_TIPS = _os_.unmarshal_int();
/* 350 */         this.ANGER_TIPS = _os_.unmarshal_int();
/* 351 */         this.EVERYDAY_GET_OFFLINE_EXP_LIMIT = _os_.unmarshal_int();
/* 352 */         this.EXP_STORE_LIMIT = _os_.unmarshal_int();
/* 353 */         this.ONE_XIULIAN_EXP_NEED_ROLE_EXP = _os_.unmarshal_int();
/* 354 */         this.EVERYDAY_TRAN_ROLE_EXP2XIULIANEXP_LIMIT = _os_.unmarshal_int();
/* 355 */         this.ROLE_LEVEL_MORE_THAN_SERVER_LEVEL = _os_.unmarshal_int();
/* 356 */         this.ROLE_EXP_POOL_EXCHANGE_RATE = _os_.unmarshal_float();
/* 357 */         this.ROLE_EXP_POOL_CAPACITY_RATE = _os_.unmarshal_int();
/* 358 */         this.VIGOR_WORK_ICON = _os_.unmarshal_int();
/* 359 */         this.ANGER_LIMIT = _os_.unmarshal_int();
/* 360 */         this.VIGOR_LIMIT = _os_.unmarshal_int();
/* 361 */         this.ADD_VIGOR_LIMIT_PERLV = _os_.unmarshal_int();
/* 362 */         this.MORETHAN_VIGOR_LIMIT_MAX_VAL_RATE = _os_.unmarshal_int();
/* 363 */         this.VIGOR_REACH_LIMIT_TIP_RATE = _os_.unmarshal_int();
/* 364 */         this.VIGOR_2_SILVER = _os_.unmarshal_int();
/* 365 */         this.VIGOR_ITEM_USE_LIMIT_PERDAY = _os_.unmarshal_int();
/* 366 */         this.VIGOR_WORK_COST = _os_.unmarshal_int();
/* 367 */         this.VIGOR_TIPS1 = _os_.unmarshal_int();
/* 368 */         this.VIGOR_TIPS2 = _os_.unmarshal_int();
/* 369 */         this.VIGOR_TIPS3 = _os_.unmarshal_int();
/* 370 */         this.VIGOR_PICID = _os_.unmarshal_int();
/* 371 */         this.OUTFIGHT_AUTO_RECOVERY_COST_BAOSHIDU = _os_.unmarshal_int();
/* 372 */         this.BAOSHIDU_LIMIT = _os_.unmarshal_int();
/* 373 */         this.BAOTIP_LIMIT = _os_.unmarshal_int();
/* 374 */         this.BAOSHIDU_ICON_COLOR_COUNT = _os_.unmarshal_int();
/* 375 */         this.BAOSHIDU_ICON_ID = _os_.unmarshal_int();
/* 376 */         this.DELETE_ROLE_RECOVERY_D = _os_.unmarshal_int();
/* 377 */         this.DELETE_ROLE_SERVICE_RECOVERY_D = _os_.unmarshal_int();
/* 378 */         this.VIGOR_REFRESH_TIME = _os_.unmarshal_int();
/* 379 */         this.MAX_WARDROBE_COUNT = _os_.unmarshal_int();
/* 380 */         this.TIME_TO_NEXT_TIP = _os_.unmarshal_int();
/* 381 */         this.TIP_CONTENT = _os_.unmarshal_int();
/* 382 */         this.PRO_TIP_CONTENT = _os_.unmarshal_int();
/* 383 */         this.BAOSHIDU_COST = _os_.unmarshal_int();
/* 384 */         this.VIGOUR_ITEM_ID = _os_.unmarshal_int();
/* 385 */         this.CAN_NOT_DELETE_ROLE_MORE_THAN_LEVEL = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 390 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 396 */     String path = dir + "mzm.gsp.occupation.confbean.RoleCommonConstants.bny";
/*     */     try
/*     */     {
/* 399 */       File file = new File(path);
/* 400 */       if (file.exists())
/*     */       {
/* 402 */         byte[] bytes = new byte['Ѐ'];
/* 403 */         FileInputStream fis = new FileInputStream(file);
/* 404 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 405 */         int len = 0;
/* 406 */         while ((len = fis.read(bytes)) > 0) {
/* 407 */           baos.write(bytes, 0, len);
/*     */         }
/* 409 */         fis.close();
/* 410 */         bytes = baos.toByteArray();
/* 411 */         OctetsStream _os_ = OctetsStream.wrap(Octets.wrap(bytes));
/* 412 */         this.BORN_LEVEL = _os_.unmarshal_int();
/* 413 */         this.MAX_LEVEL = _os_.unmarshal_int();
/* 414 */         this.BORN_MAP_ID = _os_.unmarshal_int();
/* 415 */         this.BORN_MAP_POS_X = _os_.unmarshal_int();
/* 416 */         this.BORN_MAP_POS_Y = _os_.unmarshal_int();
/* 417 */         this.BORN_MOVE_SPEED = _os_.unmarshal_float();
/* 418 */         this.ADD_POTEN_FUNC_LEVEL = _os_.unmarshal_int();
/* 419 */         this.OPEN_POINT_SYS_1_LEVEL = _os_.unmarshal_int();
/* 420 */         this.OPEN_POINT_SYS_2_LEVEL = _os_.unmarshal_int();
/* 421 */         this.OPEN_POINT_SYS_3_LEVEL = _os_.unmarshal_int();
/* 422 */         this.ZHUAN_SHENG_OLD_LEVEL = _os_.unmarshal_int();
/* 423 */         this.ZHUAN_SHENG_NEW_LEVEL = _os_.unmarshal_int();
/* 424 */         this.ZHUAN_SHENG_AWARD_POINT = _os_.unmarshal_int();
/* 425 */         this.SWITCH_PROP_SYS_COST = _os_.unmarshal_int();
/* 426 */         this.RENAME_ITEM_TYPE_ID = _os_.unmarshal_int();
/* 427 */         this.RESET_POINT_ITEM_TYPE_ID = _os_.unmarshal_int();
/* 428 */         this.LEVEL_UP_EFFECT = _os_.unmarshal_int();
/* 429 */         this.LEVEL_UP_FONT_EFFECT = _os_.unmarshal_int();
/* 430 */         this.ACCEPT_TASK_EFFECT = _os_.unmarshal_int();
/* 431 */         this.FINISH_TASK_EFFECT = _os_.unmarshal_int();
/* 432 */         this.SERVER_LEVEL_DESC_ID = _os_.unmarshal_int();
/* 433 */         this.PHY_ATK_TIPS = _os_.unmarshal_int();
/* 434 */         this.MAG_ATK_TIPS = _os_.unmarshal_int();
/* 435 */         this.PHY_DEF_TIPS = _os_.unmarshal_int();
/* 436 */         this.MAG_DEF_TIPS = _os_.unmarshal_int();
/* 437 */         this.SPEED_TIPS = _os_.unmarshal_int();
/* 438 */         this.SEAL_RES_TIPS = _os_.unmarshal_int();
/* 439 */         this.PHY_CRT_TIPS = _os_.unmarshal_int();
/* 440 */         this.MAG_CRT_TIPS = _os_.unmarshal_int();
/* 441 */         this.HP_TIPS = _os_.unmarshal_int();
/* 442 */         this.MP_TIPS = _os_.unmarshal_int();
/* 443 */         this.ANGER_TIPS = _os_.unmarshal_int();
/* 444 */         this.EVERYDAY_GET_OFFLINE_EXP_LIMIT = _os_.unmarshal_int();
/* 445 */         this.EXP_STORE_LIMIT = _os_.unmarshal_int();
/* 446 */         this.ONE_XIULIAN_EXP_NEED_ROLE_EXP = _os_.unmarshal_int();
/* 447 */         this.EVERYDAY_TRAN_ROLE_EXP2XIULIANEXP_LIMIT = _os_.unmarshal_int();
/* 448 */         this.ROLE_LEVEL_MORE_THAN_SERVER_LEVEL = _os_.unmarshal_int();
/* 449 */         this.ROLE_EXP_POOL_EXCHANGE_RATE = _os_.unmarshal_float();
/* 450 */         this.ROLE_EXP_POOL_CAPACITY_RATE = _os_.unmarshal_int();
/* 451 */         this.VIGOR_WORK_ICON = _os_.unmarshal_int();
/* 452 */         this.ANGER_LIMIT = _os_.unmarshal_int();
/* 453 */         this.VIGOR_LIMIT = _os_.unmarshal_int();
/* 454 */         this.ADD_VIGOR_LIMIT_PERLV = _os_.unmarshal_int();
/* 455 */         this.MORETHAN_VIGOR_LIMIT_MAX_VAL_RATE = _os_.unmarshal_int();
/* 456 */         this.VIGOR_REACH_LIMIT_TIP_RATE = _os_.unmarshal_int();
/* 457 */         this.VIGOR_2_SILVER = _os_.unmarshal_int();
/* 458 */         this.VIGOR_ITEM_USE_LIMIT_PERDAY = _os_.unmarshal_int();
/* 459 */         this.VIGOR_WORK_COST = _os_.unmarshal_int();
/* 460 */         this.VIGOR_TIPS1 = _os_.unmarshal_int();
/* 461 */         this.VIGOR_TIPS2 = _os_.unmarshal_int();
/* 462 */         this.VIGOR_TIPS3 = _os_.unmarshal_int();
/* 463 */         this.VIGOR_PICID = _os_.unmarshal_int();
/* 464 */         this.OUTFIGHT_AUTO_RECOVERY_COST_BAOSHIDU = _os_.unmarshal_int();
/* 465 */         this.BAOSHIDU_LIMIT = _os_.unmarshal_int();
/* 466 */         this.BAOTIP_LIMIT = _os_.unmarshal_int();
/* 467 */         this.BAOSHIDU_ICON_COLOR_COUNT = _os_.unmarshal_int();
/* 468 */         this.BAOSHIDU_ICON_ID = _os_.unmarshal_int();
/* 469 */         this.DELETE_ROLE_RECOVERY_D = _os_.unmarshal_int();
/* 470 */         this.DELETE_ROLE_SERVICE_RECOVERY_D = _os_.unmarshal_int();
/* 471 */         this.VIGOR_REFRESH_TIME = _os_.unmarshal_int();
/* 472 */         this.MAX_WARDROBE_COUNT = _os_.unmarshal_int();
/* 473 */         this.TIME_TO_NEXT_TIP = _os_.unmarshal_int();
/* 474 */         this.TIP_CONTENT = _os_.unmarshal_int();
/* 475 */         this.PRO_TIP_CONTENT = _os_.unmarshal_int();
/* 476 */         this.BAOSHIDU_COST = _os_.unmarshal_int();
/* 477 */         this.VIGOUR_ITEM_ID = _os_.unmarshal_int();
/* 478 */         this.CAN_NOT_DELETE_ROLE_MORE_THAN_LEVEL = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 483 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(RoleCommonConstants newInstance)
/*     */   {
/* 489 */     oldInstance = instance;
/* 490 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 495 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\occupation\confbean\RoleCommonConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */