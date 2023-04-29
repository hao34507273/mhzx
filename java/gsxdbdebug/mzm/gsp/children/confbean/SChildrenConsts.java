/*     */ package mzm.gsp.children.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SChildrenConsts
/*     */ {
/*  13 */   private static volatile SChildrenConsts oldInstance = null;
/*     */   
/*  15 */   private static SChildrenConsts instance = new SChildrenConsts();
/*     */   public int children_function_open_level;
/*     */   public int single_children_need_score;
/*     */   public int pregnant_cut_vigor_score;
/*     */   public int prepare_pregnant_need_score;
/*     */   
/*     */   public static SChildrenConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SChildrenConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int give_birth_need_score;
/*     */   
/*     */   public int give_birth_days;
/*     */   
/*     */   public int max_children_can_carrey;
/*     */   
/*     */   public int select_pregnant_wait_seconds;
/*     */   public int change_name_cost_gold_value;
/*     */   public int change_name_min_length;
/*     */   public int change_name_max_length;
/*     */   public int pregnant_npc_id;
/*     */   public int pregnant_npc_service_id;
/*     */   public int abortion_notify_mail_id;
/*     */   public int breed_give_up_notify_mail_id;
/*     */   public int child_give_up_notify_mail_id;
/*  47 */   public String boy_default_name = "";
/*  48 */   public String girl_default_name = "";
/*     */   public int grow_diary_record_num;
/*     */   public int BOY_BABY_BASE_CFG_ID;
/*     */   public int GIRL_BABY_BASE_CFG_ID;
/*     */   public int BOY_CHILDHOOD_BASE_CFG_ID;
/*     */   public int GIRL_CHILDHOOD_BASE_CFG_ID;
/*     */   public int BOY_ADULT1_BASE_CFG_ID;
/*     */   public int BOY_ADULT2_BASE_CFG_ID;
/*     */   public int GIRL_ADULT1_BASE_CFG_ID;
/*     */   public int GIRL_ADULT2_BASE_CFG_ID;
/*     */   public int baby_max_bao_shi_value;
/*     */   public int baby_max_clean_value;
/*     */   public int baby_max_moood_value;
/*     */   public int baby_max_tired_value;
/*     */   public int baby_to_childhood_need_health_value;
/*     */   public int baby_sleep_reduce_tired__every_hour;
/*     */   public int baby_reduce_bao_shi_every_hour;
/*     */   public int baby_reduce_clean_every_hour;
/*     */   public int baby_max_moood_every_hour;
/*     */   public int baby_health_value_add_value_one_day;
/*     */   public int baby_min_bao_shi_to_add_health;
/*     */   public int baby_min_clean_to_add_health;
/*     */   public int baby_min_mood_value_to_add_health;
/*     */   public int baby_suckle_seconds;
/*     */   public int baby_change_diaper_seconds;
/*     */   public int baby_tickle_seconds;
/*     */   public int baby_sleep_hours;
/*     */   public int baby_reduce_bao_shi_init_value;
/*     */   public int baby_reduce_clean_init_value;
/*     */   public int baby_moood_init_value;
/*     */   public int baby_health_init_value;
/*     */   public int baby_tired_init_value;
/*     */   public int child_base_prop_type_id;
/*     */   public int child_hp_aptitude_max;
/*     */   public int child_phy_atk_aptitude_max;
/*     */   public int child_mag_atk_aptitude_max;
/*     */   public int child_phy_def_aptitude_max;
/*     */   public int child_mag_def_aptitude_max;
/*     */   public int child_speed_aptitude_max;
/*     */   public int child_init_skill_pos_max;
/*     */   public int child_level_up_add_STR;
/*     */   public int child_level_up_add_DEX;
/*     */   public int child_level_up_add_SPR;
/*     */   public int child_level_up_add_STA;
/*     */   public int child_level_up_add_CON;
/*     */   public int child_one_skill_replace_rate;
/*     */   public int child_two_skill_replace_rate;
/*     */   public int child_three_skill_replace_rate;
/*     */   public int child_over_three_skill_replace_rate;
/*     */   public int child_fight_skill_max;
/*     */   public int child_level_up_add_potential_num;
/*     */   public int child_use_aptitude_item_max;
/*     */   public int child_use_grow_item_max;
/*     */   public int child_auto_set_potential_point;
/*     */   public double child_default_grow_value;
/*     */   public int child_common_skill_max;
/*     */   public int resetPrefCost;
/*     */   public double child_grow_max;
/*     */   public int child_grow_character_init;
/*     */   public int child_grow_character_max;
/*     */   public int child_summon_max;
/*     */   public int child_change_occcupation_cost;
/*     */   public int child_init_STR;
/*     */   public int child_init_DEX;
/*     */   public int child_init_SPR;
/*     */   public int child_init_STA;
/*     */   public int child_init_CON;
/*     */   public int child_random_property_main_item;
/*     */   public int child_random_property_sub_item;
/*     */   public int child_random_property_item_count;
/*     */   public int child_take_twoskills_equipment_level;
/*     */   public int child_rating_low_skill_ratio;
/*     */   public int child_rating_high_skill_ratio;
/*     */   public int child_rating_super_skill_ratio;
/*     */   public int child_rating_special_skill_ratio;
/*     */   public int child_rating_equip_level_ratio;
/*     */   public int child_rating_occupation_skill_ratio;
/*     */   public int child_rating_aptitude_ratio;
/*     */   public int child_rating_grow_ratio;
/*     */   public int child_rating_compute_count;
/*     */   public int cardClassType;
/*     */   public int cardLevel;
/*     */   public int baby_auto_bao_shi_value;
/*     */   public int baby_auto_clean_value;
/*     */   public int baby_auto_mood_value;
/*     */   public int baby_auto_tired_value;
/*     */   public int auto_breed_cost_yuanbao_per_health_point;
/*     */   public int discard_child_num_limit;
/*     */   public int period_recall_times_limit;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 140 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/* 145 */     String path = dir + "mzm.gsp.children.confbean.SChildrenConsts.xml";
/*     */     try
/*     */     {
/* 148 */       SAXReader reader = new SAXReader();
/* 149 */       org.dom4j.Document doc = reader.read(new File(path));
/* 150 */       Element root = doc.getRootElement();
/* 151 */       Map<String, Element> data = new java.util.HashMap();
/* 152 */       java.util.List<?> nodeList = root.elements();
/* 153 */       int len = nodeList.size();
/* 154 */       for (int i = 0; i < len; i++)
/*     */       {
/* 156 */         Element element = (Element)nodeList.get(i);
/* 157 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 160 */           String name = element.attributeValue("name");
/* 161 */           if (data.put(name, element) != null)
/* 162 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 165 */       this.children_function_open_level = Integer.valueOf(((Element)data.get("children_function_open_level")).attributeValue("value")).intValue();
/* 166 */       this.single_children_need_score = Integer.valueOf(((Element)data.get("single_children_need_score")).attributeValue("value")).intValue();
/* 167 */       this.pregnant_cut_vigor_score = Integer.valueOf(((Element)data.get("pregnant_cut_vigor_score")).attributeValue("value")).intValue();
/* 168 */       this.prepare_pregnant_need_score = Integer.valueOf(((Element)data.get("prepare_pregnant_need_score")).attributeValue("value")).intValue();
/* 169 */       this.give_birth_need_score = Integer.valueOf(((Element)data.get("give_birth_need_score")).attributeValue("value")).intValue();
/* 170 */       this.give_birth_days = Integer.valueOf(((Element)data.get("give_birth_days")).attributeValue("value")).intValue();
/* 171 */       this.max_children_can_carrey = Integer.valueOf(((Element)data.get("max_children_can_carrey")).attributeValue("value")).intValue();
/* 172 */       this.select_pregnant_wait_seconds = Integer.valueOf(((Element)data.get("select_pregnant_wait_seconds")).attributeValue("value")).intValue();
/* 173 */       this.change_name_cost_gold_value = Integer.valueOf(((Element)data.get("change_name_cost_gold_value")).attributeValue("value")).intValue();
/* 174 */       this.change_name_min_length = Integer.valueOf(((Element)data.get("change_name_min_length")).attributeValue("value")).intValue();
/* 175 */       this.change_name_max_length = Integer.valueOf(((Element)data.get("change_name_max_length")).attributeValue("value")).intValue();
/* 176 */       this.pregnant_npc_id = Integer.valueOf(((Element)data.get("pregnant_npc_id")).attributeValue("value")).intValue();
/* 177 */       this.pregnant_npc_service_id = Integer.valueOf(((Element)data.get("pregnant_npc_service_id")).attributeValue("value")).intValue();
/* 178 */       this.abortion_notify_mail_id = Integer.valueOf(((Element)data.get("abortion_notify_mail_id")).attributeValue("value")).intValue();
/* 179 */       this.breed_give_up_notify_mail_id = Integer.valueOf(((Element)data.get("breed_give_up_notify_mail_id")).attributeValue("value")).intValue();
/* 180 */       this.child_give_up_notify_mail_id = Integer.valueOf(((Element)data.get("child_give_up_notify_mail_id")).attributeValue("value")).intValue();
/* 181 */       this.boy_default_name = String.valueOf(((Element)data.get("boy_default_name")).attributeValue("value"));
/* 182 */       this.girl_default_name = String.valueOf(((Element)data.get("girl_default_name")).attributeValue("value"));
/* 183 */       this.grow_diary_record_num = Integer.valueOf(((Element)data.get("grow_diary_record_num")).attributeValue("value")).intValue();
/* 184 */       this.BOY_BABY_BASE_CFG_ID = Integer.valueOf(((Element)data.get("BOY_BABY_BASE_CFG_ID")).attributeValue("value")).intValue();
/* 185 */       this.GIRL_BABY_BASE_CFG_ID = Integer.valueOf(((Element)data.get("GIRL_BABY_BASE_CFG_ID")).attributeValue("value")).intValue();
/* 186 */       this.BOY_CHILDHOOD_BASE_CFG_ID = Integer.valueOf(((Element)data.get("BOY_CHILDHOOD_BASE_CFG_ID")).attributeValue("value")).intValue();
/* 187 */       this.GIRL_CHILDHOOD_BASE_CFG_ID = Integer.valueOf(((Element)data.get("GIRL_CHILDHOOD_BASE_CFG_ID")).attributeValue("value")).intValue();
/* 188 */       this.BOY_ADULT1_BASE_CFG_ID = Integer.valueOf(((Element)data.get("BOY_ADULT1_BASE_CFG_ID")).attributeValue("value")).intValue();
/* 189 */       this.BOY_ADULT2_BASE_CFG_ID = Integer.valueOf(((Element)data.get("BOY_ADULT2_BASE_CFG_ID")).attributeValue("value")).intValue();
/* 190 */       this.GIRL_ADULT1_BASE_CFG_ID = Integer.valueOf(((Element)data.get("GIRL_ADULT1_BASE_CFG_ID")).attributeValue("value")).intValue();
/* 191 */       this.GIRL_ADULT2_BASE_CFG_ID = Integer.valueOf(((Element)data.get("GIRL_ADULT2_BASE_CFG_ID")).attributeValue("value")).intValue();
/* 192 */       this.baby_max_bao_shi_value = Integer.valueOf(((Element)data.get("baby_max_bao_shi_value")).attributeValue("value")).intValue();
/* 193 */       this.baby_max_clean_value = Integer.valueOf(((Element)data.get("baby_max_clean_value")).attributeValue("value")).intValue();
/* 194 */       this.baby_max_moood_value = Integer.valueOf(((Element)data.get("baby_max_moood_value")).attributeValue("value")).intValue();
/* 195 */       this.baby_max_tired_value = Integer.valueOf(((Element)data.get("baby_max_tired_value")).attributeValue("value")).intValue();
/* 196 */       this.baby_to_childhood_need_health_value = Integer.valueOf(((Element)data.get("baby_to_childhood_need_health_value")).attributeValue("value")).intValue();
/* 197 */       this.baby_sleep_reduce_tired__every_hour = Integer.valueOf(((Element)data.get("baby_sleep_reduce_tired__every_hour")).attributeValue("value")).intValue();
/* 198 */       this.baby_reduce_bao_shi_every_hour = Integer.valueOf(((Element)data.get("baby_reduce_bao_shi_every_hour")).attributeValue("value")).intValue();
/* 199 */       this.baby_reduce_clean_every_hour = Integer.valueOf(((Element)data.get("baby_reduce_clean_every_hour")).attributeValue("value")).intValue();
/* 200 */       this.baby_max_moood_every_hour = Integer.valueOf(((Element)data.get("baby_max_moood_every_hour")).attributeValue("value")).intValue();
/* 201 */       this.baby_health_value_add_value_one_day = Integer.valueOf(((Element)data.get("baby_health_value_add_value_one_day")).attributeValue("value")).intValue();
/* 202 */       this.baby_min_bao_shi_to_add_health = Integer.valueOf(((Element)data.get("baby_min_bao_shi_to_add_health")).attributeValue("value")).intValue();
/* 203 */       this.baby_min_clean_to_add_health = Integer.valueOf(((Element)data.get("baby_min_clean_to_add_health")).attributeValue("value")).intValue();
/* 204 */       this.baby_min_mood_value_to_add_health = Integer.valueOf(((Element)data.get("baby_min_mood_value_to_add_health")).attributeValue("value")).intValue();
/* 205 */       this.baby_suckle_seconds = Integer.valueOf(((Element)data.get("baby_suckle_seconds")).attributeValue("value")).intValue();
/* 206 */       this.baby_change_diaper_seconds = Integer.valueOf(((Element)data.get("baby_change_diaper_seconds")).attributeValue("value")).intValue();
/* 207 */       this.baby_tickle_seconds = Integer.valueOf(((Element)data.get("baby_tickle_seconds")).attributeValue("value")).intValue();
/* 208 */       this.baby_sleep_hours = Integer.valueOf(((Element)data.get("baby_sleep_hours")).attributeValue("value")).intValue();
/* 209 */       this.baby_reduce_bao_shi_init_value = Integer.valueOf(((Element)data.get("baby_reduce_bao_shi_init_value")).attributeValue("value")).intValue();
/* 210 */       this.baby_reduce_clean_init_value = Integer.valueOf(((Element)data.get("baby_reduce_clean_init_value")).attributeValue("value")).intValue();
/* 211 */       this.baby_moood_init_value = Integer.valueOf(((Element)data.get("baby_moood_init_value")).attributeValue("value")).intValue();
/* 212 */       this.baby_health_init_value = Integer.valueOf(((Element)data.get("baby_health_init_value")).attributeValue("value")).intValue();
/* 213 */       this.baby_tired_init_value = Integer.valueOf(((Element)data.get("baby_tired_init_value")).attributeValue("value")).intValue();
/* 214 */       this.child_base_prop_type_id = Integer.valueOf(((Element)data.get("child_base_prop_type_id")).attributeValue("value")).intValue();
/* 215 */       this.child_hp_aptitude_max = Integer.valueOf(((Element)data.get("child_hp_aptitude_max")).attributeValue("value")).intValue();
/* 216 */       this.child_phy_atk_aptitude_max = Integer.valueOf(((Element)data.get("child_phy_atk_aptitude_max")).attributeValue("value")).intValue();
/* 217 */       this.child_mag_atk_aptitude_max = Integer.valueOf(((Element)data.get("child_mag_atk_aptitude_max")).attributeValue("value")).intValue();
/* 218 */       this.child_phy_def_aptitude_max = Integer.valueOf(((Element)data.get("child_phy_def_aptitude_max")).attributeValue("value")).intValue();
/* 219 */       this.child_mag_def_aptitude_max = Integer.valueOf(((Element)data.get("child_mag_def_aptitude_max")).attributeValue("value")).intValue();
/* 220 */       this.child_speed_aptitude_max = Integer.valueOf(((Element)data.get("child_speed_aptitude_max")).attributeValue("value")).intValue();
/* 221 */       this.child_init_skill_pos_max = Integer.valueOf(((Element)data.get("child_init_skill_pos_max")).attributeValue("value")).intValue();
/* 222 */       this.child_level_up_add_STR = Integer.valueOf(((Element)data.get("child_level_up_add_STR")).attributeValue("value")).intValue();
/* 223 */       this.child_level_up_add_DEX = Integer.valueOf(((Element)data.get("child_level_up_add_DEX")).attributeValue("value")).intValue();
/* 224 */       this.child_level_up_add_SPR = Integer.valueOf(((Element)data.get("child_level_up_add_SPR")).attributeValue("value")).intValue();
/* 225 */       this.child_level_up_add_STA = Integer.valueOf(((Element)data.get("child_level_up_add_STA")).attributeValue("value")).intValue();
/* 226 */       this.child_level_up_add_CON = Integer.valueOf(((Element)data.get("child_level_up_add_CON")).attributeValue("value")).intValue();
/* 227 */       this.child_one_skill_replace_rate = Integer.valueOf(((Element)data.get("child_one_skill_replace_rate")).attributeValue("value")).intValue();
/* 228 */       this.child_two_skill_replace_rate = Integer.valueOf(((Element)data.get("child_two_skill_replace_rate")).attributeValue("value")).intValue();
/* 229 */       this.child_three_skill_replace_rate = Integer.valueOf(((Element)data.get("child_three_skill_replace_rate")).attributeValue("value")).intValue();
/* 230 */       this.child_over_three_skill_replace_rate = Integer.valueOf(((Element)data.get("child_over_three_skill_replace_rate")).attributeValue("value")).intValue();
/* 231 */       this.child_fight_skill_max = Integer.valueOf(((Element)data.get("child_fight_skill_max")).attributeValue("value")).intValue();
/* 232 */       this.child_level_up_add_potential_num = Integer.valueOf(((Element)data.get("child_level_up_add_potential_num")).attributeValue("value")).intValue();
/* 233 */       this.child_use_aptitude_item_max = Integer.valueOf(((Element)data.get("child_use_aptitude_item_max")).attributeValue("value")).intValue();
/* 234 */       this.child_use_grow_item_max = Integer.valueOf(((Element)data.get("child_use_grow_item_max")).attributeValue("value")).intValue();
/* 235 */       this.child_auto_set_potential_point = Integer.valueOf(((Element)data.get("child_auto_set_potential_point")).attributeValue("value")).intValue();
/* 236 */       this.child_default_grow_value = Double.valueOf(((Element)data.get("child_default_grow_value")).attributeValue("value")).doubleValue();
/* 237 */       this.child_common_skill_max = Integer.valueOf(((Element)data.get("child_common_skill_max")).attributeValue("value")).intValue();
/* 238 */       this.resetPrefCost = Integer.valueOf(((Element)data.get("resetPrefCost")).attributeValue("value")).intValue();
/* 239 */       this.child_grow_max = Double.valueOf(((Element)data.get("child_grow_max")).attributeValue("value")).doubleValue();
/* 240 */       this.child_grow_character_init = Integer.valueOf(((Element)data.get("child_grow_character_init")).attributeValue("value")).intValue();
/* 241 */       this.child_grow_character_max = Integer.valueOf(((Element)data.get("child_grow_character_max")).attributeValue("value")).intValue();
/* 242 */       this.child_summon_max = Integer.valueOf(((Element)data.get("child_summon_max")).attributeValue("value")).intValue();
/* 243 */       this.child_change_occcupation_cost = Integer.valueOf(((Element)data.get("child_change_occcupation_cost")).attributeValue("value")).intValue();
/* 244 */       this.child_init_STR = Integer.valueOf(((Element)data.get("child_init_STR")).attributeValue("value")).intValue();
/* 245 */       this.child_init_DEX = Integer.valueOf(((Element)data.get("child_init_DEX")).attributeValue("value")).intValue();
/* 246 */       this.child_init_SPR = Integer.valueOf(((Element)data.get("child_init_SPR")).attributeValue("value")).intValue();
/* 247 */       this.child_init_STA = Integer.valueOf(((Element)data.get("child_init_STA")).attributeValue("value")).intValue();
/* 248 */       this.child_init_CON = Integer.valueOf(((Element)data.get("child_init_CON")).attributeValue("value")).intValue();
/* 249 */       this.child_random_property_main_item = Integer.valueOf(((Element)data.get("child_random_property_main_item")).attributeValue("value")).intValue();
/* 250 */       this.child_random_property_sub_item = Integer.valueOf(((Element)data.get("child_random_property_sub_item")).attributeValue("value")).intValue();
/* 251 */       this.child_random_property_item_count = Integer.valueOf(((Element)data.get("child_random_property_item_count")).attributeValue("value")).intValue();
/* 252 */       this.child_take_twoskills_equipment_level = Integer.valueOf(((Element)data.get("child_take_twoskills_equipment_level")).attributeValue("value")).intValue();
/* 253 */       this.child_rating_low_skill_ratio = Integer.valueOf(((Element)data.get("child_rating_low_skill_ratio")).attributeValue("value")).intValue();
/* 254 */       this.child_rating_high_skill_ratio = Integer.valueOf(((Element)data.get("child_rating_high_skill_ratio")).attributeValue("value")).intValue();
/* 255 */       this.child_rating_super_skill_ratio = Integer.valueOf(((Element)data.get("child_rating_super_skill_ratio")).attributeValue("value")).intValue();
/* 256 */       this.child_rating_special_skill_ratio = Integer.valueOf(((Element)data.get("child_rating_special_skill_ratio")).attributeValue("value")).intValue();
/* 257 */       this.child_rating_equip_level_ratio = Integer.valueOf(((Element)data.get("child_rating_equip_level_ratio")).attributeValue("value")).intValue();
/* 258 */       this.child_rating_occupation_skill_ratio = Integer.valueOf(((Element)data.get("child_rating_occupation_skill_ratio")).attributeValue("value")).intValue();
/* 259 */       this.child_rating_aptitude_ratio = Integer.valueOf(((Element)data.get("child_rating_aptitude_ratio")).attributeValue("value")).intValue();
/* 260 */       this.child_rating_grow_ratio = Integer.valueOf(((Element)data.get("child_rating_grow_ratio")).attributeValue("value")).intValue();
/* 261 */       this.child_rating_compute_count = Integer.valueOf(((Element)data.get("child_rating_compute_count")).attributeValue("value")).intValue();
/* 262 */       this.cardClassType = Integer.valueOf(((Element)data.get("cardClassType")).attributeValue("value")).intValue();
/* 263 */       this.cardLevel = Integer.valueOf(((Element)data.get("cardLevel")).attributeValue("value")).intValue();
/* 264 */       this.baby_auto_bao_shi_value = Integer.valueOf(((Element)data.get("baby_auto_bao_shi_value")).attributeValue("value")).intValue();
/* 265 */       this.baby_auto_clean_value = Integer.valueOf(((Element)data.get("baby_auto_clean_value")).attributeValue("value")).intValue();
/* 266 */       this.baby_auto_mood_value = Integer.valueOf(((Element)data.get("baby_auto_mood_value")).attributeValue("value")).intValue();
/* 267 */       this.baby_auto_tired_value = Integer.valueOf(((Element)data.get("baby_auto_tired_value")).attributeValue("value")).intValue();
/* 268 */       this.auto_breed_cost_yuanbao_per_health_point = Integer.valueOf(((Element)data.get("auto_breed_cost_yuanbao_per_health_point")).attributeValue("value")).intValue();
/* 269 */       this.discard_child_num_limit = Integer.valueOf(((Element)data.get("discard_child_num_limit")).attributeValue("value")).intValue();
/* 270 */       this.period_recall_times_limit = Integer.valueOf(((Element)data.get("period_recall_times_limit")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 274 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 279 */     String path = dir + "mzm.gsp.children.confbean.SChildrenConsts.xml";
/*     */     try
/*     */     {
/* 282 */       SAXReader reader = new SAXReader();
/* 283 */       org.dom4j.Document doc = reader.read(new File(path));
/* 284 */       Element root = doc.getRootElement();
/* 285 */       Map<String, Element> data = new java.util.HashMap();
/* 286 */       java.util.List<?> nodeList = root.elements();
/* 287 */       int len = nodeList.size();
/* 288 */       for (int i = 0; i < len; i++)
/*     */       {
/* 290 */         Element element = (Element)nodeList.get(i);
/* 291 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 294 */           String name = element.attributeValue("name");
/* 295 */           if (data.put(name, element) != null)
/* 296 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 299 */       this.children_function_open_level = Integer.valueOf(((Element)data.get("children_function_open_level")).attributeValue("value")).intValue();
/* 300 */       this.single_children_need_score = Integer.valueOf(((Element)data.get("single_children_need_score")).attributeValue("value")).intValue();
/* 301 */       this.pregnant_cut_vigor_score = Integer.valueOf(((Element)data.get("pregnant_cut_vigor_score")).attributeValue("value")).intValue();
/* 302 */       this.prepare_pregnant_need_score = Integer.valueOf(((Element)data.get("prepare_pregnant_need_score")).attributeValue("value")).intValue();
/* 303 */       this.give_birth_need_score = Integer.valueOf(((Element)data.get("give_birth_need_score")).attributeValue("value")).intValue();
/* 304 */       this.give_birth_days = Integer.valueOf(((Element)data.get("give_birth_days")).attributeValue("value")).intValue();
/* 305 */       this.max_children_can_carrey = Integer.valueOf(((Element)data.get("max_children_can_carrey")).attributeValue("value")).intValue();
/* 306 */       this.select_pregnant_wait_seconds = Integer.valueOf(((Element)data.get("select_pregnant_wait_seconds")).attributeValue("value")).intValue();
/* 307 */       this.change_name_cost_gold_value = Integer.valueOf(((Element)data.get("change_name_cost_gold_value")).attributeValue("value")).intValue();
/* 308 */       this.change_name_min_length = Integer.valueOf(((Element)data.get("change_name_min_length")).attributeValue("value")).intValue();
/* 309 */       this.change_name_max_length = Integer.valueOf(((Element)data.get("change_name_max_length")).attributeValue("value")).intValue();
/* 310 */       this.pregnant_npc_id = Integer.valueOf(((Element)data.get("pregnant_npc_id")).attributeValue("value")).intValue();
/* 311 */       this.pregnant_npc_service_id = Integer.valueOf(((Element)data.get("pregnant_npc_service_id")).attributeValue("value")).intValue();
/* 312 */       this.abortion_notify_mail_id = Integer.valueOf(((Element)data.get("abortion_notify_mail_id")).attributeValue("value")).intValue();
/* 313 */       this.breed_give_up_notify_mail_id = Integer.valueOf(((Element)data.get("breed_give_up_notify_mail_id")).attributeValue("value")).intValue();
/* 314 */       this.child_give_up_notify_mail_id = Integer.valueOf(((Element)data.get("child_give_up_notify_mail_id")).attributeValue("value")).intValue();
/* 315 */       this.boy_default_name = String.valueOf(((Element)data.get("boy_default_name")).attributeValue("value"));
/* 316 */       this.girl_default_name = String.valueOf(((Element)data.get("girl_default_name")).attributeValue("value"));
/* 317 */       this.grow_diary_record_num = Integer.valueOf(((Element)data.get("grow_diary_record_num")).attributeValue("value")).intValue();
/* 318 */       this.BOY_BABY_BASE_CFG_ID = Integer.valueOf(((Element)data.get("BOY_BABY_BASE_CFG_ID")).attributeValue("value")).intValue();
/* 319 */       this.GIRL_BABY_BASE_CFG_ID = Integer.valueOf(((Element)data.get("GIRL_BABY_BASE_CFG_ID")).attributeValue("value")).intValue();
/* 320 */       this.BOY_CHILDHOOD_BASE_CFG_ID = Integer.valueOf(((Element)data.get("BOY_CHILDHOOD_BASE_CFG_ID")).attributeValue("value")).intValue();
/* 321 */       this.GIRL_CHILDHOOD_BASE_CFG_ID = Integer.valueOf(((Element)data.get("GIRL_CHILDHOOD_BASE_CFG_ID")).attributeValue("value")).intValue();
/* 322 */       this.BOY_ADULT1_BASE_CFG_ID = Integer.valueOf(((Element)data.get("BOY_ADULT1_BASE_CFG_ID")).attributeValue("value")).intValue();
/* 323 */       this.BOY_ADULT2_BASE_CFG_ID = Integer.valueOf(((Element)data.get("BOY_ADULT2_BASE_CFG_ID")).attributeValue("value")).intValue();
/* 324 */       this.GIRL_ADULT1_BASE_CFG_ID = Integer.valueOf(((Element)data.get("GIRL_ADULT1_BASE_CFG_ID")).attributeValue("value")).intValue();
/* 325 */       this.GIRL_ADULT2_BASE_CFG_ID = Integer.valueOf(((Element)data.get("GIRL_ADULT2_BASE_CFG_ID")).attributeValue("value")).intValue();
/* 326 */       this.baby_max_bao_shi_value = Integer.valueOf(((Element)data.get("baby_max_bao_shi_value")).attributeValue("value")).intValue();
/* 327 */       this.baby_max_clean_value = Integer.valueOf(((Element)data.get("baby_max_clean_value")).attributeValue("value")).intValue();
/* 328 */       this.baby_max_moood_value = Integer.valueOf(((Element)data.get("baby_max_moood_value")).attributeValue("value")).intValue();
/* 329 */       this.baby_max_tired_value = Integer.valueOf(((Element)data.get("baby_max_tired_value")).attributeValue("value")).intValue();
/* 330 */       this.baby_to_childhood_need_health_value = Integer.valueOf(((Element)data.get("baby_to_childhood_need_health_value")).attributeValue("value")).intValue();
/* 331 */       this.baby_sleep_reduce_tired__every_hour = Integer.valueOf(((Element)data.get("baby_sleep_reduce_tired__every_hour")).attributeValue("value")).intValue();
/* 332 */       this.baby_reduce_bao_shi_every_hour = Integer.valueOf(((Element)data.get("baby_reduce_bao_shi_every_hour")).attributeValue("value")).intValue();
/* 333 */       this.baby_reduce_clean_every_hour = Integer.valueOf(((Element)data.get("baby_reduce_clean_every_hour")).attributeValue("value")).intValue();
/* 334 */       this.baby_max_moood_every_hour = Integer.valueOf(((Element)data.get("baby_max_moood_every_hour")).attributeValue("value")).intValue();
/* 335 */       this.baby_health_value_add_value_one_day = Integer.valueOf(((Element)data.get("baby_health_value_add_value_one_day")).attributeValue("value")).intValue();
/* 336 */       this.baby_min_bao_shi_to_add_health = Integer.valueOf(((Element)data.get("baby_min_bao_shi_to_add_health")).attributeValue("value")).intValue();
/* 337 */       this.baby_min_clean_to_add_health = Integer.valueOf(((Element)data.get("baby_min_clean_to_add_health")).attributeValue("value")).intValue();
/* 338 */       this.baby_min_mood_value_to_add_health = Integer.valueOf(((Element)data.get("baby_min_mood_value_to_add_health")).attributeValue("value")).intValue();
/* 339 */       this.baby_suckle_seconds = Integer.valueOf(((Element)data.get("baby_suckle_seconds")).attributeValue("value")).intValue();
/* 340 */       this.baby_change_diaper_seconds = Integer.valueOf(((Element)data.get("baby_change_diaper_seconds")).attributeValue("value")).intValue();
/* 341 */       this.baby_tickle_seconds = Integer.valueOf(((Element)data.get("baby_tickle_seconds")).attributeValue("value")).intValue();
/* 342 */       this.baby_sleep_hours = Integer.valueOf(((Element)data.get("baby_sleep_hours")).attributeValue("value")).intValue();
/* 343 */       this.baby_reduce_bao_shi_init_value = Integer.valueOf(((Element)data.get("baby_reduce_bao_shi_init_value")).attributeValue("value")).intValue();
/* 344 */       this.baby_reduce_clean_init_value = Integer.valueOf(((Element)data.get("baby_reduce_clean_init_value")).attributeValue("value")).intValue();
/* 345 */       this.baby_moood_init_value = Integer.valueOf(((Element)data.get("baby_moood_init_value")).attributeValue("value")).intValue();
/* 346 */       this.baby_health_init_value = Integer.valueOf(((Element)data.get("baby_health_init_value")).attributeValue("value")).intValue();
/* 347 */       this.baby_tired_init_value = Integer.valueOf(((Element)data.get("baby_tired_init_value")).attributeValue("value")).intValue();
/* 348 */       this.child_base_prop_type_id = Integer.valueOf(((Element)data.get("child_base_prop_type_id")).attributeValue("value")).intValue();
/* 349 */       this.child_hp_aptitude_max = Integer.valueOf(((Element)data.get("child_hp_aptitude_max")).attributeValue("value")).intValue();
/* 350 */       this.child_phy_atk_aptitude_max = Integer.valueOf(((Element)data.get("child_phy_atk_aptitude_max")).attributeValue("value")).intValue();
/* 351 */       this.child_mag_atk_aptitude_max = Integer.valueOf(((Element)data.get("child_mag_atk_aptitude_max")).attributeValue("value")).intValue();
/* 352 */       this.child_phy_def_aptitude_max = Integer.valueOf(((Element)data.get("child_phy_def_aptitude_max")).attributeValue("value")).intValue();
/* 353 */       this.child_mag_def_aptitude_max = Integer.valueOf(((Element)data.get("child_mag_def_aptitude_max")).attributeValue("value")).intValue();
/* 354 */       this.child_speed_aptitude_max = Integer.valueOf(((Element)data.get("child_speed_aptitude_max")).attributeValue("value")).intValue();
/* 355 */       this.child_init_skill_pos_max = Integer.valueOf(((Element)data.get("child_init_skill_pos_max")).attributeValue("value")).intValue();
/* 356 */       this.child_level_up_add_STR = Integer.valueOf(((Element)data.get("child_level_up_add_STR")).attributeValue("value")).intValue();
/* 357 */       this.child_level_up_add_DEX = Integer.valueOf(((Element)data.get("child_level_up_add_DEX")).attributeValue("value")).intValue();
/* 358 */       this.child_level_up_add_SPR = Integer.valueOf(((Element)data.get("child_level_up_add_SPR")).attributeValue("value")).intValue();
/* 359 */       this.child_level_up_add_STA = Integer.valueOf(((Element)data.get("child_level_up_add_STA")).attributeValue("value")).intValue();
/* 360 */       this.child_level_up_add_CON = Integer.valueOf(((Element)data.get("child_level_up_add_CON")).attributeValue("value")).intValue();
/* 361 */       this.child_one_skill_replace_rate = Integer.valueOf(((Element)data.get("child_one_skill_replace_rate")).attributeValue("value")).intValue();
/* 362 */       this.child_two_skill_replace_rate = Integer.valueOf(((Element)data.get("child_two_skill_replace_rate")).attributeValue("value")).intValue();
/* 363 */       this.child_three_skill_replace_rate = Integer.valueOf(((Element)data.get("child_three_skill_replace_rate")).attributeValue("value")).intValue();
/* 364 */       this.child_over_three_skill_replace_rate = Integer.valueOf(((Element)data.get("child_over_three_skill_replace_rate")).attributeValue("value")).intValue();
/* 365 */       this.child_fight_skill_max = Integer.valueOf(((Element)data.get("child_fight_skill_max")).attributeValue("value")).intValue();
/* 366 */       this.child_level_up_add_potential_num = Integer.valueOf(((Element)data.get("child_level_up_add_potential_num")).attributeValue("value")).intValue();
/* 367 */       this.child_use_aptitude_item_max = Integer.valueOf(((Element)data.get("child_use_aptitude_item_max")).attributeValue("value")).intValue();
/* 368 */       this.child_use_grow_item_max = Integer.valueOf(((Element)data.get("child_use_grow_item_max")).attributeValue("value")).intValue();
/* 369 */       this.child_auto_set_potential_point = Integer.valueOf(((Element)data.get("child_auto_set_potential_point")).attributeValue("value")).intValue();
/* 370 */       this.child_default_grow_value = Double.valueOf(((Element)data.get("child_default_grow_value")).attributeValue("value")).doubleValue();
/* 371 */       this.child_common_skill_max = Integer.valueOf(((Element)data.get("child_common_skill_max")).attributeValue("value")).intValue();
/* 372 */       this.resetPrefCost = Integer.valueOf(((Element)data.get("resetPrefCost")).attributeValue("value")).intValue();
/* 373 */       this.child_grow_max = Double.valueOf(((Element)data.get("child_grow_max")).attributeValue("value")).doubleValue();
/* 374 */       this.child_grow_character_init = Integer.valueOf(((Element)data.get("child_grow_character_init")).attributeValue("value")).intValue();
/* 375 */       this.child_grow_character_max = Integer.valueOf(((Element)data.get("child_grow_character_max")).attributeValue("value")).intValue();
/* 376 */       this.child_summon_max = Integer.valueOf(((Element)data.get("child_summon_max")).attributeValue("value")).intValue();
/* 377 */       this.child_change_occcupation_cost = Integer.valueOf(((Element)data.get("child_change_occcupation_cost")).attributeValue("value")).intValue();
/* 378 */       this.child_init_STR = Integer.valueOf(((Element)data.get("child_init_STR")).attributeValue("value")).intValue();
/* 379 */       this.child_init_DEX = Integer.valueOf(((Element)data.get("child_init_DEX")).attributeValue("value")).intValue();
/* 380 */       this.child_init_SPR = Integer.valueOf(((Element)data.get("child_init_SPR")).attributeValue("value")).intValue();
/* 381 */       this.child_init_STA = Integer.valueOf(((Element)data.get("child_init_STA")).attributeValue("value")).intValue();
/* 382 */       this.child_init_CON = Integer.valueOf(((Element)data.get("child_init_CON")).attributeValue("value")).intValue();
/* 383 */       this.child_random_property_main_item = Integer.valueOf(((Element)data.get("child_random_property_main_item")).attributeValue("value")).intValue();
/* 384 */       this.child_random_property_sub_item = Integer.valueOf(((Element)data.get("child_random_property_sub_item")).attributeValue("value")).intValue();
/* 385 */       this.child_random_property_item_count = Integer.valueOf(((Element)data.get("child_random_property_item_count")).attributeValue("value")).intValue();
/* 386 */       this.child_take_twoskills_equipment_level = Integer.valueOf(((Element)data.get("child_take_twoskills_equipment_level")).attributeValue("value")).intValue();
/* 387 */       this.child_rating_low_skill_ratio = Integer.valueOf(((Element)data.get("child_rating_low_skill_ratio")).attributeValue("value")).intValue();
/* 388 */       this.child_rating_high_skill_ratio = Integer.valueOf(((Element)data.get("child_rating_high_skill_ratio")).attributeValue("value")).intValue();
/* 389 */       this.child_rating_super_skill_ratio = Integer.valueOf(((Element)data.get("child_rating_super_skill_ratio")).attributeValue("value")).intValue();
/* 390 */       this.child_rating_special_skill_ratio = Integer.valueOf(((Element)data.get("child_rating_special_skill_ratio")).attributeValue("value")).intValue();
/* 391 */       this.child_rating_equip_level_ratio = Integer.valueOf(((Element)data.get("child_rating_equip_level_ratio")).attributeValue("value")).intValue();
/* 392 */       this.child_rating_occupation_skill_ratio = Integer.valueOf(((Element)data.get("child_rating_occupation_skill_ratio")).attributeValue("value")).intValue();
/* 393 */       this.child_rating_aptitude_ratio = Integer.valueOf(((Element)data.get("child_rating_aptitude_ratio")).attributeValue("value")).intValue();
/* 394 */       this.child_rating_grow_ratio = Integer.valueOf(((Element)data.get("child_rating_grow_ratio")).attributeValue("value")).intValue();
/* 395 */       this.child_rating_compute_count = Integer.valueOf(((Element)data.get("child_rating_compute_count")).attributeValue("value")).intValue();
/* 396 */       this.cardClassType = Integer.valueOf(((Element)data.get("cardClassType")).attributeValue("value")).intValue();
/* 397 */       this.cardLevel = Integer.valueOf(((Element)data.get("cardLevel")).attributeValue("value")).intValue();
/* 398 */       this.baby_auto_bao_shi_value = Integer.valueOf(((Element)data.get("baby_auto_bao_shi_value")).attributeValue("value")).intValue();
/* 399 */       this.baby_auto_clean_value = Integer.valueOf(((Element)data.get("baby_auto_clean_value")).attributeValue("value")).intValue();
/* 400 */       this.baby_auto_mood_value = Integer.valueOf(((Element)data.get("baby_auto_mood_value")).attributeValue("value")).intValue();
/* 401 */       this.baby_auto_tired_value = Integer.valueOf(((Element)data.get("baby_auto_tired_value")).attributeValue("value")).intValue();
/* 402 */       this.auto_breed_cost_yuanbao_per_health_point = Integer.valueOf(((Element)data.get("auto_breed_cost_yuanbao_per_health_point")).attributeValue("value")).intValue();
/* 403 */       this.discard_child_num_limit = Integer.valueOf(((Element)data.get("discard_child_num_limit")).attributeValue("value")).intValue();
/* 404 */       this.period_recall_times_limit = Integer.valueOf(((Element)data.get("period_recall_times_limit")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 408 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 412 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 415 */     String path = dir + "mzm.gsp.children.confbean.SChildrenConsts.bny";
/*     */     try
/*     */     {
/* 418 */       File file = new File(path);
/* 419 */       if (file.exists())
/*     */       {
/* 421 */         byte[] bytes = new byte['Ѐ'];
/* 422 */         FileInputStream fis = new FileInputStream(file);
/* 423 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 424 */         int len = 0;
/* 425 */         while ((len = fis.read(bytes)) > 0)
/* 426 */           baos.write(bytes, 0, len);
/* 427 */         fis.close();
/* 428 */         bytes = baos.toByteArray();
/* 429 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 430 */         this.children_function_open_level = _os_.unmarshal_int();
/* 431 */         this.single_children_need_score = _os_.unmarshal_int();
/* 432 */         this.pregnant_cut_vigor_score = _os_.unmarshal_int();
/* 433 */         this.prepare_pregnant_need_score = _os_.unmarshal_int();
/* 434 */         this.give_birth_need_score = _os_.unmarshal_int();
/* 435 */         this.give_birth_days = _os_.unmarshal_int();
/* 436 */         this.max_children_can_carrey = _os_.unmarshal_int();
/* 437 */         this.select_pregnant_wait_seconds = _os_.unmarshal_int();
/* 438 */         this.change_name_cost_gold_value = _os_.unmarshal_int();
/* 439 */         this.change_name_min_length = _os_.unmarshal_int();
/* 440 */         this.change_name_max_length = _os_.unmarshal_int();
/* 441 */         this.pregnant_npc_id = _os_.unmarshal_int();
/* 442 */         this.pregnant_npc_service_id = _os_.unmarshal_int();
/* 443 */         this.abortion_notify_mail_id = _os_.unmarshal_int();
/* 444 */         this.breed_give_up_notify_mail_id = _os_.unmarshal_int();
/* 445 */         this.child_give_up_notify_mail_id = _os_.unmarshal_int();
/* 446 */         this.boy_default_name = _os_.unmarshal_String("UTF-8");
/* 447 */         this.girl_default_name = _os_.unmarshal_String("UTF-8");
/* 448 */         this.grow_diary_record_num = _os_.unmarshal_int();
/* 449 */         this.BOY_BABY_BASE_CFG_ID = _os_.unmarshal_int();
/* 450 */         this.GIRL_BABY_BASE_CFG_ID = _os_.unmarshal_int();
/* 451 */         this.BOY_CHILDHOOD_BASE_CFG_ID = _os_.unmarshal_int();
/* 452 */         this.GIRL_CHILDHOOD_BASE_CFG_ID = _os_.unmarshal_int();
/* 453 */         this.BOY_ADULT1_BASE_CFG_ID = _os_.unmarshal_int();
/* 454 */         this.BOY_ADULT2_BASE_CFG_ID = _os_.unmarshal_int();
/* 455 */         this.GIRL_ADULT1_BASE_CFG_ID = _os_.unmarshal_int();
/* 456 */         this.GIRL_ADULT2_BASE_CFG_ID = _os_.unmarshal_int();
/* 457 */         this.baby_max_bao_shi_value = _os_.unmarshal_int();
/* 458 */         this.baby_max_clean_value = _os_.unmarshal_int();
/* 459 */         this.baby_max_moood_value = _os_.unmarshal_int();
/* 460 */         this.baby_max_tired_value = _os_.unmarshal_int();
/* 461 */         this.baby_to_childhood_need_health_value = _os_.unmarshal_int();
/* 462 */         this.baby_sleep_reduce_tired__every_hour = _os_.unmarshal_int();
/* 463 */         this.baby_reduce_bao_shi_every_hour = _os_.unmarshal_int();
/* 464 */         this.baby_reduce_clean_every_hour = _os_.unmarshal_int();
/* 465 */         this.baby_max_moood_every_hour = _os_.unmarshal_int();
/* 466 */         this.baby_health_value_add_value_one_day = _os_.unmarshal_int();
/* 467 */         this.baby_min_bao_shi_to_add_health = _os_.unmarshal_int();
/* 468 */         this.baby_min_clean_to_add_health = _os_.unmarshal_int();
/* 469 */         this.baby_min_mood_value_to_add_health = _os_.unmarshal_int();
/* 470 */         this.baby_suckle_seconds = _os_.unmarshal_int();
/* 471 */         this.baby_change_diaper_seconds = _os_.unmarshal_int();
/* 472 */         this.baby_tickle_seconds = _os_.unmarshal_int();
/* 473 */         this.baby_sleep_hours = _os_.unmarshal_int();
/* 474 */         this.baby_reduce_bao_shi_init_value = _os_.unmarshal_int();
/* 475 */         this.baby_reduce_clean_init_value = _os_.unmarshal_int();
/* 476 */         this.baby_moood_init_value = _os_.unmarshal_int();
/* 477 */         this.baby_health_init_value = _os_.unmarshal_int();
/* 478 */         this.baby_tired_init_value = _os_.unmarshal_int();
/* 479 */         this.child_base_prop_type_id = _os_.unmarshal_int();
/* 480 */         this.child_hp_aptitude_max = _os_.unmarshal_int();
/* 481 */         this.child_phy_atk_aptitude_max = _os_.unmarshal_int();
/* 482 */         this.child_mag_atk_aptitude_max = _os_.unmarshal_int();
/* 483 */         this.child_phy_def_aptitude_max = _os_.unmarshal_int();
/* 484 */         this.child_mag_def_aptitude_max = _os_.unmarshal_int();
/* 485 */         this.child_speed_aptitude_max = _os_.unmarshal_int();
/* 486 */         this.child_init_skill_pos_max = _os_.unmarshal_int();
/* 487 */         this.child_level_up_add_STR = _os_.unmarshal_int();
/* 488 */         this.child_level_up_add_DEX = _os_.unmarshal_int();
/* 489 */         this.child_level_up_add_SPR = _os_.unmarshal_int();
/* 490 */         this.child_level_up_add_STA = _os_.unmarshal_int();
/* 491 */         this.child_level_up_add_CON = _os_.unmarshal_int();
/* 492 */         this.child_one_skill_replace_rate = _os_.unmarshal_int();
/* 493 */         this.child_two_skill_replace_rate = _os_.unmarshal_int();
/* 494 */         this.child_three_skill_replace_rate = _os_.unmarshal_int();
/* 495 */         this.child_over_three_skill_replace_rate = _os_.unmarshal_int();
/* 496 */         this.child_fight_skill_max = _os_.unmarshal_int();
/* 497 */         this.child_level_up_add_potential_num = _os_.unmarshal_int();
/* 498 */         this.child_use_aptitude_item_max = _os_.unmarshal_int();
/* 499 */         this.child_use_grow_item_max = _os_.unmarshal_int();
/* 500 */         this.child_auto_set_potential_point = _os_.unmarshal_int();
/* 501 */         this.child_default_grow_value = _os_.unmarshal_float();
/* 502 */         this.child_common_skill_max = _os_.unmarshal_int();
/* 503 */         this.resetPrefCost = _os_.unmarshal_int();
/* 504 */         this.child_grow_max = _os_.unmarshal_float();
/* 505 */         this.child_grow_character_init = _os_.unmarshal_int();
/* 506 */         this.child_grow_character_max = _os_.unmarshal_int();
/* 507 */         this.child_summon_max = _os_.unmarshal_int();
/* 508 */         this.child_change_occcupation_cost = _os_.unmarshal_int();
/* 509 */         this.child_init_STR = _os_.unmarshal_int();
/* 510 */         this.child_init_DEX = _os_.unmarshal_int();
/* 511 */         this.child_init_SPR = _os_.unmarshal_int();
/* 512 */         this.child_init_STA = _os_.unmarshal_int();
/* 513 */         this.child_init_CON = _os_.unmarshal_int();
/* 514 */         this.child_random_property_main_item = _os_.unmarshal_int();
/* 515 */         this.child_random_property_sub_item = _os_.unmarshal_int();
/* 516 */         this.child_random_property_item_count = _os_.unmarshal_int();
/* 517 */         this.child_take_twoskills_equipment_level = _os_.unmarshal_int();
/* 518 */         this.child_rating_low_skill_ratio = _os_.unmarshal_int();
/* 519 */         this.child_rating_high_skill_ratio = _os_.unmarshal_int();
/* 520 */         this.child_rating_super_skill_ratio = _os_.unmarshal_int();
/* 521 */         this.child_rating_special_skill_ratio = _os_.unmarshal_int();
/* 522 */         this.child_rating_equip_level_ratio = _os_.unmarshal_int();
/* 523 */         this.child_rating_occupation_skill_ratio = _os_.unmarshal_int();
/* 524 */         this.child_rating_aptitude_ratio = _os_.unmarshal_int();
/* 525 */         this.child_rating_grow_ratio = _os_.unmarshal_int();
/* 526 */         this.child_rating_compute_count = _os_.unmarshal_int();
/* 527 */         this.cardClassType = _os_.unmarshal_int();
/* 528 */         this.cardLevel = _os_.unmarshal_int();
/* 529 */         this.baby_auto_bao_shi_value = _os_.unmarshal_int();
/* 530 */         this.baby_auto_clean_value = _os_.unmarshal_int();
/* 531 */         this.baby_auto_mood_value = _os_.unmarshal_int();
/* 532 */         this.baby_auto_tired_value = _os_.unmarshal_int();
/* 533 */         this.auto_breed_cost_yuanbao_per_health_point = _os_.unmarshal_int();
/* 534 */         this.discard_child_num_limit = _os_.unmarshal_int();
/* 535 */         this.period_recall_times_limit = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 540 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 546 */     String path = dir + "mzm.gsp.children.confbean.SChildrenConsts.bny";
/*     */     try
/*     */     {
/* 549 */       File file = new File(path);
/* 550 */       if (file.exists())
/*     */       {
/* 552 */         byte[] bytes = new byte['Ѐ'];
/* 553 */         FileInputStream fis = new FileInputStream(file);
/* 554 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 555 */         int len = 0;
/* 556 */         while ((len = fis.read(bytes)) > 0)
/* 557 */           baos.write(bytes, 0, len);
/* 558 */         fis.close();
/* 559 */         bytes = baos.toByteArray();
/* 560 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 561 */         this.children_function_open_level = _os_.unmarshal_int();
/* 562 */         this.single_children_need_score = _os_.unmarshal_int();
/* 563 */         this.pregnant_cut_vigor_score = _os_.unmarshal_int();
/* 564 */         this.prepare_pregnant_need_score = _os_.unmarshal_int();
/* 565 */         this.give_birth_need_score = _os_.unmarshal_int();
/* 566 */         this.give_birth_days = _os_.unmarshal_int();
/* 567 */         this.max_children_can_carrey = _os_.unmarshal_int();
/* 568 */         this.select_pregnant_wait_seconds = _os_.unmarshal_int();
/* 569 */         this.change_name_cost_gold_value = _os_.unmarshal_int();
/* 570 */         this.change_name_min_length = _os_.unmarshal_int();
/* 571 */         this.change_name_max_length = _os_.unmarshal_int();
/* 572 */         this.pregnant_npc_id = _os_.unmarshal_int();
/* 573 */         this.pregnant_npc_service_id = _os_.unmarshal_int();
/* 574 */         this.abortion_notify_mail_id = _os_.unmarshal_int();
/* 575 */         this.breed_give_up_notify_mail_id = _os_.unmarshal_int();
/* 576 */         this.child_give_up_notify_mail_id = _os_.unmarshal_int();
/* 577 */         this.boy_default_name = _os_.unmarshal_String("UTF-8");
/* 578 */         this.girl_default_name = _os_.unmarshal_String("UTF-8");
/* 579 */         this.grow_diary_record_num = _os_.unmarshal_int();
/* 580 */         this.BOY_BABY_BASE_CFG_ID = _os_.unmarshal_int();
/* 581 */         this.GIRL_BABY_BASE_CFG_ID = _os_.unmarshal_int();
/* 582 */         this.BOY_CHILDHOOD_BASE_CFG_ID = _os_.unmarshal_int();
/* 583 */         this.GIRL_CHILDHOOD_BASE_CFG_ID = _os_.unmarshal_int();
/* 584 */         this.BOY_ADULT1_BASE_CFG_ID = _os_.unmarshal_int();
/* 585 */         this.BOY_ADULT2_BASE_CFG_ID = _os_.unmarshal_int();
/* 586 */         this.GIRL_ADULT1_BASE_CFG_ID = _os_.unmarshal_int();
/* 587 */         this.GIRL_ADULT2_BASE_CFG_ID = _os_.unmarshal_int();
/* 588 */         this.baby_max_bao_shi_value = _os_.unmarshal_int();
/* 589 */         this.baby_max_clean_value = _os_.unmarshal_int();
/* 590 */         this.baby_max_moood_value = _os_.unmarshal_int();
/* 591 */         this.baby_max_tired_value = _os_.unmarshal_int();
/* 592 */         this.baby_to_childhood_need_health_value = _os_.unmarshal_int();
/* 593 */         this.baby_sleep_reduce_tired__every_hour = _os_.unmarshal_int();
/* 594 */         this.baby_reduce_bao_shi_every_hour = _os_.unmarshal_int();
/* 595 */         this.baby_reduce_clean_every_hour = _os_.unmarshal_int();
/* 596 */         this.baby_max_moood_every_hour = _os_.unmarshal_int();
/* 597 */         this.baby_health_value_add_value_one_day = _os_.unmarshal_int();
/* 598 */         this.baby_min_bao_shi_to_add_health = _os_.unmarshal_int();
/* 599 */         this.baby_min_clean_to_add_health = _os_.unmarshal_int();
/* 600 */         this.baby_min_mood_value_to_add_health = _os_.unmarshal_int();
/* 601 */         this.baby_suckle_seconds = _os_.unmarshal_int();
/* 602 */         this.baby_change_diaper_seconds = _os_.unmarshal_int();
/* 603 */         this.baby_tickle_seconds = _os_.unmarshal_int();
/* 604 */         this.baby_sleep_hours = _os_.unmarshal_int();
/* 605 */         this.baby_reduce_bao_shi_init_value = _os_.unmarshal_int();
/* 606 */         this.baby_reduce_clean_init_value = _os_.unmarshal_int();
/* 607 */         this.baby_moood_init_value = _os_.unmarshal_int();
/* 608 */         this.baby_health_init_value = _os_.unmarshal_int();
/* 609 */         this.baby_tired_init_value = _os_.unmarshal_int();
/* 610 */         this.child_base_prop_type_id = _os_.unmarshal_int();
/* 611 */         this.child_hp_aptitude_max = _os_.unmarshal_int();
/* 612 */         this.child_phy_atk_aptitude_max = _os_.unmarshal_int();
/* 613 */         this.child_mag_atk_aptitude_max = _os_.unmarshal_int();
/* 614 */         this.child_phy_def_aptitude_max = _os_.unmarshal_int();
/* 615 */         this.child_mag_def_aptitude_max = _os_.unmarshal_int();
/* 616 */         this.child_speed_aptitude_max = _os_.unmarshal_int();
/* 617 */         this.child_init_skill_pos_max = _os_.unmarshal_int();
/* 618 */         this.child_level_up_add_STR = _os_.unmarshal_int();
/* 619 */         this.child_level_up_add_DEX = _os_.unmarshal_int();
/* 620 */         this.child_level_up_add_SPR = _os_.unmarshal_int();
/* 621 */         this.child_level_up_add_STA = _os_.unmarshal_int();
/* 622 */         this.child_level_up_add_CON = _os_.unmarshal_int();
/* 623 */         this.child_one_skill_replace_rate = _os_.unmarshal_int();
/* 624 */         this.child_two_skill_replace_rate = _os_.unmarshal_int();
/* 625 */         this.child_three_skill_replace_rate = _os_.unmarshal_int();
/* 626 */         this.child_over_three_skill_replace_rate = _os_.unmarshal_int();
/* 627 */         this.child_fight_skill_max = _os_.unmarshal_int();
/* 628 */         this.child_level_up_add_potential_num = _os_.unmarshal_int();
/* 629 */         this.child_use_aptitude_item_max = _os_.unmarshal_int();
/* 630 */         this.child_use_grow_item_max = _os_.unmarshal_int();
/* 631 */         this.child_auto_set_potential_point = _os_.unmarshal_int();
/* 632 */         this.child_default_grow_value = _os_.unmarshal_float();
/* 633 */         this.child_common_skill_max = _os_.unmarshal_int();
/* 634 */         this.resetPrefCost = _os_.unmarshal_int();
/* 635 */         this.child_grow_max = _os_.unmarshal_float();
/* 636 */         this.child_grow_character_init = _os_.unmarshal_int();
/* 637 */         this.child_grow_character_max = _os_.unmarshal_int();
/* 638 */         this.child_summon_max = _os_.unmarshal_int();
/* 639 */         this.child_change_occcupation_cost = _os_.unmarshal_int();
/* 640 */         this.child_init_STR = _os_.unmarshal_int();
/* 641 */         this.child_init_DEX = _os_.unmarshal_int();
/* 642 */         this.child_init_SPR = _os_.unmarshal_int();
/* 643 */         this.child_init_STA = _os_.unmarshal_int();
/* 644 */         this.child_init_CON = _os_.unmarshal_int();
/* 645 */         this.child_random_property_main_item = _os_.unmarshal_int();
/* 646 */         this.child_random_property_sub_item = _os_.unmarshal_int();
/* 647 */         this.child_random_property_item_count = _os_.unmarshal_int();
/* 648 */         this.child_take_twoskills_equipment_level = _os_.unmarshal_int();
/* 649 */         this.child_rating_low_skill_ratio = _os_.unmarshal_int();
/* 650 */         this.child_rating_high_skill_ratio = _os_.unmarshal_int();
/* 651 */         this.child_rating_super_skill_ratio = _os_.unmarshal_int();
/* 652 */         this.child_rating_special_skill_ratio = _os_.unmarshal_int();
/* 653 */         this.child_rating_equip_level_ratio = _os_.unmarshal_int();
/* 654 */         this.child_rating_occupation_skill_ratio = _os_.unmarshal_int();
/* 655 */         this.child_rating_aptitude_ratio = _os_.unmarshal_int();
/* 656 */         this.child_rating_grow_ratio = _os_.unmarshal_int();
/* 657 */         this.child_rating_compute_count = _os_.unmarshal_int();
/* 658 */         this.cardClassType = _os_.unmarshal_int();
/* 659 */         this.cardLevel = _os_.unmarshal_int();
/* 660 */         this.baby_auto_bao_shi_value = _os_.unmarshal_int();
/* 661 */         this.baby_auto_clean_value = _os_.unmarshal_int();
/* 662 */         this.baby_auto_mood_value = _os_.unmarshal_int();
/* 663 */         this.baby_auto_tired_value = _os_.unmarshal_int();
/* 664 */         this.auto_breed_cost_yuanbao_per_health_point = _os_.unmarshal_int();
/* 665 */         this.discard_child_num_limit = _os_.unmarshal_int();
/* 666 */         this.period_recall_times_limit = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 671 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SChildrenConsts newInstance)
/*     */   {
/* 677 */     oldInstance = instance;
/* 678 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 683 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\confbean\SChildrenConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */