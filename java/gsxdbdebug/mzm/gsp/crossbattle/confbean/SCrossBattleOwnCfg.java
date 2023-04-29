/*     */ package mzm.gsp.crossbattle.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SCrossBattleOwnCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SCrossBattleOwnCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SCrossBattleOwnCfg> all = null;
/*     */   
/*     */   public int activity_cfg_id;
/*     */   public int moduleid;
/*     */   public int serverlevel;
/*     */   public int npc_id;
/*     */   public int npc_service_id;
/*     */   public int npc_controller_id;
/*     */   public int register_stage_moduleid;
/*     */   public int register_corps_member_num_lower_limit;
/*     */   public int register_corps_member_num_upper_limit;
/*     */   public int register_cost_type;
/*     */   public int register_cost_num;
/*     */   public int register_mail_cfg_id;
/*     */   public int active_unregister_mail_cfg_id;
/*     */   public int corps_member_num_dissatisfied_unregister_mail_cfg_id;
/*     */   public int vote_stage_moduleid;
/*     */   public int vote_level_limit;
/*     */   public int daily_vote_times_limit;
/*     */   public int vote_fix_award_id;
/*     */   public int canvass_trumpet_cfg_id;
/*     */   public int vote_stage_direct_promotion_corps_num;
/*     */   public int round_robin_stage_promotion_corps_num;
/*     */   public int round_robin_max_corps_num;
/*     */   public int vote_stage_direct_promotion_mail_cfg_id;
/*     */   public int vote_stage_most_votes_mail_cfg_id;
/*     */   public int vote_stage_round_robin_notice_mail_cfg_id;
/*     */   public int vote_stage_encourage_mail_cfg_id;
/*     */   public int vote_stage_rank_page_num;
/*     */   public int vote_stage_notice_mail_cfg_id;
/*     */   public int round_robin_stage_moduleid;
/*     */   public int round_robin_stage_prepare_duration_in_minute;
/*     */   public int round_robin_stage_fight_max_duration_in_minute;
/*     */   public int round_robin_map_cfg_id;
/*     */   public int round_robin_map_transfer_x;
/*     */   public int round_robin_map_transfer_y;
/*     */   public int round_robin_out_map_cfg_id;
/*     */   public int round_robin_out_map_transfer_x;
/*     */   public int round_robin_out_map_transfer_y;
/*     */   public int round_robin_out_npc_id;
/*     */   public int round_robin_out_npc_service_id;
/*     */   public int round_robin_win_point;
/*     */   public int round_robin_lose_point;
/*     */   public int round_robin_stage_promotion_mail_cfg_id;
/*     */   public int round_robin_stage_encourage_mail_cfg_id;
/*  61 */   public ArrayList<Integer> round_robin_time_points = new ArrayList();
/*  62 */   public ArrayList<Integer> round_robin_backup_time_points = new ArrayList();
/*     */   public int round_robin_main_remind_mail_cfg_id;
/*     */   public int round_robin_backup_remind_mail_cfg_id;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  68 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  69 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  70 */     this.serverlevel = Integer.valueOf(rootElement.attributeValue("serverlevel")).intValue();
/*  71 */     this.npc_id = Integer.valueOf(rootElement.attributeValue("npc_id")).intValue();
/*  72 */     this.npc_service_id = Integer.valueOf(rootElement.attributeValue("npc_service_id")).intValue();
/*  73 */     this.npc_controller_id = Integer.valueOf(rootElement.attributeValue("npc_controller_id")).intValue();
/*  74 */     this.register_stage_moduleid = Integer.valueOf(rootElement.attributeValue("register_stage_moduleid")).intValue();
/*  75 */     this.register_corps_member_num_lower_limit = Integer.valueOf(rootElement.attributeValue("register_corps_member_num_lower_limit")).intValue();
/*  76 */     this.register_corps_member_num_upper_limit = Integer.valueOf(rootElement.attributeValue("register_corps_member_num_upper_limit")).intValue();
/*  77 */     this.register_cost_type = Integer.valueOf(rootElement.attributeValue("register_cost_type")).intValue();
/*  78 */     this.register_cost_num = Integer.valueOf(rootElement.attributeValue("register_cost_num")).intValue();
/*  79 */     this.register_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("register_mail_cfg_id")).intValue();
/*  80 */     this.active_unregister_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("active_unregister_mail_cfg_id")).intValue();
/*  81 */     this.corps_member_num_dissatisfied_unregister_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("corps_member_num_dissatisfied_unregister_mail_cfg_id")).intValue();
/*  82 */     this.vote_stage_moduleid = Integer.valueOf(rootElement.attributeValue("vote_stage_moduleid")).intValue();
/*  83 */     this.vote_level_limit = Integer.valueOf(rootElement.attributeValue("vote_level_limit")).intValue();
/*  84 */     this.daily_vote_times_limit = Integer.valueOf(rootElement.attributeValue("daily_vote_times_limit")).intValue();
/*  85 */     this.vote_fix_award_id = Integer.valueOf(rootElement.attributeValue("vote_fix_award_id")).intValue();
/*  86 */     this.canvass_trumpet_cfg_id = Integer.valueOf(rootElement.attributeValue("canvass_trumpet_cfg_id")).intValue();
/*  87 */     this.vote_stage_direct_promotion_corps_num = Integer.valueOf(rootElement.attributeValue("vote_stage_direct_promotion_corps_num")).intValue();
/*  88 */     this.round_robin_stage_promotion_corps_num = Integer.valueOf(rootElement.attributeValue("round_robin_stage_promotion_corps_num")).intValue();
/*  89 */     this.round_robin_max_corps_num = Integer.valueOf(rootElement.attributeValue("round_robin_max_corps_num")).intValue();
/*  90 */     this.vote_stage_direct_promotion_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("vote_stage_direct_promotion_mail_cfg_id")).intValue();
/*  91 */     this.vote_stage_most_votes_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("vote_stage_most_votes_mail_cfg_id")).intValue();
/*  92 */     this.vote_stage_round_robin_notice_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("vote_stage_round_robin_notice_mail_cfg_id")).intValue();
/*  93 */     this.vote_stage_encourage_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("vote_stage_encourage_mail_cfg_id")).intValue();
/*  94 */     this.vote_stage_rank_page_num = Integer.valueOf(rootElement.attributeValue("vote_stage_rank_page_num")).intValue();
/*  95 */     this.vote_stage_notice_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("vote_stage_notice_mail_cfg_id")).intValue();
/*  96 */     this.round_robin_stage_moduleid = Integer.valueOf(rootElement.attributeValue("round_robin_stage_moduleid")).intValue();
/*  97 */     this.round_robin_stage_prepare_duration_in_minute = Integer.valueOf(rootElement.attributeValue("round_robin_stage_prepare_duration_in_minute")).intValue();
/*  98 */     this.round_robin_stage_fight_max_duration_in_minute = Integer.valueOf(rootElement.attributeValue("round_robin_stage_fight_max_duration_in_minute")).intValue();
/*  99 */     this.round_robin_map_cfg_id = Integer.valueOf(rootElement.attributeValue("round_robin_map_cfg_id")).intValue();
/* 100 */     this.round_robin_map_transfer_x = Integer.valueOf(rootElement.attributeValue("round_robin_map_transfer_x")).intValue();
/* 101 */     this.round_robin_map_transfer_y = Integer.valueOf(rootElement.attributeValue("round_robin_map_transfer_y")).intValue();
/* 102 */     this.round_robin_out_map_cfg_id = Integer.valueOf(rootElement.attributeValue("round_robin_out_map_cfg_id")).intValue();
/* 103 */     this.round_robin_out_map_transfer_x = Integer.valueOf(rootElement.attributeValue("round_robin_out_map_transfer_x")).intValue();
/* 104 */     this.round_robin_out_map_transfer_y = Integer.valueOf(rootElement.attributeValue("round_robin_out_map_transfer_y")).intValue();
/* 105 */     this.round_robin_out_npc_id = Integer.valueOf(rootElement.attributeValue("round_robin_out_npc_id")).intValue();
/* 106 */     this.round_robin_out_npc_service_id = Integer.valueOf(rootElement.attributeValue("round_robin_out_npc_service_id")).intValue();
/* 107 */     this.round_robin_win_point = Integer.valueOf(rootElement.attributeValue("round_robin_win_point")).intValue();
/* 108 */     this.round_robin_lose_point = Integer.valueOf(rootElement.attributeValue("round_robin_lose_point")).intValue();
/* 109 */     this.round_robin_stage_promotion_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("round_robin_stage_promotion_mail_cfg_id")).intValue();
/* 110 */     this.round_robin_stage_encourage_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("round_robin_stage_encourage_mail_cfg_id")).intValue();
/*     */     
/* 112 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "round_robin_time_points");
/* 113 */     if (collectionElement == null)
/*     */     {
/* 115 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 118 */     List<?> _nodeList = collectionElement.elements();
/* 119 */     int _len = _nodeList.size();
/* 120 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 122 */       Element elem = (Element)_nodeList.get(i);
/* 123 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 130 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 137 */         this.round_robin_time_points.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 141 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "round_robin_backup_time_points");
/* 142 */     if (collectionElement == null)
/*     */     {
/* 144 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 147 */     List<?> _nodeList = collectionElement.elements();
/* 148 */     int _len = _nodeList.size();
/* 149 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 151 */       Element elem = (Element)_nodeList.get(i);
/* 152 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 159 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 166 */         this.round_robin_backup_time_points.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/* 169 */     this.round_robin_main_remind_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("round_robin_main_remind_mail_cfg_id")).intValue();
/* 170 */     this.round_robin_backup_remind_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("round_robin_backup_remind_mail_cfg_id")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 175 */     _os_.marshal(this.activity_cfg_id);
/* 176 */     _os_.marshal(this.moduleid);
/* 177 */     _os_.marshal(this.serverlevel);
/* 178 */     _os_.marshal(this.npc_id);
/* 179 */     _os_.marshal(this.npc_service_id);
/* 180 */     _os_.marshal(this.npc_controller_id);
/* 181 */     _os_.marshal(this.register_stage_moduleid);
/* 182 */     _os_.marshal(this.register_corps_member_num_lower_limit);
/* 183 */     _os_.marshal(this.register_corps_member_num_upper_limit);
/* 184 */     _os_.marshal(this.register_cost_type);
/* 185 */     _os_.marshal(this.register_cost_num);
/* 186 */     _os_.marshal(this.register_mail_cfg_id);
/* 187 */     _os_.marshal(this.active_unregister_mail_cfg_id);
/* 188 */     _os_.marshal(this.corps_member_num_dissatisfied_unregister_mail_cfg_id);
/* 189 */     _os_.marshal(this.vote_stage_moduleid);
/* 190 */     _os_.marshal(this.vote_level_limit);
/* 191 */     _os_.marshal(this.daily_vote_times_limit);
/* 192 */     _os_.marshal(this.vote_fix_award_id);
/* 193 */     _os_.marshal(this.canvass_trumpet_cfg_id);
/* 194 */     _os_.marshal(this.vote_stage_direct_promotion_corps_num);
/* 195 */     _os_.marshal(this.round_robin_stage_promotion_corps_num);
/* 196 */     _os_.marshal(this.round_robin_max_corps_num);
/* 197 */     _os_.marshal(this.vote_stage_direct_promotion_mail_cfg_id);
/* 198 */     _os_.marshal(this.vote_stage_most_votes_mail_cfg_id);
/* 199 */     _os_.marshal(this.vote_stage_round_robin_notice_mail_cfg_id);
/* 200 */     _os_.marshal(this.vote_stage_encourage_mail_cfg_id);
/* 201 */     _os_.marshal(this.vote_stage_rank_page_num);
/* 202 */     _os_.marshal(this.vote_stage_notice_mail_cfg_id);
/* 203 */     _os_.marshal(this.round_robin_stage_moduleid);
/* 204 */     _os_.marshal(this.round_robin_stage_prepare_duration_in_minute);
/* 205 */     _os_.marshal(this.round_robin_stage_fight_max_duration_in_minute);
/* 206 */     _os_.marshal(this.round_robin_map_cfg_id);
/* 207 */     _os_.marshal(this.round_robin_map_transfer_x);
/* 208 */     _os_.marshal(this.round_robin_map_transfer_y);
/* 209 */     _os_.marshal(this.round_robin_out_map_cfg_id);
/* 210 */     _os_.marshal(this.round_robin_out_map_transfer_x);
/* 211 */     _os_.marshal(this.round_robin_out_map_transfer_y);
/* 212 */     _os_.marshal(this.round_robin_out_npc_id);
/* 213 */     _os_.marshal(this.round_robin_out_npc_service_id);
/* 214 */     _os_.marshal(this.round_robin_win_point);
/* 215 */     _os_.marshal(this.round_robin_lose_point);
/* 216 */     _os_.marshal(this.round_robin_stage_promotion_mail_cfg_id);
/* 217 */     _os_.marshal(this.round_robin_stage_encourage_mail_cfg_id);
/* 218 */     _os_.compact_uint32(this.round_robin_time_points.size());
/* 219 */     for (Integer _v_ : this.round_robin_time_points)
/*     */     {
/* 221 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 223 */     _os_.compact_uint32(this.round_robin_backup_time_points.size());
/* 224 */     for (Integer _v_ : this.round_robin_backup_time_points)
/*     */     {
/* 226 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 228 */     _os_.marshal(this.round_robin_main_remind_mail_cfg_id);
/* 229 */     _os_.marshal(this.round_robin_backup_remind_mail_cfg_id);
/* 230 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 235 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 236 */     this.moduleid = _os_.unmarshal_int();
/* 237 */     this.serverlevel = _os_.unmarshal_int();
/* 238 */     this.npc_id = _os_.unmarshal_int();
/* 239 */     this.npc_service_id = _os_.unmarshal_int();
/* 240 */     this.npc_controller_id = _os_.unmarshal_int();
/* 241 */     this.register_stage_moduleid = _os_.unmarshal_int();
/* 242 */     this.register_corps_member_num_lower_limit = _os_.unmarshal_int();
/* 243 */     this.register_corps_member_num_upper_limit = _os_.unmarshal_int();
/* 244 */     this.register_cost_type = _os_.unmarshal_int();
/* 245 */     this.register_cost_num = _os_.unmarshal_int();
/* 246 */     this.register_mail_cfg_id = _os_.unmarshal_int();
/* 247 */     this.active_unregister_mail_cfg_id = _os_.unmarshal_int();
/* 248 */     this.corps_member_num_dissatisfied_unregister_mail_cfg_id = _os_.unmarshal_int();
/* 249 */     this.vote_stage_moduleid = _os_.unmarshal_int();
/* 250 */     this.vote_level_limit = _os_.unmarshal_int();
/* 251 */     this.daily_vote_times_limit = _os_.unmarshal_int();
/* 252 */     this.vote_fix_award_id = _os_.unmarshal_int();
/* 253 */     this.canvass_trumpet_cfg_id = _os_.unmarshal_int();
/* 254 */     this.vote_stage_direct_promotion_corps_num = _os_.unmarshal_int();
/* 255 */     this.round_robin_stage_promotion_corps_num = _os_.unmarshal_int();
/* 256 */     this.round_robin_max_corps_num = _os_.unmarshal_int();
/* 257 */     this.vote_stage_direct_promotion_mail_cfg_id = _os_.unmarshal_int();
/* 258 */     this.vote_stage_most_votes_mail_cfg_id = _os_.unmarshal_int();
/* 259 */     this.vote_stage_round_robin_notice_mail_cfg_id = _os_.unmarshal_int();
/* 260 */     this.vote_stage_encourage_mail_cfg_id = _os_.unmarshal_int();
/* 261 */     this.vote_stage_rank_page_num = _os_.unmarshal_int();
/* 262 */     this.vote_stage_notice_mail_cfg_id = _os_.unmarshal_int();
/* 263 */     this.round_robin_stage_moduleid = _os_.unmarshal_int();
/* 264 */     this.round_robin_stage_prepare_duration_in_minute = _os_.unmarshal_int();
/* 265 */     this.round_robin_stage_fight_max_duration_in_minute = _os_.unmarshal_int();
/* 266 */     this.round_robin_map_cfg_id = _os_.unmarshal_int();
/* 267 */     this.round_robin_map_transfer_x = _os_.unmarshal_int();
/* 268 */     this.round_robin_map_transfer_y = _os_.unmarshal_int();
/* 269 */     this.round_robin_out_map_cfg_id = _os_.unmarshal_int();
/* 270 */     this.round_robin_out_map_transfer_x = _os_.unmarshal_int();
/* 271 */     this.round_robin_out_map_transfer_y = _os_.unmarshal_int();
/* 272 */     this.round_robin_out_npc_id = _os_.unmarshal_int();
/* 273 */     this.round_robin_out_npc_service_id = _os_.unmarshal_int();
/* 274 */     this.round_robin_win_point = _os_.unmarshal_int();
/* 275 */     this.round_robin_lose_point = _os_.unmarshal_int();
/* 276 */     this.round_robin_stage_promotion_mail_cfg_id = _os_.unmarshal_int();
/* 277 */     this.round_robin_stage_encourage_mail_cfg_id = _os_.unmarshal_int();
/* 278 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 281 */       int _v_ = _os_.unmarshal_int();
/* 282 */       this.round_robin_time_points.add(Integer.valueOf(_v_));
/*     */     }
/* 284 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 287 */       int _v_ = _os_.unmarshal_int();
/* 288 */       this.round_robin_backup_time_points.add(Integer.valueOf(_v_));
/*     */     }
/* 290 */     this.round_robin_main_remind_mail_cfg_id = _os_.unmarshal_int();
/* 291 */     this.round_robin_backup_remind_mail_cfg_id = _os_.unmarshal_int();
/* 292 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 297 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 301 */       all = new java.util.HashMap();
/* 302 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 303 */       org.dom4j.Document doc = reader.read(new File(path));
/* 304 */       Element root = doc.getRootElement();
/* 305 */       List<?> nodeList = root.elements();
/* 306 */       int len = nodeList.size();
/* 307 */       for (int i = 0; i < len; i++)
/*     */       {
/* 309 */         Element elem = (Element)nodeList.get(i);
/* 310 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg"))
/*     */         {
/*     */ 
/* 313 */           SCrossBattleOwnCfg obj = new SCrossBattleOwnCfg();
/* 314 */           obj.loadFromXml(elem);
/* 315 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 316 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 321 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SCrossBattleOwnCfg> all)
/*     */   {
/* 327 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 331 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 332 */       org.dom4j.Document doc = reader.read(new File(path));
/* 333 */       Element root = doc.getRootElement();
/* 334 */       List<?> nodeList = root.elements();
/* 335 */       int len = nodeList.size();
/* 336 */       for (int i = 0; i < len; i++)
/*     */       {
/* 338 */         Element elem = (Element)nodeList.get(i);
/* 339 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg"))
/*     */         {
/*     */ 
/* 342 */           SCrossBattleOwnCfg obj = new SCrossBattleOwnCfg();
/* 343 */           obj.loadFromXml(elem);
/* 344 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 345 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 350 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 356 */     all = new java.util.HashMap();
/*     */     
/* 358 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg.bny";
/*     */     try
/*     */     {
/* 361 */       File file = new File(path);
/* 362 */       if (file.exists())
/*     */       {
/* 364 */         byte[] bytes = new byte['Ѐ'];
/* 365 */         FileInputStream fis = new FileInputStream(file);
/* 366 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 367 */         int len = 0;
/* 368 */         while ((len = fis.read(bytes)) > 0)
/* 369 */           baos.write(bytes, 0, len);
/* 370 */         fis.close();
/* 371 */         bytes = baos.toByteArray();
/* 372 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 373 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 375 */           _os_.unmarshal_int();
/* 376 */           _os_.unmarshal_int();
/* 377 */           _os_.unmarshal_int();
/*     */         }
/* 379 */         _os_.unmarshal_int();
/* 380 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 383 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 385 */           SCrossBattleOwnCfg _v_ = new SCrossBattleOwnCfg();
/* 386 */           _v_.unmarshal(_os_);
/* 387 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 388 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 393 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 398 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SCrossBattleOwnCfg> all)
/*     */   {
/* 405 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg.bny";
/*     */     try
/*     */     {
/* 408 */       File file = new File(path);
/* 409 */       if (file.exists())
/*     */       {
/* 411 */         byte[] bytes = new byte['Ѐ'];
/* 412 */         FileInputStream fis = new FileInputStream(file);
/* 413 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 414 */         int len = 0;
/* 415 */         while ((len = fis.read(bytes)) > 0)
/* 416 */           baos.write(bytes, 0, len);
/* 417 */         fis.close();
/* 418 */         bytes = baos.toByteArray();
/* 419 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 420 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 422 */           _os_.unmarshal_int();
/* 423 */           _os_.unmarshal_int();
/* 424 */           _os_.unmarshal_int();
/*     */         }
/* 426 */         _os_.unmarshal_int();
/* 427 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 430 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 432 */           SCrossBattleOwnCfg _v_ = new SCrossBattleOwnCfg();
/* 433 */           _v_.unmarshal(_os_);
/* 434 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 435 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 440 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 445 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SCrossBattleOwnCfg getOld(int key)
/*     */   {
/* 453 */     return (SCrossBattleOwnCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SCrossBattleOwnCfg get(int key)
/*     */   {
/* 458 */     return (SCrossBattleOwnCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCrossBattleOwnCfg> getOldAll()
/*     */   {
/* 463 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCrossBattleOwnCfg> getAll()
/*     */   {
/* 468 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SCrossBattleOwnCfg> newAll)
/*     */   {
/* 473 */     oldAll = all;
/* 474 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 479 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\SCrossBattleOwnCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */