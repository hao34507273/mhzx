/*     */ package mzm.gsp.crossbattle.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class KnockOutCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int module_id;
/*     */   public int prepare_map_cfg_id;
/*     */   public int out_map_cfg_id;
/*     */   public int out_map_transfer_x;
/*     */   public int out_map_transfer_y;
/*     */   public int prepare_world_countdown;
/*     */   public int match_countdown;
/*     */   public int need_team_member_num;
/*     */   public int need_team_size;
/*  18 */   public ArrayList<String> stage_name_list = new ArrayList();
/*  19 */   public ArrayList<Integer> stage_time_point_cfg_id_list = new ArrayList();
/*  20 */   public ArrayList<Integer> stage_award_fix_id_list = new ArrayList();
/*  21 */   public ArrayList<String> stage_award_mail_title_list = new ArrayList();
/*     */   public int fight_last_time;
/*     */   public int fight_times_every_stage;
/*     */   public int champion_mail_cfg_id;
/*     */   public int second_place_mail_cfg_id;
/*     */   public int third_place_mail_cfg_id;
/*     */   public int last_winner_mail_cfg_id;
/*     */   public int konck_out_mail_cfg_id;
/*     */   public int rank_up_mail_cfg_id;
/*     */   public int bye_rank_up_mail_cfg_id;
/*     */   public int abstain_lose_mail_cfg_id;
/*     */   public int abstain_win_mail_cfg_id;
/*     */   public int fight_lose_mail_cfg_id;
/*     */   public int fight_win_mail_cfg_id;
/*     */   public int _4_to_2_fail_mail_cfg_id;
/*     */   public int abstain_rank_up_mail_cfg_id;
/*     */   public int abstain_knock_out_mail_cfg_id;
/*     */   public int rank_award_mail_cfg_id;
/*     */   public int restart_mail_cfg_id;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  43 */     this.module_id = Integer.valueOf(rootElement.attributeValue("module_id")).intValue();
/*  44 */     this.prepare_map_cfg_id = Integer.valueOf(rootElement.attributeValue("prepare_map_cfg_id")).intValue();
/*  45 */     this.out_map_cfg_id = Integer.valueOf(rootElement.attributeValue("out_map_cfg_id")).intValue();
/*  46 */     this.out_map_transfer_x = Integer.valueOf(rootElement.attributeValue("out_map_transfer_x")).intValue();
/*  47 */     this.out_map_transfer_y = Integer.valueOf(rootElement.attributeValue("out_map_transfer_y")).intValue();
/*  48 */     this.prepare_world_countdown = Integer.valueOf(rootElement.attributeValue("prepare_world_countdown")).intValue();
/*  49 */     this.match_countdown = Integer.valueOf(rootElement.attributeValue("match_countdown")).intValue();
/*  50 */     this.need_team_member_num = Integer.valueOf(rootElement.attributeValue("need_team_member_num")).intValue();
/*  51 */     this.need_team_size = Integer.valueOf(rootElement.attributeValue("need_team_size")).intValue();
/*     */     
/*  53 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "stage_name_list");
/*  54 */     if (collectionElement == null)
/*     */     {
/*  56 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  59 */     java.util.List<?> _nodeList = collectionElement.elements();
/*  60 */     int _len = _nodeList.size();
/*  61 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  63 */       Element elem = (Element)_nodeList.get(i);
/*  64 */       if (elem.getName().equalsIgnoreCase("string"))
/*     */       {
/*     */         String _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  71 */           _v_ = elem.getText();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  78 */         this.stage_name_list.add(_v_);
/*     */       }
/*     */     }
/*     */     
/*  82 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "stage_time_point_cfg_id_list");
/*  83 */     if (collectionElement == null)
/*     */     {
/*  85 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  88 */     java.util.List<?> _nodeList = collectionElement.elements();
/*  89 */     int _len = _nodeList.size();
/*  90 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  92 */       Element elem = (Element)_nodeList.get(i);
/*  93 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 100 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 107 */         this.stage_time_point_cfg_id_list.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 111 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "stage_award_fix_id_list");
/* 112 */     if (collectionElement == null)
/*     */     {
/* 114 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 117 */     java.util.List<?> _nodeList = collectionElement.elements();
/* 118 */     int _len = _nodeList.size();
/* 119 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 121 */       Element elem = (Element)_nodeList.get(i);
/* 122 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 129 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 136 */         this.stage_award_fix_id_list.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 140 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "stage_award_mail_title_list");
/* 141 */     if (collectionElement == null)
/*     */     {
/* 143 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 146 */     java.util.List<?> _nodeList = collectionElement.elements();
/* 147 */     int _len = _nodeList.size();
/* 148 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 150 */       Element elem = (Element)_nodeList.get(i);
/* 151 */       if (elem.getName().equalsIgnoreCase("string"))
/*     */       {
/*     */         String _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 158 */           _v_ = elem.getText();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 165 */         this.stage_award_mail_title_list.add(_v_);
/*     */       }
/*     */     }
/* 168 */     this.fight_last_time = Integer.valueOf(rootElement.attributeValue("fight_last_time")).intValue();
/* 169 */     this.fight_times_every_stage = Integer.valueOf(rootElement.attributeValue("fight_times_every_stage")).intValue();
/* 170 */     this.champion_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("champion_mail_cfg_id")).intValue();
/* 171 */     this.second_place_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("second_place_mail_cfg_id")).intValue();
/* 172 */     this.third_place_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("third_place_mail_cfg_id")).intValue();
/* 173 */     this.last_winner_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("last_winner_mail_cfg_id")).intValue();
/* 174 */     this.konck_out_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("konck_out_mail_cfg_id")).intValue();
/* 175 */     this.rank_up_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("rank_up_mail_cfg_id")).intValue();
/* 176 */     this.bye_rank_up_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("bye_rank_up_mail_cfg_id")).intValue();
/* 177 */     this.abstain_lose_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("abstain_lose_mail_cfg_id")).intValue();
/* 178 */     this.abstain_win_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("abstain_win_mail_cfg_id")).intValue();
/* 179 */     this.fight_lose_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("fight_lose_mail_cfg_id")).intValue();
/* 180 */     this.fight_win_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("fight_win_mail_cfg_id")).intValue();
/* 181 */     this._4_to_2_fail_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("_4_to_2_fail_mail_cfg_id")).intValue();
/* 182 */     this.abstain_rank_up_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("abstain_rank_up_mail_cfg_id")).intValue();
/* 183 */     this.abstain_knock_out_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("abstain_knock_out_mail_cfg_id")).intValue();
/* 184 */     this.rank_award_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("rank_award_mail_cfg_id")).intValue();
/* 185 */     this.restart_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("restart_mail_cfg_id")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 190 */     _os_.marshal(this.module_id);
/* 191 */     _os_.marshal(this.prepare_map_cfg_id);
/* 192 */     _os_.marshal(this.out_map_cfg_id);
/* 193 */     _os_.marshal(this.out_map_transfer_x);
/* 194 */     _os_.marshal(this.out_map_transfer_y);
/* 195 */     _os_.marshal(this.prepare_world_countdown);
/* 196 */     _os_.marshal(this.match_countdown);
/* 197 */     _os_.marshal(this.need_team_member_num);
/* 198 */     _os_.marshal(this.need_team_size);
/* 199 */     _os_.compact_uint32(this.stage_name_list.size());
/* 200 */     for (String _v_ : this.stage_name_list)
/*     */     {
/* 202 */       _os_.marshal(_v_, "UTF-8");
/*     */     }
/* 204 */     _os_.compact_uint32(this.stage_time_point_cfg_id_list.size());
/* 205 */     for (Integer _v_ : this.stage_time_point_cfg_id_list)
/*     */     {
/* 207 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 209 */     _os_.compact_uint32(this.stage_award_fix_id_list.size());
/* 210 */     for (Integer _v_ : this.stage_award_fix_id_list)
/*     */     {
/* 212 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 214 */     _os_.compact_uint32(this.stage_award_mail_title_list.size());
/* 215 */     for (String _v_ : this.stage_award_mail_title_list)
/*     */     {
/* 217 */       _os_.marshal(_v_, "UTF-8");
/*     */     }
/* 219 */     _os_.marshal(this.fight_last_time);
/* 220 */     _os_.marshal(this.fight_times_every_stage);
/* 221 */     _os_.marshal(this.champion_mail_cfg_id);
/* 222 */     _os_.marshal(this.second_place_mail_cfg_id);
/* 223 */     _os_.marshal(this.third_place_mail_cfg_id);
/* 224 */     _os_.marshal(this.last_winner_mail_cfg_id);
/* 225 */     _os_.marshal(this.konck_out_mail_cfg_id);
/* 226 */     _os_.marshal(this.rank_up_mail_cfg_id);
/* 227 */     _os_.marshal(this.bye_rank_up_mail_cfg_id);
/* 228 */     _os_.marshal(this.abstain_lose_mail_cfg_id);
/* 229 */     _os_.marshal(this.abstain_win_mail_cfg_id);
/* 230 */     _os_.marshal(this.fight_lose_mail_cfg_id);
/* 231 */     _os_.marshal(this.fight_win_mail_cfg_id);
/* 232 */     _os_.marshal(this._4_to_2_fail_mail_cfg_id);
/* 233 */     _os_.marshal(this.abstain_rank_up_mail_cfg_id);
/* 234 */     _os_.marshal(this.abstain_knock_out_mail_cfg_id);
/* 235 */     _os_.marshal(this.rank_award_mail_cfg_id);
/* 236 */     _os_.marshal(this.restart_mail_cfg_id);
/* 237 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 242 */     this.module_id = _os_.unmarshal_int();
/* 243 */     this.prepare_map_cfg_id = _os_.unmarshal_int();
/* 244 */     this.out_map_cfg_id = _os_.unmarshal_int();
/* 245 */     this.out_map_transfer_x = _os_.unmarshal_int();
/* 246 */     this.out_map_transfer_y = _os_.unmarshal_int();
/* 247 */     this.prepare_world_countdown = _os_.unmarshal_int();
/* 248 */     this.match_countdown = _os_.unmarshal_int();
/* 249 */     this.need_team_member_num = _os_.unmarshal_int();
/* 250 */     this.need_team_size = _os_.unmarshal_int();
/* 251 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 254 */       String _v_ = _os_.unmarshal_String("UTF-8");
/* 255 */       this.stage_name_list.add(_v_);
/*     */     }
/* 257 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 260 */       int _v_ = _os_.unmarshal_int();
/* 261 */       this.stage_time_point_cfg_id_list.add(Integer.valueOf(_v_));
/*     */     }
/* 263 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 266 */       int _v_ = _os_.unmarshal_int();
/* 267 */       this.stage_award_fix_id_list.add(Integer.valueOf(_v_));
/*     */     }
/* 269 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 272 */       String _v_ = _os_.unmarshal_String("UTF-8");
/* 273 */       this.stage_award_mail_title_list.add(_v_);
/*     */     }
/* 275 */     this.fight_last_time = _os_.unmarshal_int();
/* 276 */     this.fight_times_every_stage = _os_.unmarshal_int();
/* 277 */     this.champion_mail_cfg_id = _os_.unmarshal_int();
/* 278 */     this.second_place_mail_cfg_id = _os_.unmarshal_int();
/* 279 */     this.third_place_mail_cfg_id = _os_.unmarshal_int();
/* 280 */     this.last_winner_mail_cfg_id = _os_.unmarshal_int();
/* 281 */     this.konck_out_mail_cfg_id = _os_.unmarshal_int();
/* 282 */     this.rank_up_mail_cfg_id = _os_.unmarshal_int();
/* 283 */     this.bye_rank_up_mail_cfg_id = _os_.unmarshal_int();
/* 284 */     this.abstain_lose_mail_cfg_id = _os_.unmarshal_int();
/* 285 */     this.abstain_win_mail_cfg_id = _os_.unmarshal_int();
/* 286 */     this.fight_lose_mail_cfg_id = _os_.unmarshal_int();
/* 287 */     this.fight_win_mail_cfg_id = _os_.unmarshal_int();
/* 288 */     this._4_to_2_fail_mail_cfg_id = _os_.unmarshal_int();
/* 289 */     this.abstain_rank_up_mail_cfg_id = _os_.unmarshal_int();
/* 290 */     this.abstain_knock_out_mail_cfg_id = _os_.unmarshal_int();
/* 291 */     this.rank_award_mail_cfg_id = _os_.unmarshal_int();
/* 292 */     this.restart_mail_cfg_id = _os_.unmarshal_int();
/* 293 */     return _os_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\KnockOutCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */