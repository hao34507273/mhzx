/*     */ package mzm.gsp.worldgoal.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SWorldGoalCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SWorldGoalCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SWorldGoalCfg> all = null;
/*     */   
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
/*  45 */   public HashMap<Integer, SectionInfo> section_infos = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  49 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  50 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  51 */     this.activity_type = Integer.valueOf(rootElement.attributeValue("activity_type")).intValue();
/*  52 */     this.enter_activity_map_npc_id = Integer.valueOf(rootElement.attributeValue("enter_activity_map_npc_id")).intValue();
/*  53 */     this.enter_activity_map_service_id = Integer.valueOf(rootElement.attributeValue("enter_activity_map_service_id")).intValue();
/*  54 */     this.npc_id = Integer.valueOf(rootElement.attributeValue("npc_id")).intValue();
/*  55 */     this.entity_npc_id = Integer.valueOf(rootElement.attributeValue("entity_npc_id")).intValue();
/*  56 */     this.commit_service_id = Integer.valueOf(rootElement.attributeValue("commit_service_id")).intValue();
/*  57 */     this.get_activity_schedule_service_id = Integer.valueOf(rootElement.attributeValue("get_activity_schedule_service_id")).intValue();
/*  58 */     this.section_num = Integer.valueOf(rootElement.attributeValue("section_num")).intValue();
/*  59 */     this.same_price_item_id = Integer.valueOf(rootElement.attributeValue("same_price_item_id")).intValue();
/*  60 */     this.commit_item_num_limit = Integer.valueOf(rootElement.attributeValue("commit_item_num_limit")).intValue();
/*  61 */     this.commit_item_num_limit_clear_internal = Integer.valueOf(rootElement.attributeValue("commit_item_num_limit_clear_internal")).intValue();
/*  62 */     this.activity_complete_award_mail_id = Integer.valueOf(rootElement.attributeValue("activity_complete_award_mail_id")).intValue();
/*  63 */     this.npc_controller_id = Integer.valueOf(rootElement.attributeValue("npc_controller_id")).intValue();
/*  64 */     this.item_controller_id = Integer.valueOf(rootElement.attributeValue("item_controller_id")).intValue();
/*  65 */     this.item_refresh_interval = Integer.valueOf(rootElement.attributeValue("item_refresh_interval")).intValue();
/*  66 */     this.item_refresh_num = Integer.valueOf(rootElement.attributeValue("item_refresh_num")).intValue();
/*  67 */     this.monster_controller_id = Integer.valueOf(rootElement.attributeValue("monster_controller_id")).intValue();
/*  68 */     this.monster_group_id = Integer.valueOf(rootElement.attributeValue("monster_group_id")).intValue();
/*  69 */     this.monster_refresh_interval = Integer.valueOf(rootElement.attributeValue("monster_refresh_interval")).intValue();
/*  70 */     this.transfer_map_cfg_id = Integer.valueOf(rootElement.attributeValue("transfer_map_cfg_id")).intValue();
/*  71 */     this.transfer_x = Integer.valueOf(rootElement.attributeValue("transfer_x")).intValue();
/*  72 */     this.transfer_y = Integer.valueOf(rootElement.attributeValue("transfer_y")).intValue();
/*  73 */     this.enter_activity_map_transfer_map_cfg_id = Integer.valueOf(rootElement.attributeValue("enter_activity_map_transfer_map_cfg_id")).intValue();
/*  74 */     this.enter_activity_map_transfer_x = Integer.valueOf(rootElement.attributeValue("enter_activity_map_transfer_x")).intValue();
/*  75 */     this.enter_activity_map_transfer_y = Integer.valueOf(rootElement.attributeValue("enter_activity_map_transfer_y")).intValue();
/*     */     
/*  77 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "section_infos");
/*  78 */     if (mapTypeElement == null)
/*     */     {
/*  80 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  83 */     List<?> entryNodeList = mapTypeElement.elements();
/*  84 */     int entryLen = entryNodeList.size();
/*  85 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  87 */       Element entryElement = (Element)entryNodeList.get(i);
/*  88 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  93 */         Element keyElem = null;
/*  94 */         Element valueElem = null;
/*     */         
/*  96 */         List<?> _nodeList = entryElement.elements();
/*  97 */         int _len = _nodeList.size();
/*  98 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 100 */           Element elem = (Element)_nodeList.get(j);
/* 101 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 103 */             keyElem = elem;
/*     */           }
/* 105 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.worldgoal.confbean.SectionInfo")))
/*     */           {
/* 107 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 111 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 113 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         SectionInfo _v_;
/*     */         try
/*     */         {
/* 120 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 121 */           _v_ = new SectionInfo();
/* 122 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 129 */         this.section_infos.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
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
/* 163 */     _os_.compact_uint32(this.section_infos.size());
/* 164 */     for (java.util.Map.Entry<Integer, SectionInfo> _e_ : this.section_infos.entrySet())
/*     */     {
/* 166 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 167 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 169 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 174 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 175 */     this.moduleid = _os_.unmarshal_int();
/* 176 */     this.activity_type = _os_.unmarshal_int();
/* 177 */     this.enter_activity_map_npc_id = _os_.unmarshal_int();
/* 178 */     this.enter_activity_map_service_id = _os_.unmarshal_int();
/* 179 */     this.npc_id = _os_.unmarshal_int();
/* 180 */     this.entity_npc_id = _os_.unmarshal_int();
/* 181 */     this.commit_service_id = _os_.unmarshal_int();
/* 182 */     this.get_activity_schedule_service_id = _os_.unmarshal_int();
/* 183 */     this.section_num = _os_.unmarshal_int();
/* 184 */     this.same_price_item_id = _os_.unmarshal_int();
/* 185 */     this.commit_item_num_limit = _os_.unmarshal_int();
/* 186 */     this.commit_item_num_limit_clear_internal = _os_.unmarshal_int();
/* 187 */     this.activity_complete_award_mail_id = _os_.unmarshal_int();
/* 188 */     this.npc_controller_id = _os_.unmarshal_int();
/* 189 */     this.item_controller_id = _os_.unmarshal_int();
/* 190 */     this.item_refresh_interval = _os_.unmarshal_int();
/* 191 */     this.item_refresh_num = _os_.unmarshal_int();
/* 192 */     this.monster_controller_id = _os_.unmarshal_int();
/* 193 */     this.monster_group_id = _os_.unmarshal_int();
/* 194 */     this.monster_refresh_interval = _os_.unmarshal_int();
/* 195 */     this.transfer_map_cfg_id = _os_.unmarshal_int();
/* 196 */     this.transfer_x = _os_.unmarshal_int();
/* 197 */     this.transfer_y = _os_.unmarshal_int();
/* 198 */     this.enter_activity_map_transfer_map_cfg_id = _os_.unmarshal_int();
/* 199 */     this.enter_activity_map_transfer_x = _os_.unmarshal_int();
/* 200 */     this.enter_activity_map_transfer_y = _os_.unmarshal_int();
/* 201 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 204 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 206 */       SectionInfo _v_ = new SectionInfo();
/* 207 */       _v_.unmarshal(_os_);
/* 208 */       this.section_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 210 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 215 */     String path = dir + "mzm.gsp.worldgoal.confbean.SWorldGoalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 219 */       all = new HashMap();
/* 220 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 221 */       org.dom4j.Document doc = reader.read(new File(path));
/* 222 */       Element root = doc.getRootElement();
/* 223 */       List<?> nodeList = root.elements();
/* 224 */       int len = nodeList.size();
/* 225 */       for (int i = 0; i < len; i++)
/*     */       {
/* 227 */         Element elem = (Element)nodeList.get(i);
/* 228 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.worldgoal.confbean.SWorldGoalCfg"))
/*     */         {
/*     */ 
/* 231 */           SWorldGoalCfg obj = new SWorldGoalCfg();
/* 232 */           obj.loadFromXml(elem);
/* 233 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 234 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 239 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SWorldGoalCfg> all)
/*     */   {
/* 245 */     String path = dir + "mzm.gsp.worldgoal.confbean.SWorldGoalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 249 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 250 */       org.dom4j.Document doc = reader.read(new File(path));
/* 251 */       Element root = doc.getRootElement();
/* 252 */       List<?> nodeList = root.elements();
/* 253 */       int len = nodeList.size();
/* 254 */       for (int i = 0; i < len; i++)
/*     */       {
/* 256 */         Element elem = (Element)nodeList.get(i);
/* 257 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.worldgoal.confbean.SWorldGoalCfg"))
/*     */         {
/*     */ 
/* 260 */           SWorldGoalCfg obj = new SWorldGoalCfg();
/* 261 */           obj.loadFromXml(elem);
/* 262 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 263 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 268 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 274 */     all = new HashMap();
/*     */     
/* 276 */     String path = dir + "mzm.gsp.worldgoal.confbean.SWorldGoalCfg.bny";
/*     */     try
/*     */     {
/* 279 */       File file = new File(path);
/* 280 */       if (file.exists())
/*     */       {
/* 282 */         byte[] bytes = new byte['Ѐ'];
/* 283 */         FileInputStream fis = new FileInputStream(file);
/* 284 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 285 */         int len = 0;
/* 286 */         while ((len = fis.read(bytes)) > 0)
/* 287 */           baos.write(bytes, 0, len);
/* 288 */         fis.close();
/* 289 */         bytes = baos.toByteArray();
/* 290 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 291 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 293 */           _os_.unmarshal_int();
/* 294 */           _os_.unmarshal_int();
/* 295 */           _os_.unmarshal_int();
/*     */         }
/* 297 */         _os_.unmarshal_int();
/* 298 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 301 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 303 */           SWorldGoalCfg _v_ = new SWorldGoalCfg();
/* 304 */           _v_.unmarshal(_os_);
/* 305 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 306 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 311 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 316 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SWorldGoalCfg> all)
/*     */   {
/* 323 */     String path = dir + "mzm.gsp.worldgoal.confbean.SWorldGoalCfg.bny";
/*     */     try
/*     */     {
/* 326 */       File file = new File(path);
/* 327 */       if (file.exists())
/*     */       {
/* 329 */         byte[] bytes = new byte['Ѐ'];
/* 330 */         FileInputStream fis = new FileInputStream(file);
/* 331 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 332 */         int len = 0;
/* 333 */         while ((len = fis.read(bytes)) > 0)
/* 334 */           baos.write(bytes, 0, len);
/* 335 */         fis.close();
/* 336 */         bytes = baos.toByteArray();
/* 337 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 338 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 340 */           _os_.unmarshal_int();
/* 341 */           _os_.unmarshal_int();
/* 342 */           _os_.unmarshal_int();
/*     */         }
/* 344 */         _os_.unmarshal_int();
/* 345 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 348 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 350 */           SWorldGoalCfg _v_ = new SWorldGoalCfg();
/* 351 */           _v_.unmarshal(_os_);
/* 352 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 353 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 358 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 363 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SWorldGoalCfg getOld(int key)
/*     */   {
/* 371 */     return (SWorldGoalCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SWorldGoalCfg get(int key)
/*     */   {
/* 376 */     return (SWorldGoalCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SWorldGoalCfg> getOldAll()
/*     */   {
/* 381 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SWorldGoalCfg> getAll()
/*     */   {
/* 386 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SWorldGoalCfg> newAll)
/*     */   {
/* 391 */     oldAll = all;
/* 392 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 397 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\confbean\SWorldGoalCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */