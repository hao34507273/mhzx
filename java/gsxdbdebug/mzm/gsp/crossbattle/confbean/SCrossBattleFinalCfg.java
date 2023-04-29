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
/*     */ public class SCrossBattleFinalCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SCrossBattleFinalCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SCrossBattleFinalCfg> all = null;
/*     */   
/*     */   public int activity_cfg_id;
/*     */   public int module_id;
/*     */   public int final_map_cfg_id;
/*     */   public int final_out_map_cfg_id;
/*     */   public int final_out_map_transfer_x;
/*     */   public int final_out_map_transfer_y;
/*     */   public int final_out_npc_id;
/*     */   public int final_out_npc_service_id;
/*     */   public int final_countdown;
/*     */   public int final_match_countdown;
/*     */   public int final_need_team_member_num;
/*     */   public int final_need_team_num;
/*     */   public int fight_times_every_stage;
/*     */   public int final_last_winner_mail_cfg_id;
/*     */   public int final_match_cfg_id;
/*     */   public int final_champion_mail_cfg_id;
/*     */   public int final_second_place_mail_cfg_id;
/*     */   public int final_third_place_mail_cfg_id;
/*     */   public int final_die_out_mail_cfg_id;
/*     */   public int final_rank_up_mail_cfg_id;
/*     */   public int final_bye_rank_up_mail_cfg_id;
/*     */   public int final_4_to_2_fail_mail_cfg_id;
/*     */   public int final_abstain_lose_mail_cfg_id;
/*     */   public int final_abstain_win_mail_cfg_id;
/*     */   public int final_fight_lose_mail_cfg_id;
/*     */   public int final_fight_win_mail_cfg_id;
/*     */   public int final_award_mail_cfg_id;
/*     */   public int final_restart_mail_cfg_id;
/*  46 */   public ArrayList<String> final_stage_name_list = new ArrayList();
/*  47 */   public ArrayList<Integer> final_stage_time_point_list = new ArrayList();
/*     */   public int final_fight_last_time;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  52 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  53 */     this.module_id = Integer.valueOf(rootElement.attributeValue("module_id")).intValue();
/*  54 */     this.final_map_cfg_id = Integer.valueOf(rootElement.attributeValue("final_map_cfg_id")).intValue();
/*  55 */     this.final_out_map_cfg_id = Integer.valueOf(rootElement.attributeValue("final_out_map_cfg_id")).intValue();
/*  56 */     this.final_out_map_transfer_x = Integer.valueOf(rootElement.attributeValue("final_out_map_transfer_x")).intValue();
/*  57 */     this.final_out_map_transfer_y = Integer.valueOf(rootElement.attributeValue("final_out_map_transfer_y")).intValue();
/*  58 */     this.final_out_npc_id = Integer.valueOf(rootElement.attributeValue("final_out_npc_id")).intValue();
/*  59 */     this.final_out_npc_service_id = Integer.valueOf(rootElement.attributeValue("final_out_npc_service_id")).intValue();
/*  60 */     this.final_countdown = Integer.valueOf(rootElement.attributeValue("final_countdown")).intValue();
/*  61 */     this.final_match_countdown = Integer.valueOf(rootElement.attributeValue("final_match_countdown")).intValue();
/*  62 */     this.final_need_team_member_num = Integer.valueOf(rootElement.attributeValue("final_need_team_member_num")).intValue();
/*  63 */     this.final_need_team_num = Integer.valueOf(rootElement.attributeValue("final_need_team_num")).intValue();
/*  64 */     this.fight_times_every_stage = Integer.valueOf(rootElement.attributeValue("fight_times_every_stage")).intValue();
/*  65 */     this.final_last_winner_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("final_last_winner_mail_cfg_id")).intValue();
/*  66 */     this.final_match_cfg_id = Integer.valueOf(rootElement.attributeValue("final_match_cfg_id")).intValue();
/*  67 */     this.final_champion_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("final_champion_mail_cfg_id")).intValue();
/*  68 */     this.final_second_place_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("final_second_place_mail_cfg_id")).intValue();
/*  69 */     this.final_third_place_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("final_third_place_mail_cfg_id")).intValue();
/*  70 */     this.final_die_out_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("final_die_out_mail_cfg_id")).intValue();
/*  71 */     this.final_rank_up_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("final_rank_up_mail_cfg_id")).intValue();
/*  72 */     this.final_bye_rank_up_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("final_bye_rank_up_mail_cfg_id")).intValue();
/*  73 */     this.final_4_to_2_fail_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("final_4_to_2_fail_mail_cfg_id")).intValue();
/*  74 */     this.final_abstain_lose_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("final_abstain_lose_mail_cfg_id")).intValue();
/*  75 */     this.final_abstain_win_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("final_abstain_win_mail_cfg_id")).intValue();
/*  76 */     this.final_fight_lose_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("final_fight_lose_mail_cfg_id")).intValue();
/*  77 */     this.final_fight_win_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("final_fight_win_mail_cfg_id")).intValue();
/*  78 */     this.final_award_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("final_award_mail_cfg_id")).intValue();
/*  79 */     this.final_restart_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("final_restart_mail_cfg_id")).intValue();
/*     */     
/*  81 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "final_stage_name_list");
/*  82 */     if (collectionElement == null)
/*     */     {
/*  84 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  87 */     List<?> _nodeList = collectionElement.elements();
/*  88 */     int _len = _nodeList.size();
/*  89 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  91 */       Element elem = (Element)_nodeList.get(i);
/*  92 */       if (elem.getName().equalsIgnoreCase("string"))
/*     */       {
/*     */         String _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  99 */           _v_ = elem.getText();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 106 */         this.final_stage_name_list.add(_v_);
/*     */       }
/*     */     }
/*     */     
/* 110 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "final_stage_time_point_list");
/* 111 */     if (collectionElement == null)
/*     */     {
/* 113 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 116 */     List<?> _nodeList = collectionElement.elements();
/* 117 */     int _len = _nodeList.size();
/* 118 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 120 */       Element elem = (Element)_nodeList.get(i);
/* 121 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 128 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 135 */         this.final_stage_time_point_list.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/* 138 */     this.final_fight_last_time = Integer.valueOf(rootElement.attributeValue("final_fight_last_time")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 143 */     _os_.marshal(this.activity_cfg_id);
/* 144 */     _os_.marshal(this.module_id);
/* 145 */     _os_.marshal(this.final_map_cfg_id);
/* 146 */     _os_.marshal(this.final_out_map_cfg_id);
/* 147 */     _os_.marshal(this.final_out_map_transfer_x);
/* 148 */     _os_.marshal(this.final_out_map_transfer_y);
/* 149 */     _os_.marshal(this.final_out_npc_id);
/* 150 */     _os_.marshal(this.final_out_npc_service_id);
/* 151 */     _os_.marshal(this.final_countdown);
/* 152 */     _os_.marshal(this.final_match_countdown);
/* 153 */     _os_.marshal(this.final_need_team_member_num);
/* 154 */     _os_.marshal(this.final_need_team_num);
/* 155 */     _os_.marshal(this.fight_times_every_stage);
/* 156 */     _os_.marshal(this.final_last_winner_mail_cfg_id);
/* 157 */     _os_.marshal(this.final_match_cfg_id);
/* 158 */     _os_.marshal(this.final_champion_mail_cfg_id);
/* 159 */     _os_.marshal(this.final_second_place_mail_cfg_id);
/* 160 */     _os_.marshal(this.final_third_place_mail_cfg_id);
/* 161 */     _os_.marshal(this.final_die_out_mail_cfg_id);
/* 162 */     _os_.marshal(this.final_rank_up_mail_cfg_id);
/* 163 */     _os_.marshal(this.final_bye_rank_up_mail_cfg_id);
/* 164 */     _os_.marshal(this.final_4_to_2_fail_mail_cfg_id);
/* 165 */     _os_.marshal(this.final_abstain_lose_mail_cfg_id);
/* 166 */     _os_.marshal(this.final_abstain_win_mail_cfg_id);
/* 167 */     _os_.marshal(this.final_fight_lose_mail_cfg_id);
/* 168 */     _os_.marshal(this.final_fight_win_mail_cfg_id);
/* 169 */     _os_.marshal(this.final_award_mail_cfg_id);
/* 170 */     _os_.marshal(this.final_restart_mail_cfg_id);
/* 171 */     _os_.compact_uint32(this.final_stage_name_list.size());
/* 172 */     for (String _v_ : this.final_stage_name_list)
/*     */     {
/* 174 */       _os_.marshal(_v_, "UTF-8");
/*     */     }
/* 176 */     _os_.compact_uint32(this.final_stage_time_point_list.size());
/* 177 */     for (Integer _v_ : this.final_stage_time_point_list)
/*     */     {
/* 179 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 181 */     _os_.marshal(this.final_fight_last_time);
/* 182 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 187 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 188 */     this.module_id = _os_.unmarshal_int();
/* 189 */     this.final_map_cfg_id = _os_.unmarshal_int();
/* 190 */     this.final_out_map_cfg_id = _os_.unmarshal_int();
/* 191 */     this.final_out_map_transfer_x = _os_.unmarshal_int();
/* 192 */     this.final_out_map_transfer_y = _os_.unmarshal_int();
/* 193 */     this.final_out_npc_id = _os_.unmarshal_int();
/* 194 */     this.final_out_npc_service_id = _os_.unmarshal_int();
/* 195 */     this.final_countdown = _os_.unmarshal_int();
/* 196 */     this.final_match_countdown = _os_.unmarshal_int();
/* 197 */     this.final_need_team_member_num = _os_.unmarshal_int();
/* 198 */     this.final_need_team_num = _os_.unmarshal_int();
/* 199 */     this.fight_times_every_stage = _os_.unmarshal_int();
/* 200 */     this.final_last_winner_mail_cfg_id = _os_.unmarshal_int();
/* 201 */     this.final_match_cfg_id = _os_.unmarshal_int();
/* 202 */     this.final_champion_mail_cfg_id = _os_.unmarshal_int();
/* 203 */     this.final_second_place_mail_cfg_id = _os_.unmarshal_int();
/* 204 */     this.final_third_place_mail_cfg_id = _os_.unmarshal_int();
/* 205 */     this.final_die_out_mail_cfg_id = _os_.unmarshal_int();
/* 206 */     this.final_rank_up_mail_cfg_id = _os_.unmarshal_int();
/* 207 */     this.final_bye_rank_up_mail_cfg_id = _os_.unmarshal_int();
/* 208 */     this.final_4_to_2_fail_mail_cfg_id = _os_.unmarshal_int();
/* 209 */     this.final_abstain_lose_mail_cfg_id = _os_.unmarshal_int();
/* 210 */     this.final_abstain_win_mail_cfg_id = _os_.unmarshal_int();
/* 211 */     this.final_fight_lose_mail_cfg_id = _os_.unmarshal_int();
/* 212 */     this.final_fight_win_mail_cfg_id = _os_.unmarshal_int();
/* 213 */     this.final_award_mail_cfg_id = _os_.unmarshal_int();
/* 214 */     this.final_restart_mail_cfg_id = _os_.unmarshal_int();
/* 215 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 218 */       String _v_ = _os_.unmarshal_String("UTF-8");
/* 219 */       this.final_stage_name_list.add(_v_);
/*     */     }
/* 221 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 224 */       int _v_ = _os_.unmarshal_int();
/* 225 */       this.final_stage_time_point_list.add(Integer.valueOf(_v_));
/*     */     }
/* 227 */     this.final_fight_last_time = _os_.unmarshal_int();
/* 228 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 233 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleFinalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 237 */       all = new java.util.HashMap();
/* 238 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 239 */       org.dom4j.Document doc = reader.read(new File(path));
/* 240 */       Element root = doc.getRootElement();
/* 241 */       List<?> nodeList = root.elements();
/* 242 */       int len = nodeList.size();
/* 243 */       for (int i = 0; i < len; i++)
/*     */       {
/* 245 */         Element elem = (Element)nodeList.get(i);
/* 246 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.SCrossBattleFinalCfg"))
/*     */         {
/*     */ 
/* 249 */           SCrossBattleFinalCfg obj = new SCrossBattleFinalCfg();
/* 250 */           obj.loadFromXml(elem);
/* 251 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 252 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 257 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SCrossBattleFinalCfg> all)
/*     */   {
/* 263 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleFinalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 267 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 268 */       org.dom4j.Document doc = reader.read(new File(path));
/* 269 */       Element root = doc.getRootElement();
/* 270 */       List<?> nodeList = root.elements();
/* 271 */       int len = nodeList.size();
/* 272 */       for (int i = 0; i < len; i++)
/*     */       {
/* 274 */         Element elem = (Element)nodeList.get(i);
/* 275 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.SCrossBattleFinalCfg"))
/*     */         {
/*     */ 
/* 278 */           SCrossBattleFinalCfg obj = new SCrossBattleFinalCfg();
/* 279 */           obj.loadFromXml(elem);
/* 280 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 281 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 286 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 292 */     all = new java.util.HashMap();
/*     */     
/* 294 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleFinalCfg.bny";
/*     */     try
/*     */     {
/* 297 */       File file = new File(path);
/* 298 */       if (file.exists())
/*     */       {
/* 300 */         byte[] bytes = new byte['Ѐ'];
/* 301 */         FileInputStream fis = new FileInputStream(file);
/* 302 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 303 */         int len = 0;
/* 304 */         while ((len = fis.read(bytes)) > 0)
/* 305 */           baos.write(bytes, 0, len);
/* 306 */         fis.close();
/* 307 */         bytes = baos.toByteArray();
/* 308 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 309 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 311 */           _os_.unmarshal_int();
/* 312 */           _os_.unmarshal_int();
/* 313 */           _os_.unmarshal_int();
/*     */         }
/* 315 */         _os_.unmarshal_int();
/* 316 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 319 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 321 */           SCrossBattleFinalCfg _v_ = new SCrossBattleFinalCfg();
/* 322 */           _v_.unmarshal(_os_);
/* 323 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 324 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 329 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 334 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SCrossBattleFinalCfg> all)
/*     */   {
/* 341 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleFinalCfg.bny";
/*     */     try
/*     */     {
/* 344 */       File file = new File(path);
/* 345 */       if (file.exists())
/*     */       {
/* 347 */         byte[] bytes = new byte['Ѐ'];
/* 348 */         FileInputStream fis = new FileInputStream(file);
/* 349 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 350 */         int len = 0;
/* 351 */         while ((len = fis.read(bytes)) > 0)
/* 352 */           baos.write(bytes, 0, len);
/* 353 */         fis.close();
/* 354 */         bytes = baos.toByteArray();
/* 355 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 356 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 358 */           _os_.unmarshal_int();
/* 359 */           _os_.unmarshal_int();
/* 360 */           _os_.unmarshal_int();
/*     */         }
/* 362 */         _os_.unmarshal_int();
/* 363 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 366 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 368 */           SCrossBattleFinalCfg _v_ = new SCrossBattleFinalCfg();
/* 369 */           _v_.unmarshal(_os_);
/* 370 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 371 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 376 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 381 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SCrossBattleFinalCfg getOld(int key)
/*     */   {
/* 389 */     return (SCrossBattleFinalCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SCrossBattleFinalCfg get(int key)
/*     */   {
/* 394 */     return (SCrossBattleFinalCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCrossBattleFinalCfg> getOldAll()
/*     */   {
/* 399 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCrossBattleFinalCfg> getAll()
/*     */   {
/* 404 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SCrossBattleFinalCfg> newAll)
/*     */   {
/* 409 */     oldAll = all;
/* 410 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 415 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\SCrossBattleFinalCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */