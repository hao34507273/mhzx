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
/*     */ public class SCrossBattleSelectionCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SCrossBattleSelectionCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SCrossBattleSelectionCfg> all = null;
/*     */   
/*     */   public int activity_cfg_id;
/*     */   public int module_id;
/*     */   public int selection_map_cfg_id;
/*     */   public int selection_map_transfer_x;
/*     */   public int selection_map_transfer_y;
/*     */   public int selection_out_map_cfg_id;
/*     */   public int selection_out_map_transfer_x;
/*     */   public int selection_out_map_transfer_y;
/*     */   public int selection_out_npc_id;
/*     */   public int selection_out_npc_service_id;
/*     */   public int selection_countdown;
/*     */   public int selection_match_countdown;
/*     */   public int selection_need_team_member_num;
/*     */   public int selection_need_team_num;
/*     */   public int selection_last_winner_mail_cfg_id;
/*     */   public int selection_match_cfg_id;
/*     */   public int selection_champion_mail_cfg_id;
/*     */   public int selection_second_place_mail_cfg_id;
/*     */   public int selection_third_place_mail_cfg_id;
/*     */   public int selection_lose_mail_cfg_id;
/*     */   public int selection_win_mail_cfg_id;
/*     */   public int selection_4_to_2_fail_mail_cfg_id;
/*     */   public int selection_abstain_lose_mail_cfg_id;
/*     */   public int selection_abstain_win_mail_cfg_id;
/*     */   public int selection_bye_win_mail_cfg_id;
/*     */   public int selection_award_mail_cfg_id;
/*     */   public int selection_restart_mail_cfg_id;
/*  45 */   public ArrayList<String> stage_name_list = new ArrayList();
/*  46 */   public ArrayList<SelectionStageTimeBean> selection_stage_time_list = new ArrayList();
/*     */   public int selection_fight_last_time;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  51 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  52 */     this.module_id = Integer.valueOf(rootElement.attributeValue("module_id")).intValue();
/*  53 */     this.selection_map_cfg_id = Integer.valueOf(rootElement.attributeValue("selection_map_cfg_id")).intValue();
/*  54 */     this.selection_map_transfer_x = Integer.valueOf(rootElement.attributeValue("selection_map_transfer_x")).intValue();
/*  55 */     this.selection_map_transfer_y = Integer.valueOf(rootElement.attributeValue("selection_map_transfer_y")).intValue();
/*  56 */     this.selection_out_map_cfg_id = Integer.valueOf(rootElement.attributeValue("selection_out_map_cfg_id")).intValue();
/*  57 */     this.selection_out_map_transfer_x = Integer.valueOf(rootElement.attributeValue("selection_out_map_transfer_x")).intValue();
/*  58 */     this.selection_out_map_transfer_y = Integer.valueOf(rootElement.attributeValue("selection_out_map_transfer_y")).intValue();
/*  59 */     this.selection_out_npc_id = Integer.valueOf(rootElement.attributeValue("selection_out_npc_id")).intValue();
/*  60 */     this.selection_out_npc_service_id = Integer.valueOf(rootElement.attributeValue("selection_out_npc_service_id")).intValue();
/*  61 */     this.selection_countdown = Integer.valueOf(rootElement.attributeValue("selection_countdown")).intValue();
/*  62 */     this.selection_match_countdown = Integer.valueOf(rootElement.attributeValue("selection_match_countdown")).intValue();
/*  63 */     this.selection_need_team_member_num = Integer.valueOf(rootElement.attributeValue("selection_need_team_member_num")).intValue();
/*  64 */     this.selection_need_team_num = Integer.valueOf(rootElement.attributeValue("selection_need_team_num")).intValue();
/*  65 */     this.selection_last_winner_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("selection_last_winner_mail_cfg_id")).intValue();
/*  66 */     this.selection_match_cfg_id = Integer.valueOf(rootElement.attributeValue("selection_match_cfg_id")).intValue();
/*  67 */     this.selection_champion_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("selection_champion_mail_cfg_id")).intValue();
/*  68 */     this.selection_second_place_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("selection_second_place_mail_cfg_id")).intValue();
/*  69 */     this.selection_third_place_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("selection_third_place_mail_cfg_id")).intValue();
/*  70 */     this.selection_lose_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("selection_lose_mail_cfg_id")).intValue();
/*  71 */     this.selection_win_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("selection_win_mail_cfg_id")).intValue();
/*  72 */     this.selection_4_to_2_fail_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("selection_4_to_2_fail_mail_cfg_id")).intValue();
/*  73 */     this.selection_abstain_lose_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("selection_abstain_lose_mail_cfg_id")).intValue();
/*  74 */     this.selection_abstain_win_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("selection_abstain_win_mail_cfg_id")).intValue();
/*  75 */     this.selection_bye_win_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("selection_bye_win_mail_cfg_id")).intValue();
/*  76 */     this.selection_award_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("selection_award_mail_cfg_id")).intValue();
/*  77 */     this.selection_restart_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("selection_restart_mail_cfg_id")).intValue();
/*     */     
/*  79 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "stage_name_list");
/*  80 */     if (collectionElement == null)
/*     */     {
/*  82 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  85 */     List<?> _nodeList = collectionElement.elements();
/*  86 */     int _len = _nodeList.size();
/*  87 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  89 */       Element elem = (Element)_nodeList.get(i);
/*  90 */       if (elem.getName().equalsIgnoreCase("string"))
/*     */       {
/*     */         String _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  97 */           _v_ = elem.getText();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 104 */         this.stage_name_list.add(_v_);
/*     */       }
/*     */     }
/*     */     
/* 108 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "selection_stage_time_list");
/* 109 */     if (collectionElement == null)
/*     */     {
/* 111 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 114 */     List<?> _nodeList = collectionElement.elements();
/* 115 */     int _len = _nodeList.size();
/* 116 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 118 */       Element elem = (Element)_nodeList.get(i);
/* 119 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.SelectionStageTimeBean"))
/*     */       {
/*     */         SelectionStageTimeBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 126 */           _v_ = new SelectionStageTimeBean();
/* 127 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 134 */         this.selection_stage_time_list.add(_v_);
/*     */       }
/*     */     }
/* 137 */     this.selection_fight_last_time = Integer.valueOf(rootElement.attributeValue("selection_fight_last_time")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 142 */     _os_.marshal(this.activity_cfg_id);
/* 143 */     _os_.marshal(this.module_id);
/* 144 */     _os_.marshal(this.selection_map_cfg_id);
/* 145 */     _os_.marshal(this.selection_map_transfer_x);
/* 146 */     _os_.marshal(this.selection_map_transfer_y);
/* 147 */     _os_.marshal(this.selection_out_map_cfg_id);
/* 148 */     _os_.marshal(this.selection_out_map_transfer_x);
/* 149 */     _os_.marshal(this.selection_out_map_transfer_y);
/* 150 */     _os_.marshal(this.selection_out_npc_id);
/* 151 */     _os_.marshal(this.selection_out_npc_service_id);
/* 152 */     _os_.marshal(this.selection_countdown);
/* 153 */     _os_.marshal(this.selection_match_countdown);
/* 154 */     _os_.marshal(this.selection_need_team_member_num);
/* 155 */     _os_.marshal(this.selection_need_team_num);
/* 156 */     _os_.marshal(this.selection_last_winner_mail_cfg_id);
/* 157 */     _os_.marshal(this.selection_match_cfg_id);
/* 158 */     _os_.marshal(this.selection_champion_mail_cfg_id);
/* 159 */     _os_.marshal(this.selection_second_place_mail_cfg_id);
/* 160 */     _os_.marshal(this.selection_third_place_mail_cfg_id);
/* 161 */     _os_.marshal(this.selection_lose_mail_cfg_id);
/* 162 */     _os_.marshal(this.selection_win_mail_cfg_id);
/* 163 */     _os_.marshal(this.selection_4_to_2_fail_mail_cfg_id);
/* 164 */     _os_.marshal(this.selection_abstain_lose_mail_cfg_id);
/* 165 */     _os_.marshal(this.selection_abstain_win_mail_cfg_id);
/* 166 */     _os_.marshal(this.selection_bye_win_mail_cfg_id);
/* 167 */     _os_.marshal(this.selection_award_mail_cfg_id);
/* 168 */     _os_.marshal(this.selection_restart_mail_cfg_id);
/* 169 */     _os_.compact_uint32(this.stage_name_list.size());
/* 170 */     for (String _v_ : this.stage_name_list)
/*     */     {
/* 172 */       _os_.marshal(_v_, "UTF-8");
/*     */     }
/* 174 */     _os_.compact_uint32(this.selection_stage_time_list.size());
/* 175 */     for (SelectionStageTimeBean _v_ : this.selection_stage_time_list)
/*     */     {
/* 177 */       _os_.marshal(_v_);
/*     */     }
/* 179 */     _os_.marshal(this.selection_fight_last_time);
/* 180 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 185 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 186 */     this.module_id = _os_.unmarshal_int();
/* 187 */     this.selection_map_cfg_id = _os_.unmarshal_int();
/* 188 */     this.selection_map_transfer_x = _os_.unmarshal_int();
/* 189 */     this.selection_map_transfer_y = _os_.unmarshal_int();
/* 190 */     this.selection_out_map_cfg_id = _os_.unmarshal_int();
/* 191 */     this.selection_out_map_transfer_x = _os_.unmarshal_int();
/* 192 */     this.selection_out_map_transfer_y = _os_.unmarshal_int();
/* 193 */     this.selection_out_npc_id = _os_.unmarshal_int();
/* 194 */     this.selection_out_npc_service_id = _os_.unmarshal_int();
/* 195 */     this.selection_countdown = _os_.unmarshal_int();
/* 196 */     this.selection_match_countdown = _os_.unmarshal_int();
/* 197 */     this.selection_need_team_member_num = _os_.unmarshal_int();
/* 198 */     this.selection_need_team_num = _os_.unmarshal_int();
/* 199 */     this.selection_last_winner_mail_cfg_id = _os_.unmarshal_int();
/* 200 */     this.selection_match_cfg_id = _os_.unmarshal_int();
/* 201 */     this.selection_champion_mail_cfg_id = _os_.unmarshal_int();
/* 202 */     this.selection_second_place_mail_cfg_id = _os_.unmarshal_int();
/* 203 */     this.selection_third_place_mail_cfg_id = _os_.unmarshal_int();
/* 204 */     this.selection_lose_mail_cfg_id = _os_.unmarshal_int();
/* 205 */     this.selection_win_mail_cfg_id = _os_.unmarshal_int();
/* 206 */     this.selection_4_to_2_fail_mail_cfg_id = _os_.unmarshal_int();
/* 207 */     this.selection_abstain_lose_mail_cfg_id = _os_.unmarshal_int();
/* 208 */     this.selection_abstain_win_mail_cfg_id = _os_.unmarshal_int();
/* 209 */     this.selection_bye_win_mail_cfg_id = _os_.unmarshal_int();
/* 210 */     this.selection_award_mail_cfg_id = _os_.unmarshal_int();
/* 211 */     this.selection_restart_mail_cfg_id = _os_.unmarshal_int();
/* 212 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 215 */       String _v_ = _os_.unmarshal_String("UTF-8");
/* 216 */       this.stage_name_list.add(_v_);
/*     */     }
/* 218 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 221 */       SelectionStageTimeBean _v_ = new SelectionStageTimeBean();
/* 222 */       _v_.unmarshal(_os_);
/* 223 */       this.selection_stage_time_list.add(_v_);
/*     */     }
/* 225 */     this.selection_fight_last_time = _os_.unmarshal_int();
/* 226 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 231 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleSelectionCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 235 */       all = new java.util.HashMap();
/* 236 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 237 */       org.dom4j.Document doc = reader.read(new File(path));
/* 238 */       Element root = doc.getRootElement();
/* 239 */       List<?> nodeList = root.elements();
/* 240 */       int len = nodeList.size();
/* 241 */       for (int i = 0; i < len; i++)
/*     */       {
/* 243 */         Element elem = (Element)nodeList.get(i);
/* 244 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.SCrossBattleSelectionCfg"))
/*     */         {
/*     */ 
/* 247 */           SCrossBattleSelectionCfg obj = new SCrossBattleSelectionCfg();
/* 248 */           obj.loadFromXml(elem);
/* 249 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 250 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 255 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SCrossBattleSelectionCfg> all)
/*     */   {
/* 261 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleSelectionCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 265 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 266 */       org.dom4j.Document doc = reader.read(new File(path));
/* 267 */       Element root = doc.getRootElement();
/* 268 */       List<?> nodeList = root.elements();
/* 269 */       int len = nodeList.size();
/* 270 */       for (int i = 0; i < len; i++)
/*     */       {
/* 272 */         Element elem = (Element)nodeList.get(i);
/* 273 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.SCrossBattleSelectionCfg"))
/*     */         {
/*     */ 
/* 276 */           SCrossBattleSelectionCfg obj = new SCrossBattleSelectionCfg();
/* 277 */           obj.loadFromXml(elem);
/* 278 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 279 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 284 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 290 */     all = new java.util.HashMap();
/*     */     
/* 292 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleSelectionCfg.bny";
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
/* 307 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 309 */           _os_.unmarshal_int();
/* 310 */           _os_.unmarshal_int();
/* 311 */           _os_.unmarshal_int();
/*     */         }
/* 313 */         _os_.unmarshal_int();
/* 314 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 317 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 319 */           SCrossBattleSelectionCfg _v_ = new SCrossBattleSelectionCfg();
/* 320 */           _v_.unmarshal(_os_);
/* 321 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 322 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 327 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 332 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SCrossBattleSelectionCfg> all)
/*     */   {
/* 339 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleSelectionCfg.bny";
/*     */     try
/*     */     {
/* 342 */       File file = new File(path);
/* 343 */       if (file.exists())
/*     */       {
/* 345 */         byte[] bytes = new byte['Ѐ'];
/* 346 */         FileInputStream fis = new FileInputStream(file);
/* 347 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 348 */         int len = 0;
/* 349 */         while ((len = fis.read(bytes)) > 0)
/* 350 */           baos.write(bytes, 0, len);
/* 351 */         fis.close();
/* 352 */         bytes = baos.toByteArray();
/* 353 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 354 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 356 */           _os_.unmarshal_int();
/* 357 */           _os_.unmarshal_int();
/* 358 */           _os_.unmarshal_int();
/*     */         }
/* 360 */         _os_.unmarshal_int();
/* 361 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 364 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 366 */           SCrossBattleSelectionCfg _v_ = new SCrossBattleSelectionCfg();
/* 367 */           _v_.unmarshal(_os_);
/* 368 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 369 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 374 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 379 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SCrossBattleSelectionCfg getOld(int key)
/*     */   {
/* 387 */     return (SCrossBattleSelectionCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SCrossBattleSelectionCfg get(int key)
/*     */   {
/* 392 */     return (SCrossBattleSelectionCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCrossBattleSelectionCfg> getOldAll()
/*     */   {
/* 397 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCrossBattleSelectionCfg> getAll()
/*     */   {
/* 402 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SCrossBattleSelectionCfg> newAll)
/*     */   {
/* 407 */     oldAll = all;
/* 408 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 413 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\SCrossBattleSelectionCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */