/*     */ package mzm.gsp.luckystar.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SLuckyStarUserGroupOriginalCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SLuckyStarUserGroupOriginalCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SLuckyStarUserGroupOriginalCfg> all = null;
/*     */   
/*     */   public int recommend_user_group_id;
/*     */   public int activity_cfg_id;
/*     */   public int lastLogoffTime;
/*     */   public int role_level_min;
/*     */   public int role_level_max;
/*     */   public int save_amt_min;
/*     */   public int save_amt_max;
/*     */   public int last_week_save_amt_min;
/*     */   public int last_week_save_amt_max;
/*     */   public int last_two_week_save_amt_min;
/*     */   public int last_two_week_save_amt_max;
/*     */   public int last_month_save_amt_min;
/*     */   public int last_month_save_amt_max;
/*     */   public int balance_min;
/*     */   public int balance_max;
/*     */   public int open_server_limit_time_cfg_id;
/*     */   public int create_role_limit_time_cfg_id;
/*     */   public int equip_qi_lin_level_average_min;
/*     */   public int equip_qi_lin_level_average_max;
/*     */   public int wing_level_min;
/*     */   public int wing_level_max;
/*     */   public int common_fabao_star_level_average_min;
/*     */   public int common_fabao_star_level_average_max;
/*     */   public int gold_fabao_star_level_min;
/*     */   public int gold_fabao_star_level_max;
/*     */   public int wind_fabao_star_level_min;
/*     */   public int wind_fabao_star_level_max;
/*     */   public int shen_shou_num_min;
/*     */   public int shen_shou_num_max;
/*     */   public int mo_shou_num_min;
/*     */   public int mo_shou_num_max;
/*     */   public int all_shou_num_min;
/*     */   public int all_shou_num_max;
/*     */   public int shen_shou_skill_num_min;
/*     */   public int shen_shou_skill_num_max;
/*     */   public int top_fight_pet_hu_fu_level_min;
/*     */   public int top_fight_pet_hu_fu_level_max;
/*     */   public int role_fight_value_min;
/*     */   public int role_fight_value_max;
/*     */   public int role_total_fight_value_min;
/*     */   public int role_total_fight_value_max;
/*     */   public int panda_mounts_rank_min;
/*     */   public int panda_mounts_rank_max;
/*     */   public int dou_dou_mounts_rank_min;
/*     */   public int dou_dou_mounts_rank_max;
/*     */   public int meng_yan_mounts_rank_min;
/*     */   public int meng_yan_mounts_rank_max;
/*     */   public int fox_mounts_rank_min;
/*     */   public int fox_mounts_rank_max;
/*     */   public int leopard_mounts_rank_min;
/*     */   public int leopard_mounts_rank_max;
/*     */   public int partner_yuan_shen_level_min;
/*     */   public int partner_yuan_shen_level_max;
/*     */   public int child_equip_level_min;
/*     */   public int child_equip_level_max;
/*     */   public int own_equip_skill;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  77 */     this.recommend_user_group_id = Integer.valueOf(rootElement.attributeValue("recommend_user_group_id")).intValue();
/*  78 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  79 */     this.lastLogoffTime = Integer.valueOf(rootElement.attributeValue("lastLogoffTime")).intValue();
/*  80 */     this.role_level_min = Integer.valueOf(rootElement.attributeValue("role_level_min")).intValue();
/*  81 */     this.role_level_max = Integer.valueOf(rootElement.attributeValue("role_level_max")).intValue();
/*  82 */     this.save_amt_min = Integer.valueOf(rootElement.attributeValue("save_amt_min")).intValue();
/*  83 */     this.save_amt_max = Integer.valueOf(rootElement.attributeValue("save_amt_max")).intValue();
/*  84 */     this.last_week_save_amt_min = Integer.valueOf(rootElement.attributeValue("last_week_save_amt_min")).intValue();
/*  85 */     this.last_week_save_amt_max = Integer.valueOf(rootElement.attributeValue("last_week_save_amt_max")).intValue();
/*  86 */     this.last_two_week_save_amt_min = Integer.valueOf(rootElement.attributeValue("last_two_week_save_amt_min")).intValue();
/*  87 */     this.last_two_week_save_amt_max = Integer.valueOf(rootElement.attributeValue("last_two_week_save_amt_max")).intValue();
/*  88 */     this.last_month_save_amt_min = Integer.valueOf(rootElement.attributeValue("last_month_save_amt_min")).intValue();
/*  89 */     this.last_month_save_amt_max = Integer.valueOf(rootElement.attributeValue("last_month_save_amt_max")).intValue();
/*  90 */     this.balance_min = Integer.valueOf(rootElement.attributeValue("balance_min")).intValue();
/*  91 */     this.balance_max = Integer.valueOf(rootElement.attributeValue("balance_max")).intValue();
/*  92 */     this.open_server_limit_time_cfg_id = Integer.valueOf(rootElement.attributeValue("open_server_limit_time_cfg_id")).intValue();
/*  93 */     this.create_role_limit_time_cfg_id = Integer.valueOf(rootElement.attributeValue("create_role_limit_time_cfg_id")).intValue();
/*  94 */     this.equip_qi_lin_level_average_min = Integer.valueOf(rootElement.attributeValue("equip_qi_lin_level_average_min")).intValue();
/*  95 */     this.equip_qi_lin_level_average_max = Integer.valueOf(rootElement.attributeValue("equip_qi_lin_level_average_max")).intValue();
/*  96 */     this.wing_level_min = Integer.valueOf(rootElement.attributeValue("wing_level_min")).intValue();
/*  97 */     this.wing_level_max = Integer.valueOf(rootElement.attributeValue("wing_level_max")).intValue();
/*  98 */     this.common_fabao_star_level_average_min = Integer.valueOf(rootElement.attributeValue("common_fabao_star_level_average_min")).intValue();
/*  99 */     this.common_fabao_star_level_average_max = Integer.valueOf(rootElement.attributeValue("common_fabao_star_level_average_max")).intValue();
/* 100 */     this.gold_fabao_star_level_min = Integer.valueOf(rootElement.attributeValue("gold_fabao_star_level_min")).intValue();
/* 101 */     this.gold_fabao_star_level_max = Integer.valueOf(rootElement.attributeValue("gold_fabao_star_level_max")).intValue();
/* 102 */     this.wind_fabao_star_level_min = Integer.valueOf(rootElement.attributeValue("wind_fabao_star_level_min")).intValue();
/* 103 */     this.wind_fabao_star_level_max = Integer.valueOf(rootElement.attributeValue("wind_fabao_star_level_max")).intValue();
/* 104 */     this.shen_shou_num_min = Integer.valueOf(rootElement.attributeValue("shen_shou_num_min")).intValue();
/* 105 */     this.shen_shou_num_max = Integer.valueOf(rootElement.attributeValue("shen_shou_num_max")).intValue();
/* 106 */     this.mo_shou_num_min = Integer.valueOf(rootElement.attributeValue("mo_shou_num_min")).intValue();
/* 107 */     this.mo_shou_num_max = Integer.valueOf(rootElement.attributeValue("mo_shou_num_max")).intValue();
/* 108 */     this.all_shou_num_min = Integer.valueOf(rootElement.attributeValue("all_shou_num_min")).intValue();
/* 109 */     this.all_shou_num_max = Integer.valueOf(rootElement.attributeValue("all_shou_num_max")).intValue();
/* 110 */     this.shen_shou_skill_num_min = Integer.valueOf(rootElement.attributeValue("shen_shou_skill_num_min")).intValue();
/* 111 */     this.shen_shou_skill_num_max = Integer.valueOf(rootElement.attributeValue("shen_shou_skill_num_max")).intValue();
/* 112 */     this.top_fight_pet_hu_fu_level_min = Integer.valueOf(rootElement.attributeValue("top_fight_pet_hu_fu_level_min")).intValue();
/* 113 */     this.top_fight_pet_hu_fu_level_max = Integer.valueOf(rootElement.attributeValue("top_fight_pet_hu_fu_level_max")).intValue();
/* 114 */     this.role_fight_value_min = Integer.valueOf(rootElement.attributeValue("role_fight_value_min")).intValue();
/* 115 */     this.role_fight_value_max = Integer.valueOf(rootElement.attributeValue("role_fight_value_max")).intValue();
/* 116 */     this.role_total_fight_value_min = Integer.valueOf(rootElement.attributeValue("role_total_fight_value_min")).intValue();
/* 117 */     this.role_total_fight_value_max = Integer.valueOf(rootElement.attributeValue("role_total_fight_value_max")).intValue();
/* 118 */     this.panda_mounts_rank_min = Integer.valueOf(rootElement.attributeValue("panda_mounts_rank_min")).intValue();
/* 119 */     this.panda_mounts_rank_max = Integer.valueOf(rootElement.attributeValue("panda_mounts_rank_max")).intValue();
/* 120 */     this.dou_dou_mounts_rank_min = Integer.valueOf(rootElement.attributeValue("dou_dou_mounts_rank_min")).intValue();
/* 121 */     this.dou_dou_mounts_rank_max = Integer.valueOf(rootElement.attributeValue("dou_dou_mounts_rank_max")).intValue();
/* 122 */     this.meng_yan_mounts_rank_min = Integer.valueOf(rootElement.attributeValue("meng_yan_mounts_rank_min")).intValue();
/* 123 */     this.meng_yan_mounts_rank_max = Integer.valueOf(rootElement.attributeValue("meng_yan_mounts_rank_max")).intValue();
/* 124 */     this.fox_mounts_rank_min = Integer.valueOf(rootElement.attributeValue("fox_mounts_rank_min")).intValue();
/* 125 */     this.fox_mounts_rank_max = Integer.valueOf(rootElement.attributeValue("fox_mounts_rank_max")).intValue();
/* 126 */     this.leopard_mounts_rank_min = Integer.valueOf(rootElement.attributeValue("leopard_mounts_rank_min")).intValue();
/* 127 */     this.leopard_mounts_rank_max = Integer.valueOf(rootElement.attributeValue("leopard_mounts_rank_max")).intValue();
/* 128 */     this.partner_yuan_shen_level_min = Integer.valueOf(rootElement.attributeValue("partner_yuan_shen_level_min")).intValue();
/* 129 */     this.partner_yuan_shen_level_max = Integer.valueOf(rootElement.attributeValue("partner_yuan_shen_level_max")).intValue();
/* 130 */     this.child_equip_level_min = Integer.valueOf(rootElement.attributeValue("child_equip_level_min")).intValue();
/* 131 */     this.child_equip_level_max = Integer.valueOf(rootElement.attributeValue("child_equip_level_max")).intValue();
/* 132 */     this.own_equip_skill = Integer.valueOf(rootElement.attributeValue("own_equip_skill")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 137 */     _os_.marshal(this.recommend_user_group_id);
/* 138 */     _os_.marshal(this.activity_cfg_id);
/* 139 */     _os_.marshal(this.lastLogoffTime);
/* 140 */     _os_.marshal(this.role_level_min);
/* 141 */     _os_.marshal(this.role_level_max);
/* 142 */     _os_.marshal(this.save_amt_min);
/* 143 */     _os_.marshal(this.save_amt_max);
/* 144 */     _os_.marshal(this.last_week_save_amt_min);
/* 145 */     _os_.marshal(this.last_week_save_amt_max);
/* 146 */     _os_.marshal(this.last_two_week_save_amt_min);
/* 147 */     _os_.marshal(this.last_two_week_save_amt_max);
/* 148 */     _os_.marshal(this.last_month_save_amt_min);
/* 149 */     _os_.marshal(this.last_month_save_amt_max);
/* 150 */     _os_.marshal(this.balance_min);
/* 151 */     _os_.marshal(this.balance_max);
/* 152 */     _os_.marshal(this.open_server_limit_time_cfg_id);
/* 153 */     _os_.marshal(this.create_role_limit_time_cfg_id);
/* 154 */     _os_.marshal(this.equip_qi_lin_level_average_min);
/* 155 */     _os_.marshal(this.equip_qi_lin_level_average_max);
/* 156 */     _os_.marshal(this.wing_level_min);
/* 157 */     _os_.marshal(this.wing_level_max);
/* 158 */     _os_.marshal(this.common_fabao_star_level_average_min);
/* 159 */     _os_.marshal(this.common_fabao_star_level_average_max);
/* 160 */     _os_.marshal(this.gold_fabao_star_level_min);
/* 161 */     _os_.marshal(this.gold_fabao_star_level_max);
/* 162 */     _os_.marshal(this.wind_fabao_star_level_min);
/* 163 */     _os_.marshal(this.wind_fabao_star_level_max);
/* 164 */     _os_.marshal(this.shen_shou_num_min);
/* 165 */     _os_.marshal(this.shen_shou_num_max);
/* 166 */     _os_.marshal(this.mo_shou_num_min);
/* 167 */     _os_.marshal(this.mo_shou_num_max);
/* 168 */     _os_.marshal(this.all_shou_num_min);
/* 169 */     _os_.marshal(this.all_shou_num_max);
/* 170 */     _os_.marshal(this.shen_shou_skill_num_min);
/* 171 */     _os_.marshal(this.shen_shou_skill_num_max);
/* 172 */     _os_.marshal(this.top_fight_pet_hu_fu_level_min);
/* 173 */     _os_.marshal(this.top_fight_pet_hu_fu_level_max);
/* 174 */     _os_.marshal(this.role_fight_value_min);
/* 175 */     _os_.marshal(this.role_fight_value_max);
/* 176 */     _os_.marshal(this.role_total_fight_value_min);
/* 177 */     _os_.marshal(this.role_total_fight_value_max);
/* 178 */     _os_.marshal(this.panda_mounts_rank_min);
/* 179 */     _os_.marshal(this.panda_mounts_rank_max);
/* 180 */     _os_.marshal(this.dou_dou_mounts_rank_min);
/* 181 */     _os_.marshal(this.dou_dou_mounts_rank_max);
/* 182 */     _os_.marshal(this.meng_yan_mounts_rank_min);
/* 183 */     _os_.marshal(this.meng_yan_mounts_rank_max);
/* 184 */     _os_.marshal(this.fox_mounts_rank_min);
/* 185 */     _os_.marshal(this.fox_mounts_rank_max);
/* 186 */     _os_.marshal(this.leopard_mounts_rank_min);
/* 187 */     _os_.marshal(this.leopard_mounts_rank_max);
/* 188 */     _os_.marshal(this.partner_yuan_shen_level_min);
/* 189 */     _os_.marshal(this.partner_yuan_shen_level_max);
/* 190 */     _os_.marshal(this.child_equip_level_min);
/* 191 */     _os_.marshal(this.child_equip_level_max);
/* 192 */     _os_.marshal(this.own_equip_skill);
/* 193 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 198 */     this.recommend_user_group_id = _os_.unmarshal_int();
/* 199 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 200 */     this.lastLogoffTime = _os_.unmarshal_int();
/* 201 */     this.role_level_min = _os_.unmarshal_int();
/* 202 */     this.role_level_max = _os_.unmarshal_int();
/* 203 */     this.save_amt_min = _os_.unmarshal_int();
/* 204 */     this.save_amt_max = _os_.unmarshal_int();
/* 205 */     this.last_week_save_amt_min = _os_.unmarshal_int();
/* 206 */     this.last_week_save_amt_max = _os_.unmarshal_int();
/* 207 */     this.last_two_week_save_amt_min = _os_.unmarshal_int();
/* 208 */     this.last_two_week_save_amt_max = _os_.unmarshal_int();
/* 209 */     this.last_month_save_amt_min = _os_.unmarshal_int();
/* 210 */     this.last_month_save_amt_max = _os_.unmarshal_int();
/* 211 */     this.balance_min = _os_.unmarshal_int();
/* 212 */     this.balance_max = _os_.unmarshal_int();
/* 213 */     this.open_server_limit_time_cfg_id = _os_.unmarshal_int();
/* 214 */     this.create_role_limit_time_cfg_id = _os_.unmarshal_int();
/* 215 */     this.equip_qi_lin_level_average_min = _os_.unmarshal_int();
/* 216 */     this.equip_qi_lin_level_average_max = _os_.unmarshal_int();
/* 217 */     this.wing_level_min = _os_.unmarshal_int();
/* 218 */     this.wing_level_max = _os_.unmarshal_int();
/* 219 */     this.common_fabao_star_level_average_min = _os_.unmarshal_int();
/* 220 */     this.common_fabao_star_level_average_max = _os_.unmarshal_int();
/* 221 */     this.gold_fabao_star_level_min = _os_.unmarshal_int();
/* 222 */     this.gold_fabao_star_level_max = _os_.unmarshal_int();
/* 223 */     this.wind_fabao_star_level_min = _os_.unmarshal_int();
/* 224 */     this.wind_fabao_star_level_max = _os_.unmarshal_int();
/* 225 */     this.shen_shou_num_min = _os_.unmarshal_int();
/* 226 */     this.shen_shou_num_max = _os_.unmarshal_int();
/* 227 */     this.mo_shou_num_min = _os_.unmarshal_int();
/* 228 */     this.mo_shou_num_max = _os_.unmarshal_int();
/* 229 */     this.all_shou_num_min = _os_.unmarshal_int();
/* 230 */     this.all_shou_num_max = _os_.unmarshal_int();
/* 231 */     this.shen_shou_skill_num_min = _os_.unmarshal_int();
/* 232 */     this.shen_shou_skill_num_max = _os_.unmarshal_int();
/* 233 */     this.top_fight_pet_hu_fu_level_min = _os_.unmarshal_int();
/* 234 */     this.top_fight_pet_hu_fu_level_max = _os_.unmarshal_int();
/* 235 */     this.role_fight_value_min = _os_.unmarshal_int();
/* 236 */     this.role_fight_value_max = _os_.unmarshal_int();
/* 237 */     this.role_total_fight_value_min = _os_.unmarshal_int();
/* 238 */     this.role_total_fight_value_max = _os_.unmarshal_int();
/* 239 */     this.panda_mounts_rank_min = _os_.unmarshal_int();
/* 240 */     this.panda_mounts_rank_max = _os_.unmarshal_int();
/* 241 */     this.dou_dou_mounts_rank_min = _os_.unmarshal_int();
/* 242 */     this.dou_dou_mounts_rank_max = _os_.unmarshal_int();
/* 243 */     this.meng_yan_mounts_rank_min = _os_.unmarshal_int();
/* 244 */     this.meng_yan_mounts_rank_max = _os_.unmarshal_int();
/* 245 */     this.fox_mounts_rank_min = _os_.unmarshal_int();
/* 246 */     this.fox_mounts_rank_max = _os_.unmarshal_int();
/* 247 */     this.leopard_mounts_rank_min = _os_.unmarshal_int();
/* 248 */     this.leopard_mounts_rank_max = _os_.unmarshal_int();
/* 249 */     this.partner_yuan_shen_level_min = _os_.unmarshal_int();
/* 250 */     this.partner_yuan_shen_level_max = _os_.unmarshal_int();
/* 251 */     this.child_equip_level_min = _os_.unmarshal_int();
/* 252 */     this.child_equip_level_max = _os_.unmarshal_int();
/* 253 */     this.own_equip_skill = _os_.unmarshal_int();
/* 254 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 259 */     String path = dir + "mzm.gsp.luckystar.confbean.SLuckyStarUserGroupOriginalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 263 */       all = new java.util.HashMap();
/* 264 */       SAXReader reader = new SAXReader();
/* 265 */       org.dom4j.Document doc = reader.read(new File(path));
/* 266 */       Element root = doc.getRootElement();
/* 267 */       List<?> nodeList = root.elements();
/* 268 */       int len = nodeList.size();
/* 269 */       for (int i = 0; i < len; i++)
/*     */       {
/* 271 */         Element elem = (Element)nodeList.get(i);
/* 272 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.luckystar.confbean.SLuckyStarUserGroupOriginalCfg"))
/*     */         {
/*     */ 
/* 275 */           SLuckyStarUserGroupOriginalCfg obj = new SLuckyStarUserGroupOriginalCfg();
/* 276 */           obj.loadFromXml(elem);
/* 277 */           if (all.put(Integer.valueOf(obj.recommend_user_group_id), obj) != null) {
/* 278 */             throw new RuntimeException("duplicate key : " + obj.recommend_user_group_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 283 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SLuckyStarUserGroupOriginalCfg> all)
/*     */   {
/* 289 */     String path = dir + "mzm.gsp.luckystar.confbean.SLuckyStarUserGroupOriginalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 293 */       SAXReader reader = new SAXReader();
/* 294 */       org.dom4j.Document doc = reader.read(new File(path));
/* 295 */       Element root = doc.getRootElement();
/* 296 */       List<?> nodeList = root.elements();
/* 297 */       int len = nodeList.size();
/* 298 */       for (int i = 0; i < len; i++)
/*     */       {
/* 300 */         Element elem = (Element)nodeList.get(i);
/* 301 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.luckystar.confbean.SLuckyStarUserGroupOriginalCfg"))
/*     */         {
/*     */ 
/* 304 */           SLuckyStarUserGroupOriginalCfg obj = new SLuckyStarUserGroupOriginalCfg();
/* 305 */           obj.loadFromXml(elem);
/* 306 */           if (all.put(Integer.valueOf(obj.recommend_user_group_id), obj) != null) {
/* 307 */             throw new RuntimeException("duplicate key : " + obj.recommend_user_group_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 312 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 318 */     all = new java.util.HashMap();
/*     */     
/* 320 */     String path = dir + "mzm.gsp.luckystar.confbean.SLuckyStarUserGroupOriginalCfg.bny";
/*     */     try
/*     */     {
/* 323 */       File file = new File(path);
/* 324 */       if (file.exists())
/*     */       {
/* 326 */         byte[] bytes = new byte['Ѐ'];
/* 327 */         FileInputStream fis = new FileInputStream(file);
/* 328 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 329 */         int len = 0;
/* 330 */         while ((len = fis.read(bytes)) > 0)
/* 331 */           baos.write(bytes, 0, len);
/* 332 */         fis.close();
/* 333 */         bytes = baos.toByteArray();
/* 334 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 335 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 337 */           _os_.unmarshal_int();
/* 338 */           _os_.unmarshal_int();
/* 339 */           _os_.unmarshal_int();
/*     */         }
/* 341 */         _os_.unmarshal_int();
/* 342 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 345 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 347 */           SLuckyStarUserGroupOriginalCfg _v_ = new SLuckyStarUserGroupOriginalCfg();
/* 348 */           _v_.unmarshal(_os_);
/* 349 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 350 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 355 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 360 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SLuckyStarUserGroupOriginalCfg> all)
/*     */   {
/* 367 */     String path = dir + "mzm.gsp.luckystar.confbean.SLuckyStarUserGroupOriginalCfg.bny";
/*     */     try
/*     */     {
/* 370 */       File file = new File(path);
/* 371 */       if (file.exists())
/*     */       {
/* 373 */         byte[] bytes = new byte['Ѐ'];
/* 374 */         FileInputStream fis = new FileInputStream(file);
/* 375 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 376 */         int len = 0;
/* 377 */         while ((len = fis.read(bytes)) > 0)
/* 378 */           baos.write(bytes, 0, len);
/* 379 */         fis.close();
/* 380 */         bytes = baos.toByteArray();
/* 381 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 382 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 384 */           _os_.unmarshal_int();
/* 385 */           _os_.unmarshal_int();
/* 386 */           _os_.unmarshal_int();
/*     */         }
/* 388 */         _os_.unmarshal_int();
/* 389 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 392 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 394 */           SLuckyStarUserGroupOriginalCfg _v_ = new SLuckyStarUserGroupOriginalCfg();
/* 395 */           _v_.unmarshal(_os_);
/* 396 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 397 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 402 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 407 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SLuckyStarUserGroupOriginalCfg getOld(int key)
/*     */   {
/* 415 */     return (SLuckyStarUserGroupOriginalCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SLuckyStarUserGroupOriginalCfg get(int key)
/*     */   {
/* 420 */     return (SLuckyStarUserGroupOriginalCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SLuckyStarUserGroupOriginalCfg> getOldAll()
/*     */   {
/* 425 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SLuckyStarUserGroupOriginalCfg> getAll()
/*     */   {
/* 430 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SLuckyStarUserGroupOriginalCfg> newAll)
/*     */   {
/* 435 */     oldAll = all;
/* 436 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 441 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\confbean\SLuckyStarUserGroupOriginalCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */