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
/*     */ public class CrossBattleRoundRobinCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, CrossBattleRoundRobinCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, CrossBattleRoundRobinCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public int activity_cfg_id;
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
/*  35 */   public ArrayList<RoundRobinTimePoint> round_robin_time_points = new ArrayList();
/*  36 */   public ArrayList<RoundRobinBackupTimePoint> round_robin_backup_time_points = new ArrayList();
/*     */   public int round_robin_stage_tips_id;
/*     */   public int round_robin_main_remind_mail_cfg_id;
/*     */   public int round_robin_backup_remind_mail_cfg_id;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  43 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  44 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  45 */     this.round_robin_stage_moduleid = Integer.valueOf(rootElement.attributeValue("round_robin_stage_moduleid")).intValue();
/*  46 */     this.round_robin_stage_prepare_duration_in_minute = Integer.valueOf(rootElement.attributeValue("round_robin_stage_prepare_duration_in_minute")).intValue();
/*  47 */     this.round_robin_stage_fight_max_duration_in_minute = Integer.valueOf(rootElement.attributeValue("round_robin_stage_fight_max_duration_in_minute")).intValue();
/*  48 */     this.round_robin_map_cfg_id = Integer.valueOf(rootElement.attributeValue("round_robin_map_cfg_id")).intValue();
/*  49 */     this.round_robin_map_transfer_x = Integer.valueOf(rootElement.attributeValue("round_robin_map_transfer_x")).intValue();
/*  50 */     this.round_robin_map_transfer_y = Integer.valueOf(rootElement.attributeValue("round_robin_map_transfer_y")).intValue();
/*  51 */     this.round_robin_out_map_cfg_id = Integer.valueOf(rootElement.attributeValue("round_robin_out_map_cfg_id")).intValue();
/*  52 */     this.round_robin_out_map_transfer_x = Integer.valueOf(rootElement.attributeValue("round_robin_out_map_transfer_x")).intValue();
/*  53 */     this.round_robin_out_map_transfer_y = Integer.valueOf(rootElement.attributeValue("round_robin_out_map_transfer_y")).intValue();
/*  54 */     this.round_robin_out_npc_id = Integer.valueOf(rootElement.attributeValue("round_robin_out_npc_id")).intValue();
/*  55 */     this.round_robin_out_npc_service_id = Integer.valueOf(rootElement.attributeValue("round_robin_out_npc_service_id")).intValue();
/*  56 */     this.round_robin_win_point = Integer.valueOf(rootElement.attributeValue("round_robin_win_point")).intValue();
/*  57 */     this.round_robin_lose_point = Integer.valueOf(rootElement.attributeValue("round_robin_lose_point")).intValue();
/*  58 */     this.round_robin_stage_promotion_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("round_robin_stage_promotion_mail_cfg_id")).intValue();
/*  59 */     this.round_robin_stage_encourage_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("round_robin_stage_encourage_mail_cfg_id")).intValue();
/*     */     
/*  61 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "round_robin_time_points");
/*  62 */     if (collectionElement == null)
/*     */     {
/*  64 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  67 */     List<?> _nodeList = collectionElement.elements();
/*  68 */     int _len = _nodeList.size();
/*  69 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  71 */       Element elem = (Element)_nodeList.get(i);
/*  72 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.RoundRobinTimePoint"))
/*     */       {
/*     */         RoundRobinTimePoint _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  79 */           _v_ = new RoundRobinTimePoint();
/*  80 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  87 */         this.round_robin_time_points.add(_v_);
/*     */       }
/*     */     }
/*     */     
/*  91 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "round_robin_backup_time_points");
/*  92 */     if (collectionElement == null)
/*     */     {
/*  94 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  97 */     List<?> _nodeList = collectionElement.elements();
/*  98 */     int _len = _nodeList.size();
/*  99 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 101 */       Element elem = (Element)_nodeList.get(i);
/* 102 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.RoundRobinBackupTimePoint"))
/*     */       {
/*     */         RoundRobinBackupTimePoint _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 109 */           _v_ = new RoundRobinBackupTimePoint();
/* 110 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 117 */         this.round_robin_backup_time_points.add(_v_);
/*     */       }
/*     */     }
/* 120 */     this.round_robin_stage_tips_id = Integer.valueOf(rootElement.attributeValue("round_robin_stage_tips_id")).intValue();
/* 121 */     this.round_robin_main_remind_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("round_robin_main_remind_mail_cfg_id")).intValue();
/* 122 */     this.round_robin_backup_remind_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("round_robin_backup_remind_mail_cfg_id")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 127 */     _os_.marshal(this.id);
/* 128 */     _os_.marshal(this.activity_cfg_id);
/* 129 */     _os_.marshal(this.round_robin_stage_moduleid);
/* 130 */     _os_.marshal(this.round_robin_stage_prepare_duration_in_minute);
/* 131 */     _os_.marshal(this.round_robin_stage_fight_max_duration_in_minute);
/* 132 */     _os_.marshal(this.round_robin_map_cfg_id);
/* 133 */     _os_.marshal(this.round_robin_map_transfer_x);
/* 134 */     _os_.marshal(this.round_robin_map_transfer_y);
/* 135 */     _os_.marshal(this.round_robin_out_map_cfg_id);
/* 136 */     _os_.marshal(this.round_robin_out_map_transfer_x);
/* 137 */     _os_.marshal(this.round_robin_out_map_transfer_y);
/* 138 */     _os_.marshal(this.round_robin_out_npc_id);
/* 139 */     _os_.marshal(this.round_robin_out_npc_service_id);
/* 140 */     _os_.marshal(this.round_robin_win_point);
/* 141 */     _os_.marshal(this.round_robin_lose_point);
/* 142 */     _os_.marshal(this.round_robin_stage_promotion_mail_cfg_id);
/* 143 */     _os_.marshal(this.round_robin_stage_encourage_mail_cfg_id);
/* 144 */     _os_.compact_uint32(this.round_robin_time_points.size());
/* 145 */     for (RoundRobinTimePoint _v_ : this.round_robin_time_points)
/*     */     {
/* 147 */       _os_.marshal(_v_);
/*     */     }
/* 149 */     _os_.compact_uint32(this.round_robin_backup_time_points.size());
/* 150 */     for (RoundRobinBackupTimePoint _v_ : this.round_robin_backup_time_points)
/*     */     {
/* 152 */       _os_.marshal(_v_);
/*     */     }
/* 154 */     _os_.marshal(this.round_robin_stage_tips_id);
/* 155 */     _os_.marshal(this.round_robin_main_remind_mail_cfg_id);
/* 156 */     _os_.marshal(this.round_robin_backup_remind_mail_cfg_id);
/* 157 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 162 */     this.id = _os_.unmarshal_int();
/* 163 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 164 */     this.round_robin_stage_moduleid = _os_.unmarshal_int();
/* 165 */     this.round_robin_stage_prepare_duration_in_minute = _os_.unmarshal_int();
/* 166 */     this.round_robin_stage_fight_max_duration_in_minute = _os_.unmarshal_int();
/* 167 */     this.round_robin_map_cfg_id = _os_.unmarshal_int();
/* 168 */     this.round_robin_map_transfer_x = _os_.unmarshal_int();
/* 169 */     this.round_robin_map_transfer_y = _os_.unmarshal_int();
/* 170 */     this.round_robin_out_map_cfg_id = _os_.unmarshal_int();
/* 171 */     this.round_robin_out_map_transfer_x = _os_.unmarshal_int();
/* 172 */     this.round_robin_out_map_transfer_y = _os_.unmarshal_int();
/* 173 */     this.round_robin_out_npc_id = _os_.unmarshal_int();
/* 174 */     this.round_robin_out_npc_service_id = _os_.unmarshal_int();
/* 175 */     this.round_robin_win_point = _os_.unmarshal_int();
/* 176 */     this.round_robin_lose_point = _os_.unmarshal_int();
/* 177 */     this.round_robin_stage_promotion_mail_cfg_id = _os_.unmarshal_int();
/* 178 */     this.round_robin_stage_encourage_mail_cfg_id = _os_.unmarshal_int();
/* 179 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 182 */       RoundRobinTimePoint _v_ = new RoundRobinTimePoint();
/* 183 */       _v_.unmarshal(_os_);
/* 184 */       this.round_robin_time_points.add(_v_);
/*     */     }
/* 186 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 189 */       RoundRobinBackupTimePoint _v_ = new RoundRobinBackupTimePoint();
/* 190 */       _v_.unmarshal(_os_);
/* 191 */       this.round_robin_backup_time_points.add(_v_);
/*     */     }
/* 193 */     this.round_robin_stage_tips_id = _os_.unmarshal_int();
/* 194 */     this.round_robin_main_remind_mail_cfg_id = _os_.unmarshal_int();
/* 195 */     this.round_robin_backup_remind_mail_cfg_id = _os_.unmarshal_int();
/* 196 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 201 */     String path = dir + "mzm.gsp.crossbattle.confbean.CrossBattleRoundRobinCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 205 */       all = new java.util.HashMap();
/* 206 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 207 */       org.dom4j.Document doc = reader.read(new File(path));
/* 208 */       Element root = doc.getRootElement();
/* 209 */       List<?> nodeList = root.elements();
/* 210 */       int len = nodeList.size();
/* 211 */       for (int i = 0; i < len; i++)
/*     */       {
/* 213 */         Element elem = (Element)nodeList.get(i);
/* 214 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.CrossBattleRoundRobinCfgOriginal"))
/*     */         {
/*     */ 
/* 217 */           CrossBattleRoundRobinCfgOriginal obj = new CrossBattleRoundRobinCfgOriginal();
/* 218 */           obj.loadFromXml(elem);
/* 219 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 220 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 225 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, CrossBattleRoundRobinCfgOriginal> all)
/*     */   {
/* 231 */     String path = dir + "mzm.gsp.crossbattle.confbean.CrossBattleRoundRobinCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 235 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 236 */       org.dom4j.Document doc = reader.read(new File(path));
/* 237 */       Element root = doc.getRootElement();
/* 238 */       List<?> nodeList = root.elements();
/* 239 */       int len = nodeList.size();
/* 240 */       for (int i = 0; i < len; i++)
/*     */       {
/* 242 */         Element elem = (Element)nodeList.get(i);
/* 243 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.CrossBattleRoundRobinCfgOriginal"))
/*     */         {
/*     */ 
/* 246 */           CrossBattleRoundRobinCfgOriginal obj = new CrossBattleRoundRobinCfgOriginal();
/* 247 */           obj.loadFromXml(elem);
/* 248 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 249 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 254 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 260 */     all = new java.util.HashMap();
/*     */     
/* 262 */     String path = dir + "mzm.gsp.crossbattle.confbean.CrossBattleRoundRobinCfgOriginal.bny";
/*     */     try
/*     */     {
/* 265 */       File file = new File(path);
/* 266 */       if (file.exists())
/*     */       {
/* 268 */         byte[] bytes = new byte['Ѐ'];
/* 269 */         FileInputStream fis = new FileInputStream(file);
/* 270 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 271 */         int len = 0;
/* 272 */         while ((len = fis.read(bytes)) > 0)
/* 273 */           baos.write(bytes, 0, len);
/* 274 */         fis.close();
/* 275 */         bytes = baos.toByteArray();
/* 276 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 277 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 279 */           _os_.unmarshal_int();
/* 280 */           _os_.unmarshal_int();
/* 281 */           _os_.unmarshal_int();
/*     */         }
/* 283 */         _os_.unmarshal_int();
/* 284 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 287 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 289 */           CrossBattleRoundRobinCfgOriginal _v_ = new CrossBattleRoundRobinCfgOriginal();
/* 290 */           _v_.unmarshal(_os_);
/* 291 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 292 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 297 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 302 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, CrossBattleRoundRobinCfgOriginal> all)
/*     */   {
/* 309 */     String path = dir + "mzm.gsp.crossbattle.confbean.CrossBattleRoundRobinCfgOriginal.bny";
/*     */     try
/*     */     {
/* 312 */       File file = new File(path);
/* 313 */       if (file.exists())
/*     */       {
/* 315 */         byte[] bytes = new byte['Ѐ'];
/* 316 */         FileInputStream fis = new FileInputStream(file);
/* 317 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 318 */         int len = 0;
/* 319 */         while ((len = fis.read(bytes)) > 0)
/* 320 */           baos.write(bytes, 0, len);
/* 321 */         fis.close();
/* 322 */         bytes = baos.toByteArray();
/* 323 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 324 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 326 */           _os_.unmarshal_int();
/* 327 */           _os_.unmarshal_int();
/* 328 */           _os_.unmarshal_int();
/*     */         }
/* 330 */         _os_.unmarshal_int();
/* 331 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 334 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 336 */           CrossBattleRoundRobinCfgOriginal _v_ = new CrossBattleRoundRobinCfgOriginal();
/* 337 */           _v_.unmarshal(_os_);
/* 338 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 339 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 344 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 349 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static CrossBattleRoundRobinCfgOriginal getOld(int key)
/*     */   {
/* 357 */     return (CrossBattleRoundRobinCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static CrossBattleRoundRobinCfgOriginal get(int key)
/*     */   {
/* 362 */     return (CrossBattleRoundRobinCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, CrossBattleRoundRobinCfgOriginal> getOldAll()
/*     */   {
/* 367 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, CrossBattleRoundRobinCfgOriginal> getAll()
/*     */   {
/* 372 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, CrossBattleRoundRobinCfgOriginal> newAll)
/*     */   {
/* 377 */     oldAll = all;
/* 378 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 383 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\CrossBattleRoundRobinCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */