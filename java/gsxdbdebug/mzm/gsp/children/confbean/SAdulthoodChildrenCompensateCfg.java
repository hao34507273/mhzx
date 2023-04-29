/*     */ package mzm.gsp.children.confbean;
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
/*     */ public class SAdulthoodChildrenCompensateCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SAdulthoodChildrenCompensateCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SAdulthoodChildrenCompensateCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int gender;
/*     */   public String name;
/*     */   public String another_give_birth_parent_role_id;
/*     */   public int character;
/*     */   public double grow;
/*     */   public int occupation;
/*     */   public int unlock_skill_pos_num;
/*  26 */   public ArrayList<OccupationSkillBean> occupation_skill_list = new ArrayList();
/*  27 */   public ArrayList<Integer> study_skill_list = new ArrayList();
/*  28 */   public ArrayList<Integer> amulet_skill_list = new ArrayList();
/*     */   public int special_skill;
/*     */   public int model_cfg_id;
/*  31 */   public ArrayList<EquipPosBean> equip_pos_list = new ArrayList();
/*     */   public int equip_pos_4_amulet_item_cfg_id;
/*     */   public int hp_apt;
/*     */   public int phyatk_apt;
/*     */   public int magatk_apt;
/*     */   public int phydef_apt;
/*     */   public int magdef_apt;
/*     */   public int speed_apt;
/*     */   public int str_point;
/*     */   public int dex_point;
/*     */   public int spr_point;
/*     */   public int con_point;
/*     */   public int sta_point;
/*     */   public int give_birth_time_point_cfg_id;
/*     */   public int step_in_childhood_time_point_cfg_id;
/*     */   public int step_in_adulthood_time_point_cfg_id;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  50 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  51 */     this.gender = Integer.valueOf(rootElement.attributeValue("gender")).intValue();
/*  52 */     this.name = rootElement.attributeValue("name");
/*  53 */     this.another_give_birth_parent_role_id = rootElement.attributeValue("another_give_birth_parent_role_id");
/*  54 */     this.character = Integer.valueOf(rootElement.attributeValue("character")).intValue();
/*  55 */     this.grow = Double.valueOf(rootElement.attributeValue("grow")).doubleValue();
/*  56 */     this.occupation = Integer.valueOf(rootElement.attributeValue("occupation")).intValue();
/*  57 */     this.unlock_skill_pos_num = Integer.valueOf(rootElement.attributeValue("unlock_skill_pos_num")).intValue();
/*     */     
/*  59 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "occupation_skill_list");
/*  60 */     if (collectionElement == null)
/*     */     {
/*  62 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  65 */     List<?> _nodeList = collectionElement.elements();
/*  66 */     int _len = _nodeList.size();
/*  67 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  69 */       Element elem = (Element)_nodeList.get(i);
/*  70 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.children.confbean.OccupationSkillBean"))
/*     */       {
/*     */         OccupationSkillBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  77 */           _v_ = new OccupationSkillBean();
/*  78 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  85 */         this.occupation_skill_list.add(_v_);
/*     */       }
/*     */     }
/*     */     
/*  89 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "study_skill_list");
/*  90 */     if (collectionElement == null)
/*     */     {
/*  92 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  95 */     List<?> _nodeList = collectionElement.elements();
/*  96 */     int _len = _nodeList.size();
/*  97 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  99 */       Element elem = (Element)_nodeList.get(i);
/* 100 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 107 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 114 */         this.study_skill_list.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 118 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "amulet_skill_list");
/* 119 */     if (collectionElement == null)
/*     */     {
/* 121 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 124 */     List<?> _nodeList = collectionElement.elements();
/* 125 */     int _len = _nodeList.size();
/* 126 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 128 */       Element elem = (Element)_nodeList.get(i);
/* 129 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 136 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 143 */         this.amulet_skill_list.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/* 146 */     this.special_skill = Integer.valueOf(rootElement.attributeValue("special_skill")).intValue();
/* 147 */     this.model_cfg_id = Integer.valueOf(rootElement.attributeValue("model_cfg_id")).intValue();
/*     */     
/* 149 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "equip_pos_list");
/* 150 */     if (collectionElement == null)
/*     */     {
/* 152 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 155 */     List<?> _nodeList = collectionElement.elements();
/* 156 */     int _len = _nodeList.size();
/* 157 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 159 */       Element elem = (Element)_nodeList.get(i);
/* 160 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.children.confbean.EquipPosBean"))
/*     */       {
/*     */         EquipPosBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 167 */           _v_ = new EquipPosBean();
/* 168 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 175 */         this.equip_pos_list.add(_v_);
/*     */       }
/*     */     }
/* 178 */     this.equip_pos_4_amulet_item_cfg_id = Integer.valueOf(rootElement.attributeValue("equip_pos_4_amulet_item_cfg_id")).intValue();
/* 179 */     this.hp_apt = Integer.valueOf(rootElement.attributeValue("hp_apt")).intValue();
/* 180 */     this.phyatk_apt = Integer.valueOf(rootElement.attributeValue("phyatk_apt")).intValue();
/* 181 */     this.magatk_apt = Integer.valueOf(rootElement.attributeValue("magatk_apt")).intValue();
/* 182 */     this.phydef_apt = Integer.valueOf(rootElement.attributeValue("phydef_apt")).intValue();
/* 183 */     this.magdef_apt = Integer.valueOf(rootElement.attributeValue("magdef_apt")).intValue();
/* 184 */     this.speed_apt = Integer.valueOf(rootElement.attributeValue("speed_apt")).intValue();
/* 185 */     this.str_point = Integer.valueOf(rootElement.attributeValue("str_point")).intValue();
/* 186 */     this.dex_point = Integer.valueOf(rootElement.attributeValue("dex_point")).intValue();
/* 187 */     this.spr_point = Integer.valueOf(rootElement.attributeValue("spr_point")).intValue();
/* 188 */     this.con_point = Integer.valueOf(rootElement.attributeValue("con_point")).intValue();
/* 189 */     this.sta_point = Integer.valueOf(rootElement.attributeValue("sta_point")).intValue();
/* 190 */     this.give_birth_time_point_cfg_id = Integer.valueOf(rootElement.attributeValue("give_birth_time_point_cfg_id")).intValue();
/* 191 */     this.step_in_childhood_time_point_cfg_id = Integer.valueOf(rootElement.attributeValue("step_in_childhood_time_point_cfg_id")).intValue();
/* 192 */     this.step_in_adulthood_time_point_cfg_id = Integer.valueOf(rootElement.attributeValue("step_in_adulthood_time_point_cfg_id")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 197 */     _os_.marshal(this.id);
/* 198 */     _os_.marshal(this.gender);
/* 199 */     _os_.marshal(this.name, "UTF-8");
/* 200 */     _os_.marshal(this.another_give_birth_parent_role_id, "UTF-8");
/* 201 */     _os_.marshal(this.character);
/* 202 */     _os_.marshal(this.grow);
/* 203 */     _os_.marshal(this.occupation);
/* 204 */     _os_.marshal(this.unlock_skill_pos_num);
/* 205 */     _os_.compact_uint32(this.occupation_skill_list.size());
/* 206 */     for (OccupationSkillBean _v_ : this.occupation_skill_list)
/*     */     {
/* 208 */       _os_.marshal(_v_);
/*     */     }
/* 210 */     _os_.compact_uint32(this.study_skill_list.size());
/* 211 */     for (Integer _v_ : this.study_skill_list)
/*     */     {
/* 213 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 215 */     _os_.compact_uint32(this.amulet_skill_list.size());
/* 216 */     for (Integer _v_ : this.amulet_skill_list)
/*     */     {
/* 218 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 220 */     _os_.marshal(this.special_skill);
/* 221 */     _os_.marshal(this.model_cfg_id);
/* 222 */     _os_.compact_uint32(this.equip_pos_list.size());
/* 223 */     for (EquipPosBean _v_ : this.equip_pos_list)
/*     */     {
/* 225 */       _os_.marshal(_v_);
/*     */     }
/* 227 */     _os_.marshal(this.equip_pos_4_amulet_item_cfg_id);
/* 228 */     _os_.marshal(this.hp_apt);
/* 229 */     _os_.marshal(this.phyatk_apt);
/* 230 */     _os_.marshal(this.magatk_apt);
/* 231 */     _os_.marshal(this.phydef_apt);
/* 232 */     _os_.marshal(this.magdef_apt);
/* 233 */     _os_.marshal(this.speed_apt);
/* 234 */     _os_.marshal(this.str_point);
/* 235 */     _os_.marshal(this.dex_point);
/* 236 */     _os_.marshal(this.spr_point);
/* 237 */     _os_.marshal(this.con_point);
/* 238 */     _os_.marshal(this.sta_point);
/* 239 */     _os_.marshal(this.give_birth_time_point_cfg_id);
/* 240 */     _os_.marshal(this.step_in_childhood_time_point_cfg_id);
/* 241 */     _os_.marshal(this.step_in_adulthood_time_point_cfg_id);
/* 242 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 247 */     this.id = _os_.unmarshal_int();
/* 248 */     this.gender = _os_.unmarshal_int();
/* 249 */     this.name = _os_.unmarshal_String("UTF-8");
/* 250 */     this.another_give_birth_parent_role_id = _os_.unmarshal_String("UTF-8");
/* 251 */     this.character = _os_.unmarshal_int();
/* 252 */     this.grow = _os_.unmarshal_float();
/* 253 */     this.occupation = _os_.unmarshal_int();
/* 254 */     this.unlock_skill_pos_num = _os_.unmarshal_int();
/* 255 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 258 */       OccupationSkillBean _v_ = new OccupationSkillBean();
/* 259 */       _v_.unmarshal(_os_);
/* 260 */       this.occupation_skill_list.add(_v_);
/*     */     }
/* 262 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 265 */       int _v_ = _os_.unmarshal_int();
/* 266 */       this.study_skill_list.add(Integer.valueOf(_v_));
/*     */     }
/* 268 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 271 */       int _v_ = _os_.unmarshal_int();
/* 272 */       this.amulet_skill_list.add(Integer.valueOf(_v_));
/*     */     }
/* 274 */     this.special_skill = _os_.unmarshal_int();
/* 275 */     this.model_cfg_id = _os_.unmarshal_int();
/* 276 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 279 */       EquipPosBean _v_ = new EquipPosBean();
/* 280 */       _v_.unmarshal(_os_);
/* 281 */       this.equip_pos_list.add(_v_);
/*     */     }
/* 283 */     this.equip_pos_4_amulet_item_cfg_id = _os_.unmarshal_int();
/* 284 */     this.hp_apt = _os_.unmarshal_int();
/* 285 */     this.phyatk_apt = _os_.unmarshal_int();
/* 286 */     this.magatk_apt = _os_.unmarshal_int();
/* 287 */     this.phydef_apt = _os_.unmarshal_int();
/* 288 */     this.magdef_apt = _os_.unmarshal_int();
/* 289 */     this.speed_apt = _os_.unmarshal_int();
/* 290 */     this.str_point = _os_.unmarshal_int();
/* 291 */     this.dex_point = _os_.unmarshal_int();
/* 292 */     this.spr_point = _os_.unmarshal_int();
/* 293 */     this.con_point = _os_.unmarshal_int();
/* 294 */     this.sta_point = _os_.unmarshal_int();
/* 295 */     this.give_birth_time_point_cfg_id = _os_.unmarshal_int();
/* 296 */     this.step_in_childhood_time_point_cfg_id = _os_.unmarshal_int();
/* 297 */     this.step_in_adulthood_time_point_cfg_id = _os_.unmarshal_int();
/* 298 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 303 */     String path = dir + "mzm.gsp.children.confbean.SAdulthoodChildrenCompensateCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 307 */       all = new java.util.HashMap();
/* 308 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 309 */       org.dom4j.Document doc = reader.read(new File(path));
/* 310 */       Element root = doc.getRootElement();
/* 311 */       List<?> nodeList = root.elements();
/* 312 */       int len = nodeList.size();
/* 313 */       for (int i = 0; i < len; i++)
/*     */       {
/* 315 */         Element elem = (Element)nodeList.get(i);
/* 316 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.children.confbean.SAdulthoodChildrenCompensateCfg"))
/*     */         {
/*     */ 
/* 319 */           SAdulthoodChildrenCompensateCfg obj = new SAdulthoodChildrenCompensateCfg();
/* 320 */           obj.loadFromXml(elem);
/* 321 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 322 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 327 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SAdulthoodChildrenCompensateCfg> all)
/*     */   {
/* 333 */     String path = dir + "mzm.gsp.children.confbean.SAdulthoodChildrenCompensateCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 337 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 338 */       org.dom4j.Document doc = reader.read(new File(path));
/* 339 */       Element root = doc.getRootElement();
/* 340 */       List<?> nodeList = root.elements();
/* 341 */       int len = nodeList.size();
/* 342 */       for (int i = 0; i < len; i++)
/*     */       {
/* 344 */         Element elem = (Element)nodeList.get(i);
/* 345 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.children.confbean.SAdulthoodChildrenCompensateCfg"))
/*     */         {
/*     */ 
/* 348 */           SAdulthoodChildrenCompensateCfg obj = new SAdulthoodChildrenCompensateCfg();
/* 349 */           obj.loadFromXml(elem);
/* 350 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 351 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 356 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 362 */     all = new java.util.HashMap();
/*     */     
/* 364 */     String path = dir + "mzm.gsp.children.confbean.SAdulthoodChildrenCompensateCfg.bny";
/*     */     try
/*     */     {
/* 367 */       File file = new File(path);
/* 368 */       if (file.exists())
/*     */       {
/* 370 */         byte[] bytes = new byte['Ѐ'];
/* 371 */         FileInputStream fis = new FileInputStream(file);
/* 372 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 373 */         int len = 0;
/* 374 */         while ((len = fis.read(bytes)) > 0)
/* 375 */           baos.write(bytes, 0, len);
/* 376 */         fis.close();
/* 377 */         bytes = baos.toByteArray();
/* 378 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 379 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 381 */           _os_.unmarshal_int();
/* 382 */           _os_.unmarshal_int();
/* 383 */           _os_.unmarshal_int();
/*     */         }
/* 385 */         _os_.unmarshal_int();
/* 386 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 389 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 391 */           SAdulthoodChildrenCompensateCfg _v_ = new SAdulthoodChildrenCompensateCfg();
/* 392 */           _v_.unmarshal(_os_);
/* 393 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 394 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 399 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 404 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SAdulthoodChildrenCompensateCfg> all)
/*     */   {
/* 411 */     String path = dir + "mzm.gsp.children.confbean.SAdulthoodChildrenCompensateCfg.bny";
/*     */     try
/*     */     {
/* 414 */       File file = new File(path);
/* 415 */       if (file.exists())
/*     */       {
/* 417 */         byte[] bytes = new byte['Ѐ'];
/* 418 */         FileInputStream fis = new FileInputStream(file);
/* 419 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 420 */         int len = 0;
/* 421 */         while ((len = fis.read(bytes)) > 0)
/* 422 */           baos.write(bytes, 0, len);
/* 423 */         fis.close();
/* 424 */         bytes = baos.toByteArray();
/* 425 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 426 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 428 */           _os_.unmarshal_int();
/* 429 */           _os_.unmarshal_int();
/* 430 */           _os_.unmarshal_int();
/*     */         }
/* 432 */         _os_.unmarshal_int();
/* 433 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 436 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 438 */           SAdulthoodChildrenCompensateCfg _v_ = new SAdulthoodChildrenCompensateCfg();
/* 439 */           _v_.unmarshal(_os_);
/* 440 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 441 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 446 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 451 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SAdulthoodChildrenCompensateCfg getOld(int key)
/*     */   {
/* 459 */     return (SAdulthoodChildrenCompensateCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SAdulthoodChildrenCompensateCfg get(int key)
/*     */   {
/* 464 */     return (SAdulthoodChildrenCompensateCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SAdulthoodChildrenCompensateCfg> getOldAll()
/*     */   {
/* 469 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SAdulthoodChildrenCompensateCfg> getAll()
/*     */   {
/* 474 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SAdulthoodChildrenCompensateCfg> newAll)
/*     */   {
/* 479 */     oldAll = all;
/* 480 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 485 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\confbean\SAdulthoodChildrenCompensateCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */