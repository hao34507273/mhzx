/*     */ package mzm.gsp.pk.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SPKConsts
/*     */ {
/*  13 */   private static volatile SPKConsts oldInstance = null;
/*     */   
/*  15 */   private static SPKConsts instance = new SPKConsts();
/*     */   public int ENABLE_PK_MONEY_TYPE;
/*     */   public int ENABLE_PK_PRICE;
/*     */   public int ENABLE_PK_LEVEL;
/*     */   public int PK_MINUTES;
/*     */   
/*     */   public static SPKConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SPKConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int MAX_PK_TIMES_PER_DAY;
/*     */   
/*     */   public int PK_DEATH_PROTECTION_MINUTES;
/*     */   
/*     */   public int MAX_PK_DEATH_TIMES_PER_DAY;
/*     */   
/*     */   public int PK_FORCE_PROTECTION_MINUTES;
/*     */   
/*     */   public int PK_DEATH_EQUIPMENT_PENALTY;
/*     */   public int PK_MAX_DISTANCE;
/*     */   public int TEAM_PK_CONFIRM_SECONDS;
/*     */   public int INITIAL_MORAL_VALUE;
/*     */   public int ENABLE_PK_MORAL_VALUE;
/*     */   public int WANTED_MORAL_VALUE;
/*     */   public int LEAVE_PRISON_MORAL_VALUE;
/*     */   public int PK_MORAL_VALUE_REDUCE_FACTOR_A;
/*     */   public int PK_MORAL_VALUE_REDUCE_FACTOR_B;
/*     */   public int MORAL_VALUE_MONEY_TYPE;
/*     */   public int MORAL_TASK_ACTIVITY_ID;
/*     */   public int MORAL_TASK_GRAPH_ID;
/*     */   public int MORAL_TASK_AWARD_ID;
/*     */   public int REVENGE_ITEM_TRANSFER_CONFIRM_SECONDS;
/*     */   public int ARREST_MONEY_TYPE;
/*     */   public int ARREST_PRICE;
/*     */   public int ARREST_LEVEL_DIFF;
/*     */   public int ARREST_REWARD_ID;
/*     */   public int ARREST_MAX_COUNT;
/*     */   public int NPC_ARREST_MINUTES;
/*     */   public int NPC_ARREST_INTERVAL_MINUTES;
/*     */   public int NPC_ARREST_FIGHT_ID_1;
/*     */   public int NPC_ARREST_FIGHT_ID_2;
/*     */   public int WANTED_ARREST_DEATH_EQUIPMENT_PENALTY;
/*     */   public int NON_WANTED_ARREST_DEATH_EQUIPMENT_PENALTY;
/*     */   public int WANTED_RECORD_COUNT_PER_PAGE;
/*     */   public int WANTED_AWARD_MAX_COUNT_PER_DAY;
/*     */   public int PRISON_MAP_ID;
/*     */   public int WANTED_ENTER_PRISON_MAP_X;
/*     */   public int WANTED_ENTER_PRISON_MAP_Y;
/*     */   public int NON_WANTED_ENTER_PRISON_MAP_X;
/*     */   public int NON_WANTED_ENTER_PRISON_MAP_Y;
/*     */   public int LEAVE_PRISON_MAP_ID;
/*     */   public int PRISON_SERVE_MINUTES;
/*     */   public int LEAVE_PRISON_FORBIDDEN_PK_MINUTES;
/*     */   public int PRISON_BREAK_MONEY_TYPE;
/*     */   public int PRISON_BREAK_PRICE;
/*     */   public int PRISON_RECORD_COUNT_PER_PAGE;
/*     */   public int JAIL_BREAK_PVE_FIGHT_ID;
/*     */   public int JAIL_DELIVERY_PVE_FIGHT_ID;
/*     */   public int MALE_PRISON_BUFF_ID;
/*     */   public int FEMALE_PRISON_BUFF_ID;
/*     */   public int PK_NPC_ID;
/*     */   public int MORAL_VALUE_NPC_ID;
/*     */   public int WANTED_NPC_ID;
/*     */   public int ARREST_SERVICE_ID;
/*     */   public int VISIT_PRISON_SERVICE_ID;
/*     */   public int RESCUE_NPC_ID;
/*     */   public int RESCUE_SERVICE_ID;
/*     */   public int RETURN_SERVICE_ID;
/*     */   public int PRISON_BREAK_NPC_ID;
/*     */   public int PRISON_BREAK_SERVICE_ID;
/*     */   public int PRISON_SERVE_TIME_SERVICE_ID;
/*     */   public int ARRESTED_MAIL_ID;
/*     */   public int JAIL_OUT_MAIL_ID;
/*     */   public int JAIL_BREAK_MAIL_ID;
/*     */   public int JAIL_DELIVERY_MAIL_ID;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  99 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/* 104 */     String path = dir + "mzm.gsp.pk.confbean.SPKConsts.xml";
/*     */     try
/*     */     {
/* 107 */       SAXReader reader = new SAXReader();
/* 108 */       org.dom4j.Document doc = reader.read(new File(path));
/* 109 */       Element root = doc.getRootElement();
/* 110 */       Map<String, Element> data = new java.util.HashMap();
/* 111 */       java.util.List<?> nodeList = root.elements();
/* 112 */       int len = nodeList.size();
/* 113 */       for (int i = 0; i < len; i++)
/*     */       {
/* 115 */         Element element = (Element)nodeList.get(i);
/* 116 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 119 */           String name = element.attributeValue("name");
/* 120 */           if (data.put(name, element) != null)
/* 121 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 124 */       this.ENABLE_PK_MONEY_TYPE = Integer.valueOf(((Element)data.get("ENABLE_PK_MONEY_TYPE")).attributeValue("value")).intValue();
/* 125 */       this.ENABLE_PK_PRICE = Integer.valueOf(((Element)data.get("ENABLE_PK_PRICE")).attributeValue("value")).intValue();
/* 126 */       this.ENABLE_PK_LEVEL = Integer.valueOf(((Element)data.get("ENABLE_PK_LEVEL")).attributeValue("value")).intValue();
/* 127 */       this.PK_MINUTES = Integer.valueOf(((Element)data.get("PK_MINUTES")).attributeValue("value")).intValue();
/* 128 */       this.MAX_PK_TIMES_PER_DAY = Integer.valueOf(((Element)data.get("MAX_PK_TIMES_PER_DAY")).attributeValue("value")).intValue();
/* 129 */       this.PK_DEATH_PROTECTION_MINUTES = Integer.valueOf(((Element)data.get("PK_DEATH_PROTECTION_MINUTES")).attributeValue("value")).intValue();
/* 130 */       this.MAX_PK_DEATH_TIMES_PER_DAY = Integer.valueOf(((Element)data.get("MAX_PK_DEATH_TIMES_PER_DAY")).attributeValue("value")).intValue();
/* 131 */       this.PK_FORCE_PROTECTION_MINUTES = Integer.valueOf(((Element)data.get("PK_FORCE_PROTECTION_MINUTES")).attributeValue("value")).intValue();
/* 132 */       this.PK_DEATH_EQUIPMENT_PENALTY = Integer.valueOf(((Element)data.get("PK_DEATH_EQUIPMENT_PENALTY")).attributeValue("value")).intValue();
/* 133 */       this.PK_MAX_DISTANCE = Integer.valueOf(((Element)data.get("PK_MAX_DISTANCE")).attributeValue("value")).intValue();
/* 134 */       this.TEAM_PK_CONFIRM_SECONDS = Integer.valueOf(((Element)data.get("TEAM_PK_CONFIRM_SECONDS")).attributeValue("value")).intValue();
/* 135 */       this.INITIAL_MORAL_VALUE = Integer.valueOf(((Element)data.get("INITIAL_MORAL_VALUE")).attributeValue("value")).intValue();
/* 136 */       this.ENABLE_PK_MORAL_VALUE = Integer.valueOf(((Element)data.get("ENABLE_PK_MORAL_VALUE")).attributeValue("value")).intValue();
/* 137 */       this.WANTED_MORAL_VALUE = Integer.valueOf(((Element)data.get("WANTED_MORAL_VALUE")).attributeValue("value")).intValue();
/* 138 */       this.LEAVE_PRISON_MORAL_VALUE = Integer.valueOf(((Element)data.get("LEAVE_PRISON_MORAL_VALUE")).attributeValue("value")).intValue();
/* 139 */       this.PK_MORAL_VALUE_REDUCE_FACTOR_A = Integer.valueOf(((Element)data.get("PK_MORAL_VALUE_REDUCE_FACTOR_A")).attributeValue("value")).intValue();
/* 140 */       this.PK_MORAL_VALUE_REDUCE_FACTOR_B = Integer.valueOf(((Element)data.get("PK_MORAL_VALUE_REDUCE_FACTOR_B")).attributeValue("value")).intValue();
/* 141 */       this.MORAL_VALUE_MONEY_TYPE = Integer.valueOf(((Element)data.get("MORAL_VALUE_MONEY_TYPE")).attributeValue("value")).intValue();
/* 142 */       this.MORAL_TASK_ACTIVITY_ID = Integer.valueOf(((Element)data.get("MORAL_TASK_ACTIVITY_ID")).attributeValue("value")).intValue();
/* 143 */       this.MORAL_TASK_GRAPH_ID = Integer.valueOf(((Element)data.get("MORAL_TASK_GRAPH_ID")).attributeValue("value")).intValue();
/* 144 */       this.MORAL_TASK_AWARD_ID = Integer.valueOf(((Element)data.get("MORAL_TASK_AWARD_ID")).attributeValue("value")).intValue();
/* 145 */       this.REVENGE_ITEM_TRANSFER_CONFIRM_SECONDS = Integer.valueOf(((Element)data.get("REVENGE_ITEM_TRANSFER_CONFIRM_SECONDS")).attributeValue("value")).intValue();
/* 146 */       this.ARREST_MONEY_TYPE = Integer.valueOf(((Element)data.get("ARREST_MONEY_TYPE")).attributeValue("value")).intValue();
/* 147 */       this.ARREST_PRICE = Integer.valueOf(((Element)data.get("ARREST_PRICE")).attributeValue("value")).intValue();
/* 148 */       this.ARREST_LEVEL_DIFF = Integer.valueOf(((Element)data.get("ARREST_LEVEL_DIFF")).attributeValue("value")).intValue();
/* 149 */       this.ARREST_REWARD_ID = Integer.valueOf(((Element)data.get("ARREST_REWARD_ID")).attributeValue("value")).intValue();
/* 150 */       this.ARREST_MAX_COUNT = Integer.valueOf(((Element)data.get("ARREST_MAX_COUNT")).attributeValue("value")).intValue();
/* 151 */       this.NPC_ARREST_MINUTES = Integer.valueOf(((Element)data.get("NPC_ARREST_MINUTES")).attributeValue("value")).intValue();
/* 152 */       this.NPC_ARREST_INTERVAL_MINUTES = Integer.valueOf(((Element)data.get("NPC_ARREST_INTERVAL_MINUTES")).attributeValue("value")).intValue();
/* 153 */       this.NPC_ARREST_FIGHT_ID_1 = Integer.valueOf(((Element)data.get("NPC_ARREST_FIGHT_ID_1")).attributeValue("value")).intValue();
/* 154 */       this.NPC_ARREST_FIGHT_ID_2 = Integer.valueOf(((Element)data.get("NPC_ARREST_FIGHT_ID_2")).attributeValue("value")).intValue();
/* 155 */       this.WANTED_ARREST_DEATH_EQUIPMENT_PENALTY = Integer.valueOf(((Element)data.get("WANTED_ARREST_DEATH_EQUIPMENT_PENALTY")).attributeValue("value")).intValue();
/* 156 */       this.NON_WANTED_ARREST_DEATH_EQUIPMENT_PENALTY = Integer.valueOf(((Element)data.get("NON_WANTED_ARREST_DEATH_EQUIPMENT_PENALTY")).attributeValue("value")).intValue();
/* 157 */       this.WANTED_RECORD_COUNT_PER_PAGE = Integer.valueOf(((Element)data.get("WANTED_RECORD_COUNT_PER_PAGE")).attributeValue("value")).intValue();
/* 158 */       this.WANTED_AWARD_MAX_COUNT_PER_DAY = Integer.valueOf(((Element)data.get("WANTED_AWARD_MAX_COUNT_PER_DAY")).attributeValue("value")).intValue();
/* 159 */       this.PRISON_MAP_ID = Integer.valueOf(((Element)data.get("PRISON_MAP_ID")).attributeValue("value")).intValue();
/* 160 */       this.WANTED_ENTER_PRISON_MAP_X = Integer.valueOf(((Element)data.get("WANTED_ENTER_PRISON_MAP_X")).attributeValue("value")).intValue();
/* 161 */       this.WANTED_ENTER_PRISON_MAP_Y = Integer.valueOf(((Element)data.get("WANTED_ENTER_PRISON_MAP_Y")).attributeValue("value")).intValue();
/* 162 */       this.NON_WANTED_ENTER_PRISON_MAP_X = Integer.valueOf(((Element)data.get("NON_WANTED_ENTER_PRISON_MAP_X")).attributeValue("value")).intValue();
/* 163 */       this.NON_WANTED_ENTER_PRISON_MAP_Y = Integer.valueOf(((Element)data.get("NON_WANTED_ENTER_PRISON_MAP_Y")).attributeValue("value")).intValue();
/* 164 */       this.LEAVE_PRISON_MAP_ID = Integer.valueOf(((Element)data.get("LEAVE_PRISON_MAP_ID")).attributeValue("value")).intValue();
/* 165 */       this.PRISON_SERVE_MINUTES = Integer.valueOf(((Element)data.get("PRISON_SERVE_MINUTES")).attributeValue("value")).intValue();
/* 166 */       this.LEAVE_PRISON_FORBIDDEN_PK_MINUTES = Integer.valueOf(((Element)data.get("LEAVE_PRISON_FORBIDDEN_PK_MINUTES")).attributeValue("value")).intValue();
/* 167 */       this.PRISON_BREAK_MONEY_TYPE = Integer.valueOf(((Element)data.get("PRISON_BREAK_MONEY_TYPE")).attributeValue("value")).intValue();
/* 168 */       this.PRISON_BREAK_PRICE = Integer.valueOf(((Element)data.get("PRISON_BREAK_PRICE")).attributeValue("value")).intValue();
/* 169 */       this.PRISON_RECORD_COUNT_PER_PAGE = Integer.valueOf(((Element)data.get("PRISON_RECORD_COUNT_PER_PAGE")).attributeValue("value")).intValue();
/* 170 */       this.JAIL_BREAK_PVE_FIGHT_ID = Integer.valueOf(((Element)data.get("JAIL_BREAK_PVE_FIGHT_ID")).attributeValue("value")).intValue();
/* 171 */       this.JAIL_DELIVERY_PVE_FIGHT_ID = Integer.valueOf(((Element)data.get("JAIL_DELIVERY_PVE_FIGHT_ID")).attributeValue("value")).intValue();
/* 172 */       this.MALE_PRISON_BUFF_ID = Integer.valueOf(((Element)data.get("MALE_PRISON_BUFF_ID")).attributeValue("value")).intValue();
/* 173 */       this.FEMALE_PRISON_BUFF_ID = Integer.valueOf(((Element)data.get("FEMALE_PRISON_BUFF_ID")).attributeValue("value")).intValue();
/* 174 */       this.PK_NPC_ID = Integer.valueOf(((Element)data.get("PK_NPC_ID")).attributeValue("value")).intValue();
/* 175 */       this.MORAL_VALUE_NPC_ID = Integer.valueOf(((Element)data.get("MORAL_VALUE_NPC_ID")).attributeValue("value")).intValue();
/* 176 */       this.WANTED_NPC_ID = Integer.valueOf(((Element)data.get("WANTED_NPC_ID")).attributeValue("value")).intValue();
/* 177 */       this.ARREST_SERVICE_ID = Integer.valueOf(((Element)data.get("ARREST_SERVICE_ID")).attributeValue("value")).intValue();
/* 178 */       this.VISIT_PRISON_SERVICE_ID = Integer.valueOf(((Element)data.get("VISIT_PRISON_SERVICE_ID")).attributeValue("value")).intValue();
/* 179 */       this.RESCUE_NPC_ID = Integer.valueOf(((Element)data.get("RESCUE_NPC_ID")).attributeValue("value")).intValue();
/* 180 */       this.RESCUE_SERVICE_ID = Integer.valueOf(((Element)data.get("RESCUE_SERVICE_ID")).attributeValue("value")).intValue();
/* 181 */       this.RETURN_SERVICE_ID = Integer.valueOf(((Element)data.get("RETURN_SERVICE_ID")).attributeValue("value")).intValue();
/* 182 */       this.PRISON_BREAK_NPC_ID = Integer.valueOf(((Element)data.get("PRISON_BREAK_NPC_ID")).attributeValue("value")).intValue();
/* 183 */       this.PRISON_BREAK_SERVICE_ID = Integer.valueOf(((Element)data.get("PRISON_BREAK_SERVICE_ID")).attributeValue("value")).intValue();
/* 184 */       this.PRISON_SERVE_TIME_SERVICE_ID = Integer.valueOf(((Element)data.get("PRISON_SERVE_TIME_SERVICE_ID")).attributeValue("value")).intValue();
/* 185 */       this.ARRESTED_MAIL_ID = Integer.valueOf(((Element)data.get("ARRESTED_MAIL_ID")).attributeValue("value")).intValue();
/* 186 */       this.JAIL_OUT_MAIL_ID = Integer.valueOf(((Element)data.get("JAIL_OUT_MAIL_ID")).attributeValue("value")).intValue();
/* 187 */       this.JAIL_BREAK_MAIL_ID = Integer.valueOf(((Element)data.get("JAIL_BREAK_MAIL_ID")).attributeValue("value")).intValue();
/* 188 */       this.JAIL_DELIVERY_MAIL_ID = Integer.valueOf(((Element)data.get("JAIL_DELIVERY_MAIL_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 192 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 197 */     String path = dir + "mzm.gsp.pk.confbean.SPKConsts.xml";
/*     */     try
/*     */     {
/* 200 */       SAXReader reader = new SAXReader();
/* 201 */       org.dom4j.Document doc = reader.read(new File(path));
/* 202 */       Element root = doc.getRootElement();
/* 203 */       Map<String, Element> data = new java.util.HashMap();
/* 204 */       java.util.List<?> nodeList = root.elements();
/* 205 */       int len = nodeList.size();
/* 206 */       for (int i = 0; i < len; i++)
/*     */       {
/* 208 */         Element element = (Element)nodeList.get(i);
/* 209 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 212 */           String name = element.attributeValue("name");
/* 213 */           if (data.put(name, element) != null)
/* 214 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 217 */       this.ENABLE_PK_MONEY_TYPE = Integer.valueOf(((Element)data.get("ENABLE_PK_MONEY_TYPE")).attributeValue("value")).intValue();
/* 218 */       this.ENABLE_PK_PRICE = Integer.valueOf(((Element)data.get("ENABLE_PK_PRICE")).attributeValue("value")).intValue();
/* 219 */       this.ENABLE_PK_LEVEL = Integer.valueOf(((Element)data.get("ENABLE_PK_LEVEL")).attributeValue("value")).intValue();
/* 220 */       this.PK_MINUTES = Integer.valueOf(((Element)data.get("PK_MINUTES")).attributeValue("value")).intValue();
/* 221 */       this.MAX_PK_TIMES_PER_DAY = Integer.valueOf(((Element)data.get("MAX_PK_TIMES_PER_DAY")).attributeValue("value")).intValue();
/* 222 */       this.PK_DEATH_PROTECTION_MINUTES = Integer.valueOf(((Element)data.get("PK_DEATH_PROTECTION_MINUTES")).attributeValue("value")).intValue();
/* 223 */       this.MAX_PK_DEATH_TIMES_PER_DAY = Integer.valueOf(((Element)data.get("MAX_PK_DEATH_TIMES_PER_DAY")).attributeValue("value")).intValue();
/* 224 */       this.PK_FORCE_PROTECTION_MINUTES = Integer.valueOf(((Element)data.get("PK_FORCE_PROTECTION_MINUTES")).attributeValue("value")).intValue();
/* 225 */       this.PK_DEATH_EQUIPMENT_PENALTY = Integer.valueOf(((Element)data.get("PK_DEATH_EQUIPMENT_PENALTY")).attributeValue("value")).intValue();
/* 226 */       this.PK_MAX_DISTANCE = Integer.valueOf(((Element)data.get("PK_MAX_DISTANCE")).attributeValue("value")).intValue();
/* 227 */       this.TEAM_PK_CONFIRM_SECONDS = Integer.valueOf(((Element)data.get("TEAM_PK_CONFIRM_SECONDS")).attributeValue("value")).intValue();
/* 228 */       this.INITIAL_MORAL_VALUE = Integer.valueOf(((Element)data.get("INITIAL_MORAL_VALUE")).attributeValue("value")).intValue();
/* 229 */       this.ENABLE_PK_MORAL_VALUE = Integer.valueOf(((Element)data.get("ENABLE_PK_MORAL_VALUE")).attributeValue("value")).intValue();
/* 230 */       this.WANTED_MORAL_VALUE = Integer.valueOf(((Element)data.get("WANTED_MORAL_VALUE")).attributeValue("value")).intValue();
/* 231 */       this.LEAVE_PRISON_MORAL_VALUE = Integer.valueOf(((Element)data.get("LEAVE_PRISON_MORAL_VALUE")).attributeValue("value")).intValue();
/* 232 */       this.PK_MORAL_VALUE_REDUCE_FACTOR_A = Integer.valueOf(((Element)data.get("PK_MORAL_VALUE_REDUCE_FACTOR_A")).attributeValue("value")).intValue();
/* 233 */       this.PK_MORAL_VALUE_REDUCE_FACTOR_B = Integer.valueOf(((Element)data.get("PK_MORAL_VALUE_REDUCE_FACTOR_B")).attributeValue("value")).intValue();
/* 234 */       this.MORAL_VALUE_MONEY_TYPE = Integer.valueOf(((Element)data.get("MORAL_VALUE_MONEY_TYPE")).attributeValue("value")).intValue();
/* 235 */       this.MORAL_TASK_ACTIVITY_ID = Integer.valueOf(((Element)data.get("MORAL_TASK_ACTIVITY_ID")).attributeValue("value")).intValue();
/* 236 */       this.MORAL_TASK_GRAPH_ID = Integer.valueOf(((Element)data.get("MORAL_TASK_GRAPH_ID")).attributeValue("value")).intValue();
/* 237 */       this.MORAL_TASK_AWARD_ID = Integer.valueOf(((Element)data.get("MORAL_TASK_AWARD_ID")).attributeValue("value")).intValue();
/* 238 */       this.REVENGE_ITEM_TRANSFER_CONFIRM_SECONDS = Integer.valueOf(((Element)data.get("REVENGE_ITEM_TRANSFER_CONFIRM_SECONDS")).attributeValue("value")).intValue();
/* 239 */       this.ARREST_MONEY_TYPE = Integer.valueOf(((Element)data.get("ARREST_MONEY_TYPE")).attributeValue("value")).intValue();
/* 240 */       this.ARREST_PRICE = Integer.valueOf(((Element)data.get("ARREST_PRICE")).attributeValue("value")).intValue();
/* 241 */       this.ARREST_LEVEL_DIFF = Integer.valueOf(((Element)data.get("ARREST_LEVEL_DIFF")).attributeValue("value")).intValue();
/* 242 */       this.ARREST_REWARD_ID = Integer.valueOf(((Element)data.get("ARREST_REWARD_ID")).attributeValue("value")).intValue();
/* 243 */       this.ARREST_MAX_COUNT = Integer.valueOf(((Element)data.get("ARREST_MAX_COUNT")).attributeValue("value")).intValue();
/* 244 */       this.NPC_ARREST_MINUTES = Integer.valueOf(((Element)data.get("NPC_ARREST_MINUTES")).attributeValue("value")).intValue();
/* 245 */       this.NPC_ARREST_INTERVAL_MINUTES = Integer.valueOf(((Element)data.get("NPC_ARREST_INTERVAL_MINUTES")).attributeValue("value")).intValue();
/* 246 */       this.NPC_ARREST_FIGHT_ID_1 = Integer.valueOf(((Element)data.get("NPC_ARREST_FIGHT_ID_1")).attributeValue("value")).intValue();
/* 247 */       this.NPC_ARREST_FIGHT_ID_2 = Integer.valueOf(((Element)data.get("NPC_ARREST_FIGHT_ID_2")).attributeValue("value")).intValue();
/* 248 */       this.WANTED_ARREST_DEATH_EQUIPMENT_PENALTY = Integer.valueOf(((Element)data.get("WANTED_ARREST_DEATH_EQUIPMENT_PENALTY")).attributeValue("value")).intValue();
/* 249 */       this.NON_WANTED_ARREST_DEATH_EQUIPMENT_PENALTY = Integer.valueOf(((Element)data.get("NON_WANTED_ARREST_DEATH_EQUIPMENT_PENALTY")).attributeValue("value")).intValue();
/* 250 */       this.WANTED_RECORD_COUNT_PER_PAGE = Integer.valueOf(((Element)data.get("WANTED_RECORD_COUNT_PER_PAGE")).attributeValue("value")).intValue();
/* 251 */       this.WANTED_AWARD_MAX_COUNT_PER_DAY = Integer.valueOf(((Element)data.get("WANTED_AWARD_MAX_COUNT_PER_DAY")).attributeValue("value")).intValue();
/* 252 */       this.PRISON_MAP_ID = Integer.valueOf(((Element)data.get("PRISON_MAP_ID")).attributeValue("value")).intValue();
/* 253 */       this.WANTED_ENTER_PRISON_MAP_X = Integer.valueOf(((Element)data.get("WANTED_ENTER_PRISON_MAP_X")).attributeValue("value")).intValue();
/* 254 */       this.WANTED_ENTER_PRISON_MAP_Y = Integer.valueOf(((Element)data.get("WANTED_ENTER_PRISON_MAP_Y")).attributeValue("value")).intValue();
/* 255 */       this.NON_WANTED_ENTER_PRISON_MAP_X = Integer.valueOf(((Element)data.get("NON_WANTED_ENTER_PRISON_MAP_X")).attributeValue("value")).intValue();
/* 256 */       this.NON_WANTED_ENTER_PRISON_MAP_Y = Integer.valueOf(((Element)data.get("NON_WANTED_ENTER_PRISON_MAP_Y")).attributeValue("value")).intValue();
/* 257 */       this.LEAVE_PRISON_MAP_ID = Integer.valueOf(((Element)data.get("LEAVE_PRISON_MAP_ID")).attributeValue("value")).intValue();
/* 258 */       this.PRISON_SERVE_MINUTES = Integer.valueOf(((Element)data.get("PRISON_SERVE_MINUTES")).attributeValue("value")).intValue();
/* 259 */       this.LEAVE_PRISON_FORBIDDEN_PK_MINUTES = Integer.valueOf(((Element)data.get("LEAVE_PRISON_FORBIDDEN_PK_MINUTES")).attributeValue("value")).intValue();
/* 260 */       this.PRISON_BREAK_MONEY_TYPE = Integer.valueOf(((Element)data.get("PRISON_BREAK_MONEY_TYPE")).attributeValue("value")).intValue();
/* 261 */       this.PRISON_BREAK_PRICE = Integer.valueOf(((Element)data.get("PRISON_BREAK_PRICE")).attributeValue("value")).intValue();
/* 262 */       this.PRISON_RECORD_COUNT_PER_PAGE = Integer.valueOf(((Element)data.get("PRISON_RECORD_COUNT_PER_PAGE")).attributeValue("value")).intValue();
/* 263 */       this.JAIL_BREAK_PVE_FIGHT_ID = Integer.valueOf(((Element)data.get("JAIL_BREAK_PVE_FIGHT_ID")).attributeValue("value")).intValue();
/* 264 */       this.JAIL_DELIVERY_PVE_FIGHT_ID = Integer.valueOf(((Element)data.get("JAIL_DELIVERY_PVE_FIGHT_ID")).attributeValue("value")).intValue();
/* 265 */       this.MALE_PRISON_BUFF_ID = Integer.valueOf(((Element)data.get("MALE_PRISON_BUFF_ID")).attributeValue("value")).intValue();
/* 266 */       this.FEMALE_PRISON_BUFF_ID = Integer.valueOf(((Element)data.get("FEMALE_PRISON_BUFF_ID")).attributeValue("value")).intValue();
/* 267 */       this.PK_NPC_ID = Integer.valueOf(((Element)data.get("PK_NPC_ID")).attributeValue("value")).intValue();
/* 268 */       this.MORAL_VALUE_NPC_ID = Integer.valueOf(((Element)data.get("MORAL_VALUE_NPC_ID")).attributeValue("value")).intValue();
/* 269 */       this.WANTED_NPC_ID = Integer.valueOf(((Element)data.get("WANTED_NPC_ID")).attributeValue("value")).intValue();
/* 270 */       this.ARREST_SERVICE_ID = Integer.valueOf(((Element)data.get("ARREST_SERVICE_ID")).attributeValue("value")).intValue();
/* 271 */       this.VISIT_PRISON_SERVICE_ID = Integer.valueOf(((Element)data.get("VISIT_PRISON_SERVICE_ID")).attributeValue("value")).intValue();
/* 272 */       this.RESCUE_NPC_ID = Integer.valueOf(((Element)data.get("RESCUE_NPC_ID")).attributeValue("value")).intValue();
/* 273 */       this.RESCUE_SERVICE_ID = Integer.valueOf(((Element)data.get("RESCUE_SERVICE_ID")).attributeValue("value")).intValue();
/* 274 */       this.RETURN_SERVICE_ID = Integer.valueOf(((Element)data.get("RETURN_SERVICE_ID")).attributeValue("value")).intValue();
/* 275 */       this.PRISON_BREAK_NPC_ID = Integer.valueOf(((Element)data.get("PRISON_BREAK_NPC_ID")).attributeValue("value")).intValue();
/* 276 */       this.PRISON_BREAK_SERVICE_ID = Integer.valueOf(((Element)data.get("PRISON_BREAK_SERVICE_ID")).attributeValue("value")).intValue();
/* 277 */       this.PRISON_SERVE_TIME_SERVICE_ID = Integer.valueOf(((Element)data.get("PRISON_SERVE_TIME_SERVICE_ID")).attributeValue("value")).intValue();
/* 278 */       this.ARRESTED_MAIL_ID = Integer.valueOf(((Element)data.get("ARRESTED_MAIL_ID")).attributeValue("value")).intValue();
/* 279 */       this.JAIL_OUT_MAIL_ID = Integer.valueOf(((Element)data.get("JAIL_OUT_MAIL_ID")).attributeValue("value")).intValue();
/* 280 */       this.JAIL_BREAK_MAIL_ID = Integer.valueOf(((Element)data.get("JAIL_BREAK_MAIL_ID")).attributeValue("value")).intValue();
/* 281 */       this.JAIL_DELIVERY_MAIL_ID = Integer.valueOf(((Element)data.get("JAIL_DELIVERY_MAIL_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 285 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 289 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 292 */     String path = dir + "mzm.gsp.pk.confbean.SPKConsts.bny";
/*     */     try
/*     */     {
/* 295 */       File file = new File(path);
/* 296 */       if (file.exists())
/*     */       {
/* 298 */         byte[] bytes = new byte['Ѐ'];
/* 299 */         FileInputStream fis = new FileInputStream(file);
/* 300 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 301 */         int len = 0;
/* 302 */         while ((len = fis.read(bytes)) > 0)
/* 303 */           baos.write(bytes, 0, len);
/* 304 */         fis.close();
/* 305 */         bytes = baos.toByteArray();
/* 306 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 307 */         this.ENABLE_PK_MONEY_TYPE = _os_.unmarshal_int();
/* 308 */         this.ENABLE_PK_PRICE = _os_.unmarshal_int();
/* 309 */         this.ENABLE_PK_LEVEL = _os_.unmarshal_int();
/* 310 */         this.PK_MINUTES = _os_.unmarshal_int();
/* 311 */         this.MAX_PK_TIMES_PER_DAY = _os_.unmarshal_int();
/* 312 */         this.PK_DEATH_PROTECTION_MINUTES = _os_.unmarshal_int();
/* 313 */         this.MAX_PK_DEATH_TIMES_PER_DAY = _os_.unmarshal_int();
/* 314 */         this.PK_FORCE_PROTECTION_MINUTES = _os_.unmarshal_int();
/* 315 */         this.PK_DEATH_EQUIPMENT_PENALTY = _os_.unmarshal_int();
/* 316 */         this.PK_MAX_DISTANCE = _os_.unmarshal_int();
/* 317 */         this.TEAM_PK_CONFIRM_SECONDS = _os_.unmarshal_int();
/* 318 */         this.INITIAL_MORAL_VALUE = _os_.unmarshal_int();
/* 319 */         this.ENABLE_PK_MORAL_VALUE = _os_.unmarshal_int();
/* 320 */         this.WANTED_MORAL_VALUE = _os_.unmarshal_int();
/* 321 */         this.LEAVE_PRISON_MORAL_VALUE = _os_.unmarshal_int();
/* 322 */         this.PK_MORAL_VALUE_REDUCE_FACTOR_A = _os_.unmarshal_int();
/* 323 */         this.PK_MORAL_VALUE_REDUCE_FACTOR_B = _os_.unmarshal_int();
/* 324 */         this.MORAL_VALUE_MONEY_TYPE = _os_.unmarshal_int();
/* 325 */         this.MORAL_TASK_ACTIVITY_ID = _os_.unmarshal_int();
/* 326 */         this.MORAL_TASK_GRAPH_ID = _os_.unmarshal_int();
/* 327 */         this.MORAL_TASK_AWARD_ID = _os_.unmarshal_int();
/* 328 */         this.REVENGE_ITEM_TRANSFER_CONFIRM_SECONDS = _os_.unmarshal_int();
/* 329 */         this.ARREST_MONEY_TYPE = _os_.unmarshal_int();
/* 330 */         this.ARREST_PRICE = _os_.unmarshal_int();
/* 331 */         this.ARREST_LEVEL_DIFF = _os_.unmarshal_int();
/* 332 */         this.ARREST_REWARD_ID = _os_.unmarshal_int();
/* 333 */         this.ARREST_MAX_COUNT = _os_.unmarshal_int();
/* 334 */         this.NPC_ARREST_MINUTES = _os_.unmarshal_int();
/* 335 */         this.NPC_ARREST_INTERVAL_MINUTES = _os_.unmarshal_int();
/* 336 */         this.NPC_ARREST_FIGHT_ID_1 = _os_.unmarshal_int();
/* 337 */         this.NPC_ARREST_FIGHT_ID_2 = _os_.unmarshal_int();
/* 338 */         this.WANTED_ARREST_DEATH_EQUIPMENT_PENALTY = _os_.unmarshal_int();
/* 339 */         this.NON_WANTED_ARREST_DEATH_EQUIPMENT_PENALTY = _os_.unmarshal_int();
/* 340 */         this.WANTED_RECORD_COUNT_PER_PAGE = _os_.unmarshal_int();
/* 341 */         this.WANTED_AWARD_MAX_COUNT_PER_DAY = _os_.unmarshal_int();
/* 342 */         this.PRISON_MAP_ID = _os_.unmarshal_int();
/* 343 */         this.WANTED_ENTER_PRISON_MAP_X = _os_.unmarshal_int();
/* 344 */         this.WANTED_ENTER_PRISON_MAP_Y = _os_.unmarshal_int();
/* 345 */         this.NON_WANTED_ENTER_PRISON_MAP_X = _os_.unmarshal_int();
/* 346 */         this.NON_WANTED_ENTER_PRISON_MAP_Y = _os_.unmarshal_int();
/* 347 */         this.LEAVE_PRISON_MAP_ID = _os_.unmarshal_int();
/* 348 */         this.PRISON_SERVE_MINUTES = _os_.unmarshal_int();
/* 349 */         this.LEAVE_PRISON_FORBIDDEN_PK_MINUTES = _os_.unmarshal_int();
/* 350 */         this.PRISON_BREAK_MONEY_TYPE = _os_.unmarshal_int();
/* 351 */         this.PRISON_BREAK_PRICE = _os_.unmarshal_int();
/* 352 */         this.PRISON_RECORD_COUNT_PER_PAGE = _os_.unmarshal_int();
/* 353 */         this.JAIL_BREAK_PVE_FIGHT_ID = _os_.unmarshal_int();
/* 354 */         this.JAIL_DELIVERY_PVE_FIGHT_ID = _os_.unmarshal_int();
/* 355 */         this.MALE_PRISON_BUFF_ID = _os_.unmarshal_int();
/* 356 */         this.FEMALE_PRISON_BUFF_ID = _os_.unmarshal_int();
/* 357 */         this.PK_NPC_ID = _os_.unmarshal_int();
/* 358 */         this.MORAL_VALUE_NPC_ID = _os_.unmarshal_int();
/* 359 */         this.WANTED_NPC_ID = _os_.unmarshal_int();
/* 360 */         this.ARREST_SERVICE_ID = _os_.unmarshal_int();
/* 361 */         this.VISIT_PRISON_SERVICE_ID = _os_.unmarshal_int();
/* 362 */         this.RESCUE_NPC_ID = _os_.unmarshal_int();
/* 363 */         this.RESCUE_SERVICE_ID = _os_.unmarshal_int();
/* 364 */         this.RETURN_SERVICE_ID = _os_.unmarshal_int();
/* 365 */         this.PRISON_BREAK_NPC_ID = _os_.unmarshal_int();
/* 366 */         this.PRISON_BREAK_SERVICE_ID = _os_.unmarshal_int();
/* 367 */         this.PRISON_SERVE_TIME_SERVICE_ID = _os_.unmarshal_int();
/* 368 */         this.ARRESTED_MAIL_ID = _os_.unmarshal_int();
/* 369 */         this.JAIL_OUT_MAIL_ID = _os_.unmarshal_int();
/* 370 */         this.JAIL_BREAK_MAIL_ID = _os_.unmarshal_int();
/* 371 */         this.JAIL_DELIVERY_MAIL_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 376 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 382 */     String path = dir + "mzm.gsp.pk.confbean.SPKConsts.bny";
/*     */     try
/*     */     {
/* 385 */       File file = new File(path);
/* 386 */       if (file.exists())
/*     */       {
/* 388 */         byte[] bytes = new byte['Ѐ'];
/* 389 */         FileInputStream fis = new FileInputStream(file);
/* 390 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 391 */         int len = 0;
/* 392 */         while ((len = fis.read(bytes)) > 0)
/* 393 */           baos.write(bytes, 0, len);
/* 394 */         fis.close();
/* 395 */         bytes = baos.toByteArray();
/* 396 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 397 */         this.ENABLE_PK_MONEY_TYPE = _os_.unmarshal_int();
/* 398 */         this.ENABLE_PK_PRICE = _os_.unmarshal_int();
/* 399 */         this.ENABLE_PK_LEVEL = _os_.unmarshal_int();
/* 400 */         this.PK_MINUTES = _os_.unmarshal_int();
/* 401 */         this.MAX_PK_TIMES_PER_DAY = _os_.unmarshal_int();
/* 402 */         this.PK_DEATH_PROTECTION_MINUTES = _os_.unmarshal_int();
/* 403 */         this.MAX_PK_DEATH_TIMES_PER_DAY = _os_.unmarshal_int();
/* 404 */         this.PK_FORCE_PROTECTION_MINUTES = _os_.unmarshal_int();
/* 405 */         this.PK_DEATH_EQUIPMENT_PENALTY = _os_.unmarshal_int();
/* 406 */         this.PK_MAX_DISTANCE = _os_.unmarshal_int();
/* 407 */         this.TEAM_PK_CONFIRM_SECONDS = _os_.unmarshal_int();
/* 408 */         this.INITIAL_MORAL_VALUE = _os_.unmarshal_int();
/* 409 */         this.ENABLE_PK_MORAL_VALUE = _os_.unmarshal_int();
/* 410 */         this.WANTED_MORAL_VALUE = _os_.unmarshal_int();
/* 411 */         this.LEAVE_PRISON_MORAL_VALUE = _os_.unmarshal_int();
/* 412 */         this.PK_MORAL_VALUE_REDUCE_FACTOR_A = _os_.unmarshal_int();
/* 413 */         this.PK_MORAL_VALUE_REDUCE_FACTOR_B = _os_.unmarshal_int();
/* 414 */         this.MORAL_VALUE_MONEY_TYPE = _os_.unmarshal_int();
/* 415 */         this.MORAL_TASK_ACTIVITY_ID = _os_.unmarshal_int();
/* 416 */         this.MORAL_TASK_GRAPH_ID = _os_.unmarshal_int();
/* 417 */         this.MORAL_TASK_AWARD_ID = _os_.unmarshal_int();
/* 418 */         this.REVENGE_ITEM_TRANSFER_CONFIRM_SECONDS = _os_.unmarshal_int();
/* 419 */         this.ARREST_MONEY_TYPE = _os_.unmarshal_int();
/* 420 */         this.ARREST_PRICE = _os_.unmarshal_int();
/* 421 */         this.ARREST_LEVEL_DIFF = _os_.unmarshal_int();
/* 422 */         this.ARREST_REWARD_ID = _os_.unmarshal_int();
/* 423 */         this.ARREST_MAX_COUNT = _os_.unmarshal_int();
/* 424 */         this.NPC_ARREST_MINUTES = _os_.unmarshal_int();
/* 425 */         this.NPC_ARREST_INTERVAL_MINUTES = _os_.unmarshal_int();
/* 426 */         this.NPC_ARREST_FIGHT_ID_1 = _os_.unmarshal_int();
/* 427 */         this.NPC_ARREST_FIGHT_ID_2 = _os_.unmarshal_int();
/* 428 */         this.WANTED_ARREST_DEATH_EQUIPMENT_PENALTY = _os_.unmarshal_int();
/* 429 */         this.NON_WANTED_ARREST_DEATH_EQUIPMENT_PENALTY = _os_.unmarshal_int();
/* 430 */         this.WANTED_RECORD_COUNT_PER_PAGE = _os_.unmarshal_int();
/* 431 */         this.WANTED_AWARD_MAX_COUNT_PER_DAY = _os_.unmarshal_int();
/* 432 */         this.PRISON_MAP_ID = _os_.unmarshal_int();
/* 433 */         this.WANTED_ENTER_PRISON_MAP_X = _os_.unmarshal_int();
/* 434 */         this.WANTED_ENTER_PRISON_MAP_Y = _os_.unmarshal_int();
/* 435 */         this.NON_WANTED_ENTER_PRISON_MAP_X = _os_.unmarshal_int();
/* 436 */         this.NON_WANTED_ENTER_PRISON_MAP_Y = _os_.unmarshal_int();
/* 437 */         this.LEAVE_PRISON_MAP_ID = _os_.unmarshal_int();
/* 438 */         this.PRISON_SERVE_MINUTES = _os_.unmarshal_int();
/* 439 */         this.LEAVE_PRISON_FORBIDDEN_PK_MINUTES = _os_.unmarshal_int();
/* 440 */         this.PRISON_BREAK_MONEY_TYPE = _os_.unmarshal_int();
/* 441 */         this.PRISON_BREAK_PRICE = _os_.unmarshal_int();
/* 442 */         this.PRISON_RECORD_COUNT_PER_PAGE = _os_.unmarshal_int();
/* 443 */         this.JAIL_BREAK_PVE_FIGHT_ID = _os_.unmarshal_int();
/* 444 */         this.JAIL_DELIVERY_PVE_FIGHT_ID = _os_.unmarshal_int();
/* 445 */         this.MALE_PRISON_BUFF_ID = _os_.unmarshal_int();
/* 446 */         this.FEMALE_PRISON_BUFF_ID = _os_.unmarshal_int();
/* 447 */         this.PK_NPC_ID = _os_.unmarshal_int();
/* 448 */         this.MORAL_VALUE_NPC_ID = _os_.unmarshal_int();
/* 449 */         this.WANTED_NPC_ID = _os_.unmarshal_int();
/* 450 */         this.ARREST_SERVICE_ID = _os_.unmarshal_int();
/* 451 */         this.VISIT_PRISON_SERVICE_ID = _os_.unmarshal_int();
/* 452 */         this.RESCUE_NPC_ID = _os_.unmarshal_int();
/* 453 */         this.RESCUE_SERVICE_ID = _os_.unmarshal_int();
/* 454 */         this.RETURN_SERVICE_ID = _os_.unmarshal_int();
/* 455 */         this.PRISON_BREAK_NPC_ID = _os_.unmarshal_int();
/* 456 */         this.PRISON_BREAK_SERVICE_ID = _os_.unmarshal_int();
/* 457 */         this.PRISON_SERVE_TIME_SERVICE_ID = _os_.unmarshal_int();
/* 458 */         this.ARRESTED_MAIL_ID = _os_.unmarshal_int();
/* 459 */         this.JAIL_OUT_MAIL_ID = _os_.unmarshal_int();
/* 460 */         this.JAIL_BREAK_MAIL_ID = _os_.unmarshal_int();
/* 461 */         this.JAIL_DELIVERY_MAIL_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 466 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SPKConsts newInstance)
/*     */   {
/* 472 */     oldInstance = instance;
/* 473 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 478 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\confbean\SPKConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */