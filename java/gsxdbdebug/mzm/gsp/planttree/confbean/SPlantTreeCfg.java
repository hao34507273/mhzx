/*     */ package mzm.gsp.planttree.confbean;
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
/*     */ public class SPlantTreeCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SPlantTreeCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SPlantTreeCfg> all = null;
/*     */   
/*     */   public int activity_cfg_id;
/*     */   public int moduleid;
/*     */   public int activity_type;
/*     */   public int section_num;
/*     */   public int online_unit_interval;
/*     */   public int online_reward_max_point;
/*     */   public int activity_complete_award_id;
/*     */   public int add_point_max_times;
/*     */   public int special_state_refresh_interval;
/*     */   public int remove_special_state_award_max_times;
/*     */   public int remove_special_state_awardid;
/*     */   public int special_state_num;
/*  30 */   public HashMap<Integer, SSectionInfo> section_infos = new HashMap();
/*  31 */   public HashMap<Integer, SAddPointOperation> add_point_operations = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  35 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  36 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  37 */     this.activity_type = Integer.valueOf(rootElement.attributeValue("activity_type")).intValue();
/*  38 */     this.section_num = Integer.valueOf(rootElement.attributeValue("section_num")).intValue();
/*  39 */     this.online_unit_interval = Integer.valueOf(rootElement.attributeValue("online_unit_interval")).intValue();
/*  40 */     this.online_reward_max_point = Integer.valueOf(rootElement.attributeValue("online_reward_max_point")).intValue();
/*  41 */     this.activity_complete_award_id = Integer.valueOf(rootElement.attributeValue("activity_complete_award_id")).intValue();
/*  42 */     this.add_point_max_times = Integer.valueOf(rootElement.attributeValue("add_point_max_times")).intValue();
/*  43 */     this.special_state_refresh_interval = Integer.valueOf(rootElement.attributeValue("special_state_refresh_interval")).intValue();
/*  44 */     this.remove_special_state_award_max_times = Integer.valueOf(rootElement.attributeValue("remove_special_state_award_max_times")).intValue();
/*  45 */     this.remove_special_state_awardid = Integer.valueOf(rootElement.attributeValue("remove_special_state_awardid")).intValue();
/*  46 */     this.special_state_num = Integer.valueOf(rootElement.attributeValue("special_state_num")).intValue();
/*     */     
/*  48 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "section_infos");
/*  49 */     if (mapTypeElement == null)
/*     */     {
/*  51 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  54 */     List<?> entryNodeList = mapTypeElement.elements();
/*  55 */     int entryLen = entryNodeList.size();
/*  56 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  58 */       Element entryElement = (Element)entryNodeList.get(i);
/*  59 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  64 */         Element keyElem = null;
/*  65 */         Element valueElem = null;
/*     */         
/*  67 */         List<?> _nodeList = entryElement.elements();
/*  68 */         int _len = _nodeList.size();
/*  69 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  71 */           Element elem = (Element)_nodeList.get(j);
/*  72 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  74 */             keyElem = elem;
/*     */           }
/*  76 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.planttree.confbean.SSectionInfo")))
/*     */           {
/*  78 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  82 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  84 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         SSectionInfo _v_;
/*     */         try
/*     */         {
/*  91 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  92 */           _v_ = new SSectionInfo();
/*  93 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 100 */         this.section_infos.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */     
/* 104 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "add_point_operations");
/* 105 */     if (mapTypeElement == null)
/*     */     {
/* 107 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/* 110 */     List<?> entryNodeList = mapTypeElement.elements();
/* 111 */     int entryLen = entryNodeList.size();
/* 112 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/* 114 */       Element entryElement = (Element)entryNodeList.get(i);
/* 115 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 120 */         Element keyElem = null;
/* 121 */         Element valueElem = null;
/*     */         
/* 123 */         List<?> _nodeList = entryElement.elements();
/* 124 */         int _len = _nodeList.size();
/* 125 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 127 */           Element elem = (Element)_nodeList.get(j);
/* 128 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 130 */             keyElem = elem;
/*     */           }
/* 132 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.planttree.confbean.SAddPointOperation")))
/*     */           {
/* 134 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 138 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 140 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         SAddPointOperation _v_;
/*     */         try
/*     */         {
/* 147 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 148 */           _v_ = new SAddPointOperation();
/* 149 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 156 */         this.add_point_operations.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 163 */     _os_.marshal(this.activity_cfg_id);
/* 164 */     _os_.marshal(this.moduleid);
/* 165 */     _os_.marshal(this.activity_type);
/* 166 */     _os_.marshal(this.section_num);
/* 167 */     _os_.marshal(this.online_unit_interval);
/* 168 */     _os_.marshal(this.online_reward_max_point);
/* 169 */     _os_.marshal(this.activity_complete_award_id);
/* 170 */     _os_.marshal(this.add_point_max_times);
/* 171 */     _os_.marshal(this.special_state_refresh_interval);
/* 172 */     _os_.marshal(this.remove_special_state_award_max_times);
/* 173 */     _os_.marshal(this.remove_special_state_awardid);
/* 174 */     _os_.marshal(this.special_state_num);
/* 175 */     _os_.compact_uint32(this.section_infos.size());
/* 176 */     for (java.util.Map.Entry<Integer, SSectionInfo> _e_ : this.section_infos.entrySet())
/*     */     {
/* 178 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 179 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 181 */     _os_.compact_uint32(this.add_point_operations.size());
/* 182 */     for (java.util.Map.Entry<Integer, SAddPointOperation> _e_ : this.add_point_operations.entrySet())
/*     */     {
/* 184 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 185 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 187 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 192 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 193 */     this.moduleid = _os_.unmarshal_int();
/* 194 */     this.activity_type = _os_.unmarshal_int();
/* 195 */     this.section_num = _os_.unmarshal_int();
/* 196 */     this.online_unit_interval = _os_.unmarshal_int();
/* 197 */     this.online_reward_max_point = _os_.unmarshal_int();
/* 198 */     this.activity_complete_award_id = _os_.unmarshal_int();
/* 199 */     this.add_point_max_times = _os_.unmarshal_int();
/* 200 */     this.special_state_refresh_interval = _os_.unmarshal_int();
/* 201 */     this.remove_special_state_award_max_times = _os_.unmarshal_int();
/* 202 */     this.remove_special_state_awardid = _os_.unmarshal_int();
/* 203 */     this.special_state_num = _os_.unmarshal_int();
/* 204 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 207 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 209 */       SSectionInfo _v_ = new SSectionInfo();
/* 210 */       _v_.unmarshal(_os_);
/* 211 */       this.section_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 213 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 216 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 218 */       SAddPointOperation _v_ = new SAddPointOperation();
/* 219 */       _v_.unmarshal(_os_);
/* 220 */       this.add_point_operations.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 222 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 227 */     String path = dir + "mzm.gsp.planttree.confbean.SPlantTreeCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 231 */       all = new HashMap();
/* 232 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 233 */       org.dom4j.Document doc = reader.read(new File(path));
/* 234 */       Element root = doc.getRootElement();
/* 235 */       List<?> nodeList = root.elements();
/* 236 */       int len = nodeList.size();
/* 237 */       for (int i = 0; i < len; i++)
/*     */       {
/* 239 */         Element elem = (Element)nodeList.get(i);
/* 240 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.planttree.confbean.SPlantTreeCfg"))
/*     */         {
/*     */ 
/* 243 */           SPlantTreeCfg obj = new SPlantTreeCfg();
/* 244 */           obj.loadFromXml(elem);
/* 245 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 246 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 251 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SPlantTreeCfg> all)
/*     */   {
/* 257 */     String path = dir + "mzm.gsp.planttree.confbean.SPlantTreeCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 261 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 262 */       org.dom4j.Document doc = reader.read(new File(path));
/* 263 */       Element root = doc.getRootElement();
/* 264 */       List<?> nodeList = root.elements();
/* 265 */       int len = nodeList.size();
/* 266 */       for (int i = 0; i < len; i++)
/*     */       {
/* 268 */         Element elem = (Element)nodeList.get(i);
/* 269 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.planttree.confbean.SPlantTreeCfg"))
/*     */         {
/*     */ 
/* 272 */           SPlantTreeCfg obj = new SPlantTreeCfg();
/* 273 */           obj.loadFromXml(elem);
/* 274 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 275 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 280 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 286 */     all = new HashMap();
/*     */     
/* 288 */     String path = dir + "mzm.gsp.planttree.confbean.SPlantTreeCfg.bny";
/*     */     try
/*     */     {
/* 291 */       File file = new File(path);
/* 292 */       if (file.exists())
/*     */       {
/* 294 */         byte[] bytes = new byte['Ѐ'];
/* 295 */         FileInputStream fis = new FileInputStream(file);
/* 296 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 297 */         int len = 0;
/* 298 */         while ((len = fis.read(bytes)) > 0)
/* 299 */           baos.write(bytes, 0, len);
/* 300 */         fis.close();
/* 301 */         bytes = baos.toByteArray();
/* 302 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 303 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 305 */           _os_.unmarshal_int();
/* 306 */           _os_.unmarshal_int();
/* 307 */           _os_.unmarshal_int();
/*     */         }
/* 309 */         _os_.unmarshal_int();
/* 310 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 313 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 315 */           SPlantTreeCfg _v_ = new SPlantTreeCfg();
/* 316 */           _v_.unmarshal(_os_);
/* 317 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 318 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 323 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 328 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SPlantTreeCfg> all)
/*     */   {
/* 335 */     String path = dir + "mzm.gsp.planttree.confbean.SPlantTreeCfg.bny";
/*     */     try
/*     */     {
/* 338 */       File file = new File(path);
/* 339 */       if (file.exists())
/*     */       {
/* 341 */         byte[] bytes = new byte['Ѐ'];
/* 342 */         FileInputStream fis = new FileInputStream(file);
/* 343 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 344 */         int len = 0;
/* 345 */         while ((len = fis.read(bytes)) > 0)
/* 346 */           baos.write(bytes, 0, len);
/* 347 */         fis.close();
/* 348 */         bytes = baos.toByteArray();
/* 349 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 350 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 352 */           _os_.unmarshal_int();
/* 353 */           _os_.unmarshal_int();
/* 354 */           _os_.unmarshal_int();
/*     */         }
/* 356 */         _os_.unmarshal_int();
/* 357 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 360 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 362 */           SPlantTreeCfg _v_ = new SPlantTreeCfg();
/* 363 */           _v_.unmarshal(_os_);
/* 364 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 365 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 370 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 375 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SPlantTreeCfg getOld(int key)
/*     */   {
/* 383 */     return (SPlantTreeCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SPlantTreeCfg get(int key)
/*     */   {
/* 388 */     return (SPlantTreeCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPlantTreeCfg> getOldAll()
/*     */   {
/* 393 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPlantTreeCfg> getAll()
/*     */   {
/* 398 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SPlantTreeCfg> newAll)
/*     */   {
/* 403 */     oldAll = all;
/* 404 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 409 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\confbean\SPlantTreeCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */