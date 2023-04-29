/*     */ package mzm.gsp.pet.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Document;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ 
/*     */ public class PetConstants
/*     */ {
/*  19 */   private static volatile PetConstants oldInstance = null;
/*  20 */   private static PetConstants instance = new PetConstants();
/*     */   public int PET_MAX_LEVEL;
/*     */   public int PET_MIN_LEVEL;
/*     */   public int ADD_POTENTIAL_PER_LEVEL;
/*     */   public int PET_MAX_LIFE;
/*     */   public int CAN_FANSHENG_MAX_LEVEL;
/*     */   public int PET_SHELF_SKILL_NUM_LIMIT;
/*     */   public int PET_DECORATE_ITEM_TYPE;
/*     */   public int PET_CAN_EQUIP_LEVEL;
/*     */   public int HUASHENG_ITEM_TYPE;
/*     */   public int PET_DUANGU_ITEM_TYPE;
/*     */   public int PET_PUTTONG_FANSHENG_ITEM_TYPE;
/*     */   public int PET_GAOJI_FANSHENG_ITEM_TYPE;
/*     */   public int PET_JOIN_FIGHT_MIN_LIFE;
/*     */   public int PET_AFTERFIGHT_DIE_REDUCE_LIFE;
/*     */   public int PET_AFTERFIGHT_LIVE_REDUCE_LIFE;
/*     */   public int PET_STUDY_SKILL_MAX_LEVEL;
/*     */   public int PET_STUDY_SKILL_NUM_LIMIT;
/*     */   public int LEARN_SKILLBOOK_SKILL_NUM_LIMIT;
/*     */   public int PET_UNREMEMBER_SKILL_COST_SILVER;
/*     */   public int PET_LEVEL_MORE_THAN_OWNER_LIMIT;
/*     */   public int PET_HAVE_0_SKILL_STUDY_PROP;
/*     */   public int PET_HAVE_1_SKILL_STUDY_PROP;
/*     */   public int PET_HAVE_2_SKILL_STUDY_PROP;
/*     */   public int PET_HAVE_3_SKILL_STUDY_PROP;
/*     */   public int PET_1_SKILL_LEARN_BOOK_REPLACE_PROP;
/*     */   public int PET_2_SKILL_LEARN_BOOK_REPLACE_PROP;
/*     */   public int PET_3_SKILL_LEARN_BOOK_REPLACE_PROP;
/*     */   public int PET_MORE_THAN_2_SKILL_LEARN_BOOK_REPLACE_PROP;
/*     */   public double ADD_STR_PER_LEVEL;
/*     */   public double ADD_DEX_PER_LEVEL;
/*     */   public double ADD_SPR_PER_LEVEL;
/*     */   public double ADD_STA_PER_LEVEL;
/*     */   public double ADD_CON_PER_LEVEL;
/*     */   public int PET_DECORATE_ITEM_ID;
/*     */   public int PET_RESET_PROP_ITEM_ID;
/*     */   public int PET_HUASHENG_ITEM_ID;
/*     */   public int PET_LIANGU_ITEM_ID;
/*     */   public int PET_REMEBER_SKILL_ITEM_ID;
/*     */   public int PET_PUTONG_FANSHENGDAN_ID;
/*     */   public int PET_GAOJI_FANSHENGDAN_ID;
/*     */   public int NORMAL_ATTACK_SKILLID;
/*     */   public int NORMAL_DEFENCE_SKILLID;
/*     */   public int PET_SKILLBOOK_GET_METHOD;
/*     */   public int PETSHOP_NPC_ID;
/*     */   public int ADD_LIFE_TIPS_LIMIT;
/*     */   public int FIX_SCORE;
/*     */   public int GROW_FACTOR;
/*     */   public int MINGJI_TIPS;
/*     */   public int LEAN_SKILL_TIPS;
/*     */   public int FANSHENG_TIPS;
/*     */   public int GOLD_PET_REDEEM_NPCID;
/*     */   public int MOSHOU_PET_REDEEM_NPCID;
/*     */   public int PET_BAG_FUWU_ID;
/*     */   public int PET_FREE_FUWU_ID;
/*     */   public int PET_FREE_REWARD_LEVEL;
/*     */   public int PET_FREE_REWARD_RANGE;
/*     */   public int PET_FREE_REWARD_ITEMID;
/*     */   public int PET_FREE_REWARD_EMAILID;
/*     */   public int PET_APT_BASE_VALUE;
/*     */   public int PET_APT_BASE_RATE;
/*     */   public int PET_APT_SHOW_RATE;
/*     */   public int PET_HUASHENG_OPEN_LEVEL;
/*     */   public int PET_HUASHENG_LEVEL_DIFFER;
/*     */   public int PET_HUASHENG_X_SKILL_BULLETIN;
/*     */   public int PET_NEW_SKILL_MAIL;
/*     */   public int PET_SKILL_LEVELUP_MAIL;
/*     */   public int PET_REPLACE_SKILL_LEVELLIMIT;
/*     */   public int PET_MAX_STAGE;
/*     */   public int CANCEL_PET_CHANGEMODEL_ITEM_ID;
/*     */   public int CANCEL_PET_CHANGEMODEL_ITEM_COST_NUM;
/*     */   public int MIN_PET_NAME_LEN;
/*     */   public int MAX_PET_NAME_LEN;
/*     */   public int hua_sheng_minimum_guarantee_special_effect_id;
/*     */   public int hua_sheng_low_minimum_guarantee_item_id;
/*     */   public int hua_sheng_hign_minimum_guarantee_item_id;
/*     */   public int PET_SOUL_MAX_LEVEL;
/*     */   public int soul_random_property_main_item;
/*     */   public int soul_random_property_sub_item;
/*     */   public int soul_random_property_item_count;
/*     */   public int PET_SOUL_EXCHANGE_MAIN_ITEM;
/*     */   public int PET_SOUL_EXCHANGE_SUM_ITEM;
/*     */   public int PET_SOUL_EXCHANGE_ITEM_COUNT;
/*     */   public int PET_SOUL_UPGRADE_TIP;
/*     */   public int PET_SOUL_EXCHANGE_TIP;
/*     */   public int PET_SOUL_EXCHANGE_EFFECT_ID;
/*     */   public int PET_SOUL_EXCHANGE_DETAIL_TIP;
/*     */   public int RATIO_BISIC_PROP;
/*     */   public int CONST_APT;
/*     */   public int RATIO_APT;
/*     */   public int CONST_GROW;
/*     */   public int RATIO_GROW;
/*     */   public int PET_SOUL_OPEN_ROLE_LEVEL;
/*     */   public int OWN_MAX_EXTRA_MODEL_NUM;
/* 114 */   public List<RemmberSkill> PET_REMBER_SKILL_ITEM_IDS = new ArrayList();
/*     */   
/*     */   public static PetConstants getOldInstance() {
/* 117 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static PetConstants getInstance() {
/* 121 */     return instance;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir) {
/* 125 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir) {
/* 129 */     String path = dir + "mzm.gsp.pet.confbean.PetConstants.xml";
/*     */     try {
/* 131 */       SAXReader reader = new SAXReader();
/* 132 */       Document doc = reader.read(new File(path));
/* 133 */       Element root = doc.getRootElement();
/* 134 */       Map<String, Element> data = new HashMap();
/* 135 */       List<?> nodeList = root.elements();
/* 136 */       int len = nodeList.size();
/* 137 */       for (int i = 0; i < len; i++) {
/* 138 */         Element element = (Element)nodeList.get(i);
/* 139 */         if (element.getName().equalsIgnoreCase("row")) {
/* 140 */           String name = element.attributeValue("name");
/* 141 */           if (data.put(name, element) != null) {
/* 142 */             throw new RuntimeException("duplicate const : " + name);
/*     */           }
/*     */         }
/*     */       }
/* 146 */       this.PET_MAX_LEVEL = Integer.valueOf(((Element)data.get("PET_MAX_LEVEL")).attributeValue("value")).intValue();
/* 147 */       this.PET_MIN_LEVEL = Integer.valueOf(((Element)data.get("PET_MIN_LEVEL")).attributeValue("value")).intValue();
/* 148 */       this.ADD_POTENTIAL_PER_LEVEL = Integer.valueOf(((Element)data.get("ADD_POTENTIAL_PER_LEVEL")).attributeValue("value")).intValue();
/* 149 */       this.PET_MAX_LIFE = Integer.valueOf(((Element)data.get("PET_MAX_LIFE")).attributeValue("value")).intValue();
/* 150 */       this.CAN_FANSHENG_MAX_LEVEL = Integer.valueOf(((Element)data.get("CAN_FANSHENG_MAX_LEVEL")).attributeValue("value")).intValue();
/* 151 */       this.PET_SHELF_SKILL_NUM_LIMIT = Integer.valueOf(((Element)data.get("PET_SHELF_SKILL_NUM_LIMIT")).attributeValue("value")).intValue();
/* 152 */       this.PET_DECORATE_ITEM_TYPE = Integer.valueOf(((Element)data.get("PET_DECORATE_ITEM_TYPE")).attributeValue("value")).intValue();
/* 153 */       this.PET_CAN_EQUIP_LEVEL = Integer.valueOf(((Element)data.get("PET_CAN_EQUIP_LEVEL")).attributeValue("value")).intValue();
/* 154 */       this.HUASHENG_ITEM_TYPE = Integer.valueOf(((Element)data.get("HUASHENG_ITEM_TYPE")).attributeValue("value")).intValue();
/* 155 */       this.PET_DUANGU_ITEM_TYPE = Integer.valueOf(((Element)data.get("PET_DUANGU_ITEM_TYPE")).attributeValue("value")).intValue();
/* 156 */       this.PET_PUTTONG_FANSHENG_ITEM_TYPE = Integer.valueOf(((Element)data.get("PET_PUTTONG_FANSHENG_ITEM_TYPE")).attributeValue("value")).intValue();
/* 157 */       this.PET_GAOJI_FANSHENG_ITEM_TYPE = Integer.valueOf(((Element)data.get("PET_GAOJI_FANSHENG_ITEM_TYPE")).attributeValue("value")).intValue();
/* 158 */       this.PET_JOIN_FIGHT_MIN_LIFE = Integer.valueOf(((Element)data.get("PET_JOIN_FIGHT_MIN_LIFE")).attributeValue("value")).intValue();
/* 159 */       this.PET_AFTERFIGHT_DIE_REDUCE_LIFE = Integer.valueOf(((Element)data.get("PET_AFTERFIGHT_DIE_REDUCE_LIFE")).attributeValue("value")).intValue();
/* 160 */       this.PET_AFTERFIGHT_LIVE_REDUCE_LIFE = Integer.valueOf(((Element)data.get("PET_AFTERFIGHT_LIVE_REDUCE_LIFE")).attributeValue("value")).intValue();
/* 161 */       this.PET_STUDY_SKILL_MAX_LEVEL = Integer.valueOf(((Element)data.get("PET_STUDY_SKILL_MAX_LEVEL")).attributeValue("value")).intValue();
/* 162 */       this.PET_STUDY_SKILL_NUM_LIMIT = Integer.valueOf(((Element)data.get("PET_STUDY_SKILL_NUM_LIMIT")).attributeValue("value")).intValue();
/* 163 */       this.LEARN_SKILLBOOK_SKILL_NUM_LIMIT = Integer.valueOf(((Element)data.get("LEARN_SKILLBOOK_SKILL_NUM_LIMIT")).attributeValue("value")).intValue();
/* 164 */       this.PET_UNREMEMBER_SKILL_COST_SILVER = Integer.valueOf(((Element)data.get("PET_UNREMEMBER_SKILL_COST_SILVER")).attributeValue("value")).intValue();
/* 165 */       this.PET_LEVEL_MORE_THAN_OWNER_LIMIT = Integer.valueOf(((Element)data.get("PET_LEVEL_MORE_THAN_OWNER_LIMIT")).attributeValue("value")).intValue();
/* 166 */       this.PET_HAVE_0_SKILL_STUDY_PROP = Integer.valueOf(((Element)data.get("PET_HAVE_0_SKILL_STUDY_PROP")).attributeValue("value")).intValue();
/* 167 */       this.PET_HAVE_1_SKILL_STUDY_PROP = Integer.valueOf(((Element)data.get("PET_HAVE_1_SKILL_STUDY_PROP")).attributeValue("value")).intValue();
/* 168 */       this.PET_HAVE_2_SKILL_STUDY_PROP = Integer.valueOf(((Element)data.get("PET_HAVE_2_SKILL_STUDY_PROP")).attributeValue("value")).intValue();
/* 169 */       this.PET_HAVE_3_SKILL_STUDY_PROP = Integer.valueOf(((Element)data.get("PET_HAVE_3_SKILL_STUDY_PROP")).attributeValue("value")).intValue();
/* 170 */       this.PET_1_SKILL_LEARN_BOOK_REPLACE_PROP = Integer.valueOf(((Element)data.get("PET_1_SKILL_LEARN_BOOK_REPLACE_PROP")).attributeValue("value")).intValue();
/* 171 */       this.PET_2_SKILL_LEARN_BOOK_REPLACE_PROP = Integer.valueOf(((Element)data.get("PET_2_SKILL_LEARN_BOOK_REPLACE_PROP")).attributeValue("value")).intValue();
/* 172 */       this.PET_3_SKILL_LEARN_BOOK_REPLACE_PROP = Integer.valueOf(((Element)data.get("PET_3_SKILL_LEARN_BOOK_REPLACE_PROP")).attributeValue("value")).intValue();
/* 173 */       this.PET_MORE_THAN_2_SKILL_LEARN_BOOK_REPLACE_PROP = Integer.valueOf(((Element)data.get("PET_MORE_THAN_2_SKILL_LEARN_BOOK_REPLACE_PROP")).attributeValue("value")).intValue();
/* 174 */       this.ADD_STR_PER_LEVEL = Double.valueOf(((Element)data.get("ADD_STR_PER_LEVEL")).attributeValue("value")).doubleValue();
/* 175 */       this.ADD_DEX_PER_LEVEL = Double.valueOf(((Element)data.get("ADD_DEX_PER_LEVEL")).attributeValue("value")).doubleValue();
/* 176 */       this.ADD_SPR_PER_LEVEL = Double.valueOf(((Element)data.get("ADD_SPR_PER_LEVEL")).attributeValue("value")).doubleValue();
/* 177 */       this.ADD_STA_PER_LEVEL = Double.valueOf(((Element)data.get("ADD_STA_PER_LEVEL")).attributeValue("value")).doubleValue();
/* 178 */       this.ADD_CON_PER_LEVEL = Double.valueOf(((Element)data.get("ADD_CON_PER_LEVEL")).attributeValue("value")).doubleValue();
/* 179 */       this.PET_DECORATE_ITEM_ID = Integer.valueOf(((Element)data.get("PET_DECORATE_ITEM_ID")).attributeValue("value")).intValue();
/* 180 */       this.PET_RESET_PROP_ITEM_ID = Integer.valueOf(((Element)data.get("PET_RESET_PROP_ITEM_ID")).attributeValue("value")).intValue();
/* 181 */       this.PET_HUASHENG_ITEM_ID = Integer.valueOf(((Element)data.get("PET_HUASHENG_ITEM_ID")).attributeValue("value")).intValue();
/* 182 */       this.PET_LIANGU_ITEM_ID = Integer.valueOf(((Element)data.get("PET_LIANGU_ITEM_ID")).attributeValue("value")).intValue();
/* 183 */       this.PET_REMEBER_SKILL_ITEM_ID = Integer.valueOf(((Element)data.get("PET_REMEBER_SKILL_ITEM_ID")).attributeValue("value")).intValue();
/* 184 */       this.PET_PUTONG_FANSHENGDAN_ID = Integer.valueOf(((Element)data.get("PET_PUTONG_FANSHENGDAN_ID")).attributeValue("value")).intValue();
/* 185 */       this.PET_GAOJI_FANSHENGDAN_ID = Integer.valueOf(((Element)data.get("PET_GAOJI_FANSHENGDAN_ID")).attributeValue("value")).intValue();
/* 186 */       this.NORMAL_ATTACK_SKILLID = Integer.valueOf(((Element)data.get("NORMAL_ATTACK_SKILLID")).attributeValue("value")).intValue();
/* 187 */       this.NORMAL_DEFENCE_SKILLID = Integer.valueOf(((Element)data.get("NORMAL_DEFENCE_SKILLID")).attributeValue("value")).intValue();
/* 188 */       this.PET_SKILLBOOK_GET_METHOD = Integer.valueOf(((Element)data.get("PET_SKILLBOOK_GET_METHOD")).attributeValue("value")).intValue();
/* 189 */       this.PETSHOP_NPC_ID = Integer.valueOf(((Element)data.get("PETSHOP_NPC_ID")).attributeValue("value")).intValue();
/* 190 */       this.ADD_LIFE_TIPS_LIMIT = Integer.valueOf(((Element)data.get("ADD_LIFE_TIPS_LIMIT")).attributeValue("value")).intValue();
/* 191 */       this.FIX_SCORE = Integer.valueOf(((Element)data.get("FIX_SCORE")).attributeValue("value")).intValue();
/* 192 */       this.GROW_FACTOR = Integer.valueOf(((Element)data.get("GROW_FACTOR")).attributeValue("value")).intValue();
/* 193 */       this.MINGJI_TIPS = Integer.valueOf(((Element)data.get("MINGJI_TIPS")).attributeValue("value")).intValue();
/* 194 */       this.LEAN_SKILL_TIPS = Integer.valueOf(((Element)data.get("LEAN_SKILL_TIPS")).attributeValue("value")).intValue();
/* 195 */       this.FANSHENG_TIPS = Integer.valueOf(((Element)data.get("FANSHENG_TIPS")).attributeValue("value")).intValue();
/* 196 */       this.GOLD_PET_REDEEM_NPCID = Integer.valueOf(((Element)data.get("GOLD_PET_REDEEM_NPCID")).attributeValue("value")).intValue();
/* 197 */       this.MOSHOU_PET_REDEEM_NPCID = Integer.valueOf(((Element)data.get("MOSHOU_PET_REDEEM_NPCID")).attributeValue("value")).intValue();
/* 198 */       this.PET_BAG_FUWU_ID = Integer.valueOf(((Element)data.get("PET_BAG_FUWU_ID")).attributeValue("value")).intValue();
/* 199 */       this.PET_FREE_FUWU_ID = Integer.valueOf(((Element)data.get("PET_FREE_FUWU_ID")).attributeValue("value")).intValue();
/* 200 */       this.PET_FREE_REWARD_LEVEL = Integer.valueOf(((Element)data.get("PET_FREE_REWARD_LEVEL")).attributeValue("value")).intValue();
/* 201 */       this.PET_FREE_REWARD_RANGE = Integer.valueOf(((Element)data.get("PET_FREE_REWARD_RANGE")).attributeValue("value")).intValue();
/* 202 */       this.PET_FREE_REWARD_ITEMID = Integer.valueOf(((Element)data.get("PET_FREE_REWARD_ITEMID")).attributeValue("value")).intValue();
/* 203 */       this.PET_FREE_REWARD_EMAILID = Integer.valueOf(((Element)data.get("PET_FREE_REWARD_EMAILID")).attributeValue("value")).intValue();
/* 204 */       this.PET_APT_BASE_VALUE = Integer.valueOf(((Element)data.get("PET_APT_BASE_VALUE")).attributeValue("value")).intValue();
/* 205 */       this.PET_APT_BASE_RATE = Integer.valueOf(((Element)data.get("PET_APT_BASE_RATE")).attributeValue("value")).intValue();
/* 206 */       this.PET_APT_SHOW_RATE = Integer.valueOf(((Element)data.get("PET_APT_SHOW_RATE")).attributeValue("value")).intValue();
/* 207 */       this.PET_HUASHENG_OPEN_LEVEL = Integer.valueOf(((Element)data.get("PET_HUASHENG_OPEN_LEVEL")).attributeValue("value")).intValue();
/* 208 */       this.PET_HUASHENG_LEVEL_DIFFER = Integer.valueOf(((Element)data.get("PET_HUASHENG_LEVEL_DIFFER")).attributeValue("value")).intValue();
/* 209 */       this.PET_HUASHENG_X_SKILL_BULLETIN = Integer.valueOf(((Element)data.get("PET_HUASHENG_X_SKILL_BULLETIN")).attributeValue("value")).intValue();
/* 210 */       this.PET_NEW_SKILL_MAIL = Integer.valueOf(((Element)data.get("PET_NEW_SKILL_MAIL")).attributeValue("value")).intValue();
/* 211 */       this.PET_SKILL_LEVELUP_MAIL = Integer.valueOf(((Element)data.get("PET_SKILL_LEVELUP_MAIL")).attributeValue("value")).intValue();
/* 212 */       this.PET_REPLACE_SKILL_LEVELLIMIT = Integer.valueOf(((Element)data.get("PET_REPLACE_SKILL_LEVELLIMIT")).attributeValue("value")).intValue();
/* 213 */       this.PET_MAX_STAGE = Integer.valueOf(((Element)data.get("PET_MAX_STAGE")).attributeValue("value")).intValue();
/* 214 */       this.CANCEL_PET_CHANGEMODEL_ITEM_ID = Integer.valueOf(((Element)data.get("CANCEL_PET_CHANGEMODEL_ITEM_ID")).attributeValue("value")).intValue();
/* 215 */       this.CANCEL_PET_CHANGEMODEL_ITEM_COST_NUM = Integer.valueOf(((Element)data.get("CANCEL_PET_CHANGEMODEL_ITEM_COST_NUM")).attributeValue("value")).intValue();
/* 216 */       this.MIN_PET_NAME_LEN = Integer.valueOf(((Element)data.get("MIN_PET_NAME_LEN")).attributeValue("value")).intValue();
/* 217 */       this.MAX_PET_NAME_LEN = Integer.valueOf(((Element)data.get("MAX_PET_NAME_LEN")).attributeValue("value")).intValue();
/* 218 */       this.hua_sheng_minimum_guarantee_special_effect_id = Integer.valueOf(((Element)data.get("hua_sheng_minimum_guarantee_special_effect_id")).attributeValue("value")).intValue();
/* 219 */       this.hua_sheng_low_minimum_guarantee_item_id = Integer.valueOf(((Element)data.get("hua_sheng_low_minimum_guarantee_item_id")).attributeValue("value")).intValue();
/* 220 */       this.hua_sheng_hign_minimum_guarantee_item_id = Integer.valueOf(((Element)data.get("hua_sheng_hign_minimum_guarantee_item_id")).attributeValue("value")).intValue();
/* 221 */       this.PET_SOUL_MAX_LEVEL = Integer.valueOf(((Element)data.get("PET_SOUL_MAX_LEVEL")).attributeValue("value")).intValue();
/* 222 */       this.soul_random_property_main_item = Integer.valueOf(((Element)data.get("soul_random_property_main_item")).attributeValue("value")).intValue();
/* 223 */       this.soul_random_property_sub_item = Integer.valueOf(((Element)data.get("soul_random_property_sub_item")).attributeValue("value")).intValue();
/* 224 */       this.soul_random_property_item_count = Integer.valueOf(((Element)data.get("soul_random_property_item_count")).attributeValue("value")).intValue();
/* 225 */       this.PET_SOUL_EXCHANGE_MAIN_ITEM = Integer.valueOf(((Element)data.get("PET_SOUL_EXCHANGE_MAIN_ITEM")).attributeValue("value")).intValue();
/* 226 */       this.PET_SOUL_EXCHANGE_SUM_ITEM = Integer.valueOf(((Element)data.get("PET_SOUL_EXCHANGE_SUM_ITEM")).attributeValue("value")).intValue();
/* 227 */       this.PET_SOUL_EXCHANGE_ITEM_COUNT = Integer.valueOf(((Element)data.get("PET_SOUL_EXCHANGE_ITEM_COUNT")).attributeValue("value")).intValue();
/* 228 */       this.PET_SOUL_UPGRADE_TIP = Integer.valueOf(((Element)data.get("PET_SOUL_UPGRADE_TIP")).attributeValue("value")).intValue();
/* 229 */       this.PET_SOUL_EXCHANGE_TIP = Integer.valueOf(((Element)data.get("PET_SOUL_EXCHANGE_TIP")).attributeValue("value")).intValue();
/* 230 */       this.PET_SOUL_EXCHANGE_EFFECT_ID = Integer.valueOf(((Element)data.get("PET_SOUL_EXCHANGE_EFFECT_ID")).attributeValue("value")).intValue();
/* 231 */       this.PET_SOUL_EXCHANGE_DETAIL_TIP = Integer.valueOf(((Element)data.get("PET_SOUL_EXCHANGE_DETAIL_TIP")).attributeValue("value")).intValue();
/* 232 */       this.RATIO_BISIC_PROP = Integer.valueOf(((Element)data.get("RATIO_BISIC_PROP")).attributeValue("value")).intValue();
/* 233 */       this.CONST_APT = Integer.valueOf(((Element)data.get("CONST_APT")).attributeValue("value")).intValue();
/* 234 */       this.RATIO_APT = Integer.valueOf(((Element)data.get("RATIO_APT")).attributeValue("value")).intValue();
/* 235 */       this.CONST_GROW = Integer.valueOf(((Element)data.get("CONST_GROW")).attributeValue("value")).intValue();
/* 236 */       this.RATIO_GROW = Integer.valueOf(((Element)data.get("RATIO_GROW")).attributeValue("value")).intValue();
/* 237 */       this.PET_SOUL_OPEN_ROLE_LEVEL = Integer.valueOf(((Element)data.get("PET_SOUL_OPEN_ROLE_LEVEL")).attributeValue("value")).intValue();
/* 238 */       this.OWN_MAX_EXTRA_MODEL_NUM = Integer.valueOf(((Element)data.get("OWN_MAX_EXTRA_MODEL_NUM")).attributeValue("value")).intValue();
/* 239 */       Element modelElement = (Element)data.get("PET_REMBER_SKILL_ITEM_IDS");
/* 240 */       if (modelElement == null)
/* 241 */         throw new RuntimeException("collection type element does not find");
/* 242 */       List<?> _nodeList3 = modelElement.elements();
/* 243 */       int _len3 = _nodeList3.size();
/* 244 */       for (int j = 0; j < _len3; j++) {
/* 245 */         Element elem = (Element)_nodeList3.get(j);
/* 246 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.pet.confbean.RemmberSkill")) {
/*     */           try {
/* 248 */             RemmberSkill skill = new RemmberSkill();
/* 249 */             skill.loadFromXml(elem);
/* 250 */             this.PET_REMBER_SKILL_ITEM_IDS.add(skill);
/*     */           }
/*     */           catch (Exception e) {}
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 257 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 262 */     String path = dir + "mzm.gsp.pet.confbean.PetConstants.xml";
/*     */     try {
/* 264 */       SAXReader reader = new SAXReader();
/* 265 */       Document doc = reader.read(new File(path));
/* 266 */       Element root = doc.getRootElement();
/* 267 */       Map<String, Element> data = new HashMap();
/* 268 */       List<?> nodeList = root.elements();
/* 269 */       int len = nodeList.size();
/* 270 */       for (int i = 0; i < len; i++) {
/* 271 */         Element element = (Element)nodeList.get(i);
/* 272 */         if (element.getName().equalsIgnoreCase("row")) {
/* 273 */           String name = element.attributeValue("name");
/* 274 */           if (data.put(name, element) != null) {
/* 275 */             throw new RuntimeException("duplicate const : " + name);
/*     */           }
/*     */         }
/*     */       }
/* 279 */       this.PET_MAX_LEVEL = Integer.valueOf(((Element)data.get("PET_MAX_LEVEL")).attributeValue("value")).intValue();
/* 280 */       this.PET_MIN_LEVEL = Integer.valueOf(((Element)data.get("PET_MIN_LEVEL")).attributeValue("value")).intValue();
/* 281 */       this.ADD_POTENTIAL_PER_LEVEL = Integer.valueOf(((Element)data.get("ADD_POTENTIAL_PER_LEVEL")).attributeValue("value")).intValue();
/* 282 */       this.PET_MAX_LIFE = Integer.valueOf(((Element)data.get("PET_MAX_LIFE")).attributeValue("value")).intValue();
/* 283 */       this.CAN_FANSHENG_MAX_LEVEL = Integer.valueOf(((Element)data.get("CAN_FANSHENG_MAX_LEVEL")).attributeValue("value")).intValue();
/* 284 */       this.PET_SHELF_SKILL_NUM_LIMIT = Integer.valueOf(((Element)data.get("PET_SHELF_SKILL_NUM_LIMIT")).attributeValue("value")).intValue();
/* 285 */       this.PET_DECORATE_ITEM_TYPE = Integer.valueOf(((Element)data.get("PET_DECORATE_ITEM_TYPE")).attributeValue("value")).intValue();
/* 286 */       this.PET_CAN_EQUIP_LEVEL = Integer.valueOf(((Element)data.get("PET_CAN_EQUIP_LEVEL")).attributeValue("value")).intValue();
/* 287 */       this.HUASHENG_ITEM_TYPE = Integer.valueOf(((Element)data.get("HUASHENG_ITEM_TYPE")).attributeValue("value")).intValue();
/* 288 */       this.PET_DUANGU_ITEM_TYPE = Integer.valueOf(((Element)data.get("PET_DUANGU_ITEM_TYPE")).attributeValue("value")).intValue();
/* 289 */       this.PET_PUTTONG_FANSHENG_ITEM_TYPE = Integer.valueOf(((Element)data.get("PET_PUTTONG_FANSHENG_ITEM_TYPE")).attributeValue("value")).intValue();
/* 290 */       this.PET_GAOJI_FANSHENG_ITEM_TYPE = Integer.valueOf(((Element)data.get("PET_GAOJI_FANSHENG_ITEM_TYPE")).attributeValue("value")).intValue();
/* 291 */       this.PET_JOIN_FIGHT_MIN_LIFE = Integer.valueOf(((Element)data.get("PET_JOIN_FIGHT_MIN_LIFE")).attributeValue("value")).intValue();
/* 292 */       this.PET_AFTERFIGHT_DIE_REDUCE_LIFE = Integer.valueOf(((Element)data.get("PET_AFTERFIGHT_DIE_REDUCE_LIFE")).attributeValue("value")).intValue();
/* 293 */       this.PET_AFTERFIGHT_LIVE_REDUCE_LIFE = Integer.valueOf(((Element)data.get("PET_AFTERFIGHT_LIVE_REDUCE_LIFE")).attributeValue("value")).intValue();
/* 294 */       this.PET_STUDY_SKILL_MAX_LEVEL = Integer.valueOf(((Element)data.get("PET_STUDY_SKILL_MAX_LEVEL")).attributeValue("value")).intValue();
/* 295 */       this.PET_STUDY_SKILL_NUM_LIMIT = Integer.valueOf(((Element)data.get("PET_STUDY_SKILL_NUM_LIMIT")).attributeValue("value")).intValue();
/* 296 */       this.LEARN_SKILLBOOK_SKILL_NUM_LIMIT = Integer.valueOf(((Element)data.get("LEARN_SKILLBOOK_SKILL_NUM_LIMIT")).attributeValue("value")).intValue();
/* 297 */       this.PET_UNREMEMBER_SKILL_COST_SILVER = Integer.valueOf(((Element)data.get("PET_UNREMEMBER_SKILL_COST_SILVER")).attributeValue("value")).intValue();
/* 298 */       this.PET_LEVEL_MORE_THAN_OWNER_LIMIT = Integer.valueOf(((Element)data.get("PET_LEVEL_MORE_THAN_OWNER_LIMIT")).attributeValue("value")).intValue();
/* 299 */       this.PET_HAVE_0_SKILL_STUDY_PROP = Integer.valueOf(((Element)data.get("PET_HAVE_0_SKILL_STUDY_PROP")).attributeValue("value")).intValue();
/* 300 */       this.PET_HAVE_1_SKILL_STUDY_PROP = Integer.valueOf(((Element)data.get("PET_HAVE_1_SKILL_STUDY_PROP")).attributeValue("value")).intValue();
/* 301 */       this.PET_HAVE_2_SKILL_STUDY_PROP = Integer.valueOf(((Element)data.get("PET_HAVE_2_SKILL_STUDY_PROP")).attributeValue("value")).intValue();
/* 302 */       this.PET_HAVE_3_SKILL_STUDY_PROP = Integer.valueOf(((Element)data.get("PET_HAVE_3_SKILL_STUDY_PROP")).attributeValue("value")).intValue();
/* 303 */       this.PET_1_SKILL_LEARN_BOOK_REPLACE_PROP = Integer.valueOf(((Element)data.get("PET_1_SKILL_LEARN_BOOK_REPLACE_PROP")).attributeValue("value")).intValue();
/* 304 */       this.PET_2_SKILL_LEARN_BOOK_REPLACE_PROP = Integer.valueOf(((Element)data.get("PET_2_SKILL_LEARN_BOOK_REPLACE_PROP")).attributeValue("value")).intValue();
/* 305 */       this.PET_3_SKILL_LEARN_BOOK_REPLACE_PROP = Integer.valueOf(((Element)data.get("PET_3_SKILL_LEARN_BOOK_REPLACE_PROP")).attributeValue("value")).intValue();
/* 306 */       this.PET_MORE_THAN_2_SKILL_LEARN_BOOK_REPLACE_PROP = Integer.valueOf(((Element)data.get("PET_MORE_THAN_2_SKILL_LEARN_BOOK_REPLACE_PROP")).attributeValue("value")).intValue();
/* 307 */       this.ADD_STR_PER_LEVEL = Double.valueOf(((Element)data.get("ADD_STR_PER_LEVEL")).attributeValue("value")).doubleValue();
/* 308 */       this.ADD_DEX_PER_LEVEL = Double.valueOf(((Element)data.get("ADD_DEX_PER_LEVEL")).attributeValue("value")).doubleValue();
/* 309 */       this.ADD_SPR_PER_LEVEL = Double.valueOf(((Element)data.get("ADD_SPR_PER_LEVEL")).attributeValue("value")).doubleValue();
/* 310 */       this.ADD_STA_PER_LEVEL = Double.valueOf(((Element)data.get("ADD_STA_PER_LEVEL")).attributeValue("value")).doubleValue();
/* 311 */       this.ADD_CON_PER_LEVEL = Double.valueOf(((Element)data.get("ADD_CON_PER_LEVEL")).attributeValue("value")).doubleValue();
/* 312 */       this.PET_DECORATE_ITEM_ID = Integer.valueOf(((Element)data.get("PET_DECORATE_ITEM_ID")).attributeValue("value")).intValue();
/* 313 */       this.PET_RESET_PROP_ITEM_ID = Integer.valueOf(((Element)data.get("PET_RESET_PROP_ITEM_ID")).attributeValue("value")).intValue();
/* 314 */       this.PET_HUASHENG_ITEM_ID = Integer.valueOf(((Element)data.get("PET_HUASHENG_ITEM_ID")).attributeValue("value")).intValue();
/* 315 */       this.PET_LIANGU_ITEM_ID = Integer.valueOf(((Element)data.get("PET_LIANGU_ITEM_ID")).attributeValue("value")).intValue();
/* 316 */       this.PET_REMEBER_SKILL_ITEM_ID = Integer.valueOf(((Element)data.get("PET_REMEBER_SKILL_ITEM_ID")).attributeValue("value")).intValue();
/* 317 */       this.PET_PUTONG_FANSHENGDAN_ID = Integer.valueOf(((Element)data.get("PET_PUTONG_FANSHENGDAN_ID")).attributeValue("value")).intValue();
/* 318 */       this.PET_GAOJI_FANSHENGDAN_ID = Integer.valueOf(((Element)data.get("PET_GAOJI_FANSHENGDAN_ID")).attributeValue("value")).intValue();
/* 319 */       this.NORMAL_ATTACK_SKILLID = Integer.valueOf(((Element)data.get("NORMAL_ATTACK_SKILLID")).attributeValue("value")).intValue();
/* 320 */       this.NORMAL_DEFENCE_SKILLID = Integer.valueOf(((Element)data.get("NORMAL_DEFENCE_SKILLID")).attributeValue("value")).intValue();
/* 321 */       this.PET_SKILLBOOK_GET_METHOD = Integer.valueOf(((Element)data.get("PET_SKILLBOOK_GET_METHOD")).attributeValue("value")).intValue();
/* 322 */       this.PETSHOP_NPC_ID = Integer.valueOf(((Element)data.get("PETSHOP_NPC_ID")).attributeValue("value")).intValue();
/* 323 */       this.ADD_LIFE_TIPS_LIMIT = Integer.valueOf(((Element)data.get("ADD_LIFE_TIPS_LIMIT")).attributeValue("value")).intValue();
/* 324 */       this.FIX_SCORE = Integer.valueOf(((Element)data.get("FIX_SCORE")).attributeValue("value")).intValue();
/* 325 */       this.GROW_FACTOR = Integer.valueOf(((Element)data.get("GROW_FACTOR")).attributeValue("value")).intValue();
/* 326 */       this.MINGJI_TIPS = Integer.valueOf(((Element)data.get("MINGJI_TIPS")).attributeValue("value")).intValue();
/* 327 */       this.LEAN_SKILL_TIPS = Integer.valueOf(((Element)data.get("LEAN_SKILL_TIPS")).attributeValue("value")).intValue();
/* 328 */       this.FANSHENG_TIPS = Integer.valueOf(((Element)data.get("FANSHENG_TIPS")).attributeValue("value")).intValue();
/* 329 */       this.GOLD_PET_REDEEM_NPCID = Integer.valueOf(((Element)data.get("GOLD_PET_REDEEM_NPCID")).attributeValue("value")).intValue();
/* 330 */       this.MOSHOU_PET_REDEEM_NPCID = Integer.valueOf(((Element)data.get("MOSHOU_PET_REDEEM_NPCID")).attributeValue("value")).intValue();
/* 331 */       this.PET_BAG_FUWU_ID = Integer.valueOf(((Element)data.get("PET_BAG_FUWU_ID")).attributeValue("value")).intValue();
/* 332 */       this.PET_FREE_FUWU_ID = Integer.valueOf(((Element)data.get("PET_FREE_FUWU_ID")).attributeValue("value")).intValue();
/* 333 */       this.PET_FREE_REWARD_LEVEL = Integer.valueOf(((Element)data.get("PET_FREE_REWARD_LEVEL")).attributeValue("value")).intValue();
/* 334 */       this.PET_FREE_REWARD_RANGE = Integer.valueOf(((Element)data.get("PET_FREE_REWARD_RANGE")).attributeValue("value")).intValue();
/* 335 */       this.PET_FREE_REWARD_ITEMID = Integer.valueOf(((Element)data.get("PET_FREE_REWARD_ITEMID")).attributeValue("value")).intValue();
/* 336 */       this.PET_FREE_REWARD_EMAILID = Integer.valueOf(((Element)data.get("PET_FREE_REWARD_EMAILID")).attributeValue("value")).intValue();
/* 337 */       this.PET_APT_BASE_VALUE = Integer.valueOf(((Element)data.get("PET_APT_BASE_VALUE")).attributeValue("value")).intValue();
/* 338 */       this.PET_APT_BASE_RATE = Integer.valueOf(((Element)data.get("PET_APT_BASE_RATE")).attributeValue("value")).intValue();
/* 339 */       this.PET_APT_SHOW_RATE = Integer.valueOf(((Element)data.get("PET_APT_SHOW_RATE")).attributeValue("value")).intValue();
/* 340 */       this.PET_HUASHENG_OPEN_LEVEL = Integer.valueOf(((Element)data.get("PET_HUASHENG_OPEN_LEVEL")).attributeValue("value")).intValue();
/* 341 */       this.PET_HUASHENG_LEVEL_DIFFER = Integer.valueOf(((Element)data.get("PET_HUASHENG_LEVEL_DIFFER")).attributeValue("value")).intValue();
/* 342 */       this.PET_HUASHENG_X_SKILL_BULLETIN = Integer.valueOf(((Element)data.get("PET_HUASHENG_X_SKILL_BULLETIN")).attributeValue("value")).intValue();
/* 343 */       this.PET_NEW_SKILL_MAIL = Integer.valueOf(((Element)data.get("PET_NEW_SKILL_MAIL")).attributeValue("value")).intValue();
/* 344 */       this.PET_SKILL_LEVELUP_MAIL = Integer.valueOf(((Element)data.get("PET_SKILL_LEVELUP_MAIL")).attributeValue("value")).intValue();
/* 345 */       this.PET_REPLACE_SKILL_LEVELLIMIT = Integer.valueOf(((Element)data.get("PET_REPLACE_SKILL_LEVELLIMIT")).attributeValue("value")).intValue();
/* 346 */       this.PET_MAX_STAGE = Integer.valueOf(((Element)data.get("PET_MAX_STAGE")).attributeValue("value")).intValue();
/* 347 */       this.CANCEL_PET_CHANGEMODEL_ITEM_ID = Integer.valueOf(((Element)data.get("CANCEL_PET_CHANGEMODEL_ITEM_ID")).attributeValue("value")).intValue();
/* 348 */       this.CANCEL_PET_CHANGEMODEL_ITEM_COST_NUM = Integer.valueOf(((Element)data.get("CANCEL_PET_CHANGEMODEL_ITEM_COST_NUM")).attributeValue("value")).intValue();
/* 349 */       this.MIN_PET_NAME_LEN = Integer.valueOf(((Element)data.get("MIN_PET_NAME_LEN")).attributeValue("value")).intValue();
/* 350 */       this.MAX_PET_NAME_LEN = Integer.valueOf(((Element)data.get("MAX_PET_NAME_LEN")).attributeValue("value")).intValue();
/* 351 */       this.hua_sheng_minimum_guarantee_special_effect_id = Integer.valueOf(((Element)data.get("hua_sheng_minimum_guarantee_special_effect_id")).attributeValue("value")).intValue();
/* 352 */       this.hua_sheng_low_minimum_guarantee_item_id = Integer.valueOf(((Element)data.get("hua_sheng_low_minimum_guarantee_item_id")).attributeValue("value")).intValue();
/* 353 */       this.hua_sheng_hign_minimum_guarantee_item_id = Integer.valueOf(((Element)data.get("hua_sheng_hign_minimum_guarantee_item_id")).attributeValue("value")).intValue();
/* 354 */       this.PET_SOUL_MAX_LEVEL = Integer.valueOf(((Element)data.get("PET_SOUL_MAX_LEVEL")).attributeValue("value")).intValue();
/* 355 */       this.soul_random_property_main_item = Integer.valueOf(((Element)data.get("soul_random_property_main_item")).attributeValue("value")).intValue();
/* 356 */       this.soul_random_property_sub_item = Integer.valueOf(((Element)data.get("soul_random_property_sub_item")).attributeValue("value")).intValue();
/* 357 */       this.soul_random_property_item_count = Integer.valueOf(((Element)data.get("soul_random_property_item_count")).attributeValue("value")).intValue();
/* 358 */       this.PET_SOUL_EXCHANGE_MAIN_ITEM = Integer.valueOf(((Element)data.get("PET_SOUL_EXCHANGE_MAIN_ITEM")).attributeValue("value")).intValue();
/* 359 */       this.PET_SOUL_EXCHANGE_SUM_ITEM = Integer.valueOf(((Element)data.get("PET_SOUL_EXCHANGE_SUM_ITEM")).attributeValue("value")).intValue();
/* 360 */       this.PET_SOUL_EXCHANGE_ITEM_COUNT = Integer.valueOf(((Element)data.get("PET_SOUL_EXCHANGE_ITEM_COUNT")).attributeValue("value")).intValue();
/* 361 */       this.PET_SOUL_UPGRADE_TIP = Integer.valueOf(((Element)data.get("PET_SOUL_UPGRADE_TIP")).attributeValue("value")).intValue();
/* 362 */       this.PET_SOUL_EXCHANGE_TIP = Integer.valueOf(((Element)data.get("PET_SOUL_EXCHANGE_TIP")).attributeValue("value")).intValue();
/* 363 */       this.PET_SOUL_EXCHANGE_EFFECT_ID = Integer.valueOf(((Element)data.get("PET_SOUL_EXCHANGE_EFFECT_ID")).attributeValue("value")).intValue();
/* 364 */       this.PET_SOUL_EXCHANGE_DETAIL_TIP = Integer.valueOf(((Element)data.get("PET_SOUL_EXCHANGE_DETAIL_TIP")).attributeValue("value")).intValue();
/* 365 */       this.RATIO_BISIC_PROP = Integer.valueOf(((Element)data.get("RATIO_BISIC_PROP")).attributeValue("value")).intValue();
/* 366 */       this.CONST_APT = Integer.valueOf(((Element)data.get("CONST_APT")).attributeValue("value")).intValue();
/* 367 */       this.RATIO_APT = Integer.valueOf(((Element)data.get("RATIO_APT")).attributeValue("value")).intValue();
/* 368 */       this.CONST_GROW = Integer.valueOf(((Element)data.get("CONST_GROW")).attributeValue("value")).intValue();
/* 369 */       this.RATIO_GROW = Integer.valueOf(((Element)data.get("RATIO_GROW")).attributeValue("value")).intValue();
/* 370 */       this.PET_SOUL_OPEN_ROLE_LEVEL = Integer.valueOf(((Element)data.get("PET_SOUL_OPEN_ROLE_LEVEL")).attributeValue("value")).intValue();
/* 371 */       this.OWN_MAX_EXTRA_MODEL_NUM = Integer.valueOf(((Element)data.get("OWN_MAX_EXTRA_MODEL_NUM")).attributeValue("value")).intValue();
/*     */       
/* 373 */       Element modelElement = (Element)data.get("PET_REMBER_SKILL_ITEM_IDS");
/* 374 */       if (modelElement == null)
/* 375 */         throw new RuntimeException("collection type element does not find");
/* 376 */       List<?> _nodeList3 = modelElement.elements();
/* 377 */       int _len3 = _nodeList3.size();
/* 378 */       for (int j = 0; j < _len3; j++) {
/* 379 */         Element elem = (Element)_nodeList3.get(j);
/* 380 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.pet.confbean.RemmberSkill")) {
/*     */           try {
/* 382 */             RemmberSkill skill = new RemmberSkill();
/* 383 */             skill.loadFromXml(elem);
/* 384 */             this.PET_REMBER_SKILL_ITEM_IDS.add(skill);
/*     */           }
/*     */           catch (Exception e) {}
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 391 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir) {
/* 396 */     instance._loadBny(dir);
/*     */   }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 400 */     String path = dir + "mzm.gsp.pet.confbean.PetConstants.bny";
/*     */     try {
/* 402 */       File file = new File(path);
/* 403 */       if (file.exists()) {
/* 404 */         byte[] bytes = new byte['Ѐ'];
/* 405 */         FileInputStream fis = new FileInputStream(file);
/* 406 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/*     */         for (;;) {
/* 408 */           int len = fis.read(bytes);
/* 409 */           if (len <= 0) {
/*     */             break;
/*     */           }
/* 412 */           baos.write(bytes, 0, len);
/*     */         }
/* 414 */         fis.close();
/* 415 */         OctetsStream _os_ = OctetsStream.wrap(Octets.wrap(baos.toByteArray()));
/* 416 */         this.PET_MAX_LEVEL = _os_.unmarshal_int();
/* 417 */         this.PET_MIN_LEVEL = _os_.unmarshal_int();
/* 418 */         this.ADD_POTENTIAL_PER_LEVEL = _os_.unmarshal_int();
/* 419 */         this.PET_MAX_LIFE = _os_.unmarshal_int();
/* 420 */         this.CAN_FANSHENG_MAX_LEVEL = _os_.unmarshal_int();
/* 421 */         this.PET_SHELF_SKILL_NUM_LIMIT = _os_.unmarshal_int();
/* 422 */         this.PET_DECORATE_ITEM_TYPE = _os_.unmarshal_int();
/* 423 */         this.PET_CAN_EQUIP_LEVEL = _os_.unmarshal_int();
/* 424 */         this.HUASHENG_ITEM_TYPE = _os_.unmarshal_int();
/* 425 */         this.PET_DUANGU_ITEM_TYPE = _os_.unmarshal_int();
/* 426 */         this.PET_PUTTONG_FANSHENG_ITEM_TYPE = _os_.unmarshal_int();
/* 427 */         this.PET_GAOJI_FANSHENG_ITEM_TYPE = _os_.unmarshal_int();
/* 428 */         this.PET_JOIN_FIGHT_MIN_LIFE = _os_.unmarshal_int();
/* 429 */         this.PET_AFTERFIGHT_DIE_REDUCE_LIFE = _os_.unmarshal_int();
/* 430 */         this.PET_AFTERFIGHT_LIVE_REDUCE_LIFE = _os_.unmarshal_int();
/* 431 */         this.PET_STUDY_SKILL_MAX_LEVEL = _os_.unmarshal_int();
/* 432 */         this.PET_STUDY_SKILL_NUM_LIMIT = _os_.unmarshal_int();
/* 433 */         this.LEARN_SKILLBOOK_SKILL_NUM_LIMIT = _os_.unmarshal_int();
/* 434 */         this.PET_UNREMEMBER_SKILL_COST_SILVER = _os_.unmarshal_int();
/* 435 */         this.PET_LEVEL_MORE_THAN_OWNER_LIMIT = _os_.unmarshal_int();
/* 436 */         this.PET_HAVE_0_SKILL_STUDY_PROP = _os_.unmarshal_int();
/* 437 */         this.PET_HAVE_1_SKILL_STUDY_PROP = _os_.unmarshal_int();
/* 438 */         this.PET_HAVE_2_SKILL_STUDY_PROP = _os_.unmarshal_int();
/* 439 */         this.PET_HAVE_3_SKILL_STUDY_PROP = _os_.unmarshal_int();
/* 440 */         this.PET_1_SKILL_LEARN_BOOK_REPLACE_PROP = _os_.unmarshal_int();
/* 441 */         this.PET_2_SKILL_LEARN_BOOK_REPLACE_PROP = _os_.unmarshal_int();
/* 442 */         this.PET_3_SKILL_LEARN_BOOK_REPLACE_PROP = _os_.unmarshal_int();
/* 443 */         this.PET_MORE_THAN_2_SKILL_LEARN_BOOK_REPLACE_PROP = _os_.unmarshal_int();
/* 444 */         this.ADD_STR_PER_LEVEL = _os_.unmarshal_float();
/* 445 */         this.ADD_DEX_PER_LEVEL = _os_.unmarshal_float();
/* 446 */         this.ADD_SPR_PER_LEVEL = _os_.unmarshal_float();
/* 447 */         this.ADD_STA_PER_LEVEL = _os_.unmarshal_float();
/* 448 */         this.ADD_CON_PER_LEVEL = _os_.unmarshal_float();
/* 449 */         this.PET_DECORATE_ITEM_ID = _os_.unmarshal_int();
/* 450 */         this.PET_RESET_PROP_ITEM_ID = _os_.unmarshal_int();
/* 451 */         this.PET_HUASHENG_ITEM_ID = _os_.unmarshal_int();
/* 452 */         this.PET_LIANGU_ITEM_ID = _os_.unmarshal_int();
/* 453 */         this.PET_REMEBER_SKILL_ITEM_ID = _os_.unmarshal_int();
/* 454 */         this.PET_PUTONG_FANSHENGDAN_ID = _os_.unmarshal_int();
/* 455 */         this.PET_GAOJI_FANSHENGDAN_ID = _os_.unmarshal_int();
/* 456 */         this.NORMAL_ATTACK_SKILLID = _os_.unmarshal_int();
/* 457 */         this.NORMAL_DEFENCE_SKILLID = _os_.unmarshal_int();
/* 458 */         this.PET_SKILLBOOK_GET_METHOD = _os_.unmarshal_int();
/* 459 */         this.PETSHOP_NPC_ID = _os_.unmarshal_int();
/* 460 */         this.ADD_LIFE_TIPS_LIMIT = _os_.unmarshal_int();
/* 461 */         this.FIX_SCORE = _os_.unmarshal_int();
/* 462 */         this.GROW_FACTOR = _os_.unmarshal_int();
/* 463 */         this.MINGJI_TIPS = _os_.unmarshal_int();
/* 464 */         this.LEAN_SKILL_TIPS = _os_.unmarshal_int();
/* 465 */         this.FANSHENG_TIPS = _os_.unmarshal_int();
/* 466 */         this.GOLD_PET_REDEEM_NPCID = _os_.unmarshal_int();
/* 467 */         this.MOSHOU_PET_REDEEM_NPCID = _os_.unmarshal_int();
/* 468 */         this.PET_BAG_FUWU_ID = _os_.unmarshal_int();
/* 469 */         this.PET_FREE_FUWU_ID = _os_.unmarshal_int();
/* 470 */         this.PET_FREE_REWARD_LEVEL = _os_.unmarshal_int();
/* 471 */         this.PET_FREE_REWARD_RANGE = _os_.unmarshal_int();
/* 472 */         this.PET_FREE_REWARD_ITEMID = _os_.unmarshal_int();
/* 473 */         this.PET_FREE_REWARD_EMAILID = _os_.unmarshal_int();
/* 474 */         this.PET_APT_BASE_VALUE = _os_.unmarshal_int();
/* 475 */         this.PET_APT_BASE_RATE = _os_.unmarshal_int();
/* 476 */         this.PET_APT_SHOW_RATE = _os_.unmarshal_int();
/* 477 */         this.PET_HUASHENG_OPEN_LEVEL = _os_.unmarshal_int();
/* 478 */         this.PET_HUASHENG_LEVEL_DIFFER = _os_.unmarshal_int();
/* 479 */         this.PET_HUASHENG_X_SKILL_BULLETIN = _os_.unmarshal_int();
/* 480 */         this.PET_NEW_SKILL_MAIL = _os_.unmarshal_int();
/* 481 */         this.PET_SKILL_LEVELUP_MAIL = _os_.unmarshal_int();
/* 482 */         this.PET_REPLACE_SKILL_LEVELLIMIT = _os_.unmarshal_int();
/* 483 */         this.PET_MAX_STAGE = _os_.unmarshal_int();
/* 484 */         this.CANCEL_PET_CHANGEMODEL_ITEM_ID = _os_.unmarshal_int();
/* 485 */         this.CANCEL_PET_CHANGEMODEL_ITEM_COST_NUM = _os_.unmarshal_int();
/* 486 */         this.MIN_PET_NAME_LEN = _os_.unmarshal_int();
/* 487 */         this.MAX_PET_NAME_LEN = _os_.unmarshal_int();
/* 488 */         this.hua_sheng_minimum_guarantee_special_effect_id = _os_.unmarshal_int();
/* 489 */         this.hua_sheng_low_minimum_guarantee_item_id = _os_.unmarshal_int();
/* 490 */         this.hua_sheng_hign_minimum_guarantee_item_id = _os_.unmarshal_int();
/* 491 */         this.PET_SOUL_MAX_LEVEL = _os_.unmarshal_int();
/* 492 */         this.soul_random_property_main_item = _os_.unmarshal_int();
/* 493 */         this.soul_random_property_sub_item = _os_.unmarshal_int();
/* 494 */         this.soul_random_property_item_count = _os_.unmarshal_int();
/* 495 */         this.PET_SOUL_EXCHANGE_MAIN_ITEM = _os_.unmarshal_int();
/* 496 */         this.PET_SOUL_EXCHANGE_SUM_ITEM = _os_.unmarshal_int();
/* 497 */         this.PET_SOUL_EXCHANGE_ITEM_COUNT = _os_.unmarshal_int();
/* 498 */         this.PET_SOUL_UPGRADE_TIP = _os_.unmarshal_int();
/* 499 */         this.PET_SOUL_EXCHANGE_TIP = _os_.unmarshal_int();
/* 500 */         this.PET_SOUL_EXCHANGE_EFFECT_ID = _os_.unmarshal_int();
/* 501 */         this.PET_SOUL_EXCHANGE_DETAIL_TIP = _os_.unmarshal_int();
/* 502 */         this.RATIO_BISIC_PROP = _os_.unmarshal_int();
/* 503 */         this.CONST_APT = _os_.unmarshal_int();
/* 504 */         this.RATIO_APT = _os_.unmarshal_int();
/* 505 */         this.CONST_GROW = _os_.unmarshal_int();
/* 506 */         this.RATIO_GROW = _os_.unmarshal_int();
/* 507 */         this.PET_SOUL_OPEN_ROLE_LEVEL = _os_.unmarshal_int();
/* 508 */         this.OWN_MAX_EXTRA_MODEL_NUM = _os_.unmarshal_int();
/* 509 */         for (int i = _os_.uncompact_uint32(); i > 0; i--) {
/* 510 */           RemmberSkill skill = new RemmberSkill();
/* 511 */           skill.unmarshal(_os_);
/* 512 */           this.PET_REMBER_SKILL_ITEM_IDS.add(skill);
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 516 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir) {
/* 521 */     String path = dir + "mzm.gsp.pet.confbean.PetConstants.bny";
/*     */     try {
/* 523 */       File file = new File(path);
/* 524 */       if (file.exists()) {
/* 525 */         byte[] bytes = new byte['Ѐ'];
/* 526 */         FileInputStream fis = new FileInputStream(file);
/* 527 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/*     */         for (;;) {
/* 529 */           int len = fis.read(bytes);
/* 530 */           if (len <= 0) {
/*     */             break;
/*     */           }
/* 533 */           baos.write(bytes, 0, len);
/*     */         }
/* 535 */         fis.close();
/* 536 */         OctetsStream _os_ = OctetsStream.wrap(Octets.wrap(baos.toByteArray()));
/* 537 */         this.PET_MAX_LEVEL = _os_.unmarshal_int();
/* 538 */         this.PET_MIN_LEVEL = _os_.unmarshal_int();
/* 539 */         this.ADD_POTENTIAL_PER_LEVEL = _os_.unmarshal_int();
/* 540 */         this.PET_MAX_LIFE = _os_.unmarshal_int();
/* 541 */         this.CAN_FANSHENG_MAX_LEVEL = _os_.unmarshal_int();
/* 542 */         this.PET_SHELF_SKILL_NUM_LIMIT = _os_.unmarshal_int();
/* 543 */         this.PET_DECORATE_ITEM_TYPE = _os_.unmarshal_int();
/* 544 */         this.PET_CAN_EQUIP_LEVEL = _os_.unmarshal_int();
/* 545 */         this.HUASHENG_ITEM_TYPE = _os_.unmarshal_int();
/* 546 */         this.PET_DUANGU_ITEM_TYPE = _os_.unmarshal_int();
/* 547 */         this.PET_PUTTONG_FANSHENG_ITEM_TYPE = _os_.unmarshal_int();
/* 548 */         this.PET_GAOJI_FANSHENG_ITEM_TYPE = _os_.unmarshal_int();
/* 549 */         this.PET_JOIN_FIGHT_MIN_LIFE = _os_.unmarshal_int();
/* 550 */         this.PET_AFTERFIGHT_DIE_REDUCE_LIFE = _os_.unmarshal_int();
/* 551 */         this.PET_AFTERFIGHT_LIVE_REDUCE_LIFE = _os_.unmarshal_int();
/* 552 */         this.PET_STUDY_SKILL_MAX_LEVEL = _os_.unmarshal_int();
/* 553 */         this.PET_STUDY_SKILL_NUM_LIMIT = _os_.unmarshal_int();
/* 554 */         this.LEARN_SKILLBOOK_SKILL_NUM_LIMIT = _os_.unmarshal_int();
/* 555 */         this.PET_UNREMEMBER_SKILL_COST_SILVER = _os_.unmarshal_int();
/* 556 */         this.PET_LEVEL_MORE_THAN_OWNER_LIMIT = _os_.unmarshal_int();
/* 557 */         this.PET_HAVE_0_SKILL_STUDY_PROP = _os_.unmarshal_int();
/* 558 */         this.PET_HAVE_1_SKILL_STUDY_PROP = _os_.unmarshal_int();
/* 559 */         this.PET_HAVE_2_SKILL_STUDY_PROP = _os_.unmarshal_int();
/* 560 */         this.PET_HAVE_3_SKILL_STUDY_PROP = _os_.unmarshal_int();
/* 561 */         this.PET_1_SKILL_LEARN_BOOK_REPLACE_PROP = _os_.unmarshal_int();
/* 562 */         this.PET_2_SKILL_LEARN_BOOK_REPLACE_PROP = _os_.unmarshal_int();
/* 563 */         this.PET_3_SKILL_LEARN_BOOK_REPLACE_PROP = _os_.unmarshal_int();
/* 564 */         this.PET_MORE_THAN_2_SKILL_LEARN_BOOK_REPLACE_PROP = _os_.unmarshal_int();
/* 565 */         this.ADD_STR_PER_LEVEL = _os_.unmarshal_float();
/* 566 */         this.ADD_DEX_PER_LEVEL = _os_.unmarshal_float();
/* 567 */         this.ADD_SPR_PER_LEVEL = _os_.unmarshal_float();
/* 568 */         this.ADD_STA_PER_LEVEL = _os_.unmarshal_float();
/* 569 */         this.ADD_CON_PER_LEVEL = _os_.unmarshal_float();
/* 570 */         this.PET_DECORATE_ITEM_ID = _os_.unmarshal_int();
/* 571 */         this.PET_RESET_PROP_ITEM_ID = _os_.unmarshal_int();
/* 572 */         this.PET_HUASHENG_ITEM_ID = _os_.unmarshal_int();
/* 573 */         this.PET_LIANGU_ITEM_ID = _os_.unmarshal_int();
/* 574 */         this.PET_REMEBER_SKILL_ITEM_ID = _os_.unmarshal_int();
/* 575 */         this.PET_PUTONG_FANSHENGDAN_ID = _os_.unmarshal_int();
/* 576 */         this.PET_GAOJI_FANSHENGDAN_ID = _os_.unmarshal_int();
/* 577 */         this.NORMAL_ATTACK_SKILLID = _os_.unmarshal_int();
/* 578 */         this.NORMAL_DEFENCE_SKILLID = _os_.unmarshal_int();
/* 579 */         this.PET_SKILLBOOK_GET_METHOD = _os_.unmarshal_int();
/* 580 */         this.PETSHOP_NPC_ID = _os_.unmarshal_int();
/* 581 */         this.ADD_LIFE_TIPS_LIMIT = _os_.unmarshal_int();
/* 582 */         this.FIX_SCORE = _os_.unmarshal_int();
/* 583 */         this.GROW_FACTOR = _os_.unmarshal_int();
/* 584 */         this.MINGJI_TIPS = _os_.unmarshal_int();
/* 585 */         this.LEAN_SKILL_TIPS = _os_.unmarshal_int();
/* 586 */         this.FANSHENG_TIPS = _os_.unmarshal_int();
/* 587 */         this.GOLD_PET_REDEEM_NPCID = _os_.unmarshal_int();
/* 588 */         this.MOSHOU_PET_REDEEM_NPCID = _os_.unmarshal_int();
/* 589 */         this.PET_BAG_FUWU_ID = _os_.unmarshal_int();
/* 590 */         this.PET_FREE_FUWU_ID = _os_.unmarshal_int();
/* 591 */         this.PET_FREE_REWARD_LEVEL = _os_.unmarshal_int();
/* 592 */         this.PET_FREE_REWARD_RANGE = _os_.unmarshal_int();
/* 593 */         this.PET_FREE_REWARD_ITEMID = _os_.unmarshal_int();
/* 594 */         this.PET_FREE_REWARD_EMAILID = _os_.unmarshal_int();
/* 595 */         this.PET_APT_BASE_VALUE = _os_.unmarshal_int();
/* 596 */         this.PET_APT_BASE_RATE = _os_.unmarshal_int();
/* 597 */         this.PET_APT_SHOW_RATE = _os_.unmarshal_int();
/* 598 */         this.PET_HUASHENG_OPEN_LEVEL = _os_.unmarshal_int();
/* 599 */         this.PET_HUASHENG_LEVEL_DIFFER = _os_.unmarshal_int();
/* 600 */         this.PET_HUASHENG_X_SKILL_BULLETIN = _os_.unmarshal_int();
/* 601 */         this.PET_NEW_SKILL_MAIL = _os_.unmarshal_int();
/* 602 */         this.PET_SKILL_LEVELUP_MAIL = _os_.unmarshal_int();
/* 603 */         this.PET_REPLACE_SKILL_LEVELLIMIT = _os_.unmarshal_int();
/* 604 */         this.PET_MAX_STAGE = _os_.unmarshal_int();
/* 605 */         this.CANCEL_PET_CHANGEMODEL_ITEM_ID = _os_.unmarshal_int();
/* 606 */         this.CANCEL_PET_CHANGEMODEL_ITEM_COST_NUM = _os_.unmarshal_int();
/* 607 */         this.MIN_PET_NAME_LEN = _os_.unmarshal_int();
/* 608 */         this.MAX_PET_NAME_LEN = _os_.unmarshal_int();
/* 609 */         this.hua_sheng_minimum_guarantee_special_effect_id = _os_.unmarshal_int();
/* 610 */         this.hua_sheng_low_minimum_guarantee_item_id = _os_.unmarshal_int();
/* 611 */         this.hua_sheng_hign_minimum_guarantee_item_id = _os_.unmarshal_int();
/* 612 */         this.PET_SOUL_MAX_LEVEL = _os_.unmarshal_int();
/* 613 */         this.soul_random_property_main_item = _os_.unmarshal_int();
/* 614 */         this.soul_random_property_sub_item = _os_.unmarshal_int();
/* 615 */         this.soul_random_property_item_count = _os_.unmarshal_int();
/* 616 */         this.PET_SOUL_EXCHANGE_MAIN_ITEM = _os_.unmarshal_int();
/* 617 */         this.PET_SOUL_EXCHANGE_SUM_ITEM = _os_.unmarshal_int();
/* 618 */         this.PET_SOUL_EXCHANGE_ITEM_COUNT = _os_.unmarshal_int();
/* 619 */         this.PET_SOUL_UPGRADE_TIP = _os_.unmarshal_int();
/* 620 */         this.PET_SOUL_EXCHANGE_TIP = _os_.unmarshal_int();
/* 621 */         this.PET_SOUL_EXCHANGE_EFFECT_ID = _os_.unmarshal_int();
/* 622 */         this.PET_SOUL_EXCHANGE_DETAIL_TIP = _os_.unmarshal_int();
/* 623 */         this.RATIO_BISIC_PROP = _os_.unmarshal_int();
/* 624 */         this.CONST_APT = _os_.unmarshal_int();
/* 625 */         this.RATIO_APT = _os_.unmarshal_int();
/* 626 */         this.CONST_GROW = _os_.unmarshal_int();
/* 627 */         this.RATIO_GROW = _os_.unmarshal_int();
/* 628 */         this.PET_SOUL_OPEN_ROLE_LEVEL = _os_.unmarshal_int();
/* 629 */         this.OWN_MAX_EXTRA_MODEL_NUM = _os_.unmarshal_int();
/* 630 */         for (int i = _os_.uncompact_uint32(); i > 0; i--) {
/* 631 */           RemmberSkill skill = new RemmberSkill();
/* 632 */           skill.unmarshal(_os_);
/* 633 */           this.PET_REMBER_SKILL_ITEM_IDS.add(skill);
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 637 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(PetConstants newInstance) {
/* 642 */     oldInstance = instance;
/* 643 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance() {
/* 647 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\confbean\PetConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */