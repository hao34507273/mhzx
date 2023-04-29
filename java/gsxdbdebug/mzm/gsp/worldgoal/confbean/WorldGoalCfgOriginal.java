/*     */ package mzm.gsp.worldgoal.confbean;
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
/*     */ public class WorldGoalCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, WorldGoalCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, WorldGoalCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public String name;
/*     */   public String desc;
/*     */   public int activity_cfg_id;
/*     */   public int moduleid;
/*     */   public int activity_type;
/*     */   public int enter_activity_map_npc_id;
/*     */   public int enter_activity_map_service_id;
/*     */   public int npc_id;
/*     */   public int entity_npc_id;
/*     */   public int commit_service_id;
/*     */   public int get_activity_schedule_service_id;
/*     */   public int section_num;
/*     */   public int same_price_item_id;
/*     */   public int commit_item_num_limit;
/*     */   public int commit_item_num_limit_clear_internal;
/*     */   public int activity_complete_award_mail_id;
/*     */   public int npc_controller_id;
/*     */   public int item_controller_id;
/*     */   public int item_refresh_interval;
/*     */   public int item_refresh_num;
/*     */   public int monster_controller_id;
/*     */   public int monster_group_id;
/*     */   public int monster_refresh_interval;
/*     */   public int transfer_map_cfg_id;
/*     */   public int transfer_x;
/*     */   public int transfer_y;
/*     */   public int enter_activity_map_transfer_map_cfg_id;
/*     */   public int enter_activity_map_transfer_x;
/*     */   public int enter_activity_map_transfer_y;
/*     */   public int section_id;
/*     */   public int map_cfg_id;
/*     */   public int x;
/*     */   public int y;
/*     */   public int section_total_point;
/*     */   public int section_complete_award_mail_id;
/*     */   public int effect_id;
/*     */   public int play_effect_time;
/*     */   public int trigger_point;
/*  57 */   public java.util.ArrayList<String> part_name_list = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  61 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  62 */     this.name = rootElement.attributeValue("name");
/*  63 */     this.desc = rootElement.attributeValue("desc");
/*  64 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  65 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  66 */     this.activity_type = Integer.valueOf(rootElement.attributeValue("activity_type")).intValue();
/*  67 */     this.enter_activity_map_npc_id = Integer.valueOf(rootElement.attributeValue("enter_activity_map_npc_id")).intValue();
/*  68 */     this.enter_activity_map_service_id = Integer.valueOf(rootElement.attributeValue("enter_activity_map_service_id")).intValue();
/*  69 */     this.npc_id = Integer.valueOf(rootElement.attributeValue("npc_id")).intValue();
/*  70 */     this.entity_npc_id = Integer.valueOf(rootElement.attributeValue("entity_npc_id")).intValue();
/*  71 */     this.commit_service_id = Integer.valueOf(rootElement.attributeValue("commit_service_id")).intValue();
/*  72 */     this.get_activity_schedule_service_id = Integer.valueOf(rootElement.attributeValue("get_activity_schedule_service_id")).intValue();
/*  73 */     this.section_num = Integer.valueOf(rootElement.attributeValue("section_num")).intValue();
/*  74 */     this.same_price_item_id = Integer.valueOf(rootElement.attributeValue("same_price_item_id")).intValue();
/*  75 */     this.commit_item_num_limit = Integer.valueOf(rootElement.attributeValue("commit_item_num_limit")).intValue();
/*  76 */     this.commit_item_num_limit_clear_internal = Integer.valueOf(rootElement.attributeValue("commit_item_num_limit_clear_internal")).intValue();
/*  77 */     this.activity_complete_award_mail_id = Integer.valueOf(rootElement.attributeValue("activity_complete_award_mail_id")).intValue();
/*  78 */     this.npc_controller_id = Integer.valueOf(rootElement.attributeValue("npc_controller_id")).intValue();
/*  79 */     this.item_controller_id = Integer.valueOf(rootElement.attributeValue("item_controller_id")).intValue();
/*  80 */     this.item_refresh_interval = Integer.valueOf(rootElement.attributeValue("item_refresh_interval")).intValue();
/*  81 */     this.item_refresh_num = Integer.valueOf(rootElement.attributeValue("item_refresh_num")).intValue();
/*  82 */     this.monster_controller_id = Integer.valueOf(rootElement.attributeValue("monster_controller_id")).intValue();
/*  83 */     this.monster_group_id = Integer.valueOf(rootElement.attributeValue("monster_group_id")).intValue();
/*  84 */     this.monster_refresh_interval = Integer.valueOf(rootElement.attributeValue("monster_refresh_interval")).intValue();
/*  85 */     this.transfer_map_cfg_id = Integer.valueOf(rootElement.attributeValue("transfer_map_cfg_id")).intValue();
/*  86 */     this.transfer_x = Integer.valueOf(rootElement.attributeValue("transfer_x")).intValue();
/*  87 */     this.transfer_y = Integer.valueOf(rootElement.attributeValue("transfer_y")).intValue();
/*  88 */     this.enter_activity_map_transfer_map_cfg_id = Integer.valueOf(rootElement.attributeValue("enter_activity_map_transfer_map_cfg_id")).intValue();
/*  89 */     this.enter_activity_map_transfer_x = Integer.valueOf(rootElement.attributeValue("enter_activity_map_transfer_x")).intValue();
/*  90 */     this.enter_activity_map_transfer_y = Integer.valueOf(rootElement.attributeValue("enter_activity_map_transfer_y")).intValue();
/*  91 */     this.section_id = Integer.valueOf(rootElement.attributeValue("section_id")).intValue();
/*  92 */     this.map_cfg_id = Integer.valueOf(rootElement.attributeValue("map_cfg_id")).intValue();
/*  93 */     this.x = Integer.valueOf(rootElement.attributeValue("x")).intValue();
/*  94 */     this.y = Integer.valueOf(rootElement.attributeValue("y")).intValue();
/*  95 */     this.section_total_point = Integer.valueOf(rootElement.attributeValue("section_total_point")).intValue();
/*  96 */     this.section_complete_award_mail_id = Integer.valueOf(rootElement.attributeValue("section_complete_award_mail_id")).intValue();
/*  97 */     this.effect_id = Integer.valueOf(rootElement.attributeValue("effect_id")).intValue();
/*  98 */     this.play_effect_time = Integer.valueOf(rootElement.attributeValue("play_effect_time")).intValue();
/*  99 */     this.trigger_point = Integer.valueOf(rootElement.attributeValue("trigger_point")).intValue();
/*     */     
/* 101 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "part_name_list");
/* 102 */     if (collectionElement == null)
/*     */     {
/* 104 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 107 */     List<?> _nodeList = collectionElement.elements();
/* 108 */     int _len = _nodeList.size();
/* 109 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 111 */       Element elem = (Element)_nodeList.get(i);
/* 112 */       if (elem.getName().equalsIgnoreCase("string"))
/*     */       {
/*     */         String _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 119 */           _v_ = elem.getText();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 126 */         this.part_name_list.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 133 */     _os_.marshal(this.id);
/* 134 */     _os_.marshal(this.name, "UTF-8");
/* 135 */     _os_.marshal(this.desc, "UTF-8");
/* 136 */     _os_.marshal(this.activity_cfg_id);
/* 137 */     _os_.marshal(this.moduleid);
/* 138 */     _os_.marshal(this.activity_type);
/* 139 */     _os_.marshal(this.enter_activity_map_npc_id);
/* 140 */     _os_.marshal(this.enter_activity_map_service_id);
/* 141 */     _os_.marshal(this.npc_id);
/* 142 */     _os_.marshal(this.entity_npc_id);
/* 143 */     _os_.marshal(this.commit_service_id);
/* 144 */     _os_.marshal(this.get_activity_schedule_service_id);
/* 145 */     _os_.marshal(this.section_num);
/* 146 */     _os_.marshal(this.same_price_item_id);
/* 147 */     _os_.marshal(this.commit_item_num_limit);
/* 148 */     _os_.marshal(this.commit_item_num_limit_clear_internal);
/* 149 */     _os_.marshal(this.activity_complete_award_mail_id);
/* 150 */     _os_.marshal(this.npc_controller_id);
/* 151 */     _os_.marshal(this.item_controller_id);
/* 152 */     _os_.marshal(this.item_refresh_interval);
/* 153 */     _os_.marshal(this.item_refresh_num);
/* 154 */     _os_.marshal(this.monster_controller_id);
/* 155 */     _os_.marshal(this.monster_group_id);
/* 156 */     _os_.marshal(this.monster_refresh_interval);
/* 157 */     _os_.marshal(this.transfer_map_cfg_id);
/* 158 */     _os_.marshal(this.transfer_x);
/* 159 */     _os_.marshal(this.transfer_y);
/* 160 */     _os_.marshal(this.enter_activity_map_transfer_map_cfg_id);
/* 161 */     _os_.marshal(this.enter_activity_map_transfer_x);
/* 162 */     _os_.marshal(this.enter_activity_map_transfer_y);
/* 163 */     _os_.marshal(this.section_id);
/* 164 */     _os_.marshal(this.map_cfg_id);
/* 165 */     _os_.marshal(this.x);
/* 166 */     _os_.marshal(this.y);
/* 167 */     _os_.marshal(this.section_total_point);
/* 168 */     _os_.marshal(this.section_complete_award_mail_id);
/* 169 */     _os_.marshal(this.effect_id);
/* 170 */     _os_.marshal(this.play_effect_time);
/* 171 */     _os_.marshal(this.trigger_point);
/* 172 */     _os_.compact_uint32(this.part_name_list.size());
/* 173 */     for (String _v_ : this.part_name_list)
/*     */     {
/* 175 */       _os_.marshal(_v_, "UTF-8");
/*     */     }
/* 177 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 182 */     this.id = _os_.unmarshal_int();
/* 183 */     this.name = _os_.unmarshal_String("UTF-8");
/* 184 */     this.desc = _os_.unmarshal_String("UTF-8");
/* 185 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 186 */     this.moduleid = _os_.unmarshal_int();
/* 187 */     this.activity_type = _os_.unmarshal_int();
/* 188 */     this.enter_activity_map_npc_id = _os_.unmarshal_int();
/* 189 */     this.enter_activity_map_service_id = _os_.unmarshal_int();
/* 190 */     this.npc_id = _os_.unmarshal_int();
/* 191 */     this.entity_npc_id = _os_.unmarshal_int();
/* 192 */     this.commit_service_id = _os_.unmarshal_int();
/* 193 */     this.get_activity_schedule_service_id = _os_.unmarshal_int();
/* 194 */     this.section_num = _os_.unmarshal_int();
/* 195 */     this.same_price_item_id = _os_.unmarshal_int();
/* 196 */     this.commit_item_num_limit = _os_.unmarshal_int();
/* 197 */     this.commit_item_num_limit_clear_internal = _os_.unmarshal_int();
/* 198 */     this.activity_complete_award_mail_id = _os_.unmarshal_int();
/* 199 */     this.npc_controller_id = _os_.unmarshal_int();
/* 200 */     this.item_controller_id = _os_.unmarshal_int();
/* 201 */     this.item_refresh_interval = _os_.unmarshal_int();
/* 202 */     this.item_refresh_num = _os_.unmarshal_int();
/* 203 */     this.monster_controller_id = _os_.unmarshal_int();
/* 204 */     this.monster_group_id = _os_.unmarshal_int();
/* 205 */     this.monster_refresh_interval = _os_.unmarshal_int();
/* 206 */     this.transfer_map_cfg_id = _os_.unmarshal_int();
/* 207 */     this.transfer_x = _os_.unmarshal_int();
/* 208 */     this.transfer_y = _os_.unmarshal_int();
/* 209 */     this.enter_activity_map_transfer_map_cfg_id = _os_.unmarshal_int();
/* 210 */     this.enter_activity_map_transfer_x = _os_.unmarshal_int();
/* 211 */     this.enter_activity_map_transfer_y = _os_.unmarshal_int();
/* 212 */     this.section_id = _os_.unmarshal_int();
/* 213 */     this.map_cfg_id = _os_.unmarshal_int();
/* 214 */     this.x = _os_.unmarshal_int();
/* 215 */     this.y = _os_.unmarshal_int();
/* 216 */     this.section_total_point = _os_.unmarshal_int();
/* 217 */     this.section_complete_award_mail_id = _os_.unmarshal_int();
/* 218 */     this.effect_id = _os_.unmarshal_int();
/* 219 */     this.play_effect_time = _os_.unmarshal_int();
/* 220 */     this.trigger_point = _os_.unmarshal_int();
/* 221 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 224 */       String _v_ = _os_.unmarshal_String("UTF-8");
/* 225 */       this.part_name_list.add(_v_);
/*     */     }
/* 227 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 232 */     String path = dir + "mzm.gsp.worldgoal.confbean.WorldGoalCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 236 */       all = new java.util.HashMap();
/* 237 */       SAXReader reader = new SAXReader();
/* 238 */       org.dom4j.Document doc = reader.read(new File(path));
/* 239 */       Element root = doc.getRootElement();
/* 240 */       List<?> nodeList = root.elements();
/* 241 */       int len = nodeList.size();
/* 242 */       for (int i = 0; i < len; i++)
/*     */       {
/* 244 */         Element elem = (Element)nodeList.get(i);
/* 245 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.worldgoal.confbean.WorldGoalCfgOriginal"))
/*     */         {
/*     */ 
/* 248 */           WorldGoalCfgOriginal obj = new WorldGoalCfgOriginal();
/* 249 */           obj.loadFromXml(elem);
/* 250 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 251 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 256 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, WorldGoalCfgOriginal> all)
/*     */   {
/* 262 */     String path = dir + "mzm.gsp.worldgoal.confbean.WorldGoalCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 266 */       SAXReader reader = new SAXReader();
/* 267 */       org.dom4j.Document doc = reader.read(new File(path));
/* 268 */       Element root = doc.getRootElement();
/* 269 */       List<?> nodeList = root.elements();
/* 270 */       int len = nodeList.size();
/* 271 */       for (int i = 0; i < len; i++)
/*     */       {
/* 273 */         Element elem = (Element)nodeList.get(i);
/* 274 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.worldgoal.confbean.WorldGoalCfgOriginal"))
/*     */         {
/*     */ 
/* 277 */           WorldGoalCfgOriginal obj = new WorldGoalCfgOriginal();
/* 278 */           obj.loadFromXml(elem);
/* 279 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 280 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 285 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 291 */     all = new java.util.HashMap();
/*     */     
/* 293 */     String path = dir + "mzm.gsp.worldgoal.confbean.WorldGoalCfgOriginal.bny";
/*     */     try
/*     */     {
/* 296 */       File file = new File(path);
/* 297 */       if (file.exists())
/*     */       {
/* 299 */         byte[] bytes = new byte['Ѐ'];
/* 300 */         FileInputStream fis = new FileInputStream(file);
/* 301 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 302 */         int len = 0;
/* 303 */         while ((len = fis.read(bytes)) > 0)
/* 304 */           baos.write(bytes, 0, len);
/* 305 */         fis.close();
/* 306 */         bytes = baos.toByteArray();
/* 307 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 308 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 310 */           _os_.unmarshal_int();
/* 311 */           _os_.unmarshal_int();
/* 312 */           _os_.unmarshal_int();
/*     */         }
/* 314 */         _os_.unmarshal_int();
/* 315 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 318 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 320 */           WorldGoalCfgOriginal _v_ = new WorldGoalCfgOriginal();
/* 321 */           _v_.unmarshal(_os_);
/* 322 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 323 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 328 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 333 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, WorldGoalCfgOriginal> all)
/*     */   {
/* 340 */     String path = dir + "mzm.gsp.worldgoal.confbean.WorldGoalCfgOriginal.bny";
/*     */     try
/*     */     {
/* 343 */       File file = new File(path);
/* 344 */       if (file.exists())
/*     */       {
/* 346 */         byte[] bytes = new byte['Ѐ'];
/* 347 */         FileInputStream fis = new FileInputStream(file);
/* 348 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 349 */         int len = 0;
/* 350 */         while ((len = fis.read(bytes)) > 0)
/* 351 */           baos.write(bytes, 0, len);
/* 352 */         fis.close();
/* 353 */         bytes = baos.toByteArray();
/* 354 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 355 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 357 */           _os_.unmarshal_int();
/* 358 */           _os_.unmarshal_int();
/* 359 */           _os_.unmarshal_int();
/*     */         }
/* 361 */         _os_.unmarshal_int();
/* 362 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 365 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 367 */           WorldGoalCfgOriginal _v_ = new WorldGoalCfgOriginal();
/* 368 */           _v_.unmarshal(_os_);
/* 369 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 370 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 375 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 380 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static WorldGoalCfgOriginal getOld(int key)
/*     */   {
/* 388 */     return (WorldGoalCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static WorldGoalCfgOriginal get(int key)
/*     */   {
/* 393 */     return (WorldGoalCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, WorldGoalCfgOriginal> getOldAll()
/*     */   {
/* 398 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, WorldGoalCfgOriginal> getAll()
/*     */   {
/* 403 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, WorldGoalCfgOriginal> newAll)
/*     */   {
/* 408 */     oldAll = all;
/* 409 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 414 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\confbean\WorldGoalCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */