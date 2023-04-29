/*     */ package mzm.gsp.gang.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SGangConst
/*     */ {
/*  13 */   private static volatile SGangConst oldInstance = null;
/*     */   
/*  15 */   private static SGangConst instance = new SGangConst();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SGangConst getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SGangConst getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int OPEN_LEVEL = 10;
/*  32 */   public int CREATE_SERVER_LEVEL = 30;
/*  33 */   public int CREATE_NEED_ROLE_LEVEL = 30;
/*  34 */   public int CREATE_NEED_YUANBAO = 1000;
/*  35 */   public int GANG_NAME_MAX_LENGTH = 6;
/*  36 */   public int GANG_PURPOSE_MAX_LENGTH = 100;
/*  37 */   public int JOIN_MIN_LEVEL = 10;
/*  38 */   public int APPLY_NUM_LIMIT = 1;
/*  39 */   public int RESPONSE_JOIN_LIMIT_TIME_M = 24;
/*  40 */   public int GANG_APPLY_LIST_PERSIST_TIME_H = 24;
/*  41 */   public int GANG_APPLY_LIST_NUM_LIMIT = 50;
/*  42 */   public int KICK_XUETU_OFFLINE_DAYS = 2;
/*  43 */   public int KICK_NORMAL_OFFLINE_DAYS = 7;
/*  44 */   public int KICK_XUETU_BANGGONG_MIN = 100;
/*  45 */   public int KICK_NORMAL_BANGGONG_MIN = 100;
/*  46 */   public int XUETU_MAX_LV = 50;
/*  47 */   public int SETTING_XUETU_MAX_OFFSET_LV = 0;
/*  48 */   public int SETTING_XUETU_MIN_OFFSET_LV = 20;
/*  49 */   public int TANHE_OFFLINE_D = 7;
/*  50 */   public int TANHE_WAIT_TIME_D = 7;
/*  51 */   public int MODIFY_NAME_NEED_YUANBAO = 100;
/*  52 */   public int MODIFY_NAME_MIN_GANG_LV = 2;
/*  53 */   public int MODIFY_NAME_COOLDOWN_H = 24;
/*  54 */   public int KICK_NO_COST_OFFLINE_TIME_D = 7;
/*  55 */   public int KICK_NO_COST_JOIN_TIME_D = 7;
/*  56 */   public int KICK_NO_COST_BANGGONG_LIMIT = 100;
/*  57 */   public int ORGINAL_MONEY = 0;
/*  58 */   public int ADD_LIVELY_NEED_LOGIN = 5000;
/*  59 */   public int ADD_LIVELY_BY_LOGIN = 10;
/*  60 */   public int ADD_LIVELY_NEED_INDIVIDUAL_VIGOR = 100;
/*  61 */   public int ADD_LIVELY_BY__INDIVIDUAL_VIGOR = 10;
/*  62 */   public int GANG_LIVELY_MAX_LIMIT = 100;
/*  63 */   public int GANG_LIVELY_WARN_LIMIT = 50;
/*  64 */   public int GANG_WARN_TIME_H = 24;
/*  65 */   public int GANG_REMOVE_WARN_NEED_LIVELY = 10;
/*  66 */   public int GANG_BUILD_SYNC_INTERVAL_M = 10;
/*  67 */   public int NEW_GANG_PROTECT_TIME_D = 15;
/*  68 */   public int FORBIDDEN_TALK_TIME_H = 1;
/*  69 */   public int FORBIDDEN_TALK_COUNT_PER_DAY = 0;
/*  70 */   public int FORBIDDEN_TALK_COST_VIGOR = 5;
/*  71 */   public int ANNOUNCEMENT_NUM_LIMIT = 30;
/*  72 */   public int ANNOUNCEMENT_MAX_LENGTH = 35;
/*  73 */   public int PUBLISH_ANNOUNCEMENT_COST_VIGOR = 10;
/*  74 */   public int JOIN_GANG_BANGGONG_CALC_RATE = 5000;
/*  75 */   public int DONATE_LV_1 = 100000;
/*  76 */   public int LV_1_REWARD_BANGGONG = 100000;
/*  77 */   public int LV_1_CUT_TIME = 10;
/*  78 */   public int DONATE_LV_2 = 200000;
/*  79 */   public int LV_2_REWARD_BANGGONG = 100000;
/*  80 */   public int LV_2_CUT_TIME = 10;
/*  81 */   public int DONATE_LV_3 = 300000;
/*  82 */   public int LV_3_REWARD_BANGGONG = 100000;
/*  83 */   public int LV_3_CUT_TIME = 10;
/*  84 */   public int DONATE_LV_4 = 400000;
/*  85 */   public int LV_4_REWARD_BANGGONG = 100000;
/*  86 */   public int LV_4_CUT_TIME = 10;
/*  87 */   public int JOIN_MAIL_ID = 0;
/*  88 */   public int KICK_OUT_MAIL_ID = 0;
/*  89 */   public int NORMAL_FULL_HAVE_XUETU_MAIL_ID = 0;
/*  90 */   public int CHANG_BANGZHU_MAIL_ID = 0;
/*  91 */   public int CHANG_BANGZHU_OLD_BANGZHU_MAIL_ID = 0;
/*  92 */   public int TANHE_OLD_BANGZHU_MAIL_ID = 0;
/*  93 */   public int AUTO_BE_BANGZHU_MAIL_ID = 0;
/*  94 */   public int LOW_LIVELY_MAIL_ID = 0;
/*  95 */   public int CAN_NOT_MAINTAIN_MAIL_ID = 0;
/*  96 */   public int NO_MORE_MONEY_WARN_MAIL_ID = 0;
/*  97 */   public int NEED_MORE_LIVELY_WARN_MAIL_ID = 0;
/*  98 */   public int GANG_MERGE_MAIL_ID = 0;
/*  99 */   public int CHANGE_DUTY_MAIL_ID = 0;
/* 100 */   public int GANG_LEVEL_DOWN_MAIL_ID = 0;
/* 101 */   public int GANG_DISSOLVE_MAIL_ID = 0;
/* 102 */   public int DEFAULT_DUTY_NAME_ID = 410300000;
/* 103 */   public int ANNOUMCEMENT_LIMIT_PER_DAY = 10;
/* 104 */   public int GANG_MAP = 330000048;
/* 105 */   public int BE_LEADER_JOIN_LEAST_DAY = 3;
/* 106 */   public int GANG_MAX_LEVEL = 5;
/* 107 */   public int GANG_SCHEDULE_TIME_ID = 0;
/* 108 */   public int ADD_LIVELY_NEED_JUANZHONG = 10;
/* 109 */   public int ADD_LIVELY_NUM_BY_JUANZHONG = 1;
/* 110 */   public int SILVER2BANGGONG_RATE = 5000;
/* 111 */   public int SILVER2BANGGONG_LV1 = 100000;
/* 112 */   public int SILVER2BANGGONG_LV2 = 200000;
/* 113 */   public int SILVER2BANGGONG_LV3 = 400000;
/* 114 */   public int SILVER2BANGGONG_LV4 = 800000;
/* 115 */   public int SILVER2BANGGONG_LIMIT = 500;
/*     */   public int yuanbao_2_bang_gong_limit;
/* 117 */   public int SILVER2BANGGONG_CLEAR_TIMEID = 350201000;
/* 118 */   public int GANG_YAODIAN_REFRESH_INTERVAL_M = 60;
/* 119 */   public int GANG_FULI_REFRESH_TIME_ID = 350200000;
/* 120 */   public int GET_FENGLU_NEED_BANGGONG = 50;
/* 121 */   public int FENGLU_REWARD_ID = 0;
/* 122 */   public int GET_FENGLU_MIN_DAYS = 3;
/* 123 */   public int REDEEM_BANGGONG_NEED_JOIN_DAY = 72;
/* 124 */   public int CAN_GET_LIHE_NEED_JOIN_DAY = 3;
/* 125 */   public int LIHE_MAIL_ID = 340001015;
/* 126 */   public String SEVER_GANG_SIGN_STR = "甯淳绛惧埌鎻忚堪甯淳绛惧埌鎻忚堪";
/* 127 */   public int SIGN_REWARD_ITEM_ID = 1;
/* 128 */   public int NEW_GANG_SIGN_DAYNUM = 1;
/* 129 */   public int GANG_CHENGWEI_ID = 490199000;
/* 130 */   public int ONEKEY_TYPE1_NUM = 5;
/* 131 */   public int ONEKEY_TYPE2_NUM = 10;
/* 132 */   public int ONEKEY_TYPE3_NUM = 10;
/* 133 */   public int ONEKEY_TYPE4_NUM = 5;
/* 134 */   public int GANG_ONLINE_NUM_TYPE1 = 15;
/* 135 */   public int GANG_ONLINE_NUM_TYPE2 = 30;
/*     */   public int PAY_TIME;
/*     */   public int PAY_MAIL;
/*     */   public int COMBINE_VITALITY;
/*     */   public int COMBINE_CLEAN_OFFLINE_DAYS;
/*     */   public int COMBINE_APPLY_HOURS;
/*     */   public int ACTIVE_MEMBER_NEED_ACTIVE_POINT;
/*     */   public int CAN_COMBINE_MAIL;
/*     */   public int COMBINE_REFUSED_MAIL;
/*     */   public int COMBINE_SUCCEED_MAIL;
/*     */   public int COMBINE_CANCEL_MAIL;
/*     */   public int COMBINE_FAIL_MAIL;
/*     */   public int COMBINE_AGREED_MAIL;
/*     */   public int COMBINE_KICK_MAIL;
/*     */   public int COMBINE_FAIL_BY_DISSOLVE_MAIL;
/*     */   public int applyNewWeight;
/* 151 */   public java.util.ArrayList<ApplyOldOnlineWeight> applyOldWeights = new java.util.ArrayList();
/*     */   public int applyRandomRefreshSeconds;
/* 153 */   public int BANGZHU_ID = 410200000;
/* 154 */   public int FUBANGZHU_ID = 410200001;
/* 155 */   public int ZHANGLAO_ID = 410200002;
/* 156 */   public int TANGZHU_ID = 410200003;
/* 157 */   public int XIANGZHU_ID = 410200004;
/* 158 */   public int JINGYING_ID = 410200005;
/* 159 */   public int BANGZHONG_ID = 410200006;
/* 160 */   public int XUETU_ID = 410200007;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 164 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/* 169 */     String path = dir + "mzm.gsp.gang.confbean.SGangConst.xml";
/*     */     try
/*     */     {
/* 172 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 173 */       org.dom4j.Document doc = reader.read(new File(path));
/* 174 */       Element root = doc.getRootElement();
/* 175 */       Map<String, Element> data = new java.util.HashMap();
/* 176 */       List<?> nodeList = root.elements();
/* 177 */       int len = nodeList.size();
/* 178 */       for (int i = 0; i < len; i++)
/*     */       {
/* 180 */         Element element = (Element)nodeList.get(i);
/* 181 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 184 */           String name = element.attributeValue("name");
/* 185 */           if (data.put(name, element) != null)
/* 186 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 189 */       this.OPEN_LEVEL = Integer.valueOf(((Element)data.get("OPEN_LEVEL")).attributeValue("value")).intValue();
/* 190 */       this.CREATE_SERVER_LEVEL = Integer.valueOf(((Element)data.get("CREATE_SERVER_LEVEL")).attributeValue("value")).intValue();
/* 191 */       this.CREATE_NEED_ROLE_LEVEL = Integer.valueOf(((Element)data.get("CREATE_NEED_ROLE_LEVEL")).attributeValue("value")).intValue();
/* 192 */       this.CREATE_NEED_YUANBAO = Integer.valueOf(((Element)data.get("CREATE_NEED_YUANBAO")).attributeValue("value")).intValue();
/* 193 */       this.GANG_NAME_MAX_LENGTH = Integer.valueOf(((Element)data.get("GANG_NAME_MAX_LENGTH")).attributeValue("value")).intValue();
/* 194 */       this.GANG_PURPOSE_MAX_LENGTH = Integer.valueOf(((Element)data.get("GANG_PURPOSE_MAX_LENGTH")).attributeValue("value")).intValue();
/* 195 */       this.JOIN_MIN_LEVEL = Integer.valueOf(((Element)data.get("JOIN_MIN_LEVEL")).attributeValue("value")).intValue();
/* 196 */       this.APPLY_NUM_LIMIT = Integer.valueOf(((Element)data.get("APPLY_NUM_LIMIT")).attributeValue("value")).intValue();
/* 197 */       this.RESPONSE_JOIN_LIMIT_TIME_M = Integer.valueOf(((Element)data.get("RESPONSE_JOIN_LIMIT_TIME_M")).attributeValue("value")).intValue();
/* 198 */       this.GANG_APPLY_LIST_PERSIST_TIME_H = Integer.valueOf(((Element)data.get("GANG_APPLY_LIST_PERSIST_TIME_H")).attributeValue("value")).intValue();
/* 199 */       this.GANG_APPLY_LIST_NUM_LIMIT = Integer.valueOf(((Element)data.get("GANG_APPLY_LIST_NUM_LIMIT")).attributeValue("value")).intValue();
/* 200 */       this.KICK_XUETU_OFFLINE_DAYS = Integer.valueOf(((Element)data.get("KICK_XUETU_OFFLINE_DAYS")).attributeValue("value")).intValue();
/* 201 */       this.KICK_NORMAL_OFFLINE_DAYS = Integer.valueOf(((Element)data.get("KICK_NORMAL_OFFLINE_DAYS")).attributeValue("value")).intValue();
/* 202 */       this.KICK_XUETU_BANGGONG_MIN = Integer.valueOf(((Element)data.get("KICK_XUETU_BANGGONG_MIN")).attributeValue("value")).intValue();
/* 203 */       this.KICK_NORMAL_BANGGONG_MIN = Integer.valueOf(((Element)data.get("KICK_NORMAL_BANGGONG_MIN")).attributeValue("value")).intValue();
/* 204 */       this.XUETU_MAX_LV = Integer.valueOf(((Element)data.get("XUETU_MAX_LV")).attributeValue("value")).intValue();
/* 205 */       this.SETTING_XUETU_MAX_OFFSET_LV = Integer.valueOf(((Element)data.get("SETTING_XUETU_MAX_OFFSET_LV")).attributeValue("value")).intValue();
/* 206 */       this.SETTING_XUETU_MIN_OFFSET_LV = Integer.valueOf(((Element)data.get("SETTING_XUETU_MIN_OFFSET_LV")).attributeValue("value")).intValue();
/* 207 */       this.TANHE_OFFLINE_D = Integer.valueOf(((Element)data.get("TANHE_OFFLINE_D")).attributeValue("value")).intValue();
/* 208 */       this.TANHE_WAIT_TIME_D = Integer.valueOf(((Element)data.get("TANHE_WAIT_TIME_D")).attributeValue("value")).intValue();
/* 209 */       this.MODIFY_NAME_NEED_YUANBAO = Integer.valueOf(((Element)data.get("MODIFY_NAME_NEED_YUANBAO")).attributeValue("value")).intValue();
/* 210 */       this.MODIFY_NAME_MIN_GANG_LV = Integer.valueOf(((Element)data.get("MODIFY_NAME_MIN_GANG_LV")).attributeValue("value")).intValue();
/* 211 */       this.MODIFY_NAME_COOLDOWN_H = Integer.valueOf(((Element)data.get("MODIFY_NAME_COOLDOWN_H")).attributeValue("value")).intValue();
/* 212 */       this.KICK_NO_COST_OFFLINE_TIME_D = Integer.valueOf(((Element)data.get("KICK_NO_COST_OFFLINE_TIME_D")).attributeValue("value")).intValue();
/* 213 */       this.KICK_NO_COST_JOIN_TIME_D = Integer.valueOf(((Element)data.get("KICK_NO_COST_JOIN_TIME_D")).attributeValue("value")).intValue();
/* 214 */       this.KICK_NO_COST_BANGGONG_LIMIT = Integer.valueOf(((Element)data.get("KICK_NO_COST_BANGGONG_LIMIT")).attributeValue("value")).intValue();
/* 215 */       this.ORGINAL_MONEY = Integer.valueOf(((Element)data.get("ORGINAL_MONEY")).attributeValue("value")).intValue();
/* 216 */       this.ADD_LIVELY_NEED_LOGIN = Integer.valueOf(((Element)data.get("ADD_LIVELY_NEED_LOGIN")).attributeValue("value")).intValue();
/* 217 */       this.ADD_LIVELY_BY_LOGIN = Integer.valueOf(((Element)data.get("ADD_LIVELY_BY_LOGIN")).attributeValue("value")).intValue();
/* 218 */       this.ADD_LIVELY_NEED_INDIVIDUAL_VIGOR = Integer.valueOf(((Element)data.get("ADD_LIVELY_NEED_INDIVIDUAL_VIGOR")).attributeValue("value")).intValue();
/* 219 */       this.ADD_LIVELY_BY__INDIVIDUAL_VIGOR = Integer.valueOf(((Element)data.get("ADD_LIVELY_BY__INDIVIDUAL_VIGOR")).attributeValue("value")).intValue();
/* 220 */       this.GANG_LIVELY_MAX_LIMIT = Integer.valueOf(((Element)data.get("GANG_LIVELY_MAX_LIMIT")).attributeValue("value")).intValue();
/* 221 */       this.GANG_LIVELY_WARN_LIMIT = Integer.valueOf(((Element)data.get("GANG_LIVELY_WARN_LIMIT")).attributeValue("value")).intValue();
/* 222 */       this.GANG_WARN_TIME_H = Integer.valueOf(((Element)data.get("GANG_WARN_TIME_H")).attributeValue("value")).intValue();
/* 223 */       this.GANG_REMOVE_WARN_NEED_LIVELY = Integer.valueOf(((Element)data.get("GANG_REMOVE_WARN_NEED_LIVELY")).attributeValue("value")).intValue();
/* 224 */       this.GANG_BUILD_SYNC_INTERVAL_M = Integer.valueOf(((Element)data.get("GANG_BUILD_SYNC_INTERVAL_M")).attributeValue("value")).intValue();
/* 225 */       this.NEW_GANG_PROTECT_TIME_D = Integer.valueOf(((Element)data.get("NEW_GANG_PROTECT_TIME_D")).attributeValue("value")).intValue();
/* 226 */       this.FORBIDDEN_TALK_TIME_H = Integer.valueOf(((Element)data.get("FORBIDDEN_TALK_TIME_H")).attributeValue("value")).intValue();
/* 227 */       this.FORBIDDEN_TALK_COUNT_PER_DAY = Integer.valueOf(((Element)data.get("FORBIDDEN_TALK_COUNT_PER_DAY")).attributeValue("value")).intValue();
/* 228 */       this.FORBIDDEN_TALK_COST_VIGOR = Integer.valueOf(((Element)data.get("FORBIDDEN_TALK_COST_VIGOR")).attributeValue("value")).intValue();
/* 229 */       this.ANNOUNCEMENT_NUM_LIMIT = Integer.valueOf(((Element)data.get("ANNOUNCEMENT_NUM_LIMIT")).attributeValue("value")).intValue();
/* 230 */       this.ANNOUNCEMENT_MAX_LENGTH = Integer.valueOf(((Element)data.get("ANNOUNCEMENT_MAX_LENGTH")).attributeValue("value")).intValue();
/* 231 */       this.PUBLISH_ANNOUNCEMENT_COST_VIGOR = Integer.valueOf(((Element)data.get("PUBLISH_ANNOUNCEMENT_COST_VIGOR")).attributeValue("value")).intValue();
/* 232 */       this.JOIN_GANG_BANGGONG_CALC_RATE = Integer.valueOf(((Element)data.get("JOIN_GANG_BANGGONG_CALC_RATE")).attributeValue("value")).intValue();
/* 233 */       this.DONATE_LV_1 = Integer.valueOf(((Element)data.get("DONATE_LV_1")).attributeValue("value")).intValue();
/* 234 */       this.LV_1_REWARD_BANGGONG = Integer.valueOf(((Element)data.get("LV_1_REWARD_BANGGONG")).attributeValue("value")).intValue();
/* 235 */       this.LV_1_CUT_TIME = Integer.valueOf(((Element)data.get("LV_1_CUT_TIME")).attributeValue("value")).intValue();
/* 236 */       this.DONATE_LV_2 = Integer.valueOf(((Element)data.get("DONATE_LV_2")).attributeValue("value")).intValue();
/* 237 */       this.LV_2_REWARD_BANGGONG = Integer.valueOf(((Element)data.get("LV_2_REWARD_BANGGONG")).attributeValue("value")).intValue();
/* 238 */       this.LV_2_CUT_TIME = Integer.valueOf(((Element)data.get("LV_2_CUT_TIME")).attributeValue("value")).intValue();
/* 239 */       this.DONATE_LV_3 = Integer.valueOf(((Element)data.get("DONATE_LV_3")).attributeValue("value")).intValue();
/* 240 */       this.LV_3_REWARD_BANGGONG = Integer.valueOf(((Element)data.get("LV_3_REWARD_BANGGONG")).attributeValue("value")).intValue();
/* 241 */       this.LV_3_CUT_TIME = Integer.valueOf(((Element)data.get("LV_3_CUT_TIME")).attributeValue("value")).intValue();
/* 242 */       this.DONATE_LV_4 = Integer.valueOf(((Element)data.get("DONATE_LV_4")).attributeValue("value")).intValue();
/* 243 */       this.LV_4_REWARD_BANGGONG = Integer.valueOf(((Element)data.get("LV_4_REWARD_BANGGONG")).attributeValue("value")).intValue();
/* 244 */       this.LV_4_CUT_TIME = Integer.valueOf(((Element)data.get("LV_4_CUT_TIME")).attributeValue("value")).intValue();
/* 245 */       this.JOIN_MAIL_ID = Integer.valueOf(((Element)data.get("JOIN_MAIL_ID")).attributeValue("value")).intValue();
/* 246 */       this.KICK_OUT_MAIL_ID = Integer.valueOf(((Element)data.get("KICK_OUT_MAIL_ID")).attributeValue("value")).intValue();
/* 247 */       this.NORMAL_FULL_HAVE_XUETU_MAIL_ID = Integer.valueOf(((Element)data.get("NORMAL_FULL_HAVE_XUETU_MAIL_ID")).attributeValue("value")).intValue();
/* 248 */       this.CHANG_BANGZHU_MAIL_ID = Integer.valueOf(((Element)data.get("CHANG_BANGZHU_MAIL_ID")).attributeValue("value")).intValue();
/* 249 */       this.CHANG_BANGZHU_OLD_BANGZHU_MAIL_ID = Integer.valueOf(((Element)data.get("CHANG_BANGZHU_OLD_BANGZHU_MAIL_ID")).attributeValue("value")).intValue();
/* 250 */       this.TANHE_OLD_BANGZHU_MAIL_ID = Integer.valueOf(((Element)data.get("TANHE_OLD_BANGZHU_MAIL_ID")).attributeValue("value")).intValue();
/* 251 */       this.AUTO_BE_BANGZHU_MAIL_ID = Integer.valueOf(((Element)data.get("AUTO_BE_BANGZHU_MAIL_ID")).attributeValue("value")).intValue();
/* 252 */       this.LOW_LIVELY_MAIL_ID = Integer.valueOf(((Element)data.get("LOW_LIVELY_MAIL_ID")).attributeValue("value")).intValue();
/* 253 */       this.CAN_NOT_MAINTAIN_MAIL_ID = Integer.valueOf(((Element)data.get("CAN_NOT_MAINTAIN_MAIL_ID")).attributeValue("value")).intValue();
/* 254 */       this.NO_MORE_MONEY_WARN_MAIL_ID = Integer.valueOf(((Element)data.get("NO_MORE_MONEY_WARN_MAIL_ID")).attributeValue("value")).intValue();
/* 255 */       this.NEED_MORE_LIVELY_WARN_MAIL_ID = Integer.valueOf(((Element)data.get("NEED_MORE_LIVELY_WARN_MAIL_ID")).attributeValue("value")).intValue();
/* 256 */       this.GANG_MERGE_MAIL_ID = Integer.valueOf(((Element)data.get("GANG_MERGE_MAIL_ID")).attributeValue("value")).intValue();
/* 257 */       this.CHANGE_DUTY_MAIL_ID = Integer.valueOf(((Element)data.get("CHANGE_DUTY_MAIL_ID")).attributeValue("value")).intValue();
/* 258 */       this.GANG_LEVEL_DOWN_MAIL_ID = Integer.valueOf(((Element)data.get("GANG_LEVEL_DOWN_MAIL_ID")).attributeValue("value")).intValue();
/* 259 */       this.GANG_DISSOLVE_MAIL_ID = Integer.valueOf(((Element)data.get("GANG_DISSOLVE_MAIL_ID")).attributeValue("value")).intValue();
/* 260 */       this.DEFAULT_DUTY_NAME_ID = Integer.valueOf(((Element)data.get("DEFAULT_DUTY_NAME_ID")).attributeValue("value")).intValue();
/* 261 */       this.ANNOUMCEMENT_LIMIT_PER_DAY = Integer.valueOf(((Element)data.get("ANNOUMCEMENT_LIMIT_PER_DAY")).attributeValue("value")).intValue();
/* 262 */       this.GANG_MAP = Integer.valueOf(((Element)data.get("GANG_MAP")).attributeValue("value")).intValue();
/* 263 */       this.BE_LEADER_JOIN_LEAST_DAY = Integer.valueOf(((Element)data.get("BE_LEADER_JOIN_LEAST_DAY")).attributeValue("value")).intValue();
/* 264 */       this.GANG_MAX_LEVEL = Integer.valueOf(((Element)data.get("GANG_MAX_LEVEL")).attributeValue("value")).intValue();
/* 265 */       this.GANG_SCHEDULE_TIME_ID = Integer.valueOf(((Element)data.get("GANG_SCHEDULE_TIME_ID")).attributeValue("value")).intValue();
/* 266 */       this.ADD_LIVELY_NEED_JUANZHONG = Integer.valueOf(((Element)data.get("ADD_LIVELY_NEED_JUANZHONG")).attributeValue("value")).intValue();
/* 267 */       this.ADD_LIVELY_NUM_BY_JUANZHONG = Integer.valueOf(((Element)data.get("ADD_LIVELY_NUM_BY_JUANZHONG")).attributeValue("value")).intValue();
/* 268 */       this.SILVER2BANGGONG_RATE = Integer.valueOf(((Element)data.get("SILVER2BANGGONG_RATE")).attributeValue("value")).intValue();
/* 269 */       this.SILVER2BANGGONG_LV1 = Integer.valueOf(((Element)data.get("SILVER2BANGGONG_LV1")).attributeValue("value")).intValue();
/* 270 */       this.SILVER2BANGGONG_LV2 = Integer.valueOf(((Element)data.get("SILVER2BANGGONG_LV2")).attributeValue("value")).intValue();
/* 271 */       this.SILVER2BANGGONG_LV3 = Integer.valueOf(((Element)data.get("SILVER2BANGGONG_LV3")).attributeValue("value")).intValue();
/* 272 */       this.SILVER2BANGGONG_LV4 = Integer.valueOf(((Element)data.get("SILVER2BANGGONG_LV4")).attributeValue("value")).intValue();
/* 273 */       this.SILVER2BANGGONG_LIMIT = Integer.valueOf(((Element)data.get("SILVER2BANGGONG_LIMIT")).attributeValue("value")).intValue();
/* 274 */       this.yuanbao_2_bang_gong_limit = Integer.valueOf(((Element)data.get("yuanbao_2_bang_gong_limit")).attributeValue("value")).intValue();
/* 275 */       this.SILVER2BANGGONG_CLEAR_TIMEID = Integer.valueOf(((Element)data.get("SILVER2BANGGONG_CLEAR_TIMEID")).attributeValue("value")).intValue();
/* 276 */       this.GANG_YAODIAN_REFRESH_INTERVAL_M = Integer.valueOf(((Element)data.get("GANG_YAODIAN_REFRESH_INTERVAL_M")).attributeValue("value")).intValue();
/* 277 */       this.GANG_FULI_REFRESH_TIME_ID = Integer.valueOf(((Element)data.get("GANG_FULI_REFRESH_TIME_ID")).attributeValue("value")).intValue();
/* 278 */       this.GET_FENGLU_NEED_BANGGONG = Integer.valueOf(((Element)data.get("GET_FENGLU_NEED_BANGGONG")).attributeValue("value")).intValue();
/* 279 */       this.FENGLU_REWARD_ID = Integer.valueOf(((Element)data.get("FENGLU_REWARD_ID")).attributeValue("value")).intValue();
/* 280 */       this.GET_FENGLU_MIN_DAYS = Integer.valueOf(((Element)data.get("GET_FENGLU_MIN_DAYS")).attributeValue("value")).intValue();
/* 281 */       this.REDEEM_BANGGONG_NEED_JOIN_DAY = Integer.valueOf(((Element)data.get("REDEEM_BANGGONG_NEED_JOIN_DAY")).attributeValue("value")).intValue();
/* 282 */       this.CAN_GET_LIHE_NEED_JOIN_DAY = Integer.valueOf(((Element)data.get("CAN_GET_LIHE_NEED_JOIN_DAY")).attributeValue("value")).intValue();
/* 283 */       this.LIHE_MAIL_ID = Integer.valueOf(((Element)data.get("LIHE_MAIL_ID")).attributeValue("value")).intValue();
/* 284 */       this.SEVER_GANG_SIGN_STR = String.valueOf(((Element)data.get("SEVER_GANG_SIGN_STR")).attributeValue("value"));
/* 285 */       this.SIGN_REWARD_ITEM_ID = Integer.valueOf(((Element)data.get("SIGN_REWARD_ITEM_ID")).attributeValue("value")).intValue();
/* 286 */       this.NEW_GANG_SIGN_DAYNUM = Integer.valueOf(((Element)data.get("NEW_GANG_SIGN_DAYNUM")).attributeValue("value")).intValue();
/* 287 */       this.GANG_CHENGWEI_ID = Integer.valueOf(((Element)data.get("GANG_CHENGWEI_ID")).attributeValue("value")).intValue();
/* 288 */       this.ONEKEY_TYPE1_NUM = Integer.valueOf(((Element)data.get("ONEKEY_TYPE1_NUM")).attributeValue("value")).intValue();
/* 289 */       this.ONEKEY_TYPE2_NUM = Integer.valueOf(((Element)data.get("ONEKEY_TYPE2_NUM")).attributeValue("value")).intValue();
/* 290 */       this.ONEKEY_TYPE3_NUM = Integer.valueOf(((Element)data.get("ONEKEY_TYPE3_NUM")).attributeValue("value")).intValue();
/* 291 */       this.ONEKEY_TYPE4_NUM = Integer.valueOf(((Element)data.get("ONEKEY_TYPE4_NUM")).attributeValue("value")).intValue();
/* 292 */       this.GANG_ONLINE_NUM_TYPE1 = Integer.valueOf(((Element)data.get("GANG_ONLINE_NUM_TYPE1")).attributeValue("value")).intValue();
/* 293 */       this.GANG_ONLINE_NUM_TYPE2 = Integer.valueOf(((Element)data.get("GANG_ONLINE_NUM_TYPE2")).attributeValue("value")).intValue();
/* 294 */       this.PAY_TIME = Integer.valueOf(((Element)data.get("PAY_TIME")).attributeValue("value")).intValue();
/* 295 */       this.PAY_MAIL = Integer.valueOf(((Element)data.get("PAY_MAIL")).attributeValue("value")).intValue();
/* 296 */       this.COMBINE_VITALITY = Integer.valueOf(((Element)data.get("COMBINE_VITALITY")).attributeValue("value")).intValue();
/* 297 */       this.COMBINE_CLEAN_OFFLINE_DAYS = Integer.valueOf(((Element)data.get("COMBINE_CLEAN_OFFLINE_DAYS")).attributeValue("value")).intValue();
/* 298 */       this.COMBINE_APPLY_HOURS = Integer.valueOf(((Element)data.get("COMBINE_APPLY_HOURS")).attributeValue("value")).intValue();
/* 299 */       this.ACTIVE_MEMBER_NEED_ACTIVE_POINT = Integer.valueOf(((Element)data.get("ACTIVE_MEMBER_NEED_ACTIVE_POINT")).attributeValue("value")).intValue();
/* 300 */       this.CAN_COMBINE_MAIL = Integer.valueOf(((Element)data.get("CAN_COMBINE_MAIL")).attributeValue("value")).intValue();
/* 301 */       this.COMBINE_REFUSED_MAIL = Integer.valueOf(((Element)data.get("COMBINE_REFUSED_MAIL")).attributeValue("value")).intValue();
/* 302 */       this.COMBINE_SUCCEED_MAIL = Integer.valueOf(((Element)data.get("COMBINE_SUCCEED_MAIL")).attributeValue("value")).intValue();
/* 303 */       this.COMBINE_CANCEL_MAIL = Integer.valueOf(((Element)data.get("COMBINE_CANCEL_MAIL")).attributeValue("value")).intValue();
/* 304 */       this.COMBINE_FAIL_MAIL = Integer.valueOf(((Element)data.get("COMBINE_FAIL_MAIL")).attributeValue("value")).intValue();
/* 305 */       this.COMBINE_AGREED_MAIL = Integer.valueOf(((Element)data.get("COMBINE_AGREED_MAIL")).attributeValue("value")).intValue();
/* 306 */       this.COMBINE_KICK_MAIL = Integer.valueOf(((Element)data.get("COMBINE_KICK_MAIL")).attributeValue("value")).intValue();
/* 307 */       this.COMBINE_FAIL_BY_DISSOLVE_MAIL = Integer.valueOf(((Element)data.get("COMBINE_FAIL_BY_DISSOLVE_MAIL")).attributeValue("value")).intValue();
/* 308 */       this.applyNewWeight = Integer.valueOf(((Element)data.get("applyNewWeight")).attributeValue("value")).intValue();
/*     */       
/* 310 */       Element collectionElement = (Element)data.get("applyOldWeights");
/* 311 */       if (collectionElement == null)
/*     */       {
/* 313 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 316 */       List<?> _nodeList = collectionElement.elements();
/* 317 */       int _len = _nodeList.size();
/* 318 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 320 */         Element elem = (Element)_nodeList.get(i);
/* 321 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.gang.confbean.ApplyOldOnlineWeight"))
/*     */         {
/*     */           ApplyOldOnlineWeight _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 328 */             _v_ = new ApplyOldOnlineWeight();
/* 329 */             _v_.loadFromXml(elem);
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 336 */           this.applyOldWeights.add(_v_);
/*     */         }
/*     */       }
/* 339 */       this.applyRandomRefreshSeconds = Integer.valueOf(((Element)data.get("applyRandomRefreshSeconds")).attributeValue("value")).intValue();
/* 340 */       this.BANGZHU_ID = Integer.valueOf(((Element)data.get("BANGZHU_ID")).attributeValue("value")).intValue();
/* 341 */       this.FUBANGZHU_ID = Integer.valueOf(((Element)data.get("FUBANGZHU_ID")).attributeValue("value")).intValue();
/* 342 */       this.ZHANGLAO_ID = Integer.valueOf(((Element)data.get("ZHANGLAO_ID")).attributeValue("value")).intValue();
/* 343 */       this.TANGZHU_ID = Integer.valueOf(((Element)data.get("TANGZHU_ID")).attributeValue("value")).intValue();
/* 344 */       this.XIANGZHU_ID = Integer.valueOf(((Element)data.get("XIANGZHU_ID")).attributeValue("value")).intValue();
/* 345 */       this.JINGYING_ID = Integer.valueOf(((Element)data.get("JINGYING_ID")).attributeValue("value")).intValue();
/* 346 */       this.BANGZHONG_ID = Integer.valueOf(((Element)data.get("BANGZHONG_ID")).attributeValue("value")).intValue();
/* 347 */       this.XUETU_ID = Integer.valueOf(((Element)data.get("XUETU_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 351 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 356 */     String path = dir + "mzm.gsp.gang.confbean.SGangConst.xml";
/*     */     try
/*     */     {
/* 359 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 360 */       org.dom4j.Document doc = reader.read(new File(path));
/* 361 */       Element root = doc.getRootElement();
/* 362 */       Map<String, Element> data = new java.util.HashMap();
/* 363 */       List<?> nodeList = root.elements();
/* 364 */       int len = nodeList.size();
/* 365 */       for (int i = 0; i < len; i++)
/*     */       {
/* 367 */         Element element = (Element)nodeList.get(i);
/* 368 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 371 */           String name = element.attributeValue("name");
/* 372 */           if (data.put(name, element) != null)
/* 373 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 376 */       this.OPEN_LEVEL = Integer.valueOf(((Element)data.get("OPEN_LEVEL")).attributeValue("value")).intValue();
/* 377 */       this.CREATE_SERVER_LEVEL = Integer.valueOf(((Element)data.get("CREATE_SERVER_LEVEL")).attributeValue("value")).intValue();
/* 378 */       this.CREATE_NEED_ROLE_LEVEL = Integer.valueOf(((Element)data.get("CREATE_NEED_ROLE_LEVEL")).attributeValue("value")).intValue();
/* 379 */       this.CREATE_NEED_YUANBAO = Integer.valueOf(((Element)data.get("CREATE_NEED_YUANBAO")).attributeValue("value")).intValue();
/* 380 */       this.GANG_NAME_MAX_LENGTH = Integer.valueOf(((Element)data.get("GANG_NAME_MAX_LENGTH")).attributeValue("value")).intValue();
/* 381 */       this.GANG_PURPOSE_MAX_LENGTH = Integer.valueOf(((Element)data.get("GANG_PURPOSE_MAX_LENGTH")).attributeValue("value")).intValue();
/* 382 */       this.JOIN_MIN_LEVEL = Integer.valueOf(((Element)data.get("JOIN_MIN_LEVEL")).attributeValue("value")).intValue();
/* 383 */       this.APPLY_NUM_LIMIT = Integer.valueOf(((Element)data.get("APPLY_NUM_LIMIT")).attributeValue("value")).intValue();
/* 384 */       this.RESPONSE_JOIN_LIMIT_TIME_M = Integer.valueOf(((Element)data.get("RESPONSE_JOIN_LIMIT_TIME_M")).attributeValue("value")).intValue();
/* 385 */       this.GANG_APPLY_LIST_PERSIST_TIME_H = Integer.valueOf(((Element)data.get("GANG_APPLY_LIST_PERSIST_TIME_H")).attributeValue("value")).intValue();
/* 386 */       this.GANG_APPLY_LIST_NUM_LIMIT = Integer.valueOf(((Element)data.get("GANG_APPLY_LIST_NUM_LIMIT")).attributeValue("value")).intValue();
/* 387 */       this.KICK_XUETU_OFFLINE_DAYS = Integer.valueOf(((Element)data.get("KICK_XUETU_OFFLINE_DAYS")).attributeValue("value")).intValue();
/* 388 */       this.KICK_NORMAL_OFFLINE_DAYS = Integer.valueOf(((Element)data.get("KICK_NORMAL_OFFLINE_DAYS")).attributeValue("value")).intValue();
/* 389 */       this.KICK_XUETU_BANGGONG_MIN = Integer.valueOf(((Element)data.get("KICK_XUETU_BANGGONG_MIN")).attributeValue("value")).intValue();
/* 390 */       this.KICK_NORMAL_BANGGONG_MIN = Integer.valueOf(((Element)data.get("KICK_NORMAL_BANGGONG_MIN")).attributeValue("value")).intValue();
/* 391 */       this.XUETU_MAX_LV = Integer.valueOf(((Element)data.get("XUETU_MAX_LV")).attributeValue("value")).intValue();
/* 392 */       this.SETTING_XUETU_MAX_OFFSET_LV = Integer.valueOf(((Element)data.get("SETTING_XUETU_MAX_OFFSET_LV")).attributeValue("value")).intValue();
/* 393 */       this.SETTING_XUETU_MIN_OFFSET_LV = Integer.valueOf(((Element)data.get("SETTING_XUETU_MIN_OFFSET_LV")).attributeValue("value")).intValue();
/* 394 */       this.TANHE_OFFLINE_D = Integer.valueOf(((Element)data.get("TANHE_OFFLINE_D")).attributeValue("value")).intValue();
/* 395 */       this.TANHE_WAIT_TIME_D = Integer.valueOf(((Element)data.get("TANHE_WAIT_TIME_D")).attributeValue("value")).intValue();
/* 396 */       this.MODIFY_NAME_NEED_YUANBAO = Integer.valueOf(((Element)data.get("MODIFY_NAME_NEED_YUANBAO")).attributeValue("value")).intValue();
/* 397 */       this.MODIFY_NAME_MIN_GANG_LV = Integer.valueOf(((Element)data.get("MODIFY_NAME_MIN_GANG_LV")).attributeValue("value")).intValue();
/* 398 */       this.MODIFY_NAME_COOLDOWN_H = Integer.valueOf(((Element)data.get("MODIFY_NAME_COOLDOWN_H")).attributeValue("value")).intValue();
/* 399 */       this.KICK_NO_COST_OFFLINE_TIME_D = Integer.valueOf(((Element)data.get("KICK_NO_COST_OFFLINE_TIME_D")).attributeValue("value")).intValue();
/* 400 */       this.KICK_NO_COST_JOIN_TIME_D = Integer.valueOf(((Element)data.get("KICK_NO_COST_JOIN_TIME_D")).attributeValue("value")).intValue();
/* 401 */       this.KICK_NO_COST_BANGGONG_LIMIT = Integer.valueOf(((Element)data.get("KICK_NO_COST_BANGGONG_LIMIT")).attributeValue("value")).intValue();
/* 402 */       this.ORGINAL_MONEY = Integer.valueOf(((Element)data.get("ORGINAL_MONEY")).attributeValue("value")).intValue();
/* 403 */       this.ADD_LIVELY_NEED_LOGIN = Integer.valueOf(((Element)data.get("ADD_LIVELY_NEED_LOGIN")).attributeValue("value")).intValue();
/* 404 */       this.ADD_LIVELY_BY_LOGIN = Integer.valueOf(((Element)data.get("ADD_LIVELY_BY_LOGIN")).attributeValue("value")).intValue();
/* 405 */       this.ADD_LIVELY_NEED_INDIVIDUAL_VIGOR = Integer.valueOf(((Element)data.get("ADD_LIVELY_NEED_INDIVIDUAL_VIGOR")).attributeValue("value")).intValue();
/* 406 */       this.ADD_LIVELY_BY__INDIVIDUAL_VIGOR = Integer.valueOf(((Element)data.get("ADD_LIVELY_BY__INDIVIDUAL_VIGOR")).attributeValue("value")).intValue();
/* 407 */       this.GANG_LIVELY_MAX_LIMIT = Integer.valueOf(((Element)data.get("GANG_LIVELY_MAX_LIMIT")).attributeValue("value")).intValue();
/* 408 */       this.GANG_LIVELY_WARN_LIMIT = Integer.valueOf(((Element)data.get("GANG_LIVELY_WARN_LIMIT")).attributeValue("value")).intValue();
/* 409 */       this.GANG_WARN_TIME_H = Integer.valueOf(((Element)data.get("GANG_WARN_TIME_H")).attributeValue("value")).intValue();
/* 410 */       this.GANG_REMOVE_WARN_NEED_LIVELY = Integer.valueOf(((Element)data.get("GANG_REMOVE_WARN_NEED_LIVELY")).attributeValue("value")).intValue();
/* 411 */       this.GANG_BUILD_SYNC_INTERVAL_M = Integer.valueOf(((Element)data.get("GANG_BUILD_SYNC_INTERVAL_M")).attributeValue("value")).intValue();
/* 412 */       this.NEW_GANG_PROTECT_TIME_D = Integer.valueOf(((Element)data.get("NEW_GANG_PROTECT_TIME_D")).attributeValue("value")).intValue();
/* 413 */       this.FORBIDDEN_TALK_TIME_H = Integer.valueOf(((Element)data.get("FORBIDDEN_TALK_TIME_H")).attributeValue("value")).intValue();
/* 414 */       this.FORBIDDEN_TALK_COUNT_PER_DAY = Integer.valueOf(((Element)data.get("FORBIDDEN_TALK_COUNT_PER_DAY")).attributeValue("value")).intValue();
/* 415 */       this.FORBIDDEN_TALK_COST_VIGOR = Integer.valueOf(((Element)data.get("FORBIDDEN_TALK_COST_VIGOR")).attributeValue("value")).intValue();
/* 416 */       this.ANNOUNCEMENT_NUM_LIMIT = Integer.valueOf(((Element)data.get("ANNOUNCEMENT_NUM_LIMIT")).attributeValue("value")).intValue();
/* 417 */       this.ANNOUNCEMENT_MAX_LENGTH = Integer.valueOf(((Element)data.get("ANNOUNCEMENT_MAX_LENGTH")).attributeValue("value")).intValue();
/* 418 */       this.PUBLISH_ANNOUNCEMENT_COST_VIGOR = Integer.valueOf(((Element)data.get("PUBLISH_ANNOUNCEMENT_COST_VIGOR")).attributeValue("value")).intValue();
/* 419 */       this.JOIN_GANG_BANGGONG_CALC_RATE = Integer.valueOf(((Element)data.get("JOIN_GANG_BANGGONG_CALC_RATE")).attributeValue("value")).intValue();
/* 420 */       this.DONATE_LV_1 = Integer.valueOf(((Element)data.get("DONATE_LV_1")).attributeValue("value")).intValue();
/* 421 */       this.LV_1_REWARD_BANGGONG = Integer.valueOf(((Element)data.get("LV_1_REWARD_BANGGONG")).attributeValue("value")).intValue();
/* 422 */       this.LV_1_CUT_TIME = Integer.valueOf(((Element)data.get("LV_1_CUT_TIME")).attributeValue("value")).intValue();
/* 423 */       this.DONATE_LV_2 = Integer.valueOf(((Element)data.get("DONATE_LV_2")).attributeValue("value")).intValue();
/* 424 */       this.LV_2_REWARD_BANGGONG = Integer.valueOf(((Element)data.get("LV_2_REWARD_BANGGONG")).attributeValue("value")).intValue();
/* 425 */       this.LV_2_CUT_TIME = Integer.valueOf(((Element)data.get("LV_2_CUT_TIME")).attributeValue("value")).intValue();
/* 426 */       this.DONATE_LV_3 = Integer.valueOf(((Element)data.get("DONATE_LV_3")).attributeValue("value")).intValue();
/* 427 */       this.LV_3_REWARD_BANGGONG = Integer.valueOf(((Element)data.get("LV_3_REWARD_BANGGONG")).attributeValue("value")).intValue();
/* 428 */       this.LV_3_CUT_TIME = Integer.valueOf(((Element)data.get("LV_3_CUT_TIME")).attributeValue("value")).intValue();
/* 429 */       this.DONATE_LV_4 = Integer.valueOf(((Element)data.get("DONATE_LV_4")).attributeValue("value")).intValue();
/* 430 */       this.LV_4_REWARD_BANGGONG = Integer.valueOf(((Element)data.get("LV_4_REWARD_BANGGONG")).attributeValue("value")).intValue();
/* 431 */       this.LV_4_CUT_TIME = Integer.valueOf(((Element)data.get("LV_4_CUT_TIME")).attributeValue("value")).intValue();
/* 432 */       this.JOIN_MAIL_ID = Integer.valueOf(((Element)data.get("JOIN_MAIL_ID")).attributeValue("value")).intValue();
/* 433 */       this.KICK_OUT_MAIL_ID = Integer.valueOf(((Element)data.get("KICK_OUT_MAIL_ID")).attributeValue("value")).intValue();
/* 434 */       this.NORMAL_FULL_HAVE_XUETU_MAIL_ID = Integer.valueOf(((Element)data.get("NORMAL_FULL_HAVE_XUETU_MAIL_ID")).attributeValue("value")).intValue();
/* 435 */       this.CHANG_BANGZHU_MAIL_ID = Integer.valueOf(((Element)data.get("CHANG_BANGZHU_MAIL_ID")).attributeValue("value")).intValue();
/* 436 */       this.CHANG_BANGZHU_OLD_BANGZHU_MAIL_ID = Integer.valueOf(((Element)data.get("CHANG_BANGZHU_OLD_BANGZHU_MAIL_ID")).attributeValue("value")).intValue();
/* 437 */       this.TANHE_OLD_BANGZHU_MAIL_ID = Integer.valueOf(((Element)data.get("TANHE_OLD_BANGZHU_MAIL_ID")).attributeValue("value")).intValue();
/* 438 */       this.AUTO_BE_BANGZHU_MAIL_ID = Integer.valueOf(((Element)data.get("AUTO_BE_BANGZHU_MAIL_ID")).attributeValue("value")).intValue();
/* 439 */       this.LOW_LIVELY_MAIL_ID = Integer.valueOf(((Element)data.get("LOW_LIVELY_MAIL_ID")).attributeValue("value")).intValue();
/* 440 */       this.CAN_NOT_MAINTAIN_MAIL_ID = Integer.valueOf(((Element)data.get("CAN_NOT_MAINTAIN_MAIL_ID")).attributeValue("value")).intValue();
/* 441 */       this.NO_MORE_MONEY_WARN_MAIL_ID = Integer.valueOf(((Element)data.get("NO_MORE_MONEY_WARN_MAIL_ID")).attributeValue("value")).intValue();
/* 442 */       this.NEED_MORE_LIVELY_WARN_MAIL_ID = Integer.valueOf(((Element)data.get("NEED_MORE_LIVELY_WARN_MAIL_ID")).attributeValue("value")).intValue();
/* 443 */       this.GANG_MERGE_MAIL_ID = Integer.valueOf(((Element)data.get("GANG_MERGE_MAIL_ID")).attributeValue("value")).intValue();
/* 444 */       this.CHANGE_DUTY_MAIL_ID = Integer.valueOf(((Element)data.get("CHANGE_DUTY_MAIL_ID")).attributeValue("value")).intValue();
/* 445 */       this.GANG_LEVEL_DOWN_MAIL_ID = Integer.valueOf(((Element)data.get("GANG_LEVEL_DOWN_MAIL_ID")).attributeValue("value")).intValue();
/* 446 */       this.GANG_DISSOLVE_MAIL_ID = Integer.valueOf(((Element)data.get("GANG_DISSOLVE_MAIL_ID")).attributeValue("value")).intValue();
/* 447 */       this.DEFAULT_DUTY_NAME_ID = Integer.valueOf(((Element)data.get("DEFAULT_DUTY_NAME_ID")).attributeValue("value")).intValue();
/* 448 */       this.ANNOUMCEMENT_LIMIT_PER_DAY = Integer.valueOf(((Element)data.get("ANNOUMCEMENT_LIMIT_PER_DAY")).attributeValue("value")).intValue();
/* 449 */       this.GANG_MAP = Integer.valueOf(((Element)data.get("GANG_MAP")).attributeValue("value")).intValue();
/* 450 */       this.BE_LEADER_JOIN_LEAST_DAY = Integer.valueOf(((Element)data.get("BE_LEADER_JOIN_LEAST_DAY")).attributeValue("value")).intValue();
/* 451 */       this.GANG_MAX_LEVEL = Integer.valueOf(((Element)data.get("GANG_MAX_LEVEL")).attributeValue("value")).intValue();
/* 452 */       this.GANG_SCHEDULE_TIME_ID = Integer.valueOf(((Element)data.get("GANG_SCHEDULE_TIME_ID")).attributeValue("value")).intValue();
/* 453 */       this.ADD_LIVELY_NEED_JUANZHONG = Integer.valueOf(((Element)data.get("ADD_LIVELY_NEED_JUANZHONG")).attributeValue("value")).intValue();
/* 454 */       this.ADD_LIVELY_NUM_BY_JUANZHONG = Integer.valueOf(((Element)data.get("ADD_LIVELY_NUM_BY_JUANZHONG")).attributeValue("value")).intValue();
/* 455 */       this.SILVER2BANGGONG_RATE = Integer.valueOf(((Element)data.get("SILVER2BANGGONG_RATE")).attributeValue("value")).intValue();
/* 456 */       this.SILVER2BANGGONG_LV1 = Integer.valueOf(((Element)data.get("SILVER2BANGGONG_LV1")).attributeValue("value")).intValue();
/* 457 */       this.SILVER2BANGGONG_LV2 = Integer.valueOf(((Element)data.get("SILVER2BANGGONG_LV2")).attributeValue("value")).intValue();
/* 458 */       this.SILVER2BANGGONG_LV3 = Integer.valueOf(((Element)data.get("SILVER2BANGGONG_LV3")).attributeValue("value")).intValue();
/* 459 */       this.SILVER2BANGGONG_LV4 = Integer.valueOf(((Element)data.get("SILVER2BANGGONG_LV4")).attributeValue("value")).intValue();
/* 460 */       this.SILVER2BANGGONG_LIMIT = Integer.valueOf(((Element)data.get("SILVER2BANGGONG_LIMIT")).attributeValue("value")).intValue();
/* 461 */       this.yuanbao_2_bang_gong_limit = Integer.valueOf(((Element)data.get("yuanbao_2_bang_gong_limit")).attributeValue("value")).intValue();
/* 462 */       this.SILVER2BANGGONG_CLEAR_TIMEID = Integer.valueOf(((Element)data.get("SILVER2BANGGONG_CLEAR_TIMEID")).attributeValue("value")).intValue();
/* 463 */       this.GANG_YAODIAN_REFRESH_INTERVAL_M = Integer.valueOf(((Element)data.get("GANG_YAODIAN_REFRESH_INTERVAL_M")).attributeValue("value")).intValue();
/* 464 */       this.GANG_FULI_REFRESH_TIME_ID = Integer.valueOf(((Element)data.get("GANG_FULI_REFRESH_TIME_ID")).attributeValue("value")).intValue();
/* 465 */       this.GET_FENGLU_NEED_BANGGONG = Integer.valueOf(((Element)data.get("GET_FENGLU_NEED_BANGGONG")).attributeValue("value")).intValue();
/* 466 */       this.FENGLU_REWARD_ID = Integer.valueOf(((Element)data.get("FENGLU_REWARD_ID")).attributeValue("value")).intValue();
/* 467 */       this.GET_FENGLU_MIN_DAYS = Integer.valueOf(((Element)data.get("GET_FENGLU_MIN_DAYS")).attributeValue("value")).intValue();
/* 468 */       this.REDEEM_BANGGONG_NEED_JOIN_DAY = Integer.valueOf(((Element)data.get("REDEEM_BANGGONG_NEED_JOIN_DAY")).attributeValue("value")).intValue();
/* 469 */       this.CAN_GET_LIHE_NEED_JOIN_DAY = Integer.valueOf(((Element)data.get("CAN_GET_LIHE_NEED_JOIN_DAY")).attributeValue("value")).intValue();
/* 470 */       this.LIHE_MAIL_ID = Integer.valueOf(((Element)data.get("LIHE_MAIL_ID")).attributeValue("value")).intValue();
/* 471 */       this.SEVER_GANG_SIGN_STR = String.valueOf(((Element)data.get("SEVER_GANG_SIGN_STR")).attributeValue("value"));
/* 472 */       this.SIGN_REWARD_ITEM_ID = Integer.valueOf(((Element)data.get("SIGN_REWARD_ITEM_ID")).attributeValue("value")).intValue();
/* 473 */       this.NEW_GANG_SIGN_DAYNUM = Integer.valueOf(((Element)data.get("NEW_GANG_SIGN_DAYNUM")).attributeValue("value")).intValue();
/* 474 */       this.GANG_CHENGWEI_ID = Integer.valueOf(((Element)data.get("GANG_CHENGWEI_ID")).attributeValue("value")).intValue();
/* 475 */       this.ONEKEY_TYPE1_NUM = Integer.valueOf(((Element)data.get("ONEKEY_TYPE1_NUM")).attributeValue("value")).intValue();
/* 476 */       this.ONEKEY_TYPE2_NUM = Integer.valueOf(((Element)data.get("ONEKEY_TYPE2_NUM")).attributeValue("value")).intValue();
/* 477 */       this.ONEKEY_TYPE3_NUM = Integer.valueOf(((Element)data.get("ONEKEY_TYPE3_NUM")).attributeValue("value")).intValue();
/* 478 */       this.ONEKEY_TYPE4_NUM = Integer.valueOf(((Element)data.get("ONEKEY_TYPE4_NUM")).attributeValue("value")).intValue();
/* 479 */       this.GANG_ONLINE_NUM_TYPE1 = Integer.valueOf(((Element)data.get("GANG_ONLINE_NUM_TYPE1")).attributeValue("value")).intValue();
/* 480 */       this.GANG_ONLINE_NUM_TYPE2 = Integer.valueOf(((Element)data.get("GANG_ONLINE_NUM_TYPE2")).attributeValue("value")).intValue();
/* 481 */       this.PAY_TIME = Integer.valueOf(((Element)data.get("PAY_TIME")).attributeValue("value")).intValue();
/* 482 */       this.PAY_MAIL = Integer.valueOf(((Element)data.get("PAY_MAIL")).attributeValue("value")).intValue();
/* 483 */       this.COMBINE_VITALITY = Integer.valueOf(((Element)data.get("COMBINE_VITALITY")).attributeValue("value")).intValue();
/* 484 */       this.COMBINE_CLEAN_OFFLINE_DAYS = Integer.valueOf(((Element)data.get("COMBINE_CLEAN_OFFLINE_DAYS")).attributeValue("value")).intValue();
/* 485 */       this.COMBINE_APPLY_HOURS = Integer.valueOf(((Element)data.get("COMBINE_APPLY_HOURS")).attributeValue("value")).intValue();
/* 486 */       this.ACTIVE_MEMBER_NEED_ACTIVE_POINT = Integer.valueOf(((Element)data.get("ACTIVE_MEMBER_NEED_ACTIVE_POINT")).attributeValue("value")).intValue();
/* 487 */       this.CAN_COMBINE_MAIL = Integer.valueOf(((Element)data.get("CAN_COMBINE_MAIL")).attributeValue("value")).intValue();
/* 488 */       this.COMBINE_REFUSED_MAIL = Integer.valueOf(((Element)data.get("COMBINE_REFUSED_MAIL")).attributeValue("value")).intValue();
/* 489 */       this.COMBINE_SUCCEED_MAIL = Integer.valueOf(((Element)data.get("COMBINE_SUCCEED_MAIL")).attributeValue("value")).intValue();
/* 490 */       this.COMBINE_CANCEL_MAIL = Integer.valueOf(((Element)data.get("COMBINE_CANCEL_MAIL")).attributeValue("value")).intValue();
/* 491 */       this.COMBINE_FAIL_MAIL = Integer.valueOf(((Element)data.get("COMBINE_FAIL_MAIL")).attributeValue("value")).intValue();
/* 492 */       this.COMBINE_AGREED_MAIL = Integer.valueOf(((Element)data.get("COMBINE_AGREED_MAIL")).attributeValue("value")).intValue();
/* 493 */       this.COMBINE_KICK_MAIL = Integer.valueOf(((Element)data.get("COMBINE_KICK_MAIL")).attributeValue("value")).intValue();
/* 494 */       this.COMBINE_FAIL_BY_DISSOLVE_MAIL = Integer.valueOf(((Element)data.get("COMBINE_FAIL_BY_DISSOLVE_MAIL")).attributeValue("value")).intValue();
/* 495 */       this.applyNewWeight = Integer.valueOf(((Element)data.get("applyNewWeight")).attributeValue("value")).intValue();
/*     */       
/* 497 */       Element collectionElement = (Element)data.get("applyOldWeights");
/* 498 */       if (collectionElement == null)
/*     */       {
/* 500 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 503 */       List<?> _nodeList = collectionElement.elements();
/* 504 */       int _len = _nodeList.size();
/* 505 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 507 */         Element elem = (Element)_nodeList.get(i);
/* 508 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.gang.confbean.ApplyOldOnlineWeight"))
/*     */         {
/*     */           ApplyOldOnlineWeight _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 515 */             _v_ = new ApplyOldOnlineWeight();
/* 516 */             _v_.loadFromXml(elem);
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 523 */           this.applyOldWeights.add(_v_);
/*     */         }
/*     */       }
/* 526 */       this.applyRandomRefreshSeconds = Integer.valueOf(((Element)data.get("applyRandomRefreshSeconds")).attributeValue("value")).intValue();
/* 527 */       this.BANGZHU_ID = Integer.valueOf(((Element)data.get("BANGZHU_ID")).attributeValue("value")).intValue();
/* 528 */       this.FUBANGZHU_ID = Integer.valueOf(((Element)data.get("FUBANGZHU_ID")).attributeValue("value")).intValue();
/* 529 */       this.ZHANGLAO_ID = Integer.valueOf(((Element)data.get("ZHANGLAO_ID")).attributeValue("value")).intValue();
/* 530 */       this.TANGZHU_ID = Integer.valueOf(((Element)data.get("TANGZHU_ID")).attributeValue("value")).intValue();
/* 531 */       this.XIANGZHU_ID = Integer.valueOf(((Element)data.get("XIANGZHU_ID")).attributeValue("value")).intValue();
/* 532 */       this.JINGYING_ID = Integer.valueOf(((Element)data.get("JINGYING_ID")).attributeValue("value")).intValue();
/* 533 */       this.BANGZHONG_ID = Integer.valueOf(((Element)data.get("BANGZHONG_ID")).attributeValue("value")).intValue();
/* 534 */       this.XUETU_ID = Integer.valueOf(((Element)data.get("XUETU_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 538 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 542 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 545 */     String path = dir + "mzm.gsp.gang.confbean.SGangConst.bny";
/*     */     try
/*     */     {
/* 548 */       File file = new File(path);
/* 549 */       if (file.exists())
/*     */       {
/* 551 */         byte[] bytes = new byte['Ѐ'];
/* 552 */         FileInputStream fis = new FileInputStream(file);
/* 553 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 554 */         int len = 0;
/* 555 */         while ((len = fis.read(bytes)) > 0)
/* 556 */           baos.write(bytes, 0, len);
/* 557 */         fis.close();
/* 558 */         bytes = baos.toByteArray();
/* 559 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 560 */         this.OPEN_LEVEL = _os_.unmarshal_int();
/* 561 */         this.CREATE_SERVER_LEVEL = _os_.unmarshal_int();
/* 562 */         this.CREATE_NEED_ROLE_LEVEL = _os_.unmarshal_int();
/* 563 */         this.CREATE_NEED_YUANBAO = _os_.unmarshal_int();
/* 564 */         this.GANG_NAME_MAX_LENGTH = _os_.unmarshal_int();
/* 565 */         this.GANG_PURPOSE_MAX_LENGTH = _os_.unmarshal_int();
/* 566 */         this.JOIN_MIN_LEVEL = _os_.unmarshal_int();
/* 567 */         this.APPLY_NUM_LIMIT = _os_.unmarshal_int();
/* 568 */         this.RESPONSE_JOIN_LIMIT_TIME_M = _os_.unmarshal_int();
/* 569 */         this.GANG_APPLY_LIST_PERSIST_TIME_H = _os_.unmarshal_int();
/* 570 */         this.GANG_APPLY_LIST_NUM_LIMIT = _os_.unmarshal_int();
/* 571 */         this.KICK_XUETU_OFFLINE_DAYS = _os_.unmarshal_int();
/* 572 */         this.KICK_NORMAL_OFFLINE_DAYS = _os_.unmarshal_int();
/* 573 */         this.KICK_XUETU_BANGGONG_MIN = _os_.unmarshal_int();
/* 574 */         this.KICK_NORMAL_BANGGONG_MIN = _os_.unmarshal_int();
/* 575 */         this.XUETU_MAX_LV = _os_.unmarshal_int();
/* 576 */         this.SETTING_XUETU_MAX_OFFSET_LV = _os_.unmarshal_int();
/* 577 */         this.SETTING_XUETU_MIN_OFFSET_LV = _os_.unmarshal_int();
/* 578 */         this.TANHE_OFFLINE_D = _os_.unmarshal_int();
/* 579 */         this.TANHE_WAIT_TIME_D = _os_.unmarshal_int();
/* 580 */         this.MODIFY_NAME_NEED_YUANBAO = _os_.unmarshal_int();
/* 581 */         this.MODIFY_NAME_MIN_GANG_LV = _os_.unmarshal_int();
/* 582 */         this.MODIFY_NAME_COOLDOWN_H = _os_.unmarshal_int();
/* 583 */         this.KICK_NO_COST_OFFLINE_TIME_D = _os_.unmarshal_int();
/* 584 */         this.KICK_NO_COST_JOIN_TIME_D = _os_.unmarshal_int();
/* 585 */         this.KICK_NO_COST_BANGGONG_LIMIT = _os_.unmarshal_int();
/* 586 */         this.ORGINAL_MONEY = _os_.unmarshal_int();
/* 587 */         this.ADD_LIVELY_NEED_LOGIN = _os_.unmarshal_int();
/* 588 */         this.ADD_LIVELY_BY_LOGIN = _os_.unmarshal_int();
/* 589 */         this.ADD_LIVELY_NEED_INDIVIDUAL_VIGOR = _os_.unmarshal_int();
/* 590 */         this.ADD_LIVELY_BY__INDIVIDUAL_VIGOR = _os_.unmarshal_int();
/* 591 */         this.GANG_LIVELY_MAX_LIMIT = _os_.unmarshal_int();
/* 592 */         this.GANG_LIVELY_WARN_LIMIT = _os_.unmarshal_int();
/* 593 */         this.GANG_WARN_TIME_H = _os_.unmarshal_int();
/* 594 */         this.GANG_REMOVE_WARN_NEED_LIVELY = _os_.unmarshal_int();
/* 595 */         this.GANG_BUILD_SYNC_INTERVAL_M = _os_.unmarshal_int();
/* 596 */         this.NEW_GANG_PROTECT_TIME_D = _os_.unmarshal_int();
/* 597 */         this.FORBIDDEN_TALK_TIME_H = _os_.unmarshal_int();
/* 598 */         this.FORBIDDEN_TALK_COUNT_PER_DAY = _os_.unmarshal_int();
/* 599 */         this.FORBIDDEN_TALK_COST_VIGOR = _os_.unmarshal_int();
/* 600 */         this.ANNOUNCEMENT_NUM_LIMIT = _os_.unmarshal_int();
/* 601 */         this.ANNOUNCEMENT_MAX_LENGTH = _os_.unmarshal_int();
/* 602 */         this.PUBLISH_ANNOUNCEMENT_COST_VIGOR = _os_.unmarshal_int();
/* 603 */         this.JOIN_GANG_BANGGONG_CALC_RATE = _os_.unmarshal_int();
/* 604 */         this.DONATE_LV_1 = _os_.unmarshal_int();
/* 605 */         this.LV_1_REWARD_BANGGONG = _os_.unmarshal_int();
/* 606 */         this.LV_1_CUT_TIME = _os_.unmarshal_int();
/* 607 */         this.DONATE_LV_2 = _os_.unmarshal_int();
/* 608 */         this.LV_2_REWARD_BANGGONG = _os_.unmarshal_int();
/* 609 */         this.LV_2_CUT_TIME = _os_.unmarshal_int();
/* 610 */         this.DONATE_LV_3 = _os_.unmarshal_int();
/* 611 */         this.LV_3_REWARD_BANGGONG = _os_.unmarshal_int();
/* 612 */         this.LV_3_CUT_TIME = _os_.unmarshal_int();
/* 613 */         this.DONATE_LV_4 = _os_.unmarshal_int();
/* 614 */         this.LV_4_REWARD_BANGGONG = _os_.unmarshal_int();
/* 615 */         this.LV_4_CUT_TIME = _os_.unmarshal_int();
/* 616 */         this.JOIN_MAIL_ID = _os_.unmarshal_int();
/* 617 */         this.KICK_OUT_MAIL_ID = _os_.unmarshal_int();
/* 618 */         this.NORMAL_FULL_HAVE_XUETU_MAIL_ID = _os_.unmarshal_int();
/* 619 */         this.CHANG_BANGZHU_MAIL_ID = _os_.unmarshal_int();
/* 620 */         this.CHANG_BANGZHU_OLD_BANGZHU_MAIL_ID = _os_.unmarshal_int();
/* 621 */         this.TANHE_OLD_BANGZHU_MAIL_ID = _os_.unmarshal_int();
/* 622 */         this.AUTO_BE_BANGZHU_MAIL_ID = _os_.unmarshal_int();
/* 623 */         this.LOW_LIVELY_MAIL_ID = _os_.unmarshal_int();
/* 624 */         this.CAN_NOT_MAINTAIN_MAIL_ID = _os_.unmarshal_int();
/* 625 */         this.NO_MORE_MONEY_WARN_MAIL_ID = _os_.unmarshal_int();
/* 626 */         this.NEED_MORE_LIVELY_WARN_MAIL_ID = _os_.unmarshal_int();
/* 627 */         this.GANG_MERGE_MAIL_ID = _os_.unmarshal_int();
/* 628 */         this.CHANGE_DUTY_MAIL_ID = _os_.unmarshal_int();
/* 629 */         this.GANG_LEVEL_DOWN_MAIL_ID = _os_.unmarshal_int();
/* 630 */         this.GANG_DISSOLVE_MAIL_ID = _os_.unmarshal_int();
/* 631 */         this.DEFAULT_DUTY_NAME_ID = _os_.unmarshal_int();
/* 632 */         this.ANNOUMCEMENT_LIMIT_PER_DAY = _os_.unmarshal_int();
/* 633 */         this.GANG_MAP = _os_.unmarshal_int();
/* 634 */         this.BE_LEADER_JOIN_LEAST_DAY = _os_.unmarshal_int();
/* 635 */         this.GANG_MAX_LEVEL = _os_.unmarshal_int();
/* 636 */         this.GANG_SCHEDULE_TIME_ID = _os_.unmarshal_int();
/* 637 */         this.ADD_LIVELY_NEED_JUANZHONG = _os_.unmarshal_int();
/* 638 */         this.ADD_LIVELY_NUM_BY_JUANZHONG = _os_.unmarshal_int();
/* 639 */         this.SILVER2BANGGONG_RATE = _os_.unmarshal_int();
/* 640 */         this.SILVER2BANGGONG_LV1 = _os_.unmarshal_int();
/* 641 */         this.SILVER2BANGGONG_LV2 = _os_.unmarshal_int();
/* 642 */         this.SILVER2BANGGONG_LV3 = _os_.unmarshal_int();
/* 643 */         this.SILVER2BANGGONG_LV4 = _os_.unmarshal_int();
/* 644 */         this.SILVER2BANGGONG_LIMIT = _os_.unmarshal_int();
/* 645 */         this.yuanbao_2_bang_gong_limit = _os_.unmarshal_int();
/* 646 */         this.SILVER2BANGGONG_CLEAR_TIMEID = _os_.unmarshal_int();
/* 647 */         this.GANG_YAODIAN_REFRESH_INTERVAL_M = _os_.unmarshal_int();
/* 648 */         this.GANG_FULI_REFRESH_TIME_ID = _os_.unmarshal_int();
/* 649 */         this.GET_FENGLU_NEED_BANGGONG = _os_.unmarshal_int();
/* 650 */         this.FENGLU_REWARD_ID = _os_.unmarshal_int();
/* 651 */         this.GET_FENGLU_MIN_DAYS = _os_.unmarshal_int();
/* 652 */         this.REDEEM_BANGGONG_NEED_JOIN_DAY = _os_.unmarshal_int();
/* 653 */         this.CAN_GET_LIHE_NEED_JOIN_DAY = _os_.unmarshal_int();
/* 654 */         this.LIHE_MAIL_ID = _os_.unmarshal_int();
/* 655 */         this.SEVER_GANG_SIGN_STR = _os_.unmarshal_String("UTF-8");
/* 656 */         this.SIGN_REWARD_ITEM_ID = _os_.unmarshal_int();
/* 657 */         this.NEW_GANG_SIGN_DAYNUM = _os_.unmarshal_int();
/* 658 */         this.GANG_CHENGWEI_ID = _os_.unmarshal_int();
/* 659 */         this.ONEKEY_TYPE1_NUM = _os_.unmarshal_int();
/* 660 */         this.ONEKEY_TYPE2_NUM = _os_.unmarshal_int();
/* 661 */         this.ONEKEY_TYPE3_NUM = _os_.unmarshal_int();
/* 662 */         this.ONEKEY_TYPE4_NUM = _os_.unmarshal_int();
/* 663 */         this.GANG_ONLINE_NUM_TYPE1 = _os_.unmarshal_int();
/* 664 */         this.GANG_ONLINE_NUM_TYPE2 = _os_.unmarshal_int();
/* 665 */         this.PAY_TIME = _os_.unmarshal_int();
/* 666 */         this.PAY_MAIL = _os_.unmarshal_int();
/* 667 */         this.COMBINE_VITALITY = _os_.unmarshal_int();
/* 668 */         this.COMBINE_CLEAN_OFFLINE_DAYS = _os_.unmarshal_int();
/* 669 */         this.COMBINE_APPLY_HOURS = _os_.unmarshal_int();
/* 670 */         this.ACTIVE_MEMBER_NEED_ACTIVE_POINT = _os_.unmarshal_int();
/* 671 */         this.CAN_COMBINE_MAIL = _os_.unmarshal_int();
/* 672 */         this.COMBINE_REFUSED_MAIL = _os_.unmarshal_int();
/* 673 */         this.COMBINE_SUCCEED_MAIL = _os_.unmarshal_int();
/* 674 */         this.COMBINE_CANCEL_MAIL = _os_.unmarshal_int();
/* 675 */         this.COMBINE_FAIL_MAIL = _os_.unmarshal_int();
/* 676 */         this.COMBINE_AGREED_MAIL = _os_.unmarshal_int();
/* 677 */         this.COMBINE_KICK_MAIL = _os_.unmarshal_int();
/* 678 */         this.COMBINE_FAIL_BY_DISSOLVE_MAIL = _os_.unmarshal_int();
/* 679 */         this.applyNewWeight = _os_.unmarshal_int();
/* 680 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 683 */           ApplyOldOnlineWeight _v_ = new ApplyOldOnlineWeight();
/* 684 */           _v_.unmarshal(_os_);
/* 685 */           this.applyOldWeights.add(_v_);
/*     */         }
/* 687 */         this.applyRandomRefreshSeconds = _os_.unmarshal_int();
/* 688 */         this.BANGZHU_ID = _os_.unmarshal_int();
/* 689 */         this.FUBANGZHU_ID = _os_.unmarshal_int();
/* 690 */         this.ZHANGLAO_ID = _os_.unmarshal_int();
/* 691 */         this.TANGZHU_ID = _os_.unmarshal_int();
/* 692 */         this.XIANGZHU_ID = _os_.unmarshal_int();
/* 693 */         this.JINGYING_ID = _os_.unmarshal_int();
/* 694 */         this.BANGZHONG_ID = _os_.unmarshal_int();
/* 695 */         this.XUETU_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 700 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 706 */     String path = dir + "mzm.gsp.gang.confbean.SGangConst.bny";
/*     */     try
/*     */     {
/* 709 */       File file = new File(path);
/* 710 */       if (file.exists())
/*     */       {
/* 712 */         byte[] bytes = new byte['Ѐ'];
/* 713 */         FileInputStream fis = new FileInputStream(file);
/* 714 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 715 */         int len = 0;
/* 716 */         while ((len = fis.read(bytes)) > 0)
/* 717 */           baos.write(bytes, 0, len);
/* 718 */         fis.close();
/* 719 */         bytes = baos.toByteArray();
/* 720 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 721 */         this.OPEN_LEVEL = _os_.unmarshal_int();
/* 722 */         this.CREATE_SERVER_LEVEL = _os_.unmarshal_int();
/* 723 */         this.CREATE_NEED_ROLE_LEVEL = _os_.unmarshal_int();
/* 724 */         this.CREATE_NEED_YUANBAO = _os_.unmarshal_int();
/* 725 */         this.GANG_NAME_MAX_LENGTH = _os_.unmarshal_int();
/* 726 */         this.GANG_PURPOSE_MAX_LENGTH = _os_.unmarshal_int();
/* 727 */         this.JOIN_MIN_LEVEL = _os_.unmarshal_int();
/* 728 */         this.APPLY_NUM_LIMIT = _os_.unmarshal_int();
/* 729 */         this.RESPONSE_JOIN_LIMIT_TIME_M = _os_.unmarshal_int();
/* 730 */         this.GANG_APPLY_LIST_PERSIST_TIME_H = _os_.unmarshal_int();
/* 731 */         this.GANG_APPLY_LIST_NUM_LIMIT = _os_.unmarshal_int();
/* 732 */         this.KICK_XUETU_OFFLINE_DAYS = _os_.unmarshal_int();
/* 733 */         this.KICK_NORMAL_OFFLINE_DAYS = _os_.unmarshal_int();
/* 734 */         this.KICK_XUETU_BANGGONG_MIN = _os_.unmarshal_int();
/* 735 */         this.KICK_NORMAL_BANGGONG_MIN = _os_.unmarshal_int();
/* 736 */         this.XUETU_MAX_LV = _os_.unmarshal_int();
/* 737 */         this.SETTING_XUETU_MAX_OFFSET_LV = _os_.unmarshal_int();
/* 738 */         this.SETTING_XUETU_MIN_OFFSET_LV = _os_.unmarshal_int();
/* 739 */         this.TANHE_OFFLINE_D = _os_.unmarshal_int();
/* 740 */         this.TANHE_WAIT_TIME_D = _os_.unmarshal_int();
/* 741 */         this.MODIFY_NAME_NEED_YUANBAO = _os_.unmarshal_int();
/* 742 */         this.MODIFY_NAME_MIN_GANG_LV = _os_.unmarshal_int();
/* 743 */         this.MODIFY_NAME_COOLDOWN_H = _os_.unmarshal_int();
/* 744 */         this.KICK_NO_COST_OFFLINE_TIME_D = _os_.unmarshal_int();
/* 745 */         this.KICK_NO_COST_JOIN_TIME_D = _os_.unmarshal_int();
/* 746 */         this.KICK_NO_COST_BANGGONG_LIMIT = _os_.unmarshal_int();
/* 747 */         this.ORGINAL_MONEY = _os_.unmarshal_int();
/* 748 */         this.ADD_LIVELY_NEED_LOGIN = _os_.unmarshal_int();
/* 749 */         this.ADD_LIVELY_BY_LOGIN = _os_.unmarshal_int();
/* 750 */         this.ADD_LIVELY_NEED_INDIVIDUAL_VIGOR = _os_.unmarshal_int();
/* 751 */         this.ADD_LIVELY_BY__INDIVIDUAL_VIGOR = _os_.unmarshal_int();
/* 752 */         this.GANG_LIVELY_MAX_LIMIT = _os_.unmarshal_int();
/* 753 */         this.GANG_LIVELY_WARN_LIMIT = _os_.unmarshal_int();
/* 754 */         this.GANG_WARN_TIME_H = _os_.unmarshal_int();
/* 755 */         this.GANG_REMOVE_WARN_NEED_LIVELY = _os_.unmarshal_int();
/* 756 */         this.GANG_BUILD_SYNC_INTERVAL_M = _os_.unmarshal_int();
/* 757 */         this.NEW_GANG_PROTECT_TIME_D = _os_.unmarshal_int();
/* 758 */         this.FORBIDDEN_TALK_TIME_H = _os_.unmarshal_int();
/* 759 */         this.FORBIDDEN_TALK_COUNT_PER_DAY = _os_.unmarshal_int();
/* 760 */         this.FORBIDDEN_TALK_COST_VIGOR = _os_.unmarshal_int();
/* 761 */         this.ANNOUNCEMENT_NUM_LIMIT = _os_.unmarshal_int();
/* 762 */         this.ANNOUNCEMENT_MAX_LENGTH = _os_.unmarshal_int();
/* 763 */         this.PUBLISH_ANNOUNCEMENT_COST_VIGOR = _os_.unmarshal_int();
/* 764 */         this.JOIN_GANG_BANGGONG_CALC_RATE = _os_.unmarshal_int();
/* 765 */         this.DONATE_LV_1 = _os_.unmarshal_int();
/* 766 */         this.LV_1_REWARD_BANGGONG = _os_.unmarshal_int();
/* 767 */         this.LV_1_CUT_TIME = _os_.unmarshal_int();
/* 768 */         this.DONATE_LV_2 = _os_.unmarshal_int();
/* 769 */         this.LV_2_REWARD_BANGGONG = _os_.unmarshal_int();
/* 770 */         this.LV_2_CUT_TIME = _os_.unmarshal_int();
/* 771 */         this.DONATE_LV_3 = _os_.unmarshal_int();
/* 772 */         this.LV_3_REWARD_BANGGONG = _os_.unmarshal_int();
/* 773 */         this.LV_3_CUT_TIME = _os_.unmarshal_int();
/* 774 */         this.DONATE_LV_4 = _os_.unmarshal_int();
/* 775 */         this.LV_4_REWARD_BANGGONG = _os_.unmarshal_int();
/* 776 */         this.LV_4_CUT_TIME = _os_.unmarshal_int();
/* 777 */         this.JOIN_MAIL_ID = _os_.unmarshal_int();
/* 778 */         this.KICK_OUT_MAIL_ID = _os_.unmarshal_int();
/* 779 */         this.NORMAL_FULL_HAVE_XUETU_MAIL_ID = _os_.unmarshal_int();
/* 780 */         this.CHANG_BANGZHU_MAIL_ID = _os_.unmarshal_int();
/* 781 */         this.CHANG_BANGZHU_OLD_BANGZHU_MAIL_ID = _os_.unmarshal_int();
/* 782 */         this.TANHE_OLD_BANGZHU_MAIL_ID = _os_.unmarshal_int();
/* 783 */         this.AUTO_BE_BANGZHU_MAIL_ID = _os_.unmarshal_int();
/* 784 */         this.LOW_LIVELY_MAIL_ID = _os_.unmarshal_int();
/* 785 */         this.CAN_NOT_MAINTAIN_MAIL_ID = _os_.unmarshal_int();
/* 786 */         this.NO_MORE_MONEY_WARN_MAIL_ID = _os_.unmarshal_int();
/* 787 */         this.NEED_MORE_LIVELY_WARN_MAIL_ID = _os_.unmarshal_int();
/* 788 */         this.GANG_MERGE_MAIL_ID = _os_.unmarshal_int();
/* 789 */         this.CHANGE_DUTY_MAIL_ID = _os_.unmarshal_int();
/* 790 */         this.GANG_LEVEL_DOWN_MAIL_ID = _os_.unmarshal_int();
/* 791 */         this.GANG_DISSOLVE_MAIL_ID = _os_.unmarshal_int();
/* 792 */         this.DEFAULT_DUTY_NAME_ID = _os_.unmarshal_int();
/* 793 */         this.ANNOUMCEMENT_LIMIT_PER_DAY = _os_.unmarshal_int();
/* 794 */         this.GANG_MAP = _os_.unmarshal_int();
/* 795 */         this.BE_LEADER_JOIN_LEAST_DAY = _os_.unmarshal_int();
/* 796 */         this.GANG_MAX_LEVEL = _os_.unmarshal_int();
/* 797 */         this.GANG_SCHEDULE_TIME_ID = _os_.unmarshal_int();
/* 798 */         this.ADD_LIVELY_NEED_JUANZHONG = _os_.unmarshal_int();
/* 799 */         this.ADD_LIVELY_NUM_BY_JUANZHONG = _os_.unmarshal_int();
/* 800 */         this.SILVER2BANGGONG_RATE = _os_.unmarshal_int();
/* 801 */         this.SILVER2BANGGONG_LV1 = _os_.unmarshal_int();
/* 802 */         this.SILVER2BANGGONG_LV2 = _os_.unmarshal_int();
/* 803 */         this.SILVER2BANGGONG_LV3 = _os_.unmarshal_int();
/* 804 */         this.SILVER2BANGGONG_LV4 = _os_.unmarshal_int();
/* 805 */         this.SILVER2BANGGONG_LIMIT = _os_.unmarshal_int();
/* 806 */         this.yuanbao_2_bang_gong_limit = _os_.unmarshal_int();
/* 807 */         this.SILVER2BANGGONG_CLEAR_TIMEID = _os_.unmarshal_int();
/* 808 */         this.GANG_YAODIAN_REFRESH_INTERVAL_M = _os_.unmarshal_int();
/* 809 */         this.GANG_FULI_REFRESH_TIME_ID = _os_.unmarshal_int();
/* 810 */         this.GET_FENGLU_NEED_BANGGONG = _os_.unmarshal_int();
/* 811 */         this.FENGLU_REWARD_ID = _os_.unmarshal_int();
/* 812 */         this.GET_FENGLU_MIN_DAYS = _os_.unmarshal_int();
/* 813 */         this.REDEEM_BANGGONG_NEED_JOIN_DAY = _os_.unmarshal_int();
/* 814 */         this.CAN_GET_LIHE_NEED_JOIN_DAY = _os_.unmarshal_int();
/* 815 */         this.LIHE_MAIL_ID = _os_.unmarshal_int();
/* 816 */         this.SEVER_GANG_SIGN_STR = _os_.unmarshal_String("UTF-8");
/* 817 */         this.SIGN_REWARD_ITEM_ID = _os_.unmarshal_int();
/* 818 */         this.NEW_GANG_SIGN_DAYNUM = _os_.unmarshal_int();
/* 819 */         this.GANG_CHENGWEI_ID = _os_.unmarshal_int();
/* 820 */         this.ONEKEY_TYPE1_NUM = _os_.unmarshal_int();
/* 821 */         this.ONEKEY_TYPE2_NUM = _os_.unmarshal_int();
/* 822 */         this.ONEKEY_TYPE3_NUM = _os_.unmarshal_int();
/* 823 */         this.ONEKEY_TYPE4_NUM = _os_.unmarshal_int();
/* 824 */         this.GANG_ONLINE_NUM_TYPE1 = _os_.unmarshal_int();
/* 825 */         this.GANG_ONLINE_NUM_TYPE2 = _os_.unmarshal_int();
/* 826 */         this.PAY_TIME = _os_.unmarshal_int();
/* 827 */         this.PAY_MAIL = _os_.unmarshal_int();
/* 828 */         this.COMBINE_VITALITY = _os_.unmarshal_int();
/* 829 */         this.COMBINE_CLEAN_OFFLINE_DAYS = _os_.unmarshal_int();
/* 830 */         this.COMBINE_APPLY_HOURS = _os_.unmarshal_int();
/* 831 */         this.ACTIVE_MEMBER_NEED_ACTIVE_POINT = _os_.unmarshal_int();
/* 832 */         this.CAN_COMBINE_MAIL = _os_.unmarshal_int();
/* 833 */         this.COMBINE_REFUSED_MAIL = _os_.unmarshal_int();
/* 834 */         this.COMBINE_SUCCEED_MAIL = _os_.unmarshal_int();
/* 835 */         this.COMBINE_CANCEL_MAIL = _os_.unmarshal_int();
/* 836 */         this.COMBINE_FAIL_MAIL = _os_.unmarshal_int();
/* 837 */         this.COMBINE_AGREED_MAIL = _os_.unmarshal_int();
/* 838 */         this.COMBINE_KICK_MAIL = _os_.unmarshal_int();
/* 839 */         this.COMBINE_FAIL_BY_DISSOLVE_MAIL = _os_.unmarshal_int();
/* 840 */         this.applyNewWeight = _os_.unmarshal_int();
/* 841 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 844 */           ApplyOldOnlineWeight _v_ = new ApplyOldOnlineWeight();
/* 845 */           _v_.unmarshal(_os_);
/* 846 */           this.applyOldWeights.add(_v_);
/*     */         }
/* 848 */         this.applyRandomRefreshSeconds = _os_.unmarshal_int();
/* 849 */         this.BANGZHU_ID = _os_.unmarshal_int();
/* 850 */         this.FUBANGZHU_ID = _os_.unmarshal_int();
/* 851 */         this.ZHANGLAO_ID = _os_.unmarshal_int();
/* 852 */         this.TANGZHU_ID = _os_.unmarshal_int();
/* 853 */         this.XIANGZHU_ID = _os_.unmarshal_int();
/* 854 */         this.JINGYING_ID = _os_.unmarshal_int();
/* 855 */         this.BANGZHONG_ID = _os_.unmarshal_int();
/* 856 */         this.XUETU_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 861 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SGangConst newInstance)
/*     */   {
/* 867 */     oldInstance = instance;
/* 868 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 873 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\confbean\SGangConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */